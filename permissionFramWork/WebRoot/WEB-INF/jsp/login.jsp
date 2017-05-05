<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>登录</title>
    <meta http-equiv="content-type" content="text/html;charset='utf-8'" />
    <meta name="Author" content="room">
	<meta name="Keywords" content="权限管理系统"/> 	
    <meta name="direction" content="权限管理系统"/> 
    <link type="text/css" href="${pageContext.request.contextPath}/css/permission.css" rel="stylesheet"/>	
  </head>
 <body>
	<div id="container">
    	<div id="bigbox">
        	<h3>权限管理系统</h3>
            <form action="${pageContext.request.contextPath }/controller/Admin_login" method="post">
            	<div id="chioce">
                	<select name="admin.position" id="Type">
                    <option value="">请选择</option>
                    <option value="系统管理员">系统管理员</option>
                    <option value="总经理">总经理</option>
                  </select>
                </div>
            	<div id="user">
                	用户名：<input type="text" name="admin.username">
                </div>
                <div id="pwd">
                	密码：<input type="password" name="admin.password">
                </div>
                <div id="dianji">
                	<input type="submit" value="登录">
                </div>
            </form>
        </div>
    </div>
</body>
 
</html>
