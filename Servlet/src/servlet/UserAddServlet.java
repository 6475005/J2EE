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
 * Servlet implementation class UserAddServlet
 */
public class UserAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserAddServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = new String(request.getParameter("username").getBytes(
				"ISO-8859-1"), "UTF-8");
		String password = new String(request.getParameter("password").getBytes(
				"ISO-8859-1"), "UTF-8");
		String name = new String(request.getParameter("name").getBytes(
				"ISO-8859-1"), "UTF-8");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String lasttime = df.format(new Date());

		HttpSession session = request.getSession();
		String acount = (String) session.getAttribute("username");

		String url = null;
		if (acount != null) {
			try {
				if (username.length() <= 0 || password.length() <= 0
						|| name.length() <= 0) {
					session.putValue("tip", "用户名密码不为空！");
					url = "users_add.jsp";
				} else {
					User admin = new User(0, username, password, name, lasttime);
					if (UserDb.regist(admin)) {
						session.putValue("trp", "");
						url = "users.jsp";
					} else {
						session.putValue("tip", "用户名已存在！");
						url = "users_add.jsp";
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			url = "logout.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
}
