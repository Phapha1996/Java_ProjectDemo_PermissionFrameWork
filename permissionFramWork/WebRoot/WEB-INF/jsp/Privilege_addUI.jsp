<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>增加权限</title>
    <style type="text/css">
    	table{
			margin:100px 0px 0px 260px;
		}
		#caozuo{
			margin:10px 0px 0px 250px;
		}
    </style>
	
	<meta http-equiv="content-type" content="text/html;charset='utf-8'">

  </head>
  
 <%--  <body>
	<h2>当前为增加权限界面</h2><br>
	<form action="${pageContext.request.contextPath }/privileges/privilege_add">
		<input type="submit" value="增加">
	</form>
	<s:debug></s:debug>
  </body> --%>
  
  <body style="text-align:center;">
  	<form action="${pageContext.request.contextPath }/controller/Privilege_add" method="post">
  	<table border="1">
  		<tr>
  			<th>权限名称：</th>
  			<th><input type="text" name="privilege.name"/></th>
  		</tr>
  		<tr>
  			<th>权限描述：</th>
  			<th><textarea rows="10" cols="50" name="privilege.discription"></textarea></th>
  		</tr>
  	</table>
  	<div id="caozuo">
  		<input type="submit" value="添加"/>
  		<input type="reset" value="重置"/>
  	</div>
  	</form>
  </body>
  
</html>
