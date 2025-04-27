<!DOCTYPE html>
<!--/**
  @Author				:	Arun Gandhi
  @Created Date		:	27th November 2003
  @Purpose				:	To View The Event Dates
  */ -->
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<!--
     @Get The FacilityID and Encounter Id From AEEventQueryMain.jsp
-->
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	
    String strFacilityId     =  request.getParameter("Facility_Id");
	String strEncounterId =  request.getParameter("EncounterId");
	String strPatientId = request.getParameter("Patient_ID");
%>

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

<script>
 // For AE Result Function, when clicking the dates
 function callDate(start_date_time,encounter_id)
 {	
	parent.frames[2].location.href="../../eAE/jsp/ViewPatHistoryDetails.jsp?Patient_ID=<%=strPatientId%>&FacilityId=<%=strFacilityId%>&EncounterId="+encounter_id;
 }

  // For Triage Result Function, when clicking the dates
 function callDate1(start_date_time,encounter_id)
 {	
	parent.frames[2].location.href="../../eAE/jsp/AEEventTriageDetails.jsp?TriageStartDateTime='"+start_date_time+"'&FacilityId=<%=strFacilityId%>&EncounterId="+encounter_id;
 }
 
 // For Primary Assessment Function, when clicking the dates
 function callDate2(start_date_time,encounter_id)
 {	
	parent.frames[2].location.href="../../eAE/jsp/AEEventPrimaryAssessDetails.jsp?TriageStartDateTime="+start_date_time+"&FacilityId=<%=strFacilityId%>&EncounterId="+encounter_id;
 }

 // For Trauma Score Function, when clicking the dates
 function callDate3(start_date_time,encounter_id)
 {	
	parent.frames[2].location.href="../../eAE/jsp/AEEventTraumaScoreDetails.jsp?TraumaDate="+start_date_time+"&FacilityId=<%=strFacilityId%>&EncounterId="+encounter_id;
 }

  // For Trauma Assessment Function, when clicking the dates
 function callDate4(start_date_time,encounter_id)
 {	
	parent.frames[2].location.href="../../eAE/jsp/AEEventTraumaAssessDetails.jsp?TraumaDate="+start_date_time+"&FacilityId=<%=strFacilityId%>&EncounterId="+encounter_id;
 }
</script>
</head>

<!--
	@Queries To get the Dates Based on FacilityID,EncounterID
-->
<%
	String qryTriageDates = "SELECT TO_CHAR(TRIAGE_START_DATE_TIME,'dd/mm/yyyy hh24:mi') TRIAGE_START_DATE_TIME FROM AE_PAT_TRIAGE WHERE FACILITY_ID= '"+strFacilityId+"' AND  encounter_id =  '"+strEncounterId+"' ORDER BY TRIAGE_START_DATE_TIME DESC";
	
	String qryPrimaryAssessmentDates = "SELECT TO_CHAR(exam_date_time,'dd/mm/yyyy hh24:mi') exam_date_time FROM AE_TRAUMA_PRIMARY_SURVEY WHERE FACILITY_ID= '"+strFacilityId+"' AND  encounter_id = '"+strEncounterId+"' ORDER BY exam_date_time DESC ";
	
	String qryTaumaScoreDates = "SELECT TO_CHAR(exam_date_time,'dd/mm/yyyy hh24:mi')exam_date_time FROM AE_PAT_GCS_SCORE WHERE FACILITY_ID='"+strFacilityId+"'  AND  encounter_id='"+strEncounterId+"' ORDER BY exam_date_time DESC";
	
	String qryTraumaAssessmentDates= "SELECT TO_CHAR(exam_date_time,'dd/mm/yyyy hh24:mi') exam_date_time FROM AE_TRAUMA_SECONDARY_SURVEY WHERE FACILITY_ID='"+strFacilityId+"' AND  encounter_id= '"+strEncounterId+"' ORDER BY exam_date_time DESC";
%>
<!--
	@Get The Connection
	@Prepare The Statement and Execute The Queries
	@Declare the respective  Vector to store resultset values
