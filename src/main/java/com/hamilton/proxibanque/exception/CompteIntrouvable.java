package com.hamilton.proxibanque.exception;

public class CompteIntrouvable extends Exception{
    public CompteIntrouvable(){
        super();
    }

    public CompteIntrouvable(String message){
        super(message);
    }
}
