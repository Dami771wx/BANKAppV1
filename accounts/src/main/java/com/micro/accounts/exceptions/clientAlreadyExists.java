package com.micro.accounts.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(value = HttpStatus.BAD_REQUEST)

public class clientAlreadyExists extends RuntimeException {
     public clientAlreadyExists(String msg){
        super(msg);
    }

}
