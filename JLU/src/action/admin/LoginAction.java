package action.admin;

import java.text.SimpleDateFormat;
import java.util.Date;

import object.Admin;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.AdminDbManager;

public class LoginAction extends ActionSupport {
	private AdminDbManager adminDao;
	private Admin admin;
	private String CertCode;

	public String getCertCode() {
		return CertCode;
	}

	public void setCertCode(String certCode) {
		CertCode = certCode;
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
			Admin temp = adminDao.queryByUsername(admin.getUsername());
			if (temp != null) {
				if (temp.getState() != 0) {
					if (temp.getPassword().equals(admin.getPassword())) {
						ActionContext ctx2 = ActionContext.getContext();
						ctx2.getSession().put("ADMIN", temp);
						ctx2.getSession().put("NAME", temp.getName());
						ctx2.getSession().put("TIME", temp.getDate());
						Date date = new Date();
						SimpleDateFormat df = new SimpleDateFormat(
								"yyyy-MM-dd HH:mm:ss");
						temp.setDate(df.format(date));
						temp.setError(0);
						adminDao.updata(temp);
						ctx.getSession().put("top", "");
						return SUCCESS;
					} else {
						if (temp.getError() < 3) {
							temp.setError(temp.getError() + 1);
							adminDao.updata(temp);
						} else {
							temp.setState(0);
							SimpleDateFormat df = new SimpleDateFormat(
									"yyyy-MM-dd HH:mm:ss");
							temp.setLasttime(df.format(new Date()));
							adminDao.updata(temp);
							ctx.getSession().put("top", "密码错误超过3次，24小时后重试！");
							return INPUT;
						}
						ctx.getSession().put("top", "用户名或密码错误！");
						return ERROR;
					}
				} else {
					SimpleDateFormat df = new SimpleDateFormat(
							"yyyy-MM-dd HH:mm:ss");
					Date d = df.parse(temp.getLasttime());
					Date d2 = new Date();
					if (d.getHours() - d2.getHours() >= 24) {
						temp.setError(0);
						temp.setState(1);
						adminDao.updata(temp);
						ctx.getSession().put("top", "账号已解锁，请重新登录!");
						return INPUT;
					}
					ctx.getSession().put("top", "密码错误超过3次，24小时后重试！");
					return INPUT;
				}
			} else {
				ctx.getSession().put("top", "用户名不存在！");
				return NONE;
			}
		} else {
			ctx.getSession().put("top", "验证码错误！");
			return INPUT;
		}
	}

}
