package action.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.filechooser.FileSystemView;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class GetFilesAction extends ActionSupport {
	private List<String> filelist = new ArrayList<String>();
	private String savePath;

	public void setSavePath(String value) {
		this.savePath = value;
	}
	public String getSavePath() {
		return savePath;
	}

	public List<String> getFilelist() {
		return filelist;
	}

	public void setFilelist(List<String> filelist) {
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
		for(int i=0;i<fileList.length;i++){
			filelist.add(fileList[i].getName());
		}
		return SUCCESS;
	}

}
