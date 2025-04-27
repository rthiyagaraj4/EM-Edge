<!DOCTYPE html>
<%
/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
20/7/2021		TFS-21691			Shazana											MOHE-CRF-0084.1 
---------------------------------------------------------------------------------------------------------
*/
%>

 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,java.lang.*, eST.*, eST.Common.* , eCommon.Common.*,webbeans.eCommon.*,java.sql.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
<!-- 		<link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->	
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
<!-- 	<script language="javascript" src="../../eST/js/StMessages.js"></script> -->
		<script language="javascript" src="../../eST/js/TrnSummaryReport.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 

	</head>
	<%
		
		String bean_id				=		"TrnSummaryListBean";
		String bean_name			=		"eST.TrnSummaryListBean";
	//	String p_report_id			=		 null;
		String facility_id			=		(String) session.getValue( "facility_id" ) ;
		String user_name			=		(String) session.getValue( "login_user" ) ;
		
		
		TrnSummaryListBean bean		=		(TrnSummaryListBean) getBeanObject( bean_id,bean_name,request);  
		bean.clear();
		bean.setLanguageId(locale);
		boolean restrict_stores_user_access_yn =false;//Added for TFS id:21691 
	    String strFacilityParam = "";
		String restrictInReportYN = "";
		Connection con				= null; 
		try{
			con						= ConnectionManager.getConnection(request);
		    restrict_stores_user_access_yn = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_RESTRICT_USER_ACCESS_STORES");
	    }
		catch(Exception ex)
	    {
	    	ex.printStackTrace();
	    
	    }
	    finally{ 
	    	if(con != null)
	    		ConnectionManager.returnConnection(con,request); 
	    }
		strFacilityParam = bean.getRestrictUserAccessStore();
	
		if(strFacilityParam== null || strFacilityParam.equals(""))
			strFacilityParam = "N"; 
		if(restrict_stores_user_access_yn){
			if(strFacilityParam.equals("Y")){
				restrictInReportYN = "Y";
			}else{
				restrictInReportYN = "N"; 
			}
		}//END 
		System.out.println("restrictInReportYN: "+restrictInReportYN);
		
	%>
	<body onLoad="FocusFirstElement();">
		<form name="formBonusSummaryReport" id="formBonusSummaryReport" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" onReset="FocusFirstElement();">
		<table cellpadding="0" cellspacing="0" width="79%" align="center" border="0">
					<th colspan=4 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
				<tr>
					<td align="right">&nbsp;</td>
					<td class="fields" >&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td align="right" >&nbsp;</td>
					<td class="fields" >&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>

				<tr>
					<td class="label"><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></td>
					<td>&nbsp;&nbsp;<input maxLength=8 size=10 name="p_fm_doc_no" id="p_fm_doc_no" value="" class="NUMBER" onkeypress="return isValidNumber(this,event,8,0);" onBlur="checkIntegerFormat(this);"></td>
					<td class="label">&nbsp;</td>
					<td class="fields"  colspan=5>&nbsp;&nbsp;<input maxLength=8 size=10  name="p_to_doc_no" id="p_to_doc_no" value="" class="NUMBER" onkeypress="return isValidNumber(this,event,8,0);" onBlur="checkIntegerFormat(this);"></td>
				</tr>

				<tr>
					<td class=label ><fmt:message key="Common.DocDate.label" bundle="${common_labels}"/></td>
					<td>&nbsp;&nbsp;<input type=text name="p_fm_doc_date_1" id="p_fm_doc_date_1" size=10 maxlength=10 class="DATE" value="" onBlur="CheckDate(this,'<%=locale%>');" >
					<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_fm_doc_date_1');" ></img>
					&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td class="label">&nbsp;</td>
					<td class=fields colspan=5>&nbsp;&nbsp;<input type=text name="p_to_doc_date_1" id="p_to_doc_date_1" size=10 maxlength=10 class="DATE" value="" onBlur="CheckDate(this,'<%=locale%>');">
					<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_to_doc_date_1');" ></img>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
					<td>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_fm_item_code" id="p_fm_item_code" value="" ><input class="button" name="p_fm_sr2" id="p_fm_sr2" onClick="return searchCodeItem(p_fm_item_code);" type="button" value="?"></td>
					<td >&nbsp;</td>
					<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_to_item_code" id="p_to_item_code" value="" ><input class="button" name="p_to_sr2" id="p_to_sr2" onClick="return searchCodeItem(p_to_item_code);" type="button" value="?"></td>
				</tr>

			  <tr>
					<td  class="label"><fmt:message key="Common.AlphaCode.label" bundle="${common_labels}"/></td>
					<td>&nbsp;&nbsp;<input maxLength=10 size=20 name="p_fm_alpha_code" id="p_fm_alpha_code" value="" onKeyPress="return CheckForSpecialChars(event);"></td>
					<td >&nbsp;</td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=10 size=20 name="p_to_alpha_code" id="p_to_alpha_code" value=""  onKeyPress="return CheckForSpecialChars(event);"></td>
				</tr>

				<tr>
					<td  class="label"><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></td>
					<td>&nbsp;&nbsp;<input maxLength=4 size=20 name="p_fm_item_class_code" id="p_fm_item_class_code" value="" ><input class="button" name="p_fm_sr2" id="p_fm_sr2" onClick="return searchCodeItemClass(p_fm_item_class_code);" type="button" value="?"></td>
					<td >&nbsp;</td>
					<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=4 size=20 name="p_to_item_class_code" id="p_to_item_class_code" value="" ><input class="button" name="p_to_sr2" id="p_to_sr2" onClick="return searchCodeItemClass(p_to_item_class_code);" type="button" value="?"></td>
				</tr>
				
				<tr>
					<td class="label"><fmt:message key="Common.SupplierCode.label" bundle="${common_labels}"/></td>
					<td>&nbsp;&nbsp;<input maxLength=8 size=10 name="p_fm_supp_code" id="p_fm_supp_code" value="" ><input class="button" onClick="return searchSupplier(p_fm_supp_code);" type="button" value="?"></td>
					<td >&nbsp;</td>
					<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=8 size=10 name="p_to_supp_code" id="p_to_supp_code" value="" ><input class="button" name="p_to_sr2" id="p_to_sr2" onClick="return searchSupplier(p_to_supp_code);" type="button" value="?"></td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.StoreCode.label" bundle="${common_labels}"/></td>
					<% if(restrictInReportYN.equals("Y")){ %><!-- added for 21691 -->
					<td>&nbsp;&nbsp;<input maxLength=6 size=10 name="p_fm_store_code" id="p_fm_store_code" value="" ><input class="button" onClick="return searchCodeStore1(p_fm_store_code);" type="button" value="?"></td>
					<%}else{ %>
					<td>&nbsp;&nbsp;<input maxLength=6 size=10 name="p_fm_store_code" id="p_fm_store_code" value="" ><input class="button" onClick="return searchCodeStore(p_fm_store_code);" type="button" value="?"></td>
					<%} %>
					<td >&nbsp;</td>
					<%if(restrictInReportYN.equals("Y")){  %>
					<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=6 size=10 name="p_to_store_code" id="p_to_store_code" value="" ><input class="button" name="p_to_sr2" id="p_to_sr2" onClick="return searchCodeStore1(p_to_store_code);" type="button" value="?"></td>
					<% }else { %>
					<td class=fields colspan=5>&nbsp;&nbsp;<input maxLength=6 size=10 name="p_to_store_code" id="p_to_store_code" value="" ><input class="button" name="p_to_sr2" id="p_to_sr2" onClick="return searchCodeStore(p_to_store_code);" type="button" value="?"></td>
					<%} %><!-- added for 21691 end -->
				</tr>
				
				<tr>
					<td class="label"><fmt:message key="eST.PONo.label" bundle="${st_labels}"/></td>
					<td>&nbsp;&nbsp;<input type='text' maxLength=10 size=10 name="p_fm_po_no" id="p_fm_po_no" value="" onKeyPress="return CheckForSpecialCharsPONo(event);"></td>
					<td class="label">&nbsp;</td>
					<td class="fields" colspan=5>&nbsp;&nbsp;<input type='text' maxLength=10 size=10  name="p_to_po_no" id="p_to_po_no" value="" onKeyPress="return CheckForSpecialCharsPONo(event);"></td>
				</tr>
				<tr>
					<td colspan='4'>&nbsp;</td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="Common.DocTypeCode.label" bundle="${common_labels}"/></td>
					<td colspan='3'>&nbsp;&nbsp;<input maxLength=6 size=10 name="p_doc_type_code" id="p_doc_type_code" value="" ><input class="button"  onClick="return searchCodeTrnDocTypeFORGRN(p_doc_type_code);" type="button" name="p_fr_sr" id="p_fr_sr" value="?"></td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="eST.ConsignmentItemsOnly.label" bundle="${st_labels}"/></td>
					<td colspan='3'>&nbsp;<input name="p_consignment_item" id="p_consignment_item" value="Y" type='checkbox'></td>
				</tr>
				<tr>
					<td  class="label">&nbsp;<fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/>1</td>
					<td class=fields align="left">&nbsp;&nbsp;<select name="p_item_anal1_code" id="p_item_anal1_code" >
					<%=bean.getItemAnal_code_List()%>
					</select></td>
					<td  class="label">&nbsp;<fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/>2</td>
					<td class=fields >&nbsp;&nbsp;<select name="p_item_anal2_code" id="p_item_anal2_code" >
					<%=bean.getItemAnal_code_List()%>
					</select></td>
				</tr>
				<tr>
					<td  class="label">&nbsp;<fmt:message key="Common.ItemAnalysis.label" bundle="${common_labels}"/>3</td>
					<td class=fields >&nbsp;&nbsp;<select name="p_item_anal3_code" id="p_item_anal3_code" >
					<%=bean.getItemAnal_code_List()%>
					</select></td>
						<td align="right" class="label" colspan =8>&nbsp;</td>  
                 </tr>
				 <td align="right" class="label" colspan =8>&nbsp;</td>
				</table>

			
			<input type="hidden" name="bean_id" id="bean_id"								value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"							value="<%=bean_name%>">
			<input type="hidden" name="p_module_id" id="p_module_id" 						value="ST">
			<input type="hidden" name="p_fm_doc_date" id="p_fm_doc_date" 						value="">
			<input type="hidden" name="p_to_doc_date" id="p_to_doc_date" 						value="">
			<input type="hidden" name="p_report_id" id="p_report_id" 						value="STBBONUS">
			<input type="hidden" name="p_user_name" id="p_user_name"							value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"						value="<%=facility_id%>">
			<input type="hidden" name="p_language_id" id="p_language_id"						value="<%=locale%>">
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

