/*
 * Copyright (c) 1996 by SunSoft, All rights reserved.
 *
 * Original by SunSoft Java Series CD-ROM "Java by Example"
 * Programmed by Jerry R. Jackson, Alan L. McClellan
 */

package com.sun.script.lisp.prim;

import java.util.List;

import com.sun.script.lisp.LispEnv;
import com.sun.script.lisp.LispEvaluator;
import com.sun.script.lisp.LispException;
import com.sun.script.lisp.LispInterpreter;
import com.sun.script.lisp.LispPrimitive;
import com.sun.script.lisp.WrongArgumentCountException;


/**
 * This class processes the primitive of <i>eval</i>.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class LispEvalFun extends LispPrimitive {

    /**
     * Processes <i>eval</i> expression.
     * <p>
     * <tt>
     * (eval argment1 argment2)
     * </tt>
     * <p>
     *
     * @param args arguments
     * @param interp the lisp interpreter
     * @throws WrongArgumentCountException If the argument count is wrong
     * @throws LispException If a lisp error occurs
     */
    public Object apply(List<Object> args, LispInterpreter interp) throws WrongArgumentCountException, LispException {

        checkArgs("eval", args, 2);

        LispEvaluator ev = interp.getEvaluator();

        return ev.eval(args.get(0), (LispEnv) args.get(1), interp);
    }
}

/* */
