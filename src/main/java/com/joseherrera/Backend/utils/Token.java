package com.joseherrera.Backend.utils;

public class Token {

    private final int id;
    private final int dni;

    public Token(int id , int dni) {
        this.id = id;
        this.dni = dni;
        
    }

    public int getPrimaryKey(){
        return id;
    }
    
    public int getPersonPK(){
        return dni;
    }
    
}
