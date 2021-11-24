/*
 * Copyright (c) 1997 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package vavi.apps.lisp;


/**
 * Thrown when processing {@link LispThrow} primitive.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class LispThrowException extends LispException {

    /**
     * Creates a LispThrowException object with symbol name and value.
     *
     * @param newTag the symbol name
     * @param newValue the value of the symbol
     */
    public LispThrowException(LispSymbol newTag, Object newValue) {
        this.tag = newTag;
        this.value = newValue;
    }

    /**
     * Gets the symbol.
     *
     * @return the symbol
     */
    public LispSymbol getTag() {
        return tag;
    }

    /**
     * Gets the value.
     *
     * @return the value of the symbol
     */
    public Object getValue() {
        return value;
    }

    /** the lisp symbol */
    private LispSymbol tag;

    /** the value of the symbol */
    private Object value;
}

/* */
