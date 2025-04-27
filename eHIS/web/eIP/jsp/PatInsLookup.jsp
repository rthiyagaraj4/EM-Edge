<!DOCTYPE html>
﻿<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8"  import= "java.util.*,java.sql.*,java.text.*,java.net.*,webbeans.eCommon.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<% request.setCharacterEncoding("UTF-8");  %>
<html>
<head>
	<title><fmt:message key="eAM.InstructionDescript.label" bundle="${am_labels}"/></title>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>                         
<%
		String excludeInstns  =	request.getParameter("excludeInstns");
		String patInsCount  =	request.getParameter("patInsCount")==null?"0":request.getParameter("patInsCount");
		if ((excludeInstns==null) || (excludeInstns.equals("null")))  excludeInstns = "";
%>
	<iframe name='criteria_frame' id='criteria_frame' src="../../eIP/jsp/PatInsCriteria.jsp?excludeInstns=<%=excludeInstns%>&patInsCount=<%=patInsCount%>" frameborder=0 noresize scrolling='auto' style='height:20vh;width:100vw'> </iframe>
	<iframe name='contents_frame' id='contents_frame'	src='../../eCommon/html/blank.html?' frameborder=0 noresize scrolling='auto' style='height:66vh;width:100vw'></iframe>
	<iframe name='buttons_frame' id='buttons_frame'	src='../../eCommon/html/blank.html?' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/error.jsp?' frameborder=0 noresize scrolling='no' style='height:5vh;width:100vw'></iframe>
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

