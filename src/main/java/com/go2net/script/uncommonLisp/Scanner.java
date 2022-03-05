/*
 * Copyright (c) 1997 by Michael D. Bayne, All rights reserved.
 */

package com.go2net.script.uncommonLisp;


import java.io.Reader;
import java.io.StreamTokenizer;


public class Scanner extends StreamTokenizer {

    public Scanner(Reader is) {
        super(is);

        // initialize the stream tokenizer for lisp
        commentChar(';');
        parseNumbers();
        quoteChar('"');
        ordinaryChar('\'');
        wordChars('_', '_');
    }
}
