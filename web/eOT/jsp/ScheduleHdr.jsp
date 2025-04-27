<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
 <%@ page import ="java.util.StringTokenizer,
							  java.sql.Connection,
							  java.sql.PreparedStatement,
							  java.sql.ResultSet,
							  java.sql.Types,
							  webbeans.eCommon.ConnectionManager,
							  eCommon.Common.CommonBean,
							  java.sql.CallableStatement" 
 %>
<%@ page import = "eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% String locale = (String)session.getAttribute("LOCALE"); 
   String facility_id = (String) session.getValue("facility_id");
%>
<%	request.setCharacterEncoding("UTF-8");
    //Added Against MMS Vulnerability Issue - Starts
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends
%>
<html>
<head>

<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src="../../eCommon/js/CommonCalendar.js" language="javascript"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="Javascript" src="../../eOT/js/Schedule.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<body onload="disablereset(); onloadAssignDay();">
<form name="ScheduleHdr" id="ScheduleHdr" method="POST" >
<%
String strSurgeonName=CommonBean.checkForNull(request.getParameter("surgeonName"));
String strRoomDesc=CommonBean.checkForNull(request.getParameter("roomDesc"));
String roomCode=CommonBean.checkForNull(request.getParameter("roomCode"));
String strSpecialityDesc=CommonBean.checkForNull(request.getParameter("speciality_desc"));
//Commented convertDate for IN024449 by AnithaJ on 10/15/2010
String strBookingDate=CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(request.getParameter("booking_date"),"DMY","en",locale));
String strBookingDateProc=CommonBean.checkForNull(request.getParameter("booking_date"));
String strBookingNo=CommonBean.checkForNull(request.getParameter("booking_no"));
String startTime=CommonBean.checkForNull(request.getParameter("startTime"));// 44528 - Chaitanya
String endTime=CommonBean.checkForNull(request.getParameter("endTime"));
String surgeonCode=CommonBean.checkForNull(request.getParameter("surgeonCode"));
String selSurgeonCode = CommonBean.checkForNull(request.getParameter("selSurgeonCode")); // 051825
String speciality_code=CommonBean.checkForNull(request.getParameter("speciality_code"));
String orderid=CommonBean.checkForNull(request.getParameter("orderid"));
String selOrderIds=CommonBean.checkForNull(request.getParameter("selOrderIds")); // ChAiTu - 186
System.out.println("====selOrderIds==header=="+selOrderIds);
String procedure=CommonBean.checkForNull(request.getParameter("procedure"));
String called_from=CommonBean.checkForNull(request.getParameter("called_from"));
String function_id=CommonBean.checkForNull(request.getParameter("function_id"));
String full_vacant=CommonBean.checkForNull(request.getParameter("full_vacant"));
String chkSize = CommonBean.checkForNull(request.getParameter("chkSize"));
String strStatus="";
String strPatientID="";
String strResultString = "";
StringTokenizer strToken = null;
String strValue = "";
String fullVacantVal = CommonBean.checkForNull(request.getParameter("fullVacantVal"));
String frameNmbr = CommonBean.checkForNull(request.getParameter("frameNmbr"));
String overBookingWindowYN=CommonBean.checkForNull(request.getParameter("overBookingWindowYN"));

CallableStatement callableStatement = null;
Connection conn = null;
/*Below line Added for Senthil*/
PreparedStatement pstmt = null;
ResultSet overbooking_rs=null;

