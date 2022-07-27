/*
 * Copyright (c) 1997 by Michael D. Bayne, All rights reserved.
 */

package com.go2net.script.uncommonLisp.function;


import java.util.List;

import com.go2net.script.uncommonLisp.Function;
import com.go2net.script.uncommonLisp.Interpreter;
import com.go2net.script.uncommonLisp.LispList;
import com.go2net.script.uncommonLisp.LispException;


/** Beq - built in to perform equality comparison */
public class Beq extends Function {

    // Beq public member function

    public Object evaluate(Interpreter interp, List<?> sexp) throws LispException {
        try {
            int val = (Integer) interp.evaluateSExp(sexp.get(0));

            for (int i = 1; i < sexp.size(); i++) {
                Integer ival = (Integer) interp.evaluateSExp(sexp.get(i));
                if (ival != val)
                    return 0;
            }

            return 1;

        } catch (ClassCastException cce) {
            throw new LispException("Non-integer type used for " + "equality expression.", sexp);
        }
    }

    public void verifyArguments(LispList sexp) throws LispException {
        if (sexp.size() < 2)
            throw new LispException("Incorrect number of arguments " + "to eq.", sexp);
    }
}
