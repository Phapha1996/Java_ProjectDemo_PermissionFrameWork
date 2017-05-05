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
  <%-- <body>
	<h2>当前为修改权限界面</h2><br>
	<form action="${pageContext.request.contextPath }/privileges/privilege_update">
		<input type="submit" value="修改">
	</form>
	<s:debug></s:debug>
  </body> --%>
  <body style="text-align:center;">
  	<form action="${pageContext.request.contextPath }/controller/Privilege_update" method="post">
  	<table border="1">
  		<tr>
  			<th>权限名称：</th>
  			<td><input type="text" name="privilege.name" value="<s:property value="privilege.name"/>"/></td>
  		</tr>
  		<tr>
  			<th>权限描述：</th>
  			<th><textarea rows="10" cols="50" name="privilege.discription" ><s:property value="privilege.discription"/></textarea></th>
  		</tr>
  	</table>
  	<div id="caozuo">
  		<input type="submit" value="修改"/>
  		<input type="reset" value="重置"/>
  	</div>
  	<input type="hidden" name="privilege.id" value="<s:property value="privilege.id"/>">
  	</form>
  	<s:debug></s:debug>
  </body>
  
  
</html>
