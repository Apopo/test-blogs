package com.nono.Dao;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AddArt {
	@Autowired
	JdbcDao jdbcDao;
	
	public boolean addArt(String title, String content) {

		StringBuilder stringBuilder = new StringBuilder("INSERT INTO `article` VALUES (null,'"+title+"','"+content+"','nono','"+(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(new Date())+"')");
		int flag = jdbcDao.jdbcTemplate.update( stringBuilder.toString() );
		if(flag>0) {
			return true;
		}else{
			return false;
		}	
	}
}
