<!DOCTYPE html>
<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------

7/6/2021				TFS-19789				Shazana													MOHE-CRF-0084.1 
--------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,java.lang.*, eST.*, eST.Common.* , eCommon.Common.*,webbeans.eCommon.*,java.sql.*"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
<%

		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<!--<link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
	<!--<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<!--<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
		<script language="javascript" src="../../eST/js/TrnSummaryReport.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 

	</head>
	<%
		
		String bean_id					=		"TrnSummaryListBean";
		String bean_name				=		"eST.TrnSummaryListBean";
	//	String p_report_id				=		 null;
		String facility_id				=		(String) session.getValue( "facility_id" ) ;
		String user_name				=		(String) session.getValue( "login_user" ) ;
		
		
		TrnSummaryListBean bean			=		(TrnSummaryListBean) getBeanObject( bean_id,bean_name,request);  
		bean.clear();
		
		bean.setLanguageId(locale);
		
		boolean restrict_stores_user_access_yn =false;//Added for TFS id:19789 
	    String strFacilityParam = "";
		String restrictInReportYN = ""; 
		Connection con				= null; 
	    try{
			con						= ConnectionManager.getConnection(request);
		    restrict_stores_user_access_yn = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_RESTRICT_USER_ACCESS_STORES");  
	    }
	    finally{
	    	if(con != null)
	    		ConnectionManager.returnConnection(con,request); 
	    }
		strFacilityParam = bean.getRestrictUserAccessStore();
	
		if(strFacilityParam == null || strFacilityParam.equals(""))
			strFacilityParam = "N"; 
		if(restrict_stores_user_access_yn){
			if(strFacilityParam.equals("Y")){
				restrictInReportYN = "Y";
			}else{
				restrictInReportYN = "N"; 
			}
		}//END 
	
		
	%>
	<body onLoad="FocusFirstElement();">
		<form name="formGRNSummary" id="formGRNSummary" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame">
		<table cellpadding="0" cellspacing="0" width="75%" align="center" border="0">
				<th colspan=4 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
				<tr>
					<td  class="label" ><fmt:message key="Common.ReportOrder.label" bundle="${common_labels}"/></td>
					<td>&nbsp;&nbsp;<select name="p_report_id" id="p_report_id" >
								<option value="STBGRNS1"><fmt:message key="Common.ByDate.label" bundle="${common_labels}"/> </option> 	
								<option value="STBGRNS2"><fmt:message key="eST.ByItem.label" bundle="${st_labels}"/> </option> 	
								<option value="STBGRNS3"><fmt:message key="eST.BySupplier.label" bundle="${st_labels}"/> </option> 	
							</select>
					</td>
