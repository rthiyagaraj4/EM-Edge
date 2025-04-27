<!DOCTYPE html>
<!--
	Module			:	eMR
	Function			:	MR Queries -> View Death Register
	Developed By 	:	Vinod Babu 
	Created On	 	:	12/05/2005
	Modified On		:	12/05/2005
-->

<html>
<!doctype html public "-//W3C//DTD HTML 4.0 Transitional//EN">
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import= "java.util.*,java.sql.*,java.text.*,com.ehis.util.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
String facilityId		= (String)session.getValue("facility_id");
String locale       =(String) session.getAttribute("LOCALE");
%>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eIP/js/dchk.js' language='javascript'></script> 
	
	<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
	<script src='../../eMR/js/CreatePatientFile.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	request.setCharacterEncoding("UTF-8");
Connection con	= null;
Statement stmt	= null;
ResultSet rset		= null;		
try
{
	con=ConnectionManager.getConnection(request);
	String visit_adm_date_time = "";
	String death_date_time	 = "";
	String visit_adm_date_time_display = "";
	String death_date_time_display	 = "";
	String admission_short_desc = ""; 
	String practitioner_name = "";
	String patient_id = "";
	String remarks = "";
	String sql = "";
	patient_id = request.getParameter("patient_id");
	String call_from = request.getParameter("call_from");
	if (call_from==null) call_from="";
	String Locntype = "" ;
	String Locn_Desc = "" ;
	String speciality_name	= "" ;
	String CA = request.getParameter("CA") ;
	if (CA.equals("")) CA="N";
	long encounterid = 0;

	sql = "SELECT a.encounter_id, c.short_desc	speciality_name, to_char(a.visit_adm_date_time,'dd/mm/rrrr hh24:MI') visit_adm_date_time ,to_char(b.death_date_time,'dd/mm/rrrr hh24:MI') death_date_time, DECODE (a.assign_care_locn_type, 'N', 'Nursing Unit', 'C', 'Clinic') location_type, (CASE WHEN a.assign_care_locn_type = 'N' THEN (SELECT short_desc FROM ip_nursing_unit WHERE facility_id = a.facility_id AND nursing_unit_code = a.assign_care_locn_code) ELSE (SELECT long_desc FROM op_clinic WHERE facility_id = a.facility_id AND clinic_code = a.assign_care_locn_code) END) location_desc, b.remarks, (CASE WHEN a.assign_care_locn_type = 'C' THEN (SELECT short_desc FROM op_visit_type WHERE facility_id = a.facility_id  AND visit_type_code = a.visit_adm_type) ELSE (SELECT short_desc FROM ip_admission_type WHERE admission_type_code = a.visit_adm_type) END ) admission_short_desc,(case when 	attend_practitioner_id is not null then (select practitioner_name from am_practitioner where practitioner_id = a.attend_practitioner_id) end ) practitioner_name FROM pr_encounter a, mr_death_register_hdr b, am_speciality c WHERE a.facility_id = '"+facilityId+"'	AND a.patient_id ='"+patient_id+"' AND a.specialty_code = c.speciality_code AND b.patient_id = a.patient_id AND a.facility_id = b.facility_id AND a.encounter_id = b.encounter_id AND deceased_date_time IS NOT NULL ";

	stmt = con.createStatement();
	rset = stmt.executeQuery(sql);
	if ( rset != null && rset.next() )
	{
		encounterid = (long)rset.getLong("encounter_id");
		speciality_name = rset.getString("speciality_name");
		Locntype = rset.getString("location_type");
		Locn_Desc = rset.getString("location_desc");
		visit_adm_date_time	= rset.getString("visit_adm_date_time") == null ? "" : rset.getString("visit_adm_date_time"); 
		death_date_time	= rset.getString("death_date_time") == null ? "" : rset.getString("death_date_time"); 
		admission_short_desc = rset.getString("admission_short_desc") == null ? "" : rset.getString("admission_short_desc"); 
		practitioner_name = rset.getString("practitioner_name") == null ?"" : rset.getString("practitioner_name");

		visit_adm_date_time_display = DateUtils.convertDate(visit_adm_date_time,"DMYHM","en",locale); 
		death_date_time_display = DateUtils.convertDate(death_date_time,"DMYHM","en",locale);

		remarks = rset.getString("remarks") == null ? "" :  rset.getString("remarks");
		if (rset!=null) 	rset.close();
		if (stmt!=null) 	stmt.close();
	%>
		<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
		<form name='ViewDeathRegister_form' id='ViewDeathRegister_form'   method="post" target="Dummy_frame" >
		<table border=0 cellpadding=0 cellspacing=0 width="100%">
		<tr><td>
	<%
		if (!CA.equals("Y")) 
		{
	%>
			<jsp:include page="../../eCommon/jsp/pline.jsp" ><jsp:param name="flush" value="true" />
				<jsp:param name='Facility_Id' value='<%=facilityId%>'/>
				<jsp:param name='EncounterId' value='<%=encounterid%>'/>
			</jsp:include>
		<%
		}
   %>
		</td></tr>
			</table>
			<table class=label border=0 cellpadding=2 cellspacing=0 width="100%">
			<tr>
				<th align=left colspan=8><fmt:message key="eMR.DeathRegistrationDetails.label" bundle="${mr_labels}"/>&nbsp;&nbsp;</th>
			</tr>	
			<tr>
				<td  class=label>&nbsp;</td>
				<td class=label align=right  nowrap><fmt:message key="Common.AdmissionDateTime.label" bundle="${common_labels}"/></td>
				<td align=left class='querydata'  nowrap><%=visit_adm_date_time_display%>
				<td class=label align=right  nowrap><fmt:message key="Common.admissiontype.label" bundle="${common_labels}"/> </td>
				<td align=left class='querydata' nowrap><%=admission_short_desc%>
				<td class=label >&nbsp;</td>
			</tr>
			<tr>
				<td class=label>&nbsp;</td>
				<td class=label align=right><fmt:message key="Common.deathdatetime.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<td align=left class='querydata'><%=death_date_time_display%>			
				<td class=label align=right><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<td align=left class='querydata'><%=practitioner_name%></td>
				<td class=label>&nbsp;</td>
			</tr>
			<tr>
				<td class=label>&nbsp</td>
				<td class=label align=right><fmt:message key="Common.Location.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<td align=left class='querydata'><%=Locntype%>/<%=Locn_Desc%> </td>
				<td class=label align=right><fmt:message key="Common.speciality.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<td align=left class='querydata'><%=speciality_name%></td>
				<td class=label >&nbsp</td>
			</tr>
			<tr>
				<td class=label >&nbsp;</td>
				<td class=label align=right><fmt:message key="Common.remarks.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<td align=left class='querydata' wrap colspan=4><%=remarks%></td>
			</tr>
			<%
			      if ( remarks.length() < 80 )	
					{
					
			%>	 <tr><td class=label colspan=6>&nbsp;</td></tr>
					 <tr><td class=label colspan=6>&nbsp;</td></tr>
					 <tr><td class=label colspan=6>&nbsp;</td></tr>
			<%	
				    } else
			      if ( remarks.length() < 160 )	
					{
			%>
					    <tr><td class=label colspan=6>&nbsp;</td></tr>
						<tr><td class=label colspan=6>&nbsp;</td></tr>
			<%	
		            }	
			else
					{
			   %>
					 <tr><td class=label colspan=6>&nbsp;</td></tr>
			 <%	
		            }	
			  %>
		</table>
	  </body>
	</html>
		<%
	}
	else
	{
		if (rset!=null) 	rset.close();
		if (stmt!=null) 	stmt.close();
		if (CA.equals("Y"))
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common')); document.location.href='../../eCommon/html/blank.html'</script>");
			if (CA.equals("Y"))
				out.println("<script>parent.frames[1].location.href='../../eCommon/html/blank.html'</script>");
			else
				out.println("<script>parent.frames[2].location.href='../../eCommon/html/blank.html'</script>");
		}
	}
}
catch(Exception e)
{
	//out.println(e);
	e.printStackTrace();
}
finally{
ConnectionManager.returnConnection(con,request);
}
%>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

