﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE>用户登录</TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<LINK href="images/public.css" type=text/css rel=stylesheet>
<LINK href="images/login.css" type=text/css rel=stylesheet>
<STYLE type=text/css>
</STYLE>
<META content="MSHTML 6.00.2900.5848" name=GENERATOR>
<script type="text/javascript">
if (top.location != self.location){     
top.location=self.location;     
}
</script>
<script type="text/javascript">
	function changeimg() {
		var myimg = document.getElementById("code");
		now = new Date();
		myimg.src = "makeCertPic.jsp?code=" + now.getTime();
	}
</script>
<% 
	String tip = (String)session.getAttribute("tip");
	if(tip == null || tip.length() <= 0){
		tip = "";	
	}
%>
</HEAD>
<BODY>
<DIV id=div1>
<TABLE id=login height="100%" cellSpacing=0 cellPadding=0 width=800
	align=center>
	<TBODY>
		<TR id=main>
			<TD>
			<TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%">
				<TBODY>
					<form action="loginServlet" method="post">
					<TR>
						<TD colSpan=4>&nbsp;</TD>
					</TR>
					<TR height=30>
						<TD width=380>&nbsp;</TD>
						<TD>&nbsp;</TD>
						<TD style="color: red"><%=tip %></TD>
						<TD>&nbsp;</TD>
					</TR>
					<TR height=40>
						<TD rowSpan=4>&nbsp;</TD>
						<TD>用户名：</TD>
						<TD><INPUT class=textbox id=txtUserName name=username>
						</TD>
						<TD width=120>&nbsp;</TD>
					</TR>
					<TR height=40>
						<TD>密 码：</TD>
						<TD><INPUT class=textbox id=txtUserPassword type=password
							name=password></TD>
						<TD width=120>&nbsp;</TD>
					</TR>
					<TR height=40>
						<TD>验证码：</TD>
						<TD align=left colSpan=2><input type="text" size=4
							name="CertCode" id="CertCode" /> <img id="code"
							src="makeCertPic.jsp"><a href="javascript:changeimg()">看不清
						</A></TD>
					</TR>
					<TR height=40>
						<TD><INPUT type="radio" name="id" value="user" checked="checked"/>业主
						<INPUT type="radio" name="id" value="admin" />管理员</TD>
						<TD align=right><INPUT id=btnLogin type=submit value="登 录 "
							name=btnLogin></TD>
						<TD width=120>&nbsp;</TD>
					</TR>
					<TR height=110>
						<TD colSpan=4>&nbsp;</TD>
					</TR>
					</form>
				</TBODY>
			</TABLE>
			</TD>
		</TR>
		<TR id=root height=104>
			<TD>&nbsp;</TD>
		</TR>
	</TBODY>
</TABLE>
</DIV>
<DIV id=div2 style="DISPLAY: none"></DIV>
</BODY>
</HTML>
