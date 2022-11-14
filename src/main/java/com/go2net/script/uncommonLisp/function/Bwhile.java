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
public class Bwhile extends Function {

    // Bwhile public member function

    public Object evaluate(Interpreter interp, List<?> sexp) throws LispException {
        try {
            List<?> body = Interpreter.cdr(sexp);
            Integer cond = (Integer) interp.evaluateSExp(sexp.get(0));

            while (cond != 0) {
                interp.interpret(body);
                cond = (Integer) interp.evaluateSExp(sexp.get(0));
            }

            return new Nil();

        } catch (ClassCastException cce) {
            throw new LispException("Non-integer type used for " + "while expression.", sexp);
        }
    }

    public void verifyArguments(List<?> sexp) throws LispException {
        if (sexp.size() < 2)
            throw new LispException("Incorrect number of arguments " + "to while.", sexp);
    }
}
