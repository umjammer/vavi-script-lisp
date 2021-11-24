/*
 * Copyright (c) 1997 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package vavi.apps.lisp;


/**
 * Thrown when a direction for file read/write is wrong.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class BadFileIODirectionException extends LispException {

    /** Creates {@link BadFileIODirectionException} without message. */
    public BadFileIODirectionException() {
        super();
    }

    /** Constructs a new {@link BadFileIODirectionException} with the specified detail message. */
    public BadFileIODirectionException(String s) {
        super(s);
    }
}

/* */
