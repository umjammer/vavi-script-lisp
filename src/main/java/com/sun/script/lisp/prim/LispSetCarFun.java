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
 * This class processes the primitive of <i>set-car!</i>.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class LispSetCarFun extends LispPrimitive {

    /**
     * Processes <i>set-car!</i> expression.
     * <p>
     * <tt>
     * (set-car! <i>target</i>)
     * </tt>
     * <p>
     *
     * @param args arguments
     * @throws WrongArgumentCountException If the argument count is wrong
     */
    public Object apply(List<Object> args) throws WrongArgumentCountException {

        checkArgs("set-car!", args, 2);

        ((LispCons) args.get(0)).setCar(args.get(1));
        return args.get(1);
    }
}

/* */
