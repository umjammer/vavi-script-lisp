/*
 * Copyright (c) 1997 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package vavi.apps.lisp;

import java.util.List;


/**
 * Lisp �̎��Ɍ����v���~�e�B�u�̊�{�N���X�ł��B
 * ���[�U���v���~�e�B�u���쐬����ꍇ�͂��̃N���X���g�����Ďg�p���܂��B
 * 
 * @author <a href="mailto:vavivavi@yahoo.co.jp">Naohide Sano</a> (nsano)
 * 
 * @version 0.00 970730 nsano make the initial version <br>
 */
public class LispPrimitive implements LispFunction, LispPrintable {

    /**
     * ���[�U���쐬����v���~�e�B�u�͂��̃��\�b�h���I�[�o�[���C�h���Ă��������B
     * 
     * @param args ���̈����̃��X�g�D
     * @param interp Lisp �C���^�[�v���^�̃C���X�^���X�D
     * @throws LispException If a lisp error occurs.
     */
    public Object apply(List<Object> args, LispInterpreter interp) throws LispException {
        return apply(args);
    }

    /**
     * ���[�U���쐬����v���~�e�B�u�͂��̃��\�b�h���I�[�o�[���C�h���Ă��������B
     * 
     * @param args ���̈����̃��X�g�D
     * @throws LispException If a lisp error occurs.
     */
    public Object apply(List<Object> args) throws LispException {
        return LispCons.emptyList;
    }

    /**
     * ���̃v���~�e�B�u��\�� Lisp �Ƃ��Ă̕������Ԃ��܂��B
     */
    public String toLispString() {
        return "{primitive}";
    }

    /**
     * ���̈����̐��𒲂ׂ܂��D
     * 
     * @param name �v���~�e�B�u�̖��O
     * @param args �����̃��X�g
     * @param len �����̐�
     * @throws WrongArgumentCountException �����̐����Ⴄ�ꍇ
     */
    public void checkArgs(String name, List<Object> args, int len) throws WrongArgumentCountException {

        if (args.size() != len) {
            throw new WrongArgumentCountException(name + ": " + "expected " + len + (len == 1 ? " arg; " : " args; ") + "got " + args.size() + ".");
        }
    }
}

/* */
