package action.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import object.MyFile;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class GetFileToDownload extends ActionSupport {
	private List<MyFile> filelist = new ArrayList<MyFile>();
	private String savePath;

	public void setSavePath(String value) {
		this.savePath = value;
	}

	public String getSavePath() {
		return savePath;
	}

	public List<MyFile> getFilelist() {
		return filelist;
	}

	public void setFilelist(List<MyFile> filelist) {
		this.filelist = filelist;
	}

	@Override
	public String execute() throws Exception {
		setSavePath(ServletActionContext.getServletContext().getRealPath(
				"/WEB-INF/" + "upload/"));
		File directory = new File(savePath);
		if(!directory.exists()){
			directory.mkdir();
		}
		File[] fileList = directory.listFiles();
		if (fileList.length == 0 || fileList.equals(null)) {
			return ERROR;
		}
		for (int i = 0; i < fileList.length; i++) {
			MyFile file = new MyFile(fileList[i].getName(), savePath + "/");
			filelist.add(file);
		}
		return SUCCESS;
	}

}
