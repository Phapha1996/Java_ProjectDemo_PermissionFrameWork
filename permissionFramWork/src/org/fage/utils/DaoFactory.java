package org.fage.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.fage.dao.AdminDao;
import org.fage.dao.PrivilegeDao;
import org.fage.dao.RoleDao;

public class DaoFactory {
	private static PrivilegeDao privilegeDao;
	private static RoleDao roleDao;
	private static AdminDao adminDao;
	static{
		try {
			InputStream in = DaoFactory.class.getClassLoader().getResourceAsStream("dao.properties");
			Properties prop = new Properties();
			prop.load(in);
			//反射读取配置文件，得到权限的dao
			privilegeDao = (PrivilegeDao) Class.forName(prop.getProperty("privilegeDao")).newInstance();
			roleDao = (RoleDao) Class.forName(prop.getProperty("roleDao")).newInstance();
			adminDao = (AdminDao) Class.forName(prop.getProperty("adminDao")).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//得到权限的dao实现
	public static PrivilegeDao getPrivilegeDao(){
		return privilegeDao;
	}
	
	public static RoleDao getRoleDao(){
		return roleDao;
	}
	
	
	public static AdminDao getAdminDao(){
		return adminDao;
	}
	
	
}
