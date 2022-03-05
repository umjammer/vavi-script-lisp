/*
 * Copyright (c) 1996 by SunSoft, All rights reserved.
 *
 * Original by SunSoft Java Series CD-ROM "Java by Example"
 * Programmed by Jerry R. Jackson, Alan L. McClellan
 */

package com.sun.script.lisp;


/**
 * This class processes <i>set</i>.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class SetSpecialForm extends LispSpecialForm {

    /**
     * Evaluates "set" special form.
     *
     * @param exp the S expression
     * @param env the lisp environment
     * @param interp the lisp interpreter
     * @return the result of evaluation
     * @throws LispException If a lisp error occurs
     */
    public Object eval(LispCons exp, LispEnv env, LispInterpreter interp) throws LispException {

        LispEvaluator ev = interp.getEvaluator();
        Object toStore = ev.eval(exp.getCaddr(), env, interp);

        try {
            env.store((LispSymbol) exp.getCadr(), toStore);
        } catch (UnboundSymbolException e) {
            throw new UnboundSymbolException("Unbound symbol: " + exp.getCadr());
        }

        return exp.getCadr();
    }
}

/* */
