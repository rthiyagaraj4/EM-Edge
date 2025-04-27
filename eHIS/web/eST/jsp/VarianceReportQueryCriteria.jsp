<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name       	Rev.Date   		Rev.By    	Description
--------------------------------------------------------------------------------------------------------------
03/05/2017		IN:064126		Badmavathi B								Search criteria Item class not working
---------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import ="eST.*, eST.Common.* , eCommon.Common.*,java.util.*,java.lang.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
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
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- 		<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
<!-- 		<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language='javascript' src="../../eST/js/VarianceReport.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
	//java.util.HashMap defaultParameter = null;
	String bean_id = "VarianceReportBean";
	String bean_name = "eST.VarianceReportBean";
	
	VarianceReportBean bean = (VarianceReportBean) getBeanObject( bean_id, bean_name, request );
	String facility_id  =  (String) session.getValue( "facility_id" ) ;
	bean.clear( );	
bean.setLanguageId(locale);
%>

	<body onLoad="FocusFirstElement()">
		<form name="formVarianceReportQueryCriteria" id="formVarianceReportQueryCriteria" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
<table border="0" cellpadding="0" cellspacing="0" width='100%' height='100%' align='center'>
		<tr>
		<td width='100%' align='center' class="WHITE">
		<table cellpadding="0" cellspacing="0" width="75%" align="center" border="0">
				<th colspan=3 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td   class="label"><fmt:message key="eST.PhyInventoryID.label" bundle="${st_labels}"/></td>
			<td  colspan='2'>&nbsp;&nbsp;<select name='p_PHY_INV_ID' id='p_PHY_INV_ID' >
			<option value="" ><%=bean.getStRepositoryValue("DEFAULT_LIST_OPTION_TEXT")%></option>
	<%
					ArrayList	arraylist		=	null;
					HashMap		hmItemCode		=	null;	
					String code = "";
					//String	desc		=	"";

					arraylist		=	bean.getArrayCodeList(facility_id);
					int arrLength		=	arraylist.size();
					for(int i=0;i<arrLength; i++)
					{
						hmItemCode      	=	(HashMap) arraylist.get(i);
						
						code				=	(String)hmItemCode.get("PHY_INV_ID");
										
					%> 	<option value="<%=code%>"  ><%=code%></option> 	
				<% 	} %>
				
	%></select><%=bean.getImage("M")%>
	</td>
		</tr>
		<tr>
			<td   class="label"><fmt:message key="eST.SuppressZeroVariance.label" bundle="${st_labels}"/></td>
			<td colspan='2'>&nbsp;<input type="checkbox" name="selectItem" id="selectItem" value = "N" onclick ="assignValue(this);"></td>
		</tr>
		<tr>
			<td  class="label"><fmt:message key="Common.ReportOption.label" bundle="${common_labels}"/></td>
			<td colspan='2'>&nbsp;
			<select name='p_report_id' id='p_report_id'>
				<option  value='STBPHVR1'><fmt:message key="eST.VarianceReportatBatchLevel.label" bundle="${st_labels}"/> </option>
				<option  value='STBPHVR4'><fmt:message key="eST.VarianceReportatItemLevel.label" bundle="${st_labels}"/> </option>
				<option  value='STBPHVR2'><fmt:message key="eST.VarianceReportatStoreLevel.label" bundle="${st_labels}"/> </option>
				<option  value='STBPHVR3'><fmt:message key="eST.SummaryReportatItemClassLevel.label" bundle="${st_labels}"/> </option>
			</select>
			</td>
		</tr>
		<tr>
			<td  class="label"><fmt:message key="eST.SuppressSummary.label" bundle="${st_labels}"/></td>
			<td align="left" colspan='2'>&nbsp;<input type='checkbox' name='selectsummary' id='selectsummary' value = "N" onclick ="assignValue(this);"></td>
		</tr>
		<tr>
			<td   class="label"><fmt:message key="eST.PrintNilStockItems.label" bundle="${st_labels}"/></td>
			<td colspan='2'>&nbsp;<input type="checkbox" name="p_nil_stk_item" id="p_nil_stk_item" value = "N" onclick ="assignValue(this);"></td>
		</tr>
		<tr>
				<td align="left"  class="label" colspan='3'>&nbsp;</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td class="fields">&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
			<td class="fields">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
		</tr>

		<tr>
			<td  class=label><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
			<td>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_fm_item_code" id="p_fm_item_code" value="" ><input class="button" name="p_fm_sr2" id="p_fm_sr2" onClick="return searchCodeItem(p_fm_item_code);" type="button" value="?"></td>
			
			<td>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_to_item_code" id="p_to_item_code" value="" ><input class="button" name="p_to_sr2" id="p_to_sr2" onClick="return searchCodeItem(p_to_item_code);" type="button" value="?"></td>
		</tr>
		<tr>
			<td  class=label><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></td>
			<td>&nbsp;&nbsp;<input maxLength=4 size=4 name="p_fm_item_class_code" id="p_fm_item_class_code" value=""><input class="button" onClick="return searchCodeItemClass(p_fm_item_class_code);" type="button" value="?"></td>
			
			<td>&nbsp;&nbsp;<input maxLength=4 size=4 name="p_to_item_class_code" id="p_to_item_class_code" value="" ><input class="button" onClick="return searchCodeItemClass(p_to_item_class_code);" type="button" value="?"></td>
			<!--Modified p_fm_item_class to p_fm_item_class_code and  p_to_item_class to p_to_item_class_code against IN:064126 -->
		</tr>
		<tr>
			<td  class=label><fmt:message key="Common.StoreCode.label" bundle="${common_labels}"/></td>
			<td>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_fr_st_code" id="p_fr_st_code" value="" ><input class="button"  onClick="return searchCodeStore(p_fr_st_code);" type="button" name="p_to_st" id="p_to_st" value="?"></td>
			
			<td>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_to_st_code" id="p_to_st_code" value="" ><input class="button" onClick="return searchCodeStore(p_to_st_code);" type="button"  name="p_to_sr" id="p_to_sr" value="?"></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>

</table>
</td></tr>
</table>
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="p_module_id" id="p_module_id" 		value="ST">
<input type="hidden" name="p_facility_id" id="p_facility_id"		value="<%=facility_id%>">
<input type="hidden" name="P_SUMMARY" id="P_SUMMARY"		value="E">
<input type="hidden" name="p_language_id" id="p_language_id"		value="<%=locale%>">

</form>
<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")%>">
<input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP" value="<%=bean.getStRepositoryValue("SQL_ST_ITEM_LOOKUP")%>">
<input type="hidden" name="SQL_ST_ITEM_CLASS_LOOKUP_LANG" id="SQL_ST_ITEM_CLASS_LOOKUP_LANG" value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_LOOKUP_FOR_REPORT")%>">
<%
putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

