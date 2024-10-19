package com.micro.accounts.services.impl;

import com.micro.accounts.DTO.accountDTO;
import com.micro.accounts.DTO.clientAndAccount;
import com.micro.accounts.DTO.clientDTO;
import com.micro.accounts.enteties.account;
import com.micro.accounts.exceptions.notFoundException;
import com.micro.accounts.repo.accountRepo;
import com.micro.accounts.repo.clientRepo;
import com.micro.accounts.services.IAccountsService;
import lombok.AllArgsConstructor;
import com.micro.accounts.mapper.clientMapper ;
import org.springframework.stereotype.Service;
import com.micro.accounts.enteties.client ;
import com.micro.accounts.exceptions.clientAlreadyExists ;
import com.micro.accounts.mapper.accountMapper ;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor


public class accountServiceImpl implements IAccountsService {

    private clientRepo clientRepo ;
    private accountRepo accountRepo ;
    @Override
    public void createAccount(clientDTO client) {

     if (this.clientRepo.findByName(client.getName()).isPresent()){

         throw  new clientAlreadyExists("the name already exists");
     }

     client c =      this.clientRepo.save(
                  clientMapper.toClient(client)
          ) ;
     accountRepo.save(
             account.builder()
                     .type("normal account")
                     .client(c)
                     .build()
     ) ;

    }

    @Override
    public clientAndAccount getAll(String name) {
        client c = this.clientRepo.findByName(name).orElseThrow(()->new notFoundException("Name unfound")) ;

        List<accountDTO> accounts = c.getAccounts().stream()
                .map(accountMapper::mapToAccount )
                .toList();
        clientDTO clientDTO = clientMapper.toClientDTO(c) ;

        return clientAndAccount.builder()
                .clientDTO(clientDTO)
                .accountDTOS(accounts)
                .build() ;


    }

    @Override
    public void addAccount(String name) {

        client c = this.clientRepo.findByName(name).orElseThrow(()->new notFoundException("Name unfound")) ;
        this.accountRepo.save(
                account.builder()
                        .type("onother account")
                        .client(c)
                        .build()
        ) ;


    }

    @Override

    public void updateAccount(clientDTO client,String name ) {

        client c = this.clientRepo.findByName(name).orElseThrow(()->new notFoundException("Name unfound")) ;
        c.setUpdatedAt(LocalDateTime.now());
        this.clientRepo.save(
                clientMapper.to(client,c)
        ) ;

    }


}
