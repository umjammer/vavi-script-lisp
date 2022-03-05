/*
 * Copyright (c) 1996 by SunSoft, All rights reserved.
 *
 * Original by SunSoft Java Series CD-ROM "Java by Example"
 * Programmed by Jerry R. Jackson, Alan L. McClellan
 */

package com.sun.script.lisp;


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
