/*
 * Copyright (c) 1996 by SunSoft, All rights reserved.
 *
 * Original by SunSoft Java Series CD-ROM "Java by Example"
 * Programmed by Jerry R. Jackson, Alan L. McClellan
 */

package com.sun.script.lisp;


/**
 * Thrown when argument list is wrong.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class BadArgumentListException extends LispException {

    /** 詳細メッセージを持たない BadArgumentListException を構築します。 */
    public BadArgumentListException() {
        super();
    }

    /** Constructs a new {@link BadArgumentListException} with the specified detail message. */
    public BadArgumentListException(String s) {
        super(s);
    }
}

/* */
