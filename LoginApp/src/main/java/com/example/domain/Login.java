package com.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "LOGIN")
public class Login {

	@Id
	@Column(name = "LOGIN_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_login")
	@SequenceGenerator(name = "seq_login", sequenceName = "SEQ_LOGIN_ID")
	private Long id;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "LOGIN")
	private String login;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "PASSWORD")
	private String password;
	
	@Column(name = "SURNAME")
	private String surname;
	
	public String getEmail() {
		return email;
	}
	public String getLogin() {
		return login;
	}
	public Long getLogin_id() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPassword() {
		return password;
	}
	public String getSurname() {
		return surname;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public void setLogin_id(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
}
