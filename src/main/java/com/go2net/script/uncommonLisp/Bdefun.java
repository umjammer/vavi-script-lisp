/*
 * Copyright (c) 1997 by Michael D. Bayne, All rights reserved.
 */

package com.go2net.script.uncommonLisp;

/**
 * Bdefun.
 *
 * @author Michael D. Bayne
 * @version March 19, 1997
 */
public class Bdefun extends Function {
    //
    // Bdefun public member functions

    public Object evaluate(Interpreter interp, java.util.List sexp) throws RunTimeException {
        try {
            String name = ((Name) sexp.get(0)).toString();
            java.util.List args = (java.util.List) sexp.get(1);

            // first check the args for validity. should be a list of vars
            for (int i = 0; i < args.size(); i++) {
                if (!(args.get(i) instanceof Name)) {
                    throw new RunTimeException("Argument #" + i + " of defun not valid.", args.get(i));
                }
            }

            // create a new user function with this stuff
            UserFunction fn = new UserFunction(name, args, Interpreter.ccdr(sexp));
            // System.out.println("Binding function: " + name);
            interp.env.put(name, fn);

            return new Nil();

        } catch (ClassCastException cce) {
            throw new RunTimeException(cce.toString(), sexp);
        }
    }

    public void verifyArguments(java.util.List sexp) throws RunTimeException {
        switch (sexp.size()) {
        case 0:
            throw new RunTimeException("Missing function name for defun.", sexp);

        case 1:
            throw new RunTimeException("Missing argument list for defun.", sexp);

        case 2:
            throw new RunTimeException("Missing function body for defun.", sexp);
        }
    }
}
