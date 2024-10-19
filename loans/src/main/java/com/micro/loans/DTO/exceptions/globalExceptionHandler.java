package com.micro.loans.DTO.exceptions;

import com.micro.loans.DTO.errorResponse ;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class globalExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<errorResponse> handleNameExists(clientNameUnfoundException clientAlreadyExists, WebRequest webRequest){

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(
                        errorResponse.builder()
                                .apiPath(webRequest.getDescription(false))
                                .errorCode(HttpStatus.BAD_REQUEST)
                                .errorMsg(clientAlreadyExists.getMessage())
                                .errorTime(LocalDateTime.now())
                                .build()
                ) ;
    }

    @ExceptionHandler
    public ResponseEntity<errorResponse> UnknownException(Exception ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(
                        errorResponse.builder()
                                .apiPath(null)
                                .errorCode(HttpStatus.INTERNAL_SERVER_ERROR)
                                .errorMsg(ex.getMessage())
                                .errorTime(LocalDateTime.now())
                                .build()
                ) ;
    }

}
