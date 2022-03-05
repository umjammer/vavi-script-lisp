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
 * This class processes the primitive of <i>cons</i>.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class LispConsFun extends LispPrimitive {

    /**
     * Processes <i>cons</i> expression.
     * <p>
     * <tt>
     * (cons <i>argment1</i> <i>argment2</i>)
     * </tt>
     * <p>
     *
     * @param args arguments
     * @throws WrongArgumentCountException If the argument count is wrong
     */
    public Object apply(List<Object> args) throws WrongArgumentCountException {

        checkArgs("cons", args, 2);

        return new LispCons(args.get(0), args.get(1));
    }
}

/* */
