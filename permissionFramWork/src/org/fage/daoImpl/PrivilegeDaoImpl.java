package org.fage.daoImpl;

import java.util.Date;
import java.util.List;

import org.fage.dao.PrivilegeDao;
import org.fage.domain.Privilege;
import org.fage.exception.DaoException;
import org.fage.utils.SessionUtils;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/*
 	Ȩ�޵����ݷ���ʵ�ֲ�
 	Hibernateʵ��
 *
 */
public class PrivilegeDaoImpl implements PrivilegeDao {

	//����һ��Ȩ��
	/* (non-Javadoc)
	 * @see org.fage.daoImpl.PrivilegeDao#add(org.fage.domain.Privilege)
	 */
	public Privilege add(Privilege p){
		try{
			SessionUtils.getCurrentSession().save(p);
			return p;
		}catch(Exception e){
			e.printStackTrace();
			throw new DaoException();
		}
	}
	
	
	//ע�⣬�������
	/* (non-Javadoc)
	 * @see org.fage.daoImpl.PrivilegeDao#load(int)
	 */
	public Privilege load(int id){
		try{
			Privilege p = SessionUtils.getCurrentSession().load(Privilege.class, id);
			p.getId();
			return p;
		}catch(Exception e){
			e.printStackTrace();
			throw new DaoException();
		}
	}
	
	//ֱ�ӵõ�Ȩ�ޣ�����sql��䣩
	/* (non-Javadoc)
	 * @see org.fage.daoImpl.PrivilegeDao#get(int)
	 */
	public Privilege get(int id){
		try{
			return SessionUtils.getCurrentSession().get(Privilege.class,id);
		}catch(Exception e){
			e.printStackTrace();
			throw new DaoException();
		}
	}
	
	
	
	/* (non-Javadoc)
	 * @see org.fage.daoImpl.PrivilegeDao#delete(org.fage.domain.Privilege)
	 */
	public void delete(Privilege p){
			SessionUtils.getCurrentSession().delete(p);
	}
	
	
	//���²���
	/* (non-Javadoc)
	 * @see org.fage.daoImpl.PrivilegeDao#update(org.fage.domain.Privilege)
	 */
	public void update(Privilege p){
			SessionUtils.getCurrentSession().update(p);
	}
	
	
	
	public List<Privilege> getAll(){
		try{
			Session session = SessionUtils.getCurrentSession();
			List<Privilege> list = session.createQuery("from Privilege").list();
			return list;
		}catch(Exception e){
			e.printStackTrace();
			throw new DaoException();
		}
	}
	
	
	
}
