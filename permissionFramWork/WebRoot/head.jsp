<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>head</title>
    
	<meta http-equiv="content-type" content="text/html;charset='utf-8'">

  </head>
  
  <body>
  <br>
 
	<h1 style="text-align:center"><font color="blue">权限管理后台页面</font></h1>
  </body>
</html>
