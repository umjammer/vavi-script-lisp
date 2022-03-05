/*
 * Copyright (c) 1996 by SunSoft, All rights reserved.
 *
 * Original by SunSoft Java Series CD-ROM "Java by Example"
 * Programmed by Jerry R. Jackson, Alan L. McClellan
 */

package com.sun.script.lisp;

import java.util.List;


/**
 * Represents a Lisp primitive.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public interface LispFunction {

    /**
     * Evaluate this primitive.
     *
     * @param args arguments list
     * @param interp the lisp interpreter
     * @throws LispException If a lisp error occurs
     */
    Object apply(List<Object> args, LispInterpreter interp) throws LispException;
}

/* */
