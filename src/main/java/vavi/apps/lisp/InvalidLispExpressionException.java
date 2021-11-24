/*
 * Lisp Interpreter, All rights reserved.
 *
 * Copyright (c) 1997 by Naohide Sano
 *
 * Original by SunSoft Java Series CD-ROM "Java by Example"
 * Programmed by Naohide Sano
 */

package vavi.apps.lisp;


/**
 * Thrown when a syntax error occurs.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class InvalidLispExpressionException extends LispException {

    /**
     * Creates {@link InvalidLispExpressionException} without message.
     */
    public InvalidLispExpressionException() {
        super();
    }

    /** Constructs a new {@link InvalidLispExpressionException} with the specified detail message. */
    public InvalidLispExpressionException(String s) {
        super(s);
    }
}

/* */
