package com.MSansar.Account;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class AccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenApi(@Value("${application-description}") String description,
								 @Value("${application-version}") String version){
		return new OpenAPI().info(
				new Info()
						.title("MSansar Account app")
						.version(version)
						.description(description)
		);
	}

}
