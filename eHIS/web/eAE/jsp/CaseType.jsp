<!DOCTYPE html>
<!-- 
CRF Reference No: ML-MMOH-CRF-1653
Detected Release: Mar24
File Prepared by: Ajay Hatwate
File Prepared on: 02/01/2024
-->
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>">
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script><script Language="JavaScript" src="../../eAE/js/CaseType.js"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
</head>
<%
String params = request.getQueryString() ;
%>
<frameset rows='42, *, 50'>
<frame name='commontoolbarFrame' id='commontoolbarFrame'	src='../../eCommon/jsp/MstCodeToolbar.jsp?<%=params %>' frameborder=0 scrolling='no' noresize>
<frame name='f_query_add_mod' id='f_query_add_mod' src='../../eCommon/html/blank.html' frameborder=0>
<frame name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto'>
</frameset>
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
