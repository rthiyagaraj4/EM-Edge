<!DOCTYPE html>
<%@ page import="java.sql.Connection, java.sql.ResultSet, java.sql.PreparedStatement, webbeans.eCommon.ConnectionManager" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");

	String url = "../../eMR/jsp/vwEncounterDetailResult.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;	

	%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

<html>
<head>
	<title><fmt:message key="Common.PreviousEncounters.label" bundle="${common_labels}"/></title>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language='javascript' src='../../ecommon/js/common.js'></script>
 </head>
 <iframe name='resultFrame' id='resultFrame'      src='<%=source%>'  frameborder=0   style='height:87vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' scrolling='NO' frameborder='0' noresize style='height:12vh;width:100vw'></iframe>

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

