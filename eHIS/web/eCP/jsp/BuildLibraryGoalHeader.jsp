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
*	Created On		:	10 Feb 2005

--%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eCP.*, eCommon.Common.*,com.ehis.eslp.* " contentType="text/html; charset=UTF-8"%>
<%@ page language="java" import ="java.sql.*, webbeans.eCommon.*, java.net.* ,java.text.*,eOR.Common.*,eCommon.XSSRequestWrapper"%>


<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %> 
<%-- Mandatory declarations end --%>
<HTML>
<HEAD>
		<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
		<%
		//This file is saved on 18/10/2005.
		 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
      	<SCRIPT language='javascript' src='../../eCommon/js/ValidateControl.js' ></SCRIPT>
      	<SCRIPT language='javascript' src='../../eCommon/js/common.js' ></SCRIPT>
		<SCRIPT language="javascript" src="../js/BuildLibrary.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	 </HEAD>
 <BODY onKeyDown = 'lockKey()' OnMouseDown="CodeArrest()">
<FORM name="formBuildLibraryGoal" id="formBuildLibraryGoal">
<%
String termSet		=	request.getParameter("termSet");
String termDesc		=	request.getParameter("termDesc");
%>
	<TABLE border='0' cellspacing='0' cellpadding='0' align='center' width='102%'>
		<TR><TD colspan="2">&nbsp;
		</TR>
		<TR>
			<TD class="label" width="20%" align="right"><fmt:message key="Common.TerminologySet.label" bundle="${common_labels}"/></TD>
			<TD class="label" align="left"><B><%=termSet%></B></TD>
		</TR>
		<TR>
			<TD class="label" align="right"><fmt:message key="Common.TerminologyCode.label" bundle="${common_labels}"/></TD>
			<TD class="label" align="left"><B><%=termDesc%></B></TD>
		</TR>
		<TR><TD colspan="2">&nbsp;</TR>
	</TABLE>
</FORM>
</BODY>
</HTML>

