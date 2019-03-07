package com.learning.springboot.data.query.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface Dao<T, ID extends Serializable> extends Repository<T, ID> {

	void delete(T deleted);

	Iterable<T> findAll();

	Optional<T> findById(Long id);

	T save(T save);

	<S extends T> List<S> saveAll(Iterable<S> entities);
}
