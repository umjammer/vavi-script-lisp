/*
 * Copyright (c) 1997 by Michael D. Bayne, All rights reserved.
 */


package com.go2net.script.uncommonLisp;

//
//Badd - built in to perform addition
public class Badd extends Function {

    public Object evaluate(Interpreter interp, java.util.List sexp) throws RunTimeException {
        try {
            int sum = 0;

            for (int i = 0; i < sexp.size(); i++) {
                Integer ival = (Integer) interp.evaluateSExp(sexp.get(i));
                sum += ival.intValue();
            }

            return new Integer(sum);

        } catch (ClassCastException cce) {
            throw new RunTimeException("Non-integer type used for " + "addition expression.", sexp);
        }
    }

    public void verifyArguments(java.util.List sexp) throws RunTimeException {
        if (sexp.size() < 2)
            throw new RunTimeException("Incorrect number of arguments " + "to add.", sexp);
    }
}
