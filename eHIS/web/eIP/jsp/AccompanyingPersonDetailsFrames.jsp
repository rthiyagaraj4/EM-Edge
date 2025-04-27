<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8"  import= "java.util.*,java.sql.*,java.text.*,java.net.*,webbeans.eCommon.*, eCommon.XSSRequestWrapper" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<% request.setCharacterEncoding("UTF-8");  
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<html>
<head>
	<title><fmt:message key="eIP.AccompanyingPersonDetails.label" bundle="${ip_labels}"/></title>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/dchk.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>                         
<%
		String encounterId  =	request.getParameter("encounterId");
		if ((encounterId==null) || (encounterId.equals("null")))  encounterId = "";
%>
<iframe name='content_frame' id='content_frame' src='../../eIP/jsp/AccompanyingPersonDetails.jsp?encounterId=<%=encounterId%>' frameborder=0 noresize scrolling='auto'> 
	<iframe name='buttons_frame' id='buttons_frame'	src='../../eIP/jsp/AccompanyingPersonDetailsButtons.jsp' frameborder=0 noresize scrolling='no' style='height:80vh;width:100vw'></iframe>

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

