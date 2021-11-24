/*
 * Copyright (c) 1997 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package vavi.apps.lisp;


/**
 * Thrown when an argument types is wrong.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */

public final class BadArgumentTypeException extends LispException {

    /** Creates {@link BadArgumentTypeException} without message. */
    public BadArgumentTypeException() {
        super();
    }

    /** Constructs a new {@link BadArgumentTypeException} with the specified detail message. */
    public BadArgumentTypeException(String s) {
        super(s);
    }
}

/* */
