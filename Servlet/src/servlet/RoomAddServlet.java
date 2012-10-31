package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import object.Filter;
import object.Room;
import db.RoomDb;

/**
 * Servlet implementation class RoomAddServlet
 */
public class RoomAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RoomAddServlet() {
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
		String bid = new String(request.getParameter("bid").getBytes(
				"ISO-8859-1"), "UTF-8");
		String uid = new String(request.getParameter("uid").getBytes(
				"ISO-8859-1"), "UTF-8");
		String floor = new String(request.getParameter("floor").getBytes(
				"ISO-8859-1"), "UTF-8");
		String area = new String(request.getParameter("area").getBytes(
				"ISO-8859-1"), "UTF-8");
		HttpSession session = request.getSession();
		String acount = (String) session.getAttribute("username");
		String url = null;
		if (acount != null) {
			try {
				if (floor.length() <= 0 || area.length() <= 0) {
					session.putValue("tmp", "输入不合法！");
					url = "rooms_add.jsp";
				} else {
					if (Filter.isInteger(floor) && Filter.isInteger(area)) {
						Room admin = new Room(Integer.valueOf(bid),
								Integer.valueOf(uid), Integer.valueOf(floor),
								Float.valueOf(area));
						if (RoomDb.add(admin)) {
							url = "rooms.jsp";
							session.putValue("tmp", "");
						} else {
							url = "error.html";
						}
					} else {
						session.putValue("tmp", "输入不合法！");
						url = "rooms_add.jsp";
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
