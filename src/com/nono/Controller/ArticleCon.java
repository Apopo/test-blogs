package com.nono.Controller;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nono.Dao.AddArt;
import com.nono.Dao.AddCommentDao;
import com.nono.Dao.GetLinks;
import com.nono.Service.GetArticalByIdService;
import com.nono.po.ArticlePo;

@Controller
@RequestMapping ("user")  
public class ArticleCon {
	
	@Autowired
	GetArticalByIdService getArticalByIdSer;
	
	@Autowired
	AddCommentDao addCommentDao;
	
	@Autowired
	GetLinks getLinks;
	
	@Autowired
	AddArt addArt;
	
	@RequestMapping(value="add", method=RequestMethod.GET) 
	public String addArticle(ServletRequest request, ServletResponse response) {
		return "addArticle";
	}

	@RequestMapping(value="show", method=RequestMethod.GET) 
	public ModelAndView showArticle(ServletRequest request, ServletResponse response) {
		ModelAndView mavAndView = new ModelAndView("showArticle");
		int articalID = Integer.parseInt( request.getParameter("aid") );
		ArticlePo articlePo = getArticalByIdSer.getByAid( articalID );
		mavAndView.addObject("art", articlePo);
		mavAndView.addObject("coms", getArticalByIdSer.getComByAid(articalID));
		mavAndView.addObject("links", getLinks.getLinks());
		return mavAndView;
	}

	@RequestMapping(value="addComment",method=RequestMethod.POST)
	@ResponseBody
	public String post(ServletRequest request, ServletResponse response) {
		String string = "false";
		String aid = request.getParameter("aid");
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		if(true == addCommentDao.addCommentDao(aid, name, content) ) {
			string = "true";
		};
		return string;
	}
	
	@RequestMapping(value="addArt",method=RequestMethod.POST)
	@ResponseBody
	public String addArt(ServletRequest request, ServletResponse response) {
		String string = "false";
		String content = request.getParameter("content");
		String title = request.getParameter("title");
		if(true == addArt.addArt(title, content) ) {
			string = "true";
		};
		return string;
	}
	
}
