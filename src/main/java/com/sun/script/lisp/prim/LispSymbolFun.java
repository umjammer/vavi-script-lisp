/*
 * Copyright (c) 1996 by SunSoft, All rights reserved.
 *
 * Original by SunSoft Java Series CD-ROM "Java by Example"
 * Programmed by Jerry R. Jackson, Alan L. McClellan
 */

package com.sun.script.lisp.prim;

import java.util.List;

import com.sun.script.lisp.LispBoolean;
import com.sun.script.lisp.LispPrimitive;
import com.sun.script.lisp.LispSymbol;
import com.sun.script.lisp.WrongArgumentCountException;


/**
 * This class processes the lisp primitive of <i>symbol?</i>. The function "symbol?" takes one argument, and returns true if the
 * argument is a lisp symbol or returns false.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class LispSymbolFun extends LispPrimitive {

    /**
     * シンボルかどうかを判別します．
     * <p>
     * <tt>
     * (symbol? <i>target</i>)
     * </tt>
     * <p>
     *
     * @param args arguments
     * @return true: the argument is a lisp symbol <br>
     *         false: the argument is not a lisp symbol
     * @throws WrongArgumentCountException If argument count is wrong
     */
    public Object apply(List<Object> args) throws WrongArgumentCountException {

        checkArgs("symbol?", args, 1);

        if (args.get(0) instanceof LispSymbol) {
            return LispBoolean.trueValue;
        } else {
            return LispBoolean.falseValue;
        }
    }
}

/* */
