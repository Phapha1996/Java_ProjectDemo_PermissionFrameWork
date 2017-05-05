package org.fage.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionUtils {
	private static SessionFactory factory;
	
	//读取配置得到session工厂
	static{
		StandardServiceRegistry standardServiceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		factory = new MetadataSources(standardServiceRegistry).buildMetadata().buildSessionFactory();
	}
	
	public static SessionFactory getSessionFactory(){
		return factory;
	}
	
	//当前线程的session,有旧的用旧的，没有就建新的
	public static Session getCurrentSession(){
		return factory.getCurrentSession();
	}
	
	//打开新的session
	public static Session opendSession(){
		return factory.openSession();
	}
	
	
}
