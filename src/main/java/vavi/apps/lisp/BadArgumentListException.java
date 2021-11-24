/*
 * Copyright (c) 1997 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package vavi.apps.lisp;


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
