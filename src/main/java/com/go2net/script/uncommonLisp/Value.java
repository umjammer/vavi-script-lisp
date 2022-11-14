/*
 * Copyright (c) 1997 by Michael D. Bayne, All rights reserved.
 */

package com.go2net.script.uncommonLisp;


import java.util.List;


/**
 * Value - an object to store values (numbers, strings, etc)
 */
public class Value {

    public final static int NIL = 0;
    public final static int INTEGER = 1;
    public final static int STRING = 2;
    public final static int LIST = 3;
    public final static int VARIABLE = 4;
    public final static int CALL = 5;

    int type;
    int intval;
    String strval;
    List<?> lstval;

    public Value() {
        type = Value.NIL;
    }

    public Value(int value) {
        type = INTEGER;
        intval = value;
    }

    public Value(String name, boolean quoted) {
        type = (quoted ? STRING : VARIABLE);
        strval = name;
    }

    public Value(int type, List<?> list) {
        this.type = type;
        lstval = list;
    }

    public Value(Value rhs) {
        type = rhs.type;
        intval = rhs.intval;
        strval = rhs.strval;
        lstval = copyList(rhs.lstval);
    }

    public void setValue(Value rhs) throws LispException {
        if (type != rhs.type)
            throw new LispException("Type mismatch error.", this);

        switch (type) {
        case INTEGER:
            intval = rhs.intval;
            break;

        case STRING:
            strval = rhs.strval;
            break;

        case LIST:
            lstval = copyList(rhs.lstval);
            break;

        default:
            throw new LispException("Internal Error! RHS is an " + "unevaluated sexp.", this);
        }
    }

    public String toString() {
        return toString(" ");
    }

    public String toString(String seperator) {
        switch (type) {
        case INTEGER:
            return String.valueOf(intval);

        case STRING:
            return "\"" + strval + "\"";

        case LIST:
            return "'(" + listToString(lstval, seperator) + ")";

        case VARIABLE:
            return strval;

        case CALL:
            return "(" + strval + seperator + listToString(lstval, seperator) + ")";

        default:
            return "UNKNOWN: " + Integer.toString(type);
        }
    }

    //
    // Value public static member function

    public static LispList copyList(List<?> source) {
        if (source == null)
            return null;
        return copyList(source, 0, source.size());
    }

    public static LispList copyList(List<?> source, int start, int length) {
        if (source == null)
            return null;

        LispList newvec = new LispList();
        for (int i = start; i < start + length; i++) {
            newvec.add(new Value((Value) source.get(i)));
        }

        return newvec;
    }

    //
    // Value protected member function

    String listToString(List<?> list, String seperator) {
        String rv = "";

        for (int i = 0; i < lstval.size(); i++) {
            Value val = (Value) lstval.get(i);
            if (i != 0)
                rv = rv.concat(seperator);
            rv = rv.concat(val.toString(seperator));
        }

        return rv;
    }
}
