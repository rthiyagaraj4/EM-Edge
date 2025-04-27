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
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eCP.*, eCommon.Common.*,com.ehis.eslp.* " contentType="text/html; charset=UTF-8"%>
<%@ page language="java" import ="java.sql.*, webbeans.eCommon.*, java.net.* ,java.text.*,eOR.Common.*"%>

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
		
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
      	<SCRIPT language='javascript' src='../../eCommon/js/ValidateControl.js' ></SCRIPT>
      	<SCRIPT language='javascript' src='../../eCommon/js/common.js' ></SCRIPT>
	    <SCRIPT language="JavaScript" src="../../eCP/js/BuildLibrary.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY   onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
		<FORM name="formBuiildLibraryHeader" id="formBuiildLibraryHeader">
		<TABLE border='0' cellspacing='0' cellpadding='0' align='left' width='102%'>
			<TR>
				<TD class="label" width ="19%"><fmt:message key="eCP.Library.label" bundle="${cp_labels}"/></TD>
				<TD align="left">
					&nbsp;<INPUT type="text" name="LibraryDesc" id="LibraryDesc" readonly size="20" maxlength="20"><input class='button' type=button name="libraryLookupButton" id="libraryLookupButton" value="?"  onclick="showLibrary(LibraryDesc)">
					<IMG src="../../eCommon/images/mandatory.gif"></IMG>
				</TD>
				<TD align="left">&nbsp;&nbsp;
					<INPUT type='button' name='preview' id='preview' value='<fmt:message key="Common.Preview.label" bundle="${common_labels}"/>' disabled onClick='Preview()' class='button'>
				</TD>
			</TR>
		</TABLE>	
	  </FORM>
 </BODY>
</HTML>

