/*
 * Copyright (c) 1997 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package vavi.apps.lisp;


/**
 * �����̐����Ⴄ�ꍇ�ɃX���[����܂��D
 * 
 * @author <a href="mailto:vavivavi@yahoo.co.jp">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class WrongArgumentCountException extends LispException {

    /** �ڍ׃��b�Z�[�W�������Ȃ� WrongArgumentCountException ���\�z���܂��D */
    public WrongArgumentCountException() {
        super();
    }

    /** �ڍ׃��b�Z�[�W������ WrongArgumentCountException ���\�z���܂��D */
    public WrongArgumentCountException(String s) {
        super(s);
    }
}

/* */
