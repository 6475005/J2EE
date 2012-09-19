package adminaction;

import object.Admin;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.AdminDbManager;

@SuppressWarnings("serial")
public class AdminRepasswordAction extends ActionSupport {
	private AdminDbManager adminDao;
	private String password;
	private String newpassword;
	private String repassword;


	public AdminDbManager getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDbManager adminDao) {
		this.adminDao = adminDao;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	@Override
	public String execute() throws Exception {
		Admin admin = (Admin)ActionContext.getContext().getSession().get("ADMIN");
		if (password.equals(admin.getPassword())) {
			admin.setPassword(newpassword);
			adminDao.updata(admin);
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

}
