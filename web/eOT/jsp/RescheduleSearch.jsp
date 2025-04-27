<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import = "eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends 
%>

<%@page  import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.Common.OTRepository"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eCommon/jsp/Common.jsp" %>

<html>
<head>
<title>
<fmt:message key="Common.PendingOrders.label" bundle="${common_labels}"/>
</title>

<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }

%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
	<script type='text/javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script type='text/javascript' src='../../eCommon/js/common.js'></script>
	<script language="javascript" src="../../eOT/js/Booking.js" ></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>
<script language="javascript">
function funResetAll(){
	var frmObj=document.forms[0];
	frmObj.theatre_date.value="";
	frmObj.SPECIALITY_DESC.value="";
    frmObj.SURGEON.value="";
	frmObj.SURGEON_CODE.value="";
	frmObj.patientid.value="";//MO-CRF-20082
	frmObj.patient_name.value="";//MO-CRF-20082
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="ReScheduleForm" id="ReScheduleForm" method='post'>
<%
String facilityid=(String)session.getValue("facility_id");
String function_id=request.getParameter("function_id");
String strSysDate="";

String sql="";
Connection conn=null;
PreparedStatement pstmt=null;
ResultSet rs=null;
//MO-IN:052629
PreparedStatement pstmt1=null;
ResultSet rs1=null;
String PatIDLen="";
//MO-IN:052629

	conn=ConnectionManager.getConnection(request);

try
{
//MO-IN:052629
			pstmt1=conn.prepareCall("SELECT PATIENT_ID_LENGTH from MP_PARAM");
			rs1=pstmt1.executeQuery();

			if(rs1!=null &&rs1.next()==true)
			{
				 PatIDLen   = (rs1.getString("PATIENT_ID_LENGTH")==null)?"0":rs1.getString("PATIENT_ID_LENGTH");				
			}
			if(rs1!=null)		rs1.close();
			if(pstmt1 !=null) pstmt1.close();
//MO-IN:052629

sql=""+OTRepository.getOTKeyValue("SQL_OT_DIARY_DATE_SELECT1");
pstmt=conn.prepareCall(sql);
	rs=pstmt.executeQuery();

	if(rs.next())
	{
	    
		//Buddhist date conversion (Thai Locale)
		//strSysDate=rs.getString("dat2");
		strSysDate=com.ehis.util.DateUtils.convertDate(rs.getString("dat2"),"DMY","en",locale);
		
	}

	rs.close();
	pstmt.close();

}
catch(Exception ee) 
{
}
finally
{
if(rs!=null) rs.close();
if(pstmt!=null) pstmt.close();
ConnectionManager.returnConnection(conn, request);
}

%>

<table cellpadding=3  cellspacing="0" border="0" width="100%" align="center">

<tr>
	<td class='label' width='25%'>
		<fmt:message key="eOT.TheatreDate.Label" bundle="${ot_labels}"/>
	</td>
	<td class='fields' width='25%'>
		<input type='text' class='fields' name='theatre_date' id='theatre_date' size='11'   value='<%=strSysDate%>'  maxlength='10'
		Onblur="javascript:isValidDate(this);">
		<img src="../../eCommon/images/CommonCalendar.gif"	
		onClick="return showCalendar('theatre_date','dd/mm/y');">
		<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
	<td class='label' width='25%'> 
	<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' width='25%'>
		<input type='text' class='fields' name='SPECIALITY_DESC' id='SPECIALITY_DESC' maxlength='20' size='20' value= "" onBlur="if(this.value!='')return searchSpeciality(SPECIALITY_DESC); else SPECIALITY_CODE.value='' ">
		<input type='button' class='button' value='?' name='surButton' id='surButton' onClick="return searchSpeciality(SPECIALITY_DESC);">
	</td>
</tr>
<tr>
	<td class='label' width='25%'>
		<fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' width='25%'>
		<input type='text' class='fields' name='SURGEON' id='SURGEON' maxlength='20' size='20' value= "" onBlur="if(this.value!='')return searchSurgeon(SURGEON); else SURGEON_CODE.value='' ">
		<input type='button' class='button' value='?' name='surButton' id='surButton' onClick="return searchSurgeon(SURGEON);">
	</td>
	<td class='label' width='25%'>
		<fmt:message key="Common.OrderingDoctor.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' width='25%'>
		<input type='hidden' class='fields' name='ordering_doctor_code' id='ordering_doctor_code' value= "">
		
		<input type='text' class='fields' name='ordering_doctor_desc' id='ordering_doctor_desc'  maxlength='20' size='20' value= "" onBlur="if(this.value!='')return searchOrderingSurgeon(ordering_doctor_code,ordering_doctor_desc);else ordering_doctor_code.value='' "	>

		<input type='button' class='button' value='?' name='ordsurButton' id='ordsurButton' onClick="return  searchOrderingSurgeon(ordering_doctor_code,ordering_doctor_desc);">
	</td>
</tr>
<!-- MO-CRF-20082 START-->
<tr>
		<td class='label' width='25%' ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
		<td class="fields" width="25%" >   
		<!--MO-IN:052629-->
			<input type='text' name='patientid' id='patientid' maxlength='<%=PatIDLen%>' size='<%=PatIDLen%>' onkeypress="return CheckForSpecChars(event)" onBlur="if(this.value!='')callPatientSearch();else clearPatientName();" value= "" >
			<input type='button' class='button' value='?' name='surButton' id='surButton' onClick="callPatientSearch();">
		</td>
	</td>
			<td class='label' width="25%" >
			<fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>     
		</td>
		<td class='fields' width="25%" >
			<input type='text' name='patient_name' id='patient_name' maxlength='100' size='30' value= "" readOnly><!--IN:053032-->
	</td>
	
</tr>
<!--MO-CRF-20082 END-->
<tr>
	
	<td class='button' width='25%' colspan="4" align='right'>
		<input type="button" class='button' name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="funRescheduleSearch()">
		<input type="button" class='button' name="clear" id="clear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onClick="funResetAll()">
	</td>
</tr>

</table>
   <!-- added by Rajesh for Amazon Changes-->
				<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
	<!-- end -->


<input type='hidden' class='fields' name='facility_id' id='facility_id' value='<%=facilityid%>'>
<input type='hidden' class='fields' name='SPECIALITY_CODE' id='SPECIALITY_CODE' value=''>
<input type='hidden' class='fields' name='SURGEON_CODE' id='SURGEON_CODE' value=''>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
<input type='hidden' name='function_id' id='function_id' value="<%=function_id%>">
</form>
</body>
</html>

