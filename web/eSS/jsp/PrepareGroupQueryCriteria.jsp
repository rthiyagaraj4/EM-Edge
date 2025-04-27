<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page contentType="text/html;charset=UTF-8" import="eSS.Common.SsRepository, java.sql.*, java.util.*" %>
<html>
<head>
<%
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		request.setCharacterEncoding("UTF-8");
		String locale			=		(String)session.getAttribute("LOCALE");

%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/SsTransaction.js"></script>
		<script language="javascript" src="../../eSS/js/PrepareGroup.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
	<body onLoad="FocusFirstElement();document.formPrepareGroup.submit();" onMouseDown="CodeArrest()">
	<%
		String mode				=		request.getParameter( "mode" ) ;
		if (mode != null) {
			mode				=		mode.trim();
		}
		String bean_id			=		"PrepareGroupBean" ;
		String bean_name		=		"eSS.PrepareGroupBean";

		//Added by Martin
		eSS.PrepareGroupBean bean = (eSS.PrepareGroupBean) getBeanObject( bean_id, bean_name,request  );  
		bean.clear();

		bean.setMode(mode) ;
		bean.setLanguageId(locale);
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
		
		java.util.HashMap defaultParameter		=		bean.getSSParameter();
		String default_doc_type_code			=		(String)defaultParameter.get("DEF_PRE_DOC_TYPE_CODE");
		String default_store_code				=		(String)defaultParameter.get("DEF_STORE_CODE_FOR_PRE");
		bean.setDefaultDocType(default_doc_type_code);
		bean.setDefaultStoreCode(default_store_code);
	%>
		<form name="formPrepareGroup" id="formPrepareGroup" action="../../eSS/jsp/PrepareGroupQueryResult.jsp" method="post" target="qryResultPrepareGroup" onReset='FocusFirstElement();'>
			<table border="0" cellpadding="1" cellspacing="0" width='100%' align='center' title="Query Criteria">
				<tr>
					<td  class="label"><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;<select name="doc_type_code" id="doc_type_code"><%=bean.getDocTypes()%></select></td>
					<td  class="label"><fmt:message key="eSS.DocNo.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<input type='text' name="doc_no" id="doc_no" value="" size='8' maxLength='8' class='NUMBER' onKeyPress="return isValidInteger();" onBlur="checkIntegerFormat(this);"></td>
					<td  class="label"><fmt:message key="eSS.DocDate.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<input type='text' name="doc_date" id="doc_date" value="" size='10' maxLength='10' onBlur="CheckDate(this);">&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" id=Calendar onClick="return showCalendar('doc_date');"></img></td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;<select name="store_code" id="store_code" ><%=bean.getStores()%></select></td>
					<td  class="label"><fmt:message key="Common.Group.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;<input type='text' name="group_desc" id="group_desc" value=""  maxLength='15' size='15'><input class="button" type="button" value="?" onclick="searchCode(group_code,group_desc);"></td>
 					<td  class="label"> </td>
					<td class="label">&nbsp;&nbsp;</td>
				</tr>
				<tr>
				<td colspan='6' align='right'><input type='button' class='Button' value='Search' name='search' id='search' onClick="return submitCriteria();"></td>
				</tr>
			</table>
			<input type="hidden" name="SQL_SS_PREPARE_GROUP_LOOKUP" id="SQL_SS_PREPARE_GROUP_LOOKUP"		value="<%= eSS.Common.SsRepository.getSsKeyValue("SQL_SS_PREPARE_GROUP_LOOKUP")%>">
			<input type="hidden" name="bean_id" id="bean_id"							value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"						value="<%= bean_name %>">
			<input type="hidden" name="locale" id="locale"							value="<%= locale %>">
			<input type="hidden" name="group_code" id="group_code"						value="">
			<input type="hidden" name="orderbycolumns" id="orderbycolumns"					value="doc_type_code,doc_no">
			<input type="hidden" name="lookup" id="lookup"							value="lookup">
			<input type="hidden" name="function_id" id="function_id"						value="<%=bean.getFunctionId()%>">
			<input type='hidden' name="trn_type" id="trn_type"						value="PRE">
	</form>
	<%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>

