package org.fage.serviceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.fage.exception.ServiceException;
import org.fage.utils.SessionUtils;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;

//��̬����JAVAһ�����ĵ����ģʽAOPʵ�֣�
public class ServiceHandler implements InvocationHandler{
	private Object delegate;
	
	public ServiceHandler(Object delegate){
		this.delegate = delegate;
	}

	
	//��������AOP
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)throws Throwable {
		Session session = SessionUtils.getCurrentSession();
		try{
			session.beginTransaction();
			Object result = method.invoke(delegate, args);//service�е����з�����Ҫ�����ﱻ���ؾ������������з�������������
			//ֻҪ���÷����������κ��쳣�����涼���¼�쳣�����׳�
			session.getTransaction().commit();
			return result;
		}catch(InvocationTargetException sx){
			//InvocationTargetException�쳣��invoke�����ڲ�û�б�ץס���׳����쳣����װ�쳣��
			try{
				if(session.getTransaction().isActive()){
					session.getTransaction().rollback();//ֻҪ��;�����쳣�������ϻع�
				}
			}catch(Throwable rbEx){
				rbEx.printStackTrace();
			}
			throw new ServiceException(((InvocationTargetException) sx).getTargetException().getMessage());//�쳣�׳�
		}catch(Throwable e){
			//ץ������쳣�Ļ�������DAO����쳣
			try{
				if(session.getTransaction().isActive()){
					session.getTransaction().rollback();//ֻҪ��;�����쳣�������ϻع�
				}
			}catch(Throwable rbEx){
				rbEx.printStackTrace();
			}
			throw new ServiceException("�������������������������������ݣ������Ƚ�������ڲ�����");
		}finally{
			session.close();//����ع��ˣ��϶���Ҫ�ر�
		}
		
	}
	
	
	
}
