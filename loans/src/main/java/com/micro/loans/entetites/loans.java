package com.micro.loans.entetites;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class loans extends baseEntity{
    @Id
    @GeneratedValue
    private Integer id ;

    @NotNull
    private String clientName ;

    private int price ;
    private int amountPaid ;
}
