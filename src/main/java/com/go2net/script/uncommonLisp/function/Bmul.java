/*
 * Copyright (c) 1997 by Michael D. Bayne, All rights reserved.
 */

package com.go2net.script.uncommonLisp.function;


import java.util.List;

import com.go2net.script.uncommonLisp.Function;
import com.go2net.script.uncommonLisp.Interpreter;
import com.go2net.script.uncommonLisp.LispList;
import com.go2net.script.uncommonLisp.LispException;


/** Bmul - built in to perform multiplication */
public class Bmul extends Function {

    // Bmul public member function

    public Object evaluate(Interpreter interp, List<?> sexp) throws LispException {
        try {
            int prod = 1;

            for (Object o : sexp) {
                Integer ival = (Integer) interp.evaluateSExp(o);
                prod *= ival;
            }

            return prod;

        } catch (ClassCastException cce) {
            throw new LispException("Non-integer type used for " + "multiplication expression.", sexp);
        }
    }

    public void verifyArguments(LispList sexp) throws LispException {
        if (sexp.size() < 2)
            throw new LispException("Incorrect number of arguments " + "to mul.", sexp);
    }
}
