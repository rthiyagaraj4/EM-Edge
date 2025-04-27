<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>  
<%@ page language="java" contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src="../../eOA/js/repResetRunlist.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	<title><fmt:message key="eIP.MedicalCertificate.label" bundle="${ip_labels}"/></title>
</head>
<%
	request.setCharacterEncoding("UTF-8"); 
	String url = "../../eIP/jsp/DischargeMedicalCertificate.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
%>
	<iframe scrolling="no" name='menuFrame' id='menuFrame' src='<%= source %>'  frameborder=0 style='height:80vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:0%;width:100vw'></iframe>
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

