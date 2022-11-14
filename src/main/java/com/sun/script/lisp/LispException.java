/*
 * Lisp Interpreter
 *
 * Copyright (c) 1997 by Naohide Sano, All rights reserved.
 *
 * Original by SunSoft Java Series CD-ROM "Java by Example"
 * Programmed by Naohide Sano
 */

package com.sun.script.lisp;


/**
 * The base exception class for this package.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public class LispException extends Exception {

    /** Creates {@link LispException} without message. */
    public LispException() {
        super();
    }

    /** Constructs a new {@link LispException} with the specified detail message. */
    public LispException(String s) {
        super(s);
    }
}

/* */
