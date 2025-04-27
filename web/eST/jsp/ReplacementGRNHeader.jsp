<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  import=" eST.*, eST.Common.* , eCommon.Common.*, java.text.*, java.util.*, eST.Common.*,java.lang.*"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
	request.setCharacterEncoding("UTF-8");
	String locale		=	(String)session.getAttribute("LOCALE");
	String sStyle		=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eST/js/StHeader.js"></script>
		<script language="JavaScript" src="../../eST/js/ReplacementGRN.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="javaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
<body onLoad="FocusFirstElement();">
<form name="formGoodsReceivedNoteHeader" id="formGoodsReceivedNoteHeader">
<%
	String bean_id					=		"replacementGRNBean" ;
	String bean_name				=		"eST.ReplacementGRNBean";

	eST.ReplacementGRNBean bean		=		(eST.ReplacementGRNBean) getBeanObject( bean_id,bean_name, request);
	bean.setLanguageId(locale);
	String mode						=		request.getParameter("mode");
	String trn_type					=		"GRN";
	String sql_id					=		"SQL_ST_GRN_STORE_SELECT";
	String codeDisabled				=		"";
	String preview_disabled			=		"disabled";
	String Receipt_date				=		"";
	 Receipt_date					=		bean.getReceipt_date();
	 String item_class_based		=		bean.getGRNItemClassBased(trn_type);
	//sys_date						=		bean.getSystemDate().toString();

	if(!locale.equals("en"))
	{
	   
		Receipt_date				=	    com.ehis.util.DateUtils.convertDate(Receipt_date,"DMY","en",locale);
		}
	else
		{
		Receipt_date				=		Receipt_date;
		}

	if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
		codeDisabled				=		"disabled";
		preview_disabled			=		"";
	}
%>
<jsp:include page="../../eST/jsp/StHeader.jsp" > 
	<jsp:param name="mode"				value="<%=mode%>" />
	<jsp:param name="trn_type"			value="<%=trn_type%>" />
	<jsp:param name="storeSQLID"		value="<%=sql_id%>" />
	<jsp:param name="doc_type_code"		value="<%=bean.getDoc_type_code()%>" />
	<jsp:param name="doc_no"			value="<%=bean.getDoc_no()%>" />
	<jsp:param name="doc_date"			value="<%=bean.getDoc_date()%>" />
	<jsp:param name="doc_ref"			value="<%=bean.getDoc_ref()%>" />
	<jsp:param name="store_code"		value="<%=bean.getStore_code()%>" />
	<jsp:param name="item_class_code"	value="<%=bean.getItem_class_code()%>" />
	<jsp:param name="bean_id"			value="<%=bean_id%>" />
	<jsp:param name="bean_name"			value="<%=bean_name%>" />
</jsp:include>
<table cellpadding=0 cellspacing=0 border=0 width='100%' align="center">
<tr>
	<td class='label' ><fmt:message key="eST.PONo.label" bundle="${st_labels}"/></td>
	<td class='fields'>&nbsp;&nbsp;<input type='text' name='po_no' id='po_no' size='10' maxLength='20' value="<%=bean.getPo_no()%>" onKeyPress="return CheckForSpecialChars(event);" disabled>
	</td>
	<td class='label' ><fmt:message key="Common.Supplier.label" bundle="${common_labels}"/></td>
	<td class='fields'>&nbsp;<select name='supp_code' id='supp_code'value="<%=bean.getSupp_code()%>">
		<%
	/*	if (bean.isModuleInstalled("AP")) */
			out.println(bean.getSupp_code_List());
/*		else
			out.println(bean.getStRepositoryValue("DEFAULT_LIST_OPTION"));*/
		%>
		</select><%=bean.getImage("M")%>
	</td>
	<td class='label' ><fmt:message key="eST.Currency.label" bundle="${st_labels}"/></td>
	<td class='fields'>&nbsp;<select name="currency_code" id="currency_code" <%=codeDisabled%> disabled>
	<%=bean.getCurrency_code_List()%>
	</select>
	</td>
	<td  class="label"><fmt:message key="Common.receiptdate.label" bundle="${common_labels}"/></td>
	<td class='fields'>&nbsp;<input type="text" value="<%=Receipt_date%>" name="receipt_date"  id="receipt_date" maxLength="10" size="10" onBlur="checkSysdate(receipt_date,sysdate);" ><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar  ('receipt_date');" onBlur="receipt_date.focus()" ></img><%=bean.getImage("M")%></td>	
</tr>
<tr>
	<!-- <td align="right" class="label">Entry Completed</td>
	<td>&nbsp;<input type="checkbox" value="Y" name="entry_completed_yn" id="entry_completed_yn"  <%=bean.getChecked(bean.getEntry_completed_yn())%>></td>	-->
	<td colspan='5'>&nbsp;</td>
	<td class="label" ><label onMouseOver="changeCursor(this);"  class="label" onClick = "showRemarks();"><font class='HYPERLINK'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></font></label></td>
	<td class='fields'>
		<input type=button name="preview" id="preview" value='<fmt:message key="Common.Preview.label" bundle="${common_labels}"/>' class=button style='width:53' style='height:14pt' <%=preview_disabled%> onclick="previewDetails();">
	</td>
</tr>
</table>
	<input type="hidden" name="records_to_delete" id="records_to_delete"		value="">
	<input type="hidden" name="mode" id="mode"					value="<%=mode%>">
	<input type="hidden" name="finalized_yn" id="finalized_yn"			value="N">
	<input type="hidden" name="authorized_by_id" id="authorized_by_id"		value="<%=bean.getLoginById()%>">
	<input type="hidden" name="finalize_allowed_yn" id="finalize_allowed_yn"		value="N">
	<input type="hidden" name="function_id" id="function_id"				value="<%= request.getParameter("function_id") %>">
	<input type='hidden' name="sysdate" id="sysdate"					value="<%=com.ehis.util.DateUtils.getCurrentDate("DMY",locale).toString()%>">
	<input type="hidden" name="entry_completed_yn" id="entry_completed_yn"		value="Y">
	<input type="hidden" name="item_class_check" id="item_class_check"		value="<%=item_class_based%>">
	<input type="hidden" name="remarks" id="remarks"				value="<%=bean.checkForNull(bean.getRemarks(),"")%> " >
	
</form>
<%
//putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

