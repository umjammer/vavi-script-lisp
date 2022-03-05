/*
 * Copyright (c) 1997 by Michael D. Bayne, All rights reserved.
 */

package com.go2net.script.uncommonLisp;
//

// Bprint - a builtin function to print out an sexp

import java.io.PrintStream;
import java.util.logging.Level;

import vavi.util.Debug;


public class Bprint extends Function {
    //
    // Bprint public member functions

    public Object evaluate(Interpreter interp, java.util.List sexp) throws RunTimeException {
        for (int i = 0; i < sexp.size(); i++) {
            printValue(interp, sexp.get(i));
        }
        _out.flush();
        return new Nil();
    }

    //
    // Bprint protected member functions

    public void printValue(Interpreter interp, Object v) throws RunTimeException {
Debug.println(Level.FINEST, "out: " + _out);
        if ((v instanceof String) || (v instanceof Integer)) {
            _out.print(v);

        } else if (v instanceof Nil) {
            _out.print("nil");

        } else if (v instanceof List) {
            evaluate(interp, (java.util.List) v);

        } else if (v instanceof Name) {
            printValue(interp, interp.evaluateSExp(v));

        } else if (v instanceof java.util.List) {
            printValue(interp, interp.evaluateSExp(v));

        } else {
            throw new RunTimeException("print: invalid type: " + v.getClass().getName(), v);
        }
    }

    //
    // Bprint public static member functions

    public static void setOutputStream(PrintStream out) {
        _out = out;
    }

    //
    // Bprint protected static data members

    static PrintStream _out = System.out;
}
