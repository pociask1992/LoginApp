package com.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.domain.Login;

public interface LoginRepository extends CrudRepository<Login, Long>{

	List<Login> findAll();
	Login findById(@Param("id") Long id);
	List<Login> findByLogin(@Param("login") String login);
	List<Login> findByName(@Param("name") String name);
	List<Login> findBySurname(@Param("surname") String surname);
	List<Login> findByNameAndSurname(@Param("name") String name,
			@Param("surname") String surname);
	List<Login> findByNameAndSurnameAndLogin(@Param("name") String name,
			@Param("surname") String surname, @Param("login") String login);
}
