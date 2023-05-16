package com.info.user;

import com.info.user.entity.Contact;
import com.info.user.repository.impl.ContactDaoImpl;
import com.info.user.repository.impl.CredentialDaoImpl;
import com.info.user.service.impl.ContactServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class UserApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext c = SpringApplication.run(UserApplication.class, args);

		Contact g = new Contact("UUUU", "IIII");

		var f = c.getBean(ContactServiceImpl.class).findById(7);
		System.out.println();
	}

}
