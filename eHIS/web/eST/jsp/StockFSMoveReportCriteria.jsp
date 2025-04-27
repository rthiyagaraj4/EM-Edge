<!DOCTYPE html>
<%
/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
??
22/09/2017							Soorya Prakash M							ML-MMOH-CRF-0916
---------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,java.lang.*, eST.*, eST.Common.* , eCommon.Common.*"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
	<%

request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");

		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- 		<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
<!-- 		<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eST/js/StockFSMovementReport.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		
		String bean_id = "reportStockFSMoveBean";
		String bean_name = "eST.ReportStockFSMoveBean";
		//String p_report_id = null;
		
		
		ReportStockFSMoveBean bean= (ReportStockFSMoveBean) getBeanObject( bean_id, bean_name, request );
		String facility_id  =  bean.getLoginFacilityId();
		String user_name  =  bean.getLoginById();
		//bean.clear();
		bean.setLanguageId(locale);
	%>
	<body onLoad="FocusFirstElement();">
		<form name="formStockFSMoveReportCriteria" id="formStockFSMoveReportCriteria" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame"  onReset="FocusFirstElement();">
		
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' height='100%'>
			<tr>
			<td width='100%' align='center' class="WHITE">
				<table cellpadding="0" cellspacing="0" width="80%" align="center" border="0">
				<th colspan=4 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
				
				<tr>
					<td>&nbsp;</td>
					<td class="fields" colspan=2>&nbsp;&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td class="fields">&nbsp;&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
				<tr>
				<td class='label' align='left'><fmt:message key="Common.ReportOption.label" bundle="${common_labels}"/></td>
				<td colspan=2 class=fields>&nbsp;&nbsp;<select name="p_rep_option" id="p_rep_option" onchange="disRange(this);"><option  value='A'><fmt:message key="eST.AllItems.label" bundle="${st_labels}"/></option>
				<option  value='Q'><fmt:message key="eST.ByQuantity.label" bundle="${st_labels}"/></option>
				<option  value='V'><fmt:message key="eST.ByValue.label" bundle="${st_labels}"/></option>
				<option  value='N'><fmt:message key="eST.NoMovement.label" bundle="${st_labels}"/></option></select></td>
				<td class=label>&nbsp;</td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="Common.StoreCode.label" bundle="${common_labels}"/></td>
					<td colspan=2>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_fm_store_code" id="p_fm_store_code" value="" class="UPPER"><input class="button" onClick="return searchCodeStore(p_fm_store_code);" type="button" value="?">
					</td>
					<td >&nbsp;&nbsp;<input maxLength=6 size=6 name="p_to_store_code" id="p_to_store_code" class="UPPER"><input class="button" onClick="return searchCodeStore(p_to_store_code);" type="button" value="?"></td>

					
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
					<td colspan=2>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_fm_item_code" id="p_fm_item_code" value="" class="UPPER"><input class="button" onClick="return searchCodeItem(p_fm_item_code);" type="button" value="?"></td>
					<td>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_to_item_code" id="p_to_item_code" class="UPPER"><input class="button" onClick="return searchCodeItem(p_to_item_code);" type="button" value="?"></td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></td>
					<td colspan=2>&nbsp;&nbsp;<input maxLength=4 size=4 name="p_fm_item_class_code" id="p_fm_item_class_code" value="" class="UPPER"><input class="button" onClick="return searchCodeItemClass(p_fm_item_class_code);" type="button" value="?" ></td>
					<td>&nbsp;&nbsp;<input maxLength=4 size=4 name="p_to_item_class_code" id="p_to_item_class_code" value=""  class="UPPER"><input class="button" onClick="return searchCodeItemClass(p_to_item_class_code);" type="button" value="?"></td>
				</tr>
				<tr>
					<td class=label ><fmt:message key="Common.AlphaCode.label" bundle="${common_labels}"/></td>
					<td colspan=2>&nbsp;&nbsp;<input type=text name=p_fm_alpha_code size=10 maxlength=10 value="" onKeyPress="return CheckForSpecialChars(event);"></td>
					<td>&nbsp;&nbsp;<input type=text name=p_to_alpha_code size=10 maxlength=10 value="" onKeyPress="return CheckForSpecialChars(event);"></td>
				</tr>
				<tr>
					<td class=label ><fmt:message key="Common.Range.label" bundle="${common_labels}"/></td>
					<td colspan=2>&nbsp;&nbsp;<input class='number' type=text name=p_fm_value   value="" onkeypress="return isValidNumber(this,event,9,0);"></td>
					<td>&nbsp;&nbsp;<input type=text class='number' 
					  name=p_to_value value="" onkeypress="return isValidNumber(this,event,9,0);"></td>
				</tr>
				<tr>
					<td class=label ><fmt:message key="eST.AccountingPeriod.label" bundle="${st_labels}"/></td>
					<td colspan=2>&nbsp;&nbsp;<input class='number' type=text name=p_fm_month size=1 maxlength=2 value="" onBlur="chkMonth(p_fm_month)" onkeypress="return isValidNumber(this,event,3,0);">/<input class='number' type=text name=p_fm_year size=4 maxlength=4 value=""  onkeypress="return isValidNumber(this,event,4,0);"></td>
					<td>&nbsp;&nbsp;<input type=text class='number' name=p_to_month size=1 maxlength=2 value="" onBlur="chkMonth(p_to_month)" onkeypress="return isValidNumber(this,event,3,0);">/<input type=text class='number' name=p_to_year size=4 maxlength=4  value="" onkeypress="return isValidNumber(this,event,4,0);"></td>
				</tr>
				<tr>
				<td class=label><fmt:message key="Common.ReportOrder.label" bundle="${common_labels}"/></td>
				<td colspan=2>&nbsp;&nbsp;<select name="p_order_option" id="p_order_option" ><option  value='I'><fmt:message key="eST.ItemConsolidated.label" bundle="${st_labels}"/></option>
