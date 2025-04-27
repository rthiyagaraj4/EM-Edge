<!DOCTYPE html>
<html>
<%@page   import= "java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.sql.Clob,webbeans.eCommon.ConnectionManager,eOT.OperationDtlBean,eOT.Common.OTRepository,java.util.ArrayList,eOR.OrderEntryBillingQueryBean" %>

<%@page  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eOT/jsp/StringUtil.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<% String locale = (String)session.getAttribute("LOCALE"); 
	request.setCharacterEncoding("UTF-8"); 
	String or_bean_id 				    = "orderentrybean";
    String or_bean_name 			    = "eOR.OrderEntryBean";
%>
<head>
<!-- <TITLE><fmt:message key="Common.booking.label" bundle="${common_labels}"/></TITLE> -->
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
// fetching the Login User Id
Properties p = (Properties)session.getValue("jdbc");
String login_user = p.getProperty("login_user");
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"/>

<Script Language="JavaScript"  src="../../eCommon/js/CommonLookup.js"></Script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>

<script type="text/javascript">
	function refreshTotalCount(){
		var rowCount = document.forms[0].rowCountOverBooking.value;
		var userOverBookYN = document.forms[0].userOverBookYN.value;		
		var overbookcount = document.forms[0].overbookcount.value;//Added by Muthu against 31719
		//alert('orderid'+ document.forms[0].orderid.value);
		var params = document.forms[0].params.value;
		params = params + "&row_count="+rowCount+"&userOverBookYN="+userOverBookYN+"&overbookcount="+overbookcount;
		//alert('params' + params);//Sanjay
		//var param = "row_count="+rowCount+"&userOverBookYN="+userOverBookYN+"&overbookcount="+overbookcount;
		parent.footer_frame.location.href = '../../eOT/jsp/OperOverBookingFtr.jsp?'+params;			
	}
	function assignDuplicateValues(rowCount, procedureName, procedureDuration){
		var timeDuration = procedureDuration.split(",");
		var timeDurationSplit1 = timeDuration[0].split(":");
		var timeDurationSplit2 = timeDuration[1].split(":");
		var timeInMins1 = timeDurationSplit1[1];
		var timeInMins2 = timeDurationSplit2[1];		
		var totalTimeInMins = parseInt(timeInMins1, 10) + parseInt(timeInMins2, 10);
		var actualTimeInMins = totalTimeInMins%60;
		var additionalTimeInHrs = parseInt(totalTimeInMins/60);
		var timeInHrs1 = timeDurationSplit1[0];
		var timeInHrs2 = timeDurationSplit2[0];
		var totalTimeInHrs = parseInt(timeInHrs1, 10) + parseInt(timeInHrs2, 10) + additionalTimeInHrs;
		procedureDuration = LPad(totalTimeInHrs,2,"0") + ":" + LPad(actualTimeInMins,2,"0");
		//document.getElementById('procedureName'+rowCount).style.color = 'white'; //Commented by Muthu
		//document.getElementById('procedureDuration'+rowCount).style.color = 'white'; //Commented by Muthu
		document.getElementById('procedureName'+rowCount).style.color = '';
		document.getElementById('procedureDuration'+rowCount).style.color = '';
		document.getElementById('procedureName'+rowCount).innerHTML = procedureName;		
		//document.getElementById('procedureDuration'+rowCount).innerHTML = procedureDuration;
		document.getElementById('procedureDuration'+rowCount).innerHTML = procedureDuration + " " + getLabel("Common.Hrs.label","Common");
		
	}
	function LPad(ContentToSize,PadLength,PadChar)
	{
		var PaddedString=ContentToSize.toString();
		var PaddedStringLength = PaddedString.length;		
		if (PaddedStringLength < PadLength)
		{
			for(i=1;i<PadLength;i++)
			{
				PaddedString=PadChar+PaddedString;			
			}
		}
		
     return PaddedString;
	}
