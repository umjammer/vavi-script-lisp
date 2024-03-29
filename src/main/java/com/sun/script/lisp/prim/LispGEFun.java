/*
 * Copyright (c) 1996 by SunSoft, All rights reserved.
 *
 * Original by SunSoft Java Series CD-ROM "Java by Example"
 * Programmed by Jerry R. Jackson, Alan L. McClellan
 */

package com.sun.script.lisp.prim;

import java.util.List;

import com.sun.script.lisp.BadArgumentListException;
import com.sun.script.lisp.LispBoolean;
import com.sun.script.lisp.LispPrimitive;
import com.sun.script.lisp.WrongArgumentCountException;


/**
 * This class processes the primitive of <i>&gt;=</i>.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class LispGEFun extends LispPrimitive {

    @Override
    public String toLispString() {
        return ">=";
    }

    /**
     * Processes <i>&gt;=</i> expression.
     * <p>
     * <tt>
     * (&gt;= <i>number1</i> <i>number2</i>)
     * </tt>
     * <p>
     *
     * @param args arguments
     * @throws WrongArgumentCountException If the argument count is wrong
     * @throws BadArgumentListException If a bad argument exists
     */
    public Object apply(List<Object> args) throws WrongArgumentCountException, BadArgumentListException {

        checkArgs(toLispString(), args, 2);

        Object arg1 = args.get(0);
        Object arg2 = args.get(1);

        if (arg1 instanceof Integer && arg2 instanceof Integer) {
            boolean result = ((Integer) arg1).intValue() >= ((Integer) arg2).intValue();
            return LispBoolean.select(result);
        } else if (arg1 instanceof Number && arg2 instanceof Number) {
            boolean result = ((Number) arg1).doubleValue() >= ((Number) arg2).doubleValue();
            return LispBoolean.select(result);
        } else {
            throw new BadArgumentListException("Both arguments to '>=' must be numbers: " + arg1 + ", " + arg2);
        }
    }
}

/* */
