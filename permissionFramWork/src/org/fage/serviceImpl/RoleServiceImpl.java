package org.fage.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.fage.dao.PrivilegeDao;
import org.fage.dao.RoleDao;
import org.fage.domain.Privilege;
import org.fage.domain.Role;
import org.fage.exception.DaoException;
import org.fage.exception.ServiceException;
import org.fage.service.RoleService;
import org.fage.utils.DaoFactory;

public class RoleServiceImpl implements RoleService {
	private RoleDao rdao = DaoFactory.getRoleDao();
	private PrivilegeDao pdao = DaoFactory.getPrivilegeDao(); 

	//得到所有的角色
	/* (non-Javadoc)
	 * @see org.fage.serviceImpl.RoleService#getAllRole()
	 */
	public List<Role> getAllRole() throws ServiceException{
		try{
			List<Role> list = rdao.getAll();
			if(list==null||list.size()==0){
				throw new ServiceException("数据库中还未拥有任何数据");
			}
			return list;
		}catch(DaoException e){
			e.printStackTrace();
			throw new ServiceException("数据库出现未知错误，开发人员正在抢修");
		}
	}
	
	
	//增加角色
	/* (non-Javadoc)
	 * @see org.fage.serviceImpl.RoleService#addRole(org.fage.domain.Role, java.util.List)
	 */
	public void addRole(Role role,int[] p_ids) throws ServiceException{
		try{
		//如果增加的角色没有被命名，提示用户不要传入空值
			if(role.getName().equals("")||role==null){
				throw new ServiceException("请不要传入名字为空值的职位！");
			}
		//如果用户没有勾选需要的权限，那么直接增加角色就行
			if(p_ids==null||p_ids.length==0){
				rdao.add(role);
				return;
			}
			//如果用户勾选了权限
			List<Privilege> privileges = new ArrayList<Privilege>();
			for(int id:p_ids){
				Privilege p = new Privilege();
				p.setId(id);
				privileges.add(p);
			}
			
		//先找出这堆的privilege是否在数据库里面存在(由于是直接显示给用户的，所以肯定是存在在数据库里面的)
		//如果在数据库里面存在，那么就直接设置关联
			role.setPrivileges(privileges);
			rdao.add(role);
		//如果数据库里面存在同名，告诉上一层
		}catch(DaoException e){
			throw new ServiceException("数据库中已经拥有该职位角色");
		}
	
	}
	
	
	
	/* (non-Javadoc)
	 * @see org.fage.serviceImpl.RoleService#deleteRole(org.fage.domain.Role)
	 */
	public void deleteRole(Role r) throws ServiceException{
		try{
			Role role = rdao.get(r.getId());
			if(role==null)
				throw new ServiceException("删除的对象未被发现");
			role.setPrivileges(null);//先把级联去除
			rdao.delete(role);
		}catch(DaoException e){
			throw new ServiceException("数据库出现错误，开发人员正在抢修");
		}
	}
	
	
	
	
	/* (non-Javadoc)
	 * @see org.fage.serviceImpl.RoleService#updateRole(org.fage.domain.Role, java.util.List)
	 */
	public void updateRole(Role r,int[] p_ids) throws ServiceException{
		try{
			if(r.getName().equals("")||r==null){
				throw new ServiceException("请不要传入空值或者空的名字");
			}
			//把id装回list
			List<Privilege> privileges = new ArrayList<Privilege>();
			
			if(p_ids!=null&&p_ids.length!=0)
			for(int id:p_ids){
				Privilege p = new Privilege();
				p.setId(id);
				privileges.add(p);
			}
			
			Role role = rdao.get(r.getId());
			role.setName(r.getName());
			role.setDiscription(r.getDiscription());
			role.setPrivileges(privileges);
		}catch(DaoException e){
			throw new ServiceException("数据库出现未知错误，开发人员正在抢修");
		}
	}
	
	
	
	//授权操作
	/* (non-Javadoc)
	 * @see org.fage.serviceImpl.RoleService#accredit(org.fage.domain.Role, java.util.List)
	 */
	public void accredit(Role r,int[] p_ids) throws ServiceException{
		try{
			//把id装回list
			
			List<Privilege> privileges = new ArrayList<Privilege>();
			if(p_ids==null||p_ids.length==0){
				throw new ServiceException("没有做任何的权限赋予！！");
			}
			
			for(int id:p_ids){
				Privilege p = new Privilege();
				p.setId(id);
				privileges.add(p);
			}
			//先查询
			Role role = rdao.get(r.getId());
			List<Privilege> dbPrivileges = role.getPrivileges();
			dbPrivileges.addAll(privileges);
			role.setPrivileges(dbPrivileges);
		}catch(DaoException e){
			throw new ServiceException("数据库出现未知错误，开发人员正在抢修");
		}
	}
	
	
	
	/* (non-Javadoc)
	 * @see org.fage.serviceImpl.RoleService#getRole(int)
	 */
	public Role getRole(int id) throws ServiceException{
		try{
			Role role = rdao.get(id);
		//为了级联懒加载
			List<Privilege> list = role.getPrivileges();
			role.setPrivileges(list);
			return role;
		}catch(DaoException e){
			throw new ServiceException("数据库出现异常，未找到当前数据");
		}
	}
	
	
	
	//显示当前角色还未拥有的权限
	/* (non-Javadoc)
	 * @see org.fage.serviceImpl.RoleService#showHasNot(org.fage.domain.Role)
	 */
	public List<Privilege> showHasNot(Role r){
		//得到数据库中所有的权限
		List<Privilege> hasNot = pdao.getAll();
		Role role = rdao.get(r.getId());
		//移除掉当前角色已经有的权限（得到的也就是当前角色还没拥有的权限）
		hasNot.removeAll(role.getPrivileges());
		return hasNot;
	}
	
	
	//取消权限操作
	/* (non-Javadoc)
	 * @see org.fage.serviceImpl.RoleService#removePrivilege(org.fage.domain.Role, org.fage.domain.Privilege)
	 */
	public void removePrivilege(Role r,Privilege p){
		Role role = rdao.get(r.getId());
		Privilege pri = pdao.get(p.getId());
		List<Privilege> list = role.getPrivileges();
		boolean b = list.remove(pri);
		role.setPrivileges(list);
	}
	
}
