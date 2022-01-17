package com.hamilton.proxibanque.exception;

public class ClientIntrouvable extends Exception{
    public ClientIntrouvable(){ super();}

    public ClientIntrouvable(String message){
        super(message);
    }
}
