package adminaction;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import object.Admin;
import object.Student;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.AdminDbManager;
import db.StudentDbManager;

@SuppressWarnings("serial")
public class LoginAction extends ActionSupport{
	private AdminDbManager adminDao;
	private StudentDbManager studentDao;
	private Admin admin;
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
		Admin temp = adminDao.queryByName(admin.getUsername());
		if (temp != null) {
			if (temp.getPassword().equals(admin.getPassword())) {
				ActionContext ctx = ActionContext.getContext();
				ctx.getSession().put("ADMIN", temp);
				ctx.getSession().put("ADMIN_NAME", temp.getUsername());
				
				return SUCCESS;
			}
		}
		return ERROR;
	}
}
