/*
 * Copyright (c) 1997 by Michael D. Bayne, All rights reserved.
 */

package com.go2net.script.uncommonLisp.function;

import java.io.PrintStream;
import java.util.List;
import java.util.logging.Level;

import com.go2net.script.uncommonLisp.Function;
import com.go2net.script.uncommonLisp.Interpreter;
import com.go2net.script.uncommonLisp.LispList;
import com.go2net.script.uncommonLisp.Name;
import com.go2net.script.uncommonLisp.Nil;
import com.go2net.script.uncommonLisp.LispException;
import vavi.util.Debug;


/** Bprint - a builtin function to print out an sexp */
public class Bprint extends Function {

    // Bprint public member function

    public Object evaluate(Interpreter interp, List<?> sexp) throws LispException {
        for (Object o : sexp) {
            printValue(interp, o);
        }
        _out.flush();
        return new Nil();
    }

    // Bprint protected member function

    public void printValue(Interpreter interp, Object v) throws LispException {
Debug.println(Level.FINEST, "out: " + _out);
        if ((v instanceof String) || (v instanceof Integer)) {
            _out.print(v);

        } else if (v instanceof Nil) {
            _out.print("nil");

        } else if (v instanceof LispList) {
            evaluate(interp, (List<?>) v);

        } else if (v instanceof Name) {
            printValue(interp, interp.evaluateSExp(v));

        } else if (v instanceof List) {
            printValue(interp, interp.evaluateSExp(v));

        } else {
            throw new LispException("print: invalid type: " + v.getClass().getName(), v);
        }
    }

    // Bprint public static member function

    public static void setOutputStream(PrintStream out) {
        _out = out;
    }

    // Bprint protected static data members

    static PrintStream _out = System.out;
}
