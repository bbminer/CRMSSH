package com.zy.service;

import java.util.List;
import com.zy.entity.User;

public interface IUserService {
	boolean login(User user);
	
	List<User> selectAllUser();
}
