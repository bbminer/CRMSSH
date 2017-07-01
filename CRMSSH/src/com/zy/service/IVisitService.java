package com.zy.service;

import java.util.List;
import com.zy.entity.Visit;

public interface IVisitService {
	List<Visit> selectAllVisit();
	
	Visit selectVisit(int id);
	
	boolean updateLinkMan(Visit visit);
	
	List<Visit> selectVisitByAddress(String address);
	
	boolean insertVisit(Visit visit);
	
	List<Visit> select(Visit visit);
}
