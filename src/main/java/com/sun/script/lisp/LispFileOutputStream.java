/*
 * Copyright (c) 1996 by SunSoft, All rights reserved.
 *
 * Original by SunSoft Java Series CD-ROM "Java by Example"
 * Programmed by Jerry R. Jackson, Alan L. McClellan
 */

package com.sun.script.lisp;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * The file output stream as lisp primitive.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class LispFileOutputStream extends PrintWriter implements LispPrintable {

    /**
     * Creates a file output stream.
     *
     * @param fileName the file name
     */
    public LispFileOutputStream(String fileName) throws IOException {
        super(new FileOutputStream(fileName));
    }

    /**
     * Returns a string representing this object.
     */
    public String toLispString() {
        return "{file output stream}";
    }
}

/* */
