<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
<style>
.divFrame {
	width: auto;
	border: solid 1px #ffffff;
	font-size: 18px;
	text-shadow: gray;
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
<body bgcolor="#EDEDED">
<div style="position:absolute; width:100%; top:35%; ">
<div style="height:150px; width:250px; text-align:center; margin:auto;">
<div class="divCurrColor" >
<div class="divFrame"><div class="divTitle">登录系统</div></div>
	<s:form action="loginAction" >
		<s:textfield name="admin.username" label="账号" />
		<s:password name="admin.password" label="密码" />
		<s:submit value="登录" />
	</s:form>
	</div>
	</div>
	</div>
</body>
</html>