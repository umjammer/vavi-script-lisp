/*
 * Copyright (c) 1997 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package vavi.apps.lisp;


/**
 * �ǂ݂��ރt�@�C�������������Ȃ��ꍇ�ɃX���[����܂��D
 * 
 * @author <a href="mailto:vavivavi@yahoo.co.jp">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class BadLoadFileNameException extends LispException {

    /** �ڍ׃��b�Z�[�W�������Ȃ� BadLoadFileNameException ���\�z���܂��D */
    public BadLoadFileNameException() {
        super();
    }

    /** �ڍ׃��b�Z�[�W������ BadLoadFileNameException ���\�z���܂��D */
    public BadLoadFileNameException(String s) {
        super(s);
    }
}

/* */
