package org.fage.serviceImpl;

import org.fage.dao.AdminDao;
import org.fage.domain.Admin;
import org.fage.exception.ServiceException;
import org.fage.service.AdminService;
import org.fage.utils.DaoFactory;

public class AdminServiceImpl implements AdminService {
	
	private AdminDao dao= DaoFactory.getAdminDao();
	
	
	//��¼����
	/* (non-Javadoc)
	 * @see org.fage.serviceImpl.AdminService#loginAdmin(org.fage.domain.Admin)
	 */
	public Admin loginAdmin(Admin a) throws ServiceException{
		Admin admin = dao.get(a.getUsername(), a.getPassword(), a.getPosition());
		if(admin==null)
			throw new ServiceException("�û��������������ݴ���������ת���µ�½");
		return admin;
	}
	
	
	
}
