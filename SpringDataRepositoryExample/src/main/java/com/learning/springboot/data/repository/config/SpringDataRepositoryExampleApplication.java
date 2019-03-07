package com.learning.springboot.data.repository.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.learning.springboot.data.repository.entity.Employee;
import com.learning.springboot.data.repository.service.EmployeeService;

@SpringBootApplication(scanBasePackages = "com.learning.springboot.data.repository")
@EnableJpaRepositories(basePackages = "com.learning.springboot.data.repository.dao")
@EntityScan(basePackages = "com.learning.springboot.data.repository.entity")
public class SpringDataRepositoryExampleApplication implements CommandLineRunner {

	@Autowired
	private EmployeeService employeeService;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataRepositoryExampleApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		createEmployee();
	}

	private void createEmployee() {
		Employee emp = new Employee("Pritesh", "Senior Software Engineer", 1200000d);
		Employee employeeObj = employeeService.save(emp);
		System.out.println(employeeObj.toString());
	}

}
