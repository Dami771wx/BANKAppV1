package com.micro.accounts.enteties;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class client extends baseEntity  {

    @Id
    @GeneratedValue
    private Integer id ;

    @NotNull
    private String name ;

    private Integer age ;

   @OneToMany(mappedBy = "client",cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
    private List<account> accounts ;

}