</script>
</head>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<script type="text/javascript" src="../../eOT/js/wz_tooltip.js"></script>
<form name='OverBookedCases' id='OverBookedCases' method='POST' action = '../../eOT/jsp/OperOverBookingFtr.jsp'>
<%@ include file="../../eCommon/jsp/Common.jsp"%>
<%
HttpSession httpSession = request.getSession(false);
//fetching the required parameters from the previous page Calenderslot.jsp
String strFacilityId = ""+httpSession.getValue("facility_id");
String booking_date = checkForNull(request.getParameter("booking_date"));
String roomCode = checkForNull(request.getParameter("roomCode"));
String roomDesc = checkForNull(request.getParameter("roomDesc"));
String surgeonCode1 = checkForNull(request.getParameter("surgeonCode"));
String surgeonName1 = checkForNull(request.getParameter("surgeonName"));
String speciality_code = checkForNull(request.getParameter("speciality_code"));
String speciality_desc = checkForNull(request.getParameter("speciality_desc"));
String start_time = checkForNull(request.getParameter("start_time"));
String hidden_time = checkForNull(request.getParameter("hidden_time"));
String over_booking_case_yn = checkForNull(request.getParameter("over_booking_case_yn"));
String called_from = checkForNull(request.getParameter("called_from"));
String procedure = checkForNull(request.getParameter("procedure"));
String orderid = checkForNull(request.getParameter("orderid"));
// all parameters are fetched from previous page Calenderslot.jsp

// declaring parameters to store from the query
String patientId = "";
String patIdTemp = "";
String patientShortName = "";
String surgeryType = "";
String procedureName = "";
String procedureDuration = "";
String sourceType = "";
String surgeonName = "";
String sourceCode = "";
String location = "";
String scheduleStartTime = "";
String scheduleEndTime = "";
String userOverBookYN = "";
String bookingTime = "";
//Added by muthu against 31719
String overbookcount = "";
String overbookedYN="";
//Added by muthu against 31719

int rowCount = 0;
int rowCountOverBooking = 0;
Connection con = null;
PreparedStatement pstmt = null;
PreparedStatement pstmt1 = null;
PreparedStatement pstmt2 = null;
PreparedStatement pstmt3 = null;
PreparedStatement pstmt4 = null;
ResultSet rs = null;
ResultSet rs1 = null;
ResultSet rs2 = null;
ResultSet rs3 = null;
ResultSet rs4 = null;
String sql = "";
String sqlW = "";
String sqlC = "";
String sqlE = "";
String sqlD = "";
String sqlU = "";
String sqlAvail = "";
String class_val = "";
//String class_val = "EMERGENT"; //Commented by Muthu


