package com.zy.dao.impl;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.zy.dao.ICRMLinkMan;
import com.zy.entity.LinkMan;

@Repository
@Transactional(readOnly = false)
public class CRMLinkManImpl implements ICRMLinkMan {
	private HibernateTemplate ht;

	@Autowired
	public CRMLinkManImpl(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
		this.ht = new HibernateTemplate(sessionFactory);
	}

	@Override
	public List<LinkMan> selectAllLinkman() {
		// TODO Auto-generated method stub
		return this.ht.findByExample(new LinkMan());
	}

	@Override
	public LinkMan selectLinkMan(int id) {
		return this.ht.get(LinkMan.class, id);
	}

	@Override
	public void updateLinkMan(LinkMan linkMan) {
		this.ht.update(linkMan);
	}

	@Override
	public void insertLinkMan(LinkMan linkMan) {
		this.ht.save(linkMan);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LinkMan> selectLinkManByName(String name) {
		List<?> list = this.ht.find(String.format("from LinkMan where linkName like '%%%s%%'", name));
		return (List<LinkMan>) list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LinkMan> select(LinkMan linkMan) {
		// TODO Auto-generated method stub
		String sql = String.format("from LinkMan where linkName like '%%%s%%' and clid = %d", linkMan.getName(),
				linkMan.getCustomer().getId());
		return (List<LinkMan>) this.ht.find(sql);
	}
}