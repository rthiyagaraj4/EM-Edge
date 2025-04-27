<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ include file="../../eCommon/jsp/Common.jsp" %>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%@ page contentType="text/html;charset=UTF-8" import ="eSS.*, eSS.Common.* , eCommon.Common.*,java.util.Properties,java.util.ArrayList,java.util.Hashtable,webbeans.eCommon.*,java.util.*"%>
<%@ page import="eSS.AssignBinLocationBean" %>

<%
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		request.setCharacterEncoding("UTF-8");
		String locale			=		(String)session.getAttribute("LOCALE");

%>
<html>
	<head>
		<title> </title>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
		<script language='javascript' src='../../eSS/js/AssignBinLocation.js'></script>
		<script language='javascript' src='../../eSS/js/SsCommon.js'></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		String store_desc				=		request.getParameter("store_desc");
		String doc_type_desc			=		request.getParameter("doc_type_desc");
		String group_code				=		request.getParameter("group_code");
		String doc_no					=		request.getParameter("doc_no");
		String doc_date					=		request.getParameter("doc_date");
		String quantity					=		request.getParameter("quantity");
		String total_cost				=		request.getParameter("total_cost");
		String store_code				=		request.getParameter("store_code");
		String doc_ref					=		(request.getParameter( "doc_ref" ) !=null ? (request.getParameter("doc_ref").trim()):"" );
		
		if(doc_ref.equals("null")){
		doc_ref="";}
		String bean_id					=		"assignBinLocationBean";
		String bean_name				=		"eSS.AssignBinLocationBean";
		AssignBinLocationBean bean		=		(AssignBinLocationBean) getBeanObject( bean_id,  bean_name, request);  bean.setLanguageId(locale);
		bean.setGroup_code(group_code);
		bean.setDoc_no(doc_no);
		bean.setDoc_date(doc_date);
		bean.setPrepare_qty(quantity);
		bean.setTotal_cost(total_cost);
		bean.setStore_code(store_code);
		bean.setDoc_ref(doc_ref);
	

	%>	
	<body onMouseDown="CodeArrest();" >
		<form name="formAssignBinLocationHeader" id="formAssignBinLocationHeader"  >
			<table border="0" cellpadding="0" cellspacing="0" width='100%' height='100%' align='center'><tr><td>
				<table border="0" cellpadding="0" cellspacing="0" width='100%' >
				<tr>
					<td  class="label"><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<select name="doc_type_code" id="doc_type_code" disabled>
					<option value='doc_type_desc'><%=doc_type_desc%></option></select><%=bean.getMandatoryImageTag()%></td>
					<td  class="label"><fmt:message key="eSS.DocNo.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type="text" name="doc_no" id="doc_no" class="NUMBER" maxLength="8" size="8" onBlur="return checkIntegerFormat(this);" disabled value="<%=bean.getDoc_no()%>"><%=bean.getMandatoryImageTag()%></td>
					<td  class="label"><fmt:message key="eSS.DocDate.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type="text" name="doc_date" id="doc_date" maxLength="10" size="10" disabled value="<%=bean.getDoc_date()%>"><%=bean.getMandatoryImageTag()%></td>
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<select name="store_code" id="store_code" disabled><option value='store_desc'><%=store_desc%></option></select><%=bean.getMandatoryImageTag()%></td>
					<td  class="label"><fmt:message key="Common.Group.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type="text" name="group_code" id="group_code" disabled value="<%=bean.getGroupName()%>"><%=bean.getMandatoryImageTag()%></td>
					<td  class="label"><fmt:message key="eSS.DocRef.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type="text" name="doc_ref" id="doc_ref" disabled value="<%=bean.checkForNull(bean.getDoc_ref())%>"></td>
				</tr>
				<tr>
					<td class="label"><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type="text" name="prepare_qty" id="prepare_qty" class="NUMBER" maxLength="12" size="12" disabled  value="<%=bean.getPrepare_qty()%>" onBlur="return checkIntegerFormat(this);"><%=bean.getMandatoryImageTag()%></td>
					<td  class="label"><fmt:message key="eSS.TotalValue.label" bundle="${ss_labels}"/></td>
					<td class="label">&nbsp;&nbsp;<input type="text" name="total_value" id="total_value" class="NUMBER" maxLength="12" size="12" disabled value="<%=bean.getTotal_cost()%>"></td>
					<td>&nbsp;</td>
					<td>&nbsp;</td>
				</tr>
				</table>
				</td>
				</tr>
			</table>
			<input type="hidden" name="facility_id" id="facility_id" value="">
			
			<input type="hidden" name="records_for_submission" id="records_for_submission" value="">
			<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
		</form>
<%
	putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>

