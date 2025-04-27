<!DOCTYPE html>
 <%@ page import=" eST.*, eST.Common.* , eCommon.Common.*,  java.util.*,java.sql.*,java.lang.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"
contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String locale			=		(String)session.getAttribute("LOCALE");
	String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language="JavaScript" src="../../eST/js/StTransaction.js"></script>
		<script language="JavaScript" src="../../eST/js/Issue.js"></script>
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

		<title><fmt:message key="Common.IssueRemarks.label" bundle="${common_labels}"/></title>
</head>
<%
		String bean_id			=		"issueBean";
		String bean_name		=		"eST.IssueBean";
		IssueBean bean			=		(IssueBean) getBeanObject(bean_id, bean_name,request); 
		bean.setLanguageId(locale);
		String remarks			=		 bean.checkForNull(bean.getHdrRemarks(),"");
		String close_yn			=	bean.checkForNull(request.getParameter("close_yn"),"N");
		String hdr_remarks_reqd	=	bean.checkForNull(request.getParameter("hdr_remarks_reqd"),"N");
		//Added by Rabbani INC NO:34758(RUT-CRF-0082) on 07/FEB/2013
			String visibility		=	"visibility:hidden";
			 
			 if((close_yn.equals("Y")) || (hdr_remarks_reqd.equals("Y")))
			  visibility				=		"visibility:visible";
	%>
<body onload='FocusFirstElement();'>
	<form name= "formIssueRemarks" id="formIssueRemarks">
	<br>
	<table border="0" cellspacing="0" width="100%" align=center>
	  <tr>
		<td  colspan="2">&nbsp;</td>
	  </tr>
	  <tr>
		<td  class="label" nowrap><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
		<td class='fields'>
			&nbsp;&nbsp;
			<textarea name="remarks" rows="3" cols="40" onKeyPress="return false;" readonly><%=remarks%></textarea>&nbsp;<input type="hidden" name="remarks_code_2" id="remarks_code_2" value = "<%=bean.getRemarks_code()%>" >
		<input type='button' class='BUTTON' name='remark' id='remark' value='?' onClick="searchRemarksHeader(remarks_code_2,remarks);"><img src="../../eCommon/images/mandatory.gif" style="<%=visibility%>" >
			&nbsp;
		</td>
	  </tr>
	  <tr>
		<td  colspan="2"><input type="button" class="button" name="close" id="close" value="Close" onClick="updateRemarks();"></td>
	  </tr>
	</table>
		<input type="hidden"	name="bean_id" id="bean_id"								value="<%=bean_id%>">
		<input type="hidden"	name="bean_name" id="bean_name"							value="<%=bean_name %>">
		<input type="hidden"	name="lang_id_1" id="lang_id_1"							value="<%=locale%>">
		<input type="hidden"	name="SQL_ST_TRN_REMARKS_LOOKUP_SELECT" id="SQL_ST_TRN_REMARKS_LOOKUP_SELECT"		value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_TRN_REMARKS_LOOKUP_SELECT")%>">
		<input type="hidden"	name="bean_trans_type" id="bean_trans_type"						value='<%=bean.checkForNull(bean.getTrnTypeForRemarks(bean.checkForNull(bean.getDoc_no(),"")),"")%>'>
		<input type="hidden"	name="close_yn" id="close_yn"							        value="<%=close_yn %>">
		<input type="hidden"	name="hdr_remarks_reqd" id="hdr_remarks_reqd"							value="<%=hdr_remarks_reqd %>">
		
	</form>
<%
	putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>

