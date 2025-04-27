<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- Mandatory declarations start --%>
<%@page  import="java.sql.*,java.util.*,webbeans.eCommon.*, eSS.Common.* "contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<jsp:useBean id="bean" scope="page" class="eSS.ReportsMasterCodeBean"/>
<%-- Mandatory declarations end --%>
 <html>
<head>
<%
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	request.setCharacterEncoding("UTF-8");
//	String locale= (String)session.getAttribute("LOCALE");

%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/SsCommon.js"></script>
	<script language="JavaScript" src="../js/OtherReports.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
	//ReportsMasterCodeBean bean = (ReportsMasterCodeBean)getBeanObject( "ReportsMasterCodeBean","eSS.ReportsMasterCodeBean", request ) ;  
%>
<body onload="FocusFirstElement()" onMouseDown="CodeArrest()">

<form name="formSterilizationProcessReport" id="formSterilizationProcessReport" >
<table cellpadding=0 cellspacing=0 width="70%" align="center">
<tr>
	<td colspan="3">&nbsp;</td>
</tr>
<tr>
	<td align="right" class="label" width='35%'><fmt:message key="Common.report.label" bundle="${common_labels}"/></td>
	<td align="left"  colspan="2">&nbsp;<select name="function_id" id="function_id" onchange="loadPage(this.value);">
		<%=bean.getSsRepositoryValue("DEFAULT_LIST_OPTION")%>
		<option value="SS_USER_STORE_LIST"><fmt:message key="eSS.UserAccessforStoreList.label" bundle="${ss_labels}"/></option>
		<option value="SS_TRAY_DETAILS_LIST"><fmt:message key="eSS.TrayDetails.label" bundle="${ss_labels}"/></option>
		<option value="SS_PATIENT_ITEM_LIST"><fmt:message key="eSS.InstrumentsusedforPatientsList.label" bundle="${ss_labels}"/></option>
		<option value="SS_TRAY_VALUE_LIST"><fmt:message key="eSS.TrayValues.label" bundle="${ss_labels}"/></option>
		<option value="SS_DEPT_CHARGES_LIST"><fmt:message key="eSS.DepartmentChargeDetails.label" bundle="${ss_labels}"/></option>
		<option value="SS_CHARGES_SUMMARY_LIST"><fmt:message key="eSS.ChargesSummary.label" bundle="${ss_labels}"/></option>
		<option value="SS_AGEING_ANALYSIS_LIST"><fmt:message key="eSS.AgeingAnalysis.label" bundle="${ss_labels}"/></option>
	</select></td>
</tr>
<tr>
	<td colspan="3">&nbsp;</td>
</tr>
</table>
<input type="hidden" name="function_id_id" id="function_id_id" value="<%=request.getParameter("function_id")%>">
</form>
</body>
</html>

