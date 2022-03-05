/*
 * Copyright (c) 1997 by Michael D. Bayne, All rights reserved.
 */

package com.go2net.script.uncommonLisp;

public class RunTimeException extends Exception {

    Object sexp;

    RunTimeException(String msg, Object sexp) {
        super(msg);
        this.sexp = sexp;
    }

    RunTimeException(String msg, Object sexp, Throwable t) {
        super(msg, t);
        this.sexp = sexp;
    }
}