-->
<%
	Connection conn = null;
	PreparedStatement pstmt=null;
	ResultSet rsTriage=null;
	ArrayList vecTriage = null;
	ResultSet rsPrimaryAssessment=null;
	ArrayList vecPrimaryAssessment = null;
	ResultSet rsTraumaScore=null;
	ArrayList vecTraumaScore = null;
	ResultSet rsTraumaAssessment=null;
	ArrayList vecTraumaAssessment = null;
	try{
		conn = webbeans.eCommon.ConnectionManager.getConnection(request);
		/**
		  @Using The Result Set Get The Values and Add into The Vector vecTriage
		*/
		pstmt = conn.prepareStatement(qryTriageDates);
		rsTriage = pstmt.executeQuery();
		if(rsTriage != null)
		{
			vecTriage = new ArrayList();
			while(rsTriage.next())
			{
				vecTriage.add(rsTriage.getString("TRIAGE_START_DATE_TIME"));
			}
		}
		if(rsTriage != null)rsTriage.close();
		if(pstmt!=null)pstmt.close();
		/**
		  @Using The Result Set Get The Values and Add into The Vector vecPrimaryAssessment
		*/
		pstmt = conn.prepareStatement(qryPrimaryAssessmentDates);
		rsPrimaryAssessment = pstmt.executeQuery();
		if(rsPrimaryAssessment != null)
		{
			vecPrimaryAssessment = new ArrayList();
			while(rsPrimaryAssessment.next())
			{
				vecPrimaryAssessment.add(rsPrimaryAssessment.getString("exam_date_time"));
			}
		}
	    if(rsPrimaryAssessment != null)rsPrimaryAssessment.close();
		if(pstmt!=null)pstmt.close(); 
		/**
		  @Using The Result Set Get The Values and Add into The Vector vecTraumaScore
		*/
		pstmt = conn.prepareStatement(qryTaumaScoreDates);
		rsTraumaScore = pstmt.executeQuery();
		if(rsTraumaScore != null)
		{
			vecTraumaScore = new ArrayList();
			while(rsTraumaScore.next())
			{
				vecTraumaScore.add(rsTraumaScore.getString("exam_date_time"));
			}
		}
        if(rsTraumaScore != null)rsTraumaScore.close();
		if(pstmt!=null)pstmt.close(); 
		/**
		  @Using The Result Set Get The Values and Add into The Vector vecTraumaAssessment
		*/
		pstmt = conn.prepareStatement(qryTraumaAssessmentDates);
		rsTraumaAssessment = pstmt.executeQuery();
		if(rsTraumaAssessment != null)
		{
			vecTraumaAssessment =new ArrayList();
			while(rsTraumaAssessment.next())
			{
				vecTraumaAssessment.add(rsTraumaAssessment.getString("exam_date_time"));
			}
		}
        if(rsTraumaAssessment != null)rsTraumaAssessment.close();
		if(pstmt!=null)pstmt.close(); 
	}catch(Exception exec)
	{ 
		exec.printStackTrace();
	}
	finally
	{
		if(rsTriage != null)rsTriage.close();
		if(rsPrimaryAssessment != null)rsPrimaryAssessment.close();
		if(rsTraumaScore != null)rsTraumaScore.close();
		if(rsTraumaAssessment != null)rsTraumaAssessment.close();
		if(pstmt!=null)pstmt.close();
		if(conn != null)webbeans.eCommon.ConnectionManager.returnConnection(conn,request);
	}
%>
<html>
	<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
			<tr><b><a href="javascript:callDate('','<%=strEncounterId%>')">A & E Details</a></b></tr>
		</table>
		<table border="0" width="100%" cellspacing='0' cellpadding='0'>
			<tr><th><fmt:message key="eAE.Triage.label" bundle="${ae_labels}"/></th></tr>
<%
	if(vecTriage != null)
	{
		for(int i=0;i<vecTriage.size();i++)
		{
%>
		<tr><td><a href="javascript:callDate1('<%=(String)vecTriage.get(i)%>',<%=strEncounterId%>)"> <%=(String)vecTriage.get(i)%></a></td></tr>
<%
		}
        vecTriage.clear();
		vecTriage = null;
	}
%>		
			<tr><th><fmt:message key="eAE.PrimaryAssessment.label" bundle="${ae_labels}"/></th></tr>
<%
	if(vecPrimaryAssessment != null)
	{
		for(int i=0;i<vecPrimaryAssessment.size();i++)
		{
%>
			<tr><td><a href="javascript:callDate2('<%=(String)vecPrimaryAssessment.get(i)%>',<%=strEncounterId%>)"><%=(String)vecPrimaryAssessment.get(i)%></a></td></tr>
<%
		}
			vecPrimaryAssessment.clear();
		vecPrimaryAssessment=null;
	}
%>
		
			<tr><th><fmt:message key="eAE.TraumaScore.label" bundle="${ae_labels}"/></th></tr>
<%
	if(vecTraumaScore != null)
	{
		for(int i=0;i<vecTraumaScore.size();i++)
		{
%>
			<tr><td><a href="javascript:callDate3('<%=(String)vecTraumaScore.get(i)%>',<%=strEncounterId%>)"><%=(String)vecTraumaScore.get(i)%></a></td></tr>
<%
		}
			vecTraumaScore.clear();
		vecTraumaScore = null;
	}
%>
			
			<tr><th><fmt:message key="eAE.TraumaAssessment.label" bundle="${ae_labels}"/></th></tr>
<%
	if(vecTraumaAssessment != null)
	{
		int j= vecTraumaAssessment.size();
		for(int i=0;i<j;i++)
		{
%>
			<tr><td><a href="javascript:callDate4('<%=(String)vecTraumaAssessment.get(i)%>',<%=strEncounterId%>)"><%=(String)vecTraumaAssessment.get(i)%></a></td></tr>
<%
		}
			vecTraumaAssessment.clear();
		vecTraumaAssessment = null;
	}
%>
	</table>
	</body>
</html>

