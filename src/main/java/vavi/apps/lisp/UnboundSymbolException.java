/*
 * Copyright (c) 1997 by Naohide Sano, All rights reserved.
 *
 * Original by SunSoft Java Series CD-ROM "Java by Example"
 * Programmed by Naohide Sano
 */

package vavi.apps.lisp;


/**
 * �o�^����Ă��Ȃ��V���{�����g�p�����ꍇ�ɃX���[����܂��D
 * 
 * @author <a href="mailto:vavivavi@yahoo.co.jp">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class UnboundSymbolException extends LispException {

    /** �ڍ׃��b�Z�[�W�������Ȃ� UnboundSymbolException ���\�z���܂��D */
    public UnboundSymbolException() {
        super();
    }

    /** �ڍ׃��b�Z�[�W������ UnboundSymbolException ���\�z���܂��D */
    public UnboundSymbolException(String s) {
        super(s);
    }
}

/* */
