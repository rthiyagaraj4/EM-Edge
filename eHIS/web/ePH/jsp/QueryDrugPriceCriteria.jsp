<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String facility_id  =  (String) session.getValue( "facility_id" );
		String user_name  =  (String) session.getValue( "login_user" ) ;
		String locale			= (String)session.getAttribute("LOCALE");
		String doc_no	= request.getParameter( "doc_no" )==null?"":request.getParameter( "doc_no" ) ;
		String trn_type	= request.getParameter( "trn_type" )==null?"":request.getParameter( "trn_type" ) ;
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../js/QueryDrugPrice.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
		<form name="queryStockonHandCriteria_form" id="queryStockonHandCriteria_form">
			<table cellpadding="2" cellspacing="0" width="80%" align="center" border="0">	
				<tr>
					<td width='10%'>&nbsp;</td>
					<td width='40%' class="fields"><b><fmt:message key="Common.from.label" bundle="${common_labels}"/><b></td>
					<td width='40%' class="fields"><b><fmt:message key="Common.to.label" bundle="${common_labels}"/><b></td>
					<td width='10%'>&nbsp;</td>
				</tr>
				<tr><td colspan='4'>&nbsp;</td></tr>
				<tr>
					<td  class="label"><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
					<td class='fields'><input maxLength='20' size='30' name="p_fr_st_desc" id="p_fr_st_desc" value="" onChange="searchStoreCode(p_fr_st_code, p_fr_st_desc);">
						<input class="button" name='btnFrmStoreLookup' id='btnFrmStoreLookup' onClick="searchStoreCode(p_fr_st_code, p_fr_st_desc);" type="button" value="?">
						<input type="hidden" name="p_fr_st_code" id="p_fr_st_code" value="">
					</td>
					<td class='fields' colspan='2'><input maxLength='20' size='30' name="p_to_st_desc" id="p_to_st_desc" value="" onChange="searchStoreCode(p_to_st_code, p_to_st_desc);">
						<input class="button" name='btnToStoreLookup' id='btnToStoreLookup' onClick="searchStoreCode(p_to_st_code, p_to_st_desc);" type="button"value="?">
						<input type="hidden" name="p_to_st_code" id="p_to_st_code" value="">
					</td>
				</tr>
	           <tr>
					<td  class="label"><fmt:message key="Common.Drug.label" bundle="${common_labels}"/></td>
					<td class='fields'>
						<input maxLength='60' size='50' name="p_fm_item_desc" id="p_fm_item_desc"value="" onChange="searchItemCode(p_fm_item_code, p_fm_item_desc);">
						<input class="button" name="btnFrmItemLookup" id="btnFrmItemLookup" onClick="searchItemCode(p_fm_item_code, p_fm_item_desc);" type="button"value="?">&nbsp;
						<input type="hidden" name="p_fm_item_code" id="p_fm_item_code" value="">
						<img src="../../eCommon/images/mandatory.gif"></td>
					<td class='fields' >
						<input maxLength='60' size='50' name="p_to_item_desc" id="p_to_item_desc" value="" onchange = "searchItemCode(p_to_item_code, p_to_item_desc);" >
						<input class="button" name="btnToItemLookup" id="btnToItemLookup" onClick="searchItemCode(p_to_item_code, p_to_item_desc);" type="button" value="?">&nbsp;
						<input type="hidden" name="p_to_item_code" id="p_to_item_code" value="">
					</td>
					<td class='button'><input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="searchVals()">&nbsp;&nbsp;&nbsp;</td>
				</tr>
			</table>
			<input type="hidden" name="p_facility_id" id="p_facility_id" value="<%=facility_id%>">
			<input type="hidden" name="p_language_id" id="p_language_id" value="<%=locale%>">
			<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=user_name%>">
			<input type='hidden' name='doc_no' id='doc_no' value="<%=doc_no%>">
			<input type='hidden' name='trn_type' id='trn_type' value="<%=trn_type%>">
			<input type="hidden" name="SQL_PH_ST_STORE_LOOKUP_LANG" id="SQL_PH_ST_STORE_LOOKUP_LANG"value="<%= ePH.Common.PhRepository.getPhKeyValue("SQL_PH_ST_STORE_LOOKUP_LANG")%>">
		    <input type="hidden" name="SQL_PH_ST_ITEM_LOOKUP" id="SQL_PH_ST_ITEM_LOOKUP"value="<%= ePH.Common.PhRepository.getPhKeyValue("SQL_PH_ST_ITEM_LOOKUP")%>">
		</form>
	</body>
</html>

