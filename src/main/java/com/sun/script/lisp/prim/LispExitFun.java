/*
 * Copyright (c) 1996 by SunSoft, All rights reserved.
 *
 * Original by SunSoft Java Series CD-ROM "Java by Example"
 * Programmed by Jerry R. Jackson, Alan L. McClellan
 */

package com.sun.script.lisp.prim;

import java.util.List;

import com.sun.script.lisp.ExitLispException;
import com.sun.script.lisp.LispPrimitive;
import com.sun.script.lisp.WrongArgumentCountException;


/**
 * This class processes the primitive of <i>exit</i>.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class LispExitFun extends LispPrimitive {

    @Override
    public String toLispString() {
        return "exit";
    }

    /**
     * Processes <i>exit</i> expression.
     * <p>
     * <tt>
     * (exit)
     * </tt>
     * <p>
     *
     * @param args arguments
     * @throws WrongArgumentCountException If the argument count is wrong
     * @throws ExitLispException exit code
     */
    public Object apply(List<Object> args) throws WrongArgumentCountException, ExitLispException {

        checkArgs(toLispString(), args, 0);
        throw new ExitLispException();
    }
}

/* */
