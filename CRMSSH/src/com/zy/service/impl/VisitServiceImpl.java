package com.zy.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zy.dao.ICRMVisit;
import com.zy.entity.Visit;
import com.zy.service.IVisitService;

@Service
public class VisitServiceImpl implements IVisitService {
	@Autowired
	private ICRMVisit vi;

	@Override
	public List<Visit> selectAllVisit() {
		// TODO Auto-generated method stub
		return vi.selectAllVisit();
	}

	@Override
	public Visit selectVisit(int id) {
		// TODO Auto-generated method stub
		return vi.selectVisit(id);
	}

	@Override
	public boolean updateLinkMan(Visit visit) {
		// TODO Auto-generated method stub
		try {
			vi.updateLinkMan(visit);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Visit> selectVisitByAddress(String address) {
		// TODO Auto-generated method stub
		return vi.selectVisitByAddress(address);
	}

	@Override
	public boolean insertVisit(Visit visit) {
		// TODO Auto-generated method stub
		try {
			vi.insertVisit(visit);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Visit> select(Visit visit) {
		// TODO Auto-generated method stub
		return vi.select(visit);
	}
}
