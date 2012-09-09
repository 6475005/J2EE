package adminaction;

import object.Admin;

import com.opensymphony.xwork2.ActionSupport;

import db.AdminDbManager;

public class AdminAddAction extends ActionSupport {
	private String username;
	private String password;
	private String repassword;
	private AdminDbManager adminDao;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public AdminDbManager getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDbManager adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public String execute() throws Exception {
		if (password != null && username != null) {
			if (password.equals(repassword)) {
				Admin admin = adminDao.queryByName(username);
				if (admin != null) {
					return ERROR;
				} else {
					adminDao.add(username, password);
					return SUCCESS;
				}
			}
		}
		return INPUT;
	}

}
