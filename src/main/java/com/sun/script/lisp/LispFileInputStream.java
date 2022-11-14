/*
 * Copyright (c) 1996 by SunSoft, All rights reserved.
 *
 * Original by SunSoft Java Series CD-ROM "Java by Example"
 * Programmed by Jerry R. Jackson, Alan L. McClellan
 */

package com.sun.script.lisp;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * The file input stream as lisp primitive.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 *          0.01 980130 nsano add the encoding to the reader <br>
 */
public final class LispFileInputStream extends FileInputStream
    implements LispPrintable {

    /**
     * Creates file input stream.
     *
     * @param fileName the file name
     * @param interp the lisp interpreter
     */
    public LispFileInputStream(String fileName, LispInterpreter interp) throws IOException {

        super(fileName);
        reader = new LispReader(new InputStreamReader(this, interp.getEncoding()), interp.getSymbols());
    }

    /**
     * Returns a string representing this object.
     */
    public String toLispString() {
        return "{file input stream}";
    }

    /**
     * Gets the reader.
     */
    public LispReader getReader() {
        return reader;
    }

    /** The reader */
    private LispReader reader;
}

/* */
