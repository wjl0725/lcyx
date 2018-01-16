package com.baikang.dao.impl;

import java.util.List;

import com.baikang.base.BaseDaoImpl;
import com.baikang.dao.DrillldownDao;
import com.baikang.entity.Drilldown;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("unchecked")
@Repository
@Transactional
public class DrillldownDaoImpl extends BaseDaoImpl<Drilldown> implements
		DrillldownDao {

	public List<String> getYearAndMonth() {
		String hql = "select distinct (year+month) from Drilldown  order by (year+month)";
		List<String> list = getSession().createQuery(hql).list();
		return list;
	}

	public List<Drilldown> getDrilldown(String yearmonth) {
		String hql = "from Drilldown d where (d.year+d.month)=?";
		List<Drilldown> list = getSession().createQuery(hql)
				.setParameter(0, yearmonth).list();
		return list;
	}

}
