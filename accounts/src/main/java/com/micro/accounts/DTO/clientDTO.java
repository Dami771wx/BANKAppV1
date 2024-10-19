package com.micro.accounts.DTO;




import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;

@Data
@Builder
@Schema(
        name = "CLIENT"
)

public class clientDTO {
    @Schema(
            example = "imad"
    )
    @NotEmpty(message = "name must not empty")
    @Size(min = 3 , max = 10 ,message = "the length should be between 5 and 10 ")
    private String name ;

    @Schema(
            example = "22"
    )
    @Positive(message = "the age must greater than 0 ")
    private int age ;
}
