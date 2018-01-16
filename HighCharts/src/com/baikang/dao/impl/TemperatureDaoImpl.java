package com.baikang.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.baikang.base.BaseDaoImpl;
import com.baikang.dao.TemperatureDao;
import com.baikang.entity.Temperature;

@SuppressWarnings("unchecked")
@Repository
@Transactional
public class TemperatureDaoImpl extends BaseDaoImpl<Temperature> implements
		TemperatureDao {

	public List<Object> findMonth() {
		String hql = "select distinct month from Temperature order by month";
		return getSession().createQuery(hql).list();
	}

	public List<Object> findCity() {
		String hql = "select distinct city from Temperature";
		return getSession().createQuery(hql).list();
	}

	public List<Temperature> findTemperature(Integer month, String city) {
		String hql = "from Temperature where month=? and city=?";
		return getSession().createQuery(hql).setParameter(0, month)
				.setParameter(1, city).list();
	}
}
