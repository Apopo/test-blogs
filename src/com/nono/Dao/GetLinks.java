package com.nono.Dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import com.nono.po.ArticlePo;
import com.nono.po.Link;

@Repository
public class GetLinks {
	@Autowired
	JdbcDao jdbcDao;
	
	public ArrayList<Link> getLinks () {
		ArrayList<Link> links = new ArrayList<Link>();
		StringBuilder stringBuilder = new StringBuilder("select * from links ");
		List<Map<String,Object>> list = jdbcDao.jdbcTemplate.queryForList( stringBuilder.toString() );
		Iterator iterator = list.iterator();
		while(iterator.hasNext()) {
			Map<String, Object> map = (Map<String, Object>) iterator.next();
			Link link = new Link();
			link.setName( (String)map.get("name") );
			link.setUrl( (String)map.get("url") );
			links.add( link );
		};
		return links;
	}
	
}
