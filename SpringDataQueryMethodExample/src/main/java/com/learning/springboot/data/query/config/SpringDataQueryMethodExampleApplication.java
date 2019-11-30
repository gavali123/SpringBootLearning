package com.learning.springboot.data.query.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.learning.springboot.data.query.entity.Employee;
import com.learning.springboot.data.query.entity.Student;
import com.learning.springboot.data.query.service.EmployeeService;
import com.learning.springboot.data.query.service.StudentService;

@SpringBootApplication(scanBasePackages = "com.learning.springboot.data.query")
@EnableJpaRepositories(basePackages = "com.learning.springboot.data.query.dao")
@EntityScan(basePackages = "com.learning.springboot.data.query.entity")
public class SpringDataQueryMethodExampleApplication implements CommandLineRunner {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private StudentService studentService;

	public static void main(String[] args) {
		SpringApplication.run(SpringDataQueryMethodExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		createEmployee();
		createStudent();
	}

	private void createStudent() {
		Student stud = new Student("Pritesh", "Gavali", "Pune", "10");
		studentService.save(stud);
		System.out.println(stud.toString());
	}

	private void createEmployee() {
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee("Pritesh", "Senior Software Engineer", 1200000d));
		empList.add(new Employee("Ankita", "Senior .Net Developer", 1000000d));
		empList.add(new Employee("Akash", "Specialist Programmer", 1800000d));
		empList.add(new Employee("Varsha ", "Senior Software Engineer", 1200000d));
		Iterable<Employee> employeeObj = employeeService.saveAll(empList);
		for (Employee emp : employeeObj) {
			System.out.println(emp.toString());
		}
	}

}
