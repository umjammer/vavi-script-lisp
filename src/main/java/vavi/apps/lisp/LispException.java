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
 * ���̃p�b�P�[�W���̗�O�̊�{�N���X�ł��D
 * 
 * @author <a href="mailto:vavivavi@yahoo.co.jp">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public class LispException extends Exception {

    /** �ڍ׃��b�Z�[�W�������Ȃ� LispException ���\�z���܂��D */
    public LispException() {
        super();
    }

    /** �ڍ׃��b�Z�[�W������ LispException ���\�z���܂��D */
    public LispException(String s) {
        super(s);
    }
}

/* */
