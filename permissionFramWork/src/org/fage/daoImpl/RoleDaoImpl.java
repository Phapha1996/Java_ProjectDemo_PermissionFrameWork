package org.fage.daoImpl;

import java.util.List;

import org.fage.dao.RoleDao;
import org.fage.domain.Role;
import org.fage.exception.DaoException;
import org.fage.utils.SessionUtils;

public class RoleDaoImpl implements RoleDao {

	//增加的时候注意级联
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
	
	
	//1+N问题两种解决方案，一种是join，一种是设置lazy
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
	
	
	//处理删除级联的问题
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
	
	
	//级联更新问题
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
	
	
	//得到所有的Role，级联问题设置lazy即可
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
	
	
	//加载
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
