<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script language="javascript">
	setTimeout("window.close()", 7000);
</script>
<title></title>
<link href="css/css.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
			function changeimg() {
				var myimg = document.getElementById("code");
				now = new Date();
				myimg.src = "makeCertPic.jsp?code=" + now.getTime();
				}
		</script>
		<% String filename = request.getParameter("filename"); %>
</head>
<body>
<div class="main">
<div class="center">
<label style="color: #FF0000">请在7秒内输入验证码！</label>
<div class="box_2">
<div class="left_title">下载验证</div>
<form action="downloadAction" method="post">
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tbody>
		<tr>
			<td height="37" valign="middle">验证码：</td>
			<td valign="middle">
			<input type="text" size=4 name="CertCode"
				id="CertCode" class="input_3" style="float: left" /><span
				style="float: left; margin-left: 6px;"><img id="code"
				src="makeCertPic.jsp" /><a href="javascript:changeimg()">看不清</a></span></td>
		</tr>
		<tr>
			<td>
				<input name="name" type="hidden" value="<%=filename %>" />
			</td>
		</tr>
		<tr>
			<td colspan="2" align="right"><input type="submit" value="确定"/>
			</td>
		</tr>
	</tbody>
</table>
</form>
</div>
</div>
</div>
</body>
</html>