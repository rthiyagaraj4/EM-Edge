<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8"%>
<html>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/ViewResults.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body  onload='FocusFirstElement()'  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name=view_results_hdg>
<%
String selectmode=request.getParameter("selectmode");
%>
<table cellpadding=0 cellspacing=0 border=1  id='titleTab' width="100%">
<%if(selectmode.equals("")){%>
	<tr height="60%">
		<th width="15%">Date of Event</th>
		<th width="15%">Event</th>
		<th width="70%">Description</th>
	</tr>
	<%}else{%>
<tr height="60%">
		<th width="15%">Date of Event</th>
		<th width="85%">Description</th>
</tr>
	<%}%>
</table>
</form>
</body>
<script>
	parent.ViewResultsDetail.location.href="ViewResultsDetail.jsp?<%=request.getQueryString()%>"
</script>
</html>

