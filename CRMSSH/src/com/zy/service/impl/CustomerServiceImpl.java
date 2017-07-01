package com.zy.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zy.dao.ICRMCustomer;
import com.zy.entity.Customer;
import com.zy.entity.Dict;
import com.zy.service.ICustomerService;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICRMCustomer cust;

	@Override
	public List<Customer> selectAllCustomer() {
		// TODO Auto-generated method stub
		return cust.selectAllCustomer();
	}

	@Override
	public boolean deleteCustomer(int id) {
		// TODO Auto-generated method stub
		try {
			cust.deleteCustomer(id);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		try {
			cust.updateCustomer(customer);
			return customer;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Dict> selectAllDict() {
		// TODO Auto-generated method stub
		return cust.selectAllDict();
	}

	@Override
	public Customer selectCustomer(int id) {
		// TODO Auto-generated method stub
		return cust.selectCustomer(id);
	}

	@Override
	public List<Customer> selectCustomerByName(String name) {
		// TODO Auto-generated method stub
		return cust.selectCustomerByName(name);
	}

	@Override
	public boolean insertCustomer(Customer customer) {
		// TODO Auto-generated method stub
		try {
			cust.insertCustomer(customer);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Customer> select(Customer customer) {
		// TODO Auto-generated method stub
		return cust.select(customer);
	}

	@Override
	public List<?> selectCustomerSource() {
		// TODO Auto-generated method stub
		return cust.selectCustomerSource();
	}

	@Override
	public List<?> selectCustomerLevel() {
		// TODO Auto-generated method stub
		return cust.selectCustomerLevel();
	}

	@Override
	public List<Customer> selectLimit(int startrow, int pagesize) {
		// TODO Auto-generated method stub
		return cust.selectLimit(startrow, pagesize);
	}

	@Override
	public int selectCountCustomer() {
		// TODO Auto-generated method stub
		return cust.selectCountCustomer();
	}
}