package adminaction;

import object.Admin;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.AdminDbManager;
import db.StudentDbManager;

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport {
	private AdminDbManager adminDao;
	private StudentDbManager studentDao;
	private Admin admin;
	private String CertCode;

	public String getCertCode() {
		return CertCode;
	}

	public void setCertCode(String certCode) {
		CertCode = certCode;
	}

	public StudentDbManager getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDbManager studentDao) {
		this.studentDao = studentDao;
	}

	public AdminDbManager getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDbManager adminDao) {
		this.adminDao = adminDao;
	}

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	@Override
	public String execute() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		String pass = (String) ctx.getSession().get("certCode");
		if (CertCode.equals(pass)) {
			Admin temp = adminDao.queryByName(admin.getUsername());
			if (temp != null) {
				if (temp.getPassword().equals(admin.getPassword())) {
					ctx.getSession().put("ADMIN", temp);
					ctx.getSession().put("ADMIN_NAME", temp.getUsername());
					ctx.getSession().put("tip", "");
					return SUCCESS;
				} else {
					ctx.getSession().put("tip", "密码错误！");
					return ERROR;
				}
			} else {
				ctx.getSession().put("tip", "用户名不存在！");
				return NONE;
			}
		} else {
			ctx.getSession().put("tip", "验证码错误！");
			return INPUT;
		}
	}
}
