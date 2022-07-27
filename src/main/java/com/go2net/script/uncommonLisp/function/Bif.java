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
public class Bif extends Function {

    // Bif public member function

    public Object evaluate(Interpreter interp, List<?> sexp) throws LispException {
        try {
            Integer cond = (Integer) interp.evaluateSExp(sexp.get(0));

            if (cond != 0) {
                return interp.evaluateSExp(sexp.get(1));

            } else if (sexp.size() == 3) {
                return interp.evaluateSExp(sexp.get(2));

            } else {
                return new Nil();
            }

        } catch (ClassCastException cce) {
            throw new LispException("Non-integer type used for " + "conditional expression.", sexp);
        }
    }

    public void verifyArguments(List<?> sexp) throws LispException {
        if ((sexp.size() != 2) && (sexp.size() != 3))
            throw new LispException("Incorrect number of arguments " + "to if.", sexp);
    }
}
