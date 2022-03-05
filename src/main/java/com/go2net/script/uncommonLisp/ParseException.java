/*
 * Copyright (c) 1997 by Michael D. Bayne, All rights reserved.
 */

package com.go2net.script.uncommonLisp;

/**
 * ParseException - an exception to indicate problems with parsing
 */
public class ParseException extends Exception {

    public ParseException(String msg, int lineno, String token) {
        super(msg);
        _lineno = lineno;
        _token = token;
    }

    public int lineNumber() {
        return _lineno;
    }

    public String token() {
        return _token;
    }

    int _lineno;

    String _token;
}
