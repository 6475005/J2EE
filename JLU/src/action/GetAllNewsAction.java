package action;

import java.util.List;

import object.News;

import com.opensymphony.xwork2.ActionSupport;

import db.NewsDbManager;

public class GetAllNewsAction extends ActionSupport{
	private int currentPage;
	private int countPage;
	private int countNews;
	private List<News> newslist;
	private NewsDbManager newsDao;
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getCountPage() {
		return countPage;
	}
	public void setCountPage(int countPage) {
		this.countPage = countPage;
	}
	public int getCountNews() {
		return countNews;
	}
	public void setCountNews(int countNews) {
		this.countNews = countNews;
	}
	public List<News> getNewslist() {
		return newslist;
	}
	public void setNewslist(List<News> newslist) {
		this.newslist = newslist;
	}
	public NewsDbManager getNewsDao() {
		return newsDao;
	}
	public void setNewsDao(NewsDbManager newsDao) {
		this.newsDao = newsDao;
	}
	@Override
	public String execute() throws Exception {
		if (currentPage <= 0) {
			currentPage = 1;
		}
		countNews = newsDao.queryAll().size();
		countPage = countNews / 10 + 1;
		if (currentPage >= countPage) {
			currentPage = countPage;
		}
		newslist = newsDao.getNewsByPaging(currentPage);
		return "updatanews";
	}
	public String getSheLianNews(){
		if (currentPage <= 0) {
			currentPage = 1;
		}
		countNews = newsDao.querySheLian().size();
		countPage = countNews / 10 + 1;
		if (currentPage >= countPage) {
			currentPage = countPage;
		}
		newslist = newsDao.getNewsByPaging(currentPage,"社联新闻");
		return "sheliannews";
	}
	public String getSheTuanNews(){
		if (currentPage <= 0) {
			currentPage = 1;
		}
		countNews = newsDao.querySheTuan().size();
		countPage = countNews / 10 + 1;
		if (currentPage >= countPage) {
			currentPage = countPage;
		}
		newslist = newsDao.getNewsByPaging(currentPage,"社团新闻");
		return "shetuannews";
	}
	public String getImportantNews(){
		if (currentPage <= 0) {
			currentPage = 1;
		}
		countNews = newsDao.queryImportant().size();
		countPage = countNews / 10 + 1;
		if (currentPage >= countPage) {
			currentPage = countPage;
		}
		newslist = newsDao.getNewsByPaging(currentPage,"要闻提示");
		return "importantnews";
	}
	
}
