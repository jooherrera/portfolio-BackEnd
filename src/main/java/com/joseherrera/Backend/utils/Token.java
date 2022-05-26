package com.joseherrera.Backend.utils;

public class Token {

    private final int id;
    private final int dni;
    private final boolean isAdmin;

    public Token(int id , int dni, boolean isAdmin) {
        this.id = id;
        this.dni = dni;
        this.isAdmin = isAdmin;
    }

    public int getPrimaryKey(){
        return id;
    }
    
    public int getPersonPK(){
        return dni;
    }
    
    public boolean getIsAdmin(){
        return isAdmin;
    }
    
}
