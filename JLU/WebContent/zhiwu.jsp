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
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>吉大计算机社联</title>
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
						'insertunorderedlist',]
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
                <div class="top_left">
                    吉林大学<br/>
                    计算机科学与技术学院---社团联合会---欢迎您！
                </div>
                <div class="top_right">
                    <div class="top_right_1">
                    	<span onclick="var strHref=window.location.href;this.style.behavior='url(#default#homepage)';
this.setHomePage('http://www.jluccstsl.com/');" style="CURSOR: hand">设为首页</span>
                        　|　<span style="CURSOR: hand" onclick="window.external.addFavorite('http://www.jluccstsl.com/')" title="吉大-计院-社联">收藏本站</span>
                    </div>
                    <div class="top_right_2">
                        <img src="images/img_1.gif" />
                    </div>
                </div>
                <div class="clear">
                </div>
            </div>
            <div class="banner">
                <img src="images/img_2.gif" />
            </div>
            <div class="menu">
                <div class="menusel" style="width:95px;">
                    <h2><a href="index">首页</a></h2>
                </div>
                <div id="menu1" class="menusel">
                    <h2><a href="introduction.html">了解社联</a></h2>
                    <div class="position">
                        <ul class="clearfix typeul">
                            <li>
                                <a href="introduction.html">社联简介</a>
                            </li>
                            <li>
                                <a href="culture.html">社联文化</a>
                            </li>
                            <li class="lli">
                                <a href="department.html">社联部门</a>
                            </li>
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
                    <h2><a href="getNewsByType?type=0">新闻信息</a></h2>
                    <div class="position">
                        <ul class="clearfix typeul">
	<li><a href="getNewsByType?type=0">社联新闻</a></li>
	<li><a href="getNewsByType?type=1">社团新闻</a></li>
	<li class="lli"><a href="getNewsByType?type=2">要闻通知</a></li>
</ul>
                    </div>
                </div>
                <div id="menu4" class="menusel">
                    <h2><a href="getFileDownload">下载中心</a></h2>
                    <div class="position">
                        <ul class="clearfix typeul">
                            <li class="lli">
                                <a href="getFileDownload">活动材料</a>
                            </li>
                        </ul>
                    </div>
                </div>
                <div id="menu5" class="menusel">
                    <h2><a href="getCommentAction?type=zhiwu">社联游戏</a></h2>
                    <div class="position">
                        <ul class="clearfix typeul">
                        </ul>
                    </div>
                </div>
                <div id="menu6" class="menusel">
                    <h2><a href="addmessage.jsp">在线留言</a></h2>
                    <div class="position">
                        <ul class="clearfix typeul">
                            <li>
                                <a href="addmessage.jsp">发表留言</a>
                            </li>
                            <li>
                                <a href="getMessageAction">留言列表</a>
                            </li>
                            <li class="lli">
                                <a href="tousu.jsp">建议投诉</a>
                            </li>
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
                        <div class="left_title">
                            社联游戏
                        </div>
                        <div class="left_news">
                            <ul>
                                <li>
                                    <a href="getCommentAction?type=zhiwu" class="hover">植物大战僵尸</a>
                                </li>
                                <li>
                                    <a href="getCommentAction?type=shejian" >射箭救人</a>
                                </li>
                                <li>
                                    <a href="getCommentAction?type=chilun" >齿轮游戏</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="box_1">
                        <div class="left_title">
                            校内连接
                        </div>
                        <div class="left_nr">
                            <ul>
                                <li>
                                    <a href="http://www.jlu.edu.cn/newjlu/">吉林大学</a>
                                </li>
                                <li>
                                    <a href="http://ccst.jlu.edu.cn/">计算机院</a>
                                </li>
                                <li>
                                    <a href="http://kszx.jlu.edu.cn/">考试中心</a>
                                </li>
                                <li>
                                    <a href="http://oa.jlu.edu.cn/list.asp?s=1">校内通知</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="right">
                    <div class="right_title">
                        <b>植物大战僵尸</b>
                        <div>
                            首页 - <span>社联游戏</span>
                        </div>
                    </div>
                    <div class="xiangqing">
                        <br/>
