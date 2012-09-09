<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.divFrame {
	width: 260px;
	border: solid 1px #ffffff;
	font-size: 18px;
}

.divTitle {
	background-color: #CDC5BF;
	padding: 10px;
}
.divCurrColor {
	background-color: #D9D9D9;
}

</style>
</head>
<body bgcolor="#F2F2F2">
<div class="divCurrColor">
<div class="divFrame"><div class="divTitle">添加学生</div></div>
<s:form action="addStudentAction">
	<s:textfield name="student.number" label="学号"></s:textfield>
	<s:textfield name="student.name" label="姓名"></s:textfield>
	<s:radio list="#{'男':'男','女':'女'}" name="student.sex" label="性别"></s:radio>
	<s:textfield name="student.major" label="专业"></s:textfield>
	<s:textfield name="student.grade" label="班级"></s:textfield>
	<s:textfield name="student.phone" label="电话"></s:textfield>
	<s:submit value="提交" ></s:submit>
</s:form>
<div class="divFrame"><div class="divTitle"><a href="index.jsp" target="_top">返回首页</a></div></div>
</div>
</body>
</html>