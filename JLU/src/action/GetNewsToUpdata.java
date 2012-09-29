package action;

import object.Admin;
import object.News;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.NewsDbManager;

public class GetNewsToUpdata extends ActionSupport {
	private NewsDbManager newsDao;
	private Integer id;
	private String content;
	private String title;

	public NewsDbManager getNewsDao() {
		return newsDao;
	}

	public void setNewsDao(NewsDbManager newsDao) {
		this.newsDao = newsDao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String execute() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		Admin admin = (Admin) ctx.getSession().get("ADMIN");
		if (admin != null) {
			title = new String(title.getBytes("ISO-8859-1"), "UTF-8");
			News news = newsDao.get(id, title);
			content = news.getContent();
			return SUCCESS;
		} else {
			ctx.getSession().put("tip", "ÇëÏÈµÇÂ¼ÏµÍ³£¡");
			return INPUT;
		}
	}

}
