package com.micro.accounts.controllers;


import com.micro.accounts.DTO.clientDTO;
import com.micro.accounts.DTO.responseDTO;
import com.micro.accounts.services.IAccountsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.micro.accounts.DTO.clientAndAccount  ;


@Tag(
        name = "CRUD REST APIS for Accounts",
        description = "CRUD Rest API to CREATE,UPDATE,FETCH AND DELETE account details"
)
@RestController
@RequestMapping(path = "/api",produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated

public class accountController {

    private IAccountsService iAccountsService ;

    @Operation(
            summary = "CREATE Account",
            description = "CREATING NEW CLIENT AND AN ACCOUNT"
    )
   @ApiResponses({
           @ApiResponse(
                   responseCode = "201",
                   description = "HTTP Status CREATED"
           ),
           @ApiResponse(
                   responseCode = "500",
                   description = "HTTP Status Internal Server Error"
           )
   })
    @PostMapping("/create")
    public ResponseEntity<responseDTO> createAccount(@Valid  @RequestBody clientDTO clientDTO){


        this.iAccountsService.createAccount(clientDTO);

        return  ResponseEntity.status(201)
                .body(
                        responseDTO.builder()
                                .statusCode("201")
                                .statusMsg("account created")
                                .build()
                ) ;


    }

    @GetMapping("/getAll/{name}")
    public clientAndAccount getALL(@PathVariable  String name ){

        return this.iAccountsService.getAll(name) ;
    }
    @GetMapping("/add/{name}")
    public ResponseEntity<responseDTO> addAccount(@PathVariable String name ){

        this.iAccountsService.addAccount(name);

        return  ResponseEntity.status(201)
                .body(
                        responseDTO.builder()
                                .statusCode("201")
                                .statusMsg("account added to "+name+" with success")
                                .build()
                ) ;
    }
    @PutMapping("/update/{name}")
    public ResponseEntity<responseDTO> updateAccount(@RequestBody clientDTO clientDTO ,@PathVariable String name){

        this.iAccountsService.updateAccount(clientDTO,name);

        return  ResponseEntity.status(201)
                .body(
                        responseDTO.builder()
                                .statusCode("201")
                                .statusMsg("account is modified with success")
                                .build()
                ) ;
    }





}
