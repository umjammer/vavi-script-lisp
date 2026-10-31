/*
 * Copyright (c) 2026 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package com.sun.script.lisp.prim;

import java.util.List;

import com.sun.script.lisp.BadArgumentTypeException;
import com.sun.script.lisp.BadNumericArgumentException;
import com.sun.script.lisp.LispPrimitive;
import com.sun.script.lisp.WrongArgumentCountException;


/**
 * This class processes the primitive of <i>#</i>.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 260902 nsano make the initial version <br>
 */
public final class LispCommentFun extends LispPrimitive {

    @Override
    public String toLispString() {
        return "#";
    }

    /**
     * Do the comment.
     * <p>
     * <tt>
     * (# <i>string</i>)
     * </tt>
     * <p>
     *
     * @param args arguments
     * @throws BadArgumentTypeException If not string argument exists
     */
    public Object apply(List<Object> args) throws WrongArgumentCountException, BadArgumentTypeException {

        if (args.size() != 1) {
            throw new WrongArgumentCountException();
        }

        if (!(args.get(0) instanceof String)) {
            throw new BadArgumentTypeException("Invalid string argument: " + args.get(0));
        }

        return args.get(0);
    }
}
