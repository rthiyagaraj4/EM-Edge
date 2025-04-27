<!DOCTYPE html>
 <%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
 
<html>
	<head>
	<%
	request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
 		<script language="JavaScript" src="../../eST/js/StHeader.js"></script>
		<script language="JavaScript" src="../../eST/js/GoodsReturnToVendor.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="javaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<body onLoad="FocusFirstElement();">
<form name="formGoodsReturnToVendorHeader" id="formGoodsReturnToVendorHeader">
<%
	String bean_id						=		"goodsReturnToVendorBean" ;
	String bean_name					=		"eST.GoodsReturnToVendorBean";

	eST.GoodsReturnToVendorBean bean	=		(eST.GoodsReturnToVendorBean)getBeanObject( bean_id, bean_name, request);
	bean.setLanguageId(locale);
	
	String mode							=		request.getParameter("mode");
	String trn_type						=		"RTV";
	String sql_id						=		"SQL_ST_RTV_STORE_SELECT";
	String preview_disabled				=		"disabled";
	String codeDisabled					=		"";
	String item_class_based				=		bean.getRTVItemClassBased(trn_type);
    if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
		codeDisabled					=		"disabled";
		preview_disabled				=		"";
	}

	String replacementGRN_disabled		=		"";
    if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) && bean.getReplacement_grn_yn().equals("Y") ) {
		replacementGRN_disabled			=		"disabled";
	}
	
	String rtv_delete_yn =		bean.checkForNull((String)bean.fetchRecord("select  rtv_delete_yn  from  ST_USER_ACCESS_FOR_STORE where store_code=? and user_id=?",new String[]{bean.checkForNull(bean.getStore_code()),(String) session.getValue( "login_user" )}).get("RTV_DELETE_YN"),"N");

%>
<jsp:include page="../../eST/jsp/StHeader.jsp" > 
	<jsp:param name="mode"				value="<%=mode%>" />
	<jsp:param name="trn_type"			value="<%=trn_type%>" />
	<jsp:param name="storeSQLID"		value="<%=sql_id%>" />
	<jsp:param name="doc_type_code"		value="<%=bean.getDoc_type_code()%>" />
	<jsp:param name="doc_no"			value="<%=bean.getDoc_no()%>" />
	<jsp:param name="doc_date"			value="<%=bean.getDoc_date()%>" />
	<jsp:param name="doc_ref"			value="<%=bean.getDoc_ref()%>" />
	<jsp:param name="store_code"		value="<%=bean.checkForNull(bean.getStore_code())%>" />
	<jsp:param name="item_class_code"	value="<%=bean.getItem_class_code()%>" />
	<jsp:param name="bean_id"			value="<%=bean_id%>" />
	<jsp:param name="bean_name"			value="<%=bean_name%>" />
</jsp:include>


<table cellpadding=0 cellspacing=0 border=0 width='100%' align=center>

<tr>
	<td class='label' ><fmt:message key="Common.Supplier.label" bundle="${common_labels}"/></td>
	<td class='fields'>&nbsp;<select name='supp_code' id='supp_code'value="<%=bean.getSupp_code()%>" <%=codeDisabled%>>
		<%
			out.println(bean.getSupp_code_List());
		%>
		</select><%=bean.getImage("M")%>
	</td>

	<td  class="label"><fmt:message key="eST.ReplacementRTV.label" bundle="${st_labels}"/></td>
	<td class='fields'>&nbsp;<input type="checkbox" value='<%=(bean.getReplacement_grn_yn()).equals("Y")?"Y":"N"%>' name="replacement_grn_yn" <%=bean.getChecked(bean.getReplacement_grn_yn())%> onClick="setMyValue();" <%=replacementGRN_disabled%>></td>	

	<td  class="label"><fmt:message key="Common.EntryCompleted.label" bundle="${common_labels}"/></td>
	<td class='fields'>&nbsp;<input type="checkbox" value="Y" name="entry_completed_yn" id="entry_completed_yn" <%=bean.getChecked(bean.getEntry_completed_yn())%>></td>	
	<td class='fields'>
		<input type=button name="preview" id="preview" value='<fmt:message key="Common.Preview.label" bundle="${common_labels}"/> ' class=button style='width:53' style='height:14pt'  onclick="previewDetails();" <%=preview_disabled%>>
	</td>
	<td >&nbsp;</td>
</tr>


</table>

	<input type="hidden" name="records_to_delete" id="records_to_delete"		value="">
	<input type="hidden" name="mode" id="mode"					value="<%=mode%>">
	<input type="hidden" name="finalized_yn" id="finalized_yn"			value="N">
	<input type="hidden" name="authorized_by_id" id="authorized_by_id"		value="<%=bean.getLoginById()%>">
	<input type="hidden" name="finalize_allowed_yn" id="finalize_allowed_yn"		value="N">
	<input type="hidden" name="item_class_check" id="item_class_check"		value="<%=item_class_based%>">
	<input type="hidden" name="function_id" id="function_id"				value="<%= request.getParameter("function_id") %>">
	<input type="hidden" name="doc_no" id="doc_no"					value="<%=bean.getDoc_no()%>">
	<input type="hidden" name="trn_type" id="trn_type"				value="<%=trn_type%>">
	<input type="hidden" name="rtv_delete_yn" id="rtv_delete_yn"				value="<%=rtv_delete_yn%>">
</form>
<%
//putObjectInBean(bean_id,bean,request);
%>
</body>

</html>

