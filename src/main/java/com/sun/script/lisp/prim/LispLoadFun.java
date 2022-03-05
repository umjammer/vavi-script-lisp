/*
 * Copyright (c) 1996 by SunSoft, All rights reserved.
 *
 * Original by SunSoft Java Series CD-ROM "Java by Example"
 * Programmed by Jerry R. Jackson, Alan L. McClellan
 */

package com.sun.script.lisp.prim;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import com.sun.script.lisp.BadArgumentTypeException;
import com.sun.script.lisp.BadEvalExpressionException;
import com.sun.script.lisp.BadLoadFileNameException;
import com.sun.script.lisp.IncompleteExpressionException;
import com.sun.script.lisp.InvalidLispExpressionException;
import com.sun.script.lisp.LispBoolean;
import com.sun.script.lisp.LispEnv;
import com.sun.script.lisp.LispEvaluator;
import com.sun.script.lisp.LispException;
import com.sun.script.lisp.LispInterpreter;
import com.sun.script.lisp.LispPrimitive;
import com.sun.script.lisp.LispReader;
import com.sun.script.lisp.LispSymbol;
import com.sun.script.lisp.WrongArgumentCountException;


/**
 * This class processes the primitive of <i>load</i>.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 *          1.00 980123 nsano change filename to InputStream <br>
 *          1.01 980130 nsano add the encoding to the reader <br>
 */
public final class LispLoadFun extends LispPrimitive {

    /**
     * Processes <i>load</i> expression.
     * <p>
     * <tt>
     * (load <i>InputStream</i>)
     * </tt>
     * <p>
     *
     * @param args arguments
     * @param interp the lisp interpreter
     * @throws BadArgumentTypeException If a bad argument exists
     * @throws WrongArgumentCountException If the argument count is wrong
     * @throws BadLoadFileNameException If the file name is wrong
     * @throws InvalidLispExpressionException If expression is invalid
     * @throws IncompleteExpressionException If expression doesn't completed
     * @throws BadEvalExpressionException If bad eval expression exist
     * @throws LispException If a lisp error occurs
     */
    public Object apply(List<Object> args, LispInterpreter interp)
        throws BadArgumentTypeException,
               WrongArgumentCountException,
               InvalidLispExpressionException,
               IncompleteExpressionException,
               BadEvalExpressionException,
               LispException {

        checkArgs("load", args, 1);

        Object arg1 = args.get(0);
        InputStream in = null;

        if (arg1 instanceof InputStream) {
            in = (InputStream) arg1;
        } else if (arg1 instanceof LispSymbol) {
            Object val = interp.getEnv().fetch((LispSymbol) arg1);
            if (val instanceof InputStream) {
                in = (InputStream) val;
            } else {
                throw new BadArgumentTypeException("Wrong argument type: " + arg1 + "; expected InputStream");
            }
        } else {
            throw new BadArgumentTypeException("Wrong argument type: " + arg1 + "; expected InputStream");
        }

        LispReader reader = null;
        try {
            reader = new LispReader(new InputStreamReader(in, interp.getEncoding()), interp.getSymbols());
        } catch (IOException e) {
System.err.println("LispLoadFun::apply: " + e);
            return LispBoolean.falseValue;
        }
        LispEvaluator evaluator = interp.getEvaluator();
        LispEnv env = interp.getEnv();

        try {
            while (in.available() > 0) {
                Object readResult = reader.skipRead();

                if (readResult != null) {
                    evaluator.eval(readResult, env, interp);
                }
            }
        } catch (IOException e) {
System.err.println("LispLoadFun::apply: " + e);
            return LispBoolean.falseValue;
        }

        try {
            in.close();
        } catch (IOException e) {
System.err.println("LispLoadFun::apply: " + e);
            return LispBoolean.falseValue;
        }

        return LispBoolean.trueValue;
    }
}

/* */
