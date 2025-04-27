<!DOCTYPE html>
  <!--This file is saved on 07/11/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
<head>
	<%
request.setCharacterEncoding("UTF-8");
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form >
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1">
<tr>
	<td class='FORMULARY' width='2%'>&nbsp;</td>
	<td class='white' >&nbsp;&nbsp;<label style="font-size:9;font-weight:bold"><fmt:message key="ePH.NonFormulary.label" bundle="${ph_labels}"/><fmt:message key="ePH.Drugs.label" bundle="${ph_labels}"/></label></td>
<tr>
</table>
</htmL>

