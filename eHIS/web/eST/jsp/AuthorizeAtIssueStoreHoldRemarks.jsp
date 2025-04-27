<%@ page import="eST.AuthorizeAtIssueStoreBean,java.util.HashMap,java.util.ArrayList" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
String sStyle		=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eST/js/StTransaction.js"></script>
		<script language="JavaScript" src="../../eST/js/AuthorizeAtIssueStore.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script>
			function_id			=		"<%= request.getParameter("function_id") %>"
			menu_id				=		"<%= request.getParameter("menu_id") %>"
			module_id			=		"<%= request.getParameter("module_id") %>"
		</script>
		<title><fmt:message key="eST.AuthorizeAtIssueStoreRemarks.label" bundle="${st_labels}"/></title>
</head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale					=		(String)session.getAttribute("LOCALE");
		String bean_id					=		"authorizeAtIssueStoreBean";
		String bean_name				=		"eST.AuthorizeAtIssueStoreBean";
		AuthorizeAtIssueStoreBean bean	=		(AuthorizeAtIssueStoreBean) getBeanObject(bean_id,bean_name,request);  
		bean.setLanguageId(locale);
		//String remarks					=		bean.checkForNull(bean.getCloseRemarks(),""); //commented for MO-CRF-20173  
		String remarks					= "";  
		String hold_remarks_name = "";//MO-CRF-20192
		remarks =(String) request.getParameter("remarksDesc");
		remarks =	bean.checkForNull(remarks,"");   
		String itemCode = (String) request.getParameter("item_code"); 
		System.out.println("itemCode in AuthorizeAtIssueStoreHoldRemarks.jsp : "+itemCode);  
		System.out.println("itemCode in AuthorizeAtIssueStoreHoldRemarks.jsp : "+bean.getItemHoldRemarksMap(itemCode)); //RemarksMap(itemCode));    
		String holdRemarksDesc = bean.getItemHoldRemarksMap(itemCode);  
		if(holdRemarksDesc==null || holdRemarksDesc.equals(""))
			holdRemarksDesc = ""; 
	%>
<body onload='FocusFirstElement();'>
	<form name= "formAuthorizeAtIssueStoreHoldRemarks">
	<br>
	<table border="0" cellspacing="0" width="100%" align=center>
	  <tr>
		<td  colspan="2">&nbsp;</td>
	  </tr>
	  <tr>
		<td  class="label" nowrap><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<textarea name="hold_remarks" rows="3" cols="40" onKeyPress="checkMaxLimit(this,200);"><%=holdRemarksDesc%></textarea>&nbsp; <!-- added for MO-CRF-20173 -->
		<input type="hidden" name="remarks_code_1" id="remarks_code_1" value = "" >
		<input type='button' class='BUTTON' name='remark' id='remark' value='?' onClick="searchHoldRemarks(remarks_code_1,hold_remarks);"><%=bean.getImage("M")%>
		</td>
	  </tr>
	  <tr>
		<td  colspan="2" class='fields'><input type="button" class="button" name="close" id="close" value="Close" onClick="updateHoldRemarks();"></td>
	  </tr>
	</table>
		<input type="hidden"	name="bean_id" id="bean_id"								value="<%=bean_id%>">
		<input type="hidden"	name="bean_name" id="bean_name"							value="<%=bean_name%>">
		<input type="hidden"	name="lang_id" id="lang_id"								value="<%=locale%>">
		<input type="hidden"	name="rem_trans_type" id="rem_trans_type"						value="REQ">
		<input type="hidden"	name="hold_remarks_name" id="hold_remarks_name"					value="<%=hold_remarks_name%>"> 
		<input type="hidden"	name="SQL_ST_TRN_REMARKS_LOOKUP_SELECT" id="SQL_ST_TRN_REMARKS_LOOKUP_SELECT"		value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_TRN_REMARKS_LOOKUP_SELECT")%>">
		<input type="hidden"	name="itemCode" id="itemCode"								value="<%=itemCode%>"><!-- MO-CRF-20173 -->

<%
		putObjectInBean(bean_id,bean,request);
%>
	</form>
	</body>
</html>

