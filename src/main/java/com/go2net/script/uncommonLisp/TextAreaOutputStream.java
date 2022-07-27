/*
 * Copyright (c) 1997 by Michael D. Bayne, All rights reserved.
 */

package com.go2net.script.uncommonLisp;

import java.awt.TextArea;
import java.io.IOException;
import java.io.OutputStream;


/** TextAreaOutputStream - write output to a text area */
public class TextAreaOutputStream extends OutputStream {

    // TextAreaOutputStream public constructor

    public TextAreaOutputStream(TextArea target) {
        _target = target;
    }

    // TextAreaOutputStream public member function

    public void flush() throws IOException {
        _target.append(_line.toString());
        _line = new StringBuffer();
    }

    public void write(int b) throws IOException {
        _line.append((char) b);

        if (b == '\n') {
            _target.append(_line.toString());
            _line = new StringBuffer();
        }
    }

    public void write(byte[] b) throws IOException {
        _target.append(new String(b ));
    }

    public void write(byte[] b, int off, int len) throws IOException {
        _target.append(new String(b, off, len));
    }

    // TextAreaOutputStream protected data members

    TextArea _target;

    StringBuffer _line = new StringBuffer();
}
