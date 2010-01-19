/*
 * Lisp Interpreter, All rights reserved.
 *
 * Copyright (c) 1997 by Naohide Sano
 *
 * Original by SunSoft Java Series CD-ROM "Java by Example"
 * Programmed by Naohide Sano
 */

package vavi.apps.lisp;


/**
 * �V���^�b�N�X�ɊԈႢ���������ꍇ�ɃX���[����܂��D
 * 
 * @author <a href="mailto:vavivavi@yahoo.co.jp">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class InvalidLispExpressionException extends LispException {

    /**
     * �ڍ׃��b�Z�[�W�������Ȃ� InvalidLispExpressionException ���\�z���܂��D
     */
    public InvalidLispExpressionException() {
        super();
    }

    /** �ڍ׃��b�Z�[�W������ InvalidLispExpressionException ���\�z���܂��D */
    public InvalidLispExpressionException(String s) {
        super(s);
    }
}

/* */
