<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询学生</title>
<style type="text/css">
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
<div class="divFrame"><div class="divTitle">精确查找</div></div>
<br />
<s:form name="number" action="queryStudentActionByNumber" target="stulist">
	<s:textfield name="number" label="学号" />
	<s:submit value="确定"></s:submit>
</s:form>
<s:form name="name" action="queryStudentActionByName" target="stulist">
	<s:textfield name="name" label="姓名" />
	<s:submit value="确定"></s:submit>
</s:form>
<br />
<div class="divFrame"><div class="divTitle">模糊查找</div></div>
<br />
<s:form name="major" action="queryStudentActionByMajor" target="stulist">
	<s:textfield name="major" label="专业" />
	<s:submit value="确定"></s:submit>
</s:form>
<s:form name="grade" action="queryStudentActionByGrade" target="stulist">
	<s:textfield name="grade" label="班级" />
	<s:submit value="确定"></s:submit>
</s:form>
<div class="divFrame"><div class="divTitle"><a href="index.jsp" target="_top">返回首页</a></div></div>
</div>
</body>
</html>