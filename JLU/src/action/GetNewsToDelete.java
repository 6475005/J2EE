package action;

import java.util.List;

import object.Admin;
import object.News;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.NewsDbManager;

public class GetNewsToDelete extends ActionSupport {
	private int currentPage;
	private int countPage;
	private int countNews;
	private List<News> newslist;
	private NewsDbManager newsDao;

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

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
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
		ActionContext ctx = ActionContext.getContext();
		Admin admin = (Admin) ctx.getSession().get("ADMIN");
		if (admin != null) {
			if (currentPage <= 0) {
				currentPage = 1;
			}
			countNews = newsDao.queryAll().size();
			countPage = countNews / 10 + 1;
			if (currentPage >= countPage) {
				currentPage = countPage;
			}
			newslist = newsDao.getNewsByPaging(currentPage);
			return "deletenews";
		} else {
			ctx.getSession().put("tip", "ÇëÏÈµÇÂ¼ÏµÍ³£¡");
			return INPUT;
		}
	}

}
