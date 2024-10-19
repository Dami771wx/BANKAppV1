package com.micro.accounts.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Schema(
        name = "ACCOUNT"
)
public class accountDTO {

    private String type ;
}
