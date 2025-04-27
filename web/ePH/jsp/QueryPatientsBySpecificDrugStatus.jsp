<!DOCTYPE html>
 <!--This file is saved on 28/10/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.Common.*, ePH.* " %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<html>
	<head>
		<title></title>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="PatientsBySpecificDrugStatus" id="PatientsBySpecificDrugStatus">
	<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1" bordercolor="black" id="patientsbyspecificdrugtable" >
	<tr>
		<td class="white" width="1%" style='background-color:#FF0000;border:none'>&nbsp;&nbsp;</td>
		<td class="white" width="10%"  style="border:none" nowrap><label class="label" style="font-size:9"><b>&nbsp;<fmt:message key="ePH.DirectDispensing.label" bundle="${ph_labels}"/> </b></label></td>
		<td class="white" width="1%" style='background-color:#CC9933;border:none'>&nbsp;&nbsp;</td>
		<td class="white" width="10%" style="border:none" nowrap><label class="label" style="font-size:9"><b>&nbsp;<fmt:message key="ePH.viaOrder.label" bundle="${ph_labels}"/> </b></label></td>
		<td class="white" width="1%" style='background-color:#990000;border:none' >&nbsp;&nbsp;</td>
		<td class="white" width="10%" style="border:none" nowrap><label class="label" style="font-size:9"><b>&nbsp;<fmt:message key="Common.cancelled.label" bundle="${common_labels}"/> </b></label></td>
		<td class="white" width="1%" style='background-color:ADD8E6;border:none' >&nbsp;&nbsp;</td>
		<td class="white" width="10%" style="border:none" nowrap><label class="label" style="font-size:9"><b>&nbsp;<fmt:message key="Common.Discontinued.label" bundle="${common_labels}"/> </b></label></td>
		<td class="white" width="1%" style='background-color:66CCFF;border:none' >&nbsp;&nbsp;</td>
		<td class="white" width="10%" style="border:none" nowrap><label class="label" style="font-size:9"><b>&nbsp;<fmt:message key="ePH.Hold.label" bundle="${ph_labels}"/></b></label></td>
		<td class="white" width="1%" style='background-color:#33CC00;border:none' >&nbsp;&nbsp;</td>
		<td class="white" width="10%" style="border:none" nowrap><label class="label" style="font-size:9" ><b>&nbsp;<fmt:message key="Common.active.label" bundle="${common_labels}"/></b></label></td>
		<td class="white" width="1%" style='background-color:#000099;border:none' >&nbsp;&nbsp;</td>
		<td class="white" width="10%" style="border:none" nowrap><label class="label" style="font-size:9" ><b>&nbsp;<fmt:message key="Common.Inactive.label" bundle="${common_labels}"/></b></label></td>
	</tr>
</table>
</body>
</html> 

