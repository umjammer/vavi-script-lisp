/*
 * Copyright (c) 1996 by SunSoft, All rights reserved.
 *
 * Original by SunSoft Java Series CD-ROM "Java by Example"
 * Programmed by Jerry R. Jackson, Alan L. McClellan
 */

package com.sun.script.lisp;


/**
 * Thrown when a wrong loop occurs.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class BadLoopException extends LispException {

    /** Creates {@link BadLoopException} without message. */
    public BadLoopException() {
        super();
    }

    /** Constructs a new {@link BadLoopException} with the specified detail message. */
    public BadLoopException(String s) {
        super(s);
    }
}

/* */
