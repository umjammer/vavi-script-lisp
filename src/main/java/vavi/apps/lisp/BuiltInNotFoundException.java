/*
 * Copyright (c) 1997 by Naohide Sano, All rights reserved.
 *
 * Original by SunSoft Java Series CD-ROM "Java by Example"
 * Programmed by Naohide Sano
 */

package vavi.apps.lisp;


/**
 * Thrown when a built in primitive does not exist.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class BuiltInNotFoundException extends LispException {

    /** Creates {@link BuiltInNotFoundException} without message. */
    public BuiltInNotFoundException() {
        super();
    }

    /** Constructs a new {@link BuiltInNotFoundException} with the specified detail message. */
    public BuiltInNotFoundException(String s) {
        super(s);
    }
}

/* */
