package org.fage.service.test;

import java.util.ArrayList;
import java.util.List;



import org.fage.domain.Privilege;
import org.fage.domain.Role;
import org.fage.exception.ServiceException;
import org.fage.service.RoleService;
import org.fage.utils.ServiceFactory;
import org.junit.Test;

public class TestRoleService {
	private RoleService rs = ServiceFactory.getRoleService();
	
	@Test
	public void testAdd(){
		Role role = new Role();
		role.setName("产品经理");
		role.setDiscription("产品经理的角色职位");
		List<Privilege> list  = new ArrayList();
		Privilege p0 = new Privilege();
		p0.setId(23);
		Privilege p1 = new Privilege();
		p1.setId(24);
		list.add(p0);
		list.add(p1);
		rs.addRole(role, list);
	}
	
	
	@Test
	public void testGetAll(){
		try{
			List list = rs.getAllRole();
			System.out.println(list.size());
		}catch(ServiceException e){
			System.out.println(e.getMessage());
		}
	}
	
	
	
	@Test
	public void testDelete(){
		Role r = new Role();
		r.setId(5);
		rs.deleteRole(r);
		
	}
	
	
	@Test
	public void testupdate(){
		Role r = new Role();
		r.setId(6);
		r.setName("产品经理");
		r.setDiscription("产品经理角色");
	/*	Privilege p = new Privilege();
		p.setId(23);
		List<Privilege> list = new ArrayList<Privilege>();
		list.add(p);*/
		rs.updateRole(r, null);
	}
	
	@Test
	public void testAccredit(){
		Role role = new Role();
		role.setId(7);
		Privilege p = new Privilege();
		p.setId(25);
		List list = new ArrayList();
		list.add(p);
		rs.accredit(role, list);
		
	}
	
	@Test
	public void testShowHasNot(){
		Role r = new Role();
		r.setId(7);
		List list = rs.showHasNot(r);
		System.out.println(list.size());
	}
	
	
	
	@Test
	public void testRemovePrivilege(){
		Role role = new Role();
		role.setId(7);
		Privilege p = new Privilege();
		p.setId(23);
		rs.removePrivilege(role, p);
	}
	
	
}
