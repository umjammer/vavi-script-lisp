/*
 * Copyright (c) 1997 by Naohide Sano, All rights reserved.
 *
 * Original by SunSoft Java Series CD-ROM "Java by Example"
 * Programmed by Naohide Sano
 */

package vavi.apps.lisp;


/**
 * �r���g�C���̃v���~�e�B�u�����݂��Ȃ��ꍇ�ɃX���[����܂��D
 * 
 * @author <a href="mailto:vavivavi@yahoo.co.jp">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class BuiltInNotFoundException extends LispException {

    /** �ڍ׃��b�Z�[�W�������Ȃ� BuiltInNotFoundException ���\�z���܂��D */
    public BuiltInNotFoundException() {
        super();
    }

    /** �ڍ׃��b�Z�[�W������ BuiltInNotFoundException ���\�z���܂��D */
    public BuiltInNotFoundException(String s) {
        super(s);
    }
}

/* */
