<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %>
<%request.setCharacterEncoding("UTF-8");
String htmlData = request.getParameter("news.content") != null ? request.getParameter("news.content") : ""; %>
<%@taglib prefix="s" uri="/struts-tags" %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>添加新闻</title>
        <link href="css/css.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" href="kindeditor-4.0.6/themes/default/default.css" />
        <link rel="stylesheet" href="kindeditor-4.0.6/plugins/code/prettify.css" />
        <script charset="utf-8" src="kindeditor-4.0.6/kindeditor.js">
        </script>
        <script charset="utf-8" src="kindeditor-4.0.6/lang/zh_CN.js">
        </script>
        <script charset="utf-8" src="kindeditor-4.0.6/plugins/code/prettify.js">
        </script>
        <script>
            KindEditor.ready(function(K){
                var editor1 = K.create('textarea[name="news.content"]', {
                    cssPath: 'kindeditor-4.0.6/plugins/code/prettify.css',
                    uploadJson: 'kindeditor-4.0.6/jsp/upload_json.jsp',
                    fileManagerJson: 'kindeditor-4.0.6/jsp/file_manager_json.jsp',
                    allowFileManager: true,
                    afterCreate: function(){
                        var self = this;
                        K.ctrl(document, 13, function(){
                            self.sync();
                            document.forms['example'].submit();
                        });
                        K.ctrl(self.edit.doc, 13, function(){
                            self.sync();
                            document.forms['example'].submit();
                        });
                    }
                });
                prettyPrint();
            });
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
            <div class="meun_2">
                [欢迎您：<s:property value="#session.NAME" /> 您上次登陆的时间为 <s:property value="#session.TIME" />] 
            </div>
            <div class="main">
                <div class="left">
                    <div class="box_1">
                        <div class="left_title">
                            新闻管理
                        </div>
                        <div class="left_news">
                            <ul>
                                <li>
                                    <a href="#" class="hover">添加新闻</a>
                                </li>
                                <li>
                                    <a href="getAllNewsAction">修改新闻</a>
                                </li>
                                <li>
                                    <a href="getNewsToDelete">删除新闻</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="box_1">
                        <div class="left_title">
                            留言管理
                        </div>
                        <div class="left_news">
                            <ul>
                                <li>
                                    <a href="getMessageDitals">查看留言</a>
                                </li>
                                <li>
                                    <a href="getMessageToDelete">删除留言</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="box_1">
                        <div class="left_title">
                            下载管理
                        </div>
                        <div class="left_news">
                            <ul>
                                <li>
                                    <a href="fileupload.jsp">上传文件</a>
                                </li>
                                <li>
                                    <a href="getFilesAction">删除文件</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="box_1">
                        <div class="left_title">
                            账户管理
                        </div>
                        <div class="left_news">
                            <ul>
                                <li>
                                    <a href="repassword.jsp">修改密码</a>
                                </li>
                                <li>
                                    <a href="exitAction">退出系统</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="right">
                    <div class="right_title">
                        <b>添加新闻</b>
                    </div>
                    <div class="xiangqing">
                        <form name="example" method="post" action="addNewsAction">
                            <br/>
                            <b>新闻种类：</b>
                            <select name="news.type">
                                <option selected="selected" value="0">社联新闻</option>
                                <option value="1">社团新闻</option>
                                <option value="2">要闻提示</option>
                            </select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<b>新闻标题：</b>
                            <input name="news.title" type="text" size="40" style="width:450px"/>
                            <br/>
                            <br/>
                            <textarea name="news.content" cols="100" rows="8" style="width:690px;height:300px;visibility:hidden;">
                                <%=htmlspecialchars(htmlData) %>
                            </textarea>
                            <br/>
                            <b>是否置顶：</b>
                            <input name="news.state" value="1" type="checkbox" /><input type="submit" name="button" value="提交内容" style="margin-left:370px"/>(提交快捷键: Ctrl + Enter)
                        </form>
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
<%!
private String htmlspecialchars(String str) {
str = str.replaceAll("&", "&amp;");
str = str.replaceAll("<", "&lt;");
str = str.replaceAll(">", "&gt;");
str = str.replaceAll("\"", "&quot;");
return str;
} %>