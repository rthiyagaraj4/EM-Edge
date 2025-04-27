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
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<HEAD>
<SCRIPT language="JavaScript" src="../../eCP/js/common.js"></SCRIPT>
<SCRIPT language="javascript" src="../../eCommon/js/ValidateControl.js"></SCRIPT>
<SCRIPT language="javascript" src="../../eCommon/js/common.js"></SCRIPT>
<SCRIPT language="JavaScript" src="../../eCP/js/ReviseCarePlan.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<TITLE><fmt:message key="eCP.ReviseCareplan.label" bundle="${cp_labels}"/></TITLE>
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String care_plan_id=request.getParameter("care_plan_id");
	String md_care_plan_id=request.getParameter("md_care_plan_id");
	String cp_start_date=request.getParameter("cp_start_date");
	String cp_target_date=request.getParameter("cp_target_date");
	String cp_day_no=request.getParameter("cp_day_no");
	String care_mgr_id=request.getParameter("care_mgr_id");
	String patient_id=request.getParameter("patient_id");
	String encounter_id=request.getParameter("encounter_id");
	String careManagerName=request.getParameter("careManagerName");
	String source="care_plan_id="+care_plan_id+"&md_care_plan_id="+md_care_plan_id+"&cp_start_date="+cp_start_date+"&cp_target_date="+cp_target_date+"&cp_day_no="+cp_day_no+"&patient_id="+patient_id+"&encounter_id="+encounter_id+"&care_mgr_id="+care_mgr_id+"&careManagerName="+careManagerName;
	
;	
%>
	 <iframe name='f_reviseplan_header' id='f_reviseplan_header' 	src='../../eCP/jsp/ReviseCarePlanViewHeader.jsp?<%=source%>' scrolling="no" frameborder=0 noresize style='height:7vh;width:100vw'></iframe>
	 <iframe name='f_reviseplan_detail' id='f_reviseplan_detail' 	src='../../eCP/jsp/ReviseCarePlanViewDetail.jsp?<%=source%>' scrolling="auto" frameborder=0 noresize style='height:80vh;width:100vw'></iframe> 
	 <iframe name='f_reviseplan_button' id='f_reviseplan_button' 	src='../../eCP/jsp/ReviseCarePlanViewButton.jsp?<%=source%>' scrolling=no frameborder=0 noresize style='height:5vh;width:100vw'></iframe> 

</HEAD>
<BODY>
</BODY>
</HTML>

