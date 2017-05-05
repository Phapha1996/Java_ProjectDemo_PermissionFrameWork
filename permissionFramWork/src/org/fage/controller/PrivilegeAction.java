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

	
	//�õ�Ŀǰ���е�Ȩ��
	public String list() throws ServiceException{
		List<Privilege> privileges;
			privileges = service.getAllPrivilege();
			request.put("allPrivilege", privileges);
			return "success";
	}
	
	
	//����һ��Ȩ��
	public String add() throws ServiceException{
			service.addPrivilege(privilege);
			//������ӳɹ�����ʾ��listҳ��
			return "page";
	}

	
	//ɾ��һ��Ȩ��,�����ڲ��ҳ����Ĳ�ɾ���ģ����յĳɹ���
	public String delete() throws ServiceException{
			service.deletePrivilege(privilege);
			//������ʾ���ͻ��˿�
			return "page";
	}
	
	
	//����Ȩ��
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
	
	
	//�õ�����Ȩ��
	public String get(){
		return "success";
	}
	
	
}
