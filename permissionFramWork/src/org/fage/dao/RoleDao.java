package org.fage.dao;

import java.util.List;

import org.fage.domain.Role;

public interface RoleDao {

	//增加的时候注意级联
	public void add(Role r);

	//1+N问题两种解决方案，一种是join，一种是设置lazy
	public Role get(int id);

	//处理删除级联的问题
	public void delete(Role r);

	//级联更新问题
	public void update(Role r);

	//得到所有的Role，级联问题设置lazy即可
	public List<Role> getAll();

	//加载
	public Role load(int id);

}