<!-- 					<td align="right" class="label" >Category Type</td>
					<td>&nbsp;&nbsp;<select name="p_category_type" id="p_category_type" >
								<option value="S">Inventory GRN</option> 	
								<option value="N">Non Inventory GRN</option> 	
								<option value="B">Both</option> 	
							</select>
					</td>

 -->
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td  class="fields">&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/> </td>
					<td>&nbsp;</td>
					<td class="fields">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/> </td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></td>
					<td>&nbsp;&nbsp;<input maxLength=10 size=10 name="p_fm_doc_no" id="p_fm_doc_no" value="" class="NUMBER" onkeypress="return isValidNumber(this,event,8,0);" onBlur="checkIntegerFormat(this);"></td>
					<td>&nbsp;</td>
					<td>&nbsp;&nbsp;<input maxLength=10 size=10  name="p_to_doc_no" id="p_to_doc_no" value="" class="NUMBER" onkeypress="return isValidNumber(this,event,8,0);" onBlur="checkIntegerFormat(this);"></td>
				</tr>
				<tr>
					<td class=label align=left><fmt:message key="Common.DocDate.label" bundle="${common_labels}"/></td>
					<td>&nbsp;&nbsp;<input type=text name="dt_from_1" id="dt_from_1" size=10 maxlength=10 class="DATE" value="" onBlur="CheckDate(this,'<%=locale%>');" ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('dt_from_1');" ></img>&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;&nbsp;<input type=text name="dt_to_1" id="dt_to_1" size=10 maxlength=10 class="DATE" value="" onBlur="CheckDate(this,'<%=locale%>');" ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('dt_to_1');" ></img>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
					<td>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_fm_item_code" id="p_fm_item_code" value="" ><input class="button" onClick="return searchCodeItem(p_fm_item_code);" type="button" value="?"></td>
					<td>&nbsp;</td>
					<td>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_to_item_code" id="p_to_item_code" value="" ><input class="button" onClick="return searchCodeItem(p_to_item_code);" type="button" value="?"></td>
				</tr>
 
					<tr>
					<td  class="label"><fmt:message key="Common.AlphaCode.label" bundle="${common_labels}"/></td>
					<td>&nbsp;&nbsp;<input maxLength=10 size=20 name="p_fm_alpha_code" id="p_fm_alpha_code" value="" onKeyPress="return CheckForSpecialChars(event);"></td>
					<td>&nbsp;</td>
					<td>&nbsp;&nbsp;<input maxLength=10 size=20 name="p_to_alpha_code" id="p_to_alpha_code" value="" onKeyPress="return CheckForSpecialChars(event);"></td>
				</tr>


				<tr>
					<td class="label"><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></td>
					<td>&nbsp;&nbsp;<input maxLength=4 size=20 name="p_fm_item_class_code" id="p_fm_item_class_code" value="" ><input class="button" name="p_fm_sr2" id="p_fm_sr2" onClick="return searchCodeItemClass(p_fm_item_class_code);" type="button" value="?"></td>
					<td>&nbsp;</td>
					<td>&nbsp;&nbsp;<input maxLength=4 size=20 name="p_to_item_class_code" id="p_to_item_class_code" value="" ><input class="button" name="p_to_sr2" id="p_to_sr2" onClick="return searchCodeItemClass(p_to_item_class_code);" type="button" value="?"></td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="Common.SupplierCode.label" bundle="${common_labels}"/> </td>
					<td>&nbsp;&nbsp;<input maxLength=8 size=10 name="p_fm_supp_code" id="p_fm_supp_code" value="" ><input class="button" onClick="return searchSupplier(p_fm_supp_code);" type="button" value="?"></td>
					<td>&nbsp;</td>
					<td>&nbsp;&nbsp;<input maxLength=8 size=10 name="p_to_supp_code" id="p_to_supp_code" value="" ><input class="button" name="p_to_sr2" id="p_to_sr2" onClick="return searchSupplier(p_to_supp_code);" type="button" value="?"></td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.StoreCode.label" bundle="${common_labels}"/></td>
						<%if(restrict_stores_user_access_yn){ %><!-- added for 19789 start -->
					<td>&nbsp;&nbsp;<input maxLength=6 size=10 name="p_fm_store_code" id="p_fm_store_code" value="" ><input class="button" onClick="return searchCodeStore1(p_fm_store_code);" type="button" value="?"></td>
					<%}else { %>
					<td>&nbsp;&nbsp;<input maxLength=6 size=10 name="p_fm_store_code" id="p_fm_store_code" value="" ><input class="button" onClick="return searchCodeStore(p_fm_store_code);" type="button" value="?"></td>
					<%} %>
					<td>&nbsp;</td>
					<%if(restrict_stores_user_access_yn){ %><!-- MOHE-CRF-0084.1-->
					<td>&nbsp;&nbsp;<input maxLength=6 size=10 name="p_to_store_code" id="p_to_store_code" value="" ><input class="button" name="p_to_sr2" id="p_to_sr2" onClick="return searchCodeStore1(p_to_store_code);" type="button" value="?"></td>
					<%}else { %>
					<td>&nbsp;&nbsp;<input maxLength=6 size=10 name="p_to_store_code" id="p_to_store_code" value="" ><input class="button" name="p_to_sr2" id="p_to_sr2" onClick="return searchCodeStore(p_to_store_code);" type="button" value="?"></td>
					<%} %><!-- end -->
				</tr>
				
				<tr>
					<td  class="label"><fmt:message key="Common.DepartmentCode.label" bundle="${common_labels}"/> </td>
					<td>&nbsp;&nbsp;<input maxLength=6 size=10 name="p_fm_dept_code" id="p_fm_dept_code" value="" ><input class="button" onClick="return searchCodeDeptForFacility(p_fm_dept_code);" type="button" value="?"></td>
					<td>&nbsp;</td>
					<td>&nbsp;&nbsp;<input maxLength=6 size=10 name="p_to_dept_code" id="p_to_dept_code" value="" ><input class="button" name="p_to_sr2" id="p_to_sr2" onClick="return searchCodeDeptForFacility(p_to_dept_code);" type="button" value="?"></td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="eST.PONo.label" bundle="${st_labels}"/></td>
					<td>&nbsp;&nbsp;<input maxLength=10 size=10 name="p_fm_po_no" id="p_fm_po_no" value="" align="left" onKeyPress="return CheckForSpecialCharsPONo(event);" ></td>
					<td>&nbsp;</td>
					<td>&nbsp;&nbsp;<input maxLength=10 size=10  name="p_to_po_no" id="p_to_po_no" value="" onKeyPress="return CheckForSpecialCharsPONo(event);"></td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.DocTypeCode.label" bundle="${common_labels}"/></td>
					<td>&nbsp;&nbsp;<input maxLength=6 size=10 name="p_doc_type_code" id="p_doc_type_code" value="" ><input class="button"  onClick="return searchCodeTrnDocTypeFORGRN(p_doc_type_code);" type="button" name="p_fr_sr" id="p_fr_sr" value="?"></td>
					<td  class="label"><fmt:message key="eST.ConsignmentItemsOnly.label" bundle="${st_labels}"/> </td>
					<td>&nbsp;<input name="p_consignment_item" id="p_consignment_item" value="Y" type='checkbox'></td>
				</tr>
				<tr>
				<td  class="label"><fmt:message key="eST.ReplacementOnExpiry.label" bundle="${st_labels}"/></td>
				<td align="left">&nbsp;&nbsp;<select name=P_REPLACE_ON_EXPIRY_YN>
				<OPTION value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></OPTION>
				<OPTION value="Y"><fmt:message key="Common.yes.label" bundle="${common_labels}"/></OPTION>
				<OPTION value="N"><fmt:message key="Common.no.label" bundle="${common_labels}"/></OPTION>
				</select></td>
					<td  class="label"><fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/>1</td>
					<td align="left">&nbsp;&nbsp;<select name="p_item_anal1_code" id="p_item_anal1_code" >
					<%=bean.getItemAnal_code_List()%>
					</select></td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/>2</td>
					<td align="left">&nbsp;&nbsp;<select name="p_item_anal2_code" id="p_item_anal2_code" >
					<%=bean.getItemAnal_code_List()%>
					</select></td>
					<td class="label"><fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/>3</td>
					<td align="left">&nbsp;&nbsp;<select name="p_item_anal3_code" id="p_item_anal3_code" >
					<%=bean.getItemAnal_code_List()%>
					</select></td>
		<!-- 	<td class="label" colspan=8>&nbsp;</td>   -->
                 </tr>
				<tr>
