/*
 * Copyright (c) 1997 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package vavi.apps.lisp;


/**
 * �����ɐ������Ȃ����l���������ꍇ�ɃX���[����܂��D
 * 
 * @author <a href="mailto:vavivavi@yahoo.co.jp">Naohide Sano</a> (nsano)
 * 
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class BadNumericArgumentException extends LispException {

    /** �ڍ׃��b�Z�[�W�������Ȃ� BadNumericArgumentException ���\�z���܂��D */
    public BadNumericArgumentException() {
        super();
    }

    /** �ڍ׃��b�Z�[�W������ BadNumericArgumentException ���\�z���܂��D */
    public BadNumericArgumentException(String s) {
        super(s);
    }
}

/* */
