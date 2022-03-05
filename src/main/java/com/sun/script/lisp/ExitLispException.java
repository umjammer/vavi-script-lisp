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
 * Thrown when the exit primitive is processed.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class ExitLispException extends LispException {

    /** Creates {@link ExitLispException} without message. */
    public ExitLispException() {
        super();
    }

    /** Constructs a new {@link ExitLispException} with the specified detail message. */
    public ExitLispException(String s) {
        super(s);
    }
}

/* */
