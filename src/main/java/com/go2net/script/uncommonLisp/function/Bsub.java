/*
 * Copyright (c) 1997 by Michael D. Bayne, All rights reserved.
 */

package com.go2net.script.uncommonLisp.function;

import java.util.List;

import com.go2net.script.uncommonLisp.Function;
import com.go2net.script.uncommonLisp.Interpreter;
import com.go2net.script.uncommonLisp.LispException;


//
public class Bsub extends Function {

    // Bsub public member function

    public Object evaluate(Interpreter interp, List<?> sexp) throws LispException {
        try {
            Integer v = (Integer) interp.evaluateSExp(sexp.get(0));
            int result = v;

            for (int i = 1; i < sexp.size(); i++) {
                Integer ival = (Integer) interp.evaluateSExp(sexp.get(i));
                result -= ival;
            }

            return result;

        } catch (ClassCastException cce) {
            throw new LispException("Non-integer type used for " + "subtraction expression.", sexp);
        }
    }

    public void verifyArguments(List<?> sexp) throws LispException {
        if (sexp.size() < 2)
            throw new LispException("Incorrect number of arguments " + "to sub.", sexp);
    }
}
