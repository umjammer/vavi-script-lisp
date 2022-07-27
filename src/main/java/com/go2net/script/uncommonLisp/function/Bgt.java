/*
 * Copyright (c) 1997 by Michael D. Bayne, All rights reserved.
 */

package com.go2net.script.uncommonLisp.function;

import java.util.List;

import com.go2net.script.uncommonLisp.Function;
import com.go2net.script.uncommonLisp.Interpreter;
import com.go2net.script.uncommonLisp.LispException;


//
public class Bgt extends Function {

    // Bgt public member function

    public Object evaluate(Interpreter interp, List<?> sexp) throws LispException {
        try {
            Integer l = (Integer) interp.evaluateSExp(sexp.get(0));
            Integer r = (Integer) interp.evaluateSExp(sexp.get(1));

            return l > r ? 1 : 0;

        } catch (ClassCastException cce) {
            throw new LispException("Non-integer type used for " + "comparison expression.", sexp);
        }
    }

    public int numArguments() {
        return 2;
    }
}
