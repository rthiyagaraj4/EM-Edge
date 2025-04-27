<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*,java.lang.*, eST.*, eST.Common.*,eCommon.Common.*,eMM.Common.MmRepository" contentType="text/html;charset=UTF-8"%>
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
		
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<!--  <link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link> -->
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>	
		<script language="javascript" src="../../eST/js/DrugMedicalItemSalesHistoryReport.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		
		String bean_id = "ReportsStockStatusBean";
		String bean_name = "eST.ReportsStockStatusBean";
		
		
		ReportsStockStatusBean bean = (ReportsStockStatusBean)getBeanObject( bean_id,bean_name,request);  
		String facility_id  =  bean.getLoginFacilityId();
		String user_name  =  bean.getLoginById();
		bean.setLanguageId(locale);
		

	%>
	<body onLoad="FocusFirstElement();">
		<form name="formDrugMedicalItemSalesHistoryReportCriteria" id="formDrugMedicalItemSalesHistoryReportCriteria" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame"  onReset="FocusFirstElement();">
		
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' height='100%'>
			<tr>
			<td width='100%' align='center' valign="top" class="WHITE">
				<table cellpadding="0" cellspacing="5" width="80%" border="0">
				<tr>
					<td colspan=4>&nbsp;</td>
				</tr>
				<tr>
					<td colspan=4>&nbsp;</td>
				</tr>
				<tr>
					<td colspan=4>&nbsp;</td>
				</tr>
				<tr>
					<td colspan=4>&nbsp;</td>
				</tr>
				<tr>
				<th colspan=4 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
				<tr>
				<tr>
					<td colspan=4>&nbsp;</td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<td class=fields><input align="center" type='text'  name='p_patient_id' id='p_patient_id' size=20 value=""  onKeyPress="return CheckForSpecChars(event)" onBlur="return CheckForSpecChars(event)" maxlength="20" ><input valign='top' type='button' name='patient_search' id='patient_search' value='?' class='button'
					onfocus="callPatientLookup();" onClick="callPatientLookup();"></td>
					<td class="label"><fmt:message key="Common.EpisodeType.label" bundle="${common_labels}"/></td>
					<td class=fields><select name="p_episode_type" id="p_episode_type" >
					<option VALUE=""><fmt:message key="Common.all.label" bundle="${st_labels}"/></option>
					<option VALUE="I"><fmt:message key="Common.inpatient.label" bundle="${st_labels}"/></option>
					<option VALUE="O"><fmt:message key="Common.Outpatient.label" bundle="${st_labels}"/></option>
					<option VALUE="D"><fmt:message key="Common.daycare.label" bundle="${st_labels}"/></option>
					<option VALUE="E"><fmt:message key="Common.emergency.label" bundle="${st_labels}"/></option>
					</select></td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="eST.BillingNature.label" bundle="${st_labels}"/></td>
					<td class=fields><select name="p_billing_nature" id="p_billing_nature" onChange="enableCustCode()">
					<option VALUE=""><fmt:message key="Common.Both.label" bundle="${st_labels}"/></option> 
					<option VALUE="C"><fmt:message key="eST.Cash.label" bundle="${st_labels}"/></option>
					<option VALUE="R"><fmt:message key="eST.Credit.label" bundle="${st_labels}"/></option> 				
					</select></td>
					<td class="label"><fmt:message key="Common.CustomerCode.label" bundle="${common_labels}"/></td>
					<td class=fields><input maxLength=8 size=8 name="p_cust_code" id="p_cust_code" value=""  ><input class="button"  onClick="return searchCustomerCode(p_cust_code);" type="button" name="p_cus_code" id="p_cus_code" value="?" ></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td class="label"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td>&nbsp;</td>
					<td class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.StoreCode.label" bundle="${common_labels}"/></td>
					<td class=fields><input maxLength=6 size=6 name="p_frm_store_code" id="p_frm_store_code" value="" ><input class="button"  onClick="return searchCodeStore(p_frm_store_code);" type="button" name="p_fr_sr" id="p_fr_sr" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class=fields><input maxLength=6 size=6  name="p_to_store_code" id="p_to_store_code" value="" ><input class="button" onClick="return searchCodeStore(p_to_store_code);" type="button" name="p_to_sr" id="p_to_sr" value="?"></td>					
				<tr>
					<td  class="label"><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></td>
					<td class=fields><input maxLength=4 size=4 name="p_frm_item_class" id="p_frm_item_class" value=""><input class="button" onClick="return searchCodeItemClass(p_frm_item_class);" type="button" value="?" ></td>
					<td class="label">&nbsp;</td>
					<td class=fields><input maxLength=4 size=4 name="p_to_item_class" id="p_to_item_class" value=""><input class="button" onClick="return searchCodeItemClass(p_to_item_class);" type="button" value="?"></td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
					<td class=fields><input maxLength=20 size=20 name="p_frm_item_code" id="p_frm_item_code" value=""><input class="button" onClick="return searchCodeItem(p_frm_item_code);" type="button" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class=fields><input maxLength=20 size=20 name="p_to_item_code" id="p_to_item_code" ><input class="button" onClick="return searchCodeItem(p_to_item_code);" type="button" value="?"></td>
				</tr>
					
				<tr>
					<td  class="label"><fmt:message key="Common.DocDate.label" bundle="${common_labels}"/></td>
					<td class=fields><input type=text name="p_frm_doc_date" id="p_frm_doc_date" size=10 maxlength=10 class="DATE" value="" onBlur="CheckDate(this);">
					<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_frm_doc_date');" ></img>
					&nbsp;<IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0"  ></IMG> </td>
					<td class="label">&nbsp;</td>
					<td class=fields><input type=text name="p_to_doc_date" id="p_to_doc_date" size=10 maxlength=10 class="DATE" value="" onBlur="CheckDate(this);">
					<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_to_doc_date');" ></img> </td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>
					<td class=fields><select name="p_report_type" id="p_report_type" >
					<option VALUE="STDMISHISUM"><fmt:message key="Common.Summary.label" bundle="${st_labels}"/></option>
					<option VALUE="STDMISHIDET"><fmt:message key="Common.Detail.label" bundle="${st_labels}"/></option>
					</select></td>
					<td class="label">&nbsp;</td>
					<td>&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				</table>
				</td>  
				</tr>
			</table>

			
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="p_module_id" id="p_module_id" 		value="ST">
			<input type="hidden" name="p_report_id" id="p_report_id" value="">
	
			<input type="hidden" name="p_user_name" id="p_user_name"			value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=facility_id%>">
			<input type="hidden" name="p_language_id" id="p_language_id"		value="<%=locale%>">
            <input type="hidden" name="p_entity_id" id="p_entity_id"		value="<%=bean.getAccEntityID()%>">
		
		</form>
		<input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
		<input type="hidden" name="SQL_ST_ITEM_CLASS_LOOKUP_LANG" id="SQL_ST_ITEM_CLASS_LOOKUP_LANG" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_LOOKUP_FOR_REPORT")%>">
		<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")%>">
		<input type="hidden" name="SQL_ST_CUSTOMER_LOOKUP" id="SQL_ST_CUSTOMER_LOOKUP" value="select cust_code code, short_name description from ar_customer where acc_entity_code like ? and upper(cust_code) like upper(?) and upper(short_name) like upper(?)">

           
			 <%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>	

