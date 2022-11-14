/*
 * Copyright (c) 1999 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package com.sun.script.lisp;


/**
 * 入れ子の例外を持つ例外クラスです．
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 991209 nsano make the initial version <br>
 */
public final class MetaException extends LispException {

    /** 実際の例外 */
    private Throwable throwable;

    /**
     * Creates {@link MetaException} without message.
     */
    public MetaException(Throwable throwable) {
        this.throwable = throwable;
    }

    /**
     * Constructs a new {@link MetaException} with the specified detail message.
     */
    public Throwable getThrowable() {
        return throwable;
    }
}

/* */
