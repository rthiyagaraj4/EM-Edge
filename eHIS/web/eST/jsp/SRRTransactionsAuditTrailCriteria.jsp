<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, java.lang.*,eST.*, eST.Common.* , eCommon.Common.*" %>
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
<!--  	<script language="javascript" src="../../eST/js/StMessages.js"></script>  -->
		<script language="javascript" src="../../eST/js/SRRTransactionsAuditTrail.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		
		String bean_id				=		"MonthlySummaryReportBean";
		String bean_name			=		"eST.MonthlySummaryReportBean";
		//String p_report_id		=		null;
		String facility_id			=		(String) session.getValue( "facility_id" ) ;
		String user_name			=		(String) session.getValue( "login_user" ) ;

		StockLevelReportBean bean1 = (StockLevelReportBean)getBeanObject( "StockLevelReportBean", "eST.StockLevelReportBean",request) ; bean1.clear();
		bean1.setLanguageId(locale);
			
		MonthlySummaryReportBean bean =		(MonthlySummaryReportBean) getBeanObject(bean_id,bean_name,request);  
		bean.clear();
		bean.setLanguageId(locale);
		bean.setAcc_entity_id((String)session.getAttribute("ACC_ENTITY_ID"));

		String store_group	=	bean.getListOptionTag(bean.getListOptionArrayList("SELECT STORE_GROUP_CODE , SHORT_DESC FROM MM_STORE_GROUP_lang_vw WHERE EFF_STATUS = 'E' and language_id=? order by SHORT_DESC",locale));
		
		//String []stParameters		=		{bean.getLoginFacilityId(), "ALL"};
	//	HashMap hmRecord			=		null;
	//	hmRecord					=		bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_FACILITY_PARAM_SELECT_SINGLE"), stParameters);
		
	//	String curr_proc_month		=		(String)hmRecord.get("CURR_PROC_MONTH");
	//	String curr_proc_year		=		(String)hmRecord.get("CURR_PROC_YEAR"); 

	    ArrayList alParam = new ArrayList();
		alParam.add(locale);
		alParam.add(facility_id);


		String document_type_code	=	bean.getListOptionTag(bean.getListOptionArrayList("SELECT   a.doc_type_code code, b.short_desc description FROM st_trn_doc_type a, sy_doc_type_master_lang_vw b WHERE b.language_id LIKE ? AND a.facility_id LIKE (?) AND a.doc_type_code LIKE UPPER ('%') AND UPPER (b.short_desc) LIKE UPPER ('%') AND a.doc_type_code = b.doc_type_code",alParam));
       
	%>
	<body onLoad="FocusFirstElement();">
