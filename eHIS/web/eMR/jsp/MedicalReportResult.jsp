<!DOCTYPE html>
<%
/*
	Function Name	:	Prepare / Receive / Deliver Medical Report
	Developer		:	SRIDHAR R
	Created On		:	22 JULY 2004
*/
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,com.ehis.util.*,java.util.StringTokenizer,java.util.TreeMap,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<%
	request.setCharacterEncoding("UTF-8"); 
	request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
	String classValue	 = "";
	String FacilityId		= (String) session.getValue( "facility_id" ) ;	
	
	String jsp_name =request.getParameter("jsp_name");	
	
	String call_function=request.getParameter("call_function");
	if(call_function == null) call_function="";

	String request_id=request.getParameter("request_id");
	if(request_id == null) request_id="";

	String PatientId=request.getParameter("PatientId");
	if(PatientId == null) PatientId="";

	ResultSet rs	= null;
	Statement stmt	= null;
	Connection con = ConnectionManager.getConnection(request);	

	String encounter_date		= "";
	String encounter_id			= "";
	String speciality_desc		= "";
	String locn_desc			= "";
	String practitioner_name	= "";
	String locn_type			= "";
	String encounter_type		= "";
	String patient_class		= "";
	String discharge_date_time	= "";

try
{
	 StringBuffer sqlbuff = new StringBuffer();
	 if(sqlbuff.length() > 0) sqlbuff.delete(0,sqlbuff.length());
	 sqlbuff.append("SELECT h.short_desc,TO_CHAR (a.visit_adm_date_time, 'dd/mm/yy hh24:mi') encounter_date, ");
	 sqlbuff.append("a.encounter_id encounter_id, d.short_desc speciality_desc, ");
	 sqlbuff.append("DECODE (a.assign_care_locn_type,'C', f.short_desc, 'N', g.short_desc) locn_desc, ");  sqlbuff.append("e.practitioner_name, DECODE (a.assign_care_locn_type, 'C', 'Clinic','N', 'Nursing Unit') locn_type,");
	 sqlbuff.append(" h.short_desc encounter_type, h.patient_class patient_class,");
	 sqlbuff.append("TO_CHAR (a.discharge_date_time,'dd/mm/yy hh24:mi') discharge_date_time FROM ");
	 sqlbuff.append(" pr_encounter a, mp_patient b, am_speciality d, am_practitioner e, op_clinic f, ");  sqlbuff.append(" ip_nursing_unit g, am_patient_class h, MR_REPORT_REQUEST_DTL i WHERE ");
	 sqlbuff.append("a.patient_id = b.patient_id  AND b.patient_id LIKE '"+PatientId+"' AND ");
	 sqlbuff.append(" a.facility_id = '"+FacilityId+"' and i.request_id='"+request_id+"' AND ");
	 sqlbuff.append(" a.specialty_code = d.speciality_code AND a.attend_practitioner_id = e.practitioner_id (+) AND ");
	 sqlbuff.append(" a.facility_id = f.facility_id(+) AND a.assign_care_locn_code = f.clinic_code(+)");
	 sqlbuff.append("AND a.facility_id = g.facility_id(+) AND a.assign_care_locn_code = g.nursing_unit_code(+) AND ");
	 sqlbuff.append(" a.patient_class = h.patient_class(+) AND a.encounter_id = i.encounter_id ");

	try
	{
		//out.println(sqlbuff.toString());
		stmt = con.createStatement();
		rs	 = stmt.executeQuery(sqlbuff.toString());
	}
	catch(Exception e)
	{
		//out.println("Exception in try-catch  : "+e);
		e.printStackTrace();
	}
%>
<HTML>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body OnMouseDown='CodeArrest();' onKeyDown='lockKey()'>
<form name='DeathRegisterResult' id='DeathRegisterResult' >
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
	<th align='center' nowrap>&nbsp;</th>
		<th align='center' nowrap><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/></th>
			<th align='center' nowrap><fmt:message key="Common.encounterdate.label" bundle="${common_labels}"/></th> 
				<th align='center' nowrap><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th> 
					<th align='center' nowrap><fmt:message key="Common.locationtype.label" bundle="${common_labels}"/></th>
				<th align='center' nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
			<th align='center' nowrap><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>
		<th align='center' nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></th>
	<th align='center' nowrap><fmt:message key="Common.dischargedate.label" bundle="${common_labels}"/></th>
<%
	int i =0;

	if ( rs != null )
	{
		while ( rs.next() )
		{
			if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;

			encounter_date=rs.getString("encounter_date");
				if(encounter_date==null) encounter_date = "";
			if(!(encounter_date==null || encounter_date.equals("")))
					encounter_date	= DateUtils.convertDate(encounter_date,"DMYHM","en",localeName);

			encounter_id=rs.getString("encounter_id");
				if(encounter_id==null) encounter_id = "&nbsp;";
			speciality_desc=rs.getString("speciality_desc");
				if(speciality_desc==null) speciality_desc = "&nbsp;";
			locn_desc=rs.getString("locn_desc");
				if(locn_desc==null) locn_desc = "&nbsp;";
			practitioner_name=rs.getString("practitioner_name");
				if(practitioner_name==null) practitioner_name = "&nbsp;";
			locn_type=rs.getString("locn_type");
				if(locn_type==null) locn_type = "&nbsp;";
			encounter_type=rs.getString("encounter_type");
				if(encounter_type==null) encounter_type = "&nbsp;";
			patient_class=rs.getString("patient_class");
				if(patient_class==null) patient_class = "&nbsp;";

			discharge_date_time=rs.getString("discharge_date_time");		
				if(discharge_date_time==null) discharge_date_time = "";
			if(!(discharge_date_time==null || discharge_date_time.equals("")))
					discharge_date_time	= DateUtils.convertDate(discharge_date_time,"DMYHM","en",localeName);

									
			out.println("<tr><td align='left' class='"+classValue+"'>");
			out.println("<td nowrap class='"+classValue+"'>" +encounter_type+"</td>");
			out.println("<td nowrap class='"+classValue+"'>" +encounter_date+"</td>");
			out.println("<td nowrap class='"+classValue+"'>" +encounter_id+"</td>");
			out.println("<td nowrap class='"+classValue+"'>" +locn_type+"</td>");
			out.println("<td nowrap class='"+classValue+"'>" +locn_desc+"</td>");
			out.println("<td nowrap class='"+classValue+"'>" +practitioner_name+"</td>");
			out.println("<td nowrap class='"+classValue+"'>" +speciality_desc+"</td>");
			out.println("<td nowrap class='"+classValue+"'>" +discharge_date_time+"</td>");
			out.println("</tr>");

			i++;
		}
	}

try
{
	if( rs != null )	rs.close();
	if( stmt != null )	stmt.close();

	stmt = con.createStatement();
	rs	 = stmt.executeQuery(sqlbuff.toString());
	if(rs != null)
	{
		if(rs.next())
		{
			encounter_date=rs.getString("encounter_date");
				if(encounter_date==null) encounter_date = "";
			if(!(encounter_date==null || encounter_date.equals("")))
					encounter_date	= DateUtils.convertDate(encounter_date,"DMYHM","en",localeName);

			encounter_id=rs.getString("encounter_id");
				if(encounter_id==null) encounter_id = "";
			encounter_type=rs.getString("encounter_type");
				if(encounter_type==null) encounter_type = "&nbsp;";
			patient_class=rs.getString("patient_class");
				if(patient_class==null) patient_class = "&nbsp;";
			discharge_date_time=rs.getString("discharge_date_time");		
				if(discharge_date_time==null) discharge_date_time = "";
			if(!(discharge_date_time==null || discharge_date_time.equals("")))
					discharge_date_time	= DateUtils.convertDate(discharge_date_time,"DMYHM","en",localeName);

		}
	}
}catch (Exception exp)
{
	//out.println("Exception in fetching : "+exp);	
	exp.printStackTrace();
}

	%>
	</table>
	<input type='hidden' name='jsp_name' id='jsp_name' value="<%=jsp_name%>" >
	<input type='hidden' name='encounter_date' id='encounter_date' value="<%=encounter_date%>" >
	<input type='hidden' name='encounter_id' id='encounter_id' value="<%=encounter_id%>" >
	<input type='hidden' name='encounter_type' id='encounter_type' value="<%=encounter_type%>" >
	<input type='hidden' name='patient_class' id='patient_class' value="<%=patient_class%>" >
	<input type='hidden' name='discharge_date_time' id='discharge_date_time' value="<%=discharge_date_time%>" >
<%
}catch ( Exception e )
{ 
	//out.println(e);
	e.printStackTrace();
}

finally
{
	if ( stmt != null ) stmt.close() ;
	if ( rs != null ) rs.close() ;
	ConnectionManager.returnConnection(con,request);
}
%>
</center>
</form>
</body>
</html>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	? "" : inputString;
	}

	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	? defaultValue : inputString;
	}
%>

