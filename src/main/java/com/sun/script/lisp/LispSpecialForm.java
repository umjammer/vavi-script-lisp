/*
 * Copyright (c) 1996 by SunSoft, All rights reserved.
 *
 * Original by SunSoft Java Series CD-ROM "Java by Example"
 * Programmed by Jerry R. Jackson, Alan L. McClellan
 */

package com.sun.script.lisp;


/**
 * This class is the base class for a lisp special form.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public abstract class LispSpecialForm implements LispPrintable {

    /**
     * Evaluates an expression.
     *
     * @param exp the s expression
     * @param env environment
     * @param interp the lisp interpreter
     * @throws LispException If a lisp error occurs.
     */
    public abstract Object eval(LispCons exp, LispEnv env, LispInterpreter interp) throws LispException;

    /**
     * Returns a string representing this object.
     */
    public String toLispString() {
        return "{special form}";
    }
}

/* */