<iframe scrolling="no" height="405" frameborder="0" width="540" src="http://flash2.7k7k.com/fl_7/20090929/28/pvz_9_15_110325.htm" name="gameobj" id="gameobj" marginwidth="0" marginheight="0"></iframe>
                        <br/>
<!-- 将此标记放在您希望显示like按钮的位置 -->
<div class="bdlikebutton"></div>

<!-- 将此代码放在适当的位置，建议在body结束前 -->
<script id="bdlike_shell"></script>
<script>
var bdShare_config = {
	"type":"small",
	"color":"blue",
	"uid":"6471323"
};
document.getElementById("bdlike_shell").src="http://bdimg.share.baidu.com/static/js/like_shell.js?t=" + new Date().getHours();
</script>
<!-- Baidu Button BEGIN -->
    <div id="bdshare" class="bdshare_t bds_tools get-codes-bdshare">
        <a class="bds_qzone"></a>
        <a class="bds_tsina"></a>
        <a class="bds_tqq"></a>
        <a class="bds_renren"></a>
        <span class="bds_more">更多</span>
		<a class="shareCount"></a>
    </div>
<script type="text/javascript" id="bdshare_js" data="type=tools&amp;uid=6471323" ></script>
<script type="text/javascript" id="bdshell_js"></script>
<script type="text/javascript">
	document.getElementById("bdshell_js").src = "http://bdimg.share.baidu.com/static/js/shell_v2.js?cdnversion=" + new Date().getHours();
</script>
<!-- Baidu Button END -->
                        <br/><br/><b>玩家评论：</b>
                        <s:iterator value="%{list}" status="ne">
                            <table bgcolor="#F0F0F0" width="540">
                            	<tr>
	                            	<td><b>${author}:
	                            	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                            	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                            	${content}</b>
	                            	<p align="right"><b>${date}</b></p>
	                            	</td>
                            	</tr>
                            	</table><br/>
                            	</s:iterator>
                            	<div class="fanye">
			                        <div class="fanye_left">
			                            页次：${currentPage}/${countPage} 页　每页5条
			                            分页：<a href="getCommentAction?currentPage=${currentPage-1}&type=zhiwu"><img src="images/img_13.gif" /></a>${currentPage}
			                            <a href="getCommentAction?currentPage=${currentPage+1}&type=zhiwu"><img src="images/img_14.gif" /></a>
			                        </div>
			                    </div>
                        <form method="post" action="addCommentAction">
<br/><label style="color: #FF0000"><s:property value="#session.tip" /></label><br />
<textarea name="content"
	style="width: 450px; height: 30px; visibility: hidden;">
	<%=htmlspecialchars(htmlData) %>
	</textarea> <br />
	<input name="type" value="zhiwu" type="hidden" />
<b>昵称:</b><input name="author" type="text" maxlength="8" />
<input type="text" size=4 name="CertCode" id="CertCode" align="middle" /><img
	id="code" src="makeCertPic.jsp" /><a href="javascript:changeimg()">看不清</a>
<input type="submit" name="button" value="提交内容"
	style="margin-left: 90px" />(提交快捷键: Ctrl + Enter)</form>
					<br/>
                    </div>
                </div>
                <div class="clear">
                </div>
            </div>
            <div class="bottom">
                版权所有 2012-2016 <a href="http://www.jluccstsl.com/">吉林大学-计算机科学与技术学院-社团联合会</a>
            </div>
        </div>
        <script src="js/meun.js" type="text/javascript">
        </script>
        <!-- ShareTo Button BEGIN -->
		<script type="text/javascript" src="http://www.shareto.org/js/shareto_float.js#color=0&align=right&move=1" charset="utf-8"></script> 
		<!-- ShareTo Button END -->
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