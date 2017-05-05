package org.fage.controller;

import java.util.List;
import java.util.Map;

import org.fage.domain.Privilege;
import org.fage.domain.Role;
import org.fage.exception.ServiceException;
import org.fage.service.PrivilegeService;
import org.fage.service.RoleService;
import org.fage.utils.ServiceFactory;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class RoleAction extends ActionSupport{
	
	private RoleService r_service = ServiceFactory.getRoleService();
	private PrivilegeService p_service = ServiceFactory.getPrivilegeService();
	private Map<String,Object> request = (Map<String, Object>) ActionContext.getContext().get("request");
	
	
	private Role role;
	private Privilege privilege;
	private int[] p_ids;
	
	
	
	public Privilege getPrivilege() {
		return privilege;
	}


	public void setPrivilege(Privilege privilege) {
		this.privilege = privilege;
	}


	public int[] getP_ids() {
		return p_ids;
	}


	public void setP_ids(int[] p_ids) {
		this.p_ids = p_ids;
	}


	public Role getRole() {
		return role;
	}
	

	
	public void setRole(Role role) {
		this.role = role;
	}

	//�õ����еĽ�ɫ
	public String list() throws ServiceException{
			List<Role> list = r_service.getAllRole();
			request.put("allRole", list);
		return "success";
	}


	//����һ����ɫ
	public String add()throws ServiceException{
			r_service.addRole(role, p_ids);
			//������ӳɹ������ؽ�ɫ��listҳ��
			return "page";
	}
	
	//ɾ���ļ��������Ѿ����
	public String delete() throws ServiceException{
		r_service.deleteRole(role);
		//���ɾ���ɹ������ؽ�ɫ��listҳ��
		return "page";
	}
	
	//���½�ɫ�ķ���
	public String update() throws ServiceException{
			r_service.updateRole(role, p_ids);
			//������³ɹ������ؽ�ɫ��listҳ��
			return "page";
	}
	
	//��ʾ��Ȩ��UIAction
	public String accreditUI() throws ServiceException{
			Role r = r_service.getRole(role.getId());
			request.put("role", r);
			List<Privilege> hasNot = r_service.showHasNot(r);
			request.put("hasNot", hasNot);
			return "success";
	}
	

	public String accredit() throws ServiceException{
			r_service.accredit(role, p_ids);
			//����ɹ���Ȩ��ҳ��ת����Ȩҳ��
				return "accredit";
	}
	
	public String removeRolePri(){
		//����Ƴ�Ȩ�޳ɹ���ҳ��ת����Ȩҳ��
		r_service.removePrivilege(role, privilege);
			return "accredit";
	}
	
	public String addUI() throws ServiceException{
		List<Privilege> privileges = p_service.getAllPrivilege();
		request.put("allPrivilege", privileges);
		return "success";
	}
	
	//���µ�ui����
	public String updateUI() throws ServiceException{
		Role r = r_service.getRole(role.getId());
		request.put("Qrole", r);
		List<Privilege> hasNot = r_service.showHasNot(r);
		request.put("hasNot", hasNot);
		return "success";
	}
	
}
