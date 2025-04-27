<!DOCTYPE html>
 <%@ page import=" eST.*, eST.Common.* , eCommon.Common.*,  java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<!-- 	<link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link>
 -->	<%
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
	<script language="JavaScript" src="../../eST/js/StTransaction.js"></script>
	<script language="JavaScript" src="../../eST/js/CancelRequest.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <script>
        function_id = "<%= request.getParameter("function_id") %>"
		menu_id		= "<%= request.getParameter("menu_id") %>"
		module_id	= "<%= request.getParameter("module_id") %>"
    </script>
</head>
<%
	String mode					=		request.getParameter("mode");
	String item_class_value		=		StRepository.getStKeyValue("DEFAULT_LIST_OPTION");
	mode						=		mode.trim();
	if ((mode == null) || (mode.equals(""))) 
		return;
	if (!(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))))
		return;

	request.setCharacterEncoding("UTF-8");
	String locale				=	(String)session.getAttribute("LOCALE");
	

	String bean_id				=	"cancelRequestBean";
	String bean_name			=	"eST.CancelRequestBean";
	String disabled				=	"disabled";
	CancelRequestBean bean		=	(CancelRequestBean) getBeanObject(bean_id,bean_name,request);  
	bean.setDefaultDocType(bean.getDoc_type_code());
	item_class_value			=	bean.getItemClasses();
	ServletContext context		=	getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);
	bean.setMode(mode.trim());
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.setLanguageId(locale);
	%>
<body onload='FocusFirstElement();'>
	<form name= "formCancelRequestHeader">
	<table border="0" cellspacing="0" width="100%" align=center>
	  <tr>
		<td  class="label"><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<select name="doc_type_code" id="doc_type_code" <%=disabled%>><%=bean.getDocTypeCodes()%></select></td>
		<td class="label"><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<input type="text" size="10" maxlength="8" name="doc_no" id="doc_no" value="<%=bean.getDoc_no()%>" disabled></td>
		<td  class="label"><fmt:message key="Common.DocDate.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<input type="text" name="doc_date" id="doc_date" size="10" maxlength="10" value="<%=bean.getDoc_date()%>" <%=disabled%>></td>
	  </tr>
	  <tr>
		<td  class="label"><fmt:message key="Common.RequisitionbyStore.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<select name="request_by_store" id="request_by_store" <%=disabled%>><%=bean.getRequestByStore()%></select></td>
		<td  class="label"><fmt:message key="Common.RequisitiononStore.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<select name="request_on_store" id="request_on_store" <%=disabled%>><%=bean.getRequestOnStore()%></select></td>
		<td  class="label"><fmt:message key="Common.DocRef.label"   bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<input type="text" name="doc_ref" id="doc_ref" size="20" maxlength="25" value="<%=bean.getDoc_ref()%>" <%=disabled%>></td>
	  </tr>
	  <tr>
		<td  class="label"><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<select name="item_class_code" id="item_class_code" <%=disabled%>><%=item_class_value%></select></td>
		<td >&nbsp;&nbsp;</td>
		<td >&nbsp;&nbsp;</td>
		<td >&nbsp;&nbsp;</td>
		<td >&nbsp;&nbsp;</td>
	  </tr>
	  <tr>
		<td  class="label"><fmt:message key="Common.CancellationRemarks.label" bundle="${common_labels}"/></td>
		<td colspan="5" class='fields'>&nbsp;&nbsp;<textarea name="cancelled_remarks" rows="3" cols="65"></textarea>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></td>
	  </tr>
	</table>
		<input type='hidden' name="mode" id="mode" value="<%=mode%>">
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
		<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
	</form>
		<%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>

