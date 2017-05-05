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
   	<title>角色显示</title>
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
	<h2>当前得到的是所有的角色</h2><br>
	<a href="${pageContext.request.contextPath }/ui/roleupdate_ui">修改角色</a><br>
	<a href="${pageContext.request.contextPath }/ui/accredit_ui">为角色授权</a><br>
	<a href="${pageContext.request.contextPath }/controller/Role_delete">删除角色</a><br>
	<a href="${pageContext.request.contextPath }/ui/roleadd_ui">增加角色</a>
	<s:debug></s:debug>
  </body> --%>
  
  
<body style="text-align:center;">
	<br><br>
	<h3>职位角色管理</h3>
	<div id="addlink"><a href="${pageContext.request.contextPath }/controller/Role_addUI">添加职位角色</a></div>
	<table id="table" align="center" border="1" width="500px">
		<tr>
			<th>角色名称</th>
			<th>描述</th>
			<th>操作</th>
		</tr>
		 <s:iterator value="#request.allRole" var="role">
		<tr>
			
				<th><s:property value="#role.name"/></th>
				<th><s:property value="#role.discription"/></th>
				<th>
					<a href="${pageContext.request.contextPath }/controller/Role_updateUI?role.id=<s:property value="#role.id"/>&role.name=<s:property value="#role.name"/>&role.discription=<s:property value="#role.discription"/>">修改</a>
					<a href="${pageContext.request.contextPath }/controller/Role_delete?role.id=<s:property value="#role.id"/>">删除</a>
					<a href="${pageContext.request.contextPath }/controller/Role_accreditUI?role.id=<s:property value="#role.id"/>">授权</a>
				</th>
		</tr>
		</s:iterator> 
	</table> 		
 	 	
  </body>
  
  
  
</html>
