package com.nono.Service;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nono.Dao.GetAllArticleDao;
import com.nono.po.ArticlePo;

@Repository
public class GetAllArticle {
	@Autowired
	GetAllArticleDao getAllArticleDao;
	
	public ArrayList<ArticlePo> getAll() {
		ArrayList<ArticlePo> list = getAllArticleDao.getAll() ;
		return list;
	}
}
