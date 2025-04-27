<!DOCTYPE html>
<%@ page import="java.sql.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<%
  request.setCharacterEncoding("UTF-8");
  String strEncounterId = request.getParameter("encounter_id");
//  String strTriageStartDate = request.getParameter("TriageStartDateTime");
 // String facility_id = request.getParameter("FacilityId");
  String facility_id 		= (String) session.getValue( "facility_id" ) ;
  java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
  String locale = (String) p.getProperty("LOCALE");
%>
<!--
	@Variable Declaration
-->
<%
	String  strClinic = "";
	String  strTreatmentArea = "";
	String strNurse = "";
	String strPhysician = "";
	String strStartDateTime = "";
	String strComplaint = "";
	String strDurationValue = "";
	String strDurationUnit = "";
	String strEndDateTime = "";
	String strPriorityDesc = "";
%>
<%
	//String qryTriageDetails = "SELECT TO_CHAR(TRIAGE_START_DATE_TIME,'dd/mm/yyyy hh24:mi') TRIAGE_START_DATE_TIME, CLINIC_CODE, CLINIC_DESC, TREATMENT_AREA_DESC, TREATMENT_AREA_CODE, NURSE_ID,NURSE_NAME, PHYSICIAN_ID, TRIAGE_COMPLAINT, DURATION_VALUE , DURATION_UNIT DURATION_UNIT, TO_CHAR(TRIAGE_END_DATE_TIME,'dd/mm/yyyy hh24:mi') TRIAGE_END_DATE_TIME,  PRIORITY_CODE,PRIORITY_DESC,PHYSICIAN_NAME FROM AE_PAT_TRIAGE_VW WHERE FACILITY_ID = ? AND ENCOUNTER_ID = ? ";
	//AND to_char(TRIAGE_START_DATE_TIME,'dd/mm/yyyy hh24:mi')= "+strTriageStartDate+" ";
	String qryTriageDetails = "SELECT TO_CHAR(TRIAGE_START_DATE_TIME,'dd/mm/yyyy hh24:mi') TRIAGE_START_DATE_TIME, CLINIC_CODE, OP_GET_DESC.OP_CLINIC(?,CLINIC_CODE,?,'1') CLINIC_DESC, AE_GET_DESC.AE_TMT_AREA_FOR_CLINIC(?,CLINIC_CODE,TREATMENT_AREA_CODE,?,'2') TREATMENT_AREA_DESC, TREATMENT_AREA_CODE, NURSE_ID,AM_GET_DESC.AM_PRACTITIONER(NURSE_ID,?,'1') NURSE_NAME, PHYSICIAN_ID, TRIAGE_COMPLAINT, DURATION_VALUE , DURATION_UNIT DURATION_UNIT, TO_CHAR(TRIAGE_END_DATE_TIME,'dd/mm/yyyy hh24:mi') TRIAGE_END_DATE_TIME,  PRIORITY_CODE,AE_GET_DESC.AE_PAT_PRIORITY(PRIORITY_CODE,?,'2') PRIORITY_DESC,AM_GET_DESC.AM_PRACTITIONER(PHYSICIAN_ID,?,'2') PHYSICIAN_NAME FROM AE_PAT_TRIAGE_VW WHERE FACILITY_ID = ? AND ENCOUNTER_ID = ?";
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
	conn = webbeans.eCommon.ConnectionManager.getConnection(request);
	pstmt = conn.prepareStatement(qryTriageDetails);
	pstmt.setString(1,facility_id);
	pstmt.setString(2,locale);
	pstmt.setString(3,facility_id);
	pstmt.setString(4,locale);
	pstmt.setString(5,locale);
	pstmt.setString(6,locale);
	pstmt.setString(7,locale);
	pstmt.setString(8,facility_id);
	pstmt.setString(9,strEncounterId);
	rs = pstmt.executeQuery();
%>
	<!--
	@Get All the Values From The Result Set And Store in the Variables
	-->
