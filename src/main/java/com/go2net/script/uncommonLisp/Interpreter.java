/*
 * Copyright (c) 1997 by Michael D. Bayne, All rights reserved.
 */

package com.go2net.script.uncommonLisp;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.logging.Level;

import vavi.util.Debug;


/**
 * Interpreter -
 */
public class Interpreter {

    Map env = new HashMap();

    public Object interpret(Object sexp) throws RunTimeException {
        // at this level we want to evaluate each sexp in a quoted list
        // intstead of simply returning the list like evaluateSExp would do
        if (sexp instanceof java.util.List) {

            java.util.List sexps = (java.util.List) sexp;
            Object result = null;

            for (Object s : sexps) {
                result = evaluateSExp(s);
            }

            return result;

        } else {
            return evaluateSExp(sexp);
        }
    }

    Object evaluateSExp(Object sexp) throws RunTimeException {
        // we have to check for instanceof List before instanceof List
        if ((sexp instanceof Integer) || (sexp instanceof String) || (sexp instanceof LispObject)) {
            return sexp;
        }

        if (sexp instanceof Name)
            return getValue(sexp.toString());

        if (sexp instanceof java.util.List)
            return evaluateCall((java.util.List) sexp);

        throw new RunTimeException("Unknown sexp type: " + sexp.getClass().getName(), sexp);
    }

    Object getValue(Object sexp) throws RunTimeException {
        Object val = env.get(sexp);
        if (val != null)
            return val;
        return new Nil();
    }

    Object evaluateCall(java.util.List sexp) throws RunTimeException {
        try {
            String nm = ((Name) sexp.get(0)).toString();
            Function fn = (Function) env.get(nm);

            if (fn == null) {
                try {
                    String fqcn = getClass().getPackage().getName() + ".B" + nm;
Debug.println(Level.FINER, fqcn);
                    Class bic = Class.forName(fqcn);
                    // create an instance of the builtin and insert it into
                    // the global environment
                    fn = (Function) bic.newInstance();
                    env.put(nm, fn);

                } catch (InstantiationException ie) {
                    throw new RunTimeException("Error instantiating " + "implementation class for " + "builtin function: " + nm,
                                               sexp);

                } catch (IllegalAccessException iae) {
                    throw new RunTimeException("Attempted use of class " + "that does not conform to " +
                                               "Function interface: " + nm,
                                               sexp);

                } catch (ClassNotFoundException cnfe) {
                    throw new RunTimeException("Reference to undefined " + "function: " + nm, sexp);
                }
            }

            java.util.List args = cdr(sexp);
            fn.verifyArguments(args);
            return fn.evaluate(this, args);

        } catch (NoSuchElementException nsee) {
            throw new RunTimeException("Evaluation of empty sexp.", sexp);

        } catch (ClassCastException cce) {
            throw new RunTimeException(cce.toString(), sexp);
        }
    }

    //
    // Interpreter public static member functions

    public static java.util.List cdr(java.util.List list) {
        return sublist(list, 1);
    }

    public static java.util.List ccdr(java.util.List list) {
        return sublist(list, 2);
    }

    public static java.util.List sublist(java.util.List list, int spos) {
        java.util.List nv = new java.util.ArrayList();
        for (int i = spos; i < list.size(); i++) {
            nv.add(list.get(i));
        }
        return nv;
    }

    public static void main(String[] args) {
        if (args.length != 1) {
Debug.println(Level.FINER, args.length);
            System.out.println("Usage: java Interpreter source_file");
            return;
        }

        try {
            Reader fin = new FileReader(args[0]);
            Parser parser = new Parser(fin);
            Object val = parser.parse();

Debug.println(Level.FINER, "Successfully parsed:");
Debug.println(Level.FINER, val);

            Interpreter interp = new Interpreter();
            Object ret = interp.interpret(val);
Debug.println(Level.FINE, ret);

        } catch (RunTimeException rte) {
            System.err.println(rte);
            System.err.println("SExp: " + rte.sexp);

        } catch (ParseException pe) {
            System.err.println(pe);
            System.err.println("  Line: " + pe.lineNumber() + " Token: " + pe.token());

        } catch (IOException e) {
            System.err.println("Error: " + e);
        }
    }
}
