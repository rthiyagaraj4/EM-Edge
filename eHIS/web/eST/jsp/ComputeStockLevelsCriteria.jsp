<!DOCTYPE html>
 <%@page import="java.util.*, eST.*, eST.Common.* , eCommon.Common.*, java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<!-- 		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link>
 -->	<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="javascript" src="../../eST/js/ComputeStockLevels.js"></script>
		<script language='javascript' src='../../eST/js/MonthlySummaryReport.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		
		String bean_id = "computeStockLevelsBean";
		String bean_name = "eST.ComputeStockLevelsBean";
		
		
		ComputeStockLevelsBean bean = (ComputeStockLevelsBean) getBeanObject( bean_id,bean_name,request);  
		bean.setLanguageId(locale);
		bean.clear();
		
	%>
	<body onLoad="FocusFirstElement();">
		<form name="formComputeStockLevelsCriteria" id="formComputeStockLevelsCriteria" action="../../eST/jsp/ComputeStockLevelsResult.jsp"  target="frameComputeStockLevelsResult"  onReset="FocusFirstElement();">
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' >
			<tr>
			<td width='100%' align='center' class="WHITE">
				<table cellpadding="0" cellspacing="0"  align="center" border="0" width='100%'>
				
				<tr>
					<td align="right">&nbsp;</td>
					<td class="label" class="label">&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td>&nbsp;</td>
					<td class="label" colspan=2>&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td align="left" class="label"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
					<td >&nbsp;&nbsp;<input maxLength=20 size=20 name="fm_item_code" id="fm_item_code" value="" ><input class="button" name="p_fm_sr2" id="p_fm_sr2" onClick="return searchCodeItem(fm_item_code);" type="button" value="?"></td>
					<td align="right">&nbsp;</td>
					<td colspan=2>&nbsp;&nbsp;<input maxLength=20 size=20  name="to_item_code" id="to_item_code" value="" ><input class="button" name="p_to_sr2" id="p_to_sr2" onClick="return searchCodeItem(to_item_code);" type="button" value="?"></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td align="left" class="label"><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></td>
					<td>&nbsp;&nbsp;<input maxLength=4 size=4 name="fm_item_class_code" id="fm_item_class_code" value="" ><input class="button" onClick="return searchCodeItemClass(fm_item_class_code);" type="button" value="?" name="s1" id="s1"></td>
					<td align="right">&nbsp;</td>
					<td colspan=2>&nbsp;&nbsp;<input maxLength=4 size=4 name="to_item_class_code" id="to_item_class_code" value="" ><input class="button" onClick="return searchCodeItemClass(to_item_class_code);" type="button" value="?" name='s2' id='s2'></td>
					<td>&nbsp;</td>
				</tr>
					<th colspan=6 align=left><fmt:message key="eST.ConsumptionCriteria.label" bundle="${st_labels}"/></th>
			
				<tr>
					<td class=label align=left><fmt:message key="eST.ConsumptionPeriod.label" bundle="${st_labels}"/></td>
					<td>&nbsp;&nbsp;<input type=text name="consumption_period" id="consumption_period" size=4 maxlength=2 class="NUMBER" value="" onKeyPress="return isValidInteger();" ><%=bean.getImage("M")%></td>
					<td class=label align="left"><fmt:message key="eST.LeadDays.label" bundle="${st_labels}"/></td>
					<td class=label>&nbsp;&nbsp;<input type=text name="lead_days" id="lead_days" size=4 maxlength=4 class="NUMBER" value="" onKeyPress="return isValidInteger();"></td>
					<td class=label align="right"><fmt:message key="eST.ExcludeExternalStores.label" bundle="${st_labels}"/>&nbsp;</td>
					<td class=label><input type='checkbox' name='excludeexternalstores' id='excludeexternalstores' value='' onclick="changeVal();"></td>
				</tr>
				<tr>
					<td class=label align=left><fmt:message key="eST.MinStockDays.label" bundle="${st_labels}"/></td>
					<td>&nbsp;&nbsp;<input type=text name="min_stock_days" id="min_stock_days" size=4 maxlength=4 class="NUMBER" value="" onKeyPress="return isValidInteger();" ></td>
					<td class=label align="left"><fmt:message key="eST.BufferPercentage.label" bundle="${st_labels}"/> (<fmt:message key="Common.on.label" bundle="${common_labels}"/> <fmt:message key="eST.MinStock.label" bundle="${st_labels}"/>)</td>
					<td colspan=2>&nbsp;&nbsp;<input type=text name="buffer_percentage" id="buffer_percentage" size=4 maxlength=4 class="NUMBER" value="" onKeyPress="return isValidInteger();" ></td>
					<td align='right'><input type="button" class='button' value='<fmt:message key="Common.Compute.label" bundle="${common_labels}"/>' onClick="searchItems();" name="compute"></td>
				</tr>
				</table>
				</td>  
				</tr>
			</table>

			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="language_id" id="language_id" value="<%=locale%>">
			<input type="hidden" name="p_language_id" id="p_language_id" value="<%=locale%>">
			<input type="hidden" name="mode" id="mode"		value="2">
			<input type="hidden" name="function_id" id="function_id"		value="<%=request.getParameter("function_id")%>">

			<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP")%>">
            <input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
			<input type="hidden" name="SQL_ST_ITEM_CLASS_LOOKUP_LANG" id="SQL_ST_ITEM_CLASS_LOOKUP_LANG" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_LOOKUP_FOR_REPORT")%>">

		</form>
		<%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>	

