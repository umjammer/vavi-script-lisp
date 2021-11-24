/*
 * Copyright (c) 1997 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package vavi.apps.lisp;


/**
 * Thrown when a wrong numeric argument is found in arguments.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 *
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class BadNumericArgumentException extends LispException {

    /** Creates {@link BadNumericArgumentException} without message. */
    public BadNumericArgumentException() {
        super();
    }

    /** Constructs a new {@link BadNumericArgumentException} with the specified detail message. */
    public BadNumericArgumentException(String s) {
        super(s);
    }
}

/* */
