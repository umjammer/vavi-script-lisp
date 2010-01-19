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
 * exit �v���~�e�B�u�����������ꍇ�ɃX���[����܂��D
 * 
 * @author <a href="mailto:vavivavi@yahoo.co.jp">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class ExitLispException extends LispException {

    /** �ڍ׃��b�Z�[�W�������Ȃ� ExitLispException ���\�z���܂��D */
    public ExitLispException() {
        super();
    }

    /** �ڍ׃��b�Z�[�W������ ExitLispException ���\�z���܂��D */
    public ExitLispException(String s) {
        super(s);
    }
}

/* */
