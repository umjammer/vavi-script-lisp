/*
 * Copyright (c) 1997 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package vavi.apps.lisp;


/**
 * �����̌^������Ȃ��ꍇ�ɃX���[����܂��D
 * 
 * @author <a href="mailto:vavivavi@yahoo.co.jp">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */

public final class BadArgumentTypeException extends LispException {

    /** �ڍ׃��b�Z�[�W�������Ȃ� BadArgumentTypeException ���\�z���܂��D */
    public BadArgumentTypeException() {
        super();
    }

    /** �ڍ׃��b�Z�[�W������ BadArgumentTypeException ���\�z���܂��D */
    public BadArgumentTypeException(String s) {
        super(s);
    }
}

/* */
