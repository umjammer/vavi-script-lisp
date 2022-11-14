/*
 * Copyright (c) 1997 by Michael D. Bayne, All rights reserved.
 */

package com.go2net.script.uncommonLisp.function;

import java.util.List;

import com.go2net.script.uncommonLisp.Function;
import com.go2net.script.uncommonLisp.Interpreter;
import com.go2net.script.uncommonLisp.Name;
import com.go2net.script.uncommonLisp.Nil;
import com.go2net.script.uncommonLisp.LispException;
import com.go2net.script.uncommonLisp.UserFunction;


/**
 * Bdefun.
 *
 * @author Michael D. Bayne
 * @version March 19, 1997
 */
public class Bdefun extends Function {
    //
    // Bdefun public member function

    public Object evaluate(Interpreter interp, List<?> sexp) throws LispException {
        try {
            String name = sexp.get(0).toString();
            List<?> args = (List<?>) sexp.get(1);

            // first check the args for validity. should be a list of vars
            for (int i = 0; i < args.size(); i++) {
                if (!(args.get(i) instanceof Name)) {
                    throw new LispException("Argument #" + i + " of defun not valid.", args.get(i));
                }
            }

            // create a new user function with this stuff
            UserFunction fn = new UserFunction(name, args, Interpreter.ccdr(sexp));
            // System.out.println("Binding function: " + name);
            interp.env.put(name, fn);

            return new Nil();

        } catch (ClassCastException cce) {
            throw new LispException(cce.toString(), sexp);
        }
    }

    public void verifyArguments(List<?> sexp) throws LispException {
        switch (sexp.size()) {
        case 0:
            throw new LispException("Missing function name for defun.", sexp);

        case 1:
            throw new LispException("Missing argument list for defun.", sexp);

        case 2:
            throw new LispException("Missing function body for defun.", sexp);
        }
    }
}
