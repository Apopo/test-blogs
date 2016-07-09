package com.nono.Dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nono.po.Comment;

@Repository
public class GetComByAidDao {
	@Autowired
	JdbcDao jdbcDao;
	public ArrayList<Comment> getById( int id ) {
		ArrayList<Comment> result = new ArrayList<Comment>();
		StringBuilder stringBuilder = new StringBuilder( "select * from critique where aId = '"+  id +"'" );
		List<Map<String, Object>> list = jdbcDao.jdbcTemplate.queryForList( stringBuilder.toString() );
		Iterator iterator = list.iterator();
		while( iterator.hasNext() ) {
			Map<String, Object> map = (Map<String, Object>) iterator.next();
			Comment comment = new Comment();
			comment.setContent( (String)map.get("content") );
			comment.setUsername( (String)map.get("username") );
			result.add( comment );
		};
		return result;
	}
}
