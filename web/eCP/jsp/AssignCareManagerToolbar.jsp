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
*	Created By		:	Venkatasubbu PR
*	Created On		:	21 Feb 2005
--%>
<html>
<%@page import="java.sql.*, java.io.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
		 //This file is saved on 18/10/2005.
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/AssignCareManager.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 </head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
	<center>
	<form name='AssignCareMgrToolBar' id='AssignCareMgrToolBar'>
	<p align='left'>
	<table border='0' cellpadding='0' cellspacing='0' width='100%' height='100%'>
	<tr align='right'>
	<td>
		<input type='BUTTON' class='BUTTON' name='record' id='record' value=' <fmt:message key="Common.record.label" bundle="${common_labels}"/> ' onClick='return recAssignCareMgr();'>&nbsp;
		<input type='BUTTON' class='BUTTON' name='clear' id='clear' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/> ' onClick='return clrForms()'>
	</td>
	</tr>
	</table>
	</form>
	</body>
	</html>

