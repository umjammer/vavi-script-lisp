/*
 * Copyright (c) 1996 by SunSoft, All rights reserved.
 *
 * Original by SunSoft Java Series CD-ROM "Java by Example"
 * Programmed by Jerry R. Jackson, Alan L. McClellan
 */

package com.sun.script.lisp.prim;

import java.util.List;

import com.sun.script.lisp.BadArgumentTypeException;
import com.sun.script.lisp.LispBoolean;
import com.sun.script.lisp.LispFileInputStream;
import com.sun.script.lisp.LispFileOutputStream;
import com.sun.script.lisp.LispInterpreter;
import com.sun.script.lisp.LispPrimitive;
import com.sun.script.lisp.WrongArgumentCountException;


/**
 * This class processes the primitive of <i>close</i>.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class LispCloseFun extends LispPrimitive {

    /**
     * Processes <i>close</i> expression.
     * <p>
     * <tt>
     * (close <i>stream</i>)
     * </tt>
     * <p>
     *
     * @param args arguments
     * @param interp the lisp interpreter
     * @throws BadArgumentTypeException If a bad type argument exists
     * @throws WrongArgumentCountException If the argument count is wrong
     */
    public Object apply(List<Object> args, LispInterpreter interp) throws BadArgumentTypeException, WrongArgumentCountException {

        checkArgs("close", args, 1);

        Object arg = args.get(0);

        if (arg instanceof LispFileInputStream) {
            try {
                ((LispFileInputStream) arg).close();
            } catch (Exception e) {
                return LispBoolean.falseValue;
            }
        } else if (arg instanceof LispFileOutputStream) {
            try {
                ((LispFileOutputStream) arg).close();
            } catch (Exception e) {
                return LispBoolean.falseValue;
            }
        } else {
            throw new BadArgumentTypeException("Wrong argument type for close: " + arg + "; expected LispStream");
        }

        return LispBoolean.trueValue;
    }
}

/* */
