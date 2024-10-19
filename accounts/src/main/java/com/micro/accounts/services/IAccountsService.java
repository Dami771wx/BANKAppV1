package com.micro.accounts.services;

import com.micro.accounts.DTO.clientAndAccount;
import com.micro.accounts.DTO.clientDTO;

import java.util.List;

public interface IAccountsService {

    void createAccount (clientDTO client ) ;
    clientAndAccount getAll(String name) ;

    void addAccount(String name) ;
    void updateAccount(clientDTO client,String name) ;




}
