/*
 * Copyright (c) 1997 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package vavi.apps.lisp;


/**
 * �t�@�C�������������Ȃ��ꍇ�ɃX���[����܂��D
 * 
 * @author <a href="mailto:vavivavi@yahoo.co.jp">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class BadFileNameException extends LispException {

    /** �ڍ׃��b�Z�[�W�������Ȃ� BadFileNameException ���\�z���܂��D */
    public BadFileNameException() {
        super();
    }

    /** �ڍ׃��b�Z�[�W������ BadFileNameException ���\�z���܂��D */
    public BadFileNameException(String s) {
        super(s);
    }
}

/* */
