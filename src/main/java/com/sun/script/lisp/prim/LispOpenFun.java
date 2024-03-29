/*
 * Copyright (c) 1996 by SunSoft, All rights reserved.
 *
 * Original by SunSoft Java Series CD-ROM "Java by Example"
 * Programmed by Jerry R. Jackson, Alan L. McClellan
 */

package com.sun.script.lisp.prim;

import java.io.IOException;
import java.util.List;

import com.sun.script.lisp.BadArgumentTypeException;
import com.sun.script.lisp.BadFileIODirectionException;
import com.sun.script.lisp.BadFileNameException;
import com.sun.script.lisp.LispFileInputStream;
import com.sun.script.lisp.LispFileOutputStream;
import com.sun.script.lisp.LispInterpreter;
import com.sun.script.lisp.LispPrimitive;
import com.sun.script.lisp.LispSymbol;
import com.sun.script.lisp.WrongArgumentCountException;


/**
 * This class processes the primitive of <i>open</i>.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class LispOpenFun extends LispPrimitive {

    @Override
    public String toLispString() {
        return "open";
    }

    /**
     * Processes <i>open</i> expression.
     * <p>
     * <tt>
     * (open String:<i>fileName</i> LispSymbol:[output|input])
     * </tt>
     * <p>
     *
     * @param args arguments
     * @param interp the lisp interpreter
     * @return LispFileInputStream, LispFileOutputStream
     * @throws BadArgumentTypeException If bad argument type exists
     * @throws WrongArgumentCountException If argument count is wrong
     * @throws BadFileNameException If the file name is wrong
     * @throws BadFileIODirectionException If IO direction is wrong
     */
    public Object apply(List<Object> args, LispInterpreter interp) throws BadArgumentTypeException, WrongArgumentCountException, BadFileNameException, BadFileIODirectionException {

        checkArgs(toLispString(), args, 2);

        Object arg1 = args.get(0);
        Object arg2 = args.get(1);

        String fileName;

        if (arg1 instanceof String) {
            fileName = (String) arg1;
        } else if (arg1 instanceof LispSymbol) {
            fileName = ((LispSymbol) arg1).getName();
        } else {
            throw new BadArgumentTypeException("Wrong argument type for open: " + arg1 + "; expected String");
        }

        if (arg2 == LispSymbol.intern(interp.getSymbols(), "input")) {
            return openInputFile(fileName, interp);
        } else if (arg2 == LispSymbol.intern(interp.getSymbols(), "output")) {
            return openOutputFile(fileName);
        } else {
            throw new BadFileIODirectionException("open: direction must be either 'input' or 'output'");
        }
    }

    /**
     */
    private LispFileInputStream openInputFile(String fileName, LispInterpreter interp) throws BadFileNameException {

        LispFileInputStream s;

        try {
            s = new LispFileInputStream(fileName, interp);
        } catch (IOException e) {
            throw new BadFileNameException("Couldn't open file: " + fileName);
        }

        return s;
    }

    /** */
    private LispFileOutputStream openOutputFile(String fileName) throws BadFileNameException {

        LispFileOutputStream s;

        try {
            s = new LispFileOutputStream(fileName);
        } catch (IOException e) {
            throw new BadFileNameException("Couldn't open file: " + fileName);
        }

        return s;
    }
}

/* */
