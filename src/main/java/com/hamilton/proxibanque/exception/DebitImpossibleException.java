package com.hamilton.proxibanque.exception;

public class DebitImpossibleException extends Exception{
    public DebitImpossibleException(){
        super();
    }

    public DebitImpossibleException(String message){
        super(message);
    }
}
