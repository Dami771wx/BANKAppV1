package com.micro.loans.DTO.exceptions;

public class clientNameUnfoundException extends RuntimeException{
    public clientNameUnfoundException(String msg){
        super(msg);
    }
}
