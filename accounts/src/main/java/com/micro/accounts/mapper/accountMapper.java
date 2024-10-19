package com.micro.accounts.mapper;

import com.micro.accounts.DTO.accountDTO;
import com.micro.accounts.enteties.account;

import java.time.LocalDateTime;

public class accountMapper {

    public static accountDTO mapToAccount(account account){

        return accountDTO.builder()
                .type(account.getType())
                .build() ;

    }

    public static  account mapToAccountDto(accountDTO accountDTO){
        return account.builder()
                .type(accountDTO.getType())
                .build() ;
    }
}