String SqlQuery="", RoomQuery="";
int over_booking_count=0;
int over_booking_count_room=0;
boolean check_count=false;
try
{
	conn = ConnectionManager.getConnection(request);
	
	/*Added by Senthil*/
	SqlQuery = " select count(*) over_book_count from OT_BOOKING_HDR a, ot_booking_dtls b, mp_patient_mast c, OT_NATURE_OF_SURGERY d, ot_oper_mast_lang_vw e, Am_practitioner_lang_vw f where b.booking_num = a.booking_num and c.patient_id = a.patient_id and e.oper_code =  b.oper_code and e.language_id = ? and a.oper_room_code = ? and d.nature_code = a.nature_code and f.language_id(+) = ? and a.TEAM_DOCTOR_CODE = f.practitioner_id(+) and to_char(a.booking_date,'dd/mm/yyyy') = ? and a.OVER_BOOKED_YN=? and BOOKING_STATUS <> '9'";
	 pstmt = conn.prepareStatement(SqlQuery);
	 pstmt.setString(1,locale);
     pstmt.setString(2,roomCode);
     pstmt.setString(3,locale);    
     pstmt.setString(4,strBookingDate);
	 pstmt.setString(5,"Y"); 
     overbooking_rs = pstmt.executeQuery();	
	if(overbooking_rs!=null && overbooking_rs.next())
	{
	  over_booking_count=overbooking_rs.getInt("over_book_count");
	}
	  if(pstmt!=null)pstmt.close(); if(overbooking_rs!=null)overbooking_rs.close();
	  RoomQuery=" select NVL(OVER_BOOK_COUNT,0) over_book_roomcount from OT_OPER_ROOM where oper_room_code = ? and OPERATING_FACILITY_ID = ? ";
	  pstmt = conn.prepareStatement(RoomQuery);	
      pstmt.setString(1,roomCode);
	  pstmt.setString(2,facility_id);
	  overbooking_rs = pstmt.executeQuery();	
	if(overbooking_rs!=null && overbooking_rs.next())
	{
	  over_booking_count_room = overbooking_rs.getInt("over_book_roomcount");
	}
		
	if(pstmt!=null)pstmt.close(); if(overbooking_rs!=null)overbooking_rs.close();
	if(over_booking_count < over_booking_count_room) 
		check_count=true;
	//if(over_booking_count>over_booking_count_room) check_count=false;
	
	
	
	/*End Senthil*/	
	
	callableStatement=conn.prepareCall("{ call OT_SURGEON_CALENDAR(?,?,?,?,?)}");
	System.out.println("=====facility_id====schedulehdr=========="+facility_id);
	System.out.println("======surgeonCode===schedulehdr=========="+surgeonCode);
	System.out.println("=====roomCode====schedulehdr=========="+roomCode);
	System.out.println("=====strBookingDate====schedulehdr=========="+strBookingDate);
	callableStatement.setString(1, facility_id);
	callableStatement.setString(2, surgeonCode);
	callableStatement.setString(3, roomCode);
	callableStatement.setString(4, strBookingDateProc);		
	callableStatement.registerOutParameter(5, Types.VARCHAR);
	callableStatement.execute();
	strResultString = callableStatement.getString(5);
	strToken = new StringTokenizer(strResultString, "#");
	System.out.println("===strToken==="+strToken);
	if(strToken.hasMoreTokens())
	{
		strValue = strToken.nextToken();
		System.out.println("===strValue==="+strValue);
	}
}
catch(Exception ee)
{ 
	ee.printStackTrace();
}
finally
{
	if(conn!=null)
		conn.close();
}

%>

<table class='white' border="0" cellpadding=3  cellspacing="0" width="100%" align="center">
	<tr> 
		<td class='label' width='25%'>
			<b class='label'><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/>:</b>
		</td>
		<td class='label' width='25%'>
			<%=strSurgeonName%>
		</td>
		<td class='label' width='25%'>
			<b><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>:</b>
		</td>
		<td class='label' width='25%'>
			<%=strSpecialityDesc%>
		</td> 
	</tr>
	<tr>
		<td class='label' width='25%'>
			<b><fmt:message key="Common.Theatre.label" bundle="${common_labels}"/>:</b>
		</td>
		<td class='label' width='25%'>
			<%=strRoomDesc%>
		</td>
		<td class='label' width='25%'>
			<b><fmt:message key="Common.apptdate.label" bundle="${common_labels}"/>:</b>
		</td>
		<td class='label' width='25%'>
			<%=strBookingDate%>
		</td>
	</tr>
	<tr>
		<td  class='label' width='25%' nowrap> 
			<fmt:message key="Common.ScheduleDate.label" bundle="${common_labels}"/>
		</td>
		<td  class='label' width='25%' nowrap> 
			<input type='text' name='sch_date' id='sch_date' id='sch_date' size='8'  value='<%=strBookingDate%>' onblur='isValidDateLocal(this)'>
			<img src='../../eCommon/images/CommonCalendar.gif' onClick="parent.showCalendar_loc(this.previousElementSibling,'dd/mm/y',this.parentElement.nextElementSibling.querySelector('#day'));"></img>
			<img src='../../eCommon/images/mandatory.gif'></img>
		</td>
		<td  class='label' width='25%' nowrap> 
			<input type='text' name="day" id="day" readonly  value="" tabindex='-1' style="border=1"/>
		</td>
	</tr>
	<tr>
		<td width='25%'>
			<input type='button' class='button' value='Go' onClick='loadSchedulePage();'>
		<td>
