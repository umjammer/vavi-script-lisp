/*
 * Copyright (c) 1997 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package vavi.apps.lisp;


/**
 * Thrown when the file name is wrong.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class BadFileNameException extends LispException {

    /** Creates {@link BadFileNameException} without message. */
    public BadFileNameException() {
        super();
    }

    /** Constructs a new {@link BadFileNameException} with the specified detail message. */
    public BadFileNameException(String s) {
        super(s);
    }
}

/* */
