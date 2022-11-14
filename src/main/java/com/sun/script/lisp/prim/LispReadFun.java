/*
 * Copyright (c) 1996 by SunSoft, All rights reserved.
 *
 * Original by SunSoft Java Series CD-ROM "Java by Example"
 * Programmed by Jerry R. Jackson, Alan L. McClellan
 */

package com.sun.script.lisp.prim;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.sun.script.lisp.BadArgumentTypeException;
import com.sun.script.lisp.ExitLispException;
import com.sun.script.lisp.IncompleteExpressionException;
import com.sun.script.lisp.InvalidLispExpressionException;
import com.sun.script.lisp.LispBoolean;
import com.sun.script.lisp.LispFileInputStream;
import com.sun.script.lisp.LispInterpreter;
import com.sun.script.lisp.LispPrimitive;
import com.sun.script.lisp.LispReader;
import com.sun.script.lisp.LispSymbol;
import com.sun.script.lisp.LispThrowException;
import com.sun.script.lisp.WrongArgumentCountException;


/**
 * This class processes the primitive of <i>read</i>.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class LispReadFun extends LispPrimitive {

    @Override
    public String toLispString() {
        return "read";
    }

    /**
     * Processes <i>read</i> expression.
     * <p>
     * <tt>
     * (read <i>target</i>)
     * </tt>
     * <p>
     *
     * @param args arguments
     * @param interp the lisp interpreter
     * @throws WrongArgumentCountException If argument count is wrong
     * @throws BadArgumentTypeException If bad argument type exist
     * @throws IncompleteExpressionException If reading is not completed
     * @throws InvalidLispExpressionException If bad expression encountered
     * @throws LispThrowException When exception be thrown
     * @throws ExitLispException When exit code read
     */
    public Object apply(List<Object> args, LispInterpreter interp) throws BadArgumentTypeException, WrongArgumentCountException, IncompleteExpressionException, InvalidLispExpressionException, LispThrowException, ExitLispException {

        int numArgs = args.size();

        if (numArgs > 1) {
            throw new WrongArgumentCountException("read expects no more than 1 argument; got " + numArgs);
        }

        Map<String, LispSymbol> table = interp.getSymbols();
        LispReader reader;

        if (numArgs == 0) {
            reader = interp.getReader();
        } else {
            Object arg = args.get(0);

            if (arg instanceof LispFileInputStream) {
                reader = ((LispFileInputStream) arg).getReader();
            } else {
                throw new BadArgumentTypeException("Wrong argument type for read: " + arg + "; expected LispFileInputStream");
            }
        }

        Object result = null;

        try {
            result = reader.skipRead();
        } catch (IOException e) {
        }

        if (result == null) {
            throw new LispThrowException(LispSymbol.intern(table, "eof"), LispBoolean.falseValue);
        } else {
            return result;
        }
    }
}

/* */
