/*
 * Copyright (c) 1996 by SunSoft, All rights reserved.
 *
 * Original by SunSoft Java Series CD-ROM "Java by Example"
 * Programmed by Jerry R. Jackson, Alan L. McClellan
 */

package com.sun.script.lisp;


/**
 * This class processes <i>quote</i>.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class QuoteSpecialForm extends LispSpecialForm {

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
