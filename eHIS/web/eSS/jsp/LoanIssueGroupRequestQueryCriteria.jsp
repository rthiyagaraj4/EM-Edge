<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import=" eSS.*, eSS.Common.* , eCommon.Common.*, java.text.*, java.util.*, eSS.Common.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
			request.setCharacterEncoding("UTF-8");
			String locale	 =		(String)session.getAttribute("LOCALE");
			String sStyle	 =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	    <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/LoanIssueGroup.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
	</head>
	<body onLoad="FocusFirstElement();document.formLoanIssueGroupRequestQueryCriteria.submit();" onMouseDown="CodeArrest();" >
	<%
		String req_doc_type_code	=		request.getParameter("req_doc_type_code");
		String req_doc_no			=		request.getParameter("req_doc_no");
		String bean_id			    =		"LoanRequestGroupBean" ;
		String bean_name			=		"eSS.LoanRequestGroupBean";

		LoanRequestGroupBean bean		=		(LoanRequestGroupBean) getBeanObject( bean_id,  bean_name, request);  
		bean.clear();
		bean.setLanguageId(locale);
		bean.setLoginFacilityId((String)session.getAttribute("facility_id")) ;
		bean.setLoginById((String)session.getAttribute("login_user")) ;
		bean.initSsParameter();
		bean.initDoc_type_code();
		if(!req_doc_type_code.equals("")){
			bean.setDoc_type_code(req_doc_type_code);
		}

	%>
		<form name="formLoanIssueGroupRequestQueryCriteria" id="formLoanIssueGroupRequestQueryCriteria" action="../../eSS/jsp/LoanIssueGroupRequestQueryResult.jsp" method="post" target="frameLoanIssueGroupRequestQueryResult" onreset="FocusFirstElement();">
			<table border="0" cellpadding="1" cellspacing="0" width='100%' height='100%' align='center'>
				<tr>
					<td class="label"><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;<select name="doc_type_code" id="doc_type_code">
							<%=bean.getDoc_type_code_List()%></select>
							</td>
					
					<td class="label"><fmt:message key="eSS.DocNo.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<input type='text' name="doc_no" id="doc_no" value="<%=req_doc_no%>" size='8' maxLength='8' class="NUMBER" onKeyPress="return isValidInteger();" onBlur="checkIntegerFormat(this);"></td>
					<td class="label"><fmt:message key="eSS.DocDate.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<input type='text' name="doc_date" id="doc_date" value="" size='10' maxLength='10' onBlur="CheckDate(this,'<%=locale%>');">&nbsp;<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('doc_date');"></img></td>
				</tr>
				<tr>
					<td class="label" nowrap><fmt:message key="Common.RequestedBy.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;<select name="req_by_store_code" id="req_by_store_code" >
							<%=bean.getReq_by_store_code_List()%></select>
							</td>
					<td class="label"><fmt:message key="eSS.RequestedOn.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;<select name="req_on_store_code" id="req_on_store_code" >
							<%=bean.getReq_on_store_code_List()%></select>
							</td>
 					<td  class="label"> </td>
					<td class="label">&nbsp;<input type='submit' class='Button' value='Search' name='search' id='search'></td>
				</tr>
			</table>
			<br>
			<input type="hidden" name="function_id" id="function_id" value="<%=request.getParameter("function_id")%>">
			<input type="hidden" name="orderbycolumns" id="orderbycolumns" value="doc_type_code,doc_no">
	</form>
	</body>
</html>

<%
	putObjectInBean( bean_id,bean,request);
%>

