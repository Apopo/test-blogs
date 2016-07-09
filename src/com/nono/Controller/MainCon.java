package com.nono.Controller;

import java.util.ArrayList;

import javax.naming.LinkRef;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.jsqlparser.expression.operators.arithmetic.Addition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.nono.Dao.GetLinks;
import com.nono.Service.CompareUserService;
import com.nono.Service.GetAllArticle;
import com.nono.po.ArticlePo;
import com.nono.po.Link;

@Controller
public class MainCon {
	
	@Autowired
	CompareUserService compareUserService;
	
	@Autowired
	GetAllArticle getAllArticle;

	@Autowired
	GetLinks getLinks;
	
	@RequestMapping(value="index",method = RequestMethod.GET)
	public ModelAndView index(ServletRequest request, ServletResponse response) {
		ArrayList<ArticlePo> list = getAllArticle.getAll();
		ModelAndView maView = new ModelAndView("list-index");
		maView.addObject("list", list);
		maView.addObject("links", getLinks.getLinks());
		ArrayList<Link> links = getLinks.getLinks();
		return maView;
	}

	@RequestMapping(value="login",method = RequestMethod.GET)
	public String login(ServletRequest request, ServletResponse response) {
		return "login";
	}

	@RequestMapping(value="login",method = RequestMethod.POST)
	public ModelAndView loginPost(HttpServletRequest request, HttpServletResponse response) {
		String nameString = (String)request.getParameter("username");
		String password = (String)request.getParameter("password");
		//获取session;
		HttpSession session = request.getSession(false);
		ModelAndView mav;
		Boolean boolean1 = compareUserService.isRightPassword(nameString, password);
		ArrayList<ArticlePo> list = getAllArticle.getAll();
		
		if(boolean1 == true) {
			mav = new ModelAndView("list-index");
			//设置用户名字为session;
			session.setAttribute("user", nameString);
			
			mav.addObject("list", list);
			mav.addObject("links", getLinks.getLinks());
		}else{
			mav = new ModelAndView("login"); 
			mav.addObject("state", "密码错误");
		};
		mav.addObject("links", getLinks.getLinks());
		return mav; 
	}
	
}