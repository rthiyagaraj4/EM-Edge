<!DOCTYPE html>
<%@ page contentType = "text/html;charset=UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	String params = request.getQueryString() ;
	String source = url + params ;
	String call_function	= request.getParameter("function_id");	
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script src='../../eMR/js/VisitsWithoutMDS.js' language='javascript'></script>
 <head>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame' src='<%=source%>' frameborder=0 scrolling='no'  style='height:7vh;width:100vw'></iframe>
		<iframe name='f_query_add_mod' id='f_query_add_mod' 	src='../jsp/vwVisitWithoutMDSSearchCriteria.jsp?call_function=<%=call_function%>' frameborder=0 scrolling='no' noresize style='height:22%;width:100vw'></iframe>
		<iframe scrolling="auto" name='resultframe' id='resultframe' src='../../eCommon/html/blank.html'  noresize frameborder=0 style='height:60vh;width:100vw'></iframe>	
		<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='no' noresize style='height:9vh;width:100vw'></iframe>	
	
	

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

