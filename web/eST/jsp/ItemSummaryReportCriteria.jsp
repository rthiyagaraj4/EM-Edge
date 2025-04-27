<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,java.lang.*, eST.*, eST.Common.* , eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
<!-- 		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link>
 --><%

request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");

		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- 		<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
<!-- 		<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
		<script language='javascript' src='../../eST/js/ItemSummaryReport.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	</head>
	<%
		
		String bean_id = "ItemSummaryReportBean";
		String bean_name = "eST.ItemSummaryReportBean";
	//	String p_report_id = null;
		String facility_id  =  (String) session.getValue( "facility_id" ) ;
		String user_name  =  (String) session.getValue( "login_user" ) ;
		
		
		ItemSummaryReportBean bean = (ItemSummaryReportBean) getBeanObject( bean_id,bean_name,request);  
		bean.clear();
		bean.setLanguageId(locale);
		
			/**
	 * @Name - Priya
	 * @Date - 07/06/2010
	 * @Inc# - 
	 * @Desc -  To get no of decimals for cost 
	 */
		int noOfDecimalsForCost=Integer.parseInt(bean.getNoOfDecimalsCost());	
		
	%>
	<body onLoad="FocusFirstElement();">
		<form name="formItemSummaryReportCriteria" id="formItemSummaryReportCriteria" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
		<br><br>
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' >
			<tr><td width='100%' align='center' class="WHITE">
				<table cellpadding="0" cellspacing="0" width="98%" align="center" border="0">
				<th colspan=4 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>	
				<tr>
					<td align="right" width="25%">&nbsp;</td>
					<td class="fields" width="25%">&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td align="right" width="15%" >&nbsp;</td>
					<td class="fields" width="35%">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.StoreCode.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_fr_st_code" id="p_fr_st_code" value="" ><input class="button"  onClick="return searchCodeStore(p_fr_st_code);" type="button" name="p_fr_sr" id="p_fr_sr" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=6 size=6  name="p_to_st_code" id="p_to_st_code" value="" ><input class="button" onClick="return searchCodeStore(p_to_st_code);" type="button"  name="p_to_sr" id="p_to_sr" value="?"></td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=20 size=12 name="p_fm_item_code" id="p_fm_item_code" value="" ><input class="button" name="p_fm_sr2" id="p_fm_sr2" onClick="return searchCodeItem(p_fm_item_code);" type="button" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=20 size=12 name="p_to_item_code" id="p_to_item_code" value="" ><input class="button" name="p_to_sr2" id="p_to_sr2" onClick="return searchCodeItem(p_to_item_code);" type="button" value="?"></td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=4 size=6 name="p_fm_item_class" id="p_fm_item_class" value="" ><input class="button" onClick="return searchCodeItemClass(p_fm_item_class);" type="button" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class=fields >&nbsp;&nbsp;<input maxLength=4 size=6 name="p_to_item_class" id="p_to_item_class" value="" ><input class="button" onClick="return searchCodeItemClass(p_to_item_class);" type="button" value="?"></td>
				</tr>
				<tr>
				<td  class="label"><fmt:message key="eST.StockItemValue.label" bundle="${st_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input size="<%=Integer.parseInt(bean.getStRepositoryValue("VALUE_PRECISION"))-3%>" maxlength="<%=bean.getStRepositoryValue("VALUE_PRECISION")%>" class="NUMBER" name="p_fm_item_value" value="" onblur="CheckNum(p_fm_item_value)" onKeyPress="return isValidNumber(this,event,12,<%=noOfDecimalsForCost%>);"></td>
					<td class="label">&nbsp;</td>
					<td class=fields>&nbsp;&nbsp;<input size="<%=Integer.parseInt(bean.getStRepositoryValue("VALUE_PRECISION"))-3%>" maxlength="<%=bean.getStRepositoryValue("VALUE_PRECISION")%>"  name="p_to_item_value" class="NUMBER" value="" onblur="CheckNum(p_to_item_value)" onKeyPress="return isValidNumber(this,event,12,<%=noOfDecimalsForCost%>);"></td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.UnitCost.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input class="NUMBER" size="<%=Integer.parseInt(bean.getStRepositoryValue("VALUE_PRECISION"))-3%>" maxlength="<%=bean.getStRepositoryValue("VALUE_PRECISION")%>" name="p_fm_unit_cost" value="" onblur="CheckNum(p_fm_unit_cost)" onKeyPress="return isValidNumber(this,event,8,<%=noOfDecimalsForCost%>);"> </td>
					<td class="label">&nbsp;</td>
					<td class=fields>&nbsp;&nbsp;<input class="NUMBER" size="<%=Integer.parseInt(bean.getStRepositoryValue("VALUE_PRECISION"))-3%>" maxlength="<%=bean.getStRepositoryValue("VALUE_PRECISION")%>" name="p_to_unit_cost" value="" onblur="CheckNum(p_to_unit_cost)" onKeyPress="return isValidNumber(this,event,8,<%=noOfDecimalsForCost%>);"> </td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="eST.PresentCountStatus.label" bundle="${st_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input class="NUMBER" maxLength=15 size=20 name="p_count_status" id="p_count_status" value="" onblur="CheckNum(p_count_status)"></td>
					<td class="label" nowrap><fmt:message key="eST.DisplayItemQuantity.label" bundle="${st_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;<select name="p_disp_itm_qty_sel" id="p_disp_itm_qty_sel">
					<option value="A"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
					<option value="Z"><fmt:message key="eST.ZeroQuantity.label" bundle="${common_labels}"/></option>
					<option value="N"><fmt:message key="eST.NonZeroquantity.label" bundle="${common_labels}"/></option>
					
					</select></td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="eST.ExpiryItems.label" bundle="${st_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<select name="expiry_item" id="expiry_item" onChange="loadcolumn(expiry_item);" > <%=bean.getExpiryItem()%> 
					</select></td>
					<td class='label' nowrap><fmt:message key="Common.orderBy.label" bundle="${common_labels}" />:
					&nbsp;&nbsp;</td>
					<td class=fields>&nbsp;&nbsp;<select name="p_order_by" id="p_order_by">
					<option value="ID"><fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/></option>
					<option value="IA1"><fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/>&nbsp;1</option>
					<option value="IA2"><fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/>&nbsp;2</option>
					<option value="IA3"><fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/>&nbsp;3</option>
					<option value="ST"><fmt:message key="Common.StoreDescription.label" bundle="${common_labels}"/></option>
									
					</select></td>
				</tr>
			<tr ><td colspan=4>&nbsp;</td></tr>
				<th colspan=4 align=left><fmt:message key="eST.Analysis.label" bundle="${st_labels}"/></th>
			<tr ><td colspan=4>&nbsp;</td></tr>
			<tr>
					<td  class="label" width="25%"><fmt:message key="eMM.ItemAnalysisCode.label" bundle="${mm_labels}"/> 1</td>
					<td class=fields  width="25%">&nbsp;<select name="analysis_code1" id="analysis_code1" onChange="loadcolumn(analysis_code1);" > <%=bean.getItemAnal_code_List()%>
					</select></td>
					<td class="label" width="15%"><fmt:message key="eMM.ItemAnalysisCode.label" bundle="${mm_labels}"/> 2</td>
					<td class=fields   width="35%">&nbsp;&nbsp;<select name="analysis_code2" id="analysis_code2" onChange="loadcolumn(analysis_code2);" > <%=bean.getItemAnal_code_List()%>
					</select></td>
				</tr>
				<tr>
					<td class="label" width="25%"><fmt:message key="eMM.ItemAnalysisCode.label" bundle="${mm_labels}"/> 3</td>
					<td class=fields  width="25%">&nbsp;<select name="analysis_code3" id="analysis_code3" maxLength=4;onChange="loadcolumn(analysis_code3);" > <%=bean.getItemAnal_code_List()%>
					</select></td>
					<td class="label" width="15%"><fmt:message key="eST.ABCAnalysis.label" bundle="${st_labels}"/></td>
					<td class=fields width="35%">&nbsp;&nbsp;<select name="abc_analysis" id="abc_analysis" maxLength=4   onChange="loadcolumn(abc_analysis);" >
					<option value="S"><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option>
					<option value="A"><fmt:message key="eST.A.label" bundle="${st_labels}"/></option>
					<option value="B"><fmt:message key="eST.B.label" bundle="${st_labels}"/></option>
					<option value="C"><fmt:message key="eST.C.label" bundle="${st_labels}"/></option>
					</select></td>
				</tr>
				</table>
				</td>
				</tr>

	</table>	
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="p_module_id" id="p_module_id" 		value="ST">
			<input type="hidden" name="p_report_id" id="p_report_id" 		value="STBPITSM">
			<input type="hidden" name="p_user_name" id="p_user_name"			value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=facility_id%>">
			<input type="hidden" name="p_language_id" id="p_language_id"		value="<%=locale%>">
			
		
		</form>
		<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")%>">
            <input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
			 <input type="hidden" name="SQL_ST_ITEM_CLASS_LOOKUP_LANG" id="SQL_ST_ITEM_CLASS_LOOKUP_LANG" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_LOOKUP_FOR_REPORT")%>">
			 <%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>	

