package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.java.swing.plaf.windows.resources.windows;

import db.AdminDb;

import object.Admin;

/**
 * Servlet implementation class registServlet
 */
public class AdminAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminAddServlet() {
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
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		String url = null;

		HttpSession session = request.getSession();
		String acount = (String) session.getAttribute("username");

		if (acount != null) {
			Admin admin = new Admin(username, password);
			if (password.length() <= 0 || repassword.length() <= 0
					|| username.length() <= 0) {
				session.putValue("tip", "账号、密码不为空！");
				url = "addmanager.jsp";
			} else {
				if (password.equals(repassword)) {
					try {
						if (AdminDb.regist(admin)) {
							session.putValue("trp", "");
							url = "buildings.jsp";
						} else {
							session.putValue("tip", "用户名已存在！");
							url = "addmanager.jsp";
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} else {
					session.putValue("tip", "两次密码不一致！");
					url = "addmanager.jsp";
				}
			}
		} else {
			url = "logout.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}

}
