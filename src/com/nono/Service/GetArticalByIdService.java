package com.nono.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nono.Dao.GetArticalByIdDao;
import com.nono.Dao.GetComByAidDao;
import com.nono.po.ArticlePo;
import com.nono.po.Comment;

@Repository
public class GetArticalByIdService {
	@Autowired
	GetArticalByIdDao getArticalByIdDao;

	@Autowired
	GetComByAidDao getComByAidDao;

	public ArticlePo getByAid(int aid) {
		return getArticalByIdDao.getById(aid);
	}

	public ArrayList<Comment> getComByAid(int aId) {
		return getComByAidDao.getById(aId);
	}
}
