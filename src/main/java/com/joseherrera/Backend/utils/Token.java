package com.joseherrera.Backend.utils;

public class Token {

    private final int id;

    public Token(int id) {
        this.id = id;
    }

    public int getPrimaryKey(){
        return id;
    }
    
}
