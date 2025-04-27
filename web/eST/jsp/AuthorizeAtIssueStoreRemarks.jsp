<!DOCTYPE html>
<%@ page import="eST.AuthorizeAtIssueStoreBean,java.util.HashMap,java.util.ArrayList,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<!-- 	<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
		
		String sStyle		=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eST/js/StTransaction.js"></script>
		<script language="JavaScript" src="../../eST/js/AuthorizeAtIssueStore.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<style>
textarea {
  resize: none;
}
</style>
		<script>
			function_id			=		"<%= request.getParameter("function_id") %>"
			menu_id				=		"<%= request.getParameter("menu_id") %>"
			module_id			=		"<%= request.getParameter("module_id") %>"
		</script>
		<title><fmt:message key="eST.AuthorizeAtIssueStoreRemarks.label" bundle="${st_labels}"/></title>
</head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	
		String locale					=		(String)session.getAttribute("LOCALE");
		String bean_id					=		"authorizeAtIssueStoreBean";
		String bean_name				=		"eST.AuthorizeAtIssueStoreBean";
		AuthorizeAtIssueStoreBean bean	=		(AuthorizeAtIssueStoreBean) getBeanObject(bean_id,bean_name,request);  
		bean.setLanguageId(locale);
		String remarks					=		bean.checkForNull(bean.getRemarks(),"");
	%>
<body onload='FocusFirstElement();'>
	<form name= "formAuthorizeAtIssueStoreRemarks" id="formAuthorizeAtIssueStoreRemarks">
	<br>
	<table border="0" cellspacing="0" width="100%" align=center>
	  <tr>
		<td  colspan="2">&nbsp;</td>
	  </tr>
	  <tr>
		<td  class="label" nowrap><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
		<!-- <td class='fields'>&nbsp;&nbsp;<textarea name="remarks" rows="3" cols="40" onKeyPress="return false;"><%=remarks%></textarea>&nbsp;  --><!-- commented for MO-CRF-20173 -->
		<td class='fields'>&nbsp;&nbsp;<textarea name="remarks" rows="3" cols="40" onKeyPress="checkMaxLimit(this,182);"><%=remarks%></textarea>&nbsp; <!-- added for MO-CRF-20173 -->
		<input type="hidden" name="remarks_code_1" id="remarks_code_1" value = "" >
		<input type='button' class='BUTTON' name='remark' id='remark' value='?' onClick="searchRemarks(remarks_code_1,remarks);"><%=bean.getImage("M")%>
		</td>
	  </tr>
	  <tr>
		<td  colspan="2" class='fields'><input type="button" class="button" name="close" id="close" value="Close" onClick="updateRemarks();"></td>
	  </tr>
	</table>
		<input type="hidden"	name="bean_id" id="bean_id"								value="<%=bean_id%>">
		<input type="hidden"	name="bean_name" id="bean_name"							value="<%=bean_name%>">
		<input type="hidden"	name="lang_id" id="lang_id"								value="<%=locale%>">
		<input type="hidden"	name="rem_trans_type" id="rem_trans_type"						value="REQ">
		<input type="hidden"	name="SQL_ST_TRN_REMARKS_LOOKUP_SELECT" id="SQL_ST_TRN_REMARKS_LOOKUP_SELECT"		value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_TRN_REMARKS_LOOKUP_SELECT")%>">

<%
		putObjectInBean(bean_id,bean,request);
%>
	</form>
	</body>
</html>

