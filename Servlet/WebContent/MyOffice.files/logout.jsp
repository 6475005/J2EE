<%@ page contentType="text/html; charset=utf-8" language="java"%>
<html>
<head>
<title>logout</title>
<%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server
%> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<%
session.invalidate();
out.println("<script language='javascript'>");
out.println("window.location.href='../login.jsp'");
out.println("</script>");
%>
</body>
</html>

