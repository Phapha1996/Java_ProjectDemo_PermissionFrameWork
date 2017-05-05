package org.fage.service;

import org.fage.domain.Admin;
import org.fage.exception.ServiceException;

public interface AdminService {

	//µÇÂ¼¹¦ÄÜ
	public Admin loginAdmin(Admin a) throws ServiceException;

}