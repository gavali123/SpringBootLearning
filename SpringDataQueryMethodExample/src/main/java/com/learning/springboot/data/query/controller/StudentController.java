package com.learning.springboot.data.query.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.springboot.data.query.entity.Student;
import com.learning.springboot.data.query.service.StudentService;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping(value = "/find/{enrollNo}")
	public Student findByEnrollNO(@PathVariable("enrollNo") Long enrollNo) {
		return studentService.findByEnrollNo(enrollNo);
	}

}
