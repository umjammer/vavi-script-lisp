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
import com.sun.script.lisp.LispFileOutputStream;
import com.sun.script.lisp.LispInterpreter;
import com.sun.script.lisp.LispPrimitive;
import com.sun.script.lisp.LispPrinter;
import com.sun.script.lisp.WrongArgumentCountException;


/**
 * This class processes the primitive of <i>print</i>.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class LispPrintFun extends LispPrimitive {

    @Override
    public String toLispString() {
        return "print";
    }

    /**
     * Processes <i>print</i> expression.
     * <p>
     * <tt>
     * (print <i>target</i>) <br>
     * (print <i>target</i> LispFileOutputStream)
     * </tt>
     * <p>
     *
     * @param args arguments
     * @param interp the lisp interpreter
     * @return true: success
     * @throws WrongArgumentCountException If argument count is wrong
     * @throws BadArgumentTypeException If bad argument type exists
     */
    public Object apply(List<Object> args, LispInterpreter interp) throws BadArgumentTypeException, WrongArgumentCountException {

        int numArgs = args.size();

        if (numArgs > 2) {
            throw new WrongArgumentCountException("print expects no more than 2 arguments; got " + numArgs);
        }

        if (numArgs == 1) {
            LispPrinter.println(args.get(0));
        } else {
            Object toPrint = args.get(0);
            Object stream = args.get(1);

            if (stream instanceof LispFileOutputStream) {
                LispPrinter.println((LispFileOutputStream) stream, toPrint);
            } else {
                throw new BadArgumentTypeException("Wrong argument type for print: " + stream + "; expected LispFileOutputStream");
            }
        }

        return LispBoolean.trueValue;
    }
}

/* */
