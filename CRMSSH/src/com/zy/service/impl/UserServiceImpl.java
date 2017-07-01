package com.zy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zy.dao.IUserDao;
import com.zy.entity.User;
import com.zy.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
@Autowired
	private IUserDao userDao;
	
	@Override
	public boolean login(User user) {
		// TODO Auto-generated method stub
		return userDao.login(user);
	}

	@Override
	public List<User> selectAllUser() {
		// TODO Auto-generated method stub
		return userDao.selectAllUser();
	}

}
