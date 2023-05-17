package com.info.user;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@SecurityScheme(
	name = "bearerAuth",
	scheme = "bearer",
	bearerFormat = "JWT",
	type = SecuritySchemeType.HTTP,
	in = SecuritySchemeIn.HEADER
)
public class UserApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext c = SpringApplication.run(UserApplication.class, args);
	}

}
