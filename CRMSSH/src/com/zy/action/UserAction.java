package com.zy.action;

import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zy.entity.User;
import com.zy.service.IUserService;

@SuppressWarnings("serial")
@Controller
public class UserAction extends ActionSupport {
	@Autowired
	private IUserService service;

	private User user;

	//登录
	public String login() {
		boolean b = service.login(this.getUser());
		if (b) {
			Map<String, Object> map = ActionContext.getContext().getSession();
			map.put("username", user.getUserName());
			return SUCCESS;
		}
		return ERROR;
	}
	
	// 注销
	public String logout() {
		ServletActionContext.getRequest().getSession().invalidate();
		return SUCCESS;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
