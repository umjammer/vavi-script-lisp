/*
 * Copyright (c) 1997 by Michael D. Bayne, All rights reserved.
 */

package com.go2net.script.uncommonLisp.function;

import java.util.List;

import com.go2net.script.uncommonLisp.Function;
import com.go2net.script.uncommonLisp.Interpreter;
import com.go2net.script.uncommonLisp.Name;
import com.go2net.script.uncommonLisp.LispException;


//
public class Bsetq extends Function {

    // Bsetq public member function

    public Object evaluate(Interpreter interp, List<?> sexp) throws LispException {
        Object rhs = null;

        for (int i = 0; i < sexp.size(); i += 2) {
            try {
                String lhs = ((Name) sexp.get(i)).toString();
                Object orhs = interp.env.get(lhs);
                rhs = interp.evaluateSExp(sexp.get(i + 1));

                if ((orhs != null) && (orhs.getClass() != rhs.getClass())) {
                    throw new LispException("Type mismatch error.", sexp);
                }

                interp.env.put(lhs, rhs);

            } catch (ClassCastException cce) {
                throw new LispException(cce.toString(), sexp);
            }
        }

        return rhs;
    }

    public void verifyArguments(List<?> sexp) throws LispException {
        if (sexp.size() < 2)
            throw new LispException("Too few arguments to setq.", sexp);
        if (sexp.size() % 2 != 0)
            throw new LispException("setq requires variable " + "value pairs.", sexp);
    }
}
