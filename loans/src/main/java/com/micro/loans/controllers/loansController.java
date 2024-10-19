package com.micro.loans.controllers;

import com.micro.loans.DTO.exceptions.clientNameUnfoundException;
import com.micro.loans.DTO.loansDTO;
import com.micro.loans.DTO.responseDTO;
import com.micro.loans.entetites.loans;
import com.micro.loans.repo.loansRepo;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api",produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor

public class loansController {
    private loansRepo  loansRepo ;

    @PostMapping("/createLoans")
    public ResponseEntity<responseDTO> create(@RequestBody loansDTO loansDTO){
        loans loans = com.micro.loans.entetites.loans.builder()
                .clientName(loansDTO.getClientName())
                .price(loansDTO.getPrice())
                .amountPaid(loansDTO.getAmountPaid())
                .build() ;
        this.loansRepo.save(loans) ;

        return ResponseEntity.status(201)
                .body(
                        responseDTO.builder().statusCode("200")
                                .statusMsg("loans is created")
                                .build()
                ) ;
    }

    @GetMapping("/loans/{name}")
    public loansDTO getLoan(@PathVariable String name ){
       loans loans =  this.loansRepo.findByClientName(name).orElseThrow(()->new clientNameUnfoundException(name +" client name is unfound"));
        return loansDTO.builder()
                .clientName(loans.getClientName())
                .price(loans.getPrice())
                .amountPaid(loans.getAmountPaid())
                .build() ;
    }


}
