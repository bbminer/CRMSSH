package com.zy.service;

import java.util.List;

import com.zy.entity.LinkMan;

public interface ILinkManService {
	List<LinkMan> selectAllLinkman();
	
	LinkMan selectLinkMan(int id);
	
	boolean updateLinkMan(LinkMan linkMan);
	
	boolean insertLinkMan(LinkMan linkMan);
	
	List<LinkMan> selectLinkManByName(String name);
	
	List<LinkMan> select(LinkMan linkMan);
}
