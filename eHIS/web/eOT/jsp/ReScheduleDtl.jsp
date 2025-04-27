<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ page import= "java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.Common.CommonBean" %>
<html>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eOT/js/Booking.js' language='javascript'></script>
<script src='../../eOT/js/CancelTransfer.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
    
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='ReScheduleDtlForm' id='ReScheduleDtlForm' action='' method = 'post'>

<table class='grid' border='1' width='100%' cellpadding=3  cellspacing=0>
<tr>
	<th class='columnHeader' nowrap><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></th>
	<th class='columnHeader' nowrap><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></th>
	<th class='columnHeader' nowrap><fmt:message key="eOT.Procedure(s).Label" bundle="${ot_labels}"/></th>
	<th class='columnHeader' nowrap><fmt:message key="Common.RescheduledReason.label" bundle="${common_labels}"/></th>
	<th class='columnHeader' nowrap><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/></th>
	</tr>
<%	
String facilityid=(String)session.getValue("facility_id");
Properties p=(Properties)session.getValue("jdbc");
String login_user= p.getProperty("login_user");
String function_id=request.getParameter("function_id");


Connection conn=null;
PreparedStatement pstmt=null;	ResultSet rs=null;

String sql="",strOperDesc="",strReasonDesc="",strSurgeonName="",strSurgeonCode="",strBookingNum="",strPatientId="",strQuery="",strSpecialityCode="",strSpecialityDesc="",strSex="",strApptFromTime="",strApptToTime="",strOrderId="",strDOB="",strEncounterId="",strPatientClass="",strBookingYN = "",restrictTheatreBookingYN = "",cancel_schedule_yn = "",transfer_schedule_yn = "";
String strPatientName="";// 047067 Bharati

String bookingDetails_title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ViewBookingDetails.Label","ot_labels")+",";
String reschedule_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Reschedule.label","common_labels")+",";
String cancelappointment_title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelBooking.label","common_labels")+",";
String surgeryHistory_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.SurgeryHistory.Label","ot_labels")+",";
String chartsummery_title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientHistory.label","common_labels")+",";
String PreviousReschedule_title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.PreviousReschedule.Label","ot_labels")+",";

