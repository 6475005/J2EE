<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学会信息管理</title>
</head>
<frameset rows="20%,80%" frameborder="no" >
	<frame name="title" id="title" src="title.jsp">
	<frameset id="index" cols="30%,70%" >
		<frame name="menu" id="menu" src="success.jsp">
		<frame name="stulist" id="stulist" src="getStudentListAction.action">
	</frameset>
</frameset>
</html>