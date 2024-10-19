package com.micro.accounts.controllers;

import com.micro.accounts.DTO.accountContactInfo;
import com.micro.accounts.DTO.responseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor

public class test {

    private accountContactInfo accountContactInfo ;


    @Operation(
            summary = "Account Api Contact",
            description = "Contact Info datails in case of any issues"
    )

    @GetMapping("/GETApiContact")
    public ResponseEntity<accountContactInfo> get(){
        return ResponseEntity.status(200)
                .body(this.accountContactInfo);

    }

}