<!-- 					<td align="right" class="label" >Report Type</td>
					<td>&nbsp;&nbsp;<select name="p_report_type" id="p_report_type" >
					<option value="S">Summary</option> 	
					<option value="D">Detail</option> 	
					</select></td>
	-->				
					<input type='hidden' name="p_report_type" id="p_report_type" value="S">
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
			
			</table>

			
			<input type="hidden" name="bean_id" id="bean_id"								value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"							value="<%=bean_name%>">
			<input type="hidden" name="p_module_id" id="p_module_id" 						value="ST">
			<input type="hidden" name="dt_to" id="dt_to" 								value="">
			<input type="hidden" name="dt_from" id="dt_from" 							value="">
			<input type="hidden" name="p_user_name" id="p_user_name"							value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"						value="<%=facility_id%>">
			<input type="hidden" name="p_language_id" id="p_language_id"						value="<%=locale%>">
			<input type="hidden" name="p_strFacilityParam" id="p_strFacilityParam"						value="<%=strFacilityParam%>"><!-- MOHE-CRF-0084.1-->
		</form>
 			<input type="hidden" name="SQL_AP_SUPPLIER_SELECT_LOOKUP" id="SQL_AP_SUPPLIER_SELECT_LOOKUP"		value="<%= eST.Common.StRepository.getStKeyValue("SQL_AP_SUPPLIER_SELECT_LOOKUP")%>">
			<input type="hidden" name="SQL_ST_DEPT_LOOKUP" id="SQL_ST_DEPT_LOOKUP"					value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_DEPT_LOOKUP")%>">
			<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP"					value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")%>">
            <input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP"					value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
			<input type="hidden" name="SQL_ST_ITEM_CLASS_LOOKUP_LANG" id="SQL_ST_ITEM_CLASS_LOOKUP_LANG"		value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_LOOKUP_FOR_REPORT")%>">
			<input type="hidden" name="SQL_ST_TRN_DOC_TYPE_LOOKUP" id="SQL_ST_TRN_DOC_TYPE_LOOKUP"			value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_TRN_DOC_TYPE_LOOKUP")%>">
			<%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>	

