<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name       	Rev.Date   		Rev.By    	Description
--------------------------------------------------------------------------------------------------------------
12/08/2015	  	IN0037683	   		Karthi	 								SRR20056-SCF-9538
---------------------------------------------------------------------------------------------------------------
*/
%>
 <%@ page import=" eST.POCancelRequestBean" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<%
		String sStyle	 =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
	<script language="JavaScript" src="../../eST/js/POCancelRequest.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
  <!-- IN0037683-SRR20056-SCF-9538 -->
    <script>
        function_id		=		"<%= request.getParameter("function_id") %>"
		menu_id			=		 "<%= request.getParameter("menu_id") %>"
		module_id		=		"<%= request.getParameter("module_id") %>"
    </script>
</head>
<%

	request.setCharacterEncoding("UTF-8");
	String locale						=		(String)session.getAttribute("LOCALE");
	String default_value				=		"<option value=\"\">&nbsp;&nbsp;&nbsp;&nbsp;---	"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ---&nbsp;&nbsp;&nbsp;&nbsp;</option>";
	String bean_id						=		"poCancelRequestBean";
	String bean_name					=		"eST.POCancelRequestBean";
	String mode							=		request.getParameter("mode");
	mode								=		mode.trim();

	if ((mode == null) || (mode.equals(""))) 
		return;
	if (!(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))))
		return;

	POCancelRequestBean bean				=		(POCancelRequestBean) getBeanObject(bean_id,bean_name,request);  
    bean.initialize();
	bean.setEntity_param((String)session.getAttribute("ACC_ENTITY_ID"));

	ServletContext context				=		getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);
	bean.setMode(mode.trim());
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	java.util.HashMap defaultParameter	=		bean.getDefaultStParameter();
	String default_doc_type_code		=		(String)defaultParameter.get("DEF_ISS_DOC_TYPE_CODE");
	bean.setDefaultDocType(default_doc_type_code);
	bean.setLanguageId(locale);
%>
<body onload='FocusFirstElement();'>
	<form name= "formPOCancelRequestQueryCriteria" action="../../eST/jsp/POCancelRequestQueryResult.jsp" method="post" target="POCancelRequestQueryResultFrame" onReset='FocusFirstElement();'>
	<table border="0" cellspacing="0" width="100%" align=center>
	  <tr>
		<td  class="label"><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<select name="doc_type_code" id="doc_type_code" onFocus="populateStores(this);"><%=bean.getDocTypeCodes()%></select></td>
		<td  class="label"><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<input type="text" size="10" maxlength="8" class='NUMBER' name="doc_no" id="doc_no" onBlur="return checkIntegerFormat(doc_no);" ></td>
		<td  colspan=2>&nbsp; </td>
	  </tr>
	  <tr>
		<td  class="label"><fmt:message key="Common.ReqByStore.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<select name="request_by_store" id="request_by_store" onchange="populateStores(this);" onBlur="populateItemClasses(request_by_store,request_on_store);"><%=bean.getRequestByStore()%></select></td>
		<td  class="label">Req On Department</td>
		<td class='fields'>&nbsp;&nbsp;<select name="request_on_store" id="request_on_store"><%=default_value%></select></td>	 
		<td  class="label"><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<select name="item_class_code" id="item_class_code"><%=default_value%></select></td>
	  </tr>
	  <tr>
	 	<td  class="label">
			<fmt:message key="eST.DocDateFrom.label" bundle="${st_labels}"/> 
		</td>
		<td colspan='2' class='fields'>
			&nbsp;&nbsp;<input type="text" name="from_doc_date" id="from_doc_date" size="10" maxlength="10" onBlur="CheckDateLeap(this,'DMY','<%=locale%>');">
			<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('from_doc_date');"> </img>
						<label class="label">
				<fmt:message key="Common.to.label" bundle="${common_labels}"/>
			</label>
			<input type="text" name="to_doc_date" id="to_doc_date" size="10" maxlength="10" onBlur="CheckDateLeap(this,'DMY','<%=locale%>');">
			<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('to_doc_date');"> </img>
					</td> <!--changed from CheckDate() to CheckDateLeap() for SRR20056-SCF-9532 [IN037673] -->
				<td>&nbsp;&nbsp;</td>
		<td>&nbsp;&nbsp;</td>
		<td>&nbsp;&nbsp;</td>
	  </tr>
	  <tr>
		<td class='label' ><fmt:message key="eST.ReqStatus.label" bundle="${st_labels}"/></td>
		<td colspan='2' class='fields'>&nbsp;&nbsp;
			<select name="request_status" id="request_status">
				<option value="P" selected><fmt:message key="eST.PendingForApproval.label" bundle="${st_labels}"/></option>
			</select>
		</td>
		<td >&nbsp;&nbsp;</td>
		<td >&nbsp;&nbsp;</td>
		<td class='fields'><input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="submitQueryCriteria();"></td>
	  </tr>
	</table>
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name %>">
		<input type="hidden" name="mode" id="mode" value="<%=mode%>">
		<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
		<input type="hidden" name="orderbycolumns" id="orderbycolumns" value="hdr.doc_no,doc_type_code">
	</form>
<%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>

