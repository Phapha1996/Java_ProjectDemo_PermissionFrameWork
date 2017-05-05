package org.fage.dao.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.fage.dao.PrivilegeDao;
import org.fage.daoImpl.PrivilegeDaoImpl;
import org.fage.domain.Privilege;
import org.fage.domain.Role;
import org.fage.utils.SessionUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class TestPrivilegeDao {
	@Test
	public void testCreateTable(){
		Privilege p = new Privilege();
		p.setName("ɾ����Ʒ");
		p.setDiscription("ӵ�����Ȩ�������ɾ��Ʒ");
		p.setCreateTime(new Date());
		PrivilegeDao dao = new PrivilegeDaoImpl();
		SessionUtils.getCurrentSession().beginTransaction();
		dao.add(p);
		SessionUtils.getCurrentSession().getTransaction().commit();
		
	}
	@Test
	public void testgetAndLoad(){
		PrivilegeDao dao = new PrivilegeDaoImpl();
		SessionUtils.getCurrentSession().beginTransaction();
		Privilege p=dao.load(3);
		System.out.println(p.getName()+p.getDiscription());
		SessionUtils.getCurrentSession().getTransaction().commit();
	}
	
	@Test
	public void testUpdate(){
		
		Privilege p = new Privilege();
		p.setId(15);
		p.setName("������Ʒ");
		p.setDiscription("ӵ�����Ȩ�������������Ʒ");
		p.setCreateTime(new Date());
		PrivilegeDao dao = new PrivilegeDaoImpl();
		SessionUtils.getCurrentSession().beginTransaction();
		dao.update(p);;
		SessionUtils.getCurrentSession().getTransaction().commit();
		
	}
	
	
	@Test
	public void testGetAll(){
		
		PrivilegeDao dao = new PrivilegeDaoImpl();
		SessionUtils.getCurrentSession().beginTransaction();
		List<Privilege> list = dao.getAll();
		SessionUtils.getCurrentSession().getTransaction().commit();
		
		System.out.println(list.size());
		
	}
	
	
	@Test
	public void testDelete(){
		Privilege p = new Privilege();
		p.setId(2);
		PrivilegeDao dao = new PrivilegeDaoImpl();
		SessionUtils.getCurrentSession().beginTransaction();
		dao.delete(p);;
		SessionUtils.getCurrentSession().getTransaction().commit();
	}
	
	
	@Test
	public void testLoad(){
//		PrivilegeDao dao = new PrivilegeDaoImpl();
//		SessionUtils.getCurrentSession().beginTransaction();
//		System.out.println(dao.load(7));
		Session session = SessionUtils.getCurrentSession();
		session.beginTransaction();
		Privilege p = session.load(Privilege.class,23);
		System.out.println(p);
		SessionUtils.getCurrentSession().getTransaction().commit();
		SessionUtils.getSessionFactory().close();
	}
	
	
	
	/*@Test
	public void testSaveRole_Privilege(){
		Role role = new Role();
		role.setName("��Ʒ����");
		Privilege p = new Privilege();
		p.setName("��Ʒ����");
		List list = new ArrayList();
		list.add(p);
		role.setPrivileges(list);
		list = new ArrayList();
		list.add(role);
		p.setRoles(list);
		
		PrivilegeDao dao = new PrivilegeDaoImpl();
		Session session = SessionUtils.getCurrentSession();
		session.beginTransaction();
		session.persist(p);
		SessionUtils.getCurrentSession().getTransaction().commit();
		
	}*/
}
