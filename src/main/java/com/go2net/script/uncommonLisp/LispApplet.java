/*
 * Copyright (c) 1997 by Michael D. Bayne, All rights reserved.
 */

package com.go2net.script.uncommonLisp;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Panel;
import java.awt.TextArea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.Reader;
import java.io.StringReader;
import java.net.URL;

import com.go2net.script.uncommonLisp.function.Bprint;


/** LispApplet */
public class LispApplet extends Applet implements Runnable {

    public void init() {
        setLayout(new BorderLayout());

        add("North", _ctrlpanel = new Panel());
        _ctrlpanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        Button b = new Button("Run");
        b.addActionListener(e -> {
            if (_runner == null) {
                _out.println("\nRunning. Output shown below:");
                _runner = new Thread(this);
                _runner.start();
            }
        });
        _ctrlpanel.add(b);
        _ctrlpanel.add(_choices = new Choice());
        b = new Button("Run");
        b.addActionListener(e -> {
            String source = _sources[_choices.getSelectedIndex()];
            _out.println("\nLoading: " + source);
            load(source);
        });
        _ctrlpanel.add(b);
        b = new Button("Clear");
        b.addActionListener(e -> {
            _output.setText("");
        });
        _ctrlpanel.add(b);

        _choices.addItem("Hello World");
        _choices.addItem("Factorial");
        _choices.addItem("Towers of Hanoi");

        add("Center", _input = new TextArea());
        add("South", _output = new TextArea());

        _input.setFont(new Font("Courier", Font.PLAIN, 12));
        _output.setFont(new Font("Courier", Font.PLAIN, 12));
        _output.setSize(10, 100);

        _out = new PrintStream(new TextAreaOutputStream(_output));
        Bprint.setOutputStream(_out);

        load("hello.lisp");
    }

    public void run() {
        Reader bin = new StringReader(_input.getText());

        try {
            Parser p = new Parser(bin);
            _interp.interpret(p.parse());

        } catch (LispException rte) {
            _out.println(rte);
            _out.println("SExp: " + rte.sexp);

        } catch (ParseException pe) {
            _out.println(pe);
            _out.println("  Line: " + pe.lineNumber() + " Token: " + pe.token());
        }

        _runner = null;
    }

    public void load(String source) {
        try {
            URL sourceURL = new URL(getDocumentBase(), source);
            BufferedReader din = new BufferedReader(new InputStreamReader(sourceURL.openStream()));

            _input.setText("");
            String line;
            while ((line = din.readLine()) != null) {
                _input.append(line + "\n");
            }

        } catch (IOException mue) {
            _out.println("Error loading: " + source + ": " + mue);

        }
    }

    // LispApplet protected constants

    final static String[] _sources = {
        "hello.lisp", "fact.lisp", "towers.lisp"
    };

    // LispApplet protected data members

    Panel _ctrlpanel;
    Choice _choices;
    TextArea _input;
    TextArea _output;
    Interpreter _interp = new Interpreter();
    Thread _runner;
    PrintStream _out;
}
