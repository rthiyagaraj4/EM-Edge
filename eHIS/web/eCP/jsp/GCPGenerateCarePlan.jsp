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
*	Created By		:	Jerome
*	Created On		:	19/01/2005
* --%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="GCPGenerateBean"   scope="session"  class="eCP.GCPGeneratePlanBean"/>

<html>
<head>
</head> 
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//This file is saved on 18/10/2005.
	//String p_called_from_ca		= (String)request.getParameter("p_called_from_ca ");
	String patient_id			= (String)request.getParameter("patient_id");
	//String encounter_id			= (String)request.getParameter("encounter_id");
	String patient_class		= (String)request.getParameter("patient_class");

eCP.GCPGeneratePlanBean bean	= (eCP.GCPGeneratePlanBean)session.getAttribute("GCPGenerateBean");	
bean.clearBean();
bean.setPatientId(patient_id);
bean.setPatientClass(patient_class);

%>
<iframe name='GeneratePlanManager' id='GeneratePlanManager' src='../../eCP/jsp/GCPGenerateCarePlanManager.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling=no style='display:none;height:0vh;width:99vw'></iframe>
<iframe name='GeneratePlanProfile' id='GeneratePlanProfile' src='../../eCP/jsp/GCPGenerateCarePlanProfileFrame.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling=auto noresize style='height:88vh;width:99vw'></iframe>
	<iframe name='GeneratePlanType' id='GeneratePlanType' src='../../eCP/jsp/GCPGenerateCarePlanTypeFrame.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling=auto noresize style='height:10vh;width:99vw'></iframe>
	<iframe name='TempFrame' id='TempFrame' src='../../eCommon/html/blank.html' frameborder=0 noresize style='height:0vh;width:99vw'></iframe>
	

</html>

