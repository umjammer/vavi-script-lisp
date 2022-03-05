/*
 * Copyright (c) 1997 by Michael D. Bayne, All rights reserved.
 */

package com.go2net.script.uncommonLisp;
//

public class Blte extends Function {
    //
    // Blte public member functions

    public Object evaluate(Interpreter interp, java.util.List sexp) throws RunTimeException {
        try {
            Integer l = (Integer) interp.evaluateSExp(sexp.get(0));
            Integer r = (Integer) interp.evaluateSExp(sexp.get(1));

            return new Integer(l.intValue() <= r.intValue() ? 1 : 0);

        } catch (ClassCastException cce) {
            throw new RunTimeException("Non-integer type used for " + "comparison expression.", sexp);
        }
    }

    public int numArguments() {
        return 2;
    }
}
