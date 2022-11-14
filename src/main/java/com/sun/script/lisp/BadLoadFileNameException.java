/*
 * Copyright (c) 1996 by SunSoft, All rights reserved.
 *
 * Original by SunSoft Java Series CD-ROM "Java by Example"
 * Programmed by Jerry R. Jackson, Alan L. McClellan
 */

package com.sun.script.lisp;


/**
 * Thrown when a file to read is wrong.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class BadLoadFileNameException extends LispException {

    /** Creates {@link BadLoadFileNameException} without message. */
    public BadLoadFileNameException() {
        super();
    }

    /** Constructs a new {@link BadLoadFileNameException} with the specified detail message. */
    public BadLoadFileNameException(String s) {
        super(s);
    }
}

/* */
