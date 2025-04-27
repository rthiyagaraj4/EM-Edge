<!DOCTYPE html>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:	
*	Created By		:	Vinay
*	Created On		:	15 Feb 2005
--%>
<html>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%
request.setCharacterEncoding("UTF-8");
//String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%

Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

String shift_val = request.getParameter("shift_val");
String p_schedule_date = request.getParameter("p_schedule_date");
try
{
	con = ConnectionManager.getConnection(request);
	String sql = "select PRODUCTIVE_FLAG,SHIFT_INDICATOR, decode(SHIFT_INDICATOR,'P','Productive','U','Unproductive')SHIFT_IND,decode(PRODUCTIVE_FLAG,'W','Working','O','Oncall') PROD_FLAG,mnemonic_key mnemonic,?||to_char(shift_start_time,'hh24:mi') shift_start_time,to_char(to_date(?,'dd/mm/yyyy')+            decode(sign(to_date(to_char(shift_start_time,'hh24:mi'),'hh24:mi') -                    to_date(to_char(shift_end_time,'hh24:mi'),'hh24:mi')),1,1,0 ),'dd/mm/yyyy') ||to_char(shift_end_time,'hh24:mi')   shift_end_time from am_shift where shift_code=?";
	pstmt = con.prepareStatement(sql);
	pstmt.setString(1,p_schedule_date);
	pstmt.setString(2,p_schedule_date);
	pstmt.setString(3,shift_val);
	rs = pstmt.executeQuery();
	String shift_indicator = "";
	String productive_flag = "";
	String shift_ind = "";
	String prod_flag = "";
	String mnemonic = "";
	String shift_start_time = "";
	String shift_end_time = "";
	if(rs!=null){
		if(rs.next()){
			shift_indicator = rs.getString("SHIFT_IND");
			productive_flag = rs.getString("PROD_FLAG")==null?"":rs.getString("PROD_FLAG");
			mnemonic = rs.getString("mnemonic");
			shift_ind = rs.getString("SHIFT_INDICATOR");
			prod_flag = rs.getString("PRODUCTIVE_FLAG");
			shift_start_time = rs.getString("shift_start_time");
			shift_end_time = rs.getString("shift_end_time");
		}
	}
	if(pstmt!=null) pstmt.close();
	if(rs!=null) rs.close();
%>
<script>
	parent.ManageWorkScheduleAllocate_frames.document.getElementById("productive").innerText=""+"    "+"<%=shift_indicator%>"+"      "+"<%=productive_flag%>";
	parent.ManageWorkScheduleAllocate_frames.document.ManageWorkScheduleAllocate.mnemonic.value = "<%=mnemonic%>";
	parent.ManageWorkScheduleAllocate_frames.document.ManageWorkScheduleAllocate.shift_start_time.value = "<%=shift_start_time%>";
	parent.ManageWorkScheduleAllocate_frames.document.ManageWorkScheduleAllocate.shift_end_time.value = "<%=shift_end_time%>";
	parent.ManageWorkScheduleAllocate_frames.document.ManageWorkScheduleAllocate.shift_indicator.value = "<%=shift_ind%>";
	parent.ManageWorkScheduleAllocate_frames.document.ManageWorkScheduleAllocate.productive_flag.value = "<%=prod_flag%>";
</script>
<%
}
catch (Exception e)
{
	out.println(e.toString());
}
finally
{
	try
	{
	if(pstmt!=null) pstmt.close();
	if(rs!=null) rs.close();
	ConnectionManager.returnConnection(con,request);
	}
	catch(Exception exp)
	{
		out.println(exp.toString());
	}
}
%>
</html>
