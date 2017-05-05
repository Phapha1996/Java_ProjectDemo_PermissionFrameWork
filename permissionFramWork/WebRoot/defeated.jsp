<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'defeated.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="content-type" content="text/html;charset='utf-8'">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	function pose(){
		var message = document.getElementById("message").innerHTML;
		if(message=="用户名、密码或者身份错误！两秒跳转从新登陆"){
			document.getElementById("content").innerHTML = "如果没有跳转，请点击<a href='http://localhost:8080/permissionFramWork'>登陆</a>";
			setTimeout("javascript:window.location.href='http://localhost:8080/permissionFramWork'",2000);
		}
	}
	</script>
	
  </head>
  
  <body onload="pose()">
  <%-- 	<s:property value="errors.defeatedMessage[0]"/> --%>
    	<h3 align="left"><font color="red"><div id="message"><s:property value="exception.message"/></div><div id="content"></div></font></h3>
	<s:debug></s:debug>
  </body>
</html>
