<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8"  import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*, eSS.Common.*" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
<head>
<%
		String sStyle		=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		request.setCharacterEncoding("UTF-8");
		String locale		=		(String)session.getAttribute("LOCALE");

%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eSS/js/ROFProcessTimingDetailsReport.js"></script>
	<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onLoad="FocusFirstElement();"onMouseDown="CodeArrest()"> 
<%
		String bean_id			=		"ssTransaction";
		String bean_name		=		"eSS.Common.SsTransaction";
		SsTransaction bean		=		(SsTransaction)getBeanObject( bean_id, bean_name, request ) ;
		bean.clear() ;
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
%>
		
<form name="formROFProcessTimingDetail" id="formROFProcessTimingDetail" onReset="FocusFirstElement();" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame">
	<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center'  height='100%'>
	<tr>
	<td width='100%' align='center'  class="WHITE">
	<table border="0" cellpadding="1" cellspacing="0" width='75%' align='center'>
	<tr><th colspan='3' align='left'><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th></tr>
	<tr><td colspan='3'>&nbsp;</td></tr>
	<tr>
		<td>&nbsp;</td>
		<td class='LABEL'>&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
		<td class='LABEL'>&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
	</tr>
	<tr>
		<td class='LABEL' align='right'><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
		<td>&nbsp;<input onKeyPress="return CheckForSpecChars(event);" onBlur="checkSpecialChars(this);" class='UPPER' type='text' maxLength='10' size='10' name="p_from_doc_type" id="p_from_doc_type"><input type='button' class='BUTTON' value="?" onClick="searchDocType(p_from_doc_type)"></td>
		<td>&nbsp;<input onKeyPress="return CheckForSpecChars(event);" onBlur="checkSpecialChars(this);" class='UPPER' type='text' maxLength='10' size='10' name="p_to_doc_type" id="p_to_doc_type"><input type='button' class='BUTTON' value="?" onClick="searchDocType(p_to_doc_type)"></td>
	</tr>
	<tr>
		<td class='LABEL' align='right'><fmt:message key="eSS.DocNo.label" bundle="${ss_labels}"/></td>
		<td>&nbsp;<input class="NUMBER" onKeyPress="return isValidInteger(event);" onBlur="checkIntegerFormat(this);" type='text' maxLength='<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>' size='<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>' name="p_from_doc_no"></td>
		<td>&nbsp;<input class="NUMBER" onKeyPress="return isValidInteger(event);" onBlur="checkIntegerFormat(this);" type='text' maxLength='<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>' size='<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>' name="p_to_doc_no"></td>
	</tr>
	<tr>
		<td class='LABEL' align='right'><fmt:message key="eSS.DocDate.label" bundle="${ss_labels}"/></td>
		<td>&nbsp;<input onBlur="CheckDate(this,'<%=locale%>');" type='text' maxLength='10' size='10' name="p_from_doc_date1" id="p_from_doc_date1">&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_from_doc_date1');"></img></td>
		<td>&nbsp;<input onBlur="CheckDate(this,'<%=locale%>');"  type='text' maxLength='10' size='10' name="p_to_doc_date1" id="p_to_doc_date1">&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_to_doc_date1');"></img></td>
	</tr>
	<tr>
		<td class='LABEL' align='right'><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
		<td>&nbsp;<input onKeyPress="return CheckForSpecChars(event);" onBlur="checkSpecialChars(this);" class='UPPER' type='text' maxLength='6' size='6' name="p_requestor" id="p_requestor"><input type='button' class='BUTTON' value="?" onClick="searchStoreCode(p_requestor)"></td>
		<td>&nbsp;</td>
	</tr>
	<tr><td colspan='3'>&nbsp;</td></tr>
	</table>
	</td>
	</tr>
	</table>
	<input type="hidden" name="function_id" id="function_id"								value="<%=bean.getFunctionId()%>">
	<input type="hidden" name="p_module_id" id="p_module_id" 							value="SS">
	<input type="hidden" name="p_report_id" id="p_report_id" 							value="SSBRFPTD">
	<input type="hidden" name="p_from_doc_date" id="p_from_doc_date" 						value="">
	<input type="hidden" name="p_to_doc_date" id="p_to_doc_date" 							value="">
	<input type="hidden" name="p_user_name" id="p_user_name"								value="<%=bean.getLoginById()%>">
	<input type="hidden" name="p_facility_id" id="p_facility_id"							value="<%=bean.getLoginFacilityId()%>">
	<input type="hidden" name="locale" id="locale"									value="<%=locale%>">
	<input type="hidden" name="SQL_SS_STORE_LOOKUP" id="SQL_SS_STORE_LOOKUP"						value="<%=bean.getSsRepositoryValue("SQL_SS_STORE_LOOKUP")%>">
	<input type="hidden" name="SQL_SS_TRN_DOC_TYPE_LOOKUP_FOR_REPORT" id="SQL_SS_TRN_DOC_TYPE_LOOKUP_FOR_REPORT"	value="<%=bean.getSsRepositoryValue("SQL_SS_TRN_DOC_TYPE_LOOKUP_FOR_REPORT")%>">
</form>
</body>
<%	putObjectInBean(bean_id,bean,request);%>
</html>

