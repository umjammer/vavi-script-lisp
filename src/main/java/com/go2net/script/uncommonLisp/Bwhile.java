/*
 * Copyright (c) 1997 by Michael D. Bayne, All rights reserved.
 */

package com.go2net.script.uncommonLisp;
//

public class Bwhile extends Function {
    //
    // Bwhile public member functions

    public Object evaluate(Interpreter interp, java.util.List sexp) throws RunTimeException {
        try {
            java.util.List body = Interpreter.cdr(sexp);
            Integer cond = (Integer) interp.evaluateSExp(sexp.get(0));

            while (cond.intValue() != 0) {
                interp.interpret(body);
                cond = (Integer) interp.evaluateSExp(sexp.get(0));
            }

            return new Nil();

        } catch (ClassCastException cce) {
            throw new RunTimeException("Non-integer type used for " + "while expression.", sexp);
        }
    }

    public void verifyArguments(java.util.List sexp) throws RunTimeException {
        if (sexp.size() < 2)
            throw new RunTimeException("Incorrect number of arguments " + "to while.", sexp);
    }
}
