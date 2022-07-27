/*
 * Copyright (c) 1996 by SunSoft, All rights reserved.
 *
 * Original by SunSoft Java Series CD-ROM "Java by Example"
 * Programmed by Jerry R. Jackson, Alan L. McClellan
 */

package com.sun.script.lisp.specialform;


import com.sun.script.lisp.BadLoopException;
import com.sun.script.lisp.LispBoolean;
import com.sun.script.lisp.LispCons;
import com.sun.script.lisp.LispEnv;
import com.sun.script.lisp.LispEvaluator;
import com.sun.script.lisp.LispException;
import com.sun.script.lisp.LispInterpreter;
import com.sun.script.lisp.LispSpecialForm;


/**
 * This class processes <i>while</i>.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class WhileLoopSpecialForm extends LispSpecialForm {

    @Override
    public String toLispString() {
        return "while";
    }

    /**
     * Evaluates "while" special form.
     * <p>
     * <tt>
     * (while ...)
     * </tt>
     * <p>
     *
     * @param exp S expression
     * @param env lisp environment
     * @param interp lisp interpreter
     * @return result of evaluation
     * @throws LispException If a lisp error occurs
     * @throws BadLoopException If a bad loop occurs
     */
    public Object eval(LispCons exp, LispEnv env, LispInterpreter interp) throws BadLoopException, LispException {

        LispEvaluator ev = interp.getEvaluator();

        if (exp.getCdr() == LispCons.emptyList || !(exp.getCdr() instanceof LispCons)) {

            throw new BadLoopException("Missing test for loop: " + exp.toLispString());
        }

        while ((ev.eval(exp.getCadr(), env, interp)) != LispBoolean.falseValue) {
            ev.evalSequence((LispCons) exp.getCddr(), env, interp);
        }

        return LispBoolean.trueValue;
    }
}

/* */
