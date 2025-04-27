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
*	Created By		:	Sandhya.S
*	Created On		:	06/05/2005
* --%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<html>
<head>
<title>
<fmt:message key="eCP.AddInterventions.label" bundle="${cp_labels}"/>
</title>
</head>
<!--//This file is saved on 18/10/2005.-->
		<iframe name='RevisePlanAddInterventionsHeader' id='RevisePlanAddInterventionsHeader' src='../../eCP/jsp/ReviseCarePlanAddIntvnCriteria.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling=auto style='height:30vh;width:100vw'></iframe>
		<iframe name='ReviseCarePlanAddInterventionsResult' id='ReviseCarePlanAddInterventionsResult' src='../../eCP/jsp/ReviseCarePlanAddIntvnResult.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling=auto noresize style='height:60vh;width:100vw'></iframe>

</html>

