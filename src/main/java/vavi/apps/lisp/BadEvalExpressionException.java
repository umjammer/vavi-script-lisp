/*
 * Lisp Interpreter
 *
 * Copyright (c) 1997 by Naohide Sano, All rights reserved.
 *
 * Original by SunSoft Java Series CD-ROM "Java by Example"
 * Programmed by Naohide Sano
 */

package vavi.apps.lisp;


/**
 * �]������ S �����������Ȃ��ꍇ�ɃX���[����܂��D
 * 
 * @author <a href="mailto:vavivavi@yahoo.co.jp">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class BadEvalExpressionException extends LispException {

    /** �ڍ׃��b�Z�[�W�������Ȃ� BadEvalExpressionException ���\�z���܂��D */
    public BadEvalExpressionException() {
        super();
    }

    /** �ڍ׃��b�Z�[�W������ BadEvalExpressionException ���\�z���܂��D */
    public BadEvalExpressionException(String s) {
        super(s);
    }
}

/* */
