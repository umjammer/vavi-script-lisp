/*
 * Copyright (c) 1997 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package vavi.apps.lisp;


/**
 * ApplySpecialForm �ŗ�O�����������ꍇ�ɃX���[����܂��B
 * 
 * @author <a href="mailto:vavivavi@yahoo.co.jp">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class BadApplyArgumentsException extends LispException {

    /** �ڍ׃��b�Z�[�W�������Ȃ� BadApplyArgumentsException ���\�z���܂��B */
    public BadApplyArgumentsException() {
        super();
    }

    /** �ڍ׃��b�Z�[�W������ BadApplyArgumentsException ���\�z���܂��B */
    public BadApplyArgumentsException(String s) {
        super(s);
    }
}

/* */
