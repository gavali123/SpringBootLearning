package com.learning.springboot.data.query.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.springboot.data.query.entity.Employee;
import com.learning.springboot.data.query.service.EmployeeService;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping(value = "/id/{id}", produces = "application/json")
	public Employee getEmployeeById(@PathVariable("id") Long id) {
		return employeeService.getEmployeeById(id);
	}

	@GetMapping(value = "/name/{name}", produces = "application/json")
	public Employee getEmployeeByName(@PathVariable("name") String name) {
		return employeeService.getEmployeeByName(name);
	}

	@GetMapping(value = "/salary/{id}", produces = "application/json")
	public Double findSalaryById(@PathVariable("id") Long id) {
		return employeeService.findSalaryById(id);
	}

	@GetMapping(value = "/find/{salary}")
	public Iterable<Employee> getEmployeeBySalary(@PathVariable("salary") Double salary) {
		return employeeService.getEmployeeBySalary(salary);
	}

	@GetMapping(value = "/count/{designation}", produces = "application/json")
	public Integer countByDesignation(@PathVariable("designation") String designation) {
		return employeeService.countByDesignation(designation);
	}

}
