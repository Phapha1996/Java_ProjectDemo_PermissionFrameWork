package org.fage.service;

import org.fage.domain.Admin;
import org.fage.exception.ServiceException;

public interface AdminService {

	//��¼����
	public Admin loginAdmin(Admin a) throws ServiceException;

}