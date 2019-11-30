package com.learning.springboot.data.query.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.learning.springboot.data.query.entity.Employee;

@Repository
public interface EmployeeDao extends Dao<Employee, Long> {

	public Employee findByName(String name);
	
	public Integer countByDesignation(String designation);

	@Query("SELECT e.salary FROM Employee e WHERE e.empId = :id")
	public Optional<Double> findSalaryById(@Param("id") Long id);

	@Query(value = "SELECT * FROM employee e WHERE e.salary > :salary", nativeQuery = true)
	public Iterable<Employee> getAllEmployeeBySalary(@Param("salary") Double salary);

}
