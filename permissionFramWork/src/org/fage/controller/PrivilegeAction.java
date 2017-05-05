package org.fage.controller;

import java.util.List;
import java.util.Map;

import org.fage.domain.Privilege;
import org.fage.exception.ServiceException;
import org.fage.service.PrivilegeService;
import org.fage.utils.ServiceFactory;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PrivilegeAction extends ActionSupport{
	private PrivilegeService service = ServiceFactory.getPrivilegeService();
	private Map<String,Object> request = (Map<String, Object>) ActionContext.getContext().get("request");

	
	private Privilege privilege;
	public Privilege getPrivilege() {
		return privilege;
	}
	public void setPrivilege(Privilege privilege) {
		this.privilege = privilege;
	}

	
	//得到目前所有的权限
	public String list() throws ServiceException{
		List<Privilege> privileges;
			privileges = service.getAllPrivilege();
			request.put("allPrivilege", privileges);
			return "success";
	}
	
	
	//增加一个权限
	public String add() throws ServiceException{
			service.addPrivilege(privilege);
			//如果增加成功，显示回list页面
			return "page";
	}

	
	//删除一个权限,由于在查找出来的才删除的，保险的成功。
	public String delete() throws ServiceException{
			service.deletePrivilege(privilege);
			//重新显示给客户端看
			return "page";
	}
	
	
	//更新权限
	public String update() throws ServiceException{
			service.updatePrivilege(privilege);
			return "page";
	}
	
	
	public String addUI(){
		return "success";
	}
	
	
	public String updateUI(){
		return "success";
	}
	
	
	//得到单个权限
	public String get(){
		return "success";
	}
	
	
}
