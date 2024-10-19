package com.micro.accounts.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
@Schema(
        name = "client and all his Accounts"
)
public class clientAndAccount {

    private clientDTO clientDTO ;
    private List<accountDTO> accountDTOS ;


}
