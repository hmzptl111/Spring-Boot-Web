package com.login.model.persistence;

import com.login.bean.User;

public interface LoginDao {
	User login(String username, String password);
}
