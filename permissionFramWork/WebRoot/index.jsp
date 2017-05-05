<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>权限管理系统</title>
	<meta http-equiv="content-type" content="text/html;charset='utf-8'">
  </head>
	<frameset rows="20%,*">
		<frame src="head.jsp" name="head">
		<frameset cols="17%,*">
			<frame src="left.jsp" name="left">
			<frame src="body.jsp" name="body">
		</frameset>
	
	</frameset>  
</html>
