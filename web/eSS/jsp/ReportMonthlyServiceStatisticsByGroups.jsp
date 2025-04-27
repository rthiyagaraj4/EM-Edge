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
<%-- Mandatory declarations end --%>
<html>
<head>
	

<%
	String sStyle	= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	request.setCharacterEncoding("UTF-8");
	String locale	= (String)session.getAttribute("LOCALE");

%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eSS/js/MonthlyServiceStatisticsByGroupsReport.js"></script>
	<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onLoad="FocusFirstElement();"onMouseDown='CodeArrest();'>
<%

		SsTransaction bean = (SsTransaction) getBeanObject( "ssTransaction", "eSS.Common.SsTransaction",  request );
		bean.clear() ;
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
%>
		
<form name="formMonthlyServiceStatisticsByGroupsReport" id="formMonthlyServiceStatisticsByGroupsReport" onReset="FocusFirstElement();" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame">
	<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center'  height='100%'>
	<tr>
	<td width='100%' align='center'  class="WHITE">
	<table border="0" cellpadding="1" cellspacing="0" width='75%' align='center'>
	<tr><th colspan='4' align='left'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th></tr>
	<tr><td colspan='4'>&nbsp;</td></tr>
	<tr>
		<td>&nbsp;</td>
		<td class='LABEL'>&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
		<td class='LABEL'>&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td class='label' align='right'><fmt:message key="eSS.DocDate.label" bundle="${ss_labels}"/></td>
		<td class='label'>&nbsp;&nbsp;<input onBlur="CheckDate(this,'<%=locale%>');" type='text' maxLength='10' size='10' name="p_fm_doc_date1" id="p_fm_doc_date1">&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_fm_doc_date1');"></img></td>
		<td class='label'>&nbsp;&nbsp;<input onBlur="CheckDate(this,'<%=locale%>');" type='text' maxLength='10' size='10' name="p_to_doc_date1" id="p_to_doc_date1">&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_to_doc_date1');"></img></td>
		<td class='label'>&nbsp;</td>
	</tr>
	<tr><td colspan='4'>&nbsp;</td></tr>
	<tr>
		<td align="right" class="label" nowrap><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
		<td class=label>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_fm_store_code" id="p_fm_store_code" value="" ><input class="button" onClick="return searchCodeRequestBy(p_fm_store_code);" type="button" value="?"></td>
		
		<td class=label>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_to_store_code" id="p_to_store_code" value="" ><input class="button" onClick="return searchCodeRequestBy(p_to_store_code);" type="button" value="?"></td>
		<td class="label">&nbsp;</td>
	</tr>
	<tr><td colspan='4'>&nbsp;</td></tr>
	<tr>
		<td align="right" class="label"><fmt:message key="eSS.GroupCode.label" bundle="${ss_labels}"/></td>
		<td class=label>&nbsp;&nbsp;<input maxLength=10 size=10 name="P_fm_group_code" id="P_fm_group_code" value="" ><input class="button" onClick="return searchCodeGroupMaster(P_fm_group_code);" type="button" value="?"></td>
		
		<td class=label>&nbsp;&nbsp;<input maxLength=10 size=10 name="P_to_group_code" id="P_to_group_code" value="" ><input class="button" onClick="return searchCodeGroupMaster(P_to_group_code);" type="button" value="?"></td>
		<td class="label">&nbsp;</td>
	</tr>
	<tr><td colspan='4'>&nbsp;</td></tr>
	

	</table>
	</td>
	</tr>
	</table>
	<input type="hidden" name="function_id" id="function_id"								value="<%=bean.getFunctionId()%>">
	<input type="hidden" name="p_module_id" id="p_module_id" 							value="SS">
	<input type="hidden" name="p_report_id" id="p_report_id" 							value="SSBMSSBG">
	<input type="hidden" name="p_fm_doc_date" id="p_fm_doc_date" 							value="">
	<input type="hidden" name="p_to_doc_date" id="p_to_doc_date" 							value="">
	<input type="hidden" name="p_user_name" id="p_user_name"								value="<%=bean.getLoginById()%>">
	<input type="hidden" name="p_facility_id" id="p_facility_id"							value="<%=bean.getLoginFacilityId()%>">
	<input type="hidden" name="locale" id="locale"									value="<%=locale%>">
	<input type="hidden" name="SQL_SS_STORE_REQ_SELECT_LIST_LOOKUP" id="SQL_SS_STORE_REQ_SELECT_LIST_LOOKUP"		value="<%= eSS.Common.SsRepository.getSsKeyValue("SQL_SS_STORE_REQ_SELECT_LIST_LOOKUP")%>">
	<input type="hidden" name="SQL_SS_GROUP_LOOKUP" id="SQL_SS_GROUP_LOOKUP"						value="<%= eSS.Common.SsRepository.getSsKeyValue("SQL_SS_GROUP_LOOKUP")%>">
<%
putObjectInBean("ssTransaction",bean,request); 
%>
</form>
</body>
</html>

