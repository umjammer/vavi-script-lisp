/*
 * Copyright (c) 1997 by Michael D. Bayne, All rights reserved.
 */

package com.go2net.script.uncommonLisp;
//

public class Bexample extends Function {
    //
    // Bexample public member functions

    public Object evaluate(Interpreter interp, java.util.List sexp) throws RunTimeException {
        return new Nil();
    }

    public int numArguments() {
        return 0;
    }

    public void verifyArguments(java.util.List sexp) throws RunTimeException {
        super.verifyArguments(sexp);
    }
}
