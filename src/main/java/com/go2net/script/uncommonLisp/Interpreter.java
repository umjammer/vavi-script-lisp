/*
 * Copyright (c) 1997 by Michael D. Bayne, All rights reserved.
 */

package com.go2net.script.uncommonLisp;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.ServiceLoader;
import java.util.logging.Level;

import vavi.util.Debug;


/**
 * Interpreter -
 */
public class Interpreter {

    public Map<Object, Object> env = new HashMap<>();

    {
        ServiceLoader<Function> functions = ServiceLoader.load(Function.class);
        for (Function fn : functions) {
            String nm = fn.getClass().getSimpleName().replaceFirst("^B", "");
Debug.println(Level.FINER, "function: " + nm);
            env.put(nm, fn);
        }
    }

    public Object interpret(Object sexp) throws LispException {
        // at this level we want to evaluate each sexp in a quoted list
        // intstead of simply returning the list like evaluateSExp would do
        if (sexp instanceof List) {

            List<?> sexps = (List<?>) sexp;
            Object result = null;

            for (Object s : sexps) {
                result = evaluateSExp(s);
            }

            return result;

        } else {
            return evaluateSExp(sexp);
        }
    }

    public Object evaluateSExp(Object sexp) throws LispException {
        // we have to check for instanceof List before instanceof List
        if ((sexp instanceof Integer) || (sexp instanceof String) || (sexp instanceof LispObject)) {
            return sexp;
        }

        if (sexp instanceof Name)
            return getValue(sexp.toString());

        if (sexp instanceof List)
            return evaluateCall((List<?>) sexp);

        throw new LispException("Unknown sexp type: " + sexp.getClass().getName(), sexp);
    }

    Object getValue(Object sexp) throws LispException {
        Object val = env.get(sexp);
        if (val != null)
            return val;
        return new Nil();
    }

    Object evaluateCall(List<?> sexp) throws LispException {
        try {
            String nm = sexp.get(0).toString();
            Function fn = (Function) env.get(nm);

            List<?> args = cdr(sexp);
            fn.verifyArguments(args);
            return fn.evaluate(this, args);

        } catch (NoSuchElementException nsee) {
            throw new LispException("Evaluation of empty sexp.", sexp);

        } catch (ClassCastException cce) {
            throw new LispException(cce.toString(), sexp);
        }
    }

    // Interpreter public static member function

    public static List<?> cdr(List<?> list) {
        return sublist(list, 1);
    }

    public static List<?> ccdr(List<?> list) {
        return sublist(list, 2);
    }

    public static List<?> sublist(List<?> list, int spos) {
        List<Object> nv = new java.util.ArrayList<>();
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

        } catch (LispException rte) {
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
