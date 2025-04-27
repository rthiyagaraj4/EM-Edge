<!DOCTYPE html>
  <%@ page import="ePO.QuotationBean" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html> 
<head>
<%
		String sStyle		=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../ePO/js/PoCommon.js"></script>
	<script language="JavaScript" src="../../ePO/js/PoTransaction.js"></script>
	<script language="JavaScript" src="../../ePO/js/Quotation.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <script>
        function_id				=		"<%= request.getParameter("function_id") %>"
		menu_id					=		"<%= request.getParameter("menu_id") %>"
		module_id				=		"<%= request.getParameter("module_id") %>"
    </script>
	<title><fmt:message key="ePO.EvalRemarks.label" bundle="${po_labels}"/></title>
</head>
<%
		String bean_id			=		"quotationBean";
		String bean_name		=		"ePO.QuotationBean";

		request.setCharacterEncoding("UTF-8");
		String locale			=		(String)session.getAttribute("LOCALE");
		
		QuotationBean bean  =		(QuotationBean) getBeanObject(bean_id,bean_name,request);  
		bean.setLanguageId(locale);
		
		String item_code			=		request.getParameter("item_code").trim();
		String master_code			=		request.getParameter("master_code").trim();
		String eval_rmks			=		request.getParameter("eval_rmks").trim();
		
		String key = "";
		String remarks			= "";
		String remarks_code     = "";
			
			if(eval_rmks != null && eval_rmks != ""){
				remarks			=		eval_rmks;
			}else{
				key				=		item_code+"-"+master_code;
				remarks			=		bean.getRemarks(key);
				remarks_code     =       bean.getRemarks_code(key);
			}	
			
			
			
	%>
<body onload='FocusFirstElement();'>
	<form name= "formEvalRemarks">
	<br>
	<table border="0" cellspacing="0" width="100%" align=center>
	  <tr>
		<td  colspan="2">&nbsp;</td>
	  </tr>
	  <tr>
		<td  class="label" nowrap><fmt:message key="ePO.EvalRemarks.label" bundle="${po_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<textarea name="remarks" rows="3" cols="40"  onKeyPress="checkMaxLimit(this,1000);" onPaste="checkMaxLengthPaste(this,1000);" onBlur="SPCheckMaxLen('Remarks',this,1000);"><%=remarks%></textarea>&nbsp;<input type="hidden" name="remarks_code_1" id="remarks_code_1" value = "<%=remarks_code%>" >
		<input type="hidden" name="remarks_code_2" id="remarks_code_2" value = "<%=remarks%>" >
		<input type='button' class='BUTTON' name='remark' id='remark' value='?' onClick="searchRemarksHeader(remarks_code_2,remarks);">
		 </td>
	  </tr>
	  <tr>
		 <!--<td  colspan="2" class='fields' align='right'><input type="button" class="button" name="close" id="close" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick="updateRemarks();"></td>
	      </tr>-->
		  <tr>
		  </tr>
	     <tr>
		 <td  colspan="2" align="right"><input type="button" class="button" name="close" id="close" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick="updateRemarks();"></td>
	     </tr>
		 
	  </table>
		<input type="hidden"	name="bean_id" id="bean_id"								value="<%=bean_id%>">
		<input type="hidden"	name="bean_name" id="bean_name"							value="<%=bean_name %>">
		<input type="hidden"	name="item_code" id="item_code"								value="<%=item_code%>">
		<input type="hidden"	name="master_code" id="master_code"								value="<%=master_code%>">
		<input type="hidden"	name="lang_id" id="lang_id"								value="<%=locale%>">
		<input type="hidden"	name="rem_trans_type" id="rem_trans_type"						value="REQ">
		<input type="hidden"	name="SQL_ST_TRN_REMARKS_LOOKUP_SELECT" id="SQL_ST_TRN_REMARKS_LOOKUP_SELECT"		value="<%= ePO.Common.PoRepository.getPoKeyValue("SQL_ST_TRN_REMARKS_LOOKUP_SELECT")%>">
		<input type="hidden"	name="lang_id_1" id="lang_id_1"							value="<%=locale%>">
		<input type="hidden"	name="bean_master_type" id="bean_master_type"						value="POQUOT">

	 </form>
<%
	putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>

