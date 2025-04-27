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
*	Created On		:	19 Mar 2005
--%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<title><fmt:message key="eCP.EvaluatePlan.label" bundle="${cp_labels}"/></title>
<script src="../../eCP/js/common.js" language="JavaScript"></script>
<script src="../../eCommon/js/common.js" language="JavaScript"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCP/js/EvaluateCarePlan.js" language="JavaScript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String mode = request.getParameter("mode")==null?"":request.getParameter("mode");
if(!mode.equals("error_page_mode"))
{
%>
	<iframe name='eval_cp_diagandgoal' id='eval_cp_diagandgoal' src='../../eCP/jsp/EvaluateCarePlanDiagAndGoalList.jsp?<%=request.getQueryString()%>' frameborder='0' scrolling='auto' noresize style='height:45vh;width:100vw'></iframe>
	<iframe name='eval_cp_intvnandoutcome' id='eval_cp_intvnandoutcome' 	src='../../eCP/jsp/EvaluateCarePlanIntvnAndOutcomeList.jsp?<%=request.getQueryString()%>' frameborder='0' noresize scrolling='auto' style='height:45vh;width:100vw'></iframe>
	<iframe name='eval_cp_button' id='eval_cp_button' 	src='../../eCP/jsp/EvaluateCarePlanButtons.jsp' frameborder='0' noresize scrolling='no' style='height:5vh;width:100vw'></iframe>
	<iframe name='blankFrame' id='blankFrame' 	src='../../eCommon/html/blank.html' frameborder='0' noresize scrolling='auto' style='height:0%;width:100vw'></iframe>
<%
}
else
{
%>
	<iframe name='eval_cp_diagandgoal' id='eval_cp_diagandgoal' src='../../eCP/jsp/EvaluateCarePlanDiagAndGoalList.jsp?<%=request.getQueryString()%>' frameborder='0' scrolling='auto' noresize style='height:30vh;width:99vw'></iframe>
	<iframe name='eval_cp_intvnandoutcome' id='eval_cp_intvnandoutcome' 	src='../../eCP/jsp/EvaluateCarePlanIntvnAndOutcomeList.jsp?<%=request.getQueryString()%>' frameborder='0' noresize scrolling='auto' style='height:60vh;width:99vw'></iframe>
<%}%>
</head>
</html>

