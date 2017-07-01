package com.zy.dao.impl;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.zy.dao.ICRMVisit;
import com.zy.entity.Visit;

@Repository
@Transactional(readOnly = false)
public class CRMVisitImpl implements ICRMVisit {
	private HibernateTemplate ht;

	@Autowired
	public CRMVisitImpl(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
		this.ht = new HibernateTemplate(sessionFactory);
	}

	@Override
	public List<Visit> selectAllVisit() {
		// TODO Auto-generated method stub
		return this.ht.findByExample(new Visit());
	}

	@Override
	public Visit selectVisit(int id) {
		// TODO Auto-generated method stub
		return this.ht.get(Visit.class, id);
	}

	@Override
	public void updateLinkMan(Visit visit) {
		// TODO Auto-generated method stub
		this.ht.update(visit);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Visit> selectVisitByAddress(String address) {
		// TODO Auto-generated method stub
		String sql = String.format("from Visit where vaddress LIKE '%%%s%%'", address);
		return (List<Visit>) this.ht.find(sql);
	}

	@Override
	public void insertVisit(Visit visit) {
		// TODO Auto-generated method stub
		this.ht.save(visit);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Visit> select(Visit visit) {
		// TODO Auto-generated method stub
		String sql = String.format("from Visit where cvid = %d and uvid = %d and vaddress like '%%%s%%'",
				visit.getCustomer().getId(), visit.getUser().getId(), visit.getAddress());
		return (List<Visit>) this.ht.find(sql);
	}
}
