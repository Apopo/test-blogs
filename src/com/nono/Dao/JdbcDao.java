package com.nono.Dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcDao {
	public JdbcTemplate jdbcTemplate;
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	public void setJdbcTemplate ( JdbcTemplate jdbcTemplate ){
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public static void main(String args[]) {
	}
}
