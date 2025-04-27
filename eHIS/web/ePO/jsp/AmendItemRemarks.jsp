<!DOCTYPE html>

 <%@ page contentType="text/html;charset=UTF-8"  import=" ePO.*, ePO.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="ePO.ItemRemarks.label" bundle="${po_labels}"/></title>
<%
	    request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
		String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../ePO/js/PoCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
		<script language="JavaScript" src="../../ePO/js/AmendPurchaseOrder.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		 <script>
        function_id				=		 "<%= request.getParameter("function_id") %>"
		
    </script>
	
	</head>
<body >
<%
	
//	String bean_id							=				request.getParameter("bean_id");
//	String bean_name						=				request.getParameter("bean_name");
//	String mode								=				request.getParameter("mode");
//	String ItemRemarks						=				request.getParameter("ItemRemarks");
	String bean_id			=		"amendPurchaseOrderBean";
	String bean_name		=		"ePO.AmendPurchaseOrderBean";
	AmendPurchaseOrderBean bean					=				(AmendPurchaseOrderBean) getBeanObject( bean_id,bean_name,request);
	bean.setLanguageId(locale);
	
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	
	String ItemRemarks			=		 bean.checkForNull(request.getParameter("remarks"),"");
	String codedisabled		=		 bean.checkForNull(request.getParameter("codedisabled"),"");
	String rdOnly = "";
		if(codedisabled.equals("disabled")){
			rdOnly = "readOnly";
		}
	
	

%>
<form name="formItemRemarks" id="formItemRemarks">
	<table border='0' cellpadding='2' cellspacing='0' width='100%' align=center>
				<tr>
				<td  colspan="2">&nbsp;</td>
				</tr>
				<tr>
					<td  class="label" nowrap><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
					<td class=fields>&nbsp;&nbsp;<textarea name="item_remarks" rows='4' cols='40' onBlur="SPCheckMaxLen('Item Remarks',this,2000);" onPaste="checkMaxLengthPaste(this,2000);" onKeyPress="checkMaxLimit(this,2000);"  <%=rdOnly%> ><%=ItemRemarks%></textarea> 
					<input type="hidden" name="remarks_code_2" id="remarks_code_2" value = "<%=ItemRemarks%>" >
					<input type='button' class='BUTTON' name='remark' id='remark' value='?' onClick="searchRemarksHeader(remarks_code_2,item_remarks);"  <%=codedisabled%> >
					</td>
				</tr>
				<tr>
					<td  align= "right" colspan="2">
						<input type="button" class="button" name="Ok" id="Ok" value="Ok"  onClick="exitItemRemarks();">
					</td>
				</tr>
	</table>
	<input type="hidden" name="finalize_yn" id="finalize_yn"			value="No">
	<input type="hidden" name="function_id" id="function_id"			value="<%=bean.getFunctionId()%>">
	<input type="hidden" name="bean_id" id="bean_id"				value="<%=bean_id%>">
	<input type="hidden" name="bean_name" id="bean_name"			value="<%=bean_name%>">
	<input type="hidden"	name="SQL_ST_TRN_REMARKS_LOOKUP_SELECT" id="SQL_ST_TRN_REMARKS_LOOKUP_SELECT"		value="<%= ePO.Common.PoRepository.getPoKeyValue("SQL_ST_TRN_REMARKS_LOOKUP_SELECT")%>">
	<input type="hidden"	name="lang_id_1" id="lang_id_1"							value="<%=locale%>">
	<input type="hidden"	name="bean_master_type" id="bean_master_type"						value="PORDER">
	
</form>
<%
		putObjectInBean(bean_id,bean,request);
		
%>
</body>
</html>

