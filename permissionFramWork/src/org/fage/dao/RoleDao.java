package org.fage.dao;

import java.util.List;

import org.fage.domain.Role;

public interface RoleDao {

	//���ӵ�ʱ��ע�⼶��
	public void add(Role r);

	//1+N�������ֽ��������һ����join��һ��������lazy
	public Role get(int id);

	//����ɾ������������
	public void delete(Role r);

	//������������
	public void update(Role r);

	//�õ����е�Role��������������lazy����
	public List<Role> getAll();

	//����
	public Role load(int id);

}