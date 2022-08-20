package com.login.model.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.login.bean.User;
import com.login.model.persistence.helper.UserRowMapper;

@Repository
public class LoginDaoImplementation implements LoginDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public User login(String username, String password) {
		User user = null;
		try {
			String query = "select * from users where username = ? and password = ?";
			user = jdbcTemplate.queryForObject(query, new UserRowMapper(), username, password);
		} catch(org.springframework.dao.EmptyResultDataAccessException e) {
			return user;
		}
		return user;
	}
}