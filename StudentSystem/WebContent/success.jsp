<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>功能界面</title>

<script type="text/javascript" charset="utf-8" src="js/jquery-1.7.1.js">
	
</script>
<style type="text/css">
.divFrame {
	width: 260px;
	border: solid 1px #ffffff;
	font-size: 18px;
}

.divTitleStudent {
	background-color: #CDC5BF;
	padding: 10px;
}

.divTitleManager {
	background-color: #CDC5BF;
	padding: 10px;
}
.divTitleSystem {
	background-color: #CDC5BF;
	padding: 10px;
}
.divContentStudent {
	padding: 5px;
	display: none;
}

.divContentManager {
	padding: 5px;
	display: none;
}
.divContentSystem {
	padding: 5px;
	display: none;
}

.divCurrColor {
	background-color: #D9D9D9;
}

</style>
<script type="text/javascript">
	$(function() {
		$(".divTitleStudent").click(function() {
			if ($(".divContentStudent").is(":hidden")) {
				$(".divTitleStudent").addClass("divCurrColor");
				$(".divContentStudent").show(500);
			} else {
				$(".divTitleStudent").remove("divCurrColor");
				$(".divContentStudent").hide(500);
			}
		});

	});
	$(function() {
		$(".divTitleManager").click(function() {
			if ($(".divContentManager").is(":hidden")) {
				$(".divTitleManager").addClass("divCurrColor");
				$(".divContentManager").show(500);
			} else {
				$(".divTitleManager").remove("divCurrColor");
				$(".divContentManager").hide(500);
			}
		});

	});
	$(function() {
		$(".divTitleSystem").click(function() {
			if ($(".divContentSystem").is(":hidden")) {
				$(".divTitleSystem").addClass("divCurrColor");
				$(".divContentSystem").show(500);
			} else {
				$(".divTitleSystem").remove("divCurrColor");
				$(".divContentSystem").hide(500);
			}
		});

	});

</script>
<script language="javascript">
	function topicReload() {
		window.parent.frames["menu"].location.reload();
		window.parent.frames["stulist"].location.reload();
	}
</script>
</head>
<body bgcolor="#F2F2F2">
<div class="divFrame">
<div class="divTitleStudent">学生信息</div>
<div class="divContentStudent"><a
	href=""
	onclick="topicReload()">刷新信息</a><br />
<a href="addstudent.jsp">添加学生</a><br />
<a href="querystudent.jsp">查询学生</a></div>
</div>
<div class="divFrame">
<div class="divTitleManager">账户信息</div>
<div class="divContentManager"><a href="addadmin.jsp">添加账户</a><br />
<a href="deleteadmin.jsp">注销账户</a><br />
<a href="repassword.jsp">修改密码</a><br />
</div>
</div>
<div class="divFrame">
<div class="divTitleSystem">系统信息</div>
<div class="divContentSystem"><a href="exitAction"  target="_top">退出系统</a><br />
<a href="author.jsp">作者信息</a><br />
</div>
</div>
</body>
</html>