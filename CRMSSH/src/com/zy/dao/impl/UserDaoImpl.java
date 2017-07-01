package com.zy.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.zy.dao.IUserDao;
import com.zy.entity.User;

@Repository
public class UserDaoImpl implements IUserDao {
	private HibernateTemplate hTemplate;

	@Autowired
	public UserDaoImpl(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
		this.hTemplate = new HibernateTemplate(sessionFactory);
	}

	@Override
	public boolean login(User user) {
		// TODO Auto-generated method stub
		List<User> list = this.hTemplate.findByExample(user);
		if (list.size()>0) {
			return true;
		}
		return false;
	}

	@Override
	public List<User> selectAllUser() {
		// TODO Auto-generated method stub
		return this.hTemplate.findByExample(new User());
	}

}
