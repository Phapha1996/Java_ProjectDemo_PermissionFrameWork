package org.fage.serviceImpl;

import java.util.Date;
import java.util.List;

import org.fage.dao.PrivilegeDao;
import org.fage.daoImpl.PrivilegeDaoImpl;
import org.fage.domain.Privilege;
import org.fage.exception.DaoException;
import org.fage.exception.ServiceException;
import org.fage.service.PrivilegeService;
import org.fage.utils.DaoFactory;

public class PrivilegeServiceImpl implements PrivilegeService {
	private PrivilegeDao dao = DaoFactory.getPrivilegeDao();
	
	/* (non-Javadoc)
	 * @see org.fage.serviceImpl.PrivilegeService#addPrivilege(org.fage.domain.Privilege)
	 */
	
	//增加用户
	/* (non-Javadoc)
	 * @see org.fage.serviceImpl.PrivilegeService#addPrivilege(org.fage.domain.Privilege)
	 */
	public void addPrivilege(Privilege p) throws ServiceException{
		//如果传进来的名字是空值，那么提示空值并且不帮你存
		if(p.getName()==null||p==null||p.getName().equals("")){
			throw new ServiceException("不要传入空值或者没有命名的权限！！");
		}
		try{	
			p.setCreateTime(new Date());
			dao.add(p);
			//如果抛出了这个异常，说明名字相同了
		}catch(DaoException e){
			throw new ServiceException("当前权限在数据库内已经存在");
		}
	}
	
	
	//删除一个privilege(注意，privilege与role有级联，删除privilege需要先解除级联，剔除中间表，才能删除privilege)
	/* (non-Javadoc)
	 * @see org.fage.serviceImpl.PrivilegeService#deletePrivilege(org.fage.domain.Privilege)
	 */
	
			//先把P给load
	
			//查看p与role的级联，解除级联
			
			//删除privilege
	public void deletePrivilege(Privilege p) throws ServiceException{
		try{
			Privilege pe = dao.get(p.getId());
			if(pe==null){
				throw new ServiceException("删除失败");
			}
			
			
			dao.delete(pe);
		}catch(Exception e){
			throw new ServiceException("删除失败，请您先在角色管理解除当前的权限。");
		}
	}
	
	
	//修改权限，单纯修改不涉及级联
	/* (non-Javadoc)
	 * @see org.fage.serviceImpl.PrivilegeService#update(org.fage.domain.Privilege)
	 */
	public void updatePrivilege(Privilege p) throws ServiceException{
		Privilege pe = dao.get(p.getId());
		if(p.getName().equals("")||p.getName()==null){
			throw new ServiceException("不要传入空值！！！");
		}
		//如果当前名字与数据库中的名字相同，则提示未修改
		if(p.getName().equals(pe.getName())&&p.getDiscription().equals(pe.getDiscription())){
			throw new ServiceException("没有做任何修改！");
		}
			//只要查出来的不为空，那么就帮更新
		pe.setName(p.getName());
		pe.setDiscription(p.getDiscription());
		pe.setCreateTime(new Date());
		dao.update(pe);
	}
	
	
	//直接根据id拿出一个权限
	/* (non-Javadoc)
	 * @see org.fage.serviceImpl.PrivilegeService#getPrivilege(int)
	 */
	public Privilege getPrivilege(int id){
		return dao.get(id);
	}
	
	
	//得到所有的权限
	/* (non-Javadoc)
	 * @see org.fage.serviceImpl.PrivilegeService#getAllPrivilege()
	 */
	public List<Privilege> getAllPrivilege() throws ServiceException{
		List<Privilege> ps;
		try{
			ps = dao.getAll();
		//如果数据库中没有数据，那么提示没有数据
			if(ps.size()==0||ps==null){
				throw new ServiceException("数据库中还没有任何的数据！");
			}
		}catch(DaoException e){
			throw new ServiceException("数据库出现错误！！");
		}
		return ps;
	}
	
	
	
}
