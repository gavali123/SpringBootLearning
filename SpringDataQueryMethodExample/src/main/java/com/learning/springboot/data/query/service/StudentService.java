package com.learning.springboot.data.query.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.springboot.data.query.dao.StudentDao;
import com.learning.springboot.data.query.entity.Student;

@Service
public class StudentService {

	@Autowired
	private StudentDao studentDao;

	public Student findByEnrollNo(Long enrollNo) {
		return studentDao.findByEnrollNo(enrollNo);
	}

	public void save(Student stud) {
		studentDao.save(stud);
	}
}
