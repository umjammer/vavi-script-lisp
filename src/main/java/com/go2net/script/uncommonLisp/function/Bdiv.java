/*
 * Copyright (c) 1997 by Michael D. Bayne, All rights reserved.
 */

package com.go2net.script.uncommonLisp.function;

import java.util.List;

import com.go2net.script.uncommonLisp.Function;
import com.go2net.script.uncommonLisp.Interpreter;
import com.go2net.script.uncommonLisp.LispException;


//
public class Bdiv extends Function {

    // Bdiv public member function

    public Object evaluate(Interpreter interp, List<?> sexp) throws LispException {
        try {
            Integer l = (Integer) interp.evaluateSExp(sexp.get(0));
            Integer r = (Integer) interp.evaluateSExp(sexp.get(1));

            if (l == 0)
                throw new LispException("Division by zero.", sexp);

            return r / l;

        } catch (ClassCastException cce) {
            throw new LispException("Non-integer type used for " + "subtraction expression.", sexp);
        }
    }

    public int numArguments() {
        return 2;
    }
}
