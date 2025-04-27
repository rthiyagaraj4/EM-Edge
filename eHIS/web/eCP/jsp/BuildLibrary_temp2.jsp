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
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<HEAD>
<SCRIPT language="JavaScript" src="../../eCP/js/common.js"></SCRIPT>
<SCRIPT src="../../eCommon/js/ValidateControl.js" language="javascript"></SCRIPT>
<SCRIPT src="../../eCommon/js/common.js" language="javascript"></SCRIPT>
<SCRIPT language="JavaScript" src="../../eCP/js/BuildLibrary.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<TITLE><fmt:message key="Common.Preview.label" bundle="${common_labels}"/></TITLE>
<%
//This file is saved on 18/10/2005.
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String versionno=request.getParameter("versionno");
	String libraryid=request.getParameter("libraryid");
	String source="libraryid="+libraryid+"&versionno="+versionno;
		
%>
<iframe name='f_Detail_header' id='f_Detail_header' 	src='../../eCP/jsp/BuildLibrary_temp1.jsp?<%=source%>' scrolling="auto" frameborder=0 noresize style='height:100vh;width:100vw'></iframe>
	 <iframe name='f_Close_window' id='f_Close_window' 	src='../../eCommon/html/blank.html' scrolling=no frameborder=0 noresize style='height:40%;width:100vw'></iframe>
	  

</HEAD>
<BODY>
</BODY>
</HTML>

