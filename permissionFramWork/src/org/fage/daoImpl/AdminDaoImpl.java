package org.fage.daoImpl;

import org.fage.dao.AdminDao;
import org.fage.domain.Admin;
import org.fage.utils.SessionUtils;

public class AdminDaoImpl implements AdminDao{

	@Override
	public Admin get(String username,String password,String position) {
		
		return (Admin) SessionUtils.getCurrentSession().createQuery("from Admin a where username=? and password=? and position=?")
			.setString(0, username).setString(1, password).setString(2, position).uniqueResult();
		
	}
	
}
