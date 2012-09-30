package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DownloadAction extends ActionSupport implements
		ServletResponseAware {
	private javax.servlet.http.HttpServletResponse response;
	private String name;
	private InputStream input;

	public InputStream getInput() {
		return input;
	}

	public void setInput(InputStream inputStream) {
		this.input = inputStream;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String execute() throws IOException {
		ActionContext ctx = ActionContext.getContext();
		String ip = (String) ctx.getSession().get("IP");
		if (!CheckIP.checkIP(ip)) {
			response.setContentType("text/html;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");// 防止弹出的信息出现乱码
			PrintWriter out = response.getWriter();
			out.print("<script>alert('该资源只提供吉大校内网用户下载！')</script>");
			out.print("<script>window.location.href='getFileDownload'</script>");
			out.flush();
			out.close();
		}
		if (sql_inj.sql_inj(name)) {
			return "sqlinj";
		}
		try {
			name = new String(name.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		String path = ServletActionContext.getServletContext().getRealPath(
				"/WEB-INF/" + "upload/")
				+ "/" + name;
		try {
			input = new FileInputStream(new File(path));
			name = new String(this.name.getBytes(), "ISO8859-1");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

}
