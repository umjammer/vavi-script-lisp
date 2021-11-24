/*
 * Copyright (c) 1997 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package vavi.apps.lisp;


/**
 * Thrown if an exception cause at {@link ApplySpecialForm}.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class BadApplyArgumentsException extends LispException {

    /** Creates {@link BadApplyArgumentsException} w/o message. */
    public BadApplyArgumentsException() {
        super();
    }

    /** Constructs a new {@link BadApplyArgumentsException} with the specified detail message. */
    public BadApplyArgumentsException(String s) {
        super(s);
    }
}

/* */
