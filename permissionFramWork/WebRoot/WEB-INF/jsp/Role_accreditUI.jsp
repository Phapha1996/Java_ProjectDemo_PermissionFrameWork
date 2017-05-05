<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s"  uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>为某个角色授权</title>
    
	<meta http-equiv="content-type" content="text/html;charset='utf-8'">
	<style type="text/css">
	table{
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
		h3{
			margin:0px;
			padding:0px 70px 0px 0px;
		}
	
	</style>	

  </head>
  
  <%-- <body>
    这里是为角色授权的界面
    <a href="${pageContext.request.contextPath }/controller/Role_accredit">授权</a>
  </body> --%>
  
   <body style="text-align:center">
  <br><br><br>
  	<h3>角色授权</h3>
  <br>
  	<form action="${pageContext.request.contextPath }/controller/Role_accredit" method="post">
  	<table  border="1" width="500px">
  		<tr>
  			<td>角色名称：</td>
  			<th><s:property value="#request.role.name"/></th>
  		</tr>
  		<tr>
  			<td>角色拥有权限：</td>
  			<th>
  				<s:iterator value="#request.role.privileges" var="privilege">
  					<s:property value="#privilege.name"/>&nbsp<a href="${pageContext.request.contextPath }/controller/Role_removeRolePri?role.id=<s:property value="#request.role.id"/>&privilege.id=<s:property value="#privilege.id"/>">取消权限</a><br>
  				</s:iterator>
  			</th>
  		</tr>
  		<tr>
  			<td>还未拥有的权限：</td>
  			<th>
 	 			<s:iterator value="#request.hasNot" var="Nprivilege">
  					<s:property value="#Nprivilege.name"/><input type="checkbox" name="p_ids" value="<s:property value="#Nprivilege.id"/>"><br>
  				</s:iterator>
  				<br>
  				<input type="submit" value="确定授权">
  			</th>
  		</tr>
  	</table>
  	<input type="hidden" name="role.id" value="<s:property value="#request.role.id"/>">
  	<br>
  	</form>
  </body>
  
  
  
</html>
