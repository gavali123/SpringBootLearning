package com.learning.springboot.data.repository.dao;

import org.springframework.stereotype.Repository;

import com.learning.springboot.data.repository.entity.Employee;

@Repository
public interface EmployeeDao extends Dao<Employee, Long> {

}
