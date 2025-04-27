<!DOCTYPE html>
<%@ page contentType="text/html;charset=windows-1256" import="java.sql.*,webbeans.eCommon.ConnectionManager" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>	
<HEAD>
<%
	String sStyle	= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js"></script>
<script src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/messages.js' language='javascript'></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	function sendtomain(encid)
	{
		parent.window.returnValue=encid;
		parent.window.close();       
	}
</script>
</HEAD>

<BODY onMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
<form name="RepMovementHistForm" id="RepMovementHistForm">
<%
	Connection con				= null;
	PreparedStatement pstmt		= null;
	ResultSet rs				= null;
		
	String strPatLine		=		"",						strPatientId			=	"";
	String strFacilityId	=		"",						strQuery				=	"";
	String strEncId			=		"",						strVisitAdmDt			=	"";
	String strPatClass		=		"",						strLocation				=	"";
	String strPractitioner	=		"",						classValue				=	"";

	int		i				=		0;
	
	strFacilityId	=	(String) session.getValue( "facility_id" ) ;	
	
	strPatientId	=	checkForNull(request.getParameter("patient_id") );

	try
	{
		strQuery = "SELECT PATIENT_ID,get_patient_line(PATIENT_ID,?) patient_line FROM MR_PAT_FILE_INDEX WHERE FACILITY_ID = ? AND patient_id = ?";
		con		=	ConnectionManager.getConnection(request);

		pstmt	=	con.prepareStatement(strQuery);
		
		pstmt.setString(1,locale);
		pstmt.setString(2,strFacilityId);
		pstmt.setString(3,strPatientId);

		rs	= pstmt.executeQuery();

		if(rs != null && rs.next())
			strPatLine = rs.getString("patient_line").substring(0,rs.getString("patient_line").length()-6);
			
		if (rs != null) rs.close();
		if (pstmt != null) pstmt.close();

		strQuery	=	"SELECT encounter_id, TO_CHAR (visit_adm_date_time, 'dd/mm/yyyy hh24:mi'), AM_GET_DESC.AM_PRACTITIONER(admit_practitioner_id,?,'1') practitioner_name,a.PATIENT_CLASS,DECODE (a.assign_care_locn_type,'N', (SELECT short_desc FROM ip_nursing_unit WHERE nursing_unit_code = a.assign_care_locn_code AND facility_id = a.facility_id),(SELECT short_desc FROM op_clinic WHERE clinic_code = a.assign_care_locn_code AND facility_id = a.facility_id)) clinic_name FROM pr_encounter a WHERE a.facility_id = ? AND a.patient_id = ?";
			
		pstmt	=	con.prepareStatement(strQuery);

		pstmt.setString(1,locale);
		pstmt.setString(2,strFacilityId);
		pstmt.setString(3,strPatientId);

		rs	= pstmt.executeQuery();

		if(rs != null )
		{
			%>
			<table border="1" width="100%" cellspacing='0' cellpadding='0'>
			<%
				out.println("<tr><td colspan='3' class='PATIENTLINECOLOROTHLANG' nowrap><FONT  size='2'><b>"+strPatLine+"</td></tr>");
			%>
				<tr colspan='3'></tr>
			</table>
			<br>
			<table border="1" width="100%" cellspacing='0' cellpadding='0'>
			<tr>
				<th width = '20%'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></th>
				<th width = '20%'><fmt:message key="Common.admission.label" bundle="${common_labels}"/>/<fmt:message key="Common.VisitDateTime.label" bundle="${common_labels}"/></th>
				<th width = '15%'><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></th>
				<th width = '10%'><fmt:message key="Common.Location.label" bundle="${common_labels}"/>(<fmt:message key="Common.clinic.label" bundle="${common_labels}"/>/<fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/>)</th>
				<th width = '35%'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th>
			</tr>
			<%	
			while(rs.next())
			{
				%>
				<tr>
				<%
					strEncId		=	checkForNull(rs.getString(1));
					strVisitAdmDt	=	checkForNull(rs.getString(2));
					strPractitioner	=	checkForNull(rs.getString(3));
					strPatClass		=	checkForNull(rs.getString(4));
					strLocation		=	checkForNull(rs.getString(5));

					if(strPractitioner.equals("") )
						strPractitioner	=	"&nbsp;";
					
					i++;
				
					if(i % 2 == 0)
						classValue = "QRYEVEN";
					else
						classValue = "QRYODD";		 

					out.println("<td width = '20%' class='"	+ classValue+"'><a href=\"javascript:sendtomain('"+strEncId+"')\">"+strEncId+"</a></td>");
					out.println("<td width = '20%' class='" + classValue + "'>"+strVisitAdmDt+"</td>");
					out.println("<td width = '10%' class='" + classValue + "'>"+strPatClass+"</td>");
					out.println("<td width = '25%' class='" + classValue + "'>"+strLocation+"</td>");
					out.println("<td width = '25%' class='" + classValue + "'>"+strPractitioner+"</td>");
					%>
					</tr>
					<%
			}
			%>
			</table>
			<%
		}
	}
	catch(Exception e)
	{
		
		e.printStackTrace();
	}
	finally
	{		
		if(rs!=null)	rs.close();
		if(pstmt!=null) pstmt.close();
		if(con != null) ConnectionManager.returnConnection(con,request);
	}
%>
</form>
</BODY>
</HTML>
<%!
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
%>

