<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,java.sql.*,java.lang.*, eST.*, eST.Common.* , eCommon.Common.*,webbeans.eCommon.*"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
		
<%

		request.setCharacterEncoding("UTF-8");
		String locale			=		(String)session.getAttribute("LOCALE");
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eST/js/DrugStockStatusReport.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		
		String bean_id					=		"DrugStockStatusReportBean";
		String bean_name				=		"eST.DrugStockStatusReportBean";		
		String facility_id				=		(String) session.getValue( "facility_id" ) ;
		String user_name				=		(String) session.getValue( "login_user" ) ;
				
		
		DrugStockStatusReportBean bean = (DrugStockStatusReportBean) getBeanObject( bean_id,  bean_name, request );  
		bean.clear();
		bean.setLanguageId(locale);
		
	%>
	<body onLoad="FocusFirstElement()">
		<form name="DrugStockStatusReportCriteria_form" id="DrugStockStatusReportCriteria_form" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
		<br><br>
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' >
			<tr>
			<td width='100%' align='center' class="WHITE">
				<table cellpadding="0" cellspacing="0" width="98%" align="center" border="0">
				<th colspan=8 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
				
	
				<tr>
					<td align="right">&nbsp;</td>
					<td  class="fields">&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td align="right" >&nbsp;</td><td class="label">&nbsp;</td>
					<td  class="fields" colspan=5 width"10%">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td><td class="label">&nbsp;</td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.StoreCode.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_fr_st_code" id="p_fr_st_code"  value="" ><input class="button" name="p_fr_sr" id="p_fr_sr" onClick="return searchCodeStore(p_fr_st_code);"  type="button" value="?"></td>
					<td class="label">&nbsp;</td><td class="label">&nbsp;</td>
					<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_to_st_code" id="p_to_st_code" value="" ><input class="button" name="p_to_sr" id="p_to_sr" onClick="return searchCodeStore(p_to_st_code);"  type="button" value="?" ></td>
				</tr>
				
				<tr>
					<td  class="label"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=20 size=20  name="p_fm_item_code" id="p_fm_item_code" value="" ><input class="button" name="p_fm_sr2" id="p_fm_sr2" onClick="return searchCodeItem(p_fm_item_code);" type="button" value="?"></td>
					<td class="label">&nbsp;</td><td class="label">&nbsp;</td>
					<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_to_item_code" id="p_to_item_code" value="" ><input class="button" name="p_to_sr2" id="p_to_sr2" onClick="return searchCodeItem(p_to_item_code);" type="button" value="?"  ></td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=4 size=4 name="p_fr_item_class" id="p_fr_item_class" value="" ><input class="button" onClick="return searchCodeItemClass(p_fr_item_class);" type="button" value="?"></td>
					<td class="label">&nbsp;</td><td class="label">&nbsp;</td>
					<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=4 size=4 name="p_to_item_class" id="p_to_item_class" value="" ><input class="button" onClick="return searchCodeItemClass(p_to_item_class);" type="button" value="?"></td>
				</tr>
				<tr>
					<td class="label" ><fmt:message key="Common.AlphaCode.label" bundle="${common_labels}"/></td>
					<td class="fields">&nbsp;&nbsp;<input name="p_fr_alpa_code" id="p_fr_alpa_code" size=10 maxlength=10 value="" onKeyPress="return CheckForSpecialChars(event);"></td>
					<td class="label">&nbsp;</td><td class="label">&nbsp;</td>
					<td class="fields" colspan=5>&nbsp;&nbsp;<input name="p_to_alpa_code" id="p_to_alpa_code" size=10 maxlength=10 value="" onKeyPress="return CheckForSpecialChars(event);"></td>
				</tr>
				<tr>
		
					<td  class="label"><fmt:message key="eMM.ItemAnalysisCode.label" bundle="${common_labels}"/> 1</td>
					<td class=fields>&nbsp;&nbsp;<select name="analysis_code1_from" id="analysis_code1_from" > <%=bean.getItemAnal_code_List()%>
					</select></td>
					<td class="label">&nbsp;</td>
					<td class="label"><fmt:message key="eMM.ItemAnalysisCode.label" bundle="${common_labels}"/> 1</td>
					<td class=fields>&nbsp;&nbsp;<select name="analysis_code1_to" id="analysis_code1_to"  > <%=bean.getItemAnal_code_List()%>
					</select></td>
				</tr>
				<tr>
		
					<td  class="label"><fmt:message key="eMM.ItemAnalysisCode.label" bundle="${common_labels}"/> 2</td>
					<td class=fields>&nbsp;&nbsp;<select name="analysis_code2_from" id="analysis_code2_from" > <%=bean.getItemAnal_code_List()%>
					</select></td>
					<td class="label">&nbsp;</td>
					<td class="label"><fmt:message key="eMM.ItemAnalysisCode.label" bundle="${common_labels}"/> 2</td>
					<td class=fields>&nbsp;&nbsp;<select name="analysis_code2_to" id="analysis_code2_to" > <%=bean.getItemAnal_code_List()%>
					</select></td>
				</tr>
				<tr>
		
					<td  class="label"><fmt:message key="eMM.ItemAnalysisCode.label" bundle="${common_labels}"/> 3</td>
					<td class=fields>&nbsp;&nbsp;<select name="analysis_code3_from" id="analysis_code3_from"  > <%=bean.getItemAnal_code_List()%>
					</select></td>
					<td class="label">&nbsp;</td>
					<td class="label"><fmt:message key="eMM.ItemAnalysisCode.label" bundle="${common_labels}"/> 3</td>
					<td class=fields>&nbsp;&nbsp;<select name="analysis_code3_to" id="analysis_code3_to" > <%=bean.getItemAnal_code_List()%>
					</select></td>
				</tr>
                <tr>
					<td  class="label" align=right ><fmt:message key="eST.StockLevel.label" bundle="${st_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;<select name='stock_level' id='stock_level'>
					<option value="A"  ><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
					<option value="S"  ><fmt:message key="eST.StockOnHand.label" bundle="${st_labels}"/></option>
					<option value="Z"  ><fmt:message key="eST.ZeroStock.label" bundle="${st_labels}"/></option>
					<option value="B"  ><fmt:message key="eST.BelowRe-OrderLevel.label" bundle="${st_labels}"/></option>
					</select>
					</td>
				</tr>
				<tr>
					<td align="right"  class="label" ><fmt:message key="eST.StockItem.label" bundle="${st_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;<select name='stock_item' id='stock_item'>
					<option value="B"  ><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
					<option value="Y"  ><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
					<option value="N"  ><fmt:message key="Common.no.label" bundle="${common_labels}"/></option>
					</select>
					</td>
				</tr>
				<tr>
					<td class=label align=right><fmt:message key="eST.SortOrderBy.label" bundle="${st_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;<select name="p_order_by" id="p_order_by" >
					<option  value='IC'><fmt:message key="eST.ByItemCode.label"  bundle="${st_labels}"/></option>
					<option  value='SD'><fmt:message key="eST.ByShortDescription.label"  bundle="${st_labels}"/></option>
					<option  value='AC'><fmt:message key="eST.ByItemAlphaCode.label"  bundle="${st_labels}"/></option>
					<option  value='GN'><fmt:message key="eST.ByGenericName.label"  bundle="${st_labels}"/></option>
					<option  value='DF'><fmt:message key="eST.ByDosageForm.label"  bundle="${st_labels}"/></option>
					</select></td>
				</tr>
				</table>
				</td>  

				</tr>
			</table>

			
			<input type="hidden" name="bean_id" id="bean_id"							value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"						value="<%=bean_name%>">
			<input type="hidden" name="p_module_id" id="p_module_id" 					value="ST">
			<input type="hidden" name="p_user_name" id="p_user_name"						value="<%=user_name%>">
			<input type="hidden" name="p_user_id" id="p_user_id"						value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"					value="<%=facility_id%>">
			<input type="hidden" name="p_language_id" id="p_language_id"					value="<%=locale%>">
			<input type="hidden" name="p_report_id" id="p_report_id" 					value="STBDSTKS5">
		</form>
			<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP"				value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")%>">
            <input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP"				value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
			 <input type="hidden" name="SQL_ST_ITEM_CLASS_LOOKUP_LANG" id="SQL_ST_ITEM_CLASS_LOOKUP_LANG"	value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_LOOKUP_FOR_REPORT")%>">
<%
	putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>	

