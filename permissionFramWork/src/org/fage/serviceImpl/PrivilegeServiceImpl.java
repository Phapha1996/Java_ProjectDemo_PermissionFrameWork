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
	
	//�����û�
	/* (non-Javadoc)
	 * @see org.fage.serviceImpl.PrivilegeService#addPrivilege(org.fage.domain.Privilege)
	 */
	public void addPrivilege(Privilege p) throws ServiceException{
		//����������������ǿ�ֵ����ô��ʾ��ֵ���Ҳ������
		if(p.getName()==null||p==null||p.getName().equals("")){
			throw new ServiceException("��Ҫ�����ֵ����û��������Ȩ�ޣ���");
		}
		try{	
			p.setCreateTime(new Date());
			dao.add(p);
			//����׳�������쳣��˵��������ͬ��
		}catch(DaoException e){
			throw new ServiceException("��ǰȨ�������ݿ����Ѿ�����");
		}
	}
	
	
	//ɾ��һ��privilege(ע�⣬privilege��role�м�����ɾ��privilege��Ҫ�Ƚ���������޳��м������ɾ��privilege)
	/* (non-Javadoc)
	 * @see org.fage.serviceImpl.PrivilegeService#deletePrivilege(org.fage.domain.Privilege)
	 */
	
			//�Ȱ�P��load
	
			//�鿴p��role�ļ������������
			
			//ɾ��privilege
	public void deletePrivilege(Privilege p) throws ServiceException{
		try{
			Privilege pe = dao.get(p.getId());
			if(pe==null){
				throw new ServiceException("ɾ��ʧ��");
			}
			
			
			dao.delete(pe);
		}catch(Exception e){
			throw new ServiceException("ɾ��ʧ�ܣ��������ڽ�ɫ��������ǰ��Ȩ�ޡ�");
		}
	}
	
	
	//�޸�Ȩ�ޣ������޸Ĳ��漰����
	/* (non-Javadoc)
	 * @see org.fage.serviceImpl.PrivilegeService#update(org.fage.domain.Privilege)
	 */
	public void updatePrivilege(Privilege p) throws ServiceException{
		Privilege pe = dao.get(p.getId());
		if(p.getName().equals("")||p.getName()==null){
			throw new ServiceException("��Ҫ�����ֵ������");
		}
		//�����ǰ���������ݿ��е�������ͬ������ʾδ�޸�
		if(p.getName().equals(pe.getName())&&p.getDiscription().equals(pe.getDiscription())){
			throw new ServiceException("û�����κ��޸ģ�");
		}
			//ֻҪ������Ĳ�Ϊ�գ���ô�Ͱ����
		pe.setName(p.getName());
		pe.setDiscription(p.getDiscription());
		pe.setCreateTime(new Date());
		dao.update(pe);
	}
	
	
	//ֱ�Ӹ���id�ó�һ��Ȩ��
	/* (non-Javadoc)
	 * @see org.fage.serviceImpl.PrivilegeService#getPrivilege(int)
	 */
	public Privilege getPrivilege(int id){
		return dao.get(id);
	}
	
	
	//�õ����е�Ȩ��
	/* (non-Javadoc)
	 * @see org.fage.serviceImpl.PrivilegeService#getAllPrivilege()
	 */
	public List<Privilege> getAllPrivilege() throws ServiceException{
		List<Privilege> ps;
		try{
			ps = dao.getAll();
		//������ݿ���û�����ݣ���ô��ʾû������
			if(ps.size()==0||ps==null){
				throw new ServiceException("���ݿ��л�û���κε����ݣ�");
			}
		}catch(DaoException e){
			throw new ServiceException("���ݿ���ִ��󣡣�");
		}
		return ps;
	}
	
	
	
}
