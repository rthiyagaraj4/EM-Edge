<!DOCTYPE html>
  <%@ page import="ePO.DeliveryOrderCancelBean" contentType="text/html;charset=UTF-8"%>
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
	<script language="JavaScript" src="../../ePO/js/DeliveryOrderCancel.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <script>
        function_id				=		"<%= request.getParameter("function_id") %>"
		menu_id					=		"<%= request.getParameter("menu_id") %>"
		module_id				=		"<%= request.getParameter("module_id") %>"
    </script>
	<title><fmt:message key="Common.CancellationRemarks.label" bundle="${common_labels}"/></title>
</head>
<%
		String bean_id			=		"DeliveryOrderCancelBean";
		String bean_name		=		"ePO.DeliveryOrderCancelBean";

		request.setCharacterEncoding("UTF-8");
		String locale			=		(String)session.getAttribute("LOCALE");
		
		DeliveryOrderCancelBean bean  =		(DeliveryOrderCancelBean) getBeanObject(bean_id,bean_name,request);  
		bean.setLanguageId(locale);
		
		String do_date			=		request.getParameter("do_date").trim();
		String do_no			=		request.getParameter("do_no").trim();
		
		String key = "";
		
		
			key				=		do_date+"-"+do_no;
			String remarks			=		bean.getRemarks(key);
			String remarks_code     =       bean.getRemarks_code(key);
	%>
<body onload='FocusFirstElement();'>
	<form name= "formDeliveryCancelOrderRemarks">
	<br>
	<table border="0" cellspacing="0" width="100%" align=center>
	  <tr>
		<td  colspan="2">&nbsp;</td>
	  </tr>
	  <tr>
		<td  class="label" nowrap><fmt:message key="Common.CancellationRemarks.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<textarea name="remarks" rows="3" cols="40"  onKeyPress=""><%=remarks%></textarea>&nbsp;<input type="hidden" name="remarks_code_1" id="remarks_code_1" value = "<%=remarks_code%>" ><img src="../../eCommon/images/mandatory.gif" align="center">
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
		<input type="hidden"	name="do_date" id="do_date"								value="<%=do_date%>">
		<input type="hidden"	name="do_no" id="do_no"								value="<%=do_no%>">
		<input type="hidden"	name="lang_id" id="lang_id"								value="<%=locale%>">
		<input type="hidden"	name="rem_trans_type" id="rem_trans_type"						value="REQ">

	 </form>
<%
	putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>

