<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ page import= "java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.Common.CommonBean,eOT.Common.OTRepository" %>

<html>

<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

	<script src='../../eOT/js/Booking.js' language='javascript'></script>
	<script src='../../eOT/js/CancelTransfer.js' language='javascript'></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<head>
<style>	</style>
</head>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='PreReScheduleFrm' id='PreReScheduleFrm' action='' method = 'post'>

<table  border='1' width='100%' cellpadding= 3 cellspacing=0>
<TR>
			<th class ='columnheader' nowrap> <fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/></th>
			<th class ='columnheader' nowrap> <fmt:message key="Common.BookingDate.label" bundle="${common_labels}"/></th>
			<th class ='columnheader' nowrap> <fmt:message key="Common.StartTime.label" bundle="${common_labels}"/></th>
			<th class ='columnheader' nowrap> <fmt:message key="Common.EndTime.label" bundle="${common_labels}"/></th>
			<th class ='columnheader' nowrap><fmt:message key="Common.room.label" bundle="${common_labels}"/></th>
			<th class ='columnheader' nowrap><fmt:message key="Common.DoneBy.label" bundle="${common_labels}"/></th>
			<th class ='columnheader' nowrap><fmt:message key="eOT.ActionDate.Label" bundle="${common_labels}"/></th>
			<th class ='columnheader' nowrap><fmt:message key="Common.reason.label" bundle="${common_labels}"/></th>
</TR>
<%	
String strFacilityId  = (String) session.getValue("facility_id");

String strBookingNum=CommonBean.checkForNull(request.getParameter("booking_no"));


Connection conn=null;
PreparedStatement pstmt=null;	ResultSet rs=null;
String sql="";


String strSurgeonName="";
String strBookingDate="";
String strApptFromTime="";
String strApptToTime="";
String strOperRoomDesc="";
//String strOperRoomCode="";
String strDoneBy="",strActionDate="",strReason="";

String strQuery="";
int fetchCount=0;

try{
conn = ConnectionManager.getConnection(request);


/*sql="SELECT OPER_ROOM_CODE OPER_ROOM_CODE1, OPER_ROOM_DESC OPER_ROOM_DESC1, BOOKING_NUM  BOOKING_NUM1,to_char(BOOKING_DATE,'dd/mm/yyyy')  BOOKING_DATE1,to_char(BOOKING_START_TIME ,'hh24:mi') BOOKING_START_TIME1,to_char(BOOKING_END_TIME,'hh24:mi')  BOOKING_END_TIME1,SURGEON_CODE SURGEON_CODE1, SURGEON_NAME SURGEON_NAME1,OPER_TRFR_CODE OPER_TRFR_CODE1,REASON_DESC REASON_DESC1,ACTION_BY_ID ACTION_BY_ID1,to_char(ACTION_DATE,'dd/mm/yyyy')  ACTION_DATE1 FROM OT_BOOKING_RESCHD_DTLS_VW WHERE OPERATING_FACILITY_ID = ? AND BOOKING_NUM = ?";
*/
sql=OTRepository.getOTKeyValue("SQL_OT_PRERESCHEDULE_SELECT1");


pstmt=conn.prepareCall(sql);
pstmt.setString(1,strFacilityId);
pstmt.setString(2,strBookingNum);
rs=pstmt.executeQuery();

while(rs.next())
{
	fetchCount++;
	//strOperRoomCode=CommonBean.checkForNull(rs.getString("OPER_ROOM_CODE1"));
	strBookingNum=CommonBean.checkForNull(rs.getString("BOOKING_NUM1"));
	strBookingDate=CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("BOOKING_DATE1"),"DMY","en",locale));
   	strSurgeonName=CommonBean.checkForNull(rs.getString("SURGEON_NAME1"));
	strApptFromTime=CommonBean.checkForNull(rs.getString("BOOKING_START_TIME1"));
	strApptToTime=CommonBean.checkForNull(rs.getString("BOOKING_END_TIME1"));	strOperRoomDesc=CommonBean.checkForNull(rs.getString("OPER_ROOM_DESC1"));
	strDoneBy=CommonBean.checkForNull(rs.getString("ACTION_BY_ID1"));
	strActionDate=CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("ACTION_DATE1"),"DMY","en",locale));
	strReason=CommonBean.checkForNull(rs.getString("REASON_DESC1"));	
		
if(fetchCount%2==0)	strQuery="gridData";
else		strQuery="gridData";

out.println("<tr>");


out.println("<td class='"+strQuery+"' nowrap >"+strSurgeonName+"</td>");

out.println("<td class='"+strQuery+"' nowrap >"+strBookingDate+"</font></td>");
	
out.println("<td class='"+strQuery+"' nowrap >"+strApptFromTime+"</td>");

out.println("<td class='"+strQuery+"' nowrap >"+strApptToTime+"</td>");

out.println("<td class='"+strQuery+"' nowrap >"+strOperRoomDesc+"</td>");

out.println("<td class='"+strQuery+"' nowrap >"+strDoneBy+"</td>");
out.println("<td class='"+strQuery+"' nowrap >"+strActionDate+"</td>");

out.println("<td class='"+strQuery+"' nowrap ><input type='hidden' name='REASON"+fetchCount+"' id='REASON"+fetchCount+"' value=\""+strReason+"\"><a  href=\"javascript:showRemarks(document.forms[0].REASON"+fetchCount+",'0')\">"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reason.label","common_labels")+"</a></td>");

out.println("</tr>");
	}
if(fetchCount==0)
	 out.println("<script>callNoRecord();</script>");

}catch(Exception ee)
{
//eOT.LogFile.log("OTDebugger","Exception"+ee,this);	 
}
finally{
	if(rs!=null) rs.close();
	pstmt.close();
ConnectionManager.returnConnection(conn,request);
}
%>
 </table>
 <input type='hidden' name='param1' id='param1' value="">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
 </form>
</html>

