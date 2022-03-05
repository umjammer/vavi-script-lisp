/*
 * Copyright (c) 1997 by Michael D. Bayne, All rights reserved.
 */

package com.go2net.script.uncommonLisp;
//

public class Function implements LispObject {
    //
    // Function public member functions

    public Object evaluate(Interpreter interp, java.util.List sexp) throws RunTimeException {
        return null;
    }

    public int numArguments() {
        return -1;
    }

    public String name() {
        return getClass().getName().substring(1);
    }

    public void verifyArguments(java.util.List sexp) throws RunTimeException {
        if (numArguments() == -1)
            return;
        if (numArguments() != sexp.size())
            throw new RunTimeException("Illegal call to " + numArguments() + " arg function [" + name() + "] with " +
                                       sexp.size() + " args",
                                       sexp);
    }
}
