/*
 * Copyright (c) 1997 by Michael D. Bayne, All rights reserved.
 */

package com.go2net.script.uncommonLisp;
//

public class Bif extends Function {
    //
    // Bif public member functions

    public Object evaluate(Interpreter interp, java.util.List sexp) throws RunTimeException {
        try {
            Integer cond = (Integer) interp.evaluateSExp(sexp.get(0));

            if (cond.intValue() != 0) {
                return interp.evaluateSExp(sexp.get(1));

            } else if (sexp.size() == 3) {
                return interp.evaluateSExp(sexp.get(2));

            } else {
                return new Nil();
            }

        } catch (ClassCastException cce) {
            throw new RunTimeException("Non-integer type used for " + "conditional expression.", sexp);
        }
    }

    public void verifyArguments(java.util.List sexp) throws RunTimeException {
        if ((sexp.size() != 2) && (sexp.size() != 3))
            throw new RunTimeException("Incorrect number of arguments " + "to if.", sexp);
    }
}
