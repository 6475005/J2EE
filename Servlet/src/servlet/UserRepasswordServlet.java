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
import db.UserDb;

/**
 * Servlet implementation class AdminRepasswordServlet
 */
public class UserRepasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserRepasswordServlet() {
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
				session.putValue("trp", "密码不为空！");
				url = "repassword.jsp";
			} else {
				if (password.equals(repassword)) {
					try {
						UserDb.repassword(username, password);
						session.putValue("trp", "");
						url = "buildings.jsp";
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
