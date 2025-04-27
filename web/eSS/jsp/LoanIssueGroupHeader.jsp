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
<jsp:useBean id="ffff" class="eSS.LoanIssueGroupBean"/>
<html>
	<head>
<%
			request.setCharacterEncoding("UTF-8");
			String locale					=		(String)session.getAttribute("LOCALE");
			String sStyle					=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
		<script language="javascript" src="../../eSS/js/LoanIssueGroup.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

<%
	String mode;
	String bean_id;
	String bean_name;
	String codeDisabled					=		"";
	String disabled						=		"";
	String docNoDisabled				=		"";
	String function_id;
	String req_doc_no="";
	String doc_no="";
	String doc_type_code_iss="";
	
	mode								=		request.getParameter( "mode" ) ;
	function_id							=		request.getParameter( "function_id" ) ;
	bean_id								=		"LoanIssueGroupBean" ;
	bean_name							=		"eSS.LoanIssueGroupBean";
	

	if ((mode == null) || (mode.equals(""))) 
		return ;
	if ( !(mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
		return ;

	LoanIssueGroupBean bean					=		(LoanIssueGroupBean) getBeanObject( bean_id, bean_name,request );
	bean.setLanguageId(locale) ;
	bean.clear() ;
	bean.setLoginFacilityId((String)session.getAttribute("facility_id")) ;
	bean.setLoginById((String)session.getAttribute("login_user")) ;
	bean.setFunctionId(request.getParameter("function_id"));
	bean.setMode(mode) ;
	bean.setSession(session) ;
	bean.initSsParameter();
	bean.initDoc_type_code();
	bean.initReq_doc_type_code();
	bean.initDoc_date();

	docNoDisabled						=		bean.isDocNoAutoGenYN(bean.getDoc_type_code())?"disabled":docNoDisabled;

	req_doc_no=bean.getReq_doc_no();
	doc_no=bean.getDoc_no();

	bean.setDoc_no(doc_no);
%>
	<body onload="FocusFirstElement();searchRequest();" onMouseDown="CodeArrest();" >
		<form name="formLoanIssueGroupHeader" id="formLoanIssueGroupHeader" onReset="FocusFirstElement();">
			<table border="0" cellpadding="0" cellspacing="0" width='100%' height='100%' align='center'>
				<tr>
					<td  class="label"><fmt:message key="eSS.ReqDocType.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<select name="req_doc_type_code" id="req_doc_type_code" <%=codeDisabled%>>
						<%=bean.getReq_doc_type_code_List()%>
					</select><%=bean.getMandatoryImageTag()%></td>
					<td class="label"><fmt:message key="eSS.ReqDocNo.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type="text" class="NUMBER" value="<%=req_doc_no%>" name="req_doc_no" maxLength="8" size="8" onKeyPress="return isValidInteger();" onBlur="populateRequest();"><input type='button' class='BUTTON' value='?' onClick="searchRequest();"  name="search_request" id="search_request"><%=bean.getMandatoryImageTag()%></td>
					<td class="label" colspan='2'>&nbsp;</td>
				</tr>			
				<tr>
					<td  class="label"><fmt:message key="eSS.IssueStore.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<select name="fr_store_code" id="fr_store_code" >
					<%=bean.getFr_store_code_List()%>
					</select><%=bean.getMandatoryImageTag()%></td>
					<td  class="label"><fmt:message key="eSS.ReceivingStore.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<select name="to_store_code" id="to_store_code" >
					<%=bean.getTo_store_code_List()%>
					</select></td>
					<td  class="label"><fmt:message key="Common.authorizedby.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type="hidden" value="" name="authorized_by_id" id="authorized_by_id"  maxLength="15" size="15"  disabled>
					<input type="text" value="" name="authorized_by_name" id="authorized_by_name"  maxLength="15" size="15"  disabled>
					</td>
				</tr>			
				<tr>
					<td class="label"><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<select name="doc_type_code" id="doc_type_code" <%=codeDisabled%> onChange="checkDoc_type_code()">
						<%=bean.getDoc_type_code_List()%>
					</select><%=bean.getMandatoryImageTag()%></td>
					<td class="label"><fmt:message key="eSS.DocNo.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type="text" class="NUMBER" value="<%=doc_no%>" name="doc_no" maxLength="8" size="8" onKeyPress="return isValidInteger();" <%=codeDisabled%> <%=docNoDisabled%> onBlur="checkIntegerFormat(this);"><%=bean.getMandatoryImageTag()%></td>
					<td align="right" class="label"><fmt:message key="eSS.DocDate.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type="text" value="<%=com.ehis.util.DateUtils.convertDate(bean.getDoc_date(),"DMY","en",locale)%>" name="doc_date"  maxLength="10" size="10" <%=disabled%> onBlur="checkSysdate(doc_date,sysdate);"  >&nbsp;<img id = "doc_date_1"src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('doc_date');"></img><%=bean.getMandatoryImageTag()%></td>
				</tr>			
				<tr>
					<td  class="label"><fmt:message key="eSS.DocRef.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type="text" value="" name="doc_ref" id="doc_ref"  maxLength="15" size="15" ></td>
				<tr>			
			</table>
			<input type="hidden" name="records_to_delete" id="records_to_delete"		value="">
			<input type="hidden" name="mode" id="mode"					value="<%=mode%>">
			<input type="hidden" name="bean_id" id="bean_id"					value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"				value="<%= bean_name %>">
			<input type="hidden" name="function_id" id="function_id"				value="<%= bean.getFunctionId() %>">
			<input type='hidden' name="sysdate" id="sysdate"					value="<%=bean.getSSParameter().get("SYS_DATE").toString()%>">
			<input type="hidden" name="doc_type_code_iss" id="doc_type_code_iss"		value="<%=doc_type_code_iss%>">
		</form>
		
	</body>
</html>

<%
	putObjectInBean( bean_id,bean,request);
%>

