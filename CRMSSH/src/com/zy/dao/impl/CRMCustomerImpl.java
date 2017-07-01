package com.zy.dao.impl;

import java.util.List;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.zy.dao.ICRMCustomer;
import com.zy.entity.Customer;
import com.zy.entity.Dict;

@Repository
@Transactional(readOnly = false)
public class CRMCustomerImpl implements ICRMCustomer {

	private HibernateTemplate ht;

	@Autowired
	public CRMCustomerImpl(SessionFactory sessionFactory) {
		// TODO Auto-generated constructor stub
		this.ht = new HibernateTemplate(sessionFactory);
	}

	@Override
	public Customer selectCustomer(int id) {
		// TODO Auto-generated method stub
		return this.ht.get(Customer.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> selectLimit(int startrow, int pagesize) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria =DetachedCriteria.forClass(Customer.class);
		return (List<Customer>) this.ht.findByCriteria(criteria, startrow, pagesize);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> selectCustomerByName(String name) {
		// TODO Auto-generated method stub
		List<?> list = this.ht.find(String.format("from Customer where custName like '%%%s%%'", name));
		return (List<Customer>) list;
	}

	@Override
	public List<Dict> selectAllDict() {
		// TODO Auto-generated method stub
		return this.ht.findByExample(new Dict());
	}

	@Override
	public List<Customer> selectAllCustomer() {
		return this.ht.findByExample(new Customer());
	}

	public List<?> selectCustomerSource() {
		return this.ht.findByNamedQuery("selectCustomerSource");
	}

	@Override
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		Customer load = this.ht.get(Customer.class, id);
		this.ht.delete(load);
	}

	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		this.ht.update(customer);
	}

	@Override
	public void insertCustomer(Customer customer) {
		this.ht.save(customer);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> select(Customer customer) {
		// TODO Auto-generated method stub
		String sql = String.format(
				"from Customer where custName like '%%%s%%' and custLevel = %d and  custSource like '%%%s%%'",
				customer.getCustName(), customer.getDict().getDid(), customer.getCustSource());
		return (List<Customer>) this.ht.find(sql);
	}

	@Override
	public List<?> selectCustomerLevel() {
		// TODO Auto-generated method stub
		Session session = this.ht.getSessionFactory().getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery("select d.dname,count(c.custLevel) from t_customer c,t_dict d WHERE c.custLevel=d.did group by d.did");
		//转换结果
		//sqlQuery.setResultTransformer(Transformers.aliasToBean(ArrayList.class));
		return sqlQuery.list();
	}

	@Override
	public int selectCountCustomer() {
		// TODO Auto-generated method stub
		Session session = this.ht.getSessionFactory().getCurrentSession();
		SQLQuery sqlQuery = session.createSQLQuery("SELECT COUNT(*) FROM t_customer");
		return Integer.valueOf(sqlQuery.list().get(0).toString());
	}
}