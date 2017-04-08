package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Login;
import com.example.repository.LoginRepository;
import com.example.service.LoginService;

@RequestMapping("/login")
@RestController
public class LoginController {

	@Autowired
	LoginRepository loginRepository;
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping("/getAll")
	public List<Login> findAll() {
		return loginRepository.findAll();
	}

	@RequestMapping(value = "/getByLogin/{login}", method = RequestMethod.GET)
	public List<Login>findByLogin(@PathVariable String login) {
		return loginRepository.findByLogin(login);
	}
	
	@RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
	public Login findById(@PathVariable Long id) {
		return loginRepository.findById(id);
	}
	
	@RequestMapping(value = "/getByName/{name}", method = RequestMethod.GET)
	public List<Login> findByName(@PathVariable("name") String name) {
		return loginRepository.findByName(name);
	}
	
	@RequestMapping(value = "/getBySurname/{surname}", method = RequestMethod.GET)
	public List<Login> findBySurname(@PathVariable("surname") String surname) {
		return loginRepository.findBySurname(surname);
	}
	
	@RequestMapping(value = "/getByNameSurname/{name}/{surname}" ,
			method = RequestMethod.GET)
	public List<Login> findByNameSurname(@PathVariable("name") String name,
			@PathVariable("surname") String surname) {
		return loginRepository.findByNameAndSurname(name, surname);
	}
	
	@RequestMapping(value = "/getByNameSurnameLogin/{name}/{surname}/{login}")
	public List<Login> findByNameSurnameLogin(@PathVariable("name") String name,
			@PathVariable("surname") String surname, 
			@PathVariable("login") String login) {
		return loginRepository.findByNameAndSurnameAndLogin(name, surname, login);
	}
	
	@RequestMapping(value = "/addLogin", method = RequestMethod.POST)
	public ResponseEntity<Login> addLogin(@RequestBody Login login) {
		boolean added = loginService.addLogin(login);
		if(added) {
			return new ResponseEntity<Login>(login, HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<Login>(login, HttpStatus.EXPECTATION_FAILED);
		}
		
	}
	
	@RequestMapping(value = "/deleteLogin/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Login> delete(@PathVariable("id") Long id) {
		 return loginService.deleteLogin(id);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public ResponseEntity<Login> update(@RequestBody Login login) {
		 return loginService.updateLogin(login);
	}
	
}
