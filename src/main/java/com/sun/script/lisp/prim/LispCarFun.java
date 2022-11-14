/*
 * Copyright (c) 1996 by SunSoft, All rights reserved.
 *
 * Original by SunSoft Java Series CD-ROM "Java by Example"
 * Programmed by Jerry R. Jackson, Alan L. McClellan
 */

package com.sun.script.lisp.prim;

import java.util.List;

import com.sun.script.lisp.LispCons;
import com.sun.script.lisp.LispPrimitive;
import com.sun.script.lisp.WrongArgumentCountException;


/**
 * This class processes the primitive of <i>car</i>.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class LispCarFun extends LispPrimitive {

    @Override
    public String toLispString() {
        return "car";
    }

    /**
     * Processes <i>car</i> expression.
     * <p>
     * <tt>
     * (car <i>argument</i>)
     * </tt>
     * <p>
     *
     * @param args arguments
     * @throws WrongArgumentCountException If the argument count is wrong
     */
    public Object apply(List<Object> args)
        throws WrongArgumentCountException {

        checkArgs(toLispString(), args, 1);
        return ((LispCons) args.get(0)).getCar();
    }
}

/* */
