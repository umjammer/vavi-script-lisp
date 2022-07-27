/*
 * Copyright (c) 1996 by SunSoft, All rights reserved.
 *
 * Original by SunSoft Java Series CD-ROM "Java by Example"
 * Programmed by Jerry R. Jackson, Alan L. McClellan
 */

package com.sun.script.lisp.prim;

import java.util.ArrayList;
import java.util.List;

import com.sun.script.lisp.BadArgumentTypeException;
import com.sun.script.lisp.LispException;
import com.sun.script.lisp.LispFunction;
import com.sun.script.lisp.LispInterpreter;
import com.sun.script.lisp.LispPrimitive;
import com.sun.script.lisp.LispSymbol;
import com.sun.script.lisp.LispThrowException;
import com.sun.script.lisp.WrongArgumentCountException;


/**
 * This class processes the primitive of <i>catch</i>.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class LispCatchFun extends LispPrimitive {

    @Override
    public String toLispString() {
        return "catch";
    }

    /** The stack for exceptions */
    private static List<Object> vec = new ArrayList<>();

    /**
     * Processes <i>catch</i> expression.
     * <p>
     * <tt>
     * (catch <i>argment1</i> <i>argment2</i>)
     * </tt>
     * <p>
     *
     * @param args arguments
     * @throws BadArgumentTypeException If a bad type argument exists
     * @throws LispException If a lisp error occurs
     * @throws WrongArgumentCountException If the argument count is wrong
     */
    public Object apply(List<Object> args, LispInterpreter interp) throws BadArgumentTypeException, LispException, WrongArgumentCountException {

        checkArgs(toLispString(), args, 2);

        Object arg1 = args.get(0);
        Object arg2 = args.get(1);

        LispSymbol tag;
        LispFunction func;

        if (arg1 instanceof LispSymbol) {
            tag = (LispSymbol) arg1;
        } else {
            throw new BadArgumentTypeException("Wrong argument type for catch: " + arg1 + "; expected LispSymbol");
        }

        if (arg2 instanceof LispFunction) {
            func = (LispFunction) arg2;
        } else {
            throw new BadArgumentTypeException("Wrong argument type for catch: " + arg2 + "; expected LispFunction");
        }

        try {
            return func.apply(vec, interp);
        } catch (LispThrowException e) {
            if (e.getTag() == tag) {
                return e.getValue();
            } else {
                throw e;
            }
        }
    }
}

/* */
