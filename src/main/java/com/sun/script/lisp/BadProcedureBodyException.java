/*
 * Copyright (c) 1996 by SunSoft, All rights reserved.
 *
 * Original by SunSoft Java Series CD-ROM "Java by Example"
 * Programmed by Jerry R. Jackson, Alan L. McClellan
 */

package com.sun.script.lisp;


/**
 * Thrown when a body of procedure is wrong.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class BadProcedureBodyException extends LispException {

    /** Creates {@link BadProcedureBodyException} without message. */
    public BadProcedureBodyException() {
        super();
    }

    /** Constructs a new {@link BadProcedureBodyException} with the specified detail message. */
    public BadProcedureBodyException(String s) {
        super(s);
    }
}

/* */
