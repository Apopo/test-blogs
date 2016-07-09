package com.nono.Dao;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nono.po.ArticlePo;

@Repository
public class GetArticalByIdDao {
	@Autowired
	JdbcDao jdbcDao;

	public ArticlePo getById(int id) {
		ArticlePo articlePo = new ArticlePo();
		StringBuilder stringBuilder = new StringBuilder("select * from article where id = '" + id + "'");
		List<Map<String, Object>> list = jdbcDao.jdbcTemplate.queryForList(stringBuilder.toString());
		Iterator iterator = list.iterator();
		while (iterator.hasNext()) {
			Map<String, Object> map = (Map<String, Object>) iterator.next();
			articlePo.setContent((String) map.get("content"));
			articlePo.setDate((Date) map.get("date"));
			articlePo.setTitle((String) map.get("title"));
			articlePo.setUsername((String) map.get("username"));
			articlePo.setId((Integer) map.get("id"));
		}
		;
		return articlePo;
	}

}
