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
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<title><fmt:message key="Common.ResultReporting.label" bundle="${common_labels}"/></title>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../../eOR/js/ResultReporting.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<form name="ResultFrameForm" id="ResultFrameForm">
	<table id="tab" cellspacing=0 cellpadding=3 border="0" width="100%" align=center>
	 	<tr>
			<td class="label" width="13%"><fmt:message key="Common.Result.label" bundle="${common_labels}"/></td>
			<td class="label" width="15%"><input type="radio" name="reporting" id="reporting" value='' checked onClick="callResultEntry('Reporting')"><fmt:message key="eOR.Reporting.label" bundle="${or_labels}"/></td>
			<td class="label" width="15%" ><input type="radio" name="reporting" id="reporting" value=''  onClick="callResultEntry('Coding')"><fmt:message key="eOR.Coding.label" bundle="${or_labels}"/></td>
			<td class="label" width="57%"></td>
			<input type="hidden" name="query_string" id="query_string" value="<%=request.getQueryString()%>">
 		</tr>
	</table>
 </form>
</body>
</html>

