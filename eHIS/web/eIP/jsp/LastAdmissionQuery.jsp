<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page   contentType="text/html;charset=UTF-8"  import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
	<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'>
	<!-- <link rel='stylesheet' type='text/css' href='../html/text.css'></link> -->
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
<script>
	var facility_name;
	var admission_date_time;
	var  practitioner_name; 
	var  specialty_short_desc;
	var  encounter_id;
	
	function displayResult(encounter_id,patientId,facilityId)
	{
	parent.frames[1].location.href="../jsp/LastAdmissionResult.jsp?encounter_id="+encounter_id+"&patientId="+patientId+"&facility_id="+facilityId;
	}
	</script>
	
	</head>
<%
	request.setCharacterEncoding("UTF-8");
	String patientId			= checkForNull(request.getParameter("patientId"));
	String facility_id			= (String)session.getAttribute("facility_id");
	String encounter_id			= checkForNull(request.getParameter("encounterId"));
	String function_id		= checkForNull(request.getParameter("function_id"));
	Connection con					= null;
	Statement stmt					= null;
	ResultSet rset					= null;
	try
	{
		con = ConnectionManager.getConnection(request);
		stmt= con.createStatement();

		String facility_name		= "";
		String admission_date_time	= "";
		String discharge_date_time	= "";
		String practitioner_name	= "";
		String specialty_short_desc	= "";
		String classValue			= "";
		StringBuffer sqlQuery = new StringBuffer();

		if(function_id.equals("AdminHist"))
		{
			sqlQuery.append(" Select facility_id, SM_GET_DESC.SM_FACILITY_PARAM('"+facility_id+"','"+localeName+"','1') facility_name ,encounter_id, to_char(VISIT_ADM_DATE_TIME,'dd/mm/rrrr hh24:mi') admission_date_time , to_char(DISCHARGE_DATE_TIME, 'dd/mm/rrrr hh24:mi') discharge_date_time, AM_GET_DESC.AM_PRACTITIONER(ATTEND_PRACTITIONER_ID,'"+localeName+"','1') practitioner_name, AM_GET_DESC.AM_SPECIALITY(SPECIALTY_CODE,'"+localeName+"','2') specialty_short_desc from PR_ENCOUNTER where facility_id = '"+facility_id+"' and encounter_id='"+encounter_id+"' and patient_id= '"+patientId+"' ");
		}
		else
		{
			sqlQuery.append(" select facility_id, SM_GET_DESC.SM_FACILITY_PARAM('"+facility_id+"','"+localeName+"','1') facility_name ,encounter_id, to_char(admission_date_time,'dd/mm/rrrr hh24:mi') admission_date_time ,to_char(discharge_date_time, 'dd/mm/rrrr hh24:mi') discharge_date_time, AM_GET_DESC.AM_PRACTITIONER(ADMIT_PRACTITIONER_ID,'"+localeName+"','1') practitioner_name, AM_GET_DESC.AM_SPECIALITY(SPECIALTY_CODE,'"+localeName+"','2') specialty_short_desc from ip_patient_last_encounter where facility_id = '"+facility_id+"' and encounter_id='"+encounter_id+"' AND");
			sqlQuery.append(" patient_id= '"+patientId+"' ");
		}
		rset = stmt.executeQuery(sqlQuery.toString());
		int p_max_rec_cnt = 0;
				
%>

<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<FORM METHOD=POST ACTION="">
	<table cellspacing=0 cellpadding=0 align='center' width='100%' border='1'>
	
		<tr>
			<th><fmt:message key="Common.facility.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.admissiondate.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.dischargedate.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>
			<th><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></th>		
		</tr>
<%
	while(rset.next())
	{
		try
		{
			facility_name				= checkForNull(rset.getString("facility_name"),"&nabsp;");
			facility_id					= checkForNull(rset.getString("facility_id"));
			admission_date_time			= checkForNull(rset.getString("admission_date_time"),"&nbsp;");
			if(!(admission_date_time==null || admission_date_time.equals("&nbsp;")))
				admission_date_time = DateUtils.convertDate(admission_date_time,"DMYHM","en",localeName);
			discharge_date_time			= checkForNull(rset.getString("discharge_date_time"),"&nbsp;");
			if(!(discharge_date_time==null || discharge_date_time.equals("&nbsp;")))
				discharge_date_time = DateUtils.convertDate(discharge_date_time,"DMYHM","en",localeName);
			practitioner_name			= checkForNull(rset.getString("practitioner_name"),"&nbsp;");
			specialty_short_desc		= checkForNull(rset.getString("specialty_short_desc"),"&nbsp;");

			if (classValue.equals("") || classValue.equals("QRYODD"))  
			  classValue = "QRYEVEN";
			else
			  classValue = "QRYODD";
%>
		<tr>
			<td class="<%=classValue%>" align='center' nowrap><%=facility_name%> </td>
			<td class="<%=classValue%>" align='center' nowrap><%=admission_date_time%></td> 
			<td class="<%=classValue%>" align='center' nowrap><%=discharge_date_time%> </td>
			<td class="<%=classValue%>" align='center' nowrap><%=practitioner_name%> </td>
			<td class="<%=classValue%>" align='center' nowrap><%=specialty_short_desc%> </td>
		</tr>
	<% 
		}catch(Exception e)
		{ 
			out.println("ERROR : "+e); 
		}
		p_max_rec_cnt++;
	}
	if(rset!=null)	rset.close();
	if(stmt!=null) stmt.close();
		%>
	</table>
	<script>
		var p_max_cnt = '<%=p_max_rec_cnt%>';
		if (parseInt(p_max_cnt)== 1)
		{
			displayResult('<%=encounter_id%>','<%=patientId%>','<%=facility_id%>');
		}
	</script>
</FORM>
<%}catch(Exception e)	{out.println(e.toString());}
finally
{
	try
	{
		if(stmt!=null) stmt.close();
		if(rset!=null)	rset.close();
		ConnectionManager.returnConnection(con,request);
	}catch(Exception ee){out.println("Error while closing the connections :"+ee.toString());}
} %>
</body>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals(""))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals(""))) ? defaultValue : inputString);
	}
%>

