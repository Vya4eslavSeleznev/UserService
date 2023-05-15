package com.info.user;

import com.info.user.repository.Impl.ContactDaoImpl;
import com.info.user.repository.Impl.CredentialDaoImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class UserApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext c = SpringApplication.run(UserApplication.class, args);
		var f = c.getBean(CredentialDaoImpl.class).findById(1);
		System.out.println();
	}

}
