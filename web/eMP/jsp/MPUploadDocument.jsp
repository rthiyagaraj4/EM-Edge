<!DOCTYPE html>
<!--Created by Ashwini on 16-Dec-2019 for AAKH-CRF-0079.11-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, webbeans.eCommon.ConnectionManager, java.util.*, eCommon.Common.*,eMP.*,java.io.*,org.json.simple.*"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>

<head>
	<title><fmt:message key="Common.UploadInsDoc.label" bundle="${common_labels}"/></title>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../ecommon/js/common.js'></script>
	<script language='javascript' src="../js/MPUploadDocument.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	request.setCharacterEncoding("UTF-8");
    String url = "../../eCommon/jsp/MstCodeToolbar.jsp?";
    String params = request.getQueryString();
	String function_id = checkForNull(request.getParameter("function_id"));
	String patient_id = checkForNull(request.getParameter("patient_id"));
	String encounter_id = checkForNull(request.getParameter("encounter_id"));
	String source = url + params;
	
%>
								
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%=source%> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
	<iframe name='f_query_add_mod' id='f_query_add_mod' src='MPUploadDocumentSearch.jsp?params=<%=params%>&function_id=<%=function_id%>&patient_id=<%=patient_id%>&encounter_id=<%=encounter_id%>' frameborder=0 scrolling='auto' style='height:10.5vh;width:100vw'></iframe>
	<iframe name='searchResultFrame' id='searchResultFrame' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:75.5vh;width:100vw'></iframe>
	<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:6vhvh;width:100vw'></iframe>

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

