package action.news;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletResponseAware;

import object.News;
import sql_inj.sql_inj;

import com.opensymphony.xwork2.ActionSupport;

import db.NewsDbManager;

public class QueryNews extends ActionSupport implements ServletResponseAware {
	private javax.servlet.http.HttpServletResponse response;
	private NewsDbManager newsDao;
	private String title;
	private List<News> list;

	public javax.servlet.http.HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(javax.servlet.http.HttpServletResponse response) {
		this.response = response;
	}

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

	public List<News> getList() {
		return list;
	}

	public void setList(List<News> list) {
		this.list = list;
	}

	@Override
	public String execute() throws Exception {
		if (title.equals("")) {
			response.setContentType("text/html;charset=UTF-8");
			response.setCharacterEncoding("UTF-8");// 防止弹出的信息出现乱码
			PrintWriter out = response.getWriter();
			out.print("<script>alert('请输入检索新闻标题！')</script>");
			out.print("<script>window.location.href='index'</script>");
			out.flush();
			out.close();
		} else {
			if (sql_inj.sql_content(title)) {
				return "sqlinj";
			}
			list = newsDao.queryNews(title);
		}
		return SUCCESS;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}

}
