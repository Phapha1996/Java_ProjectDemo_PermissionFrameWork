package org.fage.dao;

import java.util.List;

import org.fage.domain.Privilege;

public interface PrivilegeDao {

	//����һ��Ȩ��
	public Privilege add(Privilege p);

	//ע�⣬�������
	public Privilege load(int id);

	//ֱ�ӵõ�Ȩ�ޣ�����sql��䣩
	public Privilege get(int id);

	public void delete(Privilege p);

	//���²���
	public void update(Privilege p);

	public List<Privilege> getAll();

}