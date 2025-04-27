<!DOCTYPE html>
<%@page  import ="java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,webbeans.eCommon.*,eCommon.Common.*,eOT.*,eOT.Common.*" %>
<%@page  contentType="text/html; charset=UTF-8"%>
<%@include file="../../eOT/jsp/StringUtil.jsp"%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% 	request.setCharacterEncoding("UTF-8"); %>

<HTML>
<head>
	<script type='text/javascript' src='../../eCommon/js/common.js'></script>
<TITLE> <fmt:message key="eOT.WaitListWindow.Label" bundle="${ot_labels}"/></TITLE>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"/>
	<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script type='text/javascript' src='../../eOT/js/Booking.js'></script>
	<script type="text/javascript" src="../../eOT/js/OTCommon.js"></script>
<script>
	var waitList_value=getLabel("Common.WaitList.label","common");
</script>
<script language='javascript'>
 function OnWinClosing() 
 {
	 
	  	 parent.window.returnValue="0";	
	 parent.window.close();
 }
 function OnWinOK()
 {
var frmObj=document.forms[0];
	 parent.window.returnValue=frmObj.speciality_code.value;
	 parent.window.close();

 }
 </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body >
<form name='WaitListHdr' id='WaitListHdr' method='POST' action='../../eOT/jsp/WaitListDetail.jsp'>
<%@include file="../../eCommon/jsp/Common.jsp"%>
<% 


String sql="";

String strWaitListNum="";
String strBookingNum="";
//String strPreferredDate="";
String strPatientId="";
String strPatientName="";
//String strSurgeonCode="";
String strSurgeonName="";
String strSurgeryType="";
String strBookingDate="";
//String strNatureType="";
//String strNatureCode="";
String strSpecialityCode="";
String strFacilityId="";
String strDuration="";
String strBookingNo="";
String strBookingDate1="";





sql=CommonBean.checkForNull(request.getParameter("sql"));




strWaitListNum=CommonBean.checkForNull(request.getParameter("waitlist_no"));
strFacilityId=CommonBean.checkForNull(request.getParameter("facility_id"));
strDuration=CommonBean.checkForNull(request.getParameter("booking_duration"));
strBookingNo=CommonBean.checkForNull(request.getParameter("booking_no"));
//strBookingDate=CommonBean.checkForNull(request.getParameter("booking_date"));
strBookingDate1=CommonBean.checkForNull(request.getParameter("booking_date"));

//eOT.LogFile.log("OTDebugger","strBookingNo"+strBookingNo,this);
//eOT.LogFile.log("OTDebugger","strBookingDate"+strBookingDate,this);


Connection conn = ConnectionManager.getConnection(request);
PreparedStatement pstmt = null;
ResultSet rs=null;

//sql=OTRepository.getOTKeyValue("SQL_OT_WAITLISTDTLS_SELECT1");

sql="SELECT WAITLIST_NUM WAITLIST_NUM1, BOOKING_NUM BOOKING_NUM1, to_char(BOOKING_DATE,'dd/mm/yyyy') BOOKING_DATE1,PREFERRED_DATE PREFERRED_DATE1,PATIENT_ID PATIENT_ID1, PATIENT_NAME PATIENT_NAME1,SURGEON_CODE SURGEON_CODE1, SURGEON_NAME SURGEON_NAME1,NATURE_TYPE NATURE_TYPE1, NATURE_CODE NATURE_CODE1, SURGERY_TYPE SURGERY_TYPE1,SPECIALITY_CODE SPECIALITY_CODE1  FROM OT_WAITLIST_VW WHERE LANGUAGE_ID=? AND WAITLIST_NUM = ? ";

