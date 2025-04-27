<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
	<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

				
	</head>
<%

	request.setCharacterEncoding("UTF-8");
	Connection con			= null;
	PreparedStatement stmt1	= null;
	ResultSet rset1			= null;

	String facilityId = request.getParameter("facilityId")==null?"":request.getParameter("facilityId");
	if(facilityId.equals(""))
	facilityId		= (String)session.getValue("facility_id");

	String locale			= (String)session.getAttribute("LOCALE");

	String admission_date_time_display = "";
	String discharge_date_time_display = "";
	try
	{
		con						= ConnectionManager.getConnection(request);
		String patientId		= checkForNull(request.getParameter("patientId"));
		String filename			= checkForNull(request.getParameter("Filename"));
		String Patient_Class	= checkForNull(request.getParameter("Patient_Class"));
		String encounter_id		= checkForNull(request.getParameter("encounter_id"));
		String classValue		= "";
		String referral_id		= "";
		String referral_details	= "";
		String discharge_date_time	= "";
		String admission_date_time	= "";
		String sql = "";

		

		
		


		sql = "select sm_get_desc.sm_facility_param(facility_id,'"+locale+"','1') facility_name ,    to_char(discharge_date_time,'dd/mm/yyyy hh24:mi') discharge_date_time, to_char(visit_adm_date_time,'dd/mm/yyyy hh24:mi') visit_adm_date_time, DECODE(ASSIGN_CARE_LOCN_TYPE, 'N', IP_GET_DESC.IP_NURSING_UNIT(FACILITY_ID,ASSIGN_CARE_LOCN_CODE,'"+locale+"','2'), OP_GET_DESC.op_visit_type(facility_id,visit_adm_type,'"+locale+"','2')) visit_type_desc,AM_GET_DESC.AM_PRACTITIONER(attend_practitioner_id,'"+locale+"','1') practitioner_name, AM_GET_DESC.AM_SPECIALITY(specialty_code,'"+locale+"','2') specialty_desc,encounter_id, referral_id, AM_GET_DESC.AM_SERVICE(service_code,'"+locale+"','2') service_desc, episode_id from PR_ENCOUNTER_VW where  encounter_id = ? and patient_id = ? and facility_id = ?";	



		PreparedStatement stmt		= con.prepareStatement(sql);
		ResultSet rset		=null;	
		stmt.setString(1,encounter_id);
		stmt.setString(2,patientId);
		stmt.setString(3,facilityId);
		rset = stmt.executeQuery();

		while(rset.next())
		{
			String facility_name=rset.getString("FACILITY_NAME");
			if(facility_name == null || facility_name.equals("null")) facility_name="";
		
			


			admission_date_time=rset.getString("VISIT_ADM_DATE_TIME");
			if(admission_date_time == null || admission_date_time.equals("null"))
			{
				admission_date_time="";
				admission_date_time_display = "";
			}
			else
				admission_date_time_display = DateUtils.convertDate(admission_date_time,"DMYHM","en",locale);

			String practitioner_name=rset.getString("PRACTITIONER_NAME");
			if( practitioner_name == null || practitioner_name.equals("null"))
				practitioner_name="";
			
			String specialty_short_desc=rset.getString("SPECIALTY_DESC");
			if(specialty_short_desc == null || specialty_short_desc.equals("null"))
				specialty_short_desc="";
		
			String encounter_id1= rset.getString("ENCOUNTER_ID");
			if( encounter_id1 == null) encounter_id1="";

			String admission_type_short_desc = rset.getString("VISIT_TYPE_DESC");
			if( admission_type_short_desc == null) admission_type_short_desc="";

			if(Patient_Class.equals("IP"))
			{
				referral_id = rset.getString("REFERRAL_ID");
				if (referral_id==null) referral_id = "";
			}
			String service_short_desc = "";
			String episode_id = "";
			if(!Patient_Class.equals("IP"))
			{
				service_short_desc = rset.getString("SERVICE_DESC");
				if (service_short_desc==null) service_short_desc = "";
				
				episode_id = rset.getString("EPISODE_ID");
				if (episode_id==null) episode_id = "";
			}
	%>
<body onKeyDown='lockKey()'>
<FORM METHOD=POST ACTION="">
<table cellspacing=0 cellpadding=4 align='center' width='100%' border='0'>
	<tr>
		<td  colspan='4' class="COLUMNHEADER" ><fmt:message key="Common.encounterdetails.label" bundle="${common_labels}"/></td>
	</tr>
	<tr>
		<td class='label' width="25%"  ><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
		<td class='querydata' width="30%"  ><%=facility_name%></td>
		
		<td class='label' ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
		<td class='querydata' ><%=encounter_id1%></td>
	</tr>
	<tr>
		<td class='label' ><fmt:message key="Common.VisitDate.label" bundle="${common_labels}"/>/<fmt:message key="Common.time.label" bundle="${common_labels}"/></td>
		<td class='querydata'><%=admission_date_time_display%></td>
		<td class='label'  width="25%"  >&nbsp;</td>
		<td class='label'  width="25%"  >&nbsp;</td>
	</tr>
	
	<tr>
		<td class='label' ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
		<td class='querydata' ><%=specialty_short_desc%></td>
		<td class='label' ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
		<td class='querydata' ><%=practitioner_name%></td>
	</tr>
	
		<%	

			if(!referral_id.equals("")) 
			{
				sql = "select get_referral_detail_line( ? ,'FROM','"+locale+"') from dual";
				stmt = con.prepareStatement(sql);					
				stmt.setString(1,referral_id);
				rset = stmt.executeQuery();	
				while (rset.next())
				{
					referral_details = rset.getString(1);
					if(referral_details==null) referral_details = "";
				}

				%>
				<tr>
					<td  colspan='4' class='CAGROUPHEADING'><fmt:message key="Common.referraldetails.label" bundle="${common_labels}"/></td>
				</tr>
				<tr>
					<td class='label' colspan='4'><%=referral_details%></td>
				</tr>
		<%	}	%>
				</table>
<%		} 
		if(stmt!=null) stmt.close();
		if(rset!=null) rset.close();
			%>

			
	
	</FORM>
	</body>
	</html>

<%	}catch(Exception e) 
	{
		//out.println("ERR ---------- "+e.toString()); 
		e.printStackTrace();
	}
	finally
	{
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

