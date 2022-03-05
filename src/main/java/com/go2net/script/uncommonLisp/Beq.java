/*
 * Copyright (c) 1997 by Michael D. Bayne, All rights reserved.
 */

package com.go2net.script.uncommonLisp;
//

// Beq - built in to perform equality comparison

import java.util.List;


public class Beq extends Function {
    //
    // Beq public member functions

    public Object evaluate(Interpreter interp, java.util.List sexp) throws RunTimeException {
        try {
            int val = ((Integer) interp.evaluateSExp(sexp.get(0))).intValue();

            for (int i = 1; i < sexp.size(); i++) {
                Integer ival = (Integer) interp.evaluateSExp(sexp.get(i));
                if (ival.intValue() != val)
                    return new Integer(0);
            }

            return new Integer(1);

        } catch (ClassCastException cce) {
            throw new RunTimeException("Non-integer type used for " + "equality expression.", sexp);
        }
    }

    public void verifyArguments(List sexp) throws RunTimeException {
        if (sexp.size() < 2)
            throw new RunTimeException("Incorrect number of arguments " + "to eq.", sexp);
    }
}
