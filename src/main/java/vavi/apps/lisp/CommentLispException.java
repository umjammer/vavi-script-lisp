/*
 * Lisp Interpreter
 *
 * Copyright (c) 1997 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package vavi.apps.lisp;


/**
 * �R�����g��ǂ񂾏ꍇ�ɃX���[����܂��D
 * 
 * @author <a href="mailto:vavivavi@yahoo.co.jp">Naohide Sano</a> (nsano)
 * @version 0.00 970806 nsano make the initial version <br>
 */
public final class CommentLispException extends LispException {

    /** �ڍ׃��b�Z�[�W�������Ȃ� CommentLispException ���\�z���܂��D */
    public CommentLispException() {
        super();
    }

    /** �ڍ׃��b�Z�[�W������ CommentLispException ���\�z���܂��D */
    public CommentLispException(String s) {
        super(s);
    }
}

/* */
