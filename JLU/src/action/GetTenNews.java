package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import object.News;

import com.opensymphony.xwork2.ActionSupport;

import db.NewsDbManager;

public class GetTenNews extends ActionSupport{
	private NewsDbManager newsDao;
	private List<News> newslist;
	public NewsDbManager getNewsDao() {
		return newsDao;
	}
	public void setNewsDao(NewsDbManager newsDao) {
		this.newsDao = newsDao;
	}
	public List<News> getNewslist() {
		return newslist;
	}
	public void setNewslist(List<News> newslist) {
		this.newslist = newslist;
	}
	@Override
	public String execute() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("T_flag", "123");
		newslist = newsDao.getTenNews();
		return SUCCESS;
	}
	
}
