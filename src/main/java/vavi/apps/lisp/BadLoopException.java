/*
 * Copyright (c) 1997 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package vavi.apps.lisp;


/**
 * �������Ȃ� loop �����������ꍇ�ɃX���[����܂��D
 * 
 * @author <a href="mailto:vavivavi@yahoo.co.jp">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class BadLoopException extends LispException {

    /** �ڍ׃��b�Z�[�W�������Ȃ� BadLoopException ���\�z���܂��D */
    public BadLoopException() {
        super();
    }

    /** �ڍ׃��b�Z�[�W������ BadLoopException ���\�z���܂��D */
    public BadLoopException(String s) {
        super(s);
    }
}

/* */
