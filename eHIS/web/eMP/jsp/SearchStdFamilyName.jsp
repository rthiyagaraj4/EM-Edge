<!DOCTYPE html>
<!--
	Developed By       :	Gaurav Jain
	Created on   	   :	12/09/2001
	Function		   :	To search the Family Name
-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<head>
<title><fmt:message key="eMP.StandardFamilyName.label" bundle="${mp_labels}"/></title>
<%
	request.setCharacterEncoding("UTF-8"); 
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String param_value = request.getParameter("param_value") == null?"":request.getParameter("param_value");
	String names_in_oth_lang = request.getParameter("names_in_oth_lang");
	String field_lang = request.getParameter("field_lang");
	if(names_in_oth_lang == null || names_in_oth_lang.equals("null"))
		names_in_oth_lang = "N";
		
	%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src="../../eCommon/js/ValidateControl.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	<iframe name='SearchCriteria' id='SearchCriteria' src='../jsp/SearchStdFamilyNameCriteria.jsp?names_in_oth_lang=<%=names_in_oth_lang%>&param_value=<%=param_value%>&field_lang=<%=field_lang%>' noresize frameborder='no' marginheight='0' marginwidth='0' SCROLLING='no' style='height:25vh;width:100vw'></iframe>
	<iframe name='SearchSelection' id='SearchSelection' src='../../eCommon/html/blank.html' noresize frameborder='no' marginheight='0' marginwidth='0' SCROLLING='auto' style='height:75vh;width:100vw'></iframe>
</head>
</html>


<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

