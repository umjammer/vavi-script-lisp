/*
 * Lisp Interpreter
 *
 * Copyright (c) 1997 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package vavi.apps.lisp;


/**
 * Thrown when a comment is read.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 970806 nsano make the initial version <br>
 */
public final class CommentLispException extends LispException {

    /** Creates {@link CommentLispException} without message. */
    public CommentLispException() {
        super();
    }

    /** Constructs a new {@link CommentLispException} with the specified detail message. */
    public CommentLispException(String s) {
        super(s);
    }
}

/* */
