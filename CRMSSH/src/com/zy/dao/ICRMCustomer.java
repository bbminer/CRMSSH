package com.zy.dao;

import java.util.List;
import com.zy.entity.Customer;
import com.zy.entity.Dict;

public interface ICRMCustomer {
	List<Customer> selectAllCustomer();

	List<Dict> selectAllDict();

	List<Customer> select(Customer customer);

	List<Customer> selectLimit(int startrow, int pagesize);

	List<?> selectCustomerSource();

	List<?> selectCustomerLevel();
	
	int selectCountCustomer();

	Customer selectCustomer(int id);

	List<Customer> selectCustomerByName(String name);

	void deleteCustomer(int id);

	void updateCustomer(Customer customer);

	void insertCustomer(Customer customer);
}
