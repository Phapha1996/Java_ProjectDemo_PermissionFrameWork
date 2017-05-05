<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    
    <title>更新角色</title>
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
  	<form action="${pageContext.request.contextPath }/controller/Role_update" method="post">
  	<table border="1">
  		<tr>
  			<th>角色名称：</th>
  			<td><input type="text" name="role.name" value="<s:property value="role.name"/>"/></td>
  		</tr>
  		<tr>
  			<th>角色描述：</th>
  			<th><textarea rows="10" cols="50" name="role.discription" ><s:property value="role.discription"/></textarea></th>
  		</tr>
  		<tr>
			<th>权限情况：</th>
			<th>
				<s:iterator value="#request.Qrole.privileges" var="r_pri">
						<s:property value="#r_pri.name"/><input type="checkbox" checked="checked" name="p_ids" value="<s:property value="#r_pri.id"/>">
				</s:iterator>
				<s:iterator value="#request.hasNot" var="n_pri">
					<s:property value="#n_pri.name"/><input type="checkbox" name="p_ids" value="<s:property value="#n_pri.id"/>">
				</s:iterator> 
			</th>
  		</tr>
  	</table>
  	<div id="caozuo">
  		<input type="submit" value="修改"/>
  		<input type="reset" value="重置"/>
  	</div>
  	<input type="hidden" name="role.id" value="<s:property value="role.id"/>">
  	</form>
  	<s:debug></s:debug>
  </body>
  
  
</html>
