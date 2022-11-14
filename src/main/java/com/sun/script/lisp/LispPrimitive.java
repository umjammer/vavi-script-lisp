/*
 * Copyright (c) 1996 by SunSoft, All rights reserved.
 *
 * Original by SunSoft Java Series CD-ROM "Java by Example"
 * Programmed by Jerry R. Jackson, Alan L. McClellan
 */

package com.sun.script.lisp;

import java.util.List;


/**
 * The base class for a primitive seen in the Lisp expression.
 * If you creates a primitive, extend this class.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 *
 * @version 0.00 970730 nsano make the initial version <br>
 */
public abstract class LispPrimitive implements LispFunction, LispPrintable {

    /**
     * Overrides this method for an user created primitive.
     *
     * @param args arguments list for an expression
     * @param interp Lisp instance of interpreter
     * @throws LispException If a lisp error occurs.
     */
    public Object apply(List<Object> args, LispInterpreter interp) throws LispException {
        return apply(args);
    }

    /**
     * Overrides this method for an user created primitive.
     *
     * @param args arguments list for an expression
     * @throws LispException If a lisp error occurs.
     */
    public Object apply(List<Object> args) throws LispException {
        return LispCons.emptyList;
    }

    /**
     * Returns a string represents this primitive as Lisp.
     */
    public String toLispString() {
        return "{primitive}";
    }

    /**
     * number of arguments of a expression.
     *
     * @param name name of a primitive
     * @param args arguments list for an expression
     * @param len count of arguments
     * @throws WrongArgumentCountException when arguments count is different.
     */
    public void checkArgs(String name, List<Object> args, int len) throws WrongArgumentCountException {

        if (args.size() != len) {
            throw new WrongArgumentCountException(name + ": " + "expected " + len + (len == 1 ? " arg; " : " args; ") + "got " + args.size() + ".");
        }
    }
}

/* */
