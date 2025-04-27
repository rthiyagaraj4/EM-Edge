<!DOCTYPE html>
 <!--This file is saved on 07/11/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>


<html>
	<head>
		<title></title>
		<% 
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//end.
		String JSFile=request.getParameter("JSFile");%>
		<%
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<script language="JavaScript" src="<%=JSFile%>"></script>
		
</head>
<!-- <body topmargin="0" bgcolor="pink"> -->
<body onMouseDown="" onKeyDown="lockKey()" topmargin="0" bgcolor="pink">
<form id="FormDrugInteractions" name="FormDrugInteractions" id="FormDrugInteractions">
<table name="TblInteractions" id="TblInteractions" width="100%" >
<tr><td align=right><input type=button class=button value="Close" onClick="closeInteraction()"></td></tr>
	</table>

