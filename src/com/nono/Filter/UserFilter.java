package com.nono.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nono.po.User;

public class UserFilter extends HttpServlet implements Filter {
    private static final long serialVersionUID = 1L;

    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {
           HttpServletRequest request=(HttpServletRequest)arg0;   
           HttpServletResponse response  =(HttpServletResponse) arg1;    
           HttpSession session = request.getSession(false);
           String user = null;
           if(session!=null){
        	   user =  (String)session.getAttribute("user");
           };
           String url=request.getRequestURI();
           
           //如果user为空而且进入的是新增文章的界面就跳到登录界面;
           if( user==null  && url.indexOf("add.do")>-1 ) {
        	   response.sendRedirect(request.getContextPath() + "/login.do");
               return;
           }else{
        	   //为请求添加user属性;
        	   request.setAttribute("user", user);
               arg2.doFilter(arg0, arg1);
        	   return;
           }
    }
    public void init(FilterConfig arg0) throws ServletException {
    }

}