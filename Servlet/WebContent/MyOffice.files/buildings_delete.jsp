<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="object.*"%>
<%@ page import="db.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
</head>
<body>
	<% 
		String id = request.getParameter("id");
		BuildingDb.delete(id);
		List<Room> rooms = RoomDb.queryByBid(Integer.valueOf(id));
		for(Room room:rooms){
			RoomDb.delete(String.valueOf(room.getId()));
		}
		response.sendRedirect("buildings.jsp");
	%>
</body>
</html>