package com.zy.service;

import java.util.List;

import com.zy.entity.Customer;
import com.zy.entity.Dict;

public interface ICustomerService {
	List<Customer> selectAllCustomer();

	boolean deleteCustomer(int id);
	
	Customer updateCustomer(Customer customer);
	
	List<Dict> selectAllDict();
	
	Customer selectCustomer(int id);
	
	List<Customer> selectCustomerByName(String name);
	
	boolean insertCustomer(Customer customer);
	
	List<Customer> select(Customer customer);
	
	List<?> selectCustomerSource();
	
	List<?> selectCustomerLevel();
	
	List<Customer> selectLimit(int startrow, int pagesize);
	
	int selectCountCustomer();
}
