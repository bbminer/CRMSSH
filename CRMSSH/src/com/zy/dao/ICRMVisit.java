package com.zy.dao;

import java.util.List;
import com.zy.entity.Visit;

public interface ICRMVisit {
	List<Visit> selectAllVisit();

	Visit selectVisit(int id);

	List<Visit> select(Visit visit);

	void updateLinkMan(Visit visit);

	List<Visit> selectVisitByAddress(String address);

	void insertVisit(Visit visit);
}
