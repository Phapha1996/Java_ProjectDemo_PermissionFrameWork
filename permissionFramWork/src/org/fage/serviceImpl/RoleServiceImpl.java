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

	//�õ����еĽ�ɫ
	/* (non-Javadoc)
	 * @see org.fage.serviceImpl.RoleService#getAllRole()
	 */
	public List<Role> getAllRole() throws ServiceException{
		try{
			List<Role> list = rdao.getAll();
			if(list==null||list.size()==0){
				throw new ServiceException("���ݿ��л�δӵ���κ�����");
			}
			return list;
		}catch(DaoException e){
			e.printStackTrace();
			throw new ServiceException("���ݿ����δ֪���󣬿�����Ա��������");
		}
	}
	
	
	//���ӽ�ɫ
	/* (non-Javadoc)
	 * @see org.fage.serviceImpl.RoleService#addRole(org.fage.domain.Role, java.util.List)
	 */
	public void addRole(Role role,int[] p_ids) throws ServiceException{
		try{
		//������ӵĽ�ɫû�б���������ʾ�û���Ҫ�����ֵ
			if(role.getName().equals("")||role==null){
				throw new ServiceException("�벻Ҫ��������Ϊ��ֵ��ְλ��");
			}
		//����û�û�й�ѡ��Ҫ��Ȩ�ޣ���ôֱ�����ӽ�ɫ����
			if(p_ids==null||p_ids.length==0){
				rdao.add(role);
				return;
			}
			//����û���ѡ��Ȩ��
			List<Privilege> privileges = new ArrayList<Privilege>();
			for(int id:p_ids){
				Privilege p = new Privilege();
				p.setId(id);
				privileges.add(p);
			}
			
		//���ҳ���ѵ�privilege�Ƿ������ݿ��������(������ֱ����ʾ���û��ģ����Կ϶��Ǵ��������ݿ������)
		//��������ݿ�������ڣ���ô��ֱ�����ù���
			role.setPrivileges(privileges);
			rdao.add(role);
		//������ݿ��������ͬ����������һ��
		}catch(DaoException e){
			throw new ServiceException("���ݿ����Ѿ�ӵ�и�ְλ��ɫ");
		}
	
	}
	
	
	
	/* (non-Javadoc)
	 * @see org.fage.serviceImpl.RoleService#deleteRole(org.fage.domain.Role)
	 */
	public void deleteRole(Role r) throws ServiceException{
		try{
			Role role = rdao.get(r.getId());
			if(role==null)
				throw new ServiceException("ɾ���Ķ���δ������");
			role.setPrivileges(null);//�ȰѼ���ȥ��
			rdao.delete(role);
		}catch(DaoException e){
			throw new ServiceException("���ݿ���ִ��󣬿�����Ա��������");
		}
	}
	
	
	
	
	/* (non-Javadoc)
	 * @see org.fage.serviceImpl.RoleService#updateRole(org.fage.domain.Role, java.util.List)
	 */
	public void updateRole(Role r,int[] p_ids) throws ServiceException{
		try{
			if(r.getName().equals("")||r==null){
				throw new ServiceException("�벻Ҫ�����ֵ���߿յ�����");
			}
			//��idװ��list
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
			throw new ServiceException("���ݿ����δ֪���󣬿�����Ա��������");
		}
	}
	
	
	
	//��Ȩ����
	/* (non-Javadoc)
	 * @see org.fage.serviceImpl.RoleService#accredit(org.fage.domain.Role, java.util.List)
	 */
	public void accredit(Role r,int[] p_ids) throws ServiceException{
		try{
			//��idװ��list
			
			List<Privilege> privileges = new ArrayList<Privilege>();
			if(p_ids==null||p_ids.length==0){
				throw new ServiceException("û�����κε�Ȩ�޸��裡��");
			}
			
			for(int id:p_ids){
				Privilege p = new Privilege();
				p.setId(id);
				privileges.add(p);
			}
			//�Ȳ�ѯ
			Role role = rdao.get(r.getId());
			List<Privilege> dbPrivileges = role.getPrivileges();
			dbPrivileges.addAll(privileges);
			role.setPrivileges(dbPrivileges);
		}catch(DaoException e){
			throw new ServiceException("���ݿ����δ֪���󣬿�����Ա��������");
		}
	}
	
	
	
	/* (non-Javadoc)
	 * @see org.fage.serviceImpl.RoleService#getRole(int)
	 */
	public Role getRole(int id) throws ServiceException{
		try{
			Role role = rdao.get(id);
		//Ϊ�˼���������
			List<Privilege> list = role.getPrivileges();
			role.setPrivileges(list);
			return role;
		}catch(DaoException e){
			throw new ServiceException("���ݿ�����쳣��δ�ҵ���ǰ����");
		}
	}
	
	
	
	//��ʾ��ǰ��ɫ��δӵ�е�Ȩ��
	/* (non-Javadoc)
	 * @see org.fage.serviceImpl.RoleService#showHasNot(org.fage.domain.Role)
	 */
	public List<Privilege> showHasNot(Role r){
		//�õ����ݿ������е�Ȩ��
		List<Privilege> hasNot = pdao.getAll();
		Role role = rdao.get(r.getId());
		//�Ƴ�����ǰ��ɫ�Ѿ��е�Ȩ�ޣ��õ���Ҳ���ǵ�ǰ��ɫ��ûӵ�е�Ȩ�ޣ�
		hasNot.removeAll(role.getPrivileges());
		return hasNot;
	}
	
	
	//ȡ��Ȩ�޲���
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
