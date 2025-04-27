<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page  import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*, eSS.Common.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %> 
<%-- Mandatory declarations end --%>
<html>
<head>

<%
	request.setCharacterEncoding("UTF-8");
	String sStyle		=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale		=	(String)session.getAttribute("LOCALE");

%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eSS/js/ReturnGroupSummaryReport.js"></script>
	<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onLoad="FocusFirstElement();"onMouseDown="CodeArrest()">
<%
		SsTransaction bean = (SsTransaction) getBeanObject( "ssTransaction", "eSS.Common.SsTransaction",  request );
		bean.clear() ;
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
%>
		
<form name="formReturnGroupSummaryReport" id="formReturnGroupSummaryReport" onReset="FocusFirstElement();" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame">
	<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center'  height='100%'>
	<tr>
	<td width='100%' align='center'  class="WHITE">
	<table border="0" cellpadding="1" cellspacing="0" width='75%' align='center'>
	<tr><th colspan='3' ><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th></tr>
	<tr><td colspan='3'>&nbsp;</td></tr>
	<tr>
		<td>&nbsp;</td>
		<td class='LABEL'>&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
		<td class='LABEL'>&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
	</tr>
	<tr>
		<td class='LABEL' ><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
		<td>&nbsp;<input onKeyPress="return CheckForSpecChars(event);" onBlur="checkSpecialChars(this);" class='UPPER' type='text' maxLength='10' size='10' name="p_from_doc_type" id="p_from_doc_type"><input type='button' class='BUTTON' value="?" onClick="searchDocType(p_from_doc_type)"></td>
		<td>&nbsp;<input onKeyPress="return CheckForSpecChars(event);" onBlur="checkSpecialChars(this);" class='UPPER' type='text' maxLength='10' size='10' name="p_to_doc_type" id="p_to_doc_type"><input type='button' class='BUTTON' value="?" onClick="searchDocType(p_to_doc_type)"></td>
	</tr>
	<tr>
		<td class='LABEL' ><fmt:message key="eSS.DocNo.label" bundle="${ss_labels}"/></td>
		<td>&nbsp;<input class="NUMBER" onKeyPress="return isValidInteger(event);" onBlur="checkIntegerFormat(this);" type='text' maxLength='<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>' size='<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>' name="p_from_doc_no"></td>
		<td>&nbsp;<input class="NUMBER" onKeyPress="return isValidInteger(event);" onBlur="checkIntegerFormat(this);" type='text' maxLength='<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>' size='<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>' name="p_to_doc_no"></td>
	</tr>
	<tr>
		<td class='LABEL' ><fmt:message key="eSS.DocDate.label" bundle="${ss_labels}"/></td>
		<td>&nbsp;<input onBlur="CheckDate(this,'<%=locale%>');"type='text' maxLength='10' size='10' name="p_from_doc_date1" id="p_from_doc_date1" >&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_from_doc_date1');"></img></td>
		<td>&nbsp;<input onBlur="CheckDate(this,'<%=locale%>');" type='text' maxLength='10' size='10' name="p_to_doc_date1" id="p_to_doc_date1">&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_to_doc_date1');"></img></td>
	</tr>
	<tr>
		<td class='LABEL' ><fmt:message key="eSS.FromStore.label" bundle="${ss_labels}"/></td>
		<td>&nbsp;<input onKeyPress="return CheckForSpecChars(event);" onBlur="checkSpecialChars(this);" class='UPPER' type='text' maxLength='6' size='6' name="p_from_fr_store_code" id="p_from_fr_store_code"><input type='button' class='BUTTON' value="?" onClick="searchStoreCode(p_from_fr_store_code)"></td>
		<td>&nbsp;<input onKeyPress="return CheckForSpecChars(event);" onBlur="checkSpecialChars(this);" class='UPPER' type='text' maxLength='6' size='6' name="p_to_fr_store_code" id="p_to_fr_store_code"><input type='button' class='BUTTON' value="?" onClick="searchStoreCode(p_to_fr_store_code)"></td>
	</tr>
	<tr>
		<td class='LABEL'><fmt:message key="eSS.ToStore.label" bundle="${ss_labels}"/></td>
		<td>&nbsp;<input onKeyPress="return CheckForSpecChars(event);" onBlur="checkSpecialChars(this);" class='UPPER' type='text' maxLength='6' size='6' name="p_from_to_store_code" id="p_from_to_store_code"><input type='button' class='BUTTON' value="?" onClick="searchStoreCode(p_from_to_store_code)"></td>
		<td>&nbsp;<input onKeyPress="return CheckForSpecChars(event);" onBlur="checkSpecialChars(this);" class='UPPER' type='text' maxLength='6' size='6' name="p_to_to_store_code" id="p_to_to_store_code"><input type='button' class='BUTTON' value="?" onClick="searchStoreCode(p_to_to_store_code)"></td>
	</tr>
	<tr>
		<td class='LABEL' ><fmt:message key="eSS.Finalized.label" bundle="${ss_labels}"/></td>
		<td>&nbsp;<select name=p_finalized_yn>
		<option value='A'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
		<option value='Y'><fmt:message key="eSS.Finalized.label" bundle="${ss_labels}"/></option>
		<option value='N'><fmt:message key="eSS.UnFinalized.label" bundle="${ss_labels}"/></option>
		</select></td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td class='LABEL' ><fmt:message key="Common.used.label" bundle="${common_labels}"/></td>
		<td>&nbsp;<select name=p_used_yn>
		<option value='A'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
		<option value='Y'><fmt:message key="Common.yes.label" bundle="${common_labels}"/></option>
		<option value='N'><fmt:message key="Common.no.label" bundle="${common_labels}"/></option>
		</select></td>
		<td>&nbsp;</td>
	</tr>
	<tr><td colspan='3'>&nbsp;</td></tr>
	</table>
	</td>
	</tr>
	</table>
	<input type="hidden" name="function_id" id="function_id"								value="<%=bean.getFunctionId()%>">
	<input type="hidden" name="p_module_id" id="p_module_id" 							value="SS">
	<input type="hidden" name="p_report_id" id="p_report_id" 							value="SSBRTGSM">
	<input type="hidden" name="p_from_doc_date" id="p_from_doc_date" 						value="">
	<input type="hidden" name="p_to_doc_date" id="p_to_doc_date" 							value="">
	<input type="hidden" name="p_user_name" id="p_user_name"								value="<%=bean.getLoginById()%>">
	<input type="hidden" name="p_facility_id" id="p_facility_id"							value="<%=bean.getLoginFacilityId()%>">
	<input type="hidden" name="locale" id="locale"									value="<%=locale%>">
	<input type="hidden" name="SQL_SS_STORE_LOOKUP" id="SQL_SS_STORE_LOOKUP"						value="<%=bean.getSsRepositoryValue("SQL_SS_STORE_LOOKUP")%>">
	<input type="hidden" name="SQL_SS_TRN_DOC_TYPE_LOOKUP_FOR_REPORT" id="SQL_SS_TRN_DOC_TYPE_LOOKUP_FOR_REPORT"	value="<%=bean.getSsRepositoryValue("SQL_SS_TRN_DOC_TYPE_LOOKUP_FOR_REPORT")%>">
<%
putObjectInBean("ssTransaction",bean,request); 
%>
</form>
</body>
</html>

