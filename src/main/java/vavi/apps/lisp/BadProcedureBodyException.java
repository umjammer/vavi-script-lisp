/*
 * Copyright (c) 1997 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package vavi.apps.lisp;


/**
 * �v���V�[�W���̃{�f�B���������Ȃ��ꍇ�ɃX���[����܂��D
 * 
 * @author <a href="mailto:vavivavi@yahoo.co.jp">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class BadProcedureBodyException extends LispException {

    /** �ڍ׃��b�Z�[�W�������Ȃ� BadProcedureBodyException ���\�z���܂��D */
    public BadProcedureBodyException() {
        super();
    }

    /** �ڍ׃��b�Z�[�W������ BadProcedureBodyException ���\�z���܂��D */
    public BadProcedureBodyException(String s) {
        super(s);
    }
}

/* */
