/*
 * Copyright (c) 1997 by Michael D. Bayne, All rights reserved.
 */

package com.go2net.script.uncommonLisp;
//


import java.util.HashMap;
import java.util.Map;


/**
 * a user defined function interpreted at runtime
 */
public class UserFunction extends Function {
    //
    // UserFunction public constructor

    public UserFunction(String name, java.util.List args, java.util.List sexps) {
        _name = name;
        _args = args;
        _sexps = sexps;
    }

    //
    // UserFunction public member functions

    public Object evaluate(Interpreter interp, java.util.List sexp) throws RunTimeException {
        Map<String, Object> shadowed = new HashMap<>();

        for (int i = 0; i < _args.size(); i++) {
            String name = ((Name) _args.get(i)).toString();
            Object val = sexp.get(i);

            // shadow this variable
            Object oval = interp.env.get(name);
            if (oval != null)
                shadowed.put(name, oval);
            else
                shadowed.put(name, new Nil());

            // evaluate the argument and bind it to the variable
            interp.env.put(name, interp.evaluateSExp(val));
        }

        // evaluate the sexps that constitute this function
        // System.out.println("Interpreting sexps.");
        Object result = interp.interpret(_sexps);

        // copy the values of the shadowed variables back into the environment
        for (String key : shadowed.keySet()) {
            Object oval = shadowed.get(key);
            if (oval instanceof Nil)
                interp.env.remove(key);
            else
                interp.env.put(key, oval);
        }

        return result;
    }

    public int numArguments() {
        return _args.size();
    }

    public String name() {
        return _name;
    }

    //
    // UserFunction protected data members

    String _name;

    java.util.List _args;

    java.util.List _sexps;
}
