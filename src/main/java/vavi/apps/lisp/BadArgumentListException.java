/*
 * Copyright (c) 1997 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package vavi.apps.lisp;


/**
 * �����̃��X�g���������Ȃ��ꍇ�ɃX���[����܂��B
 * 
 * @author <a href="mailto:vavivavi@yahoo.co.jp">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class BadArgumentListException extends LispException {

    /** �ڍ׃��b�Z�[�W�������Ȃ� BadArgumentListException ���\�z���܂��B */
    public BadArgumentListException() {
        super();
    }

    /** �ڍ׃��b�Z�[�W������ BadArgumentListException ���\�z���܂��B */
    public BadArgumentListException(String s) {
        super(s);
    }
}

/* */
