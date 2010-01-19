/*
 * Copyright (c) 1999 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package vavi.apps.lisp;


/**
 * ����q�̗�O������O�N���X�ł��D
 * 
 * @author <a href="mailto:vavivavi@yahoo.co.jp">Naohide Sano</a> (nsano)
 * @version 0.00 991209 nsano make the initial version <br>
 */
public final class MetaException extends LispException {

    /** ���ۂ̗�O */
    private Throwable throwable;

    /**
     * �ڍ׃��b�Z�[�W�������Ȃ� MetaException ���\�z���܂��D
     */
    public MetaException(Throwable throwable) {
        this.throwable = throwable;
    }

    /**
     * �ڍ׃��b�Z�[�W������ MetaException ���\�z���܂��D
     */
    public Throwable getThrowable() {
        return throwable;
    }
}

/* */
