/*
 * Copyright (c) 1997 by Michael D. Bayne, All rights reserved.
 */

package com.go2net.script.uncommonLisp;

import java.util.List;


//
public abstract class Function implements LispObject {

    // Function public member function

    public Object evaluate(Interpreter interp, List<?> sexp) throws LispException {
        return null;
    }

    public int numArguments() {
        return -1;
    }

    public String name() {
        return getClass().getName().substring(1);
    }

    public void verifyArguments(List<?> sexp) throws LispException {
        if (numArguments() == -1)
            return;
        if (numArguments() != sexp.size())
            throw new LispException("Illegal call to " + numArguments() + " arg function [" + name() + "] with " +
                                       sexp.size() + " args",
                                       sexp);
    }
}
