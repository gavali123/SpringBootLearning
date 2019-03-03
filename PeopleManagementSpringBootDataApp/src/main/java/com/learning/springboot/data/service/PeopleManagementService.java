package com.learning.springboot.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.springboot.data.dao.PeopleManagementDao;
import com.learning.springboot.data.entity.Person;

@Service
public class PeopleManagementService {

	@Autowired
	private PeopleManagementDao peopleManagementDao;

	public Person create(Person person) {
		return peopleManagementDao.save(person);
	}

}
