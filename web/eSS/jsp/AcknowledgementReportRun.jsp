<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html;charset=UTF-8"  import="java.util.*, eSS.*, eSS.Common.* , eCommon.Common.*,eSS.PrintCountSheetBean " %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>


<!--<%@ page import="eSS.PrintCountSheetBean" %> -->

 <%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%
	String sStyle		=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	request.setCharacterEncoding("UTF-8");
	String locale		=	(String)session.getAttribute("LOCALE");
%>


<html>
	<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/MstCodeCommon.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/AcknowledgementReport.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%

		String bean_id				=		"reportsMasterCodeBean";
		String bean_name			=		"eSS.ReportsMasterCodeBean";
		String facility_id			=		(String) session.getValue( "facility_id" ) ;
		String user_name			=		(String) session.getValue( "login_user" ) ;
		
		ReportsMasterCodeBean bean	=		(ReportsMasterCodeBean) getBeanObject( bean_id,  bean_name, request);  
		bean.clear();
		

	%>
	<body onLoad="FocusFirstElement();"onMouseDown="CodeArrest()">
		<form name="formDispatch" id="formDispatch" action="../../eCommon/jsp/report_options.jsp"  target="messageFrame" >
		<table border="0" cellpadding="10" cellspacing="0" width='100%' align='center' height='100%'>
			<tr>
			<td width='100%' align='center' class="WHITE">
				<table cellpadding="1" cellspacing="0" width="70%" align="center" border="0">
				<tr><th colspan=4 align=left><fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/></th></tr>
				<tr>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
				</tr>  
				<tr>
					<td align="right">&nbsp;</td>
					<td class="label" class="label">&nbsp;&nbsp;<fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td align="right" >&nbsp;</td>
					<td class="label" class="label">&nbsp;&nbsp;<fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>
					
				<tr>
					<td align="right" class="label"><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
					<td class=label>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_fm_document_type" id="p_fm_document_type" value="" onBlur="convertToUpperCase(this);checkSpecialChars(this);" onKeyPress="return CheckForSpecChars(event);"  class='UPPER'><input class="button" onClick="return searchCode(p_fm_document_type,'Document Type');" type="button" value="?"></td>
					<td class="label">&nbsp;</td>
					<td class=label>&nbsp;&nbsp;<input maxLength=6 size=6 name="p_to_document_type" id="p_to_document_type" value="" onBlur="convertToUpperCase(this);checkSpecialChars(this);" onKeyPress="return CheckForSpecChars(event);"  class='UPPER' ><input class="button" onClick="return searchCode(p_to_document_type,'Document Type');" type="button" value="?"></td>
				</tr>
				<tr>  
					<td align="right" class="label"><fmt:message key="eSS.DocNo.label" bundle="${ss_labels}"/></td>
					<td class=label >&nbsp;&nbsp;<input class="NUMBER" maxLength=8 size=8 name="p_fm_document_no" id="p_fm_document_no" value="" onkeypress="return isValidNumber(this,event,<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>,0);" onBlur="checkIntegerFormat(this);" ></td>
					<td class="label">&nbsp;</td>
					<td class=label>&nbsp;&nbsp;<input class="NUMBER" maxLength=8 size=8 name="p_to_document_no" id="p_to_document_no" value="" onBlur="checkIntegerFormat(this);" onkeypress="return isValidNumber(this,event,<%=bean.getSsRepositoryValue("INTEGER_PRECISION")%>,0);" ></td>
				</tr>
				
				<tr>  
					<td align="right" class="label"><fmt:message key="eSS.DocDate.label" bundle="${ss_labels}"/></td>
					<td class=label>&nbsp;&nbsp;<input maxLength=10 size=10 name="p_fm_doc_date1" id="p_fm_doc_date1" value="" onBlur="CheckDate(this,'<%=locale%>');" >&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_fm_doc_date1');"></img></td>
					<td class="label">&nbsp;</td>
					<td class=label>&nbsp;&nbsp;<input maxLength=10 size=10 name="p_to_doc_date1" id="p_to_doc_date1" value="" onBlur="CheckDate(this,'<%=locale%>');"   >&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('p_to_doc_date1');"></img></td>
				</tr>

				<tr>
					<td align="right" class="label"><fmt:message key="eSS.ServiceLocation.label" bundle="${ss_labels}"/></td>
					<td class=label>&nbsp;&nbsp;<input maxLength=8 size=10 name="p_fm_sl_code" id="p_fm_sl_code" value="" onBlur="convertToUpperCase(this);checkSpecialChars(this);" onKeyPress="return CheckForSpecChars(event);"  class='UPPER' ><input class="button" onClick="return searchCode(p_fm_sl_code,'Service Location');" type="button" value="?" onBlur="convertToUpperCase(this)" ></td>
					<td class="label">&nbsp;</td>
					<td class=label>&nbsp;&nbsp;<input maxLength=8 size=10 name="p_to_sl_code" id="p_to_sl_code" value=""  onBlur="convertToUpperCase(this);checkSpecialChars(this);" onKeyPress="return CheckForSpecChars(event);"  class='UPPER' ><input class="button" onClick='return searchCode(p_to_sl_code,"Service Location");' type="button" value="?"></td>
				</tr>
				<tr>
					<td align="right" class="label"><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
					<td class=label>&nbsp;&nbsp;<input maxLength=6 size=8 name="p_fm_store_code" id="p_fm_store_code" value="" onBlur="convertToUpperCase(this);checkSpecialChars(this);" onKeyPress="return CheckForSpecChars(event);"  class='UPPER' ><input class="button" onClick="return searchCode(p_fm_store_code,'Store');" type="button" value="?" onBlur="convertToUpperCase(this)" ></td>
					<td class="label">&nbsp;</td>
					<td class=label>&nbsp;&nbsp;<input maxLength=6 size=8 name="p_to_store_code" id="p_to_store_code" value=""  onBlur="convertToUpperCase(this);checkSpecialChars(this);" onKeyPress="return CheckForSpecChars(event);"  class='UPPER' ><input class="button" onClick='return searchCode(p_to_store_code,"Store");' type="button" value="?"></td>
				</tr>
				
				<tr>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
					<td align="right">&nbsp;</td>
				</tr>
				</table>
				</td>
				</tr>
			</table>
			
			<input type="hidden" name="P_facility_id" id="P_facility_id"						value="<%=facility_id%>">
			<input type="hidden" name="p_report_id" id="p_report_id"							value="SSBROFAK">
			<input type="hidden" name="p_module_id" id="p_module_id"							value="SS">
			<input type="hidden" name="p_user_name" id="p_user_name"							value="<%=user_name%>">
			<input type="hidden" name="p_fm_doc_date" id="p_fm_doc_date"						value="">
			<input type="hidden" name="p_to_doc_date" id="p_to_doc_date"						value="">
			<input type="hidden" name="locale" id="locale"								value="<%=locale%>">
			<input type="hidden" name="SQL_SS_STORE_LOOKUP" id="SQL_SS_STORE_LOOKUP"					value="<%= eSS.Common.SsRepository.getSsKeyValue("SQL_SS_STORE_LOOKUP")%>">
			<input type="hidden" name="SQL_SS_SERVICE_LOCATION_LOOKUP" id="SQL_SS_SERVICE_LOCATION_LOOKUP"		value="<%= eSS.Common.SsRepository.getSsKeyValue("SQL_SS_SERVICE_LOCATION_LOOKUP")%>">
			<input type="hidden" name="SQL_WRITE_RSN_DOC_TYPE_LIST" id="SQL_WRITE_RSN_DOC_TYPE_LIST"			value="<%= eSS.Common.SsRepository.getSsKeyValue("SQL_STERILE_LABEL_ROF_DOC_TYPE_LIST")%>">
			</form>
<%
	putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

