<!DOCTYPE html>
<!--/**
  @Author				:	Arun Gandhi
  @Created Date		:	27th November 2003
  @Purpose				:	
  */ -->
<%@ page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
	<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css'     href='../../eCommon/html/CommonCalendar.css'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
  <script language='javascript' src='../../eCommon/js/dchk.js'></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
  <script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<!--
	@Variable Declaration
-->
<%
String strVisitDateTime = null;
String strLocation        = null;
String strPractitioner    = null;
%>
<!--
     @Get The FacilityID and Encounter Id From AEEventQueryMain.jsp
-->
<%
	String strEncounterId =  request.getParameter("EncounterId");
%>
<!--
   @Query For getting the 
   @Encounter Details  
-->
<%
	String qryEncounterDetails = "SELECT to_char(VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') VISIT_ADM_DATE_TIME, Facility_name, Clinic_name, Practitioner_Name FROM pr_encounter_vw where Encounter_Id='"+strEncounterId+"'" ; 

%>
<!--
	@Get The Connection
	@Prepare The Statement and Execute The Query
-->
<%
	Connection conn = null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
try{
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
	conn = webbeans.eCommon.ConnectionManager.getConnection(request);
	pstmt = conn.prepareStatement(qryEncounterDetails);
	rs = pstmt.executeQuery();

	while(rs.next())
	{
		strVisitDateTime = rs.getString("Visit_adm_date_time");
		strLocation        = rs.getString("Clinic_name");
		strPractitioner    = rs.getString("Practitioner_Name");
	}
	if(rs!=null)rs.close();
	if(pstmt != null)pstmt.close();

	}catch(Exception exc)
	{
		exc.printStackTrace();
	}
	finally
	{
		if(rs!=null)rs.close();
		if(pstmt != null)pstmt.close();
		if(conn != null)webbeans.eCommon.ConnectionManager.returnConnection(conn,request);
	}
%>
	<body onSelect="codeArrestThruSelect()"  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
				<tr><th align='left'><fmt:message key="Common.encounterdetails.label" bundle="${common_labels}"/></th></tr>
		</table>
		<table border="0" width="100%" cellspacing='0' cellpadding='0'>
			<tr>
				
				<td class='LABEL' align='right'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
				<td class='LABEL' >&nbsp</td>
				<td class='QUERYDATA'><%=strEncounterId%></td>
				<td class='LABEL' align='right'><fmt:message key="eAE.VisitDateTime.label" bundle="${ae_labels}"/> </td>
				<td class='LABEL' >&nbsp</td>
				<td class='QUERYDATA'><%=strVisitDateTime%></td>
			</tr>
			<tr>
				<td class='LABEL' align='right'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
				<td class='LABEL' >&nbsp</td>
				<td class='QUERYDATA'><%=strLocation%></td>
				<td class='LABEL' align='right'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
				<td class='LABEL' >&nbsp</td>
				<td class='QUERYDATA'><%=strPractitioner%></td>
			</tr>
			
		</table>
	</body>
</html>

