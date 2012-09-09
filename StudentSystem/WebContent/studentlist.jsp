<%@page import="studentaction.StudentQueryAction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.divFrame {
	width: 524px;
	border: solid 1px #ffffff;
	font-size: 18px;
}

.divTitle {
	background-color: #CDC5BF;
	padding: 10px;
	font-weight: bold;
}

.divColumn {
	background-color: #EBEBEB;
	padding: 7px;
	text-align: left;
	font-size: 14px;
}

.divColumn2 {
	background-color: #CDC9C9;
	padding: 7px;
	text-align: left;
	font-size: 14px;
}

.divContent {
	padding: 5px;
	display: none;
}

.divCurrColor {
	background-color: gray;
}

</style>
<script language="JavaScript">
	function delete_confirm(id) {
		event.returnValue = confirm("您确认删除"+"[学号:"+id+"]的学生信息么？");
		if (event.srcElement.outerText == "删除"
				|| event.srcElement.value == "删除"){
			return true;
			}
			return false;
			
	}
</script>
<script language="javascript">
	function topicReload() {
		window.parent.frames["menu"].location.reload();
		window.parent.frames["stulist"].location.reload();
	}
</script>
</head>
<body bgcolor="#F2F2F2">
<div class="divFrame"><div class="divTitle">学生列表</div></div>
<div class="divFrame">
<table border="0">
	<tr>
		<td>
		<div class="divTitle">学号</div>
		</td>
		<td>
		<div class="divTitle">姓名</div>
		</td>
		<td>
		<div class="divTitle">性别</div>
		</td>
		<td>
		<div class="divTitle">专业</div>
		</td>
		<td>
		<div class="divTitle">班级</div>
		</td>
		<td>
		<div class="divTitle">电话</div>
		</td>
		<td>
		<div class="divTitle">修改</div>
		</td>
		<td>
		<div class="divTitle">删除</div>
		</td>
	</tr>
	<s:iterator value="%{list}" id="number" status="st">
		<s:if test="#st.odd">
			<tr>
				<td>
				<div class="divColumn2">${number}</div>
				</td>
				<td>
				<div class="divColumn2">${name}</div>
				</td>
				<td>
				<div class="divColumn2">${sex}</div>
				</td>
				<td>
				<div class="divColumn2">${major}</div>
				</td>
				<td>
				<div class="divColumn2">${grade}</div>
				</td>
				<td>
				<div class="divColumn2">${phone}</div>
				</td>
				<td>
				<div class="divColumn2"><a
					href="studentupdata.jsp?number=${number}" onclick="">修改</a></div>
				</td>
				<td>
				<div class="divColumn2"><a
					href="deleteStudentAction?number=${number}"
					onclick="delete_confirm(${number}),topicReload()">删除</a></div>
				</td>
			</tr>
		</s:if>
		<s:else>
			<tr>
				<td>
				<div class="divColumn">${number}</div>
				</td>
				<td>
				<div class="divColumn">${name}</div>
				</td>
				<td>
				<div class="divColumn">${sex}</div>
				</td>
				<td>
				<div class="divColumn">${major}</div>
				</td>
				<td>
				<div class="divColumn">${grade}</div>
				</td>
				<td>
				<div class="divColumn">${phone}</div>
				</td>
				<td>
				<div class="divColumn"><a
					href="studentupdata.jsp?number=${number}" onclick="">修改</a></div>
				</td>
				<td>
				<div class="divColumn"><a
					href="deleteStudentAction?number=${number}"
					onclick="delete_confirm(${number}),topicReload()">删除</a></div>
				</td>
			</tr>
		</s:else>
	</s:iterator>
</table>
</div>
<div class="divFrame"><div class="divTitle">
	<a href="upDataStudentListAction?currentPage=${currentPage-1}">上一页</a>
		<s:iterator value="pages" id="page" status="st">
			<a href="upDataStudentListAction?currentPage=${page}"><s:property value="page"/></a>
		</s:iterator>
	<a href="upDataStudentListAction?currentPage=${currentPage+1}">下一页</a>
</div></div>
</body>
</html>