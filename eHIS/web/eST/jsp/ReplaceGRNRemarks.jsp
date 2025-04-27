<!DOCTYPE html>
 <%@ page import=" eST.*, eST.Common.* , eCommon.Common.*,  java.util.*,java.sql.*,java.lang.*,webbeans.eCommon.*"
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
	<!--<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<!--<script language="JavaScript" src="../../eCommon/js/messages.js"></script> -->
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
	<!--<script language="JavaScript" src="../../eST/js/StMessages.js"></script> -->
		<script language="JavaScript" src="../../eST/js/StTransaction.js"></script>
		<script language="JavaScript" src="../../eST/js/ReplacementGRN.js"></script>
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

		<title>Replacement Goods Receipt Note Remarka </title>
</head>
<%
		String bean_id					=		"replacementGRNBean" ;
	   String bean_name		    		=		"eST.ReplacementGRNBean";

	eST.ReplacementGRNBean bean		=		(eST.ReplacementGRNBean) getBeanObject( bean_id,bean_name, request); 
		bean.setLanguageId(locale);
		String remarks			=		 bean.checkForNull(bean.getRemarks(),"");
		String remarks_code = remarks;
		if(remarks.length()>0)
		{
     String sql= "SELECT mm.remarks_desc  description FROM  mm_trn_remarks_lang_vw  mm, ST_TRN_TYPE_FOR_REMARKS st WHERE  st.trn_remarks_code = mm.trn_remarks_code AND  mm.language_id= ? AND mm.module_id= ?   AND  st.trn_type= ?     AND  mm.trn_remarks_code = ?";
	  String remarks_desc = (String)bean.fetchRecord(sql,new String[]{locale,"ST",bean.checkForNull(bean.getTrn_type(),"GRN"),remarks}).get("DESCRIPTION");
	  remarks =bean.checkForNull(remarks_desc,"");

		}
	%>
<body onload='FocusFirstElement();'>
	<form name= "formReplaceGRNRemarks">
	<br>
	<table border="0" cellspacing="0" width="100%" align=center>
	  <tr>
		<td  colspan="2">&nbsp;</td>
	  </tr>
	  <tr>
		<td  class="label" nowrap><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
		<td class='fields'>
			&nbsp;&nbsp;
			<textarea name="remarks" rows="3" cols="40" readonly  onKeyPress="return false;"><%=remarks%></textarea>&nbsp;<input type="hidden" name="remarks_code_2" id="remarks_code_2" value = '<%=remarks_code%>' >
		<input type='button' class='BUTTON' name='remark' id='remark' value='?' onClick="searchRemarksHeader(remarks_code_2,remarks);">
		</td>
	  </tr>
	  <tr align='right'	>
		<td  colspan="2"><input type="button" class="button" name="close" id="close" value="Close" onClick="updateRemarks();"></td>
	  </tr>
	</table>
		<input type="hidden"	name="bean_id" id="bean_id"								value="<%=bean_id%>">
		<input type="hidden"	name="bean_name" id="bean_name"							value="<%=bean_name %>">
		<input type="hidden"	name="lang_id_1" id="lang_id_1"							value="<%=locale%>">
		<input type="hidden"	name="SQL_ST_TRN_REMARKS_LOOKUP_SELECT" id="SQL_ST_TRN_REMARKS_LOOKUP_SELECT"		value="<%= eST.Common.StRepository.getStKeyValue("SQL_ST_TRN_REMARKS_LOOKUP_SELECT")%>">
		<input type="hidden"	name="bean_trans_type" id="bean_trans_type"						value=''>
		
	</form>
<%
	putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>

