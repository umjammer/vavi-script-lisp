/*
 * Copyright (c) 2021 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package com.sun.script.lisp;

import java.io.ByteArrayInputStream;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.sun.script.lisp.prim.LispEqlFun;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


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

    @Test
    void testSharpCommentAndBooleans() throws Exception {
        String script =
            "(# \"this is a sharp comment\")\n" +
            "(if #t (+ 1 2) (#f))\n";
        LispInterpreter interp = new LispInterpreter(new ByteArrayInputStream(script.getBytes(StandardCharsets.UTF_8)));
        List<Object> results = interp.interpretQuiet();
        assertEquals(2, results.size());
        assertEquals("this is a sharp comment", results.get(0));
        assertEquals(3, results.get(1));
    }

    @Test
    void testSharpCommentErrors() {
        LispInterpreter interp1 = new LispInterpreter();
        interp1.setReader(new StringReader("(#)"));
        assertThrows(WrongArgumentCountException.class, () -> interp1.eval(interp1.read()));

        LispInterpreter interp2 = new LispInterpreter();
        interp2.setReader(new StringReader("(# 123)"));
        assertThrows(BadArgumentTypeException.class, () -> interp2.eval(interp2.read()));
    }

    @Test
    void testSemicolonCommentsAndIndentation() throws Exception {
        String script =
            ";; leading comment 1\r\n" +
            "  ;; leading comment 2\n" +
            "(define (add-one x)\n" +
            "  ; comment inside list with indentation\n" +
            "  (+ x 1 ; comment before closing paren\n" +
            "  ))\n" +
            "(add-one 41)\n" +
            "; trailing comment\n";
        LispInterpreter interp = new LispInterpreter(new ByteArrayInputStream(script.getBytes(StandardCharsets.UTF_8)));
        List<Object> results = interp.interpretQuiet();
        assertEquals(2, results.size());
        assertEquals(42, results.get(1));
    }

    @Test
    void testTopLevelTokensAtEofAndMinusSymbols() throws Exception {
        LispReader numReader = new LispReader(new StringReader("42"), new HashMap<>());
        assertEquals(42, numReader.read());

        LispReader symReader = new LispReader(new StringReader("foo"), new HashMap<>());
        assertEquals("foo", ((LispSymbol) symReader.read()).getName());

        String script = "(define -foo 10) (+ -foo -3)";
        LispInterpreter interp = new LispInterpreter(new ByteArrayInputStream(script.getBytes(StandardCharsets.UTF_8)));
        List<Object> results = interp.interpretQuiet();
        assertEquals(7, results.get(1));
    }

    @Test
    void testReaderErrorsAndIncompleteExpressions() {
        LispReader incompleteList = new LispReader(new StringReader("(+ 1 2"), new HashMap<>());
        assertThrows(IncompleteExpressionException.class, incompleteList::read);

        LispReader badBoolean = new LispReader(new StringReader("#true"), new HashMap<>());
        assertThrows(InvalidLispExpressionException.class, badBoolean::read);

        LispReader badNumber = new LispReader(new StringReader("1.2.3"), new HashMap<>());
        assertThrows(InvalidLispExpressionException.class, badNumber::read);

        LispReader lineNumError = new LispReader(new StringReader("(+ 1 2)\n(+ 3 4)\n)"), new HashMap<>());
        InvalidLispExpressionException ex = assertThrows(InvalidLispExpressionException.class, () -> {
            lineNumError.read();
            lineNumError.read();
            lineNumError.read();
        });
        assertTrue(ex.getMessage().contains("(line:3)"), ex.getMessage());
    }
}
