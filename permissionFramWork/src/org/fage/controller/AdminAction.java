package org.fage.controller;

import java.util.Map;

import org.fage.domain.Admin;
import org.fage.exception.ServiceException;
import org.fage.service.AdminService;
import org.fage.utils.ServiceFactory;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport{
	private AdminService service = ServiceFactory.getAdminService();
	private Map<String,Object> session = ActionContext.getContext().getSession();
	private Admin admin;
	
	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String login() throws ServiceException{
		session.put("admin",service.loginAdmin(admin));
		return "index";
	}
	
}
