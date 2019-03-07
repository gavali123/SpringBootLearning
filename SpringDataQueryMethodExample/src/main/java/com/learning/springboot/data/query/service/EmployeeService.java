package com.learning.springboot.data.query.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.springboot.data.query.dao.EmployeeDao;
import com.learning.springboot.data.query.entity.Employee;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;

	public Employee getEmployeeById(Long id) {
		return employeeDao.findById(id).get();
	}

	public Employee save(Employee emp) {
		return employeeDao.save(emp);
	}

	public Iterable<Employee> saveAll(Iterable<Employee> employees) {
		return employeeDao.saveAll(employees);

	}

	public Employee getEmployeeByName(String name) {
		return employeeDao.findByName(name);
	}

	public Double findSalaryById(Long id) {
		return employeeDao.findSalaryById(id).get();
	}

	public Iterable<Employee> getEmployeeBySalary(Double salary) {
		return employeeDao.getAllEmployeeBySalary(salary);
	}

	public Integer countByDesignation(String designation) {
		return employeeDao.countByDesignation(designation);
	}

}
