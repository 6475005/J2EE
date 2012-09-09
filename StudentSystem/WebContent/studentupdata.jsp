<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>更新信息</title>
<style>
.divFrame {
	width: auto;
	border: solid 1px #ffffff;
	font-size: 18px;
}
.divTitle {
	background-color: gray;
	padding: 10px;
	font-weight: bold;
}
.divCurrColor {
	background-color: #D9D9D9;
}

</style>
</head>
<body bgcolor="#F2F2F2">
<div class="divCurrColor">
<div class="divFrame"><div class="divTitle">修改信息</div></div>
<%
	String number = request.getParameter("number");
	number = new String(number.getBytes("ISO-8859-1"),"UTF-8"); 
	out.println("学号：[" + number +"]&nbsp&nbsp");
%>
<s:form action="updataStudentAction">
	<input name="number" type="hidden" value="<%=number%>" ></input>
	<s:textfield name="major" label="专业"></s:textfield>
	<s:textfield name="grade" label="班级"></s:textfield>
	<s:textfield name="phone" label="电话"></s:textfield>
	<s:submit value="提交"></s:submit>
</s:form>
<div class="divFrame"><div class="divTitle"><a href="index.jsp" target="_top">返回首页</a></div></div>
</div>
</body>
</html>