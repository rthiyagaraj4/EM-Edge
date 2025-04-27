<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="java.sql.Connection, java.util.*, java.text.*, java.sql.*, java.sql.Statement,java.sql.ResultSet,java.util.HashMap" contentType="text/html;charset=UTF-8"%> 
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
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="javascript" src="../../eXH/js/InterfaceUtil.js"></script>
<script language="javascript" src="../../eXH/js/GatewayServer.js"></script>
<script language="javascript" src="../../eXB/js/opIPOBReport.js"></script>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<TITLE></TITLE>

<%
	String resultMessage = XHDBAdapter.checkNull(request.getParameter("message"));
	String statusCode = XHDBAdapter.checkNull(request.getParameter("statuscode"));
	String funcSelected = XHDBAdapter.checkNull(request.getParameter("funcselected"));
	String p_facility_id = (String) session.getValue("facility_id");
	String p_user_name = (String) session.getValue("login_user");
	String sessionID = session.getId();
	String locale = (String)session.getAttribute("LOCALE");
	String dateFormat = "dd/MM/yyyy hh:mm:ss";
	request.setAttribute("jobWhatStr","XBSSINT.E11_BUILDER_OB(");
%>
</HEAD>

<BODY onMouseDown="CodeArrest();" onKeyDown = "lockKey();" onLoad='initFunc()'>
<br>
<%@ include file="../../eXB/jsp/dispJobs.jsp"%>
<%
	String funcDisabled = "";
	if(tempCount > 0) funcDisabled = "DISABLED";
	else resultMessage = "";
%>
<form name="ssMonDPReportForm" id="ssMonDPReportForm" id="ssMonDPReportForm" method='post'>
<table width='80%' align='center' valign='top'>
	<tr>
		<td width="100%" class="Border" align='center'>

			<table width='80%' cellPadding="3" cellSpacing="3" align='center'>				
			<tr></tr>
			<tr>
				<td align='right' width='30%' class="label"><fmt:message key="Common.Function.label" bundle="${common_labels}"/></td>
				<td width='50%'>
					<SELECT name="ssDPFunc" id="ssDPFunc" ID="ssDPFunc" onChange='opdCriteria()' <%= funcDisabled %>>
						<OPTION VALUE="" SELECTED><fmt:message key="Common.Select.label" bundle="${common_labels}"/></OPTION>
						<OPTION VALUE="OPD"><fmt:message key="eXH.OPD_SOC_SEC_PRIV_USAGE_MDB.Label" bundle="${xh_labels}"/></OPTION>
						<OPTION VALUE="IPD"><fmt:message key="eXH.RP_IPD_SOC_SEC_PRIV_USAGE.Label" bundle="${xh_labels}"/></OPTION>						
					</SELECT>
				</td>
			</tr>			
			</table>
		</td>
	</tr>
</table>

<input type='hidden' id='actionParam' name='actionParam' id='actionParam' value='S'>
<input type="hidden" name="opdDate" id="opdDate" id="opdDate">
<input type='hidden' name='custCode' id='custCode' id='custCode' value=''>
<input type="hidden" name="appID" id="appID" id="appID" value="SKREBL">
<input type="hidden" name="protocolLinkID" id="protocolLinkID" id="protocolLinkID" value="SKREBLG1">
<input type="hidden" name="commType" id="commType" id="commType" value="O">
<input type="hidden" name="gatewayServerID" id="gatewayServerID" id="gatewayServerID" value="">
<input type="hidden" name="userName" id="userName" id="userName" value="<%= p_user_name %>">

</form>

<form name="dummyForm" id="dummyForm" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">

<input type='hidden' name='P_FACILITY_ID' id='P_FACILITY_ID' value='<%= p_facility_id %>'>
<input type='hidden' name='p_module_id' id='p_module_id' value='XB'>
<input type='hidden' name='p_report_id' id='p_report_id' value='XBSSIPDRPT_SKR'>
<input type='hidden' name='P_LANGUAGE_ID' id='P_LANGUAGE_ID' id='locale' value='<%= locale %>'>
<input type='hidden' name='P_PERIOD' id='P_PERIOD' id='P_PERIOD' value=''>
<input type='hidden' name='P_CUST_CODE_ONE' id='P_CUST_CODE_ONE' id='P_CUST_CODE_ONE' value=''>
<input type='hidden' name='P_SESSION_ID' id='P_SESSION_ID' id='P_SESSION_ID' value='<%= sessionID %>'>
<input type='hidden' name='P_APPL_USER_ID' id='P_APPL_USER_ID' id='P_APPL_USER_ID' value='<%= p_user_name %>'>

</form>
<input type="hidden" name="resultMessage" id="resultMessage" id="resultMessage" value="<%= resultMessage %>">
<input type="hidden" name="statusCode" id="statusCode" id="statusCode" value="<%= statusCode %>">
<input type="hidden" name="funcSelected" id="funcSelected" id="funcSelected" value="<%= funcSelected %>">

</BODY>
</HTML>

