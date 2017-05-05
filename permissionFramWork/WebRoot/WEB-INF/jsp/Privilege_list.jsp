<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
   	<title>权限显示</title>
	<meta http-equiv="content-type" content="text/html;charset='utf-8'">
	<style type="text/css" >
		#table{
			margin:10px 0px 0px 260px;
		}
		a:link,a:visited{
			text-decoration:none;
			color:#004a87;
		}
		a:hover{
			color:#CCC;
			text-decoration:underline;
			color:red;
		}
		#addlink{
			width:100%;
			margin:50px 0px 0px 0px;
			padding:0px 0px 0px 130px;
		}
		h3{
			margin:0px;
			padding:0px 70px 0px 0px;
		}
	</style>

  </head>
  
  <%-- <body>
	<h2>当前得到的是所有的权限</h2><br>
	<a href="${pageContext.request.contextPath }/ui/privilegeupdate_ui">修改权限</a><br>
	<a href="${pageContext.request.contextPath }/privileges/privilege_delete">删除权限</a><br>
	<a href="${pageContext.request.contextPath }/ui/privilegeadd_ui">增加权限</a>
	<s:debug></s:debug>
  </body> --%>
  
  
  <body style="text-align:center;">
	<br><br>
	<h3>权限管理</h3>
	<div id="addlink"><a href="${pageContext.request.contextPath }/controller/Privilege_addUI">添加权限</a></div>
	<table id="table" align="center" border="1" width="500px">
		<tr>
			<th>权限名称</th>
			<th>描述</th>
			<th>添加日期</th>
			<th>操作</th>
		</tr>
		 <s:iterator value="#request.allPrivilege" var="privilege">
		<tr>
			
				<th><s:property value="#privilege.name"/></th>
				<th><s:property value="#privilege.discription"/></th>
				<th><s:property value="#privilege.createTime"/></th>
				<th>
					<a href="${pageContext.request.contextPath }/controller/Privilege_updateUI?privilege.id=<s:property value="#privilege.id"/>&privilege.name=<s:property value="#privilege.name"/>&privilege.discription=<s:property value="#privilege.discription"/>">修改</a>
					<a href="${pageContext.request.contextPath }/controller/Privilege_delete?privilege.id=<s:property value="#privilege.id"/>">删除</a>
				</th>
		</tr>
		</s:iterator> 
	</table> 		
 	 	
  </body>
  
  
  
</html>
