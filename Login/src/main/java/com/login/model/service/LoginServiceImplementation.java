package com.login.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.login.model.persistence.LoginDao;

@Service
public class LoginServiceImplementation implements LoginService {
	@Autowired
	private LoginDao loginDao;

	@Override
	public boolean login(String username, String password) {
		if(loginDao.login(username, password) == null) return false;
		
		return true;
	}
}