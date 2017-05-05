package org.fage.serviceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.fage.exception.ServiceException;
import org.fage.utils.SessionUtils;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;

//动态代理（JAVA一个核心的设计模式AOP实现）
public class ServiceHandler implements InvocationHandler{
	private Object delegate;
	
	public ServiceHandler(Object delegate){
		this.delegate = delegate;
	}

	
	//核心拦截AOP
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)throws Throwable {
		Session session = SessionUtils.getCurrentSession();
		try{
			session.beginTransaction();
			Object result = method.invoke(delegate, args);//service中的所有方法都要从这里被拦截经过，所以所有方法都会有事务
			//只要调用方法出现了任何异常，下面都会记录异常并且抛出
			session.getTransaction().commit();
			return result;
		}catch(InvocationTargetException sx){
			//InvocationTargetException异常，invoke方法内部没有被抓住而抛出的异常（包装异常）
			try{
				if(session.getTransaction().isActive()){
					session.getTransaction().rollback();//只要中途发现异常出现马上回滚
				}
			}catch(Throwable rbEx){
				rbEx.printStackTrace();
			}
			throw new ServiceException(((InvocationTargetException) sx).getTargetException().getMessage());//异常抛出
		}catch(Throwable e){
			//抓到别的异常的话，就是DAO层的异常
			try{
				if(session.getTransaction().isActive()){
					session.getTransaction().rollback();//只要中途发现异常出现马上回滚
				}
			}catch(Throwable rbEx){
				rbEx.printStackTrace();
			}
			throw new ServiceException("操作错误，其他数据正在引用这条数据，请您先解除引用在操作！");
		}finally{
			session.close();//如果回滚了，肯定需要关闭
		}
		
	}
	
	
	
}
