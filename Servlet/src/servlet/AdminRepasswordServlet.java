package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import object.Admin;
import db.AdminDb;

/**
 * Servlet implementation class AdminRepasswordServlet
 */
public class AdminRepasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminRepasswordServlet() {
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
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		HttpSession session = request.getSession();

		String username = (String) session.getAttribute("username");
		String acount = (String) session.getAttribute("username");
		String url = null;

		if (acount != null) {
			if (password.length() <= 0 || repassword.length() <= 0) {
				session.putValue("trp", "请输入密码及确认密码！");
				url = "repassword.jsp";
			} else {
				Admin admin = new Admin(username, password);
				if (password.equals(repassword)) {
					try {
						if (AdminDb.update(admin)) {
							session.putValue("trp", "");
							url = "buildings.jsp";
						} else {
							session.putValue("trp", "修改失败！");
							url = "repassword.jsp";
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} else {
					session.putValue("trp", "两次密码不一致！");
					url = "repassword.jsp";
				}
			}
		} else {
			url = "logout.jsp";
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
