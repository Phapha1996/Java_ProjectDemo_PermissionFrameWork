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
			//�����ȡ�����ļ����õ�ԭ��service
			PrivilegeService p_Service = (PrivilegeService) Class.forName(prop.getProperty("privilegeService")).newInstance();
			RoleService r_Service = (RoleService) Class.forName(prop.getProperty("roleService")).newInstance();
			AdminService a_Service = (AdminService)Class.forName(prop.getProperty("adminService")).newInstance();
			//��ԭ��serviceװ����AOP
			ServiceHandler handler_p = new ServiceHandler(p_Service);
			ServiceHandler handler_r = new ServiceHandler(r_Service);
			ServiceHandler handler_a = new ServiceHandler(a_Service);
			//�õ�Service���������ؾ�̬����
			privilegeService = (PrivilegeService) Proxy.
					newProxyInstance(p_Service.getClass().getClassLoader(), new Class[]{PrivilegeService.class}, handler_p);
			roleService = (RoleService) Proxy.newProxyInstance(r_Service.getClass().getClassLoader(), new Class[]{RoleService.class},handler_r);
			adminService = (AdminService)Proxy.newProxyInstance(a_Service.getClass().getClassLoader(),new Class[]{AdminService.class}, handler_a);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//�õ�Ȩ�޵�Serviceʵ��
	public static PrivilegeService getPrivilegeService(){
		return privilegeService;
	}
	
	//�õ�role��Serviceʵ��
	public static RoleService getRoleService(){
		return roleService;
	}
	//�õ�ϵͳ����Ա��ʵ��
	public static AdminService getAdminService(){
		return adminService;
	}
	
}
