package org.fage.service;

import java.util.List;

import org.fage.domain.Privilege;
import org.fage.exception.ServiceException;

public interface PrivilegeService {

	//增加用户
	public void addPrivilege(Privilege p)throws ServiceException;

	//删除一个privilege(注意，privilege与role有级联，删除privilege需要先解除级联，剔除中间表，才能删除privilege)
	public void deletePrivilege(Privilege p)throws ServiceException;

	//修改权限，单纯修改不涉及级联
	public void updatePrivilege(Privilege p)throws ServiceException;

	//直接根据id拿出一个权限
	public Privilege getPrivilege(int id);

	//得到所有的权限
	public List<Privilege> getAllPrivilege()throws ServiceException;

}