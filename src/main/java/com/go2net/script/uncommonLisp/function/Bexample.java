/*
 * Copyright (c) 1997 by Michael D. Bayne, All rights reserved.
 */

package com.go2net.script.uncommonLisp.function;

import java.util.List;

import com.go2net.script.uncommonLisp.Function;
import com.go2net.script.uncommonLisp.Interpreter;
import com.go2net.script.uncommonLisp.Nil;
import com.go2net.script.uncommonLisp.LispException;


//
public class Bexample extends Function {

    // Bexample public member function

    public Object evaluate(Interpreter interp, List<?> sexp) throws LispException {
        return new Nil();
    }

    public int numArguments() {
        return 0;
    }

    public void verifyArguments(List<?> sexp) throws LispException {
        super.verifyArguments(sexp);
    }
}
