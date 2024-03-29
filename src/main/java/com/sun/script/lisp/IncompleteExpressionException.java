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
 * When a S expression is ended correctly.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class IncompleteExpressionException extends LispException {

    /**
     * Creates {@link IncompleteExpressionException} without message.
     */
    public IncompleteExpressionException() {
        super();
    }

    /** Constructs a new {@link IncompleteExpressionException} with the specified detail message. */
    public IncompleteExpressionException(String s) {
        super(s);
    }
}

/* */
