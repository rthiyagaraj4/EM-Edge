<!DOCTYPE html>
  <%@ page import=" eST.*, eST.Common.* , eCommon.Common.*,  java.util.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<!-- 	<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
		String sStyle		=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
	<script language="JavaScript" src="../../eST/js/StTransaction.js"></script>
	<script language="JavaScript" src="../../eST/js/CancelRequest.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<style>
textarea {
  resize: none;
}
</style>

    <script>
        function_id				=		"<%= request.getParameter("function_id") %>"
		menu_id					=		"<%= request.getParameter("menu_id") %>"
		module_id				=		"<%= request.getParameter("module_id") %>"
    </script>
	<title><fmt:message key="Common.CancellationRemarks.label" bundle="${common_labels}"/></title>
</head>
<%
		String bean_id			=		"cancelRequestBean";
		String bean_name		=		"eST.CancelRequestBean";

		request.setCharacterEncoding("UTF-8");
		String locale			=		(String)session.getAttribute("LOCALE");
		

		String doc_type_code	=		request.getParameter("doc_type_code").trim();
		String doc_no			=		request.getParameter("doc_no").trim();

		CancelRequestBean bean  =		(CancelRequestBean) getBeanObject(bean_id,bean_name,request);  
		bean.setLanguageId(locale);
		String key				=		doc_type_code+"-"+doc_no;
		String remarks			=		bean.getRemarks(key);
		String remarks_code     =       bean.getRemarks_code(key); //16/08/12
	%>
<body onload='FocusFirstElement();'>
	<form name= "formCancelRequestRemarks">
	<br>
	<table border="0" cellspacing="0" width="100%" align=center>
	  <tr>
		<td  colspan="2">&nbsp;</td>
	  </tr>
	  <tr>
		<td  class="label" nowrap><fmt:message key="Common.CancellationRemarks.label" bundle="${common_labels}"/></td>
		<!--<td class='fields'>&nbsp;&nbsp;<textarea name="remarks" rows="3" cols="40" onKeyPress="return false;" Readonly><%=remarks%></textarea>&nbsp;<input type="hidden" name="remarks_code_1" id="remarks_code_1" value = "<%=remarks_code%>" >
		<input type='button' class='BUTTON' name='remark' id='remark' value='?' onClick="searchRemarks(remarks_code_1,remarks);"><img src="../../eCommon/images/mandatory.gif" align="center"></td> -->
		<!--Added by Rabbani # Bru-HIMS-CRF-118[INC NO:30077] on 19-JULY-2013 Starts -->
		<td class='fields'>&nbsp;&nbsp;<textarea name="remarks" rows="3" cols="40" onpaste ="return false;" onBlur = "validateRemarks();" ><%=remarks%></textarea>&nbsp;<input type="hidden" name="remarks_code_1" id="remarks_code_1" value = "<%=remarks_code%>" >
		<input type='button' class='BUTTON' name='remark' id='remark' value='?' onClick="searchRemarks(remarks_code_1,remarks);"><img src="../../eCommon/images/mandatory.gif" align="center"></td>
	  </tr>
	  <tr>
		<td  colspan="2" class='fields'><input type="button" class="button" name="close" id="close" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick="updateRemarks();"></td>
	  </tr>
	</table>
		<input type="hidden"	name="bean_id" id="bean_id"								value="<%=bean_id%>">
		<input type="hidden"	name="bean_name" id="bean_name"							value="<%=bean_name %>">
		<input type="hidden"	name="doc_type_code" id="doc_type_code"						value="<%=doc_type_code%>">
		<input type="hidden"	name="doc_no" id="doc_no"								value="<%=doc_no%>">
		<input type="hidden"	name="lang_id" id="lang_id"								value="<%=locale%>">
		<input type="hidden"	name="rem_trans_type" id="rem_trans_type"						value="REQ">
		<input type="hidden"	name="SQL_ST_TRN_REMARKS_LOOKUP_SELECT" id="SQL_ST_TRN_REMARKS_LOOKUP_SELECT"		value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_TRN_REMARKS_LOOKUP_SELECT")%>">

	</form>
<%
	putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>

