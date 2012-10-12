package action.message;

import object.Admin;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.MessageDbManager;

public class DeleteMessageAction extends ActionSupport {
	private int id;
	private MessageDbManager messageDao;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public MessageDbManager getMessageDao() {
		return messageDao;
	}

	public void setMessageDao(MessageDbManager messageDao) {
		this.messageDao = messageDao;
	}

	@Override
	public String execute() throws Exception {
		ActionContext ctx = ActionContext.getContext();
		Admin admin = (Admin) ctx.getSession().get("ADMIN");
		if (admin != null) {
			messageDao.delete(id);
			ctx.getSession().put("tip", "");
			return SUCCESS;
		} else {
			ctx.getSession().put("tip", "ÇëÏÈµÇÂ¼ÏµÍ³£¡");
			return INPUT;
		}
	}

}
