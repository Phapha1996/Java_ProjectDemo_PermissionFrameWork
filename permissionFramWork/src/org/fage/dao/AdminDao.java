package org.fage.dao;

import org.fage.domain.Admin;

public interface AdminDao {

	public Admin get(String username,String password,String position);
	
}
