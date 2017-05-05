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
			System.out.println("失败");
			e.printStackTrace();
		}*/
		
		/*Privilege p = new Privilege();
		p.setName("下架商品");
		p.setDiscription("下架一款商品");
		p.setCreateTime(new Date());*/
//		PrivilegeService ps = ServiceFactory.getPrivilegeService();
//		ps.addPrivilege(p);
//		ps.loadPrivilege(4);
		
	}
	
	@Test
	//测试增加一个权限
	public void testAdd(){
		Privilege p = new Privilege();
		p.setName("增加商品");
		p.setDiscription("可以增加一个商品");
		p.setCreateTime(new Date());
		ServiceFactory.getPrivilegeService().addPrivilege(p);
	}
	
	@Test
	public void testupdate(){
		
		Privilege p = new Privilege();
		p.setId(3);
		p.setName("删除商品");
		p.setDiscription("删除一项商品");
		ServiceFactory.getPrivilegeService().updatePrivilege(p);
		
	}
	
	@Test
	//测试得到所有的权限
	public void testGetAll(){
		
		System.out.println(ServiceFactory.getPrivilegeService().getAllPrivilege().size());
		
	}
	
	@Test
	public void testGet(){
		System.out.println(ServiceFactory.getPrivilegeService().getPrivilege(2));
	}
	
	
	
	
	
}
