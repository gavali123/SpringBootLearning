package com.learning.springboot.data.repository.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.springboot.data.repository.dao.EmployeeDao;
import com.learning.springboot.data.repository.entity.Employee;

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

}
