/*
 * Lisp Interpreter
 *
 * Copyright (c) 1997 by Naohide Sano, All rights reserved.
 *
 * Original by SunSoft Java Series CD-ROM "Java by Example"
 * Programmed by Naohide Sano
 */

package vavi.apps.lisp;


/**
 * Thrown when an evaluation of S expression.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class BadEvalExpressionException extends LispException {

    /** Creates {@link BadEvalExpressionException} without message. */
    public BadEvalExpressionException() {
        super();
    }

    /** Constructs a new {@link BadEvalExpressionException} with the specified detail message. */
    public BadEvalExpressionException(String s) {
        super(s);
    }
}

/* */
