package org.fage.service;

import java.util.List;

import org.fage.domain.Privilege;
import org.fage.domain.Role;
import org.fage.exception.ServiceException;

public interface RoleService {

	//得到所有的角色
	public List<Role> getAllRole()throws ServiceException;

	//增加角色
	public void addRole(Role role, int[] p_ids)throws ServiceException;

	public void deleteRole(Role r)throws ServiceException;

	public void updateRole(Role r, int[] p_ids)throws ServiceException;

	//授权操作
	public void accredit(Role r, int[] p_ids)throws ServiceException;

	public Role getRole(int id)throws ServiceException;

	//显示当前角色还未拥有的权限
	public List<Privilege> showHasNot(Role r);

	//取消权限操作
	public void removePrivilege(Role r, Privilege p);

}