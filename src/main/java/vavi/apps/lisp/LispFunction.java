/*
 * Copyright (c) 1997 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package vavi.apps.lisp;

import java.util.List;


/**
 * Lisp �̃v���~�e�B�u�ł��邱�Ƃ������C���^�[�t�F�[�X�ł��D
 * 
 * @author <a href="mailto:vavivavi@yahoo.co.jp">Naohide Sano</a> (nsano)
 * @version 0.00 970730 nsano make the initial version <br>
 */
public interface LispFunction {

    /**
     * �v���~�e�B�u��]�����܂��D
     * 
     * @param args arguments list
     * @param interp the lisp interpreter
     * @throws LispException If a lisp error occurs
     */
    Object apply(List<Object> args, LispInterpreter interp) throws LispException;
}

/* */
