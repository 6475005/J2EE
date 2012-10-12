package action.message;

import object.Admin;
import object.Message;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.MessageDbManager;

public class GetTheMessage extends ActionSupport {
	private MessageDbManager messageDao;
	private Message message;
	private int id;

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public MessageDbManager getMessageDao() {
		return messageDao;
	}

	public void setMessageDao(MessageDbManager messageDao) {
		this.messageDao = messageDao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String execute() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		Admin admin = (Admin) ctx.getSession().get("ADMIN");
		if (admin != null) {
			message = messageDao.get(id);
			ctx.getSession().put("tip", "");
			return SUCCESS;
		} else {
			ctx.getSession().put("tip", "ÇëÏÈµÇÂ¼ÏµÍ³£¡");
			return INPUT;
		}
	}

}
