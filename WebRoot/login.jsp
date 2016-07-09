<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>
<title>博客系统登录</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" rel="stylesheet" href="css/main.css" media="all" />
<!--[if IE 6]><link type="text/css" rel="stylesheet" href="css/ie6.css" media="all" /><![endif]-->
<script type="text/javascript" src="js/mootools.js"></script>
<script type="text/javascript" src="js/site.js"></script>
</head>
<body>
<div id="wrapper">
  <div id="container">
    <div id="scene"> <img src="images/scene.jpg" alt="" />
      <div id="scale_area">
        <div id="scale_knob">&raquo; Font Size &laquo;</div>
      </div>
    </div>
    <div id="content">
      <div id="col_left">
        <div class="post">
          <div class="meta"></div>
          <div class="comments"><div class="comment"></div>
            <h2>博客登录</h2>
            <form class="h" method="post">
            	<p>
            	${state}
            	</p>
              <div>
                <label>用户名:</label>
                <input type="text" name="username" />
              </div>
              <div>
                <label>密码:</label>
                <input type="password" name="password" />
              </div>
              <div>
                <label></label>
                <div class="clear"> </div>
              </div>
              <div class="button_wrapper">
                <input name="提交" type="submit" class="button" value="登录" />
              </div>
            </form>
          </div>
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