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
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<title><fmt:message key="eCP.EvaluationHistory.label" bundle="${cp_labels}"/>
</title>
<head>
<!-- <script language="JavaScript" src="../../eCP/js/common.js"></script> -->
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//This file is saved on 18/10/2005.
	String url = "../../eCP/jsp/EvaluateCarePlanChartDetail.jsp?" ;
 	String params = request.getQueryString() ;
	String source = url + params ;
%>
<iframe name='f_query_add_mod' id='f_query_add_mod' 	src='../../eCP/jsp/EvaluateCarePlanChartHeader.jsp?<%=request.getQueryString()%>' frameborder=0 noresize scrolling='no' style='height:5vh;width:100vw'></iframe><iframe name='bottom_frame' id='bottom_frame' src='<%=source%>' frameborder=0 scrolling='auto' noresize style='height:100vh;width:100vw'></iframe>

</head>
<body>
</body>				
</html>

