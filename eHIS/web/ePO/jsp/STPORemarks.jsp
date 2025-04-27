<!DOCTYPE html>
 <%@ page import=" ePO.STPORequestBean, ePO.Common.* , eCommon.Common.*,  java.util.*,java.sql.*,java.lang.*,webbeans.eCommon.*"
contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			=		(String)session.getAttribute("LOCALE");
	String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../ePO/js/PoCommon.js"></script>
		<script language="JavaScript" src="../../ePO/js/PoTransaction.js"></script>
		<script language="JavaScript" src="../../ePO/js/STPORequest.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
		<script>
			function_id			=		"<%= request.getParameter("function_id") %>"
			menu_id				=		"<%= request.getParameter("menu_id") %>"
			module_id			=		"<%= request.getParameter("module_id") %>"
		</script>

		<title><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></title>
</head>
<%
		String bean_id			=		"stporequestBean";
		String bean_name		=		"ePO.STPORequestBean";
		STPORequestBean bean	=		(STPORequestBean) getBeanObject(bean_id, bean_name,request); 
		bean.setLanguageId(locale);
		
		String remarks			=		 bean.checkForNull(request.getParameter("remarks"),"");
		String codedisabled		=		 bean.checkForNull(request.getParameter("codedisabled"),"");

		
		
		String rdOnly = "";
		if(codedisabled.equals("disabled")){
			rdOnly = "readOnly";
		}
	%>
<body onload='FocusFirstElement();'>
	<form name= "formSTPORemarks">
	<br>
	<table border="0" cellspacing="0" width="100%" align=center>
	  <tr>
		<td  colspan="2">&nbsp;</td>
	  </tr>
	  <tr>
		<td  class="label" nowrap><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
		<td class='fields'>
			&nbsp;&nbsp;
			<textarea name="remarks_desc" rows="3" cols="40" onBlur="SPCheckMaxLen('Remarks',this,2000);" onPaste="checkMaxLengthPaste(this,2000);" onKeyPress="checkMaxLimit(this,2000);" <%=rdOnly%> ><%=remarks%></textarea>&nbsp;
			
		<!--	<input type="hidden" name="remarks_code" id="remarks_code" value = "" >
			<input type='button' class='BUTTON' name='remark' id='remark' value='?' onClick="searchRemarks(remarks_code,remarks_desc);"><img src="../../eCommon/images/mandatory.gif" >-->
			<input type="hidden" name="remarks_code_2" id="remarks_code_2" value = "<%=remarks%>" >
			<input type='button' class='BUTTON' name='remark' id='remark' value='?' onClick="searchRemarksHeader(remarks_code_2,remarks_desc);" <%=codedisabled%>>
			&nbsp;
		</td>
	  </tr>
	  <tr>
		<td  align="right" colspan="2"><input type="button" class="button" name="close" id="close" value="Close" onClick="updateRemarks();" ></td>
	  </tr>
	</table>
		<input type="hidden"	name="bean_id" id="bean_id"								value="<%=bean_id%>">
		<input type="hidden"	name="bean_name" id="bean_name"							value="<%=bean_name %>">
		<input type="hidden"	name="lang_id_1" id="lang_id_1"							value="<%=locale%>">
		<input type="hidden"	name="SQL_ST_TRN_REMARKS_LOOKUP_SELECT" id="SQL_ST_TRN_REMARKS_LOOKUP_SELECT"		value="<%= ePO.Common.PoRepository.getPoKeyValue("SQL_ST_TRN_REMARKS_LOOKUP_SELECT")%>">
		<input type="hidden"	name="bean_master_type" id="bean_master_type"						value="POREQN">		
	</form>
<%
	putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>

