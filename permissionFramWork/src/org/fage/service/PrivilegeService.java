package org.fage.service;

import java.util.List;

import org.fage.domain.Privilege;
import org.fage.exception.ServiceException;

public interface PrivilegeService {

	//�����û�
	public void addPrivilege(Privilege p)throws ServiceException;

	//ɾ��һ��privilege(ע�⣬privilege��role�м�����ɾ��privilege��Ҫ�Ƚ���������޳��м������ɾ��privilege)
	public void deletePrivilege(Privilege p)throws ServiceException;

	//�޸�Ȩ�ޣ������޸Ĳ��漰����
	public void updatePrivilege(Privilege p)throws ServiceException;

	//ֱ�Ӹ���id�ó�һ��Ȩ��
	public Privilege getPrivilege(int id);

	//�õ����е�Ȩ��
	public List<Privilege> getAllPrivilege()throws ServiceException;

}