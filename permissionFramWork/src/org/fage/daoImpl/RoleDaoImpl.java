package org.fage.daoImpl;

import java.util.List;

import org.fage.dao.RoleDao;
import org.fage.domain.Role;
import org.fage.exception.DaoException;
import org.fage.utils.SessionUtils;

public class RoleDaoImpl implements RoleDao {

	//���ӵ�ʱ��ע�⼶��
	/* (non-Javadoc)
	 * @see org.fage.daoImpl.RoleDao#add(org.fage.domain.Role)
	 */
	public void add(Role r){
		try{
		SessionUtils.getCurrentSession().save(r);
		}catch(Exception e){
			e.printStackTrace();
			throw new DaoException();
		}
	}
	
	
	//1+N�������ֽ��������һ����join��һ��������lazy
	/* (non-Javadoc)
	 * @see org.fage.daoImpl.RoleDao#get(int)
	 */
	public Role get(int id){
		try{
			Role role = SessionUtils.getCurrentSession().get(Role.class, id);
			return role;
		}catch(Exception e){
			e.printStackTrace();
			throw new DaoException();
		}
	}
	
	
	//����ɾ������������
	/* (non-Javadoc)
	 * @see org.fage.daoImpl.RoleDao#delete(org.fage.domain.Role)
	 */
	public void delete(Role r){
		try{
			SessionUtils.getCurrentSession().delete(r);
		}catch(Exception e){
			e.printStackTrace();
			throw new DaoException();
		}
	}
	
	
	//������������
	/* (non-Javadoc)
	 * @see org.fage.daoImpl.RoleDao#update(org.fage.domain.Role)
	 */
	public void update(Role r){
		try{
			SessionUtils.getCurrentSession().update(r);
		}catch(Exception e){
			e.printStackTrace();
			throw new DaoException();
		}
	}
	
	
	//�õ����е�Role��������������lazy����
	/* (non-Javadoc)
	 * @see org.fage.daoImpl.RoleDao#getAll()
	 */
	public List<Role> getAll(){
		try{
			return SessionUtils.getCurrentSession().createQuery("from Role").list();
		}catch(Exception e){
			e.printStackTrace();
			throw new DaoException();
		}
	}
	
	
	//����
	/* (non-Javadoc)
	 * @see org.fage.daoImpl.RoleDao#load(int)
	 */
	public Role load(int id){
		try{
			return SessionUtils.getCurrentSession().load(org.fage.domain.Role.class, id);	
		}catch(Exception e){
			e.printStackTrace();
			throw new DaoException();
		}
	}
	
}
