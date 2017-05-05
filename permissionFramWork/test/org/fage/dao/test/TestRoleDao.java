package org.fage.dao.test;

import java.util.ArrayList;
import java.util.List;

import org.fage.dao.AdminDao;
import org.fage.dao.PrivilegeDao;
import org.fage.dao.RoleDao;
import org.fage.daoImpl.AdminDaoImpl;
import org.fage.daoImpl.PrivilegeDaoImpl;
import org.fage.daoImpl.RoleDaoImpl;
import org.fage.domain.Admin;
import org.fage.domain.Privilege;
import org.fage.domain.Role;
import org.fage.utils.SessionUtils;
import org.hibernate.Session;
import org.junit.Test;

public class TestRoleDao {
	private RoleDao rdao = new RoleDaoImpl(); 
	private PrivilegeDao pdao= new PrivilegeDaoImpl();
	private AdminDao adao = new AdminDaoImpl();
	
	@Test
	public void testAdd(){
		Role r = new Role();
		r.setName("产品经理");
		r.setDiscription("产品经理职位角色");

		Session session = SessionUtils.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		rdao.add(r);
		session.getTransaction().commit();
	}
	
	
	@Test
	public void testAddRelation(){
		
		List list = new ArrayList();
		Session session = SessionUtils.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Role r = rdao.get(2);
		//Privilege p = pdao.get(23);
		Privilege p = new Privilege();
		p.setId(24);//实验结果：不是persist状态的权限也能被添加
		list = r.getPrivileges();
		list.add(p);
		r.setPrivileges(list);
//		list.add(p);
//		r.setPrivileges(list);
		session.getTransaction().commit();
	}
	
	
	@Test
	public void testDelete(){

		Session session = SessionUtils.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Role r = rdao.get(1);
		List list = r.getPrivileges();
		list = null;
		rdao.delete(r);
		session.getTransaction().commit();
	}
	
	@Test
	public void testLoad(){
		Role r = new Role();
		Session session = SessionUtils.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		r = rdao.load(2);
		System.out.println(r.getId());
		session.getTransaction().commit();
	}
	
	
	@Test
	public void testAdminDao(){
		Session session = SessionUtils.getCurrentSession();
		session.beginTransaction();
		Admin a = adao.get("18778381360", "fa123.com", "系统管理员");
		session.getTransaction().commit();
		System.out.println(a.getId()+a.getUsername()+a.getPassword()+a.getPosition());
	
	}
	
	
	
}
