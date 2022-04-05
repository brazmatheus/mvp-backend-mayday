package com.backend.mayday;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class MaydayProjApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaydayProjApplication.class, args);
	}

}
