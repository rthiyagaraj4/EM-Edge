<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,eCommon.XSSRequestWrapper,webbeans.eCommon.ConnectionManager"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%
Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
String scheduleRestrictYn = "";
String include_blocked_slot = "";//ML-MMOH-CRF-0337
String facility_id = (String) session.getValue("facility_id");	
String sql="";
String sql1="";//ML-MMOH-CRF-0337
try{
		con=ConnectionManager.getConnection(request);
		sql ="select SCHEDULE_RESTRICT_YN from OT_PARAM";
		sql1 ="SELECT INCLUDE_BLOCKED_SLOT  FROM OT_PARAM_FOR_FACILITY where operating_facility_id = ? ";//ML-MMOH-CRF-0337
		stmt=con.prepareStatement(sql);
		rs=stmt.executeQuery();
		if(rs!=null && rs.next())
		{
			scheduleRestrictYn = checkForNull(rs.getString("SCHEDULE_RESTRICT_YN"));
		}
		//ML-MMOH-CRF-0337
		stmt=con.prepareStatement(sql1);
		stmt.setString(1,facility_id);
		rs=stmt.executeQuery();
		if(rs!=null && rs.next())
		{
			include_blocked_slot = checkForNull(rs.getString("INCLUDE_BLOCKED_SLOT"));
		}
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		//ML-MMOH-CRF-0337
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
  </head>
    <body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
    <form >
    <table border="1"  width="100%">

	<td align=='right' width='2%' class='OAGREEN'> </td>
	<td align='left' width='9%' colspan='3' class='label'><fmt:message key="Common.Schedule.label" bundle="${common_labels}"/></td>

	<td align='right' width='2%' class='OALABEL'></td>
	<td align='left' width='9%' colspan='3' class='label'><fmt:message key="eOT.UnSchedule.Label" bundle="${ot_labels}"/></td>

	<td align='right' width='2%' class='OAHOLIDAY''></td>
	<td align='left' width='9%' colspan='3' class='label'><fmt:message key="Common.Holiday.label" bundle="${common_labels}"/></td>

	<td align='right' width='2%' class='OAFULL'> </td>
	<td align='left' width='9%' colspan='3' class='label'><fmt:message key="Common.FullyBooked.label" bundle="${common_labels}"/></td>

	<td align='right' width='2%' class='EMERGENT'> </td>
	<td align='left' width='20%' colspan='3' class='label'><fmt:message key="eOT.AllowedForOverBooking.Label" bundle="${ot_labels}"/></td>
	<!-- CRF-004.1 - 36448 changed on 15-3-13 by MuthuN for 38275  -->
	<%
		if("Y".equals(scheduleRestrictYn)){
	%>
    <td align='right' width='2%' class='CYANCLR'> </td>
	<td align='left' width='28%' colspan='3' class='label'><fmt:message key="eOT.BookingAuthorizationRequired.Label" bundle="${ot_labels}"/></td>
	<%
		}
	%>
	<% 
	//if("N".equals(include_blocked_slot)){
	%>
	<td align='right' width='2%' class='OARED'> </td>
	<td align='left' width='9%' colspan='3' class='label'><fmt:message key="eOT.FullyBlocked.Label" bundle="${ot_labels}"/></td>
	<td  align='right' width='2%' class='label' style="border: 1px solid red;">&nbsp</td>
	<td align='left' width='9%' colspan='3' class='label'><fmt:message key="eOT.PartiallyBlocked.Label" bundle="${ot_labels}"/></td>
	<%
	//}
	%>
	<%
}catch(Exception e)
	{
		e.printStackTrace();
		//out.println("Exception is "+e);	
		}
		finally{
			try{
			if(stmt!=null) stmt.close();
			if(rs!=null)rs.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e)
			{
				e.printStackTrace();
				//out.println("Exception is "+e);
			}
		
		}
	%>
	<!-- CRF-004.1 - 36448  -->
    </table>
    </form>
    </body>
</html>

