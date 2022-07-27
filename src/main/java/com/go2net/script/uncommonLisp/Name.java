/*
 * Copyright (c) 1997 by Michael D. Bayne, All rights reserved.
 */

package com.go2net.script.uncommonLisp;


/** Name - A class used to represent a name */
public class Name {

    // Name public constructor

    public Name(String value) {
        _string = value;
    }

    // Name public member function

    public String toString() {
        return _string;
    }

    // Name protected data members

    String _string;
}
