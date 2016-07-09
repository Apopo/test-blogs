package com.nono.Dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class GetPasswordByUserName {
	@Autowired
	JdbcDao jdbcDao;
	public String getPassword(String username) {
		
		String str = "";
		
		StringBuilder sqlString = new StringBuilder( "select * from user where username='"+username+"'");
		
		List<Map<String,Object>> list = jdbcDao.jdbcTemplate.queryForList( sqlString.toString() );
		
		Iterator iterator = list.iterator();
		
		while(iterator.hasNext()) {
			
			str = (String)((Map)iterator.next()).get("username");
			
		};
		
		return str;
	}
}
