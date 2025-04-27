<!DOCTYPE html>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<%
  request.setCharacterEncoding("UTF-8");
  String strEncounterId = request.getParameter("EncounterId");
  String strTriageStartDate = request.getParameter("TriageStartDateTime");
  String facility_id = request.getParameter("FacilityId");

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

	String qryTriageDetails = "SELECT TO_CHAR(TRIAGE_START_DATE_TIME,'dd/mm/yyyy hh24:mi') TRIAGE_START_DATE_TIME, CLINIC_CODE, CLINIC_DESC, TREATMENT_AREA_DESC, TREATMENT_AREA_CODE, NURSE_ID,NURSE_NAME, PHYSICIAN_ID, TRIAGE_COMPLAINT, TO_CHAR(TRIAGE_END_DATE_TIME,'dd/mm/yyyy hh24:mi') TRIAGE_END_DATE_TIME,  PRIORITY_CODE,PRIORITY_DESC,PHYSICIAN_NAME FROM AE_PAT_TRIAGE_VW WHERE FACILITY_ID = '"+facility_id+"' AND ENCOUNTER_ID = '"+strEncounterId+"' AND to_char(TRIAGE_START_DATE_TIME,'dd/mm/yyyy hh24:mi')= "+strTriageStartDate+" ";

	Connection conn = null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
try{
	conn = webbeans.eCommon.ConnectionManager.getConnection(request);
	pstmt = conn.prepareStatement(qryTriageDetails);
	rs = pstmt.executeQuery();
 
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
		strComplaint = rs.getString("TRIAGE_COMPLAINT");
		if(strComplaint==null)strComplaint="";
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
		strPriorityDesc = rs.getString("PRIORITY_DESC");
		if(strPriorityDesc==null)strPriorityDesc="";
	}
      if(rs!=null)rs.close();
	  if(pstmt != null)pstmt.close();
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		if(rs!=null)rs.close();
		if(pstmt != null)pstmt.close();
		if(conn != null)webbeans.eCommon.ConnectionManager.returnConnection(conn,request);
	}
	%>
<head>
  <!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
  <%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
  	<script language='javascript' src='../../eCommon/js/common.js'></script>
  <script language='javascript' src='../../eCommon/js/dchk.js'></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
  <script language='javascript' src='../../eCommon/js/FieldFormatMethods.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
	 <body onSelect="codeArrestThruSelect()"  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
   <table border="0" cellpadding="0" cellspacing="0" align='left' width='95%'>
	 <tr>
		 <th align='left' colspan='6'><fmt:message key="Common.TriageDetails.label" bundle="${common_labels}"/></th>
     </tr>
     <tr>
			  <td class='LABEL'  nowrap align='right'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
  		      <td class='QUERYDATA' >&nbsp;<%=strClinic%></td>
			  <td class='LABEL' nowrap align='right'><fmt:message key="Common.treatmentarea.label" bundle="${common_labels}"/></td>
  		      <td class='QUERYDATA'  colspan='3'> &nbsp;<%=strTreatmentArea%></td>	        
	 </tr>
	<tr> 
		 <td align='left' colspan='6'>&nbsp;</td>
    </tr>
	<tr>
  		      <td class='LABEL' align='right'><fmt:message key="Common.nurse.label" bundle="${common_labels}"/></td>
			  <td class='QUERYDATA'>&nbsp;<%=strNurse%></td>
			  <td class='LABEL' >&nbsp;</td>
  		      <td class='LABEL' colspan='3'>&nbsp;</td>
	</tr>
<tr> 
		 <td align='left' colspan='6'>&nbsp;</td>
    </tr>
	<tr> 
		  <td class='LABEL' align='right'><fmt:message key="eAE.Physician.label" bundle="${ae_labels}"/></td>
		  <td class='QUERYDATA' colspan="5">&nbsp;<%=strPhysician%></td>
	</tr>
	<tr> 
		 <td align='left' colspan='6'>&nbsp;</td>
    </tr>
	<tr>	
		      <td class='LABEL' align='right'><fmt:message key="Common.startdatetime.label" bundle="${common_labels}"/></td>
		      <td class='QUERYDATA'  colspan='5'>&nbsp;<%=strStartDateTime%></td>
     </tr>
	<tr> 
		 <td align='left' colspan='6'>&nbsp;</td>
    </tr>
    <tr>
  		      <td class='LABEL'  align='right'><fmt:message key="Common.Complaint.label" bundle="${common_labels}"/></td>
			  <td class='QUERYDATA'  colspan='5' nowrap>&nbsp;<%=strComplaint%>
              </td>
	 </tr>
	<tr> 
		 <td align='left' colspan='6'>&nbsp;</td>
    </tr>
	<tr>	
		      <td class='LABEL' align='right'><fmt:message key="Common.duration.label" bundle="${common_labels}"/></td>
  		      <td class='QUERYDATA' >&nbsp;<%=strDurationValue%> &nbsp;<%=strDurationUnit%></td>			 
			   <td class='QUERYDATA'  colspan='4'>&nbsp;</td>
	 </tr>
	<tr> 
		 <td align='left' colspan='6'>&nbsp;</td>
    </tr>
	<tr>	
		      <td class='LABEL' align='right'><fmt:message key="Common.enddatetime.label" bundle="${common_labels}"/></td>
  		     <td class='QUERYDATA' colspan='5'>&nbsp;<%=strEndDateTime%></td>
    </tr>
	<tr> 
		 <td align='left' colspan='6'>&nbsp;</td>
    </tr>
	<tr>	
		      <td class='LABEL' align='right'><fmt:message key="Common.priority.label" bundle="${common_labels}"/></td>
  		      <td class='QUERYDATA'>&nbsp;<%=strPriorityDesc%>  </td>
  		      <td class='LABEL'  colspan='4'>&nbsp;</td>
	</tr>
	<tr>
		<td class='LABEL' colspan='6'>&nbsp</td>
	</tr>
	<tr>
		<td class='LABEL' colspan='6'>&nbsp</td>
	</tr>
   </table>
 </body>
</html>

