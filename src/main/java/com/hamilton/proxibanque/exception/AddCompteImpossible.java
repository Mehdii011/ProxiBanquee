package com.hamilton.proxibanque.exception;

public class AddCompteImpossible  extends Exception{
    public AddCompteImpossible(){
        super();
    }

    public AddCompteImpossible(String message){
        super(message);
    }
}