int fetchCount=0;
try{
	conn = ConnectionManager.getConnection(request);
	String sql_access_rights="SELECT BOOK_SCHEDULE_YN BOOK_SCHEDULE_YN1, (SELECT NVL(RESTRICT_THEATRE_BOOKING_YN,'N') FROM OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID=A.OPERATING_FACILITY_ID) RESTRICT_THEATRE_BOOKING_YN, NVL(CANCEL_SCHEDULE_YN,'N') CANCEL_SCHEDULE_YN,NVL(TRANSFER_SCHEDULE_YN,'N') TRANSFER_SCHEDULE_YN  FROM OT_BOOKING_ACCESS_RIGHTS A WHERE A.OPERATING_FACILITY_ID =?  AND APPL_USER_ID=?";
	pstmt = conn.prepareStatement(sql_access_rights);
	pstmt.setString(1,facilityid);
	pstmt.setString(2,login_user);
	rs=pstmt.executeQuery();
	if(rs.next()){
		strBookingYN=rs.getString("BOOK_SCHEDULE_YN1");
		restrictTheatreBookingYN=rs.getString("RESTRICT_THEATRE_BOOKING_YN");
		cancel_schedule_yn=rs.getString("CANCEL_SCHEDULE_YN");
		transfer_schedule_yn=rs.getString("TRANSFER_SCHEDULE_YN");
	}
	if(rs!=null)	 rs.close();
	if(pstmt!=null)  pstmt.close();

 sql=request.getParameter("sql");
 pstmt=conn.prepareCall(sql);
 rs=pstmt.executeQuery();


while(rs.next())
{
   fetchCount++;
   strPatientId=CommonBean.checkForNull(rs.getString("PATIENT_ID1"));
   strPatientName=CommonBean.checkForNull(rs.getString("PATIENT_NAME1"));
   strSex=CommonBean.checkForNull(rs.getString("SEX1"));
  strApptFromTime=CommonBean.checkForNull(rs.getString("APPT_FROM_TIME1"));//047067 Bharati
  strApptToTime=CommonBean.checkForNull(rs.getString("APPT_TO_TIME1"));	//047067 Bharati
   strDOB=CommonBean.checkForNull(rs.getString("DATE_OF_BIRTH1"));
   strOperDesc=CommonBean.checkForNull(rs.getString("OPER_DESC1"));
   strReasonDesc=CommonBean.checkForNull(rs.getString("REASON_DESC1"));  
   strSurgeonCode=CommonBean.checkForNull(rs.getString("SURGEON_CODE1"));  
   strSurgeonName=CommonBean.checkForNull(rs.getString("SURGEON_NAME1"));
   	strBookingNum=CommonBean.checkForNull(rs.getString("APPT_REF_NUM1"));
	strSpecialityCode=CommonBean.checkForNull(rs.getString("SPECIALITY_CODE1"));
 	strSpecialityDesc=CommonBean.checkForNull(rs.getString("SPECIALITY_DESC1"));
 	strEncounterId=CommonBean.checkForNull(rs.getString("ENCOUNTER_ID1"));
 	strPatientClass=CommonBean.checkForNull(rs.getString("PATIENT_CLASS1"));
 	strOrderId=CommonBean.checkForNull(rs.getString("ORDER_ID"));

		
if(fetchCount%2==0)	strQuery="gridData";
else		strQuery="gridData";


%><tr>

<input type='hidden' name='xx<%=fetchCount%>' id='xx<%=fetchCount%>' value='<%=strSurgeonName%>'>
<input type='hidden' name='splty<%=fetchCount%>' id='splty<%=fetchCount%>' value='<%=strSpecialityDesc%>'><%

out.println("<input type='hidden' name='patsexdob"+fetchCount+"' id='patsexdob"+fetchCount+"' value=\""+strPatientId+"::"+strPatientName+"::"+strSex+"::"+strDOB+"\">");
out.println("<td width='' nowrap id='orderctl"+fetchCount+"' style='cursor:pointer' class='gridDataBlue' onClick=\"commonDisplayTooltip('RS1,RS2,RS3,RS6,RS4,RS5','"+bookingDetails_title+PreviousReschedule_title+reschedule_title+cancelappointment_title+surgeryHistory_title+chartsummery_title+"','"+strBookingNum+","+facilityid+","+strPatientId+","+strSurgeonCode+","+strSpecialityCode+","+fetchCount+","+strOrderId+","+strApptFromTime+","+strApptToTime+"',this,'imgArrow"+fetchCount+"');\"  width='15%'  onMouseOver='hideToolTip();'><a class='gridDataBlue' href=\"javascript:commonDisplayTooltip('RS1,RS2,RS3,RS6,RS4,RS5','"+bookingDetails_title+PreviousReschedule_title+reschedule_title+cancelappointment_title+surgeryHistory_title+chartsummery_title+"','"+strBookingNum+","+facilityid+","+strPatientId+","+strSurgeonCode+","+strSpecialityCode+","+fetchCount+","+strOrderId+","+strApptFromTime+","+strApptToTime+"',this,'imgArrow"+fetchCount+"');\">"+strPatientId+"<img align='right' src='../../eCommon/images/inactiveArrow.gif' name='imgArrow"+fetchCount+"' id='imgArrow"+fetchCount+"'></td>");

%><td class='<%=strQuery%>'  nowrap><%=strPatientName%></td>

<td class='<%=strQuery%>'  nowrap><%=strOperDesc%></td>

<td class='<%=strQuery%>'  nowrap><%=strReasonDesc%></td>

<td class='<%=strQuery%>'  nowrap><%=strSurgeonName%></td>
</tr><%
	}
if(fetchCount==0)	 out.println("<script>callNoRecord();</script>");

}catch(Exception ee)
{
	ee.printStackTrace();
	System.err.println(" Caught Exception in CancelTrnsferDtl.jsp : "+ee);
}
finally{
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();


ConnectionManager.returnConnection(conn,request);
}
%>
 </table>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='strBookingYN' id='strBookingYN' value="<%=strBookingYN%>">
<input type='hidden' name='restrictTheatreBookingYN' id='restrictTheatreBookingYN' value="<%=restrictTheatreBookingYN%>">
<input type='hidden' name='cancel_schedule_yn' id='cancel_schedule_yn' value="<%=cancel_schedule_yn%>">
<input type='hidden' name='transfer_schedule_yn' id='transfer_schedule_yn' value="<%=transfer_schedule_yn%>">
<input type='hidden' name='encounter_id' id='encounter_id' value="<%=strEncounterId%>"> 
<input type='hidden' name='patient_class' id='patient_class' value="<%=strPatientClass%>">
<input type='hidden' name='login_user' id='login_user' value="<%=login_user%>">
<input type='hidden' name='facilityid' id='facilityid' value="<%=facilityid%>">
<input type='hidden' name='function_id' id='function_id' value="<%=function_id%>">
<input type='hidden' name='strPatientId' id='strPatientId' value="<%=strPatientId%>">
<input type='hidden' name='strBookingNum' id='strBookingNum' value="<%=strBookingNum%>">
 </form>
 	<div name='tooltiplayer' id='tooltiplayer' style='position:absolute; width:20%; visibility:hidden;' bgcolor='blue'>	
	</div>
</html>

