package com.zy.dao;

import java.util.List;

import com.zy.entity.LinkMan;

public interface ICRMLinkMan {
	List<LinkMan> selectAllLinkman();

	LinkMan selectLinkMan(int id);

	List<LinkMan> select(LinkMan linkMan);

	void updateLinkMan(LinkMan linkMan);

	void insertLinkMan(LinkMan linkMan);

	List<LinkMan> selectLinkManByName(String name);
}
