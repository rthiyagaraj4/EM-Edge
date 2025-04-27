<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%
<%-- JSP Page specific attributes start --%>
<%@ page language="java" import ="java.sql.*, webbeans.eCommon.*, com.ehis.eslp.* ,java.net.*" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- jsp:useBean id="mh" scope="session" class="CommonMultipleHandler" --%>
<%-- To call the Common MultipleHandler where the id will be as mh--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%-- Mandatory declarations end --%>

<HTML>
  <HEAD>
<%
//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>	
	<SCRIPT language="JavaScript" src="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT language="javascript" src="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT language="JavaScript" src="../../eCP/js/LibrarySetUp.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

  </HEAD>
  <BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<FORM name="LibraryDetailTabsForm" id="LibraryDetailTabsForm" >

	<!-- Table to display the tabs -->
<TABLE cellpadding="1" cellspacing=0 width="90%" align="center" border="0" id="tabsTable">
<TR>
		<TD class="CASECONDSELECTHORZ" align="center" nowrap>
			<a class="MENUHIGHERLEVELLINK" ><B><fmt:message key="Common.Characteristics.label" bundle="${common_labels}"/><B></a>
		</TD>
</TR>
	<TR>
		<TD class="CASECONDSELECTHORZ" align="center" 	onClick="changeButtonColor(this,'CP_BUTTONS');Display('VersionDetails')" nowrap>
			<a class="MENUHIGHERLEVELLINK" style="color:white;cursor:pointer" ><fmt:message key="eCP.VersionDetails.label" bundle="${cp_labels}"/></a>
		</TD>
		<TD class="CAFIRSTSELECTHORZ" align="center" onClick="changeButtonColor(this,'CP_BUTTONS');Display('PatientClass')"  nowrap>
			<a class="MENUHIGHERLEVELLINK" style="color:white;cursor:pointer"><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></a>
		</TD>
		<TD class="CAFIRSTSELECTHORZ" align="center" onClick="changeButtonColor(this,'CP_BUTTONS');Display('AgeGroup')" nowrap>
			<a class="MENUHIGHERLEVELLINK" style="color:white;cursor:pointer"><fmt:message key="Common.agegroup.label" bundle="${common_labels}"/></a>
		</TD>
	</TR>
</TABLE>
<BR>
</FORM>
</BODY>
</HTML>

