<!DOCTYPE html>
<%@page  import ="java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,webbeans.eCommon.*,eCommon.Common.*,eOT.*,eOT.Common.*" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<%@page  contentType="text/html;charset=UTF-8"%>

<HTML>
<head>
	<script type='javascript' src='../../eCommon/jscommon.js'></script>

<TITLE> <fmt:message key="eOT.WaitListDetails.Label" bundle="${ot_labels}"/></TITLE>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"/>
	<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
	<script type="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script type='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script type='javascript' src='../../eOT/js/Booking.js'></script>
	<script type="javascript" src="../../eOT/js/OTCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body >
<form name='PreOperHdr' id='PreOperHdr' method='POST' action='../../eOT/jsp/OperationProcedureHdr.jsp'>
<%@include file="../../eCommon/jsp/Common.jsp"%>
<% 

 request.setCharacterEncoding("UTF-8");
 String locale = (String)session.getAttribute("LOCALE"); 
 
String sql="";
String strWaitListNo="";
String strPreferredDate="";
String strPatientId="";
String strPatientName="";
String strSex="";
String strAge="";
String strEncounterId="";
String strRoomDesc="";
String strSurgeonName="";
String strFacilityId="";
String strSpecialityDesc="";

String male_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");

String female_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");

String unknown_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

////eOT.LogFile.log("OTDebugger","strSpecialityCode"+strSpecialityCode,this);


Connection conn = ConnectionManager.getConnection(request);
PreparedStatement pstmt = null;
ResultSet rs=null;

//sql=OTRepository.getOTKeyValue("SQL_OT_BOOKINGDTLS_SELECT1");

sql="SELECT WAITLIST_NUM WAITLIST_NUM1,to_char(PREFERRED_DATE,'dd/mm/yyyy') PREFERRED_DATE1,PATIENT_ID PATIENT_ID1,PATIENT_NAME PATIENT_NAME1,SEX SEX1, to_char(DATE_OF_BIRTH,'dd/mm/yyyy') DATE_OF_BIRTH1,ENCOUNTER_ID ENCOUNTER_ID1,THEATRE_DESC THEATRE_DESC1,SURGEON_NAME SURGEON_NAME1,SPECIALITY_DESC SPECIALITY_DESC1 FROM OT_WAITLIST_VW WHERE  LANGUAGE_ID=? AND  OPERATING_FACILITY_ID=? AND WAITLIST_NUM=?";


//booking_no  as for waitlist_no
strFacilityId=CommonBean.checkForNull(request.getParameter("facility_id"));
strWaitListNo=CommonBean.checkForNull(request.getParameter("waitlist_no"));


try
{
	pstmt=conn.prepareCall(sql);
	pstmt.setString(1,locale);
	pstmt.setString(2,strFacilityId);
	pstmt.setString(3,strWaitListNo);


	rs=pstmt.executeQuery();

if(rs.next())
{
if(strWaitListNo.length()==0)
 strWaitListNo=CommonBean.checkForNull(rs.getString("WAITLIST_NUM1"));

 strPreferredDate=CommonBean.checkForNull(rs.getString("PREFERRED_DATE1"));
 strPatientId=CommonBean.checkForNull(rs.getString("PATIENT_ID1"));
 strPatientName=CommonBean.checkForNull(rs.getString("PATIENT_NAME1"));
 strSex=CommonBean.checkForNull(rs.getString("SEX1"));
 strAge=CommonBean.checkForNull(rs.getString("DATE_OF_BIRTH1"));
 strEncounterId=CommonBean.checkForNull(rs.getString("ENCOUNTER_ID1")); 
 strRoomDesc=CommonBean.checkForNull(rs.getString("THEATRE_DESC1"));
 strSurgeonName=CommonBean.checkForNull(rs.getString("SURGEON_NAME1"));
 strSpecialityDesc=CommonBean.checkForNull(rs.getString("SPECIALITY_DESC1"));
 
}

rs.close();
pstmt.close();


if(strSex.equals("M")) strSex=male_title;
else
	 if(strSex.equals("F")) strSex=female_title;
else
	 strSex=unknown_title;
}
catch(Exception ee)
	{
		System.err.println("Exception"+ee);
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
	<fmt:message key="eOT.WaitListNO.Label" bundle="${ot_labels}"/>
</td>
<td  align='left'>
<input type='text' name='booking_no' id='booking_no' size='3'   value='<%=strWaitListNo%>' disabled>
</td>
<td class='label' align='right'  nowrap><fmt:message key="Common.PreferredDate.label" bundle="${common_labels}"/>  </td>
<td  align='left'>
<input type='text' name='booking_date' id='booking_date' size='10'   value='<%=strPreferredDate%>' disabled>
</td>
<td colspan='2' class='label'></td>
</tr>

<tr>

<td class='label' align='right'  nowrap>
	<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
</td>
<td align='left' class='label' >
<input type='text' name='patient_id' id='patient_id' size='20'  align='right'  value="<%=strPatientId%>" disabled>
</td>
<td class='label' align='right'nowrap>
	<fmt:message key="Common.name.label" bundle="${common_labels}"/>
</td>
<td align='left' colspan='3'>
<input type='text' name='patient_name' id='patient_name' size='60'  align='right' value='<%=strPatientName%>' disabled>
</td>
</tr>

<tr>
<td class='label' align='right'  nowrap><fmt:message key="Common.gender.label" bundle="${common_labels}"/></td>
<td align='left'>
<input type='text' name='sex' id='sex'  size='8'    value='<%=strSex%>' disabled>
</td>
<td class='label' align='right'  nowrap> DOB</td><td align='left'>
<input type='text' name='date_of_birth' id='date_of_birth' size='10'  align='right' value='<%=strAge%>' disabled>
</td>
<td class='label' align='right'  nowrap> <fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td><td align='left'>
<input type='text' name='encounter_id' id='encounter_id' size='10'  align='right' value='<%=strEncounterId%>' disabled>
</td>
</tr>


<tr>
<td class='label' align='right'  nowrap ><fmt:message key="Common.Theatre.label" bundle="${common_labels}"/>  </td>
<td align='left'>
<input type='text' name='waitlist_no' id='waitlist_no' size='15'  align='left' 
value="<%=strRoomDesc%>"
disabled >
</td>

<td class='label' align='right'  nowrap><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/> </td>
<td align='left'>
<input type='text' name='order_id' id='order_id' size='15'  align='left'
value="<%=strSurgeonName%>"
disabled>
</td>

<td class='label' align='right'  nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>  </td>
 <td align='left'>
<input type='text' name='SPECIALITY_DESC' id='SPECIALITY_DESC' size='15' 
value="<%=strSpecialityDesc%>" disabled>
</td>
</tr>

 <tr> <td colspan='6' class='label'></td></tr>
</table>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>

</BODY>
</HTML>

