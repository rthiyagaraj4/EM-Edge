<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String called_from = (String)request.getParameter("called_from")==null?"":(String)request.getParameter("called_from");
	String QueryString  = (String)request.getQueryString();
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOR/js/ManageConsultOrders.js"></script>
	<script language="Javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<table cellpadding=3 cellspacing=0 border='0' align='center' width="100%">
	<tr>
	<td colspan='3' class="button"><input type="button" name="record" id="record" id="recordApply" class="BUTTON" value ="Record" title ="Record"  onClick="apply()"><input type="button" name="Clear" id="Clear" id="Clear" class="BUTTON" value ="Clear" title ="Clear"  onClick="Refresh('<%=QueryString%>')">
	<%
	if(called_from.equalsIgnoreCase("PATIENT_QUEUE"))
	{
	%>
		<input type="button" name="Cancel" id="Cancel" id="Cancel" class="BUTTON" value ="Cancel" title ="Cancel"  onClick="Cancel()">
	<%
	}
	%>
	</td>
	</tr>
	<input type="hidden" name="queryString" id="queryString" value="<%=QueryString%>">
	</table>
</body>
</html>

