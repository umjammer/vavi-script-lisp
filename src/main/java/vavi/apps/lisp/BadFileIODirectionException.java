/*
 * Copyright (c) 1997 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package vavi.apps.lisp;


/**
 * �t�@�C���̃��[�h���C�g�̕������������Ȃ��ꍇ�ɃX���[����܂��D
 * 
 * @author <a href="mailto:vavivavi@yahoo.co.jp">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public final class BadFileIODirectionException extends LispException {

    /** �ڍ׃��b�Z�[�W�������Ȃ� BadFileIODirectionException ���\�z���܂��D */
    public BadFileIODirectionException() {
        super();
    }

    /** �ڍ׃��b�Z�[�W������ BadFileIODirectionException ���\�z���܂��D */
    public BadFileIODirectionException(String s) {
        super(s);
    }
}

/* */
