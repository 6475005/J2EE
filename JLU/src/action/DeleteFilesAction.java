package action;

import java.io.File;

import object.Admin;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteFilesAction extends ActionSupport {
	private String name;
	private String savePath;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSavePath() {
		return savePath;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	@Override
	public String execute() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		Admin admin = (Admin) ctx.getSession().get("ADMIN");
		if (admin != null) {
			setSavePath(ServletActionContext.getServletContext().getRealPath(
					"/WEB-INF/" + "upload/"));
			name = new String(name.getBytes("ISO-8859-1"), "UTF-8");
			System.out.println(name + "!!");
			File file = new File(savePath + "/" + name);
			if (file.exists()) {
				file.delete();
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
