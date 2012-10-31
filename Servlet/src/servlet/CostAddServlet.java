package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import object.Cost;
import object.Filter;
import object.Room;
import db.CostDb;
import db.RoomDb;

/**
 * Servlet implementation class CostAddServlet
 */
public class CostAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CostAddServlet() {
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
		String uid = new String(request.getParameter("uid").getBytes(
				"ISO-8859-1"), "UTF-8");
		String monthlypay = new String(request.getParameter("monthlypay")
				.getBytes("ISO-8859-1"), "UTF-8");
		String year = new String(request.getParameter("year").getBytes(
				"ISO-8859-1"), "UTF-8");
		String month = new String(request.getParameter("month").getBytes(
				"ISO-8859-1"), "UTF-8");
		String state = new String(request.getParameter("state").getBytes(
				"ISO-8859-1"), "UTF-8");

		String url = null;
		HttpSession session = request.getSession();
		String acount = (String) session.getAttribute("username");
		if (acount != null) {
			try {
				if (monthlypay.length() <= 0 || year.length() <= 0
						|| month.length() <= 0) {
					session.putValue("tcp", "输入不合法！");
					url = "costs_add.jsp";
				} else {
					if (Filter.isInteger(monthlypay)) {
						Cost admin = new Cost(Integer.valueOf(uid),
								Float.valueOf(monthlypay), year, month,
								Integer.valueOf(state));
						if (CostDb.add(admin)) {
							url = "costs.jsp";
							session.putValue("tcp", "");
						} else {
							url = "error.html";
						}
					} else {
						session.putValue("tcp", "输入不合法！");
						url = "costs_add.jsp";
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
