<!DOCTYPE html>
 <%@page  import="java.sql.*, java.util.*, java.io.*, ePH.Common.*, ePH.*" contentType="text/html;charset=UTF-8"%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<!-- 
Developed by	:Pushkala.B
Module/Function : Reconstituent Fluid for Drug
-->

<html>
<head>
	<title><fmt:message key="ePH.StabilityInformation.label" bundle="${ph_labels}"/></title>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<!--<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/messages.js"></SCRIPT>-->
	<SCRIPT LANGUAGE="javascript" SRC="../js/PHReports.js"></SCRIPT>
	<!--<SCRIPT LANGUAGE="javascript" SRC="../js/PHmessages.js"></SCRIPT>-->
	<script language="javascript" src="../../ePH/js/RFD_1.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<!-- <body > -->
<body onMouseDown="" onKeyDown="lockKey()">
<form name="RFDSUBINFO" id="RFDSUBINFO">
<table cellpadding="0" cellspacing="0" width="90%" align="center" border="0">
<tr>
<td>
	<textarea id="RFDINFO"  rows=8 cols=30 maxLength=200 ></textarea>
</td>
</tr>
<tr>
	<td colspan="2" align="center"><input type=button value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' class="Button" onClick="clickOK();"><input type=button value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>'  class="Button" onClick="clickClose();"></td>
</tr>
</table>
<script>loadInfo()</script>
</form>
</body>
</html>

