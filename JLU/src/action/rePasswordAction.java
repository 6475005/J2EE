package action;

import object.Admin;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.AdminDbManager;

public class rePasswordAction extends ActionSupport {
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
		ActionContext ctx = ActionContext.getContext();
		Admin admin = (Admin) ctx.getSession().get("ADMIN");
		if (admin != null) {
			if (admin.getPassword().equals(password)) {
				admin.setPassword(newpassword);
				adminDao.updata(admin);
				return SUCCESS;
			} else {
				return ERROR;
			}
		} else {
			ctx.getSession().put("tip", "ÇëÏÈµÇÂ¼ÏµÍ³£¡");
			return INPUT;
		}
	}

}
