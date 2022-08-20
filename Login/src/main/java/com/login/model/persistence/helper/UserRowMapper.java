package com.login.model.persistence.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.login.bean.User;

public class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		int id = resultSet.getInt("id");
		String username = resultSet.getString("username");
		String password = resultSet.getString("password");
		
		User user = new User(id, username, password);
		return user;
	}

}
