package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import object.Building;
import object.Filter;

import db.BuildingDb;

/**
 * Servlet implementation class login
 */
public class BuildingUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BuildingUpdateServlet() {
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
		String id = new String(request.getParameter("id")
				.getBytes("ISO-8859-1"), "UTF-8");
		String name = new String(request.getParameter("name").getBytes(
				"ISO-8859-1"), "UTF-8");
		String location = new String(request.getParameter("location").getBytes(
				"ISO-8859-1"), "UTF-8");
		String sumOfRoom = new String(request.getParameter("SumOfRoom")
				.getBytes("ISO-8859-1"), "UTF-8");
		String postcode = new String(request.getParameter("postcode").getBytes(
				"ISO-8859-1"), "UTF-8");
		HttpSession session = request.getSession();
		String acount = (String) session.getAttribute("username");
		String url = null;
		if (acount != null) {
			try {
				if (name.length() <= 0 || location.length() <= 0
						|| sumOfRoom.length() <= 0 || postcode.length() <= 0) {
					session.putValue("top", "输入不合法！");
					url = "buildings_update.jsp";
				} else {
					if (Filter.isInteger(sumOfRoom)
							&& Filter.isInteger(postcode)) {
						Building admin = new Building(name, location,
								Integer.valueOf(sumOfRoom), postcode);
						admin.setId(Integer.valueOf(id));
						if (BuildingDb.update(admin)) {
							url = "buildings.jsp";
							session.putValue("top", "");
						} else {
							url = "error.html";
						}
					} else {
						session.putValue("top", "输入不合法！");
						url = "buildings_update.jsp";
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