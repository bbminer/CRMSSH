package com.zy.dao;

import java.util.List;
import com.zy.entity.User;

public interface IUserDao {
	boolean login(User user);

	List<User> selectAllUser();
}
