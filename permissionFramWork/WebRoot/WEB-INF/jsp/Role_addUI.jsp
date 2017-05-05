<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>增加角色</title>
    <style type="text/css">
    	table{
			margin:100px 0px 0px 260px;
		}
		#caozuo{
			margin:10px 0px 0px 250px;
		}
    </style>
    
    <%-- <script type="text/javascript">
    	var checkeList = document.getElementsByName("p_ids");
    	for(var i=0;i<checkeList.length;i++){
    		if(i==3){
    		}
    	}
    </script> --%>
    
	
	<meta http-equiv="content-type" content="text/html;charset='utf-8'">

  </head>
  
 <%--  <body>
	<h2>当前为增加角色界面</h2><br>
	<form action="${pageContext.request.contextPath }/privileges/privilege_add">
		<input type="submit" value="增加">
	</form>
	<s:debug></s:debug>
  </body> --%>
  
  <body style="text-align:center;">
  	<form action="${pageContext.request.contextPath }/controller/Role_add" method="post">
  	<table border="1">
  		<tr>
  			<th>角色名称：</th>
  			<th><input type="text" name="role.name"/></th>
  		</tr>
  		<tr>
  			<th>角色描述：</th>
  			<th><textarea rows="10" cols="50" name="role.discription"></textarea></th>
  		</tr>
  		<tr>
  			<th>赋予权限：</th>
  			<th>
  			<s:iterator value="#request.allPrivilege" var="privilege">
  				<s:property value="#privilege.name"/><input type="checkbox" class="priCheckbox" name="p_ids" value="<s:property value="#privilege.id"/>"/>
  			</s:iterator>
  			</th>
  		</tr>
  	</table>
  	<div id="caozuo">
  		<input type="submit" value="添加"/>
  		<input type="reset" value="重置"/>
  	</div>
  	</form>
  </body>
  
</html>
