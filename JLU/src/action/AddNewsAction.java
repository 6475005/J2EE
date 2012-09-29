package action;

import java.text.SimpleDateFormat;
import java.util.Date;

import object.Admin;
import object.News;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.NewsDbManager;

public class AddNewsAction extends ActionSupport {
	private NewsDbManager newsDao;
	private News news;

	public NewsDbManager getNewsDao() {
		return newsDao;
	}

	public void setNewsDao(NewsDbManager newsDao) {
		this.newsDao = newsDao;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	@Override
	public String execute() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		Admin admin = (Admin) ctx.getSession().get("ADMIN");
		if (admin != null) {
			if (news.getTitle().equals("")) {
				return ERROR;
			}
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String date = df.format(new Date());
			news.setDate(date);
			news.setAuthor(admin.getName());
			news.setPartment(admin.getPartment());
			newsDao.save(news);
			return SUCCESS;
		} else {
			ctx.getSession().put("tip", "ÇëÏÈµÇÂ¼ÏµÍ³£¡");
			return INPUT;
		}
	}

}
