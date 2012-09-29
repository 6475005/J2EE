package action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class DownloadAction extends ActionSupport {
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

	public String execute() {
		if (sql_inj.sql_inj(name)){
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

}
