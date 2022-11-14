/*
 * Copyright (c) 1997 by Michael D. Bayne, All rights reserved.
 */

package com.go2net.script.uncommonLisp.function;

import java.util.List;

import com.go2net.script.uncommonLisp.Interpreter;
import com.go2net.script.uncommonLisp.LispException;


//
public class Bprintln extends Bprint {

    // Bprintln public member function

    public Object evaluate(Interpreter interp, List<?> sexp) throws LispException {
        Object v = super.evaluate(interp, sexp);
        _out.println("");
        return v;
    }
}
