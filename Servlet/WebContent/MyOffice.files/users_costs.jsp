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
<%
	String id = request.getParameter("id");
	List<Cost> list = UserDb.getCost(id);
	List<CostDetials> detials = new ArrayList<CostDetials>();
	for(Cost cost:list){
		String state = "欠费";
		if(cost.getState()==1){
			state = "不欠费";
		}
		String uname = UserDb.queryById(cost.getUid().toString()).getName();
		CostDetials cd = new CostDetials(cost.getId(),uname,cost.getMonthlyPay(),
				cost.getYear(),cost.getMonth(),state);
		detials.add(cd);
	}
	int count = detials.size();
	int countPage = (Integer.valueOf(count)/7)+1;
	String currentpage = request.getParameter("currentPage");
	int currentPage = 1;
	if(currentpage == null || currentpage.length() <= 0){
		currentPage = 1;
	}else{
		currentPage = Integer.valueOf(currentpage);
		if(currentPage >= countPage){
			currentPage = countPage;
		}
		if(currentPage <= 0){
			currentPage = 1;
		}
	}
	List<CostDetials> Detials = new ArrayList<CostDetials>();
	int startRow = (currentPage - 1) * 7;
	for(int i=startRow;i<startRow+7;i++){
		if(detials.size()>i){
			Detials.add(detials.get(i));
		}
	}
%>
<META content="MSHTML 6.00.2900.5848" name=GENERATOR>
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
              <TBODY>
                <TR>
                  <TH class=gridViewHeader style="WIDTH: 50px" scope=col>&nbsp;</TH>
                  <TH class=gridViewHeader scope=col>编号</TH>
                  <TH class=gridViewHeader scope=col>所属业主</TH>
                  <TH class=gridViewHeader scope=col>物业费/月</TH>
                  <TH class=gridViewHeader scope=col>日期</TH>
                  <TH class=gridviewHeader scope=col>状态</TH>
                  <TH class=gridviewHeader scope=col>更新</TH>
                  <TH class=gridviewHeader scope=col>删除</TH>
                </TR>
                <%	
					for(int i = 0;i < Detials.size(); i ++){
						out.println("<TR><TD class=gridViewItem style='WIDTH: 50px'><IMG src='EmployeeMgr.files/bg_users.gif'> </TD>");
						out.println("<TD class=gridViewItem>"+Detials.get(i).getId()+"</TD>");
						out.println("<TD class=gridViewItem>"+Detials.get(i).getUid()+"</TD>");
						out.println("<TD class=gridViewItem>"+Detials.get(i).getMonthlyPay()+"</TD>");
						out.println("<TD class=gridViewItem>"+Detials.get(i).getYear()+"-"+Detials.get(i).getMonth()+"</TD>");
						out.println("<TD class=gridViewItem>"+Detials.get(i).getState()+"</TD>");
						out.println("<TD class=gridViewItem><A class=cmdField href='costs_update.jsp?id="+Detials.get(i).getId()+"'>编辑</A></TD>");
						out.println("<TD class=gridViewItem><A class=cmdField onclick=\"return confirm('确定要删除吗？');\" href='costs_delete.jsp?id="+Detials.get(i).getId()+"'>删除</A></TD></TR>");
					}
				%>
				<TR>
					<TD colspan="4" class=gridViewItem>共查询到<%=count %>条结果</TD>
					<TD class=gridViewItem>共<%=countPage %>页</TD>
					<TD class=gridViewItem><A class=cmdField href="users_costs.jsp?currentPage=<%=currentPage-1 %>&id=<%=id %>">上一页</A></TD>
					<TD class=gridViewItem>第<%=currentPage %>页</TD>
					<TD class=gridViewItem><A class=cmdField href="users_costs.jsp?currentPage=<%=currentPage+1 %>&id=<%=id %>">下一页</A></TD>
				</TR>
              </TBODY>
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