<option  value='S'><fmt:message key="eST.ByStore.label" bundle="${st_labels}"/></option>
</select></td>
				<td class=label>&nbsp;</td>
				</tr>
				
			<!--  Added for ML-MMOH-CRF-0916-->	
				<tr>
				
				<td class=label><fmt:message key="Common.SortOrder.label" bundle="${common_labels}"/></td>
				<td colspan=2>&nbsp;&nbsp;<select name="p_sort_order" id="p_sort_order" >
<option  value='D'><fmt:message key="eST.Descending.label" bundle="${st_labels}"/></option>
<option  value='A'><fmt:message key="eST.Ascending.label" bundle="${st_labels}"/></option>
</select></td>
 <td class=label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
				</tr>
				<!--  Ends for ML-MMOH-CRF-0916-->	
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			</table>

			
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="p_module_id" id="p_module_id" 		value="ST">
			<input type="hidden" name="p_report_id" id="p_report_id" value="">
			<input type="hidden" name="p_order_by" id="p_order_by" value="">
			<input type="hidden" name="p_sort" id="p_sort" value=""> <!--  Added for ML-MMOH-CRF-0916-->	
			<input type="hidden" name="p_user_name" id="p_user_name"			value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=facility_id%>">
			<input type="hidden" name="p_fm_year_month" id="p_fm_year_month"		value="">
			<input type="hidden" name="p_to_year_month" id="p_to_year_month"		value="">
			<input type="hidden" name="p_language_id" id="p_language_id"		value="<%=locale%>">
           

		</form>
		 <input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
			 <input type="hidden" name="SQL_ST_ITEM_CLASS_LOOKUP_LANG" id="SQL_ST_ITEM_CLASS_LOOKUP_LANG" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_LOOKUP_FOR_REPORT")%>">
			 <input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")%>">
			 <%
putObjectInBean(bean_id,bean,request);
%>
	</body>
	<script>
		disRange(document.formStockFSMoveReportCriteria.p_rep_option);
	</script>
</html>	

