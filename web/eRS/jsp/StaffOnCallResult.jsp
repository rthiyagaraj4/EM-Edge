<!DOCTYPE html>
<!--StaffProfile.jsp
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*	Purpose 		:	
*	Created By		:	Suchilagna Panigrahi
*	Created On		:	12th May 2005-->
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%-- Mandatory declarations end --%>
<%
request.setCharacterEncoding("UTF-8");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
<script language='javascript' src='../../eCommon/js/common.js' ></script>
<script language='javascript' src='../../eCommon/js/MstCodeCommon.js' ></script>		
<!-- <script language='javascript' src='../../eCommon/js/messages.js' ></script> -->
<script language='javascript' src='../../eRS/js/StaffOnCall.js'></script>
<!-- <script language='javascript'src='../../eRS/js/RSMessages.js' ></script> -->
<script language="JavaScript" src="../../eCommon/jsCommonLookup.js"></script>
<script language='javascript'src='../../eRS/js/RSCommon.js' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
<form name="form_StaffOnCallResult" id="form_StaffOnCallResult" target='messageFrame'>
<table cellpadding=0 cellspacing=0 border=1 width="102%" align=center>
<tr><th width='40%' align='left'>&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eRS.StaffName.label" bundle="${rs_labels}"/></th>
<th colspan=2 align='left'>&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eRS.OncallTimings.label" bundle="${rs_labels}"/></th></tr>
<%
Connection conn = null;

PreparedStatement pstmt = null;
ResultSet rs = null;

String date= request.getParameter("date")==null ? "":request.getParameter("date");
String workplace_code= request.getParameter("workplace_code")==null ? "":request.getParameter("workplace_code");
String login_facility_id = request.getParameter("login_facility_id")==null ? "":request.getParameter("login_facility_id");
String sql ="";
String staff_name = "";
String end_time = "";
String start_time = "";
String classValue = "";
int i= 0;

try{
		conn = ConnectionManager.getConnection(request);

sql = "select b.staff_name staff_name, to_char(a.shift_start_time,'dd/mm/yyyy hh24:mi')start_time,to_char(a.actual_end_time,'dd/mm/yyyy hh24:mi') end_time from rs_work_schedule a, am_staff_vw b, am_shift c where a.facility_id = ? and a.workplace_code = ? and schedule_date = to_date(?,'dd/mm/yyyy') and c.shift_code = a.shift_code and c.shift_indicator = 'P' and c.productive_flag = 'O' and b.role_type = a.role_type and b.staff_id = a.staff_id ";

pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,login_facility_id);
		pstmt.setString(2,workplace_code);
		pstmt.setString(3,date);

		rs = pstmt.executeQuery();

		while((rs != null) && (rs.next()))
		{
			staff_name = rs.getString("staff_name")==null ? "":rs.getString("staff_name");
			start_time = rs.getString("start_time")==null ? "":rs.getString("start_time");
			end_time = rs.getString("end_time")==null ? "":rs.getString("end_time");

			if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
		  else
		  	classValue = "QRYODD" ;
%>

<tr>
	<td class='<%=classValue%>'><%=staff_name%></td>
	<td class='<%=classValue%>'><%=start_time%></td>
	<td class='<%=classValue%>'><%=end_time%></td>
</tr>

<%i++;
}
}catch(Exception e)
{
	e.printStackTrace();
}
finally
{
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	if(conn!=null) ConnectionManager.returnConnection(conn,request);
}
%>
</table>
</form>
</body>
</html>