<!-- 	SQL_ST_TRN_TYPE_SELECT_LIST -->
		<form name="TransactionsAuditTrailCriteria" id="TransactionsAuditTrailCriteria" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
		<br><br>
		<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' >
			<tr>
			<td width='100%' align='center' class="WHITE">
				<table cellpadding="0" cellspacing="0" width="98%" align="center" border="0">
				<th colspan=8 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
							
			<!--  	<tr>
					<td align="right">&nbsp;</td>
					<td class="fields">&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td align="right" >&nbsp;</td>
					<td class="fields" colspan=5 width="10%">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>  -->
               				<tr><td class='label' colspan='3'>&nbsp;</td></tr>

               <tr>
			         <td class="label"><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;<SELECT name="p_report_option" id="p_report_option" onChange="changeReport();">
					<OPTION VALUE="1"> <fmt:message key="eST.ByItem.label" bundle="${st_labels}"/> </OPTION>
					<OPTION VALUE="2"> <fmt:message key="eST.ByItemClass.label" bundle="${st_labels}"/></OPTION>
					<OPTION VALUE="3"> <fmt:message key="eST.ByStore.label" bundle="${st_labels}"/></OPTION>
					</select></td>
					<td  class="label" ><fmt:message key="Common.ReportOption.label" bundle="${common_labels}"/></td>
					<td class=fields colspan=5>&nbsp;&nbsp;<SELECT name="P_Report_type" id="P_Report_type" >
					<OPTION VALUE="B"><fmt:message key="Common.Both.label" bundle="${common_labels}"/></OPTION>
					<OPTION VALUE="C"><fmt:message key="eST.Consumption.label" bundle="${st_labels}"/></OPTION>
					<OPTION VALUE="N"><fmt:message key="eST.NonConsumption.label" bundle="${st_labels}"/></OPTION>
					</select></td>
				</tr>

                 <tr>
					<td class="label"><fmt:message key="Common.user.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=20 size=20  name="P_USER_REPORT" id="P_USER_REPORT" value="" ><input class="button" name="p_user_but" id="p_user_but" onClick="return searchUser(P_USER_REPORT);" type="button" value="?"></td>
					<td class="label">&nbsp;</td>
				</tr>
								<tr><td class='label' colspan='3'>&nbsp;</td></tr>

				<tr>
					<td class=label align=right><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input type=text name=p_dt_from size=10 maxlength=10 class="DATE" value=""  ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_dt_from');" ></img>&nbsp;<IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0"  ></IMG></td>
					<td  class="label" ><fmt:message key="Common.to.label" bundle="${common_labels}"/><td class=fields colspan=5>&nbsp;&nbsp;<input type=text name=p_dt_to size=10 maxlength=10 class="DATE" value=""  ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_dt_to');" ></img>&nbsp;<IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0"  ></IMG></td>
				</tr>
				<tr><td class='label' colspan='3'>&nbsp;</td></tr>

				<tr>
					<td  class="label" ><fmt:message key="eST.StoreGroup.label" bundle="${st_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;<SELECT name="P_STORE_GR" id="P_STORE_GR" ><%=store_group%>
					</select></td>
				</tr>

				<tr>
					<td class="label"><fmt:message key="Common.StoreCode.label" bundle="${mm_labels}"/> </td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_fr_str_code" id="p_fr_str_code"  value="" ><input class="button" name="p_fm_stc" id="p_fm_stc" onClick="return searchCodeStore(p_fr_str_code);"  type="button" value="?"></td>
					<td  class="label" ><fmt:message key="Common.to.label" bundle="${common_labels}"/><td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=6 size=6  name="p_to_str_code" id="p_to_str_code" value="" ><input class="button" name="p_to_stc" id="p_to_stc" onClick="return searchCodeStore(p_to_str_code);"  type="button" value="?" ></td>
				</tr>
				<tr><td class='label' colspan='3'>&nbsp;</td></tr>

				<tr>
					<td  class="label" ><fmt:message key="eST.DrugMedicalSupply.label" bundle="${st_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;<SELECT name="P_DRUG_NONDRUG" id="P_DRUG_NONDRUG" >
					<OPTION VALUE=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></OPTION>
					<OPTION VALUE="Y"><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></OPTION>
					<OPTION VALUE="N"><fmt:message key="eST.MedicalSupply.label" bundle="${st_labels}"/></OPTION>
				
					</select></td>
				</tr>

					<tr>
					<td  class="label"><fmt:message key="Common.ItemClass.label" bundle="${mm_labels}"/> </td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=4 size=4 name="p_fr_item_class" id="p_fr_item_class" value="" ><input class="button" onClick="return searchCodeItemClass(p_fr_item_class);" type="button" value="?"></td>
					<td  class="label" ><fmt:message key="Common.to.label" bundle="${common_labels}"/><td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=4 size=4 name="p_to_item_class" id="p_to_item_class" value="" ><input class="button" onClick="return searchCodeItemClass(p_to_item_class);" type="button" value="?"></td>
				</tr>
				
				<tr>
					<td class="label"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=20 size=20  name="p_fm_item_code" id="p_fm_item_code" value="" ><input class="button" name="p_fm_sr2" id="p_fm_sr2" onClick="return searchCodeItem(p_fm_item_code);" type="button" value="?"></td>
					<td  class="label" ><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
					<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_to_item_code" id="p_to_item_code" value="" ><input class="button" name="p_to_sr2" id="p_to_sr2" onClick="return searchCodeItem(p_to_item_code);" type="button" value="?"></td>
				</tr>
			
				<tr>
					<td class=label align=right><fmt:message key="Common.AlphaCode.label" bundle="${mm_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input type=text name=p_fr_alpa_code size=10 maxlength=10 value="" onKeyPress="return CheckForSpecialChars(event);"></td>
					<td  class="label" ><fmt:message key="Common.to.label" bundle="${common_labels}"/><td class=fields colspan=5>&nbsp;&nbsp;<input type=text name=p_to_alpa_code size=10 maxlength=10 value="" onKeyPress="return CheckForSpecialChars(event);"></td>
				</tr>

				<tr>
					<td class=label align=right><fmt:message key="Common.BatchNo.label" bundle="${mm_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input type=text name=P_Batch_no size=20 maxlength=20 value="" onKeyPress="return CheckForSpecialChars(event);"></td>
				</tr>
				<tr><td class='label' colspan='3'>&nbsp;</td></tr>

				<tr>
					<td class=label align=right><fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/> 1 </td>
					<td class=fields >&nbsp;&nbsp;<SELECT name="P_ITEM_ANAL1_CODE" id="P_ITEM_ANAL1_CODE" ><option value="">&nbsp;----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
					<%
					ArrayList	arraylist		=	null;
					HashMap		hmItemCode		=	null;	
					String code = "";String	desc		=	"";

					arraylist		=	bean1.getArrayCodeList();
					int arrLength		=	arraylist.size();
					for(int i=0;i<arrLength; i++)
					{
						hmItemCode      	=	(HashMap) arraylist.get(i);
						
						code				=	(String)hmItemCode.get("code");
						desc				=	(String)hmItemCode.get("desc");
					
					%> 	<option value="<%=code%>"  ><%=desc%></option> 	
				<% 	} %>
					</select></td>
					<td class=fields colspan=5>&nbsp;&nbsp;<fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/> 2 </td><td class=fields ><SELECT name="P_ITEM_ANAL2_CODE" id="P_ITEM_ANAL2_CODE" ><option value="">&nbsp;----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
					<%
					for(int i=0;i<arrLength; i++)
					{
						hmItemCode      	=	(HashMap) arraylist.get(i);
						
						code				=	(String)hmItemCode.get("code");
						desc				=	(String)hmItemCode.get("desc");
					
					%> 	<option value="<%=code%>"  ><%=desc%></option> 	
				<% 	} %>
					</select></td>
				</tr>

					<tr>
					<td class=label align=right><fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/> 3 </td>
					<td class=fields >&nbsp;&nbsp;<SELECT name="P_ITEM_ANAL3_CODE" id="P_ITEM_ANAL3_CODE" ><option value="">&nbsp;----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
					<%
					for(int i=0;i<arrLength; i++)
					{
						hmItemCode      	=	(HashMap) arraylist.get(i);
						
						code				=	(String)hmItemCode.get("code");
						desc				=	(String)hmItemCode.get("desc");
					
					%> 	<option value="<%=code%>"  ><%=desc%></option> 	
				<% 	} %>
					</select></td>
					</tr>

					<tr>
					<td class=label align=right><fmt:message key="eST.ABCAnalysis.label" bundle="${st_labels}"/>  </td>
					<td class=fields >&nbsp;&nbsp;<SELECT name="P_ABC_ANALYSIS" id="P_ABC_ANALYSIS" ><option value="">&nbsp;--<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--</option>
					<OPTION VALUE="A"><fmt:message key="Common.A.label" bundle="${common_labels}"/></OPTION>
					<OPTION VALUE="B"><fmt:message key="Common.B.label" bundle="${common_labels}"/></OPTION>
					<OPTION VALUE="C"><fmt:message key="Common.C.label" bundle="${common_labels}"/></OPTION></SELECT></td>

					<td  class="label" ><fmt:message key="Common.Supplier.label" bundle="${common_labels}"/><td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=20 size=20 name="P_SUPPLIER" id="P_SUPPLIER" value="" ><input class="button" name="p_to_sr2" id="p_to_sr2" onClick="return searchsuppliercode(P_SUPPLIER);" type="button" value="?"  ></td>
				</tr>


			
				<tr>
					<td  class="label" ><fmt:message key="Common.transactiontype.label" bundle="${common_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;<SELECT name="p_tran_type" id="p_tran_type" ><%=bean.getTrn_type()%>
					</select></td>
					
				</tr>
				<tr><td class='label' colspan='3'>&nbsp;</td></tr>

				<tr>
					<td  class="label" ><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
					<td class=fields >&nbsp;&nbsp;<SELECT name="P_DOC_TYPE" id="P_DOC_TYPE" ><%=document_type_code%>
					</select></td>
					
				</tr>
								<tr><td class='label' colspan='3'>&nbsp;</td></tr>


				<tr>
					<td class=label align=right><fmt:message key="Common.DocNo.label" bundle="${mm_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input type=text name=P_FR_DOC_NO size=10 maxlength=10 value="" onKeyPress="return CheckForSpecialCharswithchar(event);"></td>
					<td  class="label" ><fmt:message key="Common.to.label" bundle="${common_labels}"/><td class=fields colspan=5>&nbsp;&nbsp;<input type=text name=P_TO_DOC_NO size=10 maxlength=10 value="" onKeyPress="return CheckForSpecialCharswithchar(event);"></td>
				</tr>
				<tr>
					<td class=label align=right><fmt:message key="Common.DocRef.label" bundle="${mm_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input type=text name=p_fr_doc_ref size=10 maxlength=10 value="" onKeyPress="return CheckForSpecialChars(event);"></td>
					<td  class="label" ><fmt:message key="Common.to.label" bundle="${common_labels}"/><td class=fields colspan=5>&nbsp;&nbsp;<input type=text name=p_to_doc_ref size=10 maxlength=10 value="" onKeyPress="return CheckForSpecialChars(event);"></td>
				</tr>
				
                
				</table>
				</td>  

				</tr>
			</table>

			
			<input type="hidden" name="bean_id" id="bean_id"								value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"							value="<%=bean_name%>">
			<input type="hidden" name="p_module_id" id="p_module_id" 						value="ST">
			<input type="hidden" name="dt_from" id="dt_from" 							value="">
			<input type="hidden" name="dt_to" id="dt_to" 								value="">
			<input type="hidden" name="dt_from_1" id="dt_from_1" 								value="">
			<input type="hidden" name="dt_to_1" id="dt_to_1" 								value="">
			<input type="hidden" name="p_user_name" id="p_user_name"							value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"						value="<%=facility_id%>">
			<input type="hidden" name="p_report_id" id="p_report_id"							value="STBTXAU1">
			<input type="hidden" name="p_language_id" id="p_language_id"						value="<%=locale%>">
			<input type="hidden" name="p_order_by" id="p_order_by"						value="1">
				   <input type="hidden" name="sysdate" id="sysdate"	value="<%=com.ehis.util.DateUtils.getCurrentDate("DMY",locale).toString()%>">
				 
				  

</form>
  <input type="hidden" name="SQL_ST_USER_LOOKUP_USERACCESS" id="SQL_ST_USER_LOOKUP_USERACCESS"		value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_USER_LOOKUP_USERACCESS")%>">
 <input type="hidden" name="SQL_AP_SUPPLIER_SELECT_LOOKUP" id="SQL_AP_SUPPLIER_SELECT_LOOKUP"		value="<%= eST.Common.StRepository.getStKeyValue("SQL_AP_SUPPLIER_SELECT_LOOKUP")%>">
			<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP"					value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")%>">
            <input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP"					value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
			 <input type="hidden" name="SQL_ST_ITEM_CLASS_LOOKUP_LANG" id="SQL_ST_ITEM_CLASS_LOOKUP_LANG"		value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_LOOKUP_FOR_REPORT")%>">
			  




		<%
putObjectInBean(bean_id,bean,request);
%>

	</body>
</html>	

