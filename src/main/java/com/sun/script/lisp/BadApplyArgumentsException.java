/*
 * Copyright (c) 1996 by SunSoft, All rights reserved.
 *
 * Original by SunSoft Java Series CD-ROM "Java by Example"
 * Programmed by Jerry R. Jackson, Alan L. McClellan
 */

package com.sun.script.lisp;


import com.sun.script.lisp.specialform.ApplySpecialForm;


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
