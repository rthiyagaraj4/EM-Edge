<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- Mandatory declarations start --%>
<%@ page contentType="text/html;charset=UTF-8" import="eSS.*, eSS.Common.*,eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

 <%-- Mandatory declarations end --%>

<html>
<head>
<%
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		request.setCharacterEncoding("UTF-8");
		//String locale= (String)session.getAttribute("LOCALE");

%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/SsCommon.js"></script>
	<script language="JavaScript" src="../js/SterilizationProcessReports.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
	String bean_id					=		"ReportsMasterCodeBean";
	String bean_name				=		"eSS.ReportsMasterCodeBean";
	ReportsMasterCodeBean bean		=		(ReportsMasterCodeBean)getBeanObject( bean_id, bean_name, request ) ;

	String multi_group_type_yn =	bean.getMultiGroupTypeYn();
%>
<body onload="FocusFirstElement()" onMouseDown="CodeArrest()">

<form name="formSterilizationProcessReport" id="formSterilizationProcessReport" >
<table cellpadding=0 cellspacing=0 width="70%" align="center">
<tr>
	<td colspan="3">&nbsp;</td>
</tr>
<tr>
	<td align="right" class="label" width='35%'>		<fmt:message key="Common.report.label" bundle="${common_labels}"/></td>
	<td align="left"  colspan="2">&nbsp;				<select name="function_id" id="function_id" onchange="loadPage(this.value);"><%=bean.getSsRepositoryValue("DEFAULT_LIST_OPTION")%>
		<option value="SS_ROF_LIST">					<fmt:message key="eSS.SterilizationRequestList.label" bundle="${ss_labels}"/></option>
		<option value="SS_PACKING_CHECK_LIST">			<fmt:message key="eSS.PackingCheckList.label" bundle="${ss_labels}"/></option>
		<option value="SS_STERILE_LABEL">				<fmt:message key="eSS.SterileLabel.label" bundle="${ss_labels}"/></option>
		<option value="SS_DISPATCH_LIST">				<fmt:message key="eSS.DispatchList.label" bundle="${ss_labels}"/></option>
		<option value="SS_ACKNOWLEDGEMENT_LIST">		<fmt:message key="eSS.AcknowledgementList.label" bundle="${ss_labels}"/></option>
		<option value="SS_PACK_LABEL">					<fmt:message key="eSS.PackLabel.label" bundle="${ss_labels}"/></option>
		<option value="SS_AUTOCLAVE_LOAD_LIST">			<fmt:message key="eSS.AutoclavingLoadDetails.label" bundle="${ss_labels}"/></option>
		<option value="SS_AUTOCLAVE_WASH_TEST_LIST">	<fmt:message key="eSS.AutoclaveWashUnitTestDetails.label" bundle="${ss_labels}"/></option>
		<option value="SS_AUTOCLAVE_LOAD_SUMM_LIST">	<fmt:message key="eSS.AutoclavingLoadSummary.label" bundle="${ss_labels}"/></option>
		<option value="SS_REQ_ORDER_TRAYS_STATUS_LIST">	<fmt:message key="eSS.RequestOrderTraysStatus.label" bundle="${ss_labels}"/></option>
		<option value="SS_REQ_ORD_TRY_STAT_SUMM_LIST">	<fmt:message key="eSS.RequestOrderTraysStatusSummary.label" bundle="${ss_labels}"/></option>
		<option value="SS_ROF_PROC_TIMING_LIST">		<fmt:message key="eSS.SterilizationRequestProcessTimingDetails.label" bundle="${ss_labels}"/></option>
	<% if (multi_group_type_yn.equalsIgnoreCase("N")) { %>
   	    <option value="SS_PACK_LABEL_6X9">				<fmt:message key="eSS.Pack.label" bundle="${ss_labels}"/>&nbsp;<fmt:message key="eSS.LabelFormat6X9.label" bundle="${ss_labels}"/></option>  <!--ML-MMOH-CRF-621-->
		<option value="SS_PACK_LABEL_3X5">				<fmt:message key="eSS.Pack.label" bundle="${ss_labels}"/>&nbsp;<fmt:message key="eSS.LabelFormat3X5.label" bundle="${ss_labels}"/> <!--ML-MMOH-CRF-621-->
	<% } %>
	</select></td>
</tr>
<tr>
	<td colspan="3">&nbsp;</td>
</tr>
</table>
<input type="hidden" name="function_id_id" id="function_id_id" value="<%=request.getParameter("function_id")%>">
</form>
</body>
<%	 putObjectInBean(bean_id,bean,request);%>
</html>

