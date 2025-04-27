<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="eSS.Common.SsRepository,eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*" contentType="text/html;charset=UTF-8"%>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %> 

<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String sStyle				=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String locale= (String)session.getAttribute("LOCALE");
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/LoanReturnGroup.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
	<body onLoad='FocusFirstElement();document.formLoanReturnGroup.submit();'onMouseDown="CodeArrest()">
	<%
		String mode					=		request.getParameter( "mode" ) ;

		if (mode != null) {
			mode					=		mode.trim();
		}
		String bean_id				=		"LoanReturnGroupBean" ;
		String bean_name			=		"eSS.LoanReturnGroupBean";

		eSS.LoanReturnGroupBean bean	=		(eSS.LoanReturnGroupBean) getBeanObject( bean_id, bean_name,  request);		
		bean.clear();
		bean.setFr_store_code("");
		bean.setTo_store_code("");
		bean.setMode(mode) ;
		bean.setLanguageId(locale);
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	%>
		<form name="formLoanReturnGroup" id="formLoanReturnGroup" action="../../eSS/jsp/LoanReturnGroupQueryResult.jsp" method="post" target="qryResultLoanReturnGroup" onReset="FocusFirstElement();">
			<table border="0" cellpadding="1" cellspacing="0" width='100%' align='center' title="Query Criteria">
				<tr>
					<td  class="label"><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<select name="doc_type_code" id="doc_type_code"><%=bean.getDocTypes()%></select></td>
					<td class="label"><fmt:message key="eSS.DocNo.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type='text' name="doc_no" id="doc_no" value="" size='8' maxLength='8' class='NUMBER' onBlur="return checkIntegerFormat(this);" onKeyPress="return isValidInteger();"></td>
					<td  class="label"><fmt:message key="eSS.DocDate.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type='text' name="doc_date" id="doc_date" value="" size='10' maxLength='10' onBlur="CheckDate(this,'<%=locale%>');">&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('doc_date');"></img></td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="eSS.ReturnFromStore.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<select name="fr_store_code" id="fr_store_code"><%=bean.getReturnFrom(bean.getFr_store_code())%></select></td>
					<td class="label"><fmt:message key="eSS.ReturnToStore.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<select name="to_store_code" id="to_store_code"><%=bean.getReturnTo(bean.getTo_store_code())%></select></td>
 					<td  class="label"><fmt:message key="eSS.Entry.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<select name="entry_completed_yn" id="entry_completed_yn" >
						<option value='%'><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>		
						<option value='Y' selected><fmt:message key="Common.completed.label" bundle="${common_labels}"/></option>		
						<option value='N'><fmt:message key="eSS.Notcompleted.label" bundle="${ss_labels}"/></option>		
						</select>
					</td>

				</tr>
				<tr>
				<td colspan='4' >&nbsp;</td>
				<td colspan='2' ><input type='submit' class='Button' value='Search' name='search' id='search'></td>
				</tr>
			</table>
			<input type="hidden" name="bean_id" id="bean_id"			value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"		value="<%= bean_name %>">
			<input type="hidden" name="group_code" id="group_code"		value="">
			<input type="hidden" name="orderbycolumns" id="orderbycolumns"  value="doc_type_code,doc_no">
			<input type="hidden" name="function_id" id="function_id"		value="<%=bean.getFunctionId()%>">
			<input type="hidden" name="mode" id="mode"			value="<%=mode%>">
	</form>
	</body>
	<%
putObjectInBean(bean_id,bean,request); 
%>

</html>

