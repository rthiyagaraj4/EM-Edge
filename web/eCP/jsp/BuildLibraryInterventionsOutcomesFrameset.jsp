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
*	Created On		:	10 Feb 2005

--%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<HEAD>
<SCRIPT language="JavaScript" src="../../eCP/js/common.js"></SCRIPT>
<SCRIPT language="javascript" src="../../eCommon/js/ValidateControl.js" ></SCRIPT>
<SCRIPT language="javascript" src="../../eCommon/js/common.js"></SCRIPT>
<SCRIPT language="JavaScript" src="../../eCP/js/BuildLibrary.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
		 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		 //This file is saved on 18/10/2005.
	String termSet		=	request.getParameter("termSet");
	String termCode		=	request.getParameter("termCode");
	String goalCode		=	request.getParameter("goalCode");
	String versionno	=	request.getParameter("versionno");
	String libraryid	=	request.getParameter("libraryid");
	String tableName	=	request.getParameter("tableName");
	String source="termSet="+termSet+"&termCode="+termCode+"&goalCode="+goalCode+"&libraryid="+libraryid+"&versionno="+versionno+"&tableName="+tableName+"&alphalink=Associated";
				
%>
<TITLE><fmt:message key="eCP.InterventionsOutcomes.label" bundle="${cp_labels}"/>&nbsp;<fmt:message key="Common.for.label" bundle="${common_labels}"/><%=termCode%> [ <%=termSet%> ]</TITLE>
<iframe name='f__InterventionOutcome_Group' id='f__InterventionOutcome_Group' 	src='../../eCP/jsp/BuildLibraryInterventionOutcomeGroups.jsp?<%=source%>' scrolling="no" frameborder="0" noresize style='height:8%;width:100vw'></iframe>
	 <iframe name='f_Intervention_hyperlink' id='f_Intervention_hyperlink' 	src='../../eCommon/html/blank.html'  scrolling="no" frameborder="0" noresize style='height:9%;width:100vw'></iframe>
	 <iframe name='f_Intervention_detail' id='f_Intervention_detail'		src='../../eCommon/html/blank.html'  scrolling="auto" frameborder="0" noresize style='height:33%;width:100vw'></iframe>
	 <iframe name='f_Outcome_hyperlink' id='f_Outcome_hyperlink'		src='../../eCommon/html/blank.html'  
		scrolling="no" frameborder="0" noresize style='height:9%;width:100vw'></iframe>
	 <iframe name='f_Outcome_detail' id='f_Outcome_detail'		src='../../eCommon/html/blank.html'  scrolling ="no" frameborder="0" noresize style='height:100vh;width:100vw'></iframe>

</HEAD>
<BODY >
</BODY>
</HTML>

