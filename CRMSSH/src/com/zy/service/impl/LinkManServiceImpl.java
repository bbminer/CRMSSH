package com.zy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zy.dao.ICRMLinkMan;
import com.zy.entity.LinkMan;
import com.zy.service.ILinkManService;

@Service
public class LinkManServiceImpl implements ILinkManService {

	@Autowired
	private ICRMLinkMan lm;

	@Override
	public List<LinkMan> selectAllLinkman() {
		// TODO Auto-generated method stub
		return lm.selectAllLinkman();
	}

	@Override
	public LinkMan selectLinkMan(int id) {
		// TODO Auto-generated method stub
		return lm.selectLinkMan(id);
	}

	@Override
	public boolean updateLinkMan(LinkMan linkMan) {
		// TODO Auto-generated method stub
		try {
			lm.updateLinkMan(linkMan);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean insertLinkMan(LinkMan linkMan) {
		// TODO Auto-generated method stub
		try {
			lm.insertLinkMan(linkMan);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}	
	}

	@Override
	public List<LinkMan> selectLinkManByName(String name) {
		// TODO Auto-generated method stub
		return lm.selectLinkManByName(name);
	}

	@Override
	public List<LinkMan> select(LinkMan linkMan) {
		// TODO Auto-generated method stub
		return lm.select(linkMan);
	}
}
