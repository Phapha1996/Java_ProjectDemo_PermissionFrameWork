package org.fage.serviceImpl;

import org.fage.dao.AdminDao;
import org.fage.domain.Admin;
import org.fage.exception.ServiceException;
import org.fage.service.AdminService;
import org.fage.utils.DaoFactory;

public class AdminServiceImpl implements AdminService {
	
	private AdminDao dao= DaoFactory.getAdminDao();
	
	
	//登录功能
	/* (non-Javadoc)
	 * @see org.fage.serviceImpl.AdminService#loginAdmin(org.fage.domain.Admin)
	 */
	public Admin loginAdmin(Admin a) throws ServiceException{
		Admin admin = dao.get(a.getUsername(), a.getPassword(), a.getPosition());
		if(admin==null)
			throw new ServiceException("用户名、密码或者身份错误！两秒跳转从新登陆");
		return admin;
	}
	
	
	
}
