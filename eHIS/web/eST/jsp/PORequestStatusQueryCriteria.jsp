<!DOCTYPE html>
<%@ page import="eST.PORequestStatusBean" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			 =	(String)session.getAttribute("LOCALE");
		String sStyle			 =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
		<script language='javaScript' src="../../eST/js/PORequestStatus.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		 <script>
		    function_id			=		"<%= request.getParameter("function_id") %>"
			menu_id				=		"<%= request.getParameter("menu_id") %>"
			module_id			=		"<%= request.getParameter("module_id") %>"
	 </script>
</head>
<%
	String bean_id				=		"PORequestStatusBean";
	String bean_name			=		"eST.PORequestStatusBean";
	String mode					=		 request.getParameter("mode");
	String default_value		=		"<option value=\"\">&nbsp;&nbsp;&nbsp;&nbsp;---	"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ---&nbsp;&nbsp;&nbsp;&nbsp;</option>";
	try{
	mode						=		mode.trim();
	if ((mode == null) || (mode.equals(""))) 
		return;
	if (!(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))))
		return;
	}
	catch(Exception ee) { }

	PORequestStatusBean bean		=		(PORequestStatusBean) getBeanObject(bean_id, bean_name,request);  
	bean.setLanguageId(locale);
	bean.clear();
	bean.setEntity_param((String)session.getAttribute("ACC_ENTITY_ID"));

	ServletContext context		=		getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);
	bean.setMode(mode);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	
%>
<body onload='FocusFirstElement();'>
	<form name= "formPORequestStatusQueryCriteria" action="../../eST/jsp/PORequestStatusQueryResult.jsp" method="post"  target="result" onReset='FocusFirstElement();'>
	
	<table border="0" cellspacing="0" width="100%" align="center">
	  <tr>
		<td align="left" class="label"><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
		<td >&nbsp;&nbsp;<select name="doc_type_code" id="doc_type_code" on="populateToStoresInQuery(request_by_store);"><%=bean.getDocTypeCodes()%></select></td>
		<td align="left" class="label"><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></td>
		<td colspan='3'>&nbsp;&nbsp;<input class="NUMBER" type="text" size="10" maxlength="8" onKeyPress="return isValidInteger();" name="doc_no" id="doc_no" onBlur="return checkIntegerFormat(this);" ></td>
	  </tr>
	  <tr>
		<td align="left" class="label"><fmt:message key="Common.ReqByStore.label" bundle="${common_labels}"/></td>
		<!-- 
		   
			* @Name - Priya
			* @Date - 29/01/2010
			* @Inc# - IN018492
			* @Desc - As Item Classes have to be populated based on the selected store, the function 'populateItemClasses' is removed from 'RequestOnDepartment' and is written in the onchange of 'Store'
			
		-->
		<td >&nbsp;&nbsp;<select name="request_by_store" id="request_by_store" onchange="populateToStoresInQuery(this);populateItemClasses(this,request_on_department);"><%=bean.getRequestByStore()%></select></td>
		<td align="left" class="label"><fmt:message key="eST.RequestOnDepartment.label" bundle="${st_labels}"/></td>
		<td >&nbsp;&nbsp;<select name="request_on_department" id="request_on_department" onchange=""><%=default_value%></select></td>	 
		<td align="left" class="label"><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></td>
		<td >&nbsp;&nbsp;<select name="item_class_code" id="item_class_code"><%=default_value%></select></td>
	  </tr>
	  <tr>
		<td class="label" align='left'><fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
		<td >&nbsp;&nbsp;<input type='text' size='20'  maxlength='20' name='item_code' id='item_code'  value=""><input class='button' type='button' name='searchItem' id='searchItem' value='?'  onClick="return searchItemCode(item_code);" class="label">
		<td align="left" class="label"><fmt:message key="Common.RequestStatus.label" bundle="${common_labels}"/></td>
		<td colspan=3>&nbsp;&nbsp;<select name="request_status" id="request_status">
	   <option value=""><fmt:message key="Common.all.label" bundle="${common_labels}"/> </option>
		<option value="U"><fmt:message key="Common.UnFinalized.label" bundle="${common_labels}"/></option>
		<option value="P"><fmt:message key="eST.PendingForApproval.label" bundle="${st_labels}"/></option>
		<option value="R"><fmt:message key="eST.RequestRejectedbyPODept.label" bundle="${st_labels}"/></option>
		<option value="L"><fmt:message key="eST.RequestReceivedPartially.label" bundle="${st_labels}"/> </option>
		<option value="C"><fmt:message key="eST.RequestReceivedCompletely.label" bundle="${st_labels}"/></option>
		<option value="X"><fmt:message key="eST.RequestCancelled.label" bundle="${st_labels}"/></option>
		</select></td>
	

	   </tr>
	  <tr>
	 	<td align="left" class="label"><fmt:message key="eST.DocDateFrom.label" bundle="${st_labels}"/> </td>
		<td colspan=3>&nbsp;&nbsp;<input type="text" name="from_doc_date" id="from_doc_date" size="10" maxlength="10" onBlur="CheckDate(this);">
		<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('from_doc_date');"  ></img>
		&nbsp;&nbsp;<label class="label"><fmt:message key="Common.to.label" bundle="${common_labels}"/></label>&nbsp;&nbsp;<input type="text" name="to_doc_date" id="to_doc_date" size="10" maxlength="10" onBlur="CheckDate(this);"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('to_doc_date');"  ></img></td>
		<td align="right" class="label">&nbsp;</td>
		<td align="right"><input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="searchPORequestResults( );"></td>
		
	   </tr>
	
	  </tr>
	  
	</table>
		<input type="hidden" name="SQL_ST_ITEM_LOOKUP" id="SQL_ST_ITEM_LOOKUP"		value="<%=bean.getStRepositoryValue("SQL_ST_ITEM_LOOKUP")%>">
		<input type="hidden" name="bean_id" id="bean_id"					value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name"				value="<%=bean_name %>">
		<input type="hidden" name="language_id" id="language_id"				value="<%=locale %>">
		<input type="hidden" name="mode" id="mode"					value="<%=mode%>">
		<input type="hidden" name="function_id" id="function_id"				value="<%=bean.getFunctionId()%>">
		<input type="hidden" name="orderbycolumns" id="orderbycolumns"			value="doc_type_code,doc_no">
	</form>
<%
putObjectInBean(bean_id,bean,request);
%>

	</body>
</html>

