package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import object.User;
import db.UserDb;

/**
 * Servlet implementation class UserUpdateServlet
 */
public class UserUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserUpdateServlet() {
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
		String id = new String(request.getParameter("id")
				.getBytes("ISO-8859-1"), "UTF-8");
		String username = new String(request.getParameter("username").getBytes(
				"ISO-8859-1"), "UTF-8");
		String password = new String(request.getParameter("password").getBytes(
				"ISO-8859-1"), "UTF-8");
		String name = new String(request.getParameter("name").getBytes(
				"ISO-8859-1"), "UTF-8");
		String url = null;
		HttpSession session = request.getSession();
		if (username.length() <= 0 || password.length() <= 0
				|| name.length() <= 0) {
			session.putValue("tpp", "ÃÜÂë²»Îª¿Õ£¡");
			url = "users_update.jsp";
		} else {
			User admin = new User(0, username, password, name, null);
			String acount = (String) session.getAttribute("username");
			admin.setId(Integer.valueOf(id));
			if (acount != null) {
				try {
					UserDb.update(admin);
					url = "users.jsp";
				} catch (SQLException e) {
					e.printStackTrace();
				}
			} else {
				url = "logout.jsp";
			}
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
