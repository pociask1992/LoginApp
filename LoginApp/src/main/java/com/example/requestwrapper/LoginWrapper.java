package com.example.requestwrapper;

import com.example.domain.Login;

public class LoginWrapper {

	private Login login;
	
	public LoginWrapper() {
		
	}
	
	public LoginWrapper(Login login) {
		this.login = login;
	}
	
	public void setLogin(Login login) {
		this.login = login;
	}
	
	public Login getLogin() {
		return login;
	}
}
