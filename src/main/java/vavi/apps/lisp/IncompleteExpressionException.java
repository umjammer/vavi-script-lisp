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
 * S �����������I�����Ă��Ȃ��ꍇ�ɃX���[����܂��D
 * 
 * @author <a href="mailto:vavivavi@yahoo.co.jp">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class IncompleteExpressionException extends LispException {

    /**
     * �ڍ׃��b�Z�[�W�������Ȃ� IncompleteExpressionException ���\�z���܂��D
     */
    public IncompleteExpressionException() {
        super();
    }

    /** �ڍ׃��b�Z�[�W������ IncompleteExpressionException ���\�z���܂��D */
    public IncompleteExpressionException(String s) {
        super(s);
    }
}

/* */
