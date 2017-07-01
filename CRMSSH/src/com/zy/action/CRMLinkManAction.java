package com.zy.action;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zy.entity.Customer;
import com.zy.entity.LinkMan;
import com.zy.service.ICustomerService;
import com.zy.service.ILinkManService;

@SuppressWarnings("serial")
@Controller
public class CRMLinkManAction extends ActionSupport {
	private LinkMan linkMan;
	private int lid;
	// 上传文件
	private String path = "linkMan";
	private File upload;
	private String uploadFileName;

	@Autowired
	private ILinkManService lService;
	@Autowired
	private ICustomerService cService;

	// 查询所有联系人
	public String selectLinkman() {
		List<LinkMan> list = lService.selectAllLinkman();
		if (list.size() > 0 && list != null) {
			Map<String, Object> map = ActionContext.getContext().getSession();
			map.put("listLinkMan", list);
			return SUCCESS;
		}
		return ERROR;
	}

	// 跳到修改界面
	public String toLinkManEditPage() {
		List<Customer> allCustomer = cService.selectAllCustomer();
		if (allCustomer.size() > 0 && allCustomer != null) {
			Map<String, Object> map = ActionContext.getContext().getSession();
			map.put("linkManOfAllCustomer", allCustomer);
		}
		linkMan = lService.selectLinkMan(this.getLid());
		return SUCCESS;
	}

	// 修改联系人
	public String updateLinkMan() {
		if (lService.updateLinkMan(this.getLinkMan())) {
			return SUCCESS;
		}
		return ERROR;
	}

	// 跳到增加联系人界面
	public String toLinkmanAddPage() {
		List<Customer> allCustomer = cService.selectAllCustomer();
		if (allCustomer.size() > 0 && allCustomer != null) {
			Map<String, Object> map = ActionContext.getContext().getSession();
			map.put("linkManOfAllCustomer", allCustomer);
		}
		return SUCCESS;
	}

	// 新增联系人
	public String addLinkMan() {
		// 处理上传文件
		if (upload != null) {
			String realPath = ServletActionContext.getServletContext().getRealPath(path);
			System.out.println(realPath);
			String extension = FilenameUtils.getExtension(uploadFileName);
			String newName = String.format("%s.%s", UUID.randomUUID(), extension);
			File file = new File(realPath, newName);
			try {
				FileUtils.copyFile(upload, file);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (lService.insertLinkMan(this.getLinkMan())) {
			return SUCCESS;
		}
		return ERROR;
	}

	// 根据联系人名称查询
	public String selectLinkManByName() {
		List<LinkMan> list = lService.selectLinkManByName(this.getLinkMan().getName());
		if (list != null && list.size() > 0) {
			Map<String, Object> map = ActionContext.getContext().getSession();
			map.put("listLinkMan", list);
			return SUCCESS;
		}
		return ERROR;
	}

	// 动态查询联系人
	public String select() {
		List<LinkMan> list = lService.select(this.getLinkMan());
		if (list != null && list.size() > 0) {
			Map<String, Object> map = ActionContext.getContext().getSession();
			map.put("listLinkMan", list);
			return SUCCESS;
		}
		return ERROR;
	}

	public LinkMan getLinkMan() {
		return linkMan;
	}

	public void setLinkMan(LinkMan linkMan) {
		this.linkMan = linkMan;
	}

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}
}
