/*
 * Copyright (c) 1997 by Michael D. Bayne, All rights reserved.
 */

package com.go2net.script.uncommonLisp;
//

public class Bdiv extends Function {
    //
    // Bdiv public member functions

    public Object evaluate(Interpreter interp, java.util.List sexp) throws RunTimeException {
        try {
            Integer l = (Integer) interp.evaluateSExp(sexp.get(0));
            Integer r = (Integer) interp.evaluateSExp(sexp.get(1));

            if (l.intValue() == 0)
                throw new RunTimeException("Division by zero.", sexp);

            return new Integer(r.intValue() / l.intValue());

        } catch (ClassCastException cce) {
            throw new RunTimeException("Non-integer type used for " + "subtraction expression.", sexp);
        }
    }

    public int numArguments() {
        return 2;
    }
}
