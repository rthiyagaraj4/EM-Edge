<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,com.ehis.util.*"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/rowcolor.js' language='javascript'></SCRIPT>

<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<%
    request.setCharacterEncoding("UTF-8");
    Connection conn		= null;
	Statement stmt		= null;
	ResultSet rs		= null;
	String rowclass		= "QRYEVEN";
	String facilityid	= (String)session.getValue("facility_id") ;		
	String Encounter_Id = checkForNull(request.getParameter("Encounter_Id"));	
	String IPval		= request.getParameter("IPval");
	String locale			= (String)session.getAttribute("LOCALE");
	String role_start_time_converted = "";
	String role_end_time_converted	=	"";
	
	int aname=1;
	int i=0;

/// Added by Sridhar R on 1 JULY 2004
/// This Block will Fetch the values from Pr_encounter_pract_vw & display in the result page...
try
{
	StringBuffer sqlQuery	= new StringBuffer();
	conn = ConnectionManager.getConnection(request);	
	stmt = conn.createStatement();
    sqlQuery.append("SELECT a.operating_facility_id, a.encounter_id, a.srl_no, a.PRACTITIONER_ID, AM_GET_DESC.AM_SPECIALITY(a.SPECIALTY_CODE,'"+locale+"','2') PRACT_SPECIALTY, a.SPECIALTY_CODE PRACT_SPECIALTY_CODE, IP_GET_DESC.IP_NURSING_UNIT(a.OPERATING_FACILITY_ID,a.NURSING_UNIT_CODE,'"+locale+"','2') PRACT_LOCATION, AM_GET_DESC.AM_POSITION(b.POSITION_CODE,'"+locale+"','1') PRACT_DESIGNATION, AM_GET_DESC.AM_PRACTITIONER(a.PRACTITIONER_ID,'"+locale+"','1') PRACT_NAME, TO_CHAR(a.ROLE_END_TIME,'dd/mm/rrrr hh24:mi') ROLE_END_DATE_TIME,TO_CHAR(a.ROLE_START_TIME,'dd/mm/rrrr hh24:mi') ROLE_START_DATE_TIME,a.PRACTITIONER_ROLE PRACT_ROLE, a.REMARKS FROM pr_encounter_pract a, am_practitioner b where a.operating_facility_id = '"+facilityid+"' AND a.encounter_id = '"+Encounter_Id+"' and A.PRACTITIONER_ID   = B.PRACTITIONER_ID ORDER BY a.PRACTITIONER_ROLE, a.ROLE_START_TIME desc");
	
	
	rs = stmt.executeQuery(sqlQuery.toString()); 	

%>

	<form name='PractIncompleteResult_form' id='PractIncompleteResult_form'>
	<div align='center'>
	<table border="1" width="100%" cellspacing='0' cellpadding='0' id='tb1' align='center'>
	<th nowrap><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>
	<th nowrap><fmt:message key="eIP.DesignationTitle.label" bundle="${ip_labels}"/></th>
	<th nowrap><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></th>
	<th nowrap><fmt:message key="Common.Location.label" bundle="${common_labels}"/></th>
	<th nowrap><fmt:message key="eIP.RoleStartDate.label" bundle="${ip_labels}"/></th>
	<th nowrap><fmt:message key="eIP.RoleEndDate.label" bundle="${ip_labels}"/></th>
	<th nowrap><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th>

<%
	if (!rs.next())
	{

	}
	else
	{
		String oldRole = "";
		do
		{
			if (i % 2 == 0 )
				rowclass = "QRYEVEN";
			else
				rowclass = "QRYEVEN";

			String practitioner_role= checkForNull(rs.getString("PRACT_ROLE"),"&nbsp;");
			String practitioner_name= checkForNull(rs.getString("PRACT_NAME"),"&nbsp;");
			String role_start_time	= checkForNull(rs.getString("ROLE_START_DATE_TIME"),"&nbsp;");
			String role_end_time	= checkForNull(rs.getString("ROLE_END_DATE_TIME"));
			
			String practitioner_id	= checkForNull(rs.getString("PRACTITIONER_ID"),"&nbsp;");
			String srl_no			= checkForNull(rs.getString("srl_no"),"&nbsp;");
			String Designation		= checkForNull(rs.getString("PRACT_DESIGNATION"),"&nbsp;");
			String Specialty		= checkForNull(rs.getString("PRACT_SPECIALTY"),"&nbsp;");
			String Location			= checkForNull(rs.getString("PRACT_LOCATION"),"&nbsp;");
			String remarks			= checkForNull(rs.getString("REMARKS"),"&nbsp;");
			String specialtycode	= checkForNull(rs.getString("PRACT_SPECIALTY_CODE"));
/*/// Added by Sridhar R on 1 JULY 2004
/// if Old role of Practitioner is not same as new role obtaibed from table then a new header will be added for the New Role..

Roles of Practitioner are..
1 - Admitting
2 - Co-Attending
3 - Assisting 
4 - Attending

*/		if(!(role_start_time.equals("") || role_start_time == null || role_start_time.equals("&nbsp;")))
					role_start_time_converted = DateUtils.convertDate(role_start_time,"DMYHM","en",locale); 
		if(!(role_end_time.equals("") || role_end_time == null || role_end_time.equals("&nbsp;")))
					role_end_time_converted = DateUtils.convertDate(role_end_time,"DMYHM","en",locale); 
	
   
   		if(!practitioner_role.equals(oldRole))
		{ if(practitioner_role.equals("1"))
			{%>
			<tr><td class='"+rowclass+"' colspan='7'><b><fmt:message key="eIP.Admitting.label" bundle="${ip_labels}"/></b></td>
			<%}else  if(practitioner_role.equals("2"))
			{%>
			<tr><td class='"+rowclass+"' colspan='7'><b><fmt:message key="Common.consultant.label" bundle="${common_labels}"/></b></td>
			<%}else if(practitioner_role.equals("3"))
			{%>
			<tr><td class='"+rowclass+"' colspan='7'><b><fmt:message key="eIP.Assisting.label" bundle="${ip_labels}"/></b></td>
			<%}else  if(practitioner_role.equals("4"))
			{%>
			<tr><td class='"+rowclass+"' colspan='7'><b><fmt:message key="eIP.Attendant.label" bundle="${ip_labels}"/></b></td>
			<%}else
			{%>
			<tr><td class='"+rowclass+"' colspan='7'><b>&nbsp;</b></td>
			<%}
			out.println ( "</tr>" ) ;
		}

		out.println("<tr style='background-color:;' ><td nowrap class='"+rowclass+"' >");

          if(!(role_end_time.equals("") || role_end_time == "" )) 
			{
			
			out.println(practitioner_name+"</a></td><td nowrap class='"+rowclass+"' >");
			}
			else
			{
			out.println("<a name='"+aname+"' onclick='changeRowColor(this,0)' href='../../eIP/jsp/addPractInCompleteVisit.jsp?Practitioner_Id="+practitioner_id+"&practitioner_name="+java.net.URLEncoder.encode(practitioner_name)+"&practitioner_role="+practitioner_role+"&specialtycode="+java.net.URLEncoder.encode(specialtycode)+"&roleStartTime="+role_start_time+"&roleEndTime="+role_end_time+"&Encounter_Id="+Encounter_Id+"&srl_no="+srl_no+"&Modval=modify&IPval="+IPval+"' target='add_modify' >");
			
			out.println(practitioner_name+"</a></td><td nowrap class='"+rowclass+"' >");
			}
			out.println(Designation+"</td><td nowrap class='"+rowclass+"' >");
			out.println(Specialty+"</td><td nowrap class='"+rowclass+"' >");
			out.println(Location+"</td><td nowrap class='"+rowclass+"' >");
			out.println(role_start_time_converted+"</td><td nowrap class='"+rowclass+"' >");
			if(role_end_time.equals("") || role_end_time == "" ) 
				out.println("&nbsp;</td><td wrap class='"+rowclass+"' >");
			else
				out.println(role_end_time_converted+"</td><td wrap class='"+rowclass+"' >");
			out.println(remarks+"</td></tr>");
		
			oldRole =rs.getString("PRACT_ROLE");
			aname++;
			i++;
		}
			while  (rs.next());
	}
if (sqlQuery.length() > 0)
sqlQuery.delete(0, sqlQuery.length());

}catch(Exception e){out.print(e);}
finally
{
	try{

		if(rs!=null)	rs.close();
		if(stmt!=null) 	stmt.close();
		ConnectionManager.returnConnection(conn,request);
	}catch(Exception ee){out.println("Error while closing the connections:"+ee.toString());}
}
%>
</table>
</div>
<input type='hidden'  value=''  name="practitioner_role" id="practitioner_role">
<input type='hidden'  value=''  name="specialtycode" id="specialtycode">
<input type='hidden'  value=''  name="shortdesc" id="shortdesc">
</form>
</BODY>
</HTML>
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

