package com.varun.bsm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class BloodSampleManagementApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BloodSampleManagementApiApplication.class, args);
	}

}
