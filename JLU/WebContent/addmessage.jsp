<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String htmlData = request.getParameter("content") != null ? request.getParameter("content") : "";
%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="shortcut icon" href="logo.ico" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>添加留言</title>
<link href="css/css.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="kindeditor-4.0.6/themes/default/default.css" />
<link rel="stylesheet" href="kindeditor-4.0.6/plugins/code/prettify.css" />
<script charset="utf-8" src="kindeditor-4.0.6/kindeditor.js">
        </script>
<script charset="utf-8" src="kindeditor-4.0.6/lang/zh_CN.js">
        </script>
<script charset="utf-8" src="kindeditor-4.0.6/plugins/code/prettify.js">
        </script>
<style>
form {
	margin: 0;
}

textarea {
	display: block;
}
</style>
<script charset="utf-8" src="kindeditor-4.0.6/kindeditor-min.js"></script>
<script>
			var editor;
			KindEditor.ready(function(K) {
				editor = K.create('textarea[name="content"]', {
					resizeType : 1,
					allowPreviewEmoticons : false,
					allowImageUpload : false,
					items : [
						'fontname', 'fontsize', '|', 'forecolor', 'hilitecolor', 'bold', 'italic', 'underline',
						'removeformat', '|', 'justifyleft', 'justifycenter', 'justifyright', 'insertorderedlist',
						'insertunorderedlist', '|', 'emoticons',]
				});
			});
		</script>

<script type="text/javascript">
			function changeimg() {
				var myimg = document.getElementById("code");
				now = new Date();
				myimg.src = "makeCertPic.jsp?code=" + now.getTime();
				}
		</script>
</head>
<body>
<div class="zhong">
<div class="top">
<div class="top_left">吉林大学<br />
计算机科学与技术学院---社团联合会---欢迎您！</div>
<div class="top_right">
<div class="top_right_1"><span
	onclick="var strHref=window.location.href;this.style.behavior='url(#default#homepage)';
this.setHomePage('http://www.jluccstsl.com/');"
	style="CURSOR: hand">设为首页</span> | <span style="CURSOR: hand"
	onclick="window.external.addFavorite('http://www.jluccstsl.com/')"
	title="吉大-计院-社联">收藏本站</span></div>
<div class="top_right_2"><img src="images/img_1.gif" /></div>
</div>
<div class="clear"></div>
</div>
<div class="banner"><img src="images/img_2.gif" /></div>
<div class="menu">
<div class="menusel" style="width: 95px;">
<h2><a href="index">首页</a></h2>
</div>
<div id="menu1" class="menusel">
<h2><a href="introduction.html">了解社联</a></h2>
<div class="position">
<ul class="clearfix typeul">
	<li><a href="introduction.html">社联简介</a></li>
	<li><a href="culture.html">社联文化</a></li>
	<li class="lli"><a href="department.html">社联部门</a></li>
</ul>
</div>
</div>
<div id="menu2" class="menusel">
<h2><a href="shetuan.html">社团风采</a></h2>
<div class="position">
<ul class="clearfix typeul">
</ul>
</div>
</div>
<div id="menu3" class="menusel">
<h2><a href="getSheLianNews">新闻信息</a></h2>
<div class="position">
<ul class="clearfix typeul">
	<li><a href="getSheLianNews">社联新闻</a></li>
	<li><a href="getSheTuanNews">社团新闻</a></li>
	<li class="lli"><a href="getImportantNews">要闻通知</a></li>
</ul>
</div>
</div>
<div id="menu4" class="menusel">
<h2><a href="getFileDownload">下载中心</a></h2>
<div class="position">
<ul class="clearfix typeul">
	<li class="lli"><a href="getFileDownload">活动材料</a></li>
</ul>
</div>
</div>
<div id="menu5" class="menusel">
<h2><a href="recruitment.html">社联纳新</a></h2>
<div class="position">
<ul class="clearfix typeul">
</ul>
</div>
</div>
<div id="menu6" class="menusel">
<h2><a href="addmessage.jsp">在线留言</a></h2>
<div class="position">
<ul class="clearfix typeul">
	<li><a href="addmessage.jsp">发表留言</a></li>
	<li><a href="getMessageAction">留言列表</a></li>
	<li class="lli"><a href="tousu.jsp">建议投诉</a></li>
</ul>
</div>
</div>
<div id="menu7" class="menusel">
<h2><a href="http://page.renren.com/601017264">社联人人</a></h2>
<div class="position">
<ul class="clearfix typeul">
</ul>
</div>
</div>
</div>
<div class="main">
<div class="left">
<div class="box_1">
<div class="left_title">在线留言</div>
<div class="left_news">
<ul>
	<li><a href="#" class="hover">发表留言</a></li>
	<li><a href="getMessageAction">留言列表</a></li>
	<li><a href="tousu.jsp">建议投诉</a></li>
</ul>
</div>
</div>
<div class="box_1">
<div class="left_title">校内连接</div>
<div class="left_nr">
<ul>
	<li><a href="http://www.jlu.edu.cn/newjlu/">吉林大学</a></li>
	<li><a href="http://ccst.jlu.edu.cn/">计算机院</a></li>
	<li><a href="http://kszx.jlu.edu.cn/">考试中心</a></li>
	<li><a href="http://oa.jlu.edu.cn/list.asp?s=1">校内通知</a></li>
</ul>
</div>
</div>
</div>
<div class="right">
<div class="right_title"><b>添加留言</b></div>
<div class="xiangqing">
<form method="post" action="addMessageAction">
<label style="color: #FF0000"><s:property value="#session.tip" /></label><br />
<b>种类：</b><input name="type" value="留言" readonly="readonly"
	type="text" maxlength="4" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <b>标题:</b><input name="title"
	type="text" maxlength="20" /> <textarea name="content"
	style="width: 700px; height: 200px; visibility: hidden;">
	<%=htmlspecialchars(htmlData) %>
	</textarea> <br />
<b>昵称:</b><input name="author" type="text" maxlength="8" /> <b>电话:</b><input
	name="phone" type="text" maxlength="11" /> <b>qq:</b><input name="qq"
	type="text" maxlength="11" /><br />
<input type="text" size=4 name="CertCode" id="CertCode" align="middle" /><img
	id="code" src="makeCertPic.jsp" /><a href="javascript:changeimg()">看不清</a>
<input type="submit" name="button" value="提交内容"
	style="margin-left: 90px" />(提交快捷键: Ctrl + Enter)</form>
</div>
</div>
</div>
<div class="bottom">版权所有 2012-2016 <a
	href="http://www.jluccstsl.com/">吉林大学-计算机科学与技术学院-社团联合会</a></div>
</div>
<script src="js/meun.js" type="text/javascript">
        </script>
</body>
</html>
<%!
private String htmlspecialchars(String str) {
str = str.replaceAll("&", "&amp;");
str = str.replaceAll("<", "&lt;");
str = str.replaceAll(">", "&gt;");
str = str.replaceAll("\"", "&quot;");
return str;
} %>