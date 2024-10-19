package com.micro.loans.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Schema(
        name = "LOANS"
)
public class loansDTO {
    private String clientName ;
    private int price ;
    private int amountPaid ;

}
