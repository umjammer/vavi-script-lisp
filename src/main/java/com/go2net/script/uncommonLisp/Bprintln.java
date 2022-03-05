/*
 * Copyright (c) 1997 by Michael D. Bayne, All rights reserved.
 */

package com.go2net.script.uncommonLisp;
//

public class Bprintln extends Bprint {
    //
    // Bprintln public member functions

    public Object evaluate(Interpreter interp, java.util.List sexp) throws RunTimeException {
        Object v = super.evaluate(interp, sexp);
        _out.println("");
        return v;
    }
}
