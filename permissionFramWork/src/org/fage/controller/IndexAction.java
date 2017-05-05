package org.fage.controller;

import java.util.Map;

import org.fage.exception.ServiceException;

import com.opensymphony.xwork2.ActionContext;

public class IndexAction {
	private Map<String,Object> session = ActionContext.getContext().getSession();
	
	public String execute() throws ServiceException{
		if(session.get("admin")==null)
			throw new ServiceException("«Îµ«¬º¡À‘Ÿ¿¥°£");
		return "success";
	}
	
}