<%
/* 
		System.out.println("========strStatus=========schedulehdr========="+strStatus);
		System.out.println("========strPatientID=========schedulehdr========="+strPatientID);
		if(!strStatus.equals("30") && strPatientID.length() != 0)
		{
*/
		if(String.valueOf(strValue.charAt(0)).equals("O") )// && check_count)
		{
%>
			<td id='overBooking' width='25%'>
				<input type='button' class='button' value='Over Booking' onClick='showBookingDialogOverBook("<%=speciality_code%>", "<%=strSpecialityDesc%>", "<%=surgeonCode%>", "<%=strSurgeonName.replaceAll("'", "")%>", "<%=roomCode%>", "<%=strRoomDesc%>", "<%=strBookingDate%>", "<%=full_vacant%>", "<%=called_from%>", "", "", "<%=frameNmbr%>", "<%=overBookingWindowYN%>");'>
			</td>
<%
		}
%>
	</tr>
</table>

<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='facility_id' id='facility_id' value="<%=facility_id%>">
<input type='hidden' name='bkng_no' id='bkng_no' value="<%=strBookingNo%>">
<input type='hidden' name='startTime' id='startTime' value='<%=startTime%>'> <!-- 44528 - Chaitanya -->
<input type='hidden' name='endTime' id='endTime' value='<%=endTime%>'>
<input type='hidden' name='bkng_date' id='bkng_date' value="<%=strBookingDate%>">
<input type='hidden' name='HsurgeonDesc' id='HsurgeonDesc' value="<%=strSurgeonName%>">
<input type='hidden' name='HroomDesc' id='HroomDesc' value="<%=strRoomDesc%>">
<input type='hidden' name='HroomCode' id='HroomCode' value="<%=roomCode%>">
<input type='hidden' name='HspecialityDesc' id='HspecialityDesc' value="<%=strSpecialityDesc%>">
<input type='hidden' name='HsurgeonCode' id='HsurgeonCode' value="<%=surgeonCode%>">
<input type='hidden' name='Hspeciality_code' id='Hspeciality_code' value="<%=speciality_code%>">
<input type='hidden' name='Horderid' id='Horderid' value="<%=orderid%>">
<input type='hidden' name='selOrderIds' id='selOrderIds' id='selOrderIds' value='<%=selOrderIds%>'> <%-- ChAiTu - 186 --%>
<input type='hidden' name='Hprocedure' id='Hprocedure' value="<%=procedure%>">
<input type='hidden' name='Hcalled_from' id='Hcalled_from' value="<%=called_from%>">
<input type='hidden' name='Hfunction_id' id='Hfunction_id' value="<%=function_id%>">
<input type='hidden' name='Hfull_vacant' id='Hfull_vacant' value="<%=full_vacant%>">
<input type="hidden" name="chkSize" id="chkSize" id="chkSize" value="<%=chkSize%>">
<input type="hidden" name="fullVacantVal" id="fullVacantVal" id="fullVacantVal" value="<%=fullVacantVal%>">
<input type="hidden" name="frameNmbr" id="frameNmbr" id="frameNmbr" value="<%=frameNmbr%>">
<input type="hidden" name="selSurgeonCode" id="selSurgeonCode" id="selSurgeonCode" value="<%=selSurgeonCode%>"> <!-- 051825 -->
</form>
</body>
</html>

