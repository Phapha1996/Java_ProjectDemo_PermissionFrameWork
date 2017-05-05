package org.fage.service.test;

import org.fage.domain.Admin;
import org.fage.exception.ServiceException;
import org.fage.service.AdminService;
import org.fage.utils.ServiceFactory;
import org.junit.Test;

public class AdminServiceTest {
	private AdminService service = ServiceFactory.getAdminService();
	
	@Test
	public void testAdminlogin(){
		Admin a = new Admin();
		a.setPassword("fa123.com");
		a.setUsername("18778381360");
		a.setPosition("系统管理员");
		
		try {
			Admin admin = service.loginAdmin(a);
			System.out.println(admin);
			
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
	}
}
