package action.comment;

import java.text.SimpleDateFormat;
import java.util.Date;

import object.Comment;
import sql_inj.sql_inj;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import db.CommentDbManager;

public class addCommentAction extends ActionSupport{
	private CommentDbManager commentDao;
	private String type;
	private String content;
	private String author;
	private String CertCode;
	public CommentDbManager getCommentDao() {
		return commentDao;
	}
	public void setCommentDao(CommentDbManager commentDao) {
		this.commentDao = commentDao;
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCertCode() {
		return CertCode;
	}
	public void setCertCode(String certCode) {
		CertCode = certCode;
	}
	@Override
	public String execute() throws Exception {
		type = type.trim();
		content = content.trim();
		author = author.trim();
		ActionContext ctx = ActionContext.getContext();
		String pass = (String) ctx.getSession().get("certCode");
		if (CertCode.equals(pass)) {
			if (type.equals("")) {
				ctx.getSession().put("tip", "类别不为空！");
				return SUCCESS;
			}
			if (content.equals("")) {
				ctx.getSession().put("tip", "内容不为空！");
				return SUCCESS;
			}
			if (content.length() > 300) {
				ctx.getSession().put("tip", "评论超长！");
				return SUCCESS;
			}
			if (author.equals("")) {
				ctx.getSession().put("tip", "昵称不为空！");
				return SUCCESS;
			}
			if (author.length() > 8) {
				ctx.getSession().put("tip", "超长或包含非法字符！");
				return SUCCESS;
			}
			if (sql_inj.sql_content(content)) {
				return "sqlinj";
			}
			Comment comment = new Comment();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			comment.setType(type);
			comment.setContent(content);
			comment.setAuthor(author);
			comment.setDate(df.format(new Date()));
			commentDao.add(comment);
			ctx.getSession().put("tip", "");
			return SUCCESS;
		}else{
			ctx.getSession().put("tip", "验证码错误！");
			return SUCCESS;
		}
		
	}
	
}
