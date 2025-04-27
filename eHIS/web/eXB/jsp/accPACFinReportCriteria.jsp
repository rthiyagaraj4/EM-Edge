<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="eXH.XHUtil,eXH.XHDBAdapter,webbeans.eCommon.ConnectionManager,webbeans.eCommon.*,eXB.*,com.ehis.util.DateUtils,com.ehis.util.FormatterFactory" contentType="text/html;charset=UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>

<%
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eXH/js/InterfaceUtil.js"></script>
<script language="javascript" src="../../eXB/js/accPACReport.js"></script>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<html>
<TITLE></TITLE>

<%
	String loginFacilityID = (String) session.getValue("facility_id");
	String loginUsername = (String) session.getValue("login_user");
	String locale = (String)session.getAttribute("LOCALE");
	String resultMessage = XHDBAdapter.checkNull(request.getParameter("message"));
	request.setAttribute("jobWhatStr","XBSSINT.accpacfin_invdata");
%>
</HEAD>

<BODY onMouseDown="CodeArrest();" onKeyDown="lockKey();" onLoad="initFunc()">
<br>
<%@ include file="../../eXB/jsp/dispJobs.jsp"%>
<form name="accPACCReport" id="accPACCReport" id="accPACCReport" target="reportCriteriaFrame">
<table width='80%' align='center' valign='top'>
	<tr>
		<td width="100%" class="Border" align='center'>

			<table width='80%' cellPadding="3" cellSpacing="3"  align='center'>				
			<tr></tr>
			<tr>
				<td align='right' width='30%' class="label"><fmt:message key="Common.Function.label" bundle="${common_labels}"/></td>
				<td width='50%'>
					<SELECT name="p_report_id" id="p_report_id" ID="p_report_id" STYLE="width: 200px" onChange="changeFunc()">
						<OPTION VALUE="" SELECTED><fmt:message key="Common.Select.label" bundle="${common_labels}"/></OPTION>
						<OPTION VALUE="XBDAILYINVOICE"><fmt:message key="eXH.DAILY_INVOICE.Label" bundle="${xh_labels}"/></OPTION>
						<OPTION VALUE="ACCPACCSV"><fmt:message key="eXH.GEN_ACCPAC_INV_CSV_FILE.Label" bundle="${xh_labels}"/></OPTION>
					</SELECT>
					<img src='../../eCommon/images/mandatory.gif' align='middle'>
				</td>
			</tr>
			<tr>
				<td class='label'><fmt:message key="eXH.ProcessDate.Label" bundle="${xh_labels}"/></td>
				<td class='fields'>
					<input type='text' name='P_DOC_DATE' id='P_DOC_DATE' id='P_DOC_DATE' onBlur="xhAfterNow(this,'DMY')">
					<input type='image' name='showcalndr' id='showcalndr' id="showcalndr" src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('P_DOC_DATE','dd/mm/y');"  >
					<img src='../../eCommon/images/mandatory.gif' align='middle'>
				</td>
			</tr>
			</table>
	</td>
</tr>
</table>

<input type='hidden' name='P_FACILITY_ID' id='P_FACILITY_ID' value='<%= loginFacilityID %>'>
<input type='hidden' name='P_LANGUAGE_ID' id='P_LANGUAGE_ID' id='locale' value='<%= locale %>'>
<input type='hidden' name='p_module_id' id='p_module_id' value='XB'>

</form>
<input type="hidden" name="resultMessage" id="resultMessage" id="resultMessage" value="<%= resultMessage %>">

</BODY>
</HTML>

