package com.learning.springboot.data.dao;

import org.springframework.data.repository.CrudRepository;

import com.learning.springboot.data.entity.Person;

public interface PeopleManagementDao extends CrudRepository<Person, Integer> {

}
