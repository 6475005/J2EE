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
	<div class="divFrame"><div class="divTitle">修改密码</div></div>
	<s:form action="repasswordAction">
	<s:textfield name="password" label="原密码"></s:textfield>
	<s:textfield name="newpassword" label="新密码"></s:textfield>
	<s:textfield name="repassword" label="确认密码"></s:textfield>
	<s:submit value="提交" ></s:submit>
</s:form>
<div class="divFrame"><div class="divTitle"><a href="index.jsp" target="_top">返回首页</a></div></div>
</div>
</body>
</html>