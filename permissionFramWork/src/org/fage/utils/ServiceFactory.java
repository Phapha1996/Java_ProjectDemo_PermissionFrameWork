package org.fage.utils;

import java.io.InputStream;
import java.lang.reflect.Proxy;
import java.util.Properties;

import org.fage.service.AdminService;
import org.fage.service.PrivilegeService;
import org.fage.service.RoleService;
import org.fage.serviceImpl.ServiceHandler;

public class ServiceFactory {
	private static PrivilegeService privilegeService;
	private static RoleService roleService;
	private static AdminService adminService;
	
	static{
		try {
			InputStream in = DaoFactory.class.getClassLoader().getResourceAsStream("service.properties");
			Properties prop = new Properties();
			prop.load(in);
			//反射读取配置文件，得到原生service
			PrivilegeService p_Service = (PrivilegeService) Class.forName(prop.getProperty("privilegeService")).newInstance();
			RoleService r_Service = (RoleService) Class.forName(prop.getProperty("roleService")).newInstance();
			AdminService a_Service = (AdminService)Class.forName(prop.getProperty("adminService")).newInstance();
			//将原生service装载入AOP
			ServiceHandler handler_p = new ServiceHandler(p_Service);
			ServiceHandler handler_r = new ServiceHandler(r_Service);
			ServiceHandler handler_a = new ServiceHandler(a_Service);
			//得到Service代理对象给回静态属性
			privilegeService = (PrivilegeService) Proxy.
					newProxyInstance(p_Service.getClass().getClassLoader(), new Class[]{PrivilegeService.class}, handler_p);
			roleService = (RoleService) Proxy.newProxyInstance(r_Service.getClass().getClassLoader(), new Class[]{RoleService.class},handler_r);
			adminService = (AdminService)Proxy.newProxyInstance(a_Service.getClass().getClassLoader(),new Class[]{AdminService.class}, handler_a);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//得到权限的Service实现
	public static PrivilegeService getPrivilegeService(){
		return privilegeService;
	}
	
	//得到role的Service实现
	public static RoleService getRoleService(){
		return roleService;
	}
	//得到系统管理员的实现
	public static AdminService getAdminService(){
		return adminService;
	}
	
}
