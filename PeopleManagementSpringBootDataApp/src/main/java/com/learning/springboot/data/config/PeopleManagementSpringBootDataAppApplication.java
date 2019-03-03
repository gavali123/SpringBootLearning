package com.learning.springboot.data.config;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.learning.springboot.data.entity.Person;
import com.learning.springboot.data.service.PeopleManagementService;

@SpringBootApplication(scanBasePackages = "com.learning.springboot.data")
@EnableJpaRepositories(basePackages = "com.learning.springboot.data.dao")
@EntityScan(basePackages = "com.learning.springboot.data.entity")
public class PeopleManagementSpringBootDataAppApplication implements CommandLineRunner {

	@Autowired
	private PeopleManagementService peopleManagementService;

	public static void main(String[] args) {
		SpringApplication.run(PeopleManagementSpringBootDataAppApplication.class, args);
	}

	@Override
	public void run(String... args) {
		createPerson();
	}

	private void createPerson() {
		Person person = new Person("Pritesh", "Gavali", "gavali.pritesh@gmail.com", new Date());
		Person personObj = peopleManagementService.create(person);
		System.out.println(personObj.toString());
	}

}
