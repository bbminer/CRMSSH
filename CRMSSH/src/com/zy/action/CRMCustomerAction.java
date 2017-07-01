package com.zy.action;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zy.entity.Customer;
import com.zy.entity.Dict;
import com.zy.entity.PageBean;
import com.zy.entity.User;
import com.zy.service.ICustomerService;

@Controller
public class CRMCustomerAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private User user;
	private int cid;
	private Customer customer;
	// 分页
	private PageBean pageBean;
	@Autowired
	private ICustomerService service;

	// 查看所有客户
	public String selectAllCustomer() {
		List<Customer> list = service.selectAllCustomer();
		;
		if (list != null && list.size() > 0) {
			Map<String, Object> map = ActionContext.getContext().getSession();
			map.put("allCustomer", list);
			return SUCCESS;
		}
		return ERROR;
	}

	// 删除一个客户
	public String deleteCustomer() {
		if (service.deleteCustomer(this.getCid())) {
			return SUCCESS;
		}
		return ERROR;
	}

	// 修改客户
	public String updateCustomer() {
		if (service.updateCustomer(this.getCustomer()) != null) {
			return SUCCESS;
		}
		return ERROR;
	}

	// 根据名称查询客户
	public String selectByName() {
		List<Customer> list = service.selectCustomerByName(this.customer.getCustName());
		if (list != null && list.size() > 0) {
			Map<String, Object> map = ActionContext.getContext().getSession();
			map.put("allCustomer", list);
			return SUCCESS;
		}
		return ERROR;
	}

	// 查询所有的客户级别
	public String selectAllDict() {
		List<Dict> dict = service.selectAllDict();
		if (this.getCid() > 0) {
			customer = service.selectCustomer(this.getCid());
		}
		if (dict != null && dict.size() > 0) {
			Map<String, Object> map = ActionContext.getContext().getSession();
			map.put("allDict", dict);
			return SUCCESS;
		}
		return ERROR;
	}

	// 新增客户
	public String addCustomer() {
		if (service.insertCustomer(this.getCustomer())) {
			return SUCCESS;
		}
		return ERROR;
	}

	// 动态查询客户
	public String select() {
		List<Customer> list = service.select(this.getCustomer());
		if (list != null && list.size() > 0) {
			Map<String, Object> map = ActionContext.getContext().getSession();
			map.put("allCustomer", list);
			return SUCCESS;
		}
		return ERROR;
	}

	// 客户来源统计
	public String sourceCount() {
		List<?> list = service.selectCustomerSource();
		if (list != null && list.size() > 0) {
			Map<String, Object> map = ActionContext.getContext().getSession();
			map.put("allCustomerSource", list);
			return SUCCESS;
		}
		return ERROR;
	}

	// 客户级别统计
	public String levelCount() {
		List<?> list = service.selectCustomerLevel();
		if (list != null && list.size() > 0) {
			Map<String, Object> map = ActionContext.getContext().getSession();
			map.put("allCustomerLevel", list);
			return SUCCESS;
		}
		return ERROR;
	}

	// 分页
	public String limitPage() {
		int startRow = this.getPageBean().getCurrentPage(); // 从数据库中第几条开始拿
		int pageCount = 3; // 每页展示几条
		List<Customer> list = service.selectLimit((startRow - 1) * pageCount, pageCount);
		if (list != null && list.size() > 0) {
			int rowsCount = service.selectCountCustomer();
			pageBean.setRowsCount(rowsCount);
			pageBean.setList(list);
			pageBean.setTotalPage(rowsCount % pageCount == 0 ? (rowsCount / pageCount) : (rowsCount / pageCount + 1));
			return SUCCESS;
		}
		return ERROR;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
}