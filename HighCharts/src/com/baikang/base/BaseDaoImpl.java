package com.baikang.base;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements BaseDao<T> {
	@Resource
	private SessionFactory sessionFactory;
	protected Class<T> clazz;

	public BaseDaoImpl() {
		ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
		clazz = (Class<T>) pt.getActualTypeArguments()[0];

		System.out.println("---> clazz = " + clazz);
	}

	public void delete(Integer id) {
		Object obj = getSession().get(clazz, id);
		getSession().delete(obj);
	}
	public List findAll() {
		return getSession().createCriteria(clazz).list();
	}
	public T getById(Integer id) {
		if (id == null) {
			return null;
		}
		return (T) getSession().get(clazz, id);
	}

	public void save(T entity) {
		getSession().save(entity);
	}

	public void update(T entity) {
		getSession().update(entity);

	}

	// 获取当前Session
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
}
