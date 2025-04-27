<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,java.lang.*, eST.*, eST.Common.* , eCommon.Common.*"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%

		request.setCharacterEncoding("UTF-8");
		String locale			=		(String)session.getAttribute("LOCALE");
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- 	<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
<!--	<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eST/js/SRRStockLedgerReport.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%

	
		String bean_id					=		"MonthlySummaryReportBean";
		String bean_name				=		"eST.MonthlySummaryReportBean";

		String bean_id1				=		"ReportsStockStatusBean";
		String bean_name1			=		"eST.ReportsStockStatusBean";

		String bean_id2					=		"TrnSummaryListBean";
		String bean_name2				=		"eST.TrnSummaryListBean";


		TrnSummaryListBean bean2			=		(TrnSummaryListBean)getBeanObject( bean_id2,  bean_name2,request);  
		bean2.clear();
		bean2.setLanguageId(locale);


		ReportsStockStatusBean bean1 =		(ReportsStockStatusBean) getBeanObject( bean_id1,  bean_name1,request  );  
		 String p_store_group	=	bean1.getListOptionTag(bean2.getListOptionArrayList("SELECT STORE_GROUP_CODE , SHORT_DESC FROM MM_STORE_GROUP_lang_vw WHERE EFF_STATUS = 'E' and language_id=? order by SHORT_DESC",locale));
	
		//String p_report_id			=		 null;
		String facility_id				=		(String) session.getValue( "facility_id" ) ;
		String user_name				=		(String) session.getValue( "login_user" ) ;
		
		
		MonthlySummaryReportBean bean = (MonthlySummaryReportBean) getBeanObject( bean_id,  bean_name, request );  
		bean.clear();
		bean.setLanguageId(locale);
		String []stParameters=	{bean.getLoginFacilityId(), "ALL"};
		HashMap hmRecord	=	null;
		hmRecord	=	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_FACILITY_PARAM_SELECT_SINGLE"), stParameters);
		
		String curr_proc_month=(String)hmRecord.get("CURR_PROC_MONTH");
		String curr_proc_year =(String)hmRecord.get("CURR_PROC_YEAR"); 
		curr_proc_year = com.ehis.util.DateUtils.convertDate(curr_proc_year,"YY","en",locale);
	%>
	<body onLoad="FocusFirstElement();">
		<form name="StockLedgerReportCriteria" id="StockLedgerReportCriteria" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
		<br><br>
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' >
			<tr>
			<td width='100%' align='center' class="WHITE">
				<table cellpadding="0" cellspacing="0" width="98%" align="center" border="0">
				<th colspan=8 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
				
				<tr>
					<td  class="label" width="20%"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>
					<td class=fields colspan=7>&nbsp;&nbsp;<SELECT name="p_report_id" id="p_report_id" >
					<OPTION VALUE="STBSTLG1"> <fmt:message key="eST.ByItem.label" bundle="${st_labels}"/> </OPTION>
					<OPTION VALUE="STBSTLG2"> <fmt:message key="eST.ByStore.label" bundle="${st_labels}"/> </OPTION>
					
					</select></td>

				</tr>
				<tr>
					<td align="right" class="label" colspan = 8>&nbsp;</td>
					</tr>
				
				<tr>	
					<td class="label"><fmt:message key="eST.Accounting.label" bundle="${st_labels}"/>&nbsp;<fmt:message key="Common.Month/Year.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=2 size=2 name="p_fm_month" id="p_fm_month" value="<%=curr_proc_month%>" onKeyPress="return isValidInteger();" onblur="checkDoubleFormat(this);" class="NUMBER"> 
					<class=text> / 	<class=text> <input maxLength=4 size=4 name="p_fm_year1" id="p_fm_year1" value="<%=curr_proc_year%>" onKeyPress="return isValidInteger();"  class="NUMBER"> <%=bean.getImage("M")%>  </td> 
					<td class="fields" >&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/> </td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=2 size=2 name="p_to_month" id="p_to_month" value="<%=curr_proc_month%>" onKeyPress="return isValidInteger();" onblur="checkDoubleFormat(this);" class="NUMBER"> 
					<class=text> / 	<class=text> <input maxLength=4 size=4 name="p_to_year1" id="p_to_year1" value="<%=curr_proc_year%>" onKeyPress="return isValidInteger();"  class="NUMBER"> <%=bean.getImage("M")%>  </td> 
				</tr>
				<tr>
					<td class=label ><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;<input type=text name=p_dt_from_1 size=10 maxlength=10 class="DATE" value="" onBlur="CheckDate(this,'<%=locale%>');"  ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_dt_from_1');" ></img>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td class="fields" >&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/> </td><td class=fields >&nbsp;&nbsp;<input type=text name=p_dt_to_1 size=10 maxlength=10 class="DATE" value="" onBlur="CheckDate(this,'<%=locale%>');"  ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_dt_to_1');" ></img>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				</tr>

				<tr>
					<td  class="label" ><fmt:message key="eST.StoreGroup.label" bundle="${st_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;<SELECT name="p_store_group_code" id="p_store_group_code" ><%=p_store_group%>
					</select></td>
				</tr>

				<tr>
					<td align="right" class="label" colspan = 8>&nbsp;</td>
					</tr>


				<tr>
					<td  class="label"><fmt:message key="Common.StoreCode.label" bundle="${mm_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_fr_str_code" id="p_fr_str_code"  value="" ><input class="button" name="p_fm_stc" id="p_fm_stc" onClick="return searchCodeStore(p_fr_str_code);"  type="button" value="?"></td>
					<td class="fields" >&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/> </td>
					<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_to_str_code" id="p_to_str_code" value="" ><input class="button" name="p_to_stc" id="p_to_stc" onClick="return searchCodeStore(p_to_str_code);"  type="button" value="?" ></td>
				</tr>

				<tr>
					<td  class="label" ><fmt:message key="eST.DrugMedicalSupply.label" bundle="${st_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;<select name="p_drug_nondrug" id="p_drug_nondrug" >
						<option value=''><fmt:message key="Common.all.label" bundle="${mm_labels}"/></option>
						<option  value='Y'><fmt:message key="Common.Drug.label" bundle="${mm_labels}"/></option>
						<option  value='N'><fmt:message key="eST.MedicalSupply.label" bundle="${st_labels}"/></option>
					</select></td>
				</tr>

				<tr>
					<td  class="label"><fmt:message key="Common.ItemClass.label" bundle="${mm_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=4 size=4 name="p_fr_item_class" id="p_fr_item_class" value="" ><input class="button" onClick="return searchCodeItemClass(p_fr_item_class);" type="button" value="?"></td>
					<td class="fields" >&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/> </td>
					<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=4 size=4 name="p_to_item_class" id="p_to_item_class" value="" ><input class="button" onClick="return searchCodeItemClass(p_to_item_class);" type="button" value="?"></td>
				</tr>
				<tr>
					<td align="right" class="label" colspan = 8>&nbsp;</td>
					</tr>
				
				<tr>
					<td  class="label"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=20 size=20  name="p_fm_item_code" id="p_fm_item_code" value="" ><input class="button" name="p_fm_sr2" id="p_fm_sr2" onClick="return searchCodeItem(p_fm_item_code);" type="button" value="?"></td>
					<td class="fields" >&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/> </td>
					<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_to_item_code" id="p_to_item_code" value="" ><input class="button" name="p_to_sr2" id="p_to_sr2" onClick="return searchCodeItem(p_to_item_code);" type="button" value="?"  ></td>
				</tr>
				
				<tr>
					<td class="label" ><fmt:message key="Common.AlphaCode.label" bundle="${mm_labels}"/></td>
					<td class="fields">&nbsp;&nbsp;<input name="p_fr_alpa_code" id="p_fr_alpa_code" size=10 maxlength=10 value="" onKeyPress="return CheckForSpecialChars(event);"></td>
					<td class="fields" >&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/> </td>
					<td class="fields" colspan=5>&nbsp;&nbsp;<input name="p_to_alpa_code" id="p_to_alpa_code" size=10 maxlength=10 value="" onKeyPress="return CheckForSpecialChars(event);"></td>
				</tr>

				<tr>
					<td align="right" class="label" colspan = 8>&nbsp;</td>
					</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.ItemAnalysis.label" bundle="${mm_labels}"/>1</td>
					<td class=fields>&nbsp;&nbsp;<select name="p_item_anal1_code" id="p_item_anal1_code" >
					<%=bean2.getItemAnal_code_List()%>
					</select></td>

					<td  class="label">&nbsp;<fmt:message key="Common.ItemAnalysis.label" bundle="${mm_labels}"/> 2</td>
					<td class=fields>&nbsp;&nbsp;<select name="p_item_anal2_code" id="p_item_anal2_code" >
					<%=bean2.getItemAnal_code_List()%>
					</select></td>
				</tr>
				<tr>

					</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.ItemAnalysis.label" bundle="${mm_labels}"/> 3</td>
					<td class=fields>&nbsp;&nbsp;<select name="p_item_anal3_code" id="p_item_anal3_code" >
					<%=bean2.getItemAnal_code_List()%>
					</select></td>
				</tr>
				 <tr>
					<td class=label align=right><fmt:message key="eST.ABCAnalysis.label" bundle="${st_labels}"/>  </td>
					<td class=fields >&nbsp;&nbsp;<select name="p_abc_anal" id="p_abc_anal" ><option value="">&nbsp;--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
					<OPTION VALUE="A"><fmt:message key="Common.A.label" bundle="${common_labels}"/></OPTION>
					<OPTION VALUE="B"><fmt:message key="Common.B.label" bundle="${common_labels}"/></OPTION>
					<OPTION VALUE="C"><fmt:message key="Common.C.label" bundle="${common_labels}"/></OPTION></SELECT></td>
					<td  class="label" >&nbsp;<fmt:message key="Common.Supplier.label" bundle="${common_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;<input maxLength=20 size=20 name="p_supplier_code" id="p_supplier_code" value="" ><input class="button" name="p_fr_sr" id="p_fr_sr" onClick="return searchsuppliercode(p_supplier_code);" type="button" value="?"  ></td>
				</tr>
				
				
				
			   <!--  <tr>
					<td align="right" class="label">Print Technical Specification</td>
					<td align="left">&nbsp;<input type="checkbox" value="E" name="print_spec" id="print_spec"></td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
				</tr> -->
                
				</table>
				</td>  

				</tr>
			</table>

			<input type="hidden" name="bean_id1" id="bean_id1"								value="<%=bean_id1%>">
			<input type="hidden" name="bean_name1" id="bean_name1"							value="<%=bean_name1%>">
			<input type="hidden" name="bean_id2" id="bean_id2"							value="<%=bean_id2%>">
			<input type="hidden" name="bean_name2" id="bean_name2"						value="<%=bean_name2%>">

			<input type="hidden" name="bean_id" id="bean_id"							value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"						value="<%=bean_name%>">
			<input type="hidden" name="p_module_id" id="p_module_id" 					value="ST">
			<input type="hidden" name="dt_from" id="dt_from" 						value="">
			<input type="hidden" name="dt_to" id="dt_to" 							value="">
			<input type="hidden" name="p_user_name" id="p_user_name"						value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"					value="<%=facility_id%>">
			<input type="hidden" name="curr_proc_month" id="curr_proc_month"					value="<%=curr_proc_month%>">
			<input type="hidden" name="curr_proc_year" id="curr_proc_year"					value="<%=curr_proc_year %>">
			<input type="hidden" name="p_language_id" id="p_language_id"					value="<%=locale%>">
			<input type="hidden" name="p_to_year" id="p_to_year"						value="">
			<input type="hidden" name="p_fm_year" id="p_fm_year"						value="">
			</form>
			<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP"				value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")%>">
            <input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP"				value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
			<input type="hidden" name="SQL_ST_ITEM_CLASS_LOOKUP_LANG" id="SQL_ST_ITEM_CLASS_LOOKUP_LANG"	value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_LOOKUP_FOR_REPORT")%>">
			 <input type="hidden" name="SQL_AP_SUPPLIER_SELECT_LOOKUP" id="SQL_AP_SUPPLIER_SELECT_LOOKUP"		value="<%= eST.Common.StRepository.getStKeyValue("SQL_AP_SUPPLIER_SELECT_LOOKUP")%>">


	<%
putObjectInBean(bean_id,bean,request);
    %>	
	</body>
</html>	

