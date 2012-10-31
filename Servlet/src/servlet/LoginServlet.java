package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import object.Admin;
import object.User;

import db.AdminDb;
import db.UserDb;

/**
 * Servlet implementation class login
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String id = request.getParameter("id");
		String CertCode = request.getParameter("CertCode");

		String url = null;

		HttpSession session = request.getSession();
		String pass = (String) session.getValue("certCode");
		if (CertCode.equals(pass)) {
			if (id.equals("admin")) {
				Admin admin = null;
				try {
					admin = AdminDb.query(username);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (admin != null) {
					if (admin.getPassword().equals(password)) {
						url = "MyOffice.htm";
						session.putValue("id", "管理员");
						session.putValue("username", username);
						session.putValue("tip", "");
					} else {
						url = "login.jsp";
						session.putValue("tip", "用户名或密码错误！");
					}
				} else {
					url = "login.jsp";
					session.putValue("tip", "用户名或密码错误！");
				}
			}else{
				User admin = null;
				try {
					admin = UserDb.query(username);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (admin != null) {
					if (admin.getPassword().equals(password)) {
						SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						String lasttime = df.format(new Date());
						try {
							UserDb.update(username, lasttime);
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						url = "UserOffice.htm";
						session.putValue("id", "业主");
						session.putValue("username", username);
						session.putValue("tip", "");
					} else {
						url = "login.jsp";
						session.putValue("tip", "用户名或密码错误！");
					}
				} else {
					url = "login.jsp";
					session.putValue("tip", "用户名或密码错误！");
				}
			}
		} else {
			url = "login.jsp";
			session.putValue("tip", "验证码错误！");
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}