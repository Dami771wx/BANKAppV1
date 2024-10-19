package com.micro.accounts.mapper;

import com.micro.accounts.DTO.clientDTO;
import com.micro.accounts.enteties.client;

import java.time.LocalDateTime;

public class clientMapper {

    public static clientDTO toClientDTO(client client){
        return clientDTO.builder()
                .name(client.getName())
                .age(client.getAge())
                .build() ;

    }
    public static client toClient(clientDTO clientDTO){

        return client.builder()
                .name(clientDTO.getName())
                .age(clientDTO.getAge())
                .createdAt(LocalDateTime.now())
                .build() ;

    }
    public static client to(clientDTO cDTO ,client c  ){
         c.setName(cDTO.getName());
         c.setAge(cDTO.getAge());
         return c ;
    }
}
