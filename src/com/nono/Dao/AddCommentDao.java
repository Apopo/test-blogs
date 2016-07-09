package com.nono.Dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AddCommentDao {
	@Autowired
	JdbcDao jdbcDao;
	public boolean addCommentDao(String aid, String username, String content) {
		StringBuilder stringBuilder = new StringBuilder("INSERT INTO critique VALUES (null, "+ Integer.parseInt(aid) +", '"+content+"', '"+username+"')");
		int flag = jdbcDao.jdbcTemplate.update( stringBuilder.toString() );
		if(flag>0) {
			return true;
		}else{
			return false;
		}
	}
}
