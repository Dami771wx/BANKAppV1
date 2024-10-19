package com.micro.accounts.enteties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Entity
@Getter @Setter @ToString
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class account extends baseEntity {
    @Id
    @GeneratedValue
    private Integer id ;

    private String type ;

    @ManyToOne
    private client client ;

}
