<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import ="eSS.*, eSS.Common.* , eCommon.Common.*,java.util.Properties,java.util.ArrayList,java.util.Hashtable,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %> 
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle		=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eCommon/js/MstCodeCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
	<script language="javascript" src="../../eSS/js/MaintainROFStatus.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	String mode							=		request.getParameter("mode");
	mode								=		mode.trim();
	java.util.HashMap defaultParameter  =		null;
	String bean_id						=		"maintainROFStatusBean";
	String bean_name					=		"eSS.MaintainROFStatusBean";
	String doc_type_code				=		request.getParameter("doc_type_code");
	String doc_no						=		request.getParameter("doc_no");
	String disabled						=		"";
	String store_code					=		(request.getParameter( "store_code" ) !=null ? (request.getParameter("store_code").trim()):"" );
	boolean editMode					=		false;	
	if ((mode == null) || (mode.equals(""))) 
		return;
	if ( !(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT"))))
		return;

	

	MaintainROFStatusBean bean			=		(MaintainROFStatusBean)getBeanObject( bean_id, bean_name,request); 
	bean.clear();
	bean.setLanguageId(locale);


	bean.setMode(mode.trim());
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
		bean.setDoc_type_code (doc_type_code.trim());
		bean.setDoc_no (doc_no.trim());
		bean.setDefaultDocType(doc_type_code.trim());
		bean.loadData() ;
		editMode		=		true;	
		disabled		=		"disabled";
	}
	else {
		defaultParameter = bean.getSSParameter();
		String default_doc_type_code	=	(String)defaultParameter.get("DEF_PRE_DOC_TYPE_CODE");
		bean.setDefaultDocType(default_doc_type_code);
		
	}
	%>
<body onload='FocusFirstElement();'>
	<form name="formMaintainROFStatus" id="formMaintainROFStatus">
			<table border="0" cellpadding="0" cellspacing="0" width='100%' align='center' height='100%'>
			<tr>
			 <td width='100%' align='center' class="WHITE">
			  <table cellspacing=0 cellpadding=1 width="75%" align=center border=0>
				<tr>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<td class=label ><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
					<td class=label>&nbsp;<select name="doc_type_code" id="doc_type_code" onBlur="validateDocNo(this);" <%=editMode?disabled:""%>><%=bean.getDocTypes()%></select>&nbsp;<IMG src="../../eCommon/images/mandatory.gif" align=center></td>
				</tr>
				<tr>
				<td>&nbsp;</td><td>&nbsp;</td>
				</tr>
				<tr>
					<td class=label ><fmt:message key="eSS.DocNo.label" bundle="${ss_labels}"/></td>
					<td class=label>&nbsp;<input CLASS="NUMBER" maxLength=8 size=8 name="doc_no" id="doc_no" onKeyPress="return isValidInteger();" disabled value="<%=bean.getDoc_no()%>" onBlur="isValidDocNo(this);">&nbsp;<IMG src="../../eCommon/images/mandatory.gif" align=center ></td>
				</tr>
				<tr>
					<td>&nbsp;</td><td>&nbsp;</td>
				</tr>
				<tr>
					<td class=label ><fmt:message key="eSS.DocDate.label" bundle="${ss_labels}"/></td>
					<!-- onBlur="CheckDate(this);" -->
					<td class=label>&nbsp;<input type="text" maxLength=10 size=10 name="doc_date" id="doc_date" value="<%=com.ehis.util.DateUtils.convertDate(bean.getDoc_date(),"DMY","en",locale)%>" onBlur="CheckDate(this);" <%=disabled%>>&nbsp;<IMG src="../../eCommon/images/mandatory.gif" align=center></td>
				<tr>
					<td>&nbsp;</td><td>&nbsp;</td>
				</tr>
				<tr>
					<td class=label ><fmt:message key="eSS.DocRef.label" bundle="${ss_labels}"/></td>
					<td class=label>&nbsp;<input maxLength=15 size=15 name="doc_ref" id="doc_ref" value="<%=bean.checkForNull(bean.getDoc_ref())%>" <%=disabled%>> </td></TR>
				</tr>
				<tr>
					<td>&nbsp;</td><td>&nbsp;</td>
				</tr>
				<tr>
				    <td class=label ><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
					<td class=label>&nbsp;<select name="store_code" id="store_code" <%=disabled%>> <%=bean.getStores(store_code)%></select>&nbsp;<IMG src="../../eCommon/images/mandatory.gif" align=center></td>
				<tr>
					<td>&nbsp;</td><td>&nbsp;</td>
				</tr>
				<tr>
				    <td class=label ><fmt:message key="eSS.ProcessStage.label" bundle="${ss_labels}"/></td>
					<td class=label>&nbsp;<select name="process_stage_code" id="process_stage_code" > <%=bean.getProcess()%></select>&nbsp;</td>
				<tr>
					<td>&nbsp;</td><td>&nbsp;</td>
				</tr>
				<tr>
				    <td class=label ><fmt:message key="eSS.ProcessRemarks.label" bundle="${ss_labels}"/></td>
					<td class=label>&nbsp;<textarea rows="3" cols="30" name="process_remarks" onKeyPress="return setTextAreaMaxLength(this,200);" onBlur="checkSetTextAreaMaxLength(this,200);" ><%=bean.getProcess_remarks()%></textarea>&nbsp;</td>
				<tr>
					<td>&nbsp;</td><td>&nbsp;</td>
				</tr>
			   </table>
			</td>
			</tr>
			</table>
			<input type='hidden' name="facility_id" id="facility_id"			value="<%=bean.getLoginFacilityId() %>">
			<input type='hidden' name="trn_type" id="trn_type"			value="ROF">
			<input type='hidden' name="store_desc" id="store_desc"			value="">
			<input type='hidden' name="mode" id="mode"				value="<%=mode%>">
			<input type="hidden" name="bean_id" id="bean_id"				value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"			value="<%= bean_name %>">
			<input type="hidden" name="function_id" id="function_id"			value="<%=bean.getFunctionId()%>">
			</form>
			<%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>

