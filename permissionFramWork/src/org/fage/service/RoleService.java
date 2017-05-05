package org.fage.service;

import java.util.List;

import org.fage.domain.Privilege;
import org.fage.domain.Role;
import org.fage.exception.ServiceException;

public interface RoleService {

	//�õ����еĽ�ɫ
	public List<Role> getAllRole()throws ServiceException;

	//���ӽ�ɫ
	public void addRole(Role role, int[] p_ids)throws ServiceException;

	public void deleteRole(Role r)throws ServiceException;

	public void updateRole(Role r, int[] p_ids)throws ServiceException;

	//��Ȩ����
	public void accredit(Role r, int[] p_ids)throws ServiceException;

	public Role getRole(int id)throws ServiceException;

	//��ʾ��ǰ��ɫ��δӵ�е�Ȩ��
	public List<Privilege> showHasNot(Role r);

	//ȡ��Ȩ�޲���
	public void removePrivilege(Role r, Privilege p);

}