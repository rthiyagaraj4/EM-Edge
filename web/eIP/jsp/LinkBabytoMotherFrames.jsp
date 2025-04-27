<!DOCTYPE html>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); %>

<html>
<head>
<title> <fmt:message key="eIP.BabyToMotherDetails.label" bundle="${ip_labels}"/> </title>
	
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

</head>
<iframe name='BabyDetailsFrame' id='BabyDetailsFrame' src='../../eIP/jsp/LinkBabytoMotherDetails.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='auto' noresize valign='center' style='height:95vh;width:98vw'></iframe><iframe name='MessageFrame' id='MessageFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no' style='height:0vh;width:98vw'></iframe>
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

