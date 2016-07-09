<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="en" xml:lang="en">
<head>
<title>添加文章</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link type="text/css" rel="stylesheet" href="../css/main.css" media="all" />
<script src="http://cdn.bootcss.com/jquery/1.9.0/jquery.js"></script>
<!--[if IE 6]><link type="text/css" rel="stylesheet" href="css/ie6.css" media="all" /><![endif]-->
<script type="text/javascript" src="../js/mootools.js"></script>
<script type="text/javascript" src="../js/site.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=basePath%>/editor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8" src="<%=basePath%>/editor/ueditor.all.min.js"> </script>
<!--建议手动加在语言，避免在ie下有时因为加载语言失败导致编辑器加载失败-->
<!--这里加载的语言文件会覆盖你在配置项目里添加的语言类型，比如你在配置项目里配置的是英文，这里加载的中文，那最后就是中文-->
<script type="text/javascript" charset="utf-8" src="<%=basePath%>/editor/lang/zh-cn/zh-cn.js"></script>
</head>
<body>
<div id="wrapper">
  <div id="container">
    <div id="scene"> <img src="../images/scene.jpg" alt="" />
      <div id="scale_area">
        <div id="scale_knob">&raquo; Font Size &laquo;</div>
      </div>
    </div>
    <div id="content">
      <div id="col_left">
        <div class="post">
          <div class="meta"></div>
          <div class="comments"><div class="comment"></div>
            <h2>添加文章</h2>
              <div>
                <label>标题：</label>
                <input id="title" type="text" name="title" />
              </div>
              <div>
                <label>内容：</label>
                <div>
    				<script id="c" type="text/plain"></script>
                </div>

              </div>
              <div>
                <label></label>
                <div class="clear"> </div>
              </div>
              <div class="button_wrapper">
                <input id="submit" name="提交" type="submit" class="button" value="提交" />
              </div>
            <script>
            	jQuery("#submit").click(function() {
            		jQuery.post("addArt.do", {content:window.ue.getContent(), title: jQuery("#title").val()}, function( response ) {
            			if(response === "true") {
            				location.href = "../index.do";
            			}
            		});
            	});
            	jQuery(function(){
			    	window.ue = UE.getEditor('c');
			    });
            </script>
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
              <li class="holder"> <a href="../index.do">文章列表</a> </li>
              <c:if test="${user==null}">
                <li class="holder"> <a href="../login.do">博客登录</a> </li>
              </c:if>
              <c:if test="${user!=null}">
                <li class="holder"> <a href="add.do">写新博客</a> </li>
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