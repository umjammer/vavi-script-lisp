/*
 * Copyright (c) 1997 by Naohide Sano, All rights reserved.
 *
 * Original by SunSoft Java Series CD-ROM "Java by Example"
 * Programmed by Naohide Sano
 */

package vavi.apps.lisp;


/**
 * Thrown when using unregistered symbol.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class UnboundSymbolException extends LispException {

    /** Creates {@link UnboundSymbolException} without message. */
    public UnboundSymbolException() {
        super();
    }

    /** Constructs a new {@link UnboundSymbolException} with the specified detail message. */
    public UnboundSymbolException(String s) {
        super(s);
    }
}

/* */
