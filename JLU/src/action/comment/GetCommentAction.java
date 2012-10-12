package action.comment;

import java.util.List;

import object.Comment;

import com.opensymphony.xwork2.ActionSupport;

import db.CommentDbManager;

public class GetCommentAction extends ActionSupport{
	private int currentPage;
	private int countPage;
	private int countNews;
	private String type;
	private CommentDbManager commentDao;
	private List<Comment> list;
	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

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

	public CommentDbManager getCommentDao() {
		return commentDao;
	}

	public void setCommentDao(CommentDbManager commentDao) {
		this.commentDao = commentDao;
	}

	public List<Comment> getList() {
		return list;
	}

	public void setList(List<Comment> list) {
		this.list = list;
	}

	@Override
	public String execute() throws Exception {
		if (currentPage <= 0) {
			currentPage = 1;
		}
		countNews = commentDao.querySize(type).size();
		countPage = countNews / 5 + 1;
		if (currentPage >= countPage) {
			currentPage = countPage;
		}
		list = commentDao.getCommentByPaging(currentPage,type);
		return type;
	}
	
}
