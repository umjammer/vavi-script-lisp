/*
 * Copyright (c) 2021 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package com.sun.script.lisp;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.sun.script.lisp.prim.LispEqlFun;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * LispTest.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (umjammer)
 * @version 0.00 2022/03/02 umjammer initial version <br>
 */
class LispTest {

    @Test
    void test() throws Exception {
        LispEqlFun lisp = new LispEqlFun();
        Object result = lisp.apply(Arrays.asList(LispBoolean.trueValue, LispBoolean.trueValue));
        assertEquals(LispBoolean.trueValue, result);
    }
}

/* */
