/*
 * Lisp Interpreter
 *
 * Copyright (c) 1997 by Naohide Sano, All rights reserved.
 *
 * Original by SunSoft Java Series CD-ROM "Java by Example"
 * Programmed by Naohide Sano
 */

package com.sun.script.lisp;


/**
 * The interface for printable lisp symbols.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
interface LispPrintable {

    /**
     * Gets a name representing lisp symbol.
     *
     * @return a lisp symbol name
     */
    String toLispString();
}

/* */
