<!DOCTYPE html>
 <%@ page import="ePO.PurchaseOrderCancelBean" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html> 
<head>
<%
		String sStyle		=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String locale		=		(String)session.getAttribute("LOCALE");
		request.setCharacterEncoding("UTF-8");
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../ePO/js/PoCommon.js"></script>
	<script language="JavaScript" src="../../ePO/js/PoTransaction.js"></script>
	<script language="JavaScript" src="../../ePO/js/PurchaseOrderCancel.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <script>
        function_id				=		"<%= request.getParameter("function_id") %>"
		menu_id					=		"<%= request.getParameter("menu_id") %>"
		module_id				=		"<%= request.getParameter("module_id") %>"
    </script>
<%
		String bean_id			=		"PurchaseOrderCancelBean";
		String bean_name		=		"ePO.PurchaseOrderCancelBean";

		PurchaseOrderCancelBean bean  =		(PurchaseOrderCancelBean) getBeanObject(bean_id,bean_name,request);  
		bean.setLanguageId(locale);

		String po_close			=		request.getParameter("po_close").trim();
		String po_cancel		=		request.getParameter("po_cancel").trim();
		String po_order_mode	=		request.getParameter("po_order_mode").trim();
		String po_no			=		request.getParameter("po_no").trim();
		String key				=		po_order_mode+"-"+po_no;
		String remarks			=		bean.getRemarks(key);
		String remarks_code     =       bean.getRemarks_code(key);

%>

	<title>
	<% if(po_close.equals("Y")){%>
		Close Remarks
	<%}else if(po_cancel.equals("Y")){%>
		<fmt:message key="Common.CancellationRemarks.label" bundle="${common_labels}"/>
	<%}%>
	</title>
</head>
<body onload='FocusFirstElement();'>
	<form name= "formSTPOCancelOrderRemarks">
	<br>
	<table border="0" cellspacing="0" width="100%" align=center>
	  <tr>
		<td  colspan="2">&nbsp;</td>
	  </tr>
	  <tr>
		<td  class="label" nowrap>
		<% if(po_close.equals("Y")){%>
			Close Remarks
		<%}else if(po_cancel.equals("Y")){%>
			<fmt:message key="Common.CancellationRemarks.label" bundle="${common_labels}"/>
		<%}%>
		</td>
		<td class='fields'>&nbsp;&nbsp;<textarea name="remarks" rows="3" cols="40"  onKeyPress="checkMaxLimit(this,2000);" onPaste="checkMaxLengthPaste(this,2000);" onBlur="SPCheckMaxLen('Remarks',this,2000);"><%=bean.checkForNull(remarks)%></textarea>&nbsp;
		<input type="hidden" name="remarks_code_1" id="remarks_code_1" value = "<%=bean.checkForNull(remarks_code)%>" >
		<input type='button' class='BUTTON' name='remark' id='remark' value='?' onClick="searchRemarksHeader(remarks_code_1,remarks);" >
		<img src="../../eCommon/images/mandatory.gif" align="center">
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
		<input type="hidden"	name="po_order_mode" id="po_order_mode"						value="<%=po_order_mode%>">
		<input type="hidden"	name="po_no" id="po_no"								value="<%=po_no%>">
		<input type="hidden"	name="lang_id" id="lang_id"								value="<%=locale%>">
		<input type="hidden"	name="rem_trans_type" id="rem_trans_type"						value="REQ">
		<input type="hidden"	name="SQL_ST_TRN_REMARKS_LOOKUP_SELECT" id="SQL_ST_TRN_REMARKS_LOOKUP_SELECT"		value="<%= ePO.Common.PoRepository.getPoKeyValue("SQL_ST_TRN_REMARKS_LOOKUP_SELECT")%>">
		<input type="hidden"	name="lang_id_1" id="lang_id_1"							value="<%=locale%>">
		<input type="hidden"	name="bean_master_type" id="bean_master_type"						value="PORDER">

	 </form>
<%
	putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>

