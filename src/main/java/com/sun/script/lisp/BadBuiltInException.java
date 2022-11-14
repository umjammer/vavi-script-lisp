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
 * Thrown when a built in primitive is wrong.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class BadBuiltInException extends LispException {

    /** Creates {@link BadBuiltInException} without message. */
    public BadBuiltInException() {
        super();
    }

    /** Constructs a new {@link BadBuiltInException} with the specified detail message. */
    public BadBuiltInException(String s) {
        super(s);
    }
}

/* */
