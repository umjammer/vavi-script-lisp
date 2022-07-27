/*
 * Copyright (c) 1996 by SunSoft, All rights reserved.
 *
 * Original by SunSoft Java Series CD-ROM "Java by Example"
 * Programmed by Jerry R. Jackson, Alan L. McClellan
 */

package com.sun.script.lisp.prim;

import java.util.List;

import com.sun.script.lisp.BadArgumentTypeException;
import com.sun.script.lisp.LispInterpreter;
import com.sun.script.lisp.LispPrimitive;
import com.sun.script.lisp.LispSymbol;
import com.sun.script.lisp.LispThrowException;
import com.sun.script.lisp.WrongArgumentCountException;


/**
 * This class processes the primitive of <i>throw</i>.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class LispThrowFun extends LispPrimitive {

    @Override
    public String toLispString() {
        return "throw";
    }

    /**
     * throws an exception.
     * <p>
     * <tt>
     * (throw <i>symbol</i>)
     * </tt>
     * <p>
     *
     * @param args arguments
     * @param interp the lisp interpreter
     * @throws BadArgumentTypeException If bad argument are exist
     * @throws WrongArgumentCountException If the argument count is wrong
     * @throws LispThrowException When processed correctly
     */
    public Object apply(List<Object> args, LispInterpreter interp) throws BadArgumentTypeException, WrongArgumentCountException, LispThrowException {

        checkArgs(toLispString(), args, 2);

        Object arg1 = args.get(0);
        Object value = args.get(1);

        LispSymbol tag;

        if (arg1 instanceof LispSymbol) {
            tag = (LispSymbol) arg1;
        } else {
            throw new BadArgumentTypeException("Wrong argument type for throw: " + arg1 + "; expected LispSymbol");
        }

        throw new LispThrowException(tag, value);
    }
}

/* */
