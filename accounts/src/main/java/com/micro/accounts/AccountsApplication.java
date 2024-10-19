package com.micro.accounts;

import com.micro.accounts.DTO.accountContactInfo;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
			title = "Accounts Microservices Rest API Documentation",
			description = "Rest API Documentation",
				version = "V1",
				contact = @Contact(
						name = "IMAD SAMADI",
						email = "imadsamadi999@gmail.com"

				)

		)
)
@EnableConfigurationProperties(value = {accountContactInfo.class})
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
