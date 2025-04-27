<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*,java.lang.*, eMM.*, eMM.Common.* , eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html> 
	<head>
	<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
//locale ="en";
//String primary_lang		= (String)session.getAttribute("PRIMARY_LANG");
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<!-- <script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eMM/js/MmCommon.js"></script>
		<!-- <script language="javascript" src="../../eMM/js/MmMessages.js"></script> -->
		<script language="javascript" src="../../eMM/js/MasterCodeList.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
	</head>
	<%
		
		String bean_id = "ReportsMasterCodeBeanMM";
		String bean_name = "eMM.ReportsMasterCodeBeanMM";
		String p_report_id = "MMBTRDIT";
		String facility_id  =  (String) session.getValue( "facility_id" ) ;
		String user_name  =  (String) session.getValue( "login_user" ) ;
		
		
		ReportsMasterCodeBeanMM bean = (ReportsMasterCodeBeanMM) getBeanObject( bean_id, bean_name, request );
		bean.clear();
		bean.setLanguageId(locale);		
		
	%>
	<body onLoad="FocusFirstElement();">
		<form name="formReportTradeNameForItem" id="formReportTradeNameForItem" action="../../eCommon/jsp/report_options.jsp" target="messageFrame" >
		<br><br>
		<table border="0" cellpadding="0" cellspacing="0" width='100%'  align=center>
			<tr>
			<td width='100%'  class="WHITE">
				<table cellpadding="0" cellspacing="0" width="70%"  border="0" align=center>
								<th colspan=4 >
								<fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>

				<tr>
					<td >&nbsp;</td>
					<td class="fields" >&nbsp;&nbsp;
					<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td >&nbsp;</td>
					<td class="fields"   >&nbsp;&nbsp;
					<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
				<tr>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength="20" size="20" name="p_item_from_code" id="p_item_from_code" value="" ><input class="button" onClick="return searchItem(p_item_from_code,item_from_desc);" type="button" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class=fields>&nbsp;&nbsp;<input maxLength="20" size="20" name="p_item_to_code" id="p_item_to_code" value="" ><input class="button" onClick="return searchItem(p_item_to_code,item_to_desc);" type="button" value="?"></td>
				</tr>
				<tr>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.TradeID.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength="20" size="20" name="p_trade_from_code" id="p_trade_from_code" value="" ><input class="button" onClick="return searchTradeItem(p_trade_from_code,trade_from_desc);" type="button" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class=fields>&nbsp;&nbsp;<input maxLength="20" size="20" name="p_trade_to_code" id="p_trade_to_code" value="" ><input class="button" onClick="return searchTradeItem(p_trade_to_code,trade_to_desc);" type="button" value="?"></td>
				</tr>
				<tr>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
				</tr>
				<tr>
					<td  class="label" ><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/></td>
					<td class=fields colspan='3'>&nbsp;&nbsp;<select name="p_order_by" id="p_order_by">
			<option value='1'><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></option>
		    <option value='2'><fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/></option>
			<option value='3'><fmt:message key="Common.TradeID.label" bundle="${common_labels}"/></option>
			<option value='4'><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></option>
					</select></td>
				</tr>
				<tr>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
					<td >&nbsp;</td>
				</tr>
				</table>
				</td>
				</tr>
			</table>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="item_from_desc" id="item_from_desc" value="" >
			<input type="hidden" name="item_to_desc" id="item_to_desc" value="" >
			<input type="hidden" name="trade_from_desc" id="trade_from_desc" value="" >
			<input type="hidden" name="trade_to_desc" id="trade_to_desc" value="" >
			<input type="hidden" name="p_module_id" id="p_module_id" value="MM">
			<input type="hidden" name="p_report_id" id="p_report_id" value="<%=p_report_id%>">
			<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%=facility_id%>">
			<input type="hidden" name="p_language_id" id="p_language_id" value="<%=locale%>">
			
			
		</form>
		<input type="hidden" name="SQL_MM_ITEM_LOOKUP" id="SQL_MM_ITEM_LOOKUP" value="<%= eMM.Common.MmRepository.getMmKeyValue("SQL_MM_ITEM_LOOKUP")%>">
		<input type="hidden" name="SQL_AM_TRADE_NAME_LOOKUP" id="SQL_AM_TRADE_NAME_LOOKUP" value="<%= eMM.Common.MmRepository.getMmKeyValue("SQL_AM_TRADE_NAME_LOOKUP")%>">
		<%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>

