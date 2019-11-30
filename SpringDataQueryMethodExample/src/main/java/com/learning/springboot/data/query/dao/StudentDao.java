package com.learning.springboot.data.query.dao;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.learning.springboot.data.query.entity.Student;

@Repository
public interface StudentDao extends Dao<Student, Long> {

	public Student findByEnrollNo(@Param("enrollNo") Long enrollNo);

}
