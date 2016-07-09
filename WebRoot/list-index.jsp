<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>
<title>博客系统首页</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" rel="stylesheet" href="css/main.css" media="all" />
<!--[if IE 6]><link type="text/css" rel="stylesheet" href="css/ie6.css" media="all" /><![endif]-->
<script type="text/javascript" src="js/mootools.js"></script>
<script type="text/javascript" src="js/site.js"></script>
</head>
<body>
<div id="wrapper">
  <div id="container">
    <div id="scene">
      <img src="images/scene.jpg" alt="" />
      <div id="scale_area">
        <div id="scale_knob">&raquo; Font Size &laquo;</div>
      </div>
    </div>
    <div id="content">
      <div id="col_left">
        <div class="post">
          <div class="meta"><a class="title" href="">博客系统首页</a>
            <div class="clear"></div>
          </div>
        <!-- 循环输出 -->
		
        <c:forEach items="${list}" var="item">
         
          <div class="comments">
            <div class="comment">
              <div class="meta"> <span><a href="user/show.do?aid=${item.id}">${item.title}</a> <small>:</small></span>
                <div class="clear"> </div>
              </div>
              <div>
              	${item.content}
              </div>
            </div>
            <div class="comment alt">
              <div class="meta"><span class="datetime">
              	<!-- 发表时间 -->
					发表于:
					${item.date}
              </span>
                <div class="clear"> </div>
              </div>
            </div>
          </div>
          
        </c:forEach>
        
        </div>
      </div>
      <div id="col_right">
        <div id="links">
			<c:forEach items="${links}" var="item">
				<a href="${item.url}"> ${item.name} </a>
			</c:forEach>
        </div>
        <div id="sidebar">
          <h2>页面导航</h2>
          <ul>
              <li class="holder"> <a href="index.do">文章列表</a> </li>
              <c:if test="${user==null}">
                <li class="holder"> <a href="login.do">博客登录</a> </li>
              </c:if>
              <c:if test="${user!=null}">
                <li class="holder"> <a href="user/add.do">写新博客</a> </li>
              </c:if>
          </ul>
        </div>
      </div>
      <div class="clear"> </div>
    </div>
    <div id="footer">
      <div class="clear"> </div>
      <hr />
      <p class="credit">博客网站系统</p>
    </div>
  </div>
</div>
</body>
</html>