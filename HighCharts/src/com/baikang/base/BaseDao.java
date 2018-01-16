package com.baikang.base;

import java.util.List;

public interface BaseDao<T> {
	/**
	 * 保存实体
	 * 
	 * @param entity
	 */
	void save(T entity);

	/**
	 * 更新实体
	 * 
	 * @param entity
	 */
	void update(T entity);

	/**
	 * 删除实体
	 * 
	 * @param id
	 */
	void delete(Integer id);

	/**
	 * 获取实体，如果id为null，则返回null
	 * 
	 * @param id
	 * @return
	 */
	T getById(Integer id);


	/**
	 * 查询所有
	 * 
	 * @return
	 */
	List<T> findAll();

}
