<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%
  if(request.getAttribute("T_flag")==null)
  {
  response.sendRedirect("index.action");
  }
%>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>吉大-计算机学院-社团联合会</title>
<link href="css/css.css" rel="stylesheet" type="text/css" />
<script src="js/jquery.min.js" type="text/javascript"></script>
<style type="text/css">
body,div,ul,li {
	margin: 0;
	padding: 0;
}

#slide {
	position: relative;
	width: 669px;
	height: 374px;
	margin: 5px auto;
}

#pic_list {
	position: absolute;
	left: 0;
	bottom: 0;
	width: 100%;
	list-style: none;
	overflow: hidden;
	z-index: 2;
}

#pic_list li {
	float: left;
	width: 100px;
	height: 52px;
	padding-top: 10px;
}

#pic_list li img {
	position: absolute;
	top: 18px;
	width: 65px;
	height: 35px;
	margin: 0 20px;
	border: 1px solid #fff;
}

#this_pic {
	position: absolute;
	width: 100%;
	height: 100%;
	border: none;
}

#transparence {
	position: absolute;
	left: 0;
	bottom: 0;
	width: 100%;
	height: 50px;
	border-top: 1px solid #fff;
	background: #000;
	z-index: 1;
}
</style>
<script type="text/javascript"> 
		var theInt = null;
		var curclicked = 0;
		 
		$(function(){
			$('#transparence').css('opacity','0.4');
			$('#pic_list img').css({'opacity':'0.6'});
			$('#pic_list img:eq(0)').css({'top':'0','opacity':'1'});
			$('#pic_list a').click(function(){return false;});
			t(0);
			$('#pic_list img').mouseover(function(){
				if($('#this_pic').attr('src') == $(this).attr('src')) return;
				t($('#pic_list img').index($(this)));
			});
		});
		 
		t = function(i){
			clearInterval(theInt);
			if( typeof i != 'undefined' )
			curclicked = i;
				$('#this_pic').fadeOut(0).fadeIn(500).attr('src',$('#pic_list img').eq(i).attr('src'));
				$('#this_a').attr('href',$('#pic_list img').eq(i).parents('a').attr('href'));
				$('#this_a').attr('title',$('#pic_list img').eq(i).parents('a').attr('title'));
				$('#pic_list img').eq(i).parents('li').nextAll('li').find('img').animate({top:18,opacity:0.6},500);
				$('#pic_list img').eq(i).parents('li').prevAll('li').find('img').animate({top:18,opacity:0.6},500);
				$('#pic_list img').eq(i).animate({top:0},500).css('opacity','1');
			theInt = setInterval(function (){
				i++;
				if (i > $('#pic_list img').length - 1) {i = 0;};
				$('#this_pic').fadeOut(0).fadeIn(500).attr('src',$('#pic_list img').eq(i).attr('src'));
				$('#this_a').attr('href',$('#pic_list img').eq(i).parents('a').attr('href'));
				$('#this_a').attr('title',$('#pic_list img').eq(i).parents('a').attr('title'));
				$('#pic_list img').eq(i).parents('li').nextAll('li').find('img').animate({top:18,opacity:0.6},500);
				$('#pic_list img').eq(i).parents('li').prevAll('li').find('img').animate({top:18,opacity:0.6},500);
				$('#pic_list img').eq(i).animate({top:0},500).css('opacity','1');
			},3000);
		};
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
	onclick="window.external.addFavorite('http://www.jluccstsl.com/')" title="吉大-计院-社联">收藏本站</span>
</div>
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
<h2><a href="information/introduction.html">了解社联</a></h2>
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
	<li class="lli"><a href="getFileDownload">活动材料</a></li>
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
<div class="left_title">滚动新闻</div>
<div class="left_nr"><marquee style="width: 200px; height: 80px"
	scrollamount="2" direction="up"> <s:iterator
	value="%{newslist}" status="ne">
	<ul>
		<li style="margin-left: 0px; overflow: hidden;"><a
			href="getTheNews?id=${id}&title=${title}">${title}</a></li>
	</ul>
</s:iterator> </marquee></div>
</div>
<div class="box_1">
<div class="left_title">新闻信息</div>
<div class="left_news">
<ul>
	<li><a href="getNewsByType?type=0">社联新闻</a></li>
	<li><a href="getNewsByType?type=1">社团新闻</a></li>
	<li><a href="getNewsByType?type=2">要闻通知</a></li>
</ul>
</div>
</div>
<div class="box_1">
<div class="left_title">新闻检索</div>
<div class="left_news">
<ul>
<s:form action="queryNews">
	<b>标题：</b>
	<s:textfield name="title" maxlength="10"></s:textfield>
	<s:submit value="查询"></s:submit>
</s:form>
</ul>
</div>
</div>
<div class="box_1" style="margin: 0px;">
<div class="left_title">社联导航</div>
<div class="left_nr">
<ul>
	<li><a href="mishu.html">秘书部</a></li>
	<li><a href="guanli.html">管理部</a></li>
	<li><a href="gongguan.html">公关部</a></li>
	<li><a href="xuanchuan.html">宣传部</a></li>
	<li><a href="weiquan.html">维权部</a></li>
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
<div class="right_top_img">
<div id="slide"><a href="#" id="this_a"><img
	src="images/ppt_1.jpg" id="this_pic" /></a>
<ul id="pic_list">
	<li><a href="#"><img src="images/ppt_1.jpg" /></a></li>
	<li><a href="#"><img src="images/ppt_2.jpg" /></a></li>
	<li><a href="#"><img src="images/ppt_3.jpg" /></a></li>
	<li><a href="#"><img src="images/ppt_4.jpg" /></a></li>
</ul>
<span id="transparence"></span></div>
</div>
<div class="news">
<div class="news_title"><span><img src="images/title_1.gif" /></span><a
	href="getNewsByType?type=0"><img src="images/more.gif" /></a></div>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<s:iterator value="%{newslist}" status="ne">
		<tr>
			<td width="48%" height="18"><a
				href="getTheNews?id=${id}&title=${title}">${title}</a></td>
			<td width="27%">${partment}</td>
			<td width="25%" align="center">${date}</td>
		</tr>
	</s:iterator>
</table>
</div>
</div>
<div class="clear"></div>
<div class="huoban">
<div class="right_title"><b>社团活动</b></div>
<div class="huoban_nr">
<ul>
	<li><img src="images/huoban_1.jpg" /></li>
	<li><img src="images/huoban_2.jpg" /></li>
	<li><img src="images/huoban_3.jpg" /></li>
	<li><img src="images/huoban_4.jpg" /></li>
	<li><img src="images/huoban_5.jpg" /></li>
</ul>
<div class="clear"></div>
</div>
</div>
</div>
<div class="bottom">版权所有 2012-2016 <a href="http://www.jluccstsl.com/">吉林大学-计算机科学与技术学院-社团联合会</a></div>
</div>
<script src="js/meun.js" type="text/javascript">
        </script>
        <!-- 将此代码放在适当的位置，建议在body结束前 -->
<script id="bdaddtocite_shell"></script>
<script>
var bdShare_config_addtocite = {
	"type":"slide"
	,"pos":"left"
	,"color":"darkblue"
	,"top":"200"
	,"uid":"6471323"
};
document.getElementById("bdaddtocite_shell").src="http://bdimg.share.baidu.com/static/js/addtocite_shell.js?t=" + new Date().getHours();
</script>
</body>
</html>
