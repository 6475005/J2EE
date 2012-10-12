<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>管理登录</title>
        <link href="css/css.css" rel="stylesheet" type="text/css" />
        <script type="text/javascript">
			function changeimg() {
				var myimg = document.getElementById("code");
				now = new Date();
				myimg.src = "makeCertPic.jsp?code=" + now.getTime();
				}
		</script>
    </head>
    <body>
        <div class="main">
            <div class="center">
                <div class="box_2">
                    <div class="left_title">
                        会员中心
                    </div>
                    <form name="login" action="loginAction" method="post">
                    <label style="color: #FF0000"><s:property value="#session.top" /></label>
                    <table width="100%" border="0" cellspacing="0" cellpadding="0">
                    	<tbody>
                        <tr>
                            <td width="32%" height="37" valign="middle">
                                用户名：
                            </td>
                            <td width="68%" valign="middle">
                                <input type="text" name="admin.username" id="textfield" class="input_1" maxlength="15" maxlength="15"/>
                            </td>
                        </tr>
                        <tr>
                            <td height="37" valign="middle">
                                密　码：
                            </td>
                            <td valign="middle">
                                <input type="password" name="admin.password" id="textfield2" class="input_2" maxlength="15"/>
                            </td>
                        </tr>
                        <tr>
                            <td height="37" valign="middle">
                                验证码：
                            </td>
                            <td valign="middle">
                                <input type="text" size=4 name="CertCode" id="CertCode" class="input_3" style="float:left"/><span style="float:left; margin-left:6px;"><img id="code" src="makeCertPic.jsp" /><a href="javascript:changeimg()">看不清</a></span>
                            </td>
                        </tr>
                        <tr>
                            <td colspan="2" align="right">
                                <input  type="submit" value="登录" />
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