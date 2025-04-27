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
*	Created By		:	Sandhya.S
*	Created On		:	21 Mar 2005
--%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<HEAD>
<SCRIPT language="JavaScript" src="../../eCP/js/common.js"></SCRIPT>
<SCRIPT src="../../eCommon/js/ValidateControl.js" language="javascript"></SCRIPT>
<SCRIPT src="../../eCommon/js/common.js" language="javascript"></SCRIPT>
<SCRIPT language="JavaScript" src="../../eCP/js/ReviseCarePlan.js"></SCRIPT>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
//This file is saved on 18/10/2005.
	String md_care_plan_id=request.getParameter("md_care_plan_id");
	String care_plan_id=request.getParameter("care_plan_id");
	String care_mgr_id=request.getParameter("care_mgr_id");
	String patient_id=request.getParameter("patient_id");
	String encounter_id=request.getParameter("encounter_id");
	String source="md_care_plan_id="+md_care_plan_id+"&care_plan_id="+care_plan_id+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&care_mgr_id="+care_mgr_id;
	
%>

<TITLE><fmt:message key="Common.revise.label" bundle="${common_labels}"/> </TITLE>
	 <iframe name='f_reviseplanrecord_detail' id='f_reviseplanrecord_detail' 	src='../../eCP/jsp/ReviseCarePlanRecordChanges.jsp?<%=source%>' scrolling="auto" frameborder=0 noresize style='height:90vh;width:100vw'></iframe>
	 <iframe name='f_reviseplanrecord_button' id='f_reviseplanrecord_button' 	src='../../eCP/jsp/ReviseCarePlanRecordChangesButton.jsp' scrolling=no frameborder=0 noresize style='height:8vh;width:100vw'></iframe> 
	 <iframe name='messageFrame' id='messageFrame' src='../../eCommon/html/blank.html' scrolling=no frameborder=0 noresize style='height:0%;width:100vw'></iframe> 

</HEAD>
<BODY>
</BODY>
</HTML>

