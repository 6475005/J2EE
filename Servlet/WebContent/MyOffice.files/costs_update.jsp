<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page import="object.*"%>
<%@ page import="db.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE></TITLE>
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<STYLE type=text/css> 
{
	FONT-SIZE: 12px
}
.gridView {
	BORDER-RIGHT: #bad6ec 1px; BORDER-TOP: #bad6ec 1px; BORDER-LEFT: #bad6ec 1px; COLOR: #566984; BORDER-BOTTOM: #bad6ec 1px; FONT-FAMILY: Courier New
}
.gridViewHeader {
	BORDER-RIGHT: #bad6ec 1px solid; BORDER-TOP: #bad6ec 1px solid; BACKGROUND-IMAGE: url(../images/bg_th.gif); BORDER-LEFT: #bad6ec 1px solid; LINE-HEIGHT: 27px; BORDER-BOTTOM: #bad6ec 1px solid
}
.gridViewItem {
	BORDER-RIGHT: #bad6ec 1px solid; BORDER-TOP: #bad6ec 1px solid; BORDER-LEFT: #bad6ec 1px solid; LINE-HEIGHT: 32px; BORDER-BOTTOM: #bad6ec 1px solid; TEXT-ALIGN: center
}
.cmdField {
	BORDER-RIGHT: 0px; BORDER-TOP: 0px; BACKGROUND-IMAGE: url(../images/bg_rectbtn.png); OVERFLOW: hidden; BORDER-LEFT: 0px; WIDTH: 67px; COLOR: #364c6d; LINE-HEIGHT: 27px; BORDER-BOTTOM: 0px; BACKGROUND-REPEAT: repeat-x; HEIGHT: 27px; BACKGROUND-COLOR: transparent; TEXT-DECORATION: none
}
.buttonBlue {
	BORDER-RIGHT: 0px; BORDER-TOP: 0px; BACKGROUND-IMAGE: url(../images/bg_button_blue.gif); BORDER-LEFT: 0px; WIDTH: 78px; COLOR: white; BORDER-BOTTOM: 0px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 21px
}
</STYLE>
<META content="MSHTML 6.00.2900.5848" name=GENERATOR>
<%
		List<User> ulist = UserDb.query();
		String id = request.getParameter("id");
		Cost building = CostDb.queryById(id);
%>
<% 
	String tcp = (String)session.getAttribute("tcp");
	if(tcp == null || tcp.length() <= 0){
		tcp = "";	
	}
%>
</HEAD>
<BODY 
style="BACKGROUND-POSITION-Y: -120px; BACKGROUND-IMAGE: url(../images/bg.gif); BACKGROUND-REPEAT: repeat-x">
<DIV>
  <TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%" border=0>
    <TBODY>
      <TR 
  style="BACKGROUND-IMAGE: url(../images/bg_header.gif); BACKGROUND-REPEAT: repeat-x" 
  height=47>
        <TD width=10><SPAN 
      style="FLOAT: left; BACKGROUND-IMAGE: url(../images/main_hl.gif); WIDTH: 15px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 47px"></SPAN></TD>
        <TD><SPAN 
      style="FLOAT: left; BACKGROUND-IMAGE: url(../images/main_hl2.gif); WIDTH: 15px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 47px"></SPAN><SPAN 
      style="PADDING-RIGHT: 10px; PADDING-LEFT: 10px; FLOAT: left; BACKGROUND-IMAGE: url(../images/main_hb.gif); PADDING-BOTTOM: 10px; COLOR: white; PADDING-TOP: 10px; BACKGROUND-REPEAT: repeat-x; HEIGHT: 47px; TEXT-ALIGN: center; 0px: ">物业费管理</SPAN><SPAN 
      style="FLOAT: left; BACKGROUND-IMAGE: url(../images/main_hr.gif); WIDTH: 60px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 47px"></SPAN></TD>
        <TD 
    style="BACKGROUND-POSITION: 50% bottom; BACKGROUND-IMAGE: url(../images/main_rc.gif)" 
    width=10></TD>
      </TR>
      <TR>
        <TD style="BACKGROUND-IMAGE: url(../images/main_ls.gif)">&nbsp;</TD>
        <TD 
    style="PADDING-RIGHT: 10px; PADDING-LEFT: 10px; PADDING-BOTTOM: 10px; COLOR: #566984; PADDING-TOP: 10px; BACKGROUND-COLOR: white" 
    vAlign=top align="center">
          <DIV>
            <TABLE class=gridView id=ctl00_ContentPlaceHolder2_GridView1 
      style="WIDTH: 100%; BORDER-COLLAPSE: collapse" cellSpacing=0 rules=all 
      border=1>
              <form action="CostUpdateServlet" method="post">
              <b style="color: red;"><%=tcp %></b><br/>
             		<input type="hidden" name="id" value="<%=id %>"/>
					所属业主：<select name="uid" size=1>
					<%
					for(User user:ulist){
						if(building.getUid() == user.getId()){
							out.println("<option value='"+user.getId()+"' selected='selected'>"+user.getName()+"</option>");
						}else{
							out.println("<option value='"+user.getId()+"'>"+user.getName()+"</option>");
						}
					}
					%></select><br/>
					月付费用：<input type="text" name="monthlypay" value="<%=building.getMonthlyPay() %>" /><br/>
					截止日期：<select name="year" size=1>
					<%
					for(int i=2005;i<=2012;i++){
						if(building.getYear().equals(String.valueOf(i))){
							out.println("<option value='"+i+"' selected='selected'>"+i+"</option>");
						}else{
							out.println("<option value='"+i+"'>"+i+"</option>");
						}
					}
					%></select>年<select name="month" size=1>
					<%
					for(int i=1;i<=12;i++){
						if(building.getMonth().equals(String.valueOf(i))){
							out.println("<option value='"+i+"' selected='selected'>"+i+"</option>");
						}else{
							out.println("<option value='"+i+"'>"+i+"</option>");
						}
					}
					%></select>月<br/>
					缴费情况：<%
						if(building.getState() == 0){
							out.println("<input type='radio' name='state' value='0' checked />未交<input type='radio' name='state' value='1' />已交<br/>");
						}else{
							out.println("<input type='radio' name='state' value='0' />未交<input type='radio' name='state' value='1' checked />已交<br/>");
						}
					%>
					<input type="submit" value="提交" />
					<input type="reset" value="重置" />
				</form>	
            </TABLE>
          </DIV>
        </TD>
        <TD style="BACKGROUND-IMAGE: url(../images/main_rs.gif)"></TD>
      </TR>
      <TR 
  style="BACKGROUND-IMAGE: url(../images/main_fs.gif); BACKGROUND-REPEAT: repeat-x" 
  height=10>
        <TD style="BACKGROUND-IMAGE: url(../images/main_lf.gif)"></TD>
        <TD style="BACKGROUND-IMAGE: url(../images/main_fs.gif)"></TD>
        <TD 
style="BACKGROUND-IMAGE: url(../images/main_rf.gif)"></TD>
      </TR>
    </TBODY>
  </TABLE>
</DIV>
</BODY>
</HTML>
