/*
 * Copyright (c) 2008 by Naohide Sano, All rights reserved.
 *
 * Programmed by Naohide Sano
 */

package com.sun.script.lisp.jsr223;

import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptException;
import javax.script.SimpleBindings;
import javax.script.SimpleScriptContext;

import com.sun.script.lisp.CommentLispException;
import com.sun.script.lisp.ExitLispException;
import com.sun.script.lisp.LispInterpreter;


/**
 * LispScriptEngine.
 *
 * @author <a href="mailto:umjammer@gmail.com">Naohide Sano</a> (nsano)
 * @version 0.00 080602 nsano make the initial version <br>
 */
public class LispScriptEngine implements ScriptEngine {

    /** */
    private static final String __ENGINE_VERSION__ = "0.0 release 1";
    /** */
    private static final String MY_NAME = "Sun Lisp";
    /** */
    private static final String MY_SHORT_NAME = "lisp";
    /** */
    private static final String STR_THISLANGUAGE = "Scheme";

    /** */
    private ScriptEngineFactory factory;

    /** */
    private ScriptContext defaultContext;

    /** */
    public LispScriptEngine(ScriptEngineFactory factory) {
        this.factory = factory;
        defaultContext = new SimpleScriptContext();
        // set special values
        put(LANGUAGE_VERSION, "1.0");
        put(LANGUAGE, STR_THISLANGUAGE);
        put(ENGINE, MY_NAME);
        put(ENGINE_VERSION, __ENGINE_VERSION__);
        put(ARGV, ""); // TO DO: set correct value
        put(FILENAME, ""); // TO DO: set correct value
        put(NAME, MY_SHORT_NAME);
        /*
         * I am not sure if this is correct; we need to check if
         * the name really is THREADING. I have no idea why there is
         * no constant as for the other keys
         */
        put("THREADING", null);

        this.interpreter = new LispInterpreter();
    }

    /** */
    private LispInterpreter interpreter;

    @Override
    public Object eval(String script) throws ScriptException {
        return eval(script, getContext());
    }

    @Override
    public Object eval(String script, ScriptContext context) throws ScriptException {
        try {
            Reader reader = new StringReader(script);
            interpreter.setReader(reader);

            List<Object> results = new ArrayList<Object>();

            while (true) {
                try {
                    Object expression = interpreter.read();
                    results.add(interpreter.eval(expression));
                } catch (CommentLispException e) {
                    // ignore
                } catch (ExitLispException | EOFException e) {
                    return results;
                }
            }
        } catch (Exception e) {
            throw new ScriptException(e);
        }
    }

    @Override
    public Object eval(String script, Bindings bindings) throws ScriptException {
        Bindings current = getContext().getBindings(ScriptContext.ENGINE_SCOPE);
        getContext().setBindings(bindings, ScriptContext.ENGINE_SCOPE);
        Object result = eval(script);
        getContext().setBindings(current, ScriptContext.ENGINE_SCOPE);
        return result;
    }

    @Override
    public Object eval(Reader reader) throws ScriptException {
        return eval(getScriptFromReader(reader));
    }

    @Override
    public Object eval(Reader reader, ScriptContext scriptContext) throws ScriptException {
        return eval(getScriptFromReader(reader), scriptContext);
    }

    @Override
    public Object eval(Reader reader, Bindings bindings) throws ScriptException {
        return eval(getScriptFromReader(reader), bindings);
    }

    @Override
    public void put(String key, Object value) {
        getBindings(ScriptContext.ENGINE_SCOPE).put(key, value);
    }

    @Override
    public Object get(String key) {
        return getBindings(ScriptContext.ENGINE_SCOPE).get(key);
    }

    @Override
    public Bindings getBindings(int scope) {
        return getContext().getBindings(scope);
    }

    @Override
    public void setBindings(Bindings bindings, int scope) {
        getContext().setBindings(bindings, scope);
    }

    @Override
    public Bindings createBindings() {
        return new SimpleBindings();
    }

    @Override
    public ScriptContext getContext() {
        return defaultContext;
    }

    @Override
    public void setContext(ScriptContext context) {
        defaultContext = context;
    }

    @Override
    public ScriptEngineFactory getFactory() {
        return factory;
    }

    /** */
    private static String getScriptFromReader(Reader reader) {
        try {
            StringWriter script = new StringWriter();
            int data;
            while ((data = reader.read()) != -1) {
                script.write(data);
            }
            script.flush();
            return script.toString();
        } catch (IOException e) {
e.printStackTrace(System.err);
            return null;
        }
    }
}

/* */
