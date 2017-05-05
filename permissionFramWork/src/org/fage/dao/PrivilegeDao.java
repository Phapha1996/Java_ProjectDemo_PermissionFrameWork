package org.fage.dao;

import java.util.List;

import org.fage.domain.Privilege;

public interface PrivilegeDao {

	//增加一个权限
	public Privilege add(Privilege p);

	//注意，代理对象
	public Privilege load(int id);

	//直接得到权限（立马发sql语句）
	public Privilege get(int id);

	public void delete(Privilege p);

	//更新操作
	public void update(Privilege p);

	public List<Privilege> getAll();

}