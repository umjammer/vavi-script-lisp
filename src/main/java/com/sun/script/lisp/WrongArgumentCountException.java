/*
 * Copyright (c) 1996 by SunSoft, All rights reserved.
 *
 * Original by SunSoft Java Series CD-ROM "Java by Example"
 * Programmed by Jerry R. Jackson, Alan L. McClellan
 */

package com.sun.script.lisp;


/**
 * Thrown when the arguments count is wrong.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class WrongArgumentCountException extends LispException {

    /** Creates {@link WrongArgumentCountException} without message. */
    public WrongArgumentCountException() {
        super();
    }

    /** Constructs a new {@link WrongArgumentCountException} with the specified detail message. */
    public WrongArgumentCountException(String s) {
        super(s);
    }
}

/* */