<%
	out.println("X");
	while(rs.next())
	{
  
		strClinic = rs.getString("CLINIC_DESC");
		if(strClinic==null)strClinic="";
		strTreatmentArea = rs.getString("TREATMENT_AREA_DESC");
		if(strTreatmentArea==null)strTreatmentArea="";
		strNurse =rs.getString("NURSE_NAME");
		if(strNurse ==null)strNurse="";
		strPhysician = rs.getString("PHYSICIAN_NAME");
		if(strPhysician==null)strPhysician="";
		strStartDateTime = rs.getString("TRIAGE_START_DATE_TIME");
		if(strStartDateTime==null)strStartDateTime="";

		strStartDateTime		= com.ehis.util.DateUtils.convertDate(strStartDateTime,"DMYHM","en",locale);
		strComplaint = rs.getString("TRIAGE_COMPLAINT");
		if(strComplaint==null)strComplaint="";
		strDurationValue =rs.getString("DURATION_VALUE");
		if(strDurationValue==null)strDurationValue="";
		strDurationUnit = rs.getString("DURATION_UNIT");

		if(strDurationUnit == null)
		{
			strDurationUnit = "";
		}
		if(strDurationUnit.equals("H"))
		{
			strDurationUnit = "Hrs";
		}
		else if(strDurationUnit.equals("D"))
		{
			strDurationUnit = "Days";
		}
		else if(strDurationUnit.equals("M"))
		{
			strDurationUnit = "Mins";
		}
		else if(strDurationUnit.equals("W"))
		{
			strDurationUnit = "Weeks";
		}
		if(strDurationUnit==null)strDurationUnit="";
		strEndDateTime = rs.getString("TRIAGE_END_DATE_TIME");
		if(strEndDateTime==null)strEndDateTime="";
		strEndDateTime		= com.ehis.util.DateUtils.convertDate(strEndDateTime,"DMYHM","en",locale);
		strPriorityDesc = rs.getString("PRIORITY_DESC");
		if(strPriorityDesc==null)strPriorityDesc="";
	}
%>
	<!--
	Close All the Connections and Result sets
	-->
	<%

		if(rs!=null)rs.close();
		if(pstmt != null)pstmt.close();
	}catch(Exception e)
	{
		//out.println(e);//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		
		if(conn != null)webbeans.eCommon.ConnectionManager.returnConnection(conn,request);
	}
	%>
<head>
  <%
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
  	<script language='javascript' src='../../eCommon/js/common.js'></script>
  <script language='javascript' src='../../eCommon/js/dchk.js'></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
  <script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



</head>
	 <body onSelect="codeArrestThruSelect()" onKeyDown ='lockKey()'  OnMouseDown='CodeArrest()'>
   <table border="0" cellpadding="3" cellspacing="0" align='center' width='95%'>
	 <tr>
		 <td class='columnheader'  colspan='4'><fmt:message key="Common.TriageDetails.label" bundle="${common_labels}"/></th>
     </tr>
     <tr>
			  <td class='LABEL'  width='25%'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
  		      <td class='QUERYDATA'  width='25%' >&nbsp;<%=strClinic%></td>
			  <td class='LABEL'  width='25%'><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/></td>
  		      <td class='QUERYDATA'   width='25%'> &nbsp;<%=strTreatmentArea%></td>	        
	 </tr>
	
	<tr>
  		      <td class='LABEL' width='25%'><fmt:message key="Common.nurse.label" bundle="${common_labels}"/></td>
			  <td class='QUERYDATA' width='25%'>&nbsp;<%=strNurse%></td>
			  <td class='LABEL' width='25%'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
			  <td class='QUERYDATA' width='25%'>&nbsp;<%=strPhysician%></td>
    </tr>
	
	<tr>	
		      <td class='LABEL'  width='25%'><fmt:message key="Common.startdatetime.label" bundle="${common_labels}"/></td>
		      <td class='QUERYDATA'  width='25%'>&nbsp;<%=strStartDateTime%></td>
    	      <td class='LABEL'   width='25%'><fmt:message key="Common.Complaint.label" bundle="${common_labels}"/></td>
			  <td class='QUERYDATA'  width='25%'>&nbsp;<%=strComplaint%></td>
	 </tr>

	<tr>	
		      <td class='LABEL' width='25%'><fmt:message key="Common.duration.label" bundle="${common_labels}"/></td>
  		      <td class='QUERYDATA' width='25%' >&nbsp;<%=strDurationValue%> &nbsp;<%=strDurationUnit%></td>			 
		      <td class='LABEL' width='25%'><fmt:message key="Common.enddatetime.label" bundle="${common_labels}"/></td>
  		      <td class='QUERYDATA' width='25%'>&nbsp;<%=strEndDateTime%></td>
    </tr>
	
	<tr>	
		      <td class='LABEL' width='25%'><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
  		      <td class='QUERYDATA' width='25%'>&nbsp;<%=strPriorityDesc%>  </td>
  		      <td class='LABEL'  width='25%'>&nbsp;</td>
			  <td class='LABEL'  width='25%'>&nbsp;</td>
	</tr>
   </table>
 </body>
</html>

