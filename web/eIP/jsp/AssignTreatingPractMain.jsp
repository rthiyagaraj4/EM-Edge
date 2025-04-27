<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<html>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
	<head>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'</link>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
	</head>
<%
	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	String facility			= (String) session.getValue( "facility_id" ) ;
	String encounterid		= checkForNull(request.getParameter("encounterId")); 
	String nurs_unit_code	= checkForNull(request.getParameter("location_code"));
	String Practitioner_Id	= checkForNull(request.getParameter("Practitioner_Id"));    
	String fromServlet		= checkForNull(request.getParameter("fromServlet"));
%>	
	<title><fmt:message key="Common.AssignTreatingPractitioner.label" bundle="${common_labels}"/> </title>	
	<iframe name='PLINE' id='PLINE' src='../../eCommon/jsp/pline.jsp?EncounterId=<%=encounterid%>&Facility_Id=<%=facility%>' noresize  frameborder=no scrolling='no' style='height:12vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eIP/jsp/PaintAddPractInCompleteVisit.jsp?Practitioner_Id=<%=Practitioner_Id%>&EncounterId=<%=encounterid%>&nurs_unit_code=<%=nurs_unit_code%>&IPval=ip&fromServlet=<%=fromServlet%>'  frameborder='0' scrolling='NO' marginheight='0' marginwidth='0' style='height:86vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'  src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='yes' marginheight='0' marginwidth='0' style='height:0vh;width:100vw'></iframe>

</html>
<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

