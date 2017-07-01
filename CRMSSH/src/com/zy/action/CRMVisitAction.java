package com.zy.action;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zy.entity.Customer;
import com.zy.entity.User;
import com.zy.entity.Visit;
import com.zy.service.ICustomerService;
import com.zy.service.IUserService;
import com.zy.service.IVisitService;

@Controller
public class CRMVisitAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private int id;
	private Visit visit;

	@Autowired
	private IVisitService vService;
	@Autowired
	private ICustomerService cService;
	@Autowired
	private IUserService uService;

	// 查询所有拜访记录
	public String selectVisit() {
		List<Visit> list = vService.selectAllVisit();
		if (list.size() > 0 && list != null) {
			Map<String, Object> map = ActionContext.getContext().getSession();
			map.put("listAllVisit", list);
			return SUCCESS;
		}
		return ERROR;
	}

	// 跳到修改界面
	public String toVisitEditPage() {
		prepare();
		visit = vService.selectVisit(id);
		return SUCCESS;
	}

	// 修改拜访记录
	public String visitUpdate() {
		if (vService.updateLinkMan(this.getVisit())) {
			return SUCCESS;
		}
		return ERROR;
	}

	// 根据地址查询拜访记录
	public String selectByAddress() {
		List<Visit> list = vService.selectVisitByAddress(this.visit.getAddress());
		if (list != null && list.size() > 0) {
			Map<String, Object> map = ActionContext.getContext().getSession();
			map.put("listAllVisit", list);
			return SUCCESS;
		}
		return ERROR;
	}

	// 跳到新增拜访记录界面
	public String toVisitAddPage() {
		prepare();
		return SUCCESS;
	}

	// 新增拜访记录
	public String addVisit() {
		if (vService.insertVisit(this.getVisit())) {
			return SUCCESS;
		}
		return ERROR;
	}

	// 动态查询拜访记录
	public String select() {
		List<Visit> list = vService.select(this.getVisit());
		if (list != null && list.size() > 0) {
			Map<String, Object> map = ActionContext.getContext().getSession();
			map.put("listAllVisit", list);
			return SUCCESS;
		}
		return ERROR;
	}

	private void prepare() {
		List<Customer> allCustomer = cService.selectAllCustomer();
		Map<String, Object> map = ActionContext.getContext().getSession();
		if (allCustomer.size() > 0 && allCustomer != null) {
			map.put("visitOfAllCustomer", allCustomer);
		}

		List<User> usList = uService.selectAllUser();
		if (usList.size() > 0 && usList != null) {
			map.put("visitOfAllUser", usList);
		}
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Visit getVisit() {
		return visit;
	}

	public void setVisit(Visit visit) {
		this.visit = visit;
	}

	/*
	 * // 修改联系人 public String updateLinkman() { CRMLinkManImpl cImpl = new
	 * CRMLinkManImpl(); if (cImpl.selectLinkman(this.getLinkMan()) != null) {
	 * return SUCCESS; } return ERROR; }
	 * 
	 * // 跳到修改界面 public String toLinkManEditPage() {
	 * 
	 * CRMCustomerImpl customerImpl = new CRMCustomerImpl(); List<Customer>
	 * allCustomer = customerImpl.selectAllCustomer(); if (allCustomer.size() >
	 * 0 && allCustomer != null) { Map<String, Object> map =
	 * ActionContext.getContext().getSession(); map.put("linkManOfAllCustomer",
	 * allCustomer); } CRMLinkManImpl cImpl = new CRMLinkManImpl(); linkMan =
	 * cImpl.selectLinkMan(String.format("%d", this.getLid())); return SUCCESS;
	 * }
	 * 
	 * // 修改联系人 public String updateLinkMan() { CRMLinkManImpl cImpl = new
	 * CRMLinkManImpl(); if (cImpl.updateLinkMan(this.getLinkMan()) != null) {
	 * return SUCCESS; } return ERROR; }
	 * 
	 * // 跳到增加联系人界面 public String toLinkmanAddPage() { CRMCustomerImpl
	 * customerImpl = new CRMCustomerImpl(); List<Customer> allCustomer =
	 * customerImpl.selectAllCustomer(); if (allCustomer.size() > 0 &&
	 * allCustomer != null) { Map<String, Object> map =
	 * ActionContext.getContext().getSession(); map.put("linkManOfAllCustomer",
	 * allCustomer); } return SUCCESS; }
	 * 
	 * // 新增联系人 public String addLinkMan() { // 处理上传文件 if (upload!=null) {
	 * String realPath =
	 * ServletActionContext.getServletContext().getRealPath(path);
	 * System.out.println(realPath); String extension =
	 * FilenameUtils.getExtension(uploadFileName); String newName =
	 * String.format("%s.%s", UUID.randomUUID(), extension); File file = new
	 * File(realPath, newName); try { FileUtils.copyFile(upload, file); } catch
	 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace();
	 * } } CRMLinkManImpl cImpl = new CRMLinkManImpl(); if
	 * (cImpl.insertLinkMan(this.getLinkMan())) { return SUCCESS; } return
	 * ERROR; }
	 */

}
