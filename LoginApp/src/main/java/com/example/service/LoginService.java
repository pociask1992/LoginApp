package com.example.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.domain.Login;
import com.example.repository.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	LoginRepository loginRepository;

	@Transactional
	public boolean addLogin(Login login) {
		List<Login> logins = new ArrayList<>();
		logins = loginRepository.findAll();
		boolean isOccurs = false;
		for(Login l : logins) {
			if(l.getLogin().equals(login.getLogin())) {
				isOccurs = true;
			}
		}	
		
		if(isOccurs == false) {
			loginRepository.save(login);
			return true;
		}
		else 
			return false;

	}
	
	@Transactional
	public ResponseEntity<Login> deleteLogin(Long id) {
		Login login = loginRepository.findById(id);
		if(login.getLogin_id() > -1) {
			loginRepository.delete(id);
			return new ResponseEntity<Login>(login, HttpStatus.OK);
		}
		else 
			return new ResponseEntity<Login>(login, HttpStatus.NOT_FOUND);
	}
	
	@Transactional
	public ResponseEntity<Login> updateLogin(Login login) {
		if(login == null) {
			return new ResponseEntity<Login>(login, HttpStatus.NOT_FOUND);
		} 
		else {
			loginRepository.save(login);
			return new ResponseEntity<Login>(login, HttpStatus.OK);
		}
	}
	
	
}
