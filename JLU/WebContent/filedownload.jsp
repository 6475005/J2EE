<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>下载中心</title>
        <link href="css/css.css" rel="stylesheet" type="text/css" />
        <%
        String realIP = request.getHeader("x-forwarded-for");
        String ip = request.getRemoteAddr();
        if(realIP==null||realIP.length()==0){
        	session.setAttribute("IP",ip);
        }else{
        	session.setAttribute("IP",realIP);
        }
        %>
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
                    <h2><a href="getSheLianNews">新闻信息</a></h2>
                    <div class="position">
                        <ul class="clearfix typeul">
                            <li>
                                <a href="getSheLianNews">社联新闻</a>
                            </li>
                            <li>
                                <a href="getSheTuanNews">社团新闻</a>
                            </li>
                            <li class="lli">
                                <a href="getImportantNews">要闻通知</a>
                            </li>
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
                            下载中心
                        </div>
                        <div class="left_news">
                            <ul>
                                <li>
                                    <a href="#" class="hover">活动资料</a>
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
                        <b>文件下载</b>
                    </div>
                    <div class="liebiao">
                        <ul>
                            <s:iterator value="%{filelist}" id="name" status="ne">
                            <li>
                            	<b>
                               	<a href="downloadAction?name=${name}">${name}</a>
                               	</b>
                            </li>
							</s:iterator>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="bottom">
                版权所有 2012-2016 <a href="http://www.jluccstsl.com/">吉林大学-计算机科学与技术学院-社团联合会</a>
            </div>
        </div>
        <script src="js/meun.js" type="text/javascript">
        </script>
    </body>
</html>
