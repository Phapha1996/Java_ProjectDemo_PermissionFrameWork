package org.fage.service.test;

import java.lang.reflect.Proxy;
import java.util.Date;

import org.fage.domain.Privilege;
import org.fage.exception.DaoException;
import org.fage.service.PrivilegeService;
import org.fage.serviceImpl.PrivilegeServiceImpl;
import org.fage.serviceImpl.ServiceHandler;
import org.fage.utils.ServiceFactory;
import org.junit.Test;

public class TestPrivilegeService {
	@Test
	public void testadd(){
		/*PrivilegeService s = new PrivilegeServiceImpl();
		ServiceHandler sh = new ServiceHandler(s);
		PrivilegeService service = (PrivilegeService) Proxy.newProxyInstance(s.getClass().getClassLoader(), new Class[]{PrivilegeService.class}, sh);
		
		try{
			Privilege p = service.loadPrivilege(2);
			
		}catch(Exception e){
			System.out.println("ʧ��");
			e.printStackTrace();
		}*/
		
		/*Privilege p = new Privilege();
		p.setName("�¼���Ʒ");
		p.setDiscription("�¼�һ����Ʒ");
		p.setCreateTime(new Date());*/
//		PrivilegeService ps = ServiceFactory.getPrivilegeService();
//		ps.addPrivilege(p);
//		ps.loadPrivilege(4);
		
	}
	
	@Test
	//��������һ��Ȩ��
	public void testAdd(){
		Privilege p = new Privilege();
		p.setName("������Ʒ");
		p.setDiscription("��������һ����Ʒ");
		p.setCreateTime(new Date());
		ServiceFactory.getPrivilegeService().addPrivilege(p);
	}
	
	@Test
	public void testupdate(){
		
		Privilege p = new Privilege();
		p.setId(3);
		p.setName("ɾ����Ʒ");
		p.setDiscription("ɾ��һ����Ʒ");
		ServiceFactory.getPrivilegeService().updatePrivilege(p);
		
	}
	
	@Test
	//���Եõ����е�Ȩ��
	public void testGetAll(){
		
		System.out.println(ServiceFactory.getPrivilegeService().getAllPrivilege().size());
		
	}
	
	@Test
	public void testGet(){
		System.out.println(ServiceFactory.getPrivilegeService().getPrivilege(2));
	}
	
	
	
	
	
}
