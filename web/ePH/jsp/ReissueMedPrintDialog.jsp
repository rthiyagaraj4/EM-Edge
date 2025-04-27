<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<HTML>
<HEAD>	
	<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<script language="JavaScript" src="../../ePH/js/ReissueMed.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<title><fmt:message key="Common.internalreport.label" bundle="${common_labels}"/></title>
</HEAD>
<!-- <body> -->
<body onMouseDown="" onKeyDown="lockKey()">
<form name="ReissueMedPrintDialog" id="ReissueMedPrintDialog">
<table cellpadding="0" cellspacing="0" width="100%"  >
		<tr><td class="white" colspan="3"></td></tr>
		<tr><td class="white" colspan="3"></td></tr>
		<tr><td class="label"></td>
			<td class="label"><fmt:message key="ePH.DispenseLabel.label" bundle="${ph_labels}"/> </td>
			<td class="label"><input type="checkbox" name="disp_label" id="disp_label" checked></td>	
		</tr>
		<tr><td class="white" colspan="3"></td></tr>
		<tr><td class="white" colspan="3"></td></tr>
		<tr>
			<td align="center" colspan="3" class="white"><input type="button" class="button" value="OK" onClick="printOnlineDispense(document.ReissueMedPrintDialog)">
		   <input type="button" class="button" value="Cancel" onClick="parent.parent.document.getElementById('dialog_tag').close();">
		</td>
	  </tr>
	  <input type="hidden" name="language_id" id="language_id" value="<%=locale%>">
</table>
</form>

