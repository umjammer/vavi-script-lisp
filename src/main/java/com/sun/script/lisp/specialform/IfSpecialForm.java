/*
 * Copyright (c) 1996 by SunSoft, All rights reserved.
 *
 * Original by SunSoft Java Series CD-ROM "Java by Example"
 * Programmed by Jerry R. Jackson, Alan L. McClellan
 */

package com.sun.script.lisp.specialform;


import com.sun.script.lisp.LispBoolean;
import com.sun.script.lisp.LispCons;
import com.sun.script.lisp.LispEnv;
import com.sun.script.lisp.LispEvaluator;
import com.sun.script.lisp.LispException;
import com.sun.script.lisp.LispInterpreter;
import com.sun.script.lisp.LispSpecialForm;


/**
 * This class processes <i>if</i>.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 *
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class IfSpecialForm extends LispSpecialForm {

    @Override
    public String toLispString() {
        return "if";
    }

    /**
     * Evaluates "if" special form.
     *
     * @param exp S expression
     * @param env lisp environment
     * @param interp the lisp interpreter
     * @return result of evaluation
     * @throws LispException If a lisp error occurs
     */
    public Object eval(LispCons exp, LispEnv env, LispInterpreter interp) throws LispException {

        LispEvaluator ev = interp.getEvaluator();
        Object test = exp.getCadr();
        LispCons tail = (LispCons) exp.getCddr();

        if (ev.eval(test, env, interp) != LispBoolean.falseValue) {
            return ev.eval(tail.getCar(), env, interp);
        } else if (tail.getCdr() != LispCons.emptyList) {
            return ev.eval(tail.getCadr(), env, interp);
        } else {
            return LispBoolean.falseValue;
        }
    }
}

/* */
