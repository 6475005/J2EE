package action.news;

import java.text.SimpleDateFormat;
import java.util.Date;

import object.Admin;
import object.News;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.NewsDbManager;

public class UpdataNewsAction extends ActionSupport {
	private NewsDbManager newsDao;
	private String title;
	private String type;
	private String content;
	private Integer state;
	

	public NewsDbManager getNewsDao() {
		return newsDao;
	}

	public void setNewsDao(NewsDbManager newsDao) {
		this.newsDao = newsDao;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@Override
	public String execute() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		Admin admin = (Admin) ctx.getSession().get("ADMIN");
		if (admin != null) {
			News news = new News();
			news.setTitle(title);
			news.setType(type);
			news.setContent(content);
			news.setState(state);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String date = df.format(new Date());
			news.setDate(date);
			news.setAuthor(admin.getName());
			news.setPartment(admin.getPartment());
			newsDao.updata(news);
			ctx.getSession().put("tip", "");
			return SUCCESS;
		} else {
			ctx.getSession().put("tip", "ÇëÏÈµÇÂ¼ÏµÍ³£¡");
			return INPUT;
		}
	}

}
