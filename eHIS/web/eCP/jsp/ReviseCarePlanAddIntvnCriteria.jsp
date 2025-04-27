<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- 
	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	SANDHYA. S
*	Created On		:	06/05/2005
* --%>
<%@page import="java.sql.*, java.io.*,java.util.*,java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String locale=(String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>	
<script language="JavaScript" src="../../eCP/js/ReviseCarePlan.js"></script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
 <script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
String termSet = request.getParameter("termSet")==null?"":request.getParameter("termSet");
String termCode = request.getParameter("termCode")==null?"":request.getParameter("termCode");
String goalCode = request.getParameter("goalCode")==null?"":request.getParameter("goalCode");
String groupid = request.getParameter("groupid")==null?"":request.getParameter("groupid");
String md_care_plan_id = request.getParameter("md_care_plan_id")==null?"":request.getParameter("md_care_plan_id");
String care_plan_id = request.getParameter("care_plan_id")==null?"":request.getParameter("care_plan_id");
%>
<body>
	<form name='ReviseAddIntvncriteria' id='ReviseAddIntvncriteria'>
	<table border=0 cellspacing='0' cellpadding='0' width='100%'>
	<tr>
		<td class='label' width='15%' align='right'><fmt:message key="eCP.Interventions.label" bundle="${cp_labels}"/></td>
		<td>&nbsp;&nbsp;
			<input type='text' size=50 maxlength='60' name='intvn_desc' id='intvn_desc'>
			<input class='button' type=button name="intvn_btn" id="intvn_btn" value="?" onClick='selectIntvn(this)'>
			<input type='hidden' name='intvn_code' id='intvn_code' value=''>
			<input type='hidden' name='intvn_type' id='intvn_type' value=''>
		</td>
	</tr>
	<tr>
		<td colspan='2' align='right'>
			<input class='button' type=button name="addIntvn_btn" id="addIntvn_btn" value='<fmt:message key="Common.Add.label" bundle="${common_labels}"/>' onclick="addIntvn()">&nbsp;
			<input class='button' type=button name="close_btn" id="close_btn" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>
'  onClick='closewindow();'>
		</td>
	</tr>
	</table>
	<INPUT TYPE="hidden" name="md_care_plan_id" id="md_care_plan_id" value="<%=md_care_plan_id%>">
	<INPUT TYPE="hidden" name="care_plan_id" id="care_plan_id" value="<%=care_plan_id%>">
	<INPUT TYPE="hidden" name="termSet" id="termSet" value="<%=termSet%>">
	<INPUT TYPE="hidden" name="termCode" id="termCode" value="<%=termCode%>">
	<INPUT TYPE="hidden" name="goalCode" id="goalCode" value="<%=goalCode%>">
	<INPUT TYPE="hidden" name="groupid" id="groupid" value="<%=groupid%>">
	<INPUT TYPE="hidden" name="locale" id="locale" value="<%=locale%>">
<form>
</body>
</html>

