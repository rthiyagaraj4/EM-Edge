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
*	Created By		:	P.Anuradha 
*	Created On		:	19 July 2005
--%>
<%@page language="java" import ="com.ehis.eslp.*,java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="CarePlanVariance" class="webbeans.eCommon.RecordSet" scope="session"/> 
<html>
<head>
<%
//This file is saved on 07/11/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
CarePlanVariance.clearAll();
%>
<title><fmt:message key="eCP.RecordVariance.label" bundle="${cp_labels}"/></title>
<script src="../../eCP/js/common.js" language="JavaScript"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCP/js/CarePlanVariance.js" language="JavaScript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<iframe name='care_plan_header' id='care_plan_header' src='../../eCP/jsp/CarePlanVarianceHeader.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='no' noresize style='height:40%;width:100vw'></iframe>
<iframe name='care_plan_dtls' id='care_plan_dtls' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:45%;width:100vw'></iframe>
<iframe name='care_plan_dyn_val' id='care_plan_dyn_val' 	src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no'>
<iframe name='care_plan_buttons' id='care_plan_buttons' 	src='../../eCP/jsp/CarePlanVarianceButtons.jsp' frameborder=0 scrolling='no' noresize style='height:0%;width:100vw'></iframe>

</head>
</html>