try
{
pstmt=conn.prepareCall(sql);
pstmt.setString(1,locale);
pstmt.setString(2,strWaitListNum);
//eOT.LogFile.log("OTDebugger","strWaitListNum"+strWaitListNum,this);
//eOT.LogFile.log("OTDebugger","sql"+sql,this);


	rs=pstmt.executeQuery();

if(rs.next())
{
 strBookingNum=CommonBean.checkForNull(rs.getString("BOOKING_NUM1"));
 strBookingDate=CommonBean.checkForNull(rs.getString("BOOKING_DATE1"));
// strPreferredDate=CommonBean.checkForNull(rs.getString("PREFERRED_DATE1"));
 strPatientId=CommonBean.checkForNull(rs.getString("PATIENT_ID1"));
 strPatientName=CommonBean.checkForNull(rs.getString("PATIENT_NAME1"));
// strSurgeonCode=CommonBean.checkForNull(rs.getString("SURGEON_CODE1"));
 strSurgeonName=CommonBean.checkForNull(rs.getString("SURGEON_NAME1"));
// strNatureType=CommonBean.checkForNull(rs.getString("NATURE_TYPE1"));
// strNatureCode=CommonBean.checkForNull(rs.getString("NATURE_CODE1"));
 strSurgeryType=CommonBean.checkForNull(rs.getString("SURGERY_TYPE1"));
 strSpecialityCode=CommonBean.checkForNull(rs.getString("SPECIALITY_CODE1"));
}

rs.close();
pstmt.close();
}
catch(Exception ee)
	{
		//eOT.LogFile.log("OTDebugger","Exception"+ee,this);
	}
	finally
	{
		try{
		if(rs!=null) rs.close();
		pstmt.close();
		ConnectionManager.returnConnection(conn,request);
		}catch(Exception ee){}
	}

%>



<table border='0' cellpadding='3' cellspacing='0' width='100%'>

<tr>
<td class='label' align='right'  nowrap>
	<fmt:message key="Common.waitlistno.label" bundle="${common_labels}"/>
</td>
<td  align='left'>
<input type='text' name='waitlist_no' id='waitlist_no' value='<%=strWaitListNum%>' onBlur="if(this.value!='')funOTCheckDetail1('Waitlist',waitList_value,'<%=locale%>')">
<input type='button' class='button' name='quest1' id='quest1' value='?' onClick="funOTCheckDetail1('Waitlist',waitList_value,'<%=locale%>')">
</td>
<td class='label' align='right'  nowrap>
	<fmt:message key="Common.SurgeryType.label" bundle="${common_labels}"/>
</td>
<td  align='left'>
<input type='text' name='surgery_type' id='surgery_type' size='10'   value='<%=strSurgeryType%>' disabled>
</td>
</tr>


<tr>
<td class='label' align='right'  nowrap>
	<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
</td>
<td align='left' class='label' colspan='3'>
<input type='text' name='patient_id' id='patient_id' size='20'  align='right'  value="<%=strPatientId%>" disabled>
<input type='text' name='patient_name' id='patient_name' size='60'  align='right' value='<%=strPatientName%>' disabled>
</td>
</tr>

<tr>
<td class='label' align='right'  nowrap>
	<fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/>
</td>
<td align='left'>
<input type='text' name='sex' id='sex'  size='8'    value='<%=strSurgeonName%>' disabled>
</td>
<td class='label' align='right'  nowrap>
	<fmt:message key="Common.ScheduledDate.label" bundle="${common_labels}"/></td><td align='left'>
	<input type='text' name='scheduled_date' id='scheduled_date' size='10'  align='right' value='<%=strBookingDate%>' disabled>
</td>
</tr>


<tr>
<td class='label' align='right'  nowrap >
	<fmt:message key="eOT.BookingNO.Label" bundle="${ot_labels}"/>
</td>
<td align='left'>
<input type='text' name='booking_num' id='booking_num' size='15'  align='left' 
value="<%=strBookingNum%>" disabled >
</td>
<td class='label' colspan='2'>
</td>
</tr>

<tr>
<td  colspan='4' align='right'>
<input class='button' type='button' name='ok' id='ok' value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick="OnWinOK()">
<input class='button' type='button' name='cancel' id='cancel' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick="OnWinClosing()">
</td>
</tr>


</table>
<!-- <input type='hidden' name='booking_no1' id='booking_no1' value="<%=strBookingNo%>"> -->
<input type='hidden' name='booking_no' id='booking_no' value="<%=strBookingNo%>">
<input type='hidden' name='speciality_code' id='speciality_code' value="<%=strSpecialityCode%>">
<input type='hidden' name='facility_id' id='facility_id' value="<%=strFacilityId%>">
<input type='hidden' name='booking_duration' id='booking_duration' value="<%=strDuration%>">
<!-- <input type='hidden' name='booking_date1' id='booking_date1' value="<%=strBookingDate%>"> -->
<input type='hidden' name='booking_date' id='booking_date' value="<%=strBookingDate1%>">
<input type='hidden' name='waitlist_nm' id='waitlist_nm' value="<%=strWaitListNum%>">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</BODY>
</HTML>

