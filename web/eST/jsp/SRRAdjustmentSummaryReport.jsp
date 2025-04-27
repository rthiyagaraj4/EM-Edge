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
		<script language="javascript" src="../../eST/js/SRRTrnSummaryReport.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
	<%
		
		String bean_id				=		 "TrnSummaryListBean";
		String bean_name			=		"eST.TrnSummaryListBean";
		String facility_id			=		(String) session.getValue( "facility_id" ) ;
		String user_name			=		(String) session.getValue( "login_user" ) ;
		String trn_type				=		(String)request.getParameter("trn_type");
		
		TrnSummaryListBean bean		=		(TrnSummaryListBean) getBeanObject( bean_id,bean_name,request);  
		bean.clear();
		bean.setLanguageId(locale);
		
	%>
	<body onLoad="FocusFirstElement();">
		<form name="formSRRChangeBinLocation" id="formSRRChangeBinLocation" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
	
				<table cellpadding="0" cellspacing="0" width="75%" align="center" border="0">
				<th colspan=4 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th>
				<tr>
					<td colspan=4>&nbsp;</td>
				</tr>
				<tr>
					<td colspan=4>&nbsp;</td>
				</tr>
				<tr>
					<td class=label align=right><fmt:message key="Common.user.label" bundle="${common_labels}"/></td>
					<td class=fields colspan=3>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_user_id" id="p_user_id" value="" ><input class="button" name="p_user_button" id="p_user_button" onClick="searchUserCode(p_user_id);" type="button" value="?"></td>
				</tr>
				<tr>
					<td colspan=4>&nbsp;</td>
				</tr>
				<tr>
					<td class=label align=right><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input type=text name=p_date_from size=10 maxlength=10 class="DATE" value="" onBlur="CheckDate(this);">
					<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_date_from');" ></img>
					&nbsp;<IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0"  ></IMG>&nbsp;&nbsp;</td>
					<td class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;</td><td class=fields >&nbsp;&nbsp;<input type=text name=p_date_to size=10 maxlength=10 class="DATE" value="" onBlur="CheckDate(this);">
					<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_date_to');" ></img>
					&nbsp;<IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0"  ></IMG>&nbsp;&nbsp;</td>
				</tr>
				<tr>
					<td colspan=4>&nbsp;</td>
				</tr>
				<tr>
					<td align="right" class="label"><fmt:message key="Common.StoreCode.label" bundle="${mm_labels}"/></td>
					<td class=fields colspan=3>&nbsp;&nbsp;<input maxLength=6 size=7 name="p_store_code" id="p_store_code" value="" ><input class="button" name="p_store_button" id="p_store_button" onClick="return searchCodeStore(p_store_code);" type="button" value="?"> &nbsp;<IMG SRC="../../eCommon/images/mandatory.gif" BORDER="0"  ></IMG> </td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="eST.FromBinLocation.label" bundle="${st_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=10 size=11 name="p_fm_bin_loc" id="p_fm_bin_loc" value="" ></td>
					<td class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;</td>
					<td class=fields >&nbsp;&nbsp;<input maxLength=10 size=11 name="p_to_bin_loc" id="p_to_bin_loc" value="" ></td>
				</tr>
				<tr>
					<td colspan=4>&nbsp;</td>
				</tr>
				<tr>
					<td class=label align=right><fmt:message key="eST.DrugMedicalSupply.label" bundle="${st_labels}"/></td>
					<td class=fields colspan=3>&nbsp;&nbsp;<select name="p_drug_nondrug" id="p_drug_nondrug" >
					<option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
					<option VALUE="Y"><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></option>
					<option VALUE="N"><fmt:message key="eST.MedicalSupply.label" bundle="${st_labels}"/></option>
				
					</select></td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=4 size=5 name="p_fm_item_class_code" id="p_fm_item_class_code" value="" ><input class="button" name="p_fm_sr2" id="p_fm_sr2" onClick="return searchCodeItemClass(p_fm_item_class_code);" type="button" value="?"></td>
					<td class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;</td>
					<td class=fields >&nbsp;&nbsp;<input maxLength=4 size=5 name="p_to_item_class_code" id="p_to_item_class_code" value="" ><input class="button" name="p_to_sr2" id="p_to_sr2" onClick="return searchCodeItemClass(p_to_item_class_code);" type="button" value="?"></td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_fm_item_code" id="p_fm_item_code" value="" ><input class="button" name="p_fm_sr2" id="p_fm_sr2" onClick="return searchCodeItem(p_fm_item_code);" type="button" value="?"></td>
					<td class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;</td>
					<td class=fields >&nbsp;&nbsp;<input maxLength=20 size=20 name="p_to_item_code" id="p_to_item_code" value="" ><input class="button" name="p_to_sr2" id="p_to_sr2" onClick="return searchCodeItem(p_to_item_code);" type="button" value="?"></td>
				</tr>
                <tr>
					<td  class="label"><fmt:message key="Common.AlphaCode.label" bundle="${mm_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<input maxLength=10 size=11 name="p_fm_alpha_code" id="p_fm_alpha_code" value="" onKeyPress="return CheckForSpecialChars(event);"></td>
					<td class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/>&nbsp;</td>
					<td class=fields >&nbsp;&nbsp;<input maxLength=10 size=11 name="p_to_alpha_code" id="p_to_alpha_code" value="" onKeyPress="return CheckForSpecialChars(event);"></td>
				 </tr>
				 <tr>
					<td class=label align=right><fmt:message key="eST.BatchNumber.label" bundle="${st_labels}"/></td>
					<td class=fields colspan=3>&nbsp;&nbsp;<input maxLength=20 size=20 name="p_batch_no" id="p_batch_no" value="" onKeyPress="return CheckForSpecialChars(event);"></td>
				</tr>

                
			</table>
			
			<input type="hidden" name="bean_id" id="bean_id"						value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"					value="<%=bean_name%>">
			<input type="hidden" name="p_module_id" id="p_module_id" 				value="ST">
			<input type="hidden" name="dt_from" id="dt_from" 					value="">
			<input type="hidden" name="dt_to" id="dt_to" 						value="">
			<input type="hidden" name="p_report_id" id="p_report_id" 				value="STCHBINLOCN">
			<input type="hidden" name="p_user_name" id="p_user_name"					value="<%=user_name%>">
			<input type="hidden" name="p_facility_id" id="p_facility_id"				value="<%=facility_id%>">
			<input type="hidden" name="p_language_id" id="p_language_id"				value="<%=locale%>">
			<input type="hidden" name="p_trn_type" id="p_trn_type"					value="<%=trn_type%>">
			<%
putObjectInBean(bean_id,bean,request);
%>
		</form>
			<input type="hidden" name="SQL_ST_STORE_LOOKUP" id="SQL_ST_STORE_LOOKUP"				value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_STORE_LOOKUP_FOR_REPORT")%>">
            <input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP"				value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_LOOKUP")%>">
			<input type="hidden" name="SQL_ST_ITEM_CLASS_LOOKUP_LANG" id="SQL_ST_ITEM_CLASS_LOOKUP_LANG"	value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_ITEM_CLASS_LOOKUP_FOR_REPORT")%>">
			<input type="hidden" name="SQL_SM_APPL_USER_USER_LOOK_UP" id="SQL_SM_APPL_USER_USER_LOOK_UP" value="<%= eST.Common.StRepository.getStKeyValue("SQL_SM_APPL_USER_USER_LOOK_UP")%>">
	</body>
</html>	

