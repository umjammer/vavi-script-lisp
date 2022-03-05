/*
 * Copyright (c) 1996 by SunSoft, All rights reserved.
 *
 * Original by SunSoft Java Series CD-ROM "Java by Example"
 * Programmed by Jerry R. Jackson, Alan L. McClellan
 */

package com.sun.script.lisp;


/**
 * This class processes <i>while</i>.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class WhileLoopSpecialForm extends LispSpecialForm {

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
