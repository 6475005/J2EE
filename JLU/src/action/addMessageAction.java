package action;

import java.text.SimpleDateFormat;
import java.util.Date;

import object.Message;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.xml.internal.ws.encoding.xml.XMLMessage.MessageDataSource;

import db.MessageDbManager;

public class addMessageAction extends ActionSupport {
	private MessageDbManager messageDao;
	private String type;
	private String title;
	private String content;
	private String author;
	private String qq;
	private String phone;
	private String CertCode;

	public String getCertCode() {
		return CertCode;
	}

	public void setCertCode(String certCode) {
		CertCode = certCode;
	}

	public MessageDbManager getMessageDao() {
		return messageDao;
	}

	public void setMessageDao(MessageDbManager messageDao) {
		this.messageDao = messageDao;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String execute() throws Exception {
		type = type.trim();
		title = title.trim();
		content = content.trim();
		author = author.trim();
		phone = phone.trim();
		qq = qq.trim();
		ActionContext ctx = ActionContext.getContext();
		String pass = (String) ctx.getSession().get("certCode");
		if (CertCode.equals(pass)) {
			if (type.equals("")) {
				ctx.getSession().put("tip", "类别不为空！");
				return INPUT;
			}
			if (!(type.equals("留言") || type.equals("投诉"))) {
				ctx.getSession().put("tip", "类别不合法！");
				return INPUT;
			}
			if (title.equals("")) {
				ctx.getSession().put("tip", "标题不为空！");
				return INPUT;
			}
			if (content.equals("")) {
				ctx.getSession().put("tip", "内容不为空！");
				return INPUT;
			}
			if (content.length() > 800) {
				ctx.getSession().put("tip", "留言超长！");
				return ERROR;
			}
			if (author.equals("")) {
				ctx.getSession().put("tip", "昵称不为空！");
				return INPUT;
			}
			if (qq.equals("")) {
				ctx.getSession().put("tip", "qq不为空！");
				return INPUT;
			}
			if (!isInteger(qq) || qq.length() < 5) {
				ctx.getSession().put("tip", "qq为数字且6位至11位！");
				return INPUT;
			}
			if (phone.equals("")) {
				ctx.getSession().put("tip", "电话不为空！");
				return INPUT;
			}
			if (!isInteger(phone) || phone.length() < 6) {
				ctx.getSession().put("tip", "电话为数字且7位至11位！");
				return INPUT;
			}
			Message message = new Message();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			title = htmlspecialchars(title);
			if (title.length() > 20) {
				ctx.getSession().put("tip", "超长或包含非法字符！");
				return ERROR;
			}
			if (author.length() > 8) {
				ctx.getSession().put("tip", "超长或包含非法字符！");
				return ERROR;
			}
			if (qq.length() > 11) {
				ctx.getSession().put("tip", "超长或包含非法字符！");
				return ERROR;
			}
			if (phone.length() > 11) {
				ctx.getSession().put("tip", "超长或包含非法字符！");
				return ERROR;
			}
			if (sql_inj.sql_inj(type) || sql_inj.sql_inj(title)
					|| sql_inj.sql_inj(author)) {
				return "sqlinj";
			}
			if (sql_inj.sql_content(content)) {
				return "sqlinj";
			}
			message.setTitle(title);
			message.setType(type);
			message.setAuthor(author);
			message.setContent(content);
			message.setQq(qq);
			message.setPhone(phone);
			message.setDate(df.format(new Date()));
			messageDao.add(message);
			return SUCCESS;
		} else {
			ctx.getSession().put("tip", "验证码错误！");
			return ERROR;
		}
	}

	private String htmlspecialchars(String str) {
		str = str.replaceAll("&", "&amp;");
		str = str.replaceAll("<", "&lt;");
		str = str.replaceAll(">", "&gt;");
		str = str.replaceAll("\"", "&quot;");
		return str;
	}

	public static boolean isInteger(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
