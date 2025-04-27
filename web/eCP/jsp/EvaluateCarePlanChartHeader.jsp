<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%--
*	Copyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eCP
*	Purpose 		:	
*	Created By		:	Vinay.
--%>
<html>
<head>
<%@ page import ="java.sql.*, java.text.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String comp	=	request.getParameter("comp")== null?"":request.getParameter("comp");
String care_plan_id	=	request.getParameter("care_plan_id")== null?"":request.getParameter("care_plan_id");
String md_plan_id	=	request.getParameter("md_plan_id")== null?"":request.getParameter("md_plan_id");
String term_set_id	=	request.getParameter("term_set_id")== null?"":request.getParameter("term_set_id");
String term_code	=	request.getParameter("term_code")== null?"":request.getParameter("term_code");
String term_code_srl_no	=	request.getParameter("term_code_srl_no")== null?"":request.getParameter("term_code_srl_no");
String goal_code	=	request.getParameter("goal_code")== null?"":request.getParameter("goal_code");
String goal_srl_no	=	request.getParameter("goal_srl_no")== null?"":request.getParameter("goal_srl_no");
String goal_desc	=	request.getParameter("goal_desc")== null?"":request.getParameter("goal_desc");
String diag_desc	=	request.getParameter("diag_desc")== null?"":request.getParameter("diag_desc");
String outcome_code	=	request.getParameter("outcome_code")== null?"":request.getParameter("outcome_code");
String outcome_srl_no	=	request.getParameter("outcome_srl_no")== null?"":request.getParameter("outcome_srl_no");
String outcome_desc	=	request.getParameter("outcome_desc")== null?"":request.getParameter("outcome_desc");
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src="../../eCP/js/EvaluateCarePlan.js" language="JavaScript"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<body>
<form>
<table width='100%' cellspacing='0' cellpadding='0' border=0>
<tr>
	<td>
		<INPUT TYPE="button" class='button' value='<fmt:message key="eCP.Graphical.label" bundle="${cp_labels}"/>' onclick="loadchart('Graph','<%=comp%>','<%=care_plan_id%>','<%=md_plan_id%>','<%=term_set_id%>','<%=term_code%>','<%=term_code_srl_no%>','<%=diag_desc%>','<%=goal_code%>','<%=goal_srl_no%>','<%=goal_desc%>','<%=outcome_code%>','<%=outcome_srl_no%>','<%=outcome_desc%>')">
		<INPUT TYPE="button" class='button' value='<fmt:message key="eCP.Textual.label" bundle="${cp_labels}"/>' onclick="loadchart('Text','<%=comp%>','<%=care_plan_id%>','<%=md_plan_id%>','<%=term_set_id%>','<%=term_code%>','<%=term_code_srl_no%>','<%=diag_desc%>','<%=goal_code%>','<%=goal_srl_no%>','<%=goal_desc%>','<%=outcome_code%>','<%=outcome_srl_no%>','<%=outcome_desc%>')">
	</td>
</tr>
</form>
</body>
</html>

