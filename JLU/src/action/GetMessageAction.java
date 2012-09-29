package action;

import java.util.List;

import object.Message;

import com.opensymphony.xwork2.ActionSupport;

import db.MessageDbManager;

public class GetMessageAction extends ActionSupport{
	private int currentPage;
	private int countPage;
	private int countNews;
	private MessageDbManager messageDao;
	private List<Message> list;
	
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

	public MessageDbManager getMessageDao() {
		return messageDao;
	}

	public void setMessageDao(MessageDbManager messageDao) {
		this.messageDao = messageDao;
	}

	public List<Message> getList() {
		return list;
	}

	public void setList(List<Message> list) {
		this.list = list;
	}

	@Override
	public String execute() throws Exception {
		if (currentPage <= 0) {
			currentPage = 1;
		}
		List<Message> temp = messageDao.queryAll();
		if(temp.equals(null)){
			return SUCCESS;
		}
		countNews = temp.size();
		countPage = countNews / 10 + 1;
		if (currentPage >= countPage) {
			currentPage = countPage;
		}
		
		list = messageDao.getNewsByPaging(currentPage);
		return SUCCESS;
	}
	
}
