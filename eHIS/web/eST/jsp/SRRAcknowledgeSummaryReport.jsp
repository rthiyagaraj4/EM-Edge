<!DOCTYPE html>

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, eST.*,java.lang.*, eST.Common.* , eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
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
<!--	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
<!-- 	<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
<!-- 	<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
		<script language="javascript" src="../../eST/js/SRRTrnSummaryReport.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 

	</head>
	<%
		
		String bean_id					=		"TrnSummaryListBean";
		String bean_name				=		"eST.TrnSummaryListBean";
	//	String p_report_id				=		null;

	String bean_id1				=		"ReportsStockStatusBean";
		String bean_name1			=		"eST.ReportsStockStatusBean";


		String facility_id				=		(String) session.getValue( "facility_id" ) ;
		String user_name				=		(String) session.getValue( "login_user" ) ;
		
		
		TrnSummaryListBean bean			=		(TrnSummaryListBean)getBeanObject( bean_id,  bean_name,request);  
		bean.clear();
		bean.setLanguageId(locale);

		ReportsStockStatusBean bean1 =		(ReportsStockStatusBean) getBeanObject( bean_id1,  bean_name1,request  );  
		String p_store_group	=	bean1.getListOptionTag(bean.getListOptionArrayList("SELECT STORE_GROUP_CODE , SHORT_DESC FROM MM_STORE_GROUP_lang_vw WHERE EFF_STATUS = 'E' and language_id=? order by SHORT_DESC",locale));
	
		 ArrayList params = new ArrayList();
		params.add("RET");
		params.add(locale);

		String p_remarks	=	bean1.getListOptionTag(bean.getListOptionArrayList("SELECT   a.trn_remarks_code, c.remarks_desc FROM st_trn_type_for_remarks a, mm_trn_remarks_lang_vw c WHERE a.trn_remarks_code = c.trn_remarks_code AND a.eff_status = 'E' AND a.trn_type = ? AND c.language_id = ? ORDER BY 2 ",params));
	
		
	%>
	<body onLoad="FocusFirstElement();">
		<form name="formAcknowledgeSummaryReport" id="formAcknowledgeSummaryReport" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
		<table cellpadding="0" cellspacing="0" width="75%" align="center" border="0">
				<th colspan=8 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>

				<tr>
					<td align="right" class="label" colspan = 8>&nbsp;</td>
					</tr>

				<tr>
					
					<td class=label align=right><fmt:message key="eST.RejectQuantity.label" bundle="${st_labels}"/>  </td>
					<td class=fields >&nbsp;&nbsp;<select name="p_reject_qty" id="p_reject_qty" ><option  value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
					<option value ='Z'><fmt:message key="eST.Zero.label" bundle="${st_labels}"/></option>
						<option  value='NZ'><fmt:message key="eST.NonZero.label" bundle="${st_labels}"/></option>
					</select></td>
					<td class=label align=right><fmt:message key="eST.ReceiveType.label" bundle="${st_labels}"/>  </td>
					<td class=fields >&nbsp;&nbsp;<select name="p_iss_type" id="p_iss_type" ><option  value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
					<option value ='S'><fmt:message key="eST.StockIssues.label" bundle="${st_labels}"/></option>
						<option  value='NS'><fmt:message key="eST.NonStockIssues.label" bundle="${st_labels}"/></option>
					</select></td>
				</tr>

				<tr>
					<td class=label ><fmt:message key="Common.DocDate.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input type=text name=p_fm_doc_date_1 size=10 maxlength=10 class="DATE" value="" onBlur="CheckDate(this);"  ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_fm_doc_date_1');" ></img>
					&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td class="fields" >&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/> </td><td class=fields colspan=5>&nbsp;&nbsp;<input type=text name=p_to_doc_date_1 size=10 maxlength=10 class="DATE" value="" onBlur="CheckDate(this);"  >
					<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_to_doc_date_1');" ></img>
					&nbsp;&nbsp;&nbsp;&nbsp;</td>
				</tr>


				<tr>
					<td  class="label" ><fmt:message key="eST.StoreGroup.label" bundle="${st_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;<SELECT name="p_store_gr" id="p_store_gr" ><%=p_store_group%>
					</select></td>
				</tr>
					<tr>
					<td align="right" class="label" colspan = 8>&nbsp;</td>
					</tr>

					<tr>
					<td  class="label"><fmt:message key="eST.IssuingStore.label" bundle="${st_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_fm_iss_st" id="p_fm_iss_st" value="" ><input class="button" name="p_fm_sr21" id="p_fm_sr21" onClick="return searchCodeStore(p_fm_iss_st);" type="button" value="?"></td>
					<td class="fields" > &nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/> </td>
					<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_to_iss_st" id="p_to_iss_st" value="" ><input class="button" name="p_to_sr21" id="p_to_sr21" onClick="return searchCodeStore(p_to_iss_st);" type="button" value="?"></td>
				</tr>
				
				<tr>
					<td  class="label"><fmt:message key="Common.ReceivingStore.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_fm_rec_to_st" id="p_fm_rec_to_st" value="" ><input class="button" name="p_fm_sr2" id="p_fm_sr2" onClick="return searchCodeStore(p_fm_rec_to_st);" type="button" value="?"></td>
					<td class="fields" >&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/> </td>
					<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_to_rec_to_st" id="p_to_rec_to_st" value="" ><input class="button" name="p_to_sr2" id="p_to_sr2" onClick="return searchCodeStore(p_to_rec_to_st);" type="button" value="?"></td>
				</tr>
				
				
				<tr>
					<td  class="label" >Drug / Medical Supply</td>
					<td class=fields >&nbsp;&nbsp;<select name="p_drug_nondrug" id="p_drug_nondrug" >
						<option value=''><fmt:message key="Common.all.label" bundle="${mm_labels}"/></option>
						<option  value='Y'><fmt:message key="Common.Drug.label" bundle="${mm_labels}"/></option>
						<option  value='N'><fmt:message key="eST.MedicalSupply.label" bundle="${st_labels}"/></option>
					</select></td>
				</tr>
				<tr>
					<td align="right" class="label" colspan = 8>&nbsp;</td>
					</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.ItemClass.label" bundle="${mm_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=4 size=20 name="p_fm_item_class_code" id="p_fm_item_class_code" value="" ><input class="button" name="p_fm_sr2" id="p_fm_sr2" onClick="return searchCodeItemClass(p_fm_item_class_code);" type="button" value="?"></td>
					<td class="fields" >&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/> </td>
					<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=4 size=20 name="p_to_item_class_code" id="p_to_item_class_code" value="" ><input class="button" name="p_to_sr2" id="p_to_sr2" onClick="return searchCodeItemClass(p_to_item_class_code);" type="button" value="?"></td>
				</tr>
				
				
				<tr>
					<td  class="label"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_fm_item_code" id="p_fm_item_code" value="" ><input class="button" name="p_fm_sr2" id="p_fm_sr2" onClick="return searchCodeItem(p_fm_item_code);" type="button" value="?"></td>
					<td class="fields" >&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/> </td>
					<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_to_item_code" id="p_to_item_code" value="" ><input class="button" name="p_to_sr2" id="p_to_sr2" onClick="return searchCodeItem(p_to_item_code);" type="button" value="?"></td>
				</tr>

				 <tr>
					<td class="label"><fmt:message key="Common.AlphaCode.label" bundle="${mm_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=10 size=20 name="p_fm_alpha_code" id="p_fm_alpha_code" value="" onKeyPress="return CheckForSpecialChars(event);"></td>
					<td class="fields" >&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/> </td>
					<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=10 size=20 name="p_to_alpha_code" id="p_to_alpha_code" value="" onKeyPress="return CheckForSpecialChars(event);"></td>
				</tr>
				<tr>
					<td align="right" class="label" colspan = 8>&nbsp;</td>
					</tr>
				<tr>
					<td  class="label">&nbsp;<fmt:message key="Common.ItemAnalysis.label" bundle="${mm_labels}"/>1</td>
					<td class=fields>&nbsp;&nbsp;<select name="p_item_anal1_code" id="p_item_anal1_code" >
					<%=bean.getItemAnal_code_List()%>
					</select></td>

					<td  class="label">&nbsp;<fmt:message key="Common.ItemAnalysis.label" bundle="${mm_labels}"/> 2</td>
					<td class=fields>&nbsp;&nbsp;<select name="p_item_anal2_code" id="p_item_anal2_code" >
					<%=bean.getItemAnal_code_List()%>
					</select></td>
				</tr>
				<tr>
					<td  class="label">&nbsp;<fmt:message key="Common.ItemAnalysis.label" bundle="${mm_labels}"/> 3</td>
					<td class=fields>&nbsp;&nbsp;<select name="p_item_anal3_code" id="p_item_anal3_code" >
					<%=bean.getItemAnal_code_List()%>
					</select></td>
						<td align="right" class="label" colspan =8>&nbsp;</td>  
                 </tr>
				 <!--
					* @Name - Priya
					* @Date - 31/12/2009
					* @Inc# - IN017730
					* @Desc - To display the option fields of ?ABC Analysis? as ?A?, ?B?, ?C?  instead of ?Type A?, ?Type B?, ?Type C' & to remove 'All' in the options 
					 -->
				 <tr>
					<td class=label align=right><fmt:message key="eST.ABCAnalysis.label" bundle="${st_labels}"/>  </td>
					<td class=fields >&nbsp;&nbsp;<select name="p_abc_analysis" id="p_abc_analysis" >
					<option value="">  ---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---  </option>
					<option value ='A'><fmt:message key="eST.A.label" bundle="${st_labels}"/></option>
					<option  value='B'><fmt:message key="eST.B.label" bundle="${st_labels}"/></option>
					<option  value='C'><fmt:message key="eST.C.label" bundle="${st_labels}"/></option>
					<td align="right" class="label" >&nbsp;&nbsp;</td>
					<td align="right" class="label" >&nbsp;&nbsp;</td>
					</select></td>
				</tr>
				<tr>
					<td align="right" class="label" colspan = 8>&nbsp;</td>
					</tr>

				
				<tr>
					<td  class="label"><fmt:message key="Common.DocTypeCode.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=6 size=10 name="p_fr_doc_type" id="p_fr_doc_type" value="" ><input class="button"  onClick="return searchDocType(p_fr_doc_type);" type="button" name="p_fr_sr" id="p_fr_sr" value="?"></td>
					<td class="fields" >&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/> </td>
					<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=6 size=10  name="p_to_doc_type" id="p_to_doc_type" value="" ><input class="button" onClick="return searchDocType(p_to_doc_type);" type="button"  name="p_to_sr" id="p_to_sr" value="?"></td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;<input class="NUMBER" maxLength=10 size=10 name="p_fm_doc_no" id="p_fm_doc_no" value="" onKeyPress="numbervalidation();"></td><td class="fields" >&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/> </td>
					<td  class="fields" colspan=5>&nbsp;&nbsp;<input class="NUMBER" maxLength=10 size=10  name="p_to_doc_no" id="p_to_doc_no" value="" onKeyPress="numbervalidation();"></td>
				</tr>
				
				
				<tr>
					<td align="right" class="label" colspan = 8>&nbsp;</td>
					</tr>
				 
				
				<!--
					* @Name - Priya
					* @Date - 31/12/2009
					* @Inc# - IN017730
					* @Desc - Commented Remarks field as it is not needed in this report 
					 -->
				<!--<tr>
					<td  class="label" ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;<SELECT name="p_remark" id="p_remark" ><%=p_remarks%>
					</select></td>
				</tr>	-->
				<tr>
					<td align="right" class="label" colspan = 8>&nbsp;</td>
					</tr>
	        
				</table>
				
			<input type="hidden" name="bean_id1" id="bean_id1"								value="<%=bean_id1%>">
			<input type="hidden" name="bean_name1" id="bean_name1"							value="<%=bean_name1%>">
	
			<input type="hidden" name="bean_id" id="bean_id"							value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"						value="<%=bean_name%>">
			<input type="hidden" name="p_module_id" id="p_module_id" 					value="ST">
			
		<!--<input type="hidden" name="p_report_id" id="p_report_id" 					value="STBRETSM">	 -->	
			<input type="hidden" name="p_user_name" id="p_user_name"						value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"					value="<%=facility_id%>">
			<input type="hidden" name="p_language_id" id="p_language_id"					value="<%=locale%>">
			<input type="hidden" name="dt_from" id="dt_from" 					value="">
			<input type="hidden" name="dt_to" id="dt_to" 						value="">
		</form>
			<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP"				value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")%>">
            <input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP"				value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
			<input type="hidden" name="SQL_ST_ITEM_CLASS_LOOKUP_LANG" id="SQL_ST_ITEM_CLASS_LOOKUP_LANG"	value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_LOOKUP_FOR_REPORT")%>">
			<input type="hidden" name="SQL_ST_TRN_DOC_TYPE_LOOKUP" id="SQL_ST_TRN_DOC_TYPE_LOOKUP"		value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_TRN_DOC_TYPE_LOOKUP")%>">
			<%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>	

