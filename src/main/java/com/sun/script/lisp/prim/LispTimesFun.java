/*
 * Copyright (c) 1996 by SunSoft, All rights reserved.
 *
 * Original by SunSoft Java Series CD-ROM "Java by Example"
 * Programmed by Jerry R. Jackson, Alan L. McClellan
 */

package com.sun.script.lisp.prim;

import java.util.List;

import com.sun.script.lisp.BadNumericArgumentException;
import com.sun.script.lisp.LispPrimitive;


/**
 * This class processes the primitive of <i>*</i>.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class LispTimesFun extends LispPrimitive {

    @Override
    public String toLispString() {
        return "*";
    }

    /**
     * do multiplication.
     * <p>
     * <tt>
     * (* <i>number1</i> <i>number2</i> [<i>number3</i> ...])
     * </tt>
     * <p>
     *
     * @param args arguments
     * @return the value
     * @throws BadNumericArgumentException If bad argument are exist.
     */
    public Object apply(List<Object> args) throws BadNumericArgumentException {

        int result = 1;
        int index = 0;

        for (index = 0; index < args.size(); index++) {
            if (!(args.get(index) instanceof Integer)) {
                break;
            }

            result *= (Integer) args.get(index);

            if (result == 0) {
                return 0;
            }
        }

        if (index == args.size()) {
            return result;
        } else {
            double dresult = result;

            while (index < args.size()) {
                Object arg = args.get(index);

                if (!(arg instanceof Number)) {
                    throw new BadNumericArgumentException("Invalid numeric argument: " + arg);
                }

                dresult *= ((Number) arg).doubleValue();
                index++;
            }

            return dresult;
        }
    }
}

/* */
