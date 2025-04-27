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
*	Created By		:	Sandhya
*	Created On		:	02 Feb 2005

--%>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<HEAD>
	<LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT language="javascript" src="../js/TermCodeLookup.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
<TITLE><fmt:message key="eCP.TerminologyCodeSearch.label" bundle="${cp_labels}"/></TITLE>
	</HEAD>
	<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	//This file is saved on 18/10/2005.
	String libraryid=request.getParameter("libraryid");
	String versionno=request.getParameter("versionno");
	String source="libraryid="+libraryid+"&versionno="+versionno;
	%>
	<iframe name="TermcodeLookup_header" id="TermcodeLookup_header" FRAMEBORDER="0" SCROLLING="auto" NORESIZE  SRC="../../eCP/jsp/TermCodeLookupCriteria.jsp?<%=source%>" style="height:27vh;width:100vw"></iframe>
	<iframe name="TermcodeLookup_hyperlink" id="TermcodeLookup_hyperlink" FRAMEBORDER="0" SCROLLING="no" NORESIZE SRC="../../eCommon/html/blank.html" style="height:8vh;width:100vw">
	</iframe><iframe name="TermcodeLookup_details" id="TermcodeLookup_details" FRAMEBORDER="0" SCROLLING="auto" NORESIZE SRC="../../eCommon/html/blank.html" style="height:65vh;width:100vw"></iframe>
	 <BODY>
	 </BODY>
</HTML>

