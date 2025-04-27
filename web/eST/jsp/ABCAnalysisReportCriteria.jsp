<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*,java.lang.*, eST.*, eST.Common.* , eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
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
 <link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- 		<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
<!-- 		<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eST/js/ABCAnalysisReport.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		
		String bean_id = "ReportsStockStatusBean";
		String bean_name = "eST.ReportsStockStatusBean";
	//	String p_report_id = null;
		
		
		ReportsStockStatusBean bean = (ReportsStockStatusBean)getBeanObject(bean_id,bean_name,request);  
		String facility_id  =  bean.getLoginFacilityId();
		String user_name  =  bean.getLoginById();
		//bean.clear();
		bean.setLanguageId(locale);
		String stItemAnalysisList	=	bean.getListOptionTag(bean.getListOptionArrayList(eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_ANALYSIS"),locale));
	%>
	<body onLoad="FocusFirstElement();">
		<form name="formABCAnalysisReportCriteria" id="formABCAnalysisReportCriteria" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame"  onReset="FocusFirstElement();">
		
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
					<td class="label"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
					<td colspan=2>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_fm_item_code" id="p_fm_item_code" value="" class="UPPER"><input class="button" onClick="return searchCodeItem(p_fm_item_code);" type="button" value="?"></td>
					<td>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_to_item_code" id="p_to_item_code" class="UPPER"><input class="button" onClick="return searchCodeItem(p_to_item_code);" type="button" value="?"></td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></td>
					<td colspan=2>&nbsp;&nbsp;<input maxLength=4 size=4 name="p_fm_item_class_code" id="p_fm_item_class_code" value="" class="UPPER"><input class="button" onClick="return searchCodeItemClass(p_fm_item_class_code);" type="button" value="?" ></td>
					<td>&nbsp;&nbsp;<input maxLength=4 size=4 name="p_to_item_class_code" id="p_to_item_class_code" value=""  class="UPPER"><input class="button" onClick="return searchCodeItemClass(p_to_item_class_code);" type="button" value="?"></td>
				</tr>
				<tr>
					<td class=label align=left><fmt:message key="Common.AlphaCode.label" bundle="${common_labels}"/></td>
					<td colspan=2>&nbsp;&nbsp;<input type=text name=p_fm_alpha_code size=10 maxlength=10 value="" onKeyPress="return CheckForSpecialChars(event);"></td>
					<td>&nbsp;&nbsp;<input type=text name=p_to_alpha_code size=10 maxlength=10 value="" onKeyPress="return CheckForSpecialChars(event);"></td>
				</tr>
				<!-- Added for ML-MMOH-CRF-1884 -->
				 <tr>
					<td  class="label"><fmt:message key="Common.StoreCode.label" bundle="${common_labels}"/></td>
					<td colspan='2' class=fields>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_fm_store_code" id="p_fm_store_code" value="" class='UPPER'  tabindex='2'><input class="button"  onClick="return searchCodeStore(p_fm_store_code);" type="button" value="?"  tabindex='3'></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_to_store_code" id="p_to_store_code" class="UPPER" tabindex='4'><input class="button" onClick="return searchCodeStore(p_to_store_code);" type="button" value="?"  tabindex='5'></td>
				</tr>
				<!-- End for ML-MMOH-CRF-1884 -->
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td class="label" ><fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/> 1</td>
					<td>&nbsp;&nbsp;<select name="p_item_anal_code_1" id="p_item_anal_code_1" >
					<%=stItemAnalysisList%>
					</select></td>
					<td class="label" ><fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/>2</td>
					<td>&nbsp;&nbsp;<select name="p_item_anal_code_2" id="p_item_anal_code_2" >
					<%=stItemAnalysisList%>
					</select></td>
				</tr>
				<tr>
					<td  class="label" ><fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/> 3</td>
					<td>&nbsp;&nbsp;<select name="p_item_anal_code_3" id="p_item_anal_code_3" >
					<%=stItemAnalysisList%>
					</select></td>
					<td  class="label" ><fmt:message key="eST.ABCCriteria.label" bundle="${st_labels}"/></td>
					<td>&nbsp;&nbsp;<select name="p_abc_criteria" id="p_abc_criteria" onChange="toggleCutOffRange(this);">
						<option value="U"><fmt:message key="Common.UnitCost.label" bundle="${common_labels}"/></option>
						<option value="V"><fmt:message key="Common.Value.label" bundle="${common_labels}"/></option>
						<option value="Q"><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></option>
						<option value=""><fmt:message key="eST.ABCCodeItemMaster.label" bundle="${st_labels}"/></option>
						</select>
					</td>
				</tr>
				<tr>
					<td  class="label" ><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>
					<td colspan=2>&nbsp;&nbsp;<select name="p_report_type" id="p_report_type" >
						<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						<option value="A"><fmt:message key="eST.OnlyA.label" bundle="${st_labels}"/></option>
						<option value="B"><fmt:message key="eST.OnlyB.label" bundle="${st_labels}"/></option>
						<option value="C"><fmt:message key="eST.OnlyC.label" bundle="${st_labels}"/></option>
						</select>
					</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
				<th colspan=4 align=left><fmt:message key="eST.ABCCutoffRange.label" bundle="${st_labels}"/></th>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td class="fields" colspan=2>&nbsp;&nbsp;&nbsp;<fmt:message key="Common.Minimum.label" bundle="${common_labels}"/></td>
					<td class="fields">&nbsp;&nbsp;&nbsp;<fmt:message key="Common.maximum.label" bundle="${common_labels}"/></td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="eST.ForA.label" bundle="${st_labels}"/></td>
					<td colspan=2>&nbsp;&nbsp;<input type='text' name="p_range_low_a" id="p_range_low_a" class="NUMBER" onKeyPress="return isValidNumber(this,event,10,3);" onBlur="checkDoubleFormat(this,false);" size=14 maxlength=14></td>
					<td>&nbsp;&nbsp;<input type='text' name="p_range_high_a" id="p_range_high_a" class="NUMBER" onKeyPress="return isValidNumber(this,event,10,3);" onBlur="checkDoubleFormat(this,false);" size=14 maxlength=14></td>
				</tr>
				<tr>
					<td class="label" ><fmt:message key="eST.ForB.label" bundle="${st_labels}"/></td>
					<td colspan=2>&nbsp;&nbsp;<input type='text' name="p_range_low_b" id="p_range_low_b" class="NUMBER" onKeyPress="return isValidNumber(this,event,10,3);" onBlur="checkDoubleFormat(this,false);" size=14 maxlength=14></td>
					<td>&nbsp;&nbsp;<input type='text' name="p_range_high_b" id="p_range_high_b" class="NUMBER" onKeyPress="return isValidNumber(this,event,10,3);" onBlur="checkDoubleFormat(this,false);" size=14 maxlength=14></td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="eST.ForC.label" bundle="${st_labels}"/></td>
					<td colspan=2>&nbsp;&nbsp;<input type='text' name="p_range_low_c" id="p_range_low_c" class="NUMBER" onKeyPress="return isValidNumber(this,event,10,3);" onBlur="checkDoubleFormat(this,false);" size=14 maxlength=14></td>
					<td>&nbsp;&nbsp;<input type='text' name="p_range_high_c" id="p_range_high_c" class="NUMBER" onKeyPress="return isValidNumber(this,event,10,3);" onBlur="checkDoubleFormat(this,false);" size=14 maxlength=14></td>
				</tr>
				</table>
				</td>  
				</tr>
			</table>

			
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="p_module_id" id="p_module_id" 		value="ST">
			<input type="hidden" name="p_report_id" id="p_report_id" value="STBABCAN">
	
			<input type="hidden" name="p_user_name" id="p_user_name"			value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=facility_id%>">
			<input type="hidden" name="p_language_id" id="p_language_id"		value="<%=locale%>">
           

		</form>
		 <input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
		 <input type="hidden" name="SQL_ST_ITEM_CLASS_LOOKUP_LANG" id="SQL_ST_ITEM_CLASS_LOOKUP_LANG" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_LOOKUP_FOR_REPORT")%>">
		 <input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP"				value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")%>">
	<%putObjectInBean(bean_id,bean,request);%>
	</body>
</html>	

