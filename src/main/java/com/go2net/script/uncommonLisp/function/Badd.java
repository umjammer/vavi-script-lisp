/*
 * Copyright (c) 1997 by Michael D. Bayne, All rights reserved.
 */

package com.go2net.script.uncommonLisp.function;

import java.util.List;

import com.go2net.script.uncommonLisp.Function;
import com.go2net.script.uncommonLisp.Interpreter;
import com.go2net.script.uncommonLisp.LispException;


/** Badd - built in to perform addition */
public class Badd extends Function {

    public Object evaluate(Interpreter interp, List<?> sexp) throws LispException {
        try {
            int sum = 0;

            for (Object o : sexp) {
                Integer ival = (Integer) interp.evaluateSExp(o);
                sum += ival;
            }

            return sum;

        } catch (ClassCastException cce) {
            throw new LispException("Non-integer type used for " + "addition expression.", sexp);
        }
    }

    public void verifyArguments(List<?> sexp) throws LispException {
        if (sexp.size() < 2)
            throw new LispException("Incorrect number of arguments " + "to add.", sexp);
    }
}
