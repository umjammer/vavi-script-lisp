/*
 * Copyright (c) 1997 by Michael D. Bayne, All rights reserved.
 */

package com.go2net.script.uncommonLisp;


import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;


class EndOfListException extends Exception {
}

public class Parser {

    Parser(Reader in) {
        _scanner = new Scanner(in);
    }

    /**
     * parse the input stream. function definitions are parsed as calls to the
     * function defun and the interpreter will work it all out
     */
    public LispList parse() throws ParseException {
        LispList sexps = new LispList();

        // insert everything into one big top level list for execution
        try {
            Object val;
            while ((val = parseSExp()) != null)
                sexps.add(val);
            return sexps;

        } catch (IOException ioe) {
            throw new ParseException("IOException: " + ioe, _scanner.lineno(), "");

        } catch (EndOfListException eole) {
            // oops, extra close paren somewhere
            throw new ParseException("Unbalanced close parenthesis.", _scanner.lineno(), ")");
        }
    }

    Object parseSExp() throws IOException, ParseException, EndOfListException {
        int token = _scanner.nextToken();
        if (token == '\'') {
            return parseValue(true);
        } else {
            _scanner.pushBack();
            return parseValue(false);
        }
    }

    Object parseValue(boolean quoted) throws IOException, ParseException, EndOfListException {
        int token = _scanner.nextToken();

        switch (token) {
        case Scanner.TT_EOF:
            return null;

        case Scanner.TT_NUMBER:
            if (quoted)
                return String.valueOf(_scanner.nval);
            else
                return (int) _scanner.nval;

        case Scanner.TT_WORD:
            if (_scanner.sval.equals("nil")) {
                return new Nil();
            } else if (quoted) {
                return _scanner.sval;
            } else {
                return new Name(_scanner.sval);
            }

        case '"':
            return _scanner.sval;

        case '(': {
            List<Object> list = (quoted ? new LispList() : new ArrayList<>());

            try {
                Object sexp;
                while ((sexp = parseSExp()) != null)
                    list.add(sexp);

                // uh oh, hit EOF
                throw new ParseException("Premature end of sexp.", _scanner.lineno(), "");

            } catch (EndOfListException e) {
                return list;
            }
        }

        case ')':
            throw new EndOfListException();

        case '+':
            return new Name("add");

//         case '-': {
//             int nt = _scanner.nextToken();
//             if (nt == Scanner.TT_NUMBER) {
//                 return new Integer(-((int)_scanner.nval));
//             } else {
//                 _scanner.pushBack();
//                 return new Name("sub");
//             }
//         }

        case '-':
            return new Name("sub");

        case '*':
            return new Name("mul");

        case '/':
            return new Name("div");

        case '=':
            return new Name("eq");

        case '<': {
            int nt = _scanner.nextToken();
            if (nt == '=') {
                return new Name("lte");
            } else {
                _scanner.pushBack();
                return new Name("lt");
            }
        }

        case '>': {
            int nt = _scanner.nextToken();
            if (nt == '=') {
                return new Name("gte");
            } else {
                _scanner.pushBack();
                return new Name("gt");
            }
        }

        default:
            // attempt to allow one character function names like +
            throw new ParseException("Invalid token.", _scanner.lineno(), String.valueOf((char) token));
        }
    }

    // Parser protected data members

    Scanner _scanner;
}
