/*
 * Copyright (c) 1996 by SunSoft, All rights reserved.
 *
 * Original by SunSoft Java Series CD-ROM "Java by Example"
 * Programmed by Jerry R. Jackson, Alan L. McClellan
 */

package com.sun.script.lisp.specialform;


import com.sun.script.lisp.LispCons;
import com.sun.script.lisp.LispEnv;
import com.sun.script.lisp.LispInterpreter;
import com.sun.script.lisp.LispSpecialForm;


/**
 * This class processes <i>quote</i>.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class QuoteSpecialForm extends LispSpecialForm {

    @Override
    public String toLispString() {
        return "quote";
    }

    /**
     * Evaluates quote special form.
     *
     * @param exp lisp expression
     * @param env lisp environment
     * @param interp the lisp interpreter
     */
    public Object eval(LispCons exp, LispEnv env, LispInterpreter interp) {
        return exp.getCadr();
    }
}

/* */
