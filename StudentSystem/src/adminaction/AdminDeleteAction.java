package adminaction;

import object.Admin;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.AdminDbManager;

public class AdminDeleteAction extends ActionSupport {

	private AdminDbManager adminDao;
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public AdminDbManager getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDbManager adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public String execute() throws Exception {
		Admin admin = (Admin) ActionContext.getContext().getSession()
				.get("ADMIN");
		if (admin.getPassword().equals(password)) {
			adminDao.delete(admin);
			ActionContext.getContext().getSession().clear();
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
}