try{

  con = ConnectionManager.getConnection(request);  
  // Framing the Query to get the required parameters for displaying purpose
  //sql = "select c.patient_id, c.short_name, d.short_desc, e.short_Desc, to_char(b.OPER_DURN,'HH24:MI'), a.source_type, F.SHORT_NAME, a.source_code from OT_BOOKING_HDR a, ot_booking_dtls b, mp_patient_mast c, OT_NATURE_OF_SURGERY d, ot_oper_mast_lang_vw e, Am_practitioner_lang_vw f where a.over_booked_yn = ? and b.booking_num = a.booking_num and c.patient_id = a.patient_id and e.oper_code =  b.oper_code and e.language_id = ? and a.oper_room_code = ? and d.nature_code = a.nature_code and f.language_id(+) = ? and a.TEAM_DOCTOR_CODE = f.practitioner_id(+) and to_char(a.booking_date,'dd/mm/yyyy') = ?";
  sql = "select c.patient_id, c.short_name, d.short_desc, e.short_Desc, to_char(b.OPER_DURN,'HH24:MI'), a.source_type, F.SHORT_NAME, a.source_code, NVL(a.over_booked_yn,'N'), to_char(a.BOOKING_START_TIME,'hh24:mi'), a.booking_num from OT_BOOKING_HDR a, ot_booking_dtls b, mp_patient_mast c, OT_NATURE_OF_SURGERY d, ot_oper_mast_lang_vw e, Am_practitioner_lang_vw f where b.booking_num = a.booking_num and c.patient_id = a.patient_id and e.oper_code =  b.oper_code and e.language_id = ? and a.oper_room_code = ? and d.nature_code = a.nature_code and f.language_id(+) = ? and a.TEAM_DOCTOR_CODE = f.practitioner_id(+) and to_char(a.booking_date,'dd/mm/yyyy') = ? and BOOKING_STATUS <> '9' order by 11";

  sqlW = "SELECT LONG_DESC FROM IP_NURSING_UNIT_LANG_VW WHERE LANGUAGE_ID = ? AND FACILITY_ID = ? AND NVL(EFF_STATUS,'D') = 'E' and NURSING_UNIT_CODE = ?";

  sqlC = "SELECT LONG_DESC FROM OP_CLINIC_LANG_VW WHERE LANGUAGE_ID = ? AND FACILITY_ID = ? AND NVL(EFF_STATUS,'D') = 'E' and CLINIC_CODE = ?" ;

  sqlE = "SELECT LONG_DESC FROM AM_REFERRAL_LANG_VW WHERE LANGUAGE_ID = ? AND NVL(EFF_STATUS,'D') = 'E' and REFERRAL_CODE = ?" ;

  sqlD = "select to_char(WD_START_TIME,'hh24:MI'), to_char(WD_END_TIME,'hh24:MI') from OT_OPER_ROOM_LANG_VW where oper_room_code = ? and language_id = ?  and operating_facility_id = ?";

  sqlU = "select NVL(OVER_BOOK_YN, 'N') from OT_BOOKING_ACCESS_RIGHTS where APPL_USER_ID = ? and OPERATING_FACILITY_ID = ?";
  

  sqlAvail ="select NVL(OVER_BOOK_COUNT,0) from OT_OPER_ROOM where oper_room_code = ? and OPERATING_FACILITY_ID = ?";

  pstmt3 = con.prepareStatement(sqlU);
  pstmt3.setString(1,login_user);  
  pstmt3.setString(2,strFacilityId);
  rs3 = pstmt3.executeQuery();	 
	 while(rs3.next() && rs3!=null){
		 userOverBookYN = rs3.getString(1);
	 }

  pstmt2 = con.prepareStatement(sqlD);
  pstmt2.setString(1,roomCode);
  pstmt2.setString(2,locale);
  pstmt2.setString(3,strFacilityId);
  rs2 = pstmt2.executeQuery();	 
	 while(rs2.next() && rs2!=null){
		 scheduleStartTime = rs2.getString(1);
		 scheduleEndTime = rs2.getString(2);
	 }

//Added on 7-11-12 by Muthu against 31719
  pstmt4 = con.prepareStatement(sqlAvail);
  pstmt4.setString(1,roomCode);
  pstmt4.setString(2,strFacilityId);
  rs4 = pstmt4.executeQuery();	 
	 while(rs4.next() && rs4!=null){
		 overbookcount = rs4.getString(1);
	 }
	 //if (Integer.parseInt(overbookcount) > 0 ) {//Sanjay
//Added on 7-11-12 by Muthu against 31719
%>
<table border='1' cellpadding=0  cellspacing='0' width='100%'>
<tr>
	<td class='columnheader' colspan='6' >
	<fmt:message key="eOT.OverBookedCasesInTheRoom.Label" bundle="${ot_labels}"/> 	
	</td>
	<td class='columnheader' colspan='1' >
    <fmt:message key="eOT.ScheduleTime.Label" bundle="${ot_labels}"/> 	
	<td class='columnheader' colspan='1' >
	<%= scheduleStartTime %> - <%= scheduleEndTime %>
	</td>
	<!-- </td> 	</td>	-->
</tr>

<tr> </tr>

<tr>
	<td class='columnheader'>
	<fmt:message key="eOT.BookedDate.Label" bundle="${ot_labels}"/>	
	</td>
	<td class='columnheader'>
	<fmt:message key="eOT.TotalProcTime.Label" bundle="${ot_labels}"/>
	</td>
	<td class='columnheader'>
	<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
	</td>
	<td class='columnheader'>
	<fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>
	</td>
	<td class='columnheader' width = '25%'>
	<fmt:message key="Common.Procedure.label" bundle="${common_labels}"/>
	</td>
	<td class='columnheader'>
	<fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/>
	</td>
	<td class='columnheader'>
	<fmt:message key="Common.SurgeryType.label" bundle="${common_labels}"/>  
	</td>
	<td class='columnheader'>
	<fmt:message key="Common.Location.label" bundle="${common_labels}"/>
	</td>
</tr>
<%	
	 //}//Sanjay
  pstmt = con.prepareStatement(sql);
/*  pstmt.setString(1,over_booking_case_yn);
  pstmt.setString(2,locale);
  pstmt.setString(3,roomCode);
  pstmt.setString(4,locale);
  pstmt.setString(5,booking_date);
  */

  pstmt.setString(1,locale);
  pstmt.setString(2,roomCode);
  pstmt.setString(3,locale);
  pstmt.setString(4,booking_date);
  rs = pstmt.executeQuery();	 
  patientId = "";
  patIdTemp = "";
	 while(rs.next() && rs!=null)
	{	
		 		 
		 /*
		 patientId = checkForNull(rs.getString(1));
		 patientShortName = checkForNull(rs.getString(2));		 
		 surgeryType = checkForNull(rs.getString(3));
		 procedureName = checkForNull(rs.getString(4));
		 procedureDuration = checkForNull(rs.getString(5));
		 sourceType = checkForNull(rs.getString(6));
		 System.out.println("OperOverBookingHdr.jsp sourceType:" + sourceType + ":");
		 surgeonName = checkForNull(rs.getString(7));
		 sourceCode = checkForNull(rs.getString(8));
		 System.out.println("OperOverBookingHdr.jsp sourceCode:" + sourceCode + ":");
		 */		 
		 
		 
		 patIdTemp = checkForNull(rs.getString(1));
		 
		 if (patientId.equalsIgnoreCase(patIdTemp)) {			 
			 patientId = patIdTemp;			 
			 procedureName = procedureName + ", " + checkForNull(rs.getString(4));
			 //System.out.println("OperOverBookingHdr.jsp procedureName:" + procedureName);
			 //procedureDuration = procedureDuration + "," + checkForNull(rs.getString(5));
			 procedureDuration = checkForNull(rs.getString(5));
			 //System.out.println("OperOverBookingHdr.jsp procedureDuration:" + procedureDuration + ":rowCount:" + rowCount);
			 %>
			 <script> 
				 //alert("procedureDuration ->" + '<%= procedureDuration %>');
				 var procedureDurationTemp = document.getElementById('procedureDuration'+'<%= rowCount %>').innerHTML + "," + '<%= procedureDuration %>';
				 //alert("procedureDurationTemp ->" + procedureDurationTemp);
				 assignDuplicateValues('<%=rowCount%>', '<%= procedureName %>', procedureDurationTemp); 
			 </script>
			 <%			 
		 }
		 else {			 
			 //rowCount ++;
			 //System.out.println("OperOverBookingHdr.jsp else");
			 patientId = rs.getString(1);		 
			 patientShortName = rs.getString(2);		 
			 surgeryType = rs.getString(3);
			 procedureName = rs.getString(4);
			 procedureDuration = rs.getString(5);
			 sourceType = rs.getString(6);
			 surgeonName = checkForNull(rs.getString(7));
			 sourceCode = checkForNull(rs.getString(8));
			 //Added on 7-11-12 by Muthu against 31719
			 overbookedYN = checkForNull(rs.getString(9));
			 bookingTime = checkForNull(rs.getString(10));			 
			 //out.println("bookingTime:" + bookingTime + ":overbookedYN:" + overbookedYN);//sanjay
				if(overbookedYN.equalsIgnoreCase("N")){					
					class_val =   "QRYEVEN";					
					}
				else{					
					class_val =   "EMERGENT";
					rowCountOverBooking++;
					//rowCount++;//commented by Sanjay 26-Dec-12
					}
				rowCount++;
			//Added on 7-11-12 by Muthu against 31719

			 if (patientShortName.length() > 25) {
				 patientShortName = patientShortName.substring(0,24)+"..";
				 //System.out.println("OperOverBookingHdr:" + patientShortName.length() + ":patientShortName:" + patientShortName);
			 }
			 if (surgeonName.length() == 0) {
				 surgeonName = "*ALL";
			 }
			 if (sourceType.equalsIgnoreCase("W") || sourceType.equalsIgnoreCase("N") ) {
				 pstmt1 = con.prepareStatement(sqlW);
				 pstmt1.setString(1,locale);
				 pstmt1.setString(2,strFacilityId);
				 pstmt1.setString(3,sourceCode);
		     }
			 else if (sourceType.equalsIgnoreCase("C")) { 
				 pstmt1 = con.prepareStatement(sqlC);
				 pstmt1.setString(1,locale);
			     pstmt1.setString(2,strFacilityId);
			     pstmt1.setString(3,sourceCode);			 
			 }
			 else if (sourceType.equalsIgnoreCase("E")) {
				 pstmt1 = con.prepareStatement(sqlE);
				 pstmt1.setString(1,locale);			 
				 pstmt1.setString(2,sourceCode);			 
			 }
			 rs1 = pstmt1.executeQuery();
			 while(rs1.next() && rs1!=null) {
				 location = checkForNull(rs1.getString(1));
			 } 
			 //if (Integer.parseInt(overbookcount) > 0 ) {//Sanjay
				 out.println("<tr>" );
				 out.println("<td id='"+"booking_date"+rowCount+"' class='"+class_val+"'value='"+booking_date+"'><font color=''>"+booking_date+"</td>");			 
				 //out.println("<td id='"+"procedureDuration"+rowCount+"'class='"+class_val+"'>"+procedureDuration+"</td>");
				 out.println("<td id='"+"procedureDuration"+rowCount+"'class='"+class_val+"'>"+procedureDuration+"&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Hrs.label","common_labels")+"</td>");
				 out.println("<td id='"+"patientId"+rowCount+"'class='"+class_val+"'><font color=''>"+patientId+"</td>");
				 out.println("<td id='"+"patientShortName"+rowCount+"'class='"+class_val+"'><font color=''>"+patientShortName+"</td>");
				 out.println("<td id='"+"procedureName"+rowCount+"'class='"+class_val+"'><font color=''>"+procedureName+"</td>");
				 out.println("<td id='"+"surgeonName"+rowCount+"'class='"+class_val+"'><font color=''>"+surgeonName+"</td>");
				 out.println("<td id='"+"surgeryType"+rowCount+"'class='"+class_val+"'><font color=''>"+surgeryType+"</td>");
				 out.println("<td id='"+"location"+rowCount+"'class='"+class_val+"'><font color=''>"+location+"</td>");
				 out.println("</tr>");			
			 //}//Sanjay
		 }

/* <fmt:message key="Common.Hrs.label" bundle="${common_labels}"
 "<fmt:message key=\"Common.Hrs.label\" bundle=\"${common_labels}\" "
out.println("<tr>" );
out.println("<td class='"+class_val+"'>"+booking_date+"</td>");
out.println("<td class='"+class_val+"'>"+procedureDuration+"</td>");
out.println("<td class='"+class_val+"'>"+patientId+"</td>");
out.println("<td class='"+class_val+"'>"+patientShortName+"</td>");
out.println("<td class='"+class_val+"'>"+procedureName+"</td>");
out.println("<td class='"+class_val+"'>"+surgeonName+"</td>");
out.println("<td class='"+class_val+"'>"+surgeryType+"</td>");
out.println("<td class='"+class_val+"'>"+location+"</td>");
out.println("</tr>");
*/
	}
	if(rs != null) rs.close();
	if(pstmt != null) pstmt.close();
	if(rs1 != null) rs1.close();
	if(pstmt1 != null) pstmt1.close();
	if(rs2 != null) rs2.close();
	if(pstmt2 != null) pstmt2.close();
	if(rs3 != null) rs3.close();
    if(pstmt3 != null) pstmt3.close();
	}
   catch(Exception ee){  
	   ee.printStackTrace();
	   System.err.println("Exception in OperationProcedureHdr.jsp "+ee);
	 }finally{
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
		if(rs1 != null) rs1.close();
		if(pstmt1 != null) pstmt1.close();
		if(rs2 != null) rs2.close();
	    if(pstmt2 != null) pstmt2.close();
		if(rs3 != null) rs3.close();
	    if(pstmt3 != null) pstmt3.close();
		   ConnectionManager.returnConnection(con, request);
	}
