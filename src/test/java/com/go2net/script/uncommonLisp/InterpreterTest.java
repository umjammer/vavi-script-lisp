/*
 * Copyright (c) 2022 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package com.go2net.script.uncommonLisp;

import java.io.Reader;
import java.io.StringReader;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InterpreterTest {

    @Test
    void test() throws Exception {
        Interpreter.main(new String[] { "src/test/resources/com/go2net/script/uncommonLisp/hello.lisp" });
    }

    @Test
    void test2() throws Exception {
        Interpreter.main(new String[] { "src/test/resources/com/go2net/script/uncommonLisp/fact.lisp" });
    }

    @Test
    void test3() throws Exception {
        Interpreter.main(new String[] { "src/test/resources/com/go2net/script/uncommonLisp/towers.lisp" });
    }

    @Test
    void test4() throws Exception {
        Reader fin = new StringReader("(add 10 20)");

        Parser parser = new Parser(fin);
        Object val = parser.parse();
        Interpreter interp = new Interpreter();
        assertEquals(30, interp.interpret(val));
    }
}

/* */
