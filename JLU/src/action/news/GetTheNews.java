package action.news;

import object.News;
import sql_inj.sql_inj;

import com.opensymphony.xwork2.ActionSupport;

import db.NewsDbManager;

public class GetTheNews extends ActionSupport{
	private NewsDbManager newsDao;
	private News news;
	private String title;
	private int id;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String execute() throws Exception {
		if (sql_inj.sql_inj(title)) {
			return "sqlinj";
		}
		title = new String(title.getBytes("ISO-8859-1"),"UTF-8");
		news = newsDao.get(id, title);
		return SUCCESS;
	}
	
}