%>
</table>
<% 
		//if(strOrderId.length()>0){
			//out.println("<script language='javascript'>disableButton();</script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>");
		//}
%>

<input type='hidden' name='rowCount' id='rowCount' value="<%= rowCount %>">
<input type='hidden' name='rowCountOverBooking' id='rowCountOverBooking' value="<%= rowCountOverBooking %>">
<input type="hidden" name="strFacilityId" id="strFacilityId" value="<%= strFacilityId %>">
<input type="hidden" name="booking_date" id="booking_date" value="<%= booking_date %>">
<input type="hidden" name="roomCode" id="roomCode" value="<%= roomCode %>">
<input type="hidden" name="roomDesc" id="roomDesc" value="<%= roomDesc %>">
<input type="hidden" name="surgeonCode" id="surgeonCode" value="<%= surgeonCode1 %>">
<input type="hidden" name="surgeonName" id="surgeonName" value="<%= surgeonName1 %>">
<input type="hidden" name="speciality_code" id="speciality_code" value="<%= speciality_code %>">
<input type="hidden" name="speciality_desc" id="speciality_desc" value="<%= speciality_desc %>">
<input type="hidden" name="start_time" id="start_time" value="<%= start_time %>">
<input type="hidden" name="hidden_time" id="hidden_time" value="<%= hidden_time %>">
<input type="hidden" name="over_booking_case_yn" id="over_booking_case_yn" value="<%= over_booking_case_yn %>">
<input type="hidden" name="called_from" id="called_from" value="<%= called_from %>">
<input type="hidden" name="procedure" id="procedure" value="<%= procedure %>">
<input type="hidden" name="orderid" id="orderid" value="<%= orderid %>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>"> 
<input type='hidden' name='userOverBookYN' id='userOverBookYN' value="<%=userOverBookYN%>">
<input type='hidden' name='overbookcount' id='overbookcount' value="<%=overbookcount%>">
<input type='hidden' name='params' id='params' value="<%=request.getQueryString()%>">
</form>
<script>
refreshTotalCount();
</script>
</BODY>
</HTML>

