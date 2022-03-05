/*
 * Copyright (c) 1996 by SunSoft, All rights reserved.
 *
 * Original by SunSoft Java Series CD-ROM "Java by Example"
 * Programmed by Jerry R. Jackson, Alan L. McClellan
 */

package com.sun.script.lisp.prim;

import java.util.List;

import com.sun.script.lisp.LispBoolean;
import com.sun.script.lisp.LispCons;
import com.sun.script.lisp.LispPrimitive;
import com.sun.script.lisp.WrongArgumentCountException;


/**
 * This class processes the primitive of <i>pair?</i>.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class LispPairFun extends LispPrimitive {

    /**
     * Processes <i>pair?</i> expression.
     * <p>
     * <tt>
     * (pair? <i>target</i>)
     * </tt>
     * <p>
     *
     * @param args arguments
     * @throws WrongArgumentCountException If argument count is wrong
     */
    public Object apply(List<Object> args) throws WrongArgumentCountException {

        checkArgs("pair?", args, 1);

        if ((args.get(0) instanceof LispCons) && args.get(0) != LispCons.emptyList) {
            return LispBoolean.trueValue;
        } else {
            return LispBoolean.falseValue;
        }
    }
}

/* */
