<!DOCTYPE html>
<%
/*
 Function Name/ID:	Status of Medical Report Request / MEDICAL_REPORT_STATUS
 Developer		:	SRIDHAR R
 Created On		:	23 NOV 2004
*/
%>
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
		
	<script language ='javascript' src='../../eMR/js/PrepareMedReport.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>	

</head>

<%
	request.setCharacterEncoding("UTF-8");
	String url="../../eCommon/jsp/commonToolbar.jsp?";
	String params = request.getQueryString() ;	
	String source = url + params ;

//	String facilityId	= (String)session.getValue("facility_id");
//	String loginUser	= (String)session.getValue("login_user");	
	String function_id	= request.getParameter("function_id");

%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src="<%=source%>" frameborder='0' scrolling='no' noresize style='height:8%;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' 	src='../jsp/ReportRequestQueryCriteria.jsp?call_function=<%=function_id%>' frameborder=0 scrolling='no' noresize style='height:45%;width:100vw'></iframe>
	<iframe name='result' id='result' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:100vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='no' noresize style='height:8%;width:100vw'></iframe>

</html>
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

