<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
04/02/2016	IN057461		Badmavathi B									Query page for Product Transfer/Repackaging 
--------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import=" eST.*, eST.Common.* , eCommon.Common.*,  java.util.*,java.lang.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");		
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
	<script language="JavaScript" src="../../eST/js/ProductTransfer.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <script>
        function_id			=	 "<%= request.getParameter("function_id") %>"
		menu_id				=	 "<%= request.getParameter("menu_id") %>"
		module_id			=	 "<%= request.getParameter("module_id") %>"
    </script>
</head>
<%
	String mode				=		CommonRepository.getCommonKeyValue("MODE_MODIFY");
	String acc_entity_id	=		(String) session.getValue("ACC_ENTITY_ID");
	String bean_id			=		"ProductTransferBean";
	String bean_name		=		"eST.ProductTransferBean";
	String default_value	=		"<option value=\"\">&nbsp;&nbsp;&nbsp;&nbsp;---	"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ---&nbsp;&nbsp;&nbsp;&nbsp;</option>";
	ProductTransferBean bean	=		(ProductTransferBean) getBeanObject(bean_id, bean_name, request);  
	bean.setLanguageId(locale);
	bean.initialize();
	ServletContext context  =		getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);

	bean.setMode(mode.trim());
	bean.setAcc_entity_id(acc_entity_id);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	HashMap defaultParameter = bean.getDefaultStParameter();
	String default_doc_type_code = (String)defaultParameter.get("DEF_PRT_DOC_TYPE_CODE");
	bean.setDefaultDocType(default_doc_type_code);
	String homepage		= request.getParameter("homepage") == null?"N":request.getParameter("homepage");
	String store_code	= request.getParameter("store_code") == null?"":request.getParameter("store_code");
	String prep_loc	= request.getParameter("PREPARE_LOCATION_CODE") == null?"":request.getParameter("PREPARE_LOCATION_CODE");
	HashMap alstartdate           = bean.getDurationforStartDate();
    String currentdate			  =  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("SYSTEMDATE"),"DMY","en",locale);
	String currentdateminus	      =  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("DURATIONFORSTARTDATE"),"DMY","en",locale);
%>
<body onload='FocusFirstElement();document.formProductTransferQueryCriteria.submit();'>
	<form name= "formProductTransferQueryCriteria" action="../../eST/jsp/ProductTransferQueryResult.jsp" method="post" target="ProductTransferQueryResult" onReset='FocusFirstElement();'>
	<table border="0" cellspacing="0" width="100%" align=center>
	  <tr>
		<td  class="label"><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<select name="doc_type_code" id="doc_type_code" ><%=bean.getDocTypeCodes()%></select></td>
		<td  class="label"><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type="text" size="10" maxlength="8" class='NUMBER' name="doc_no" id="doc_no" onBlur="return checkIntegerFormat(this);" ></td>
		<td  class="label"><fmt:message key="eST.FromDocDate.label" bundle="${st_labels}"/></td>
		<td class='fields'>
			&nbsp;
			<input type="text" name="from_doc_date" id="from_doc_date" size="10" maxlength="10" value="<%=currentdateminus%>" onBlur="CheckDateLeap(this,'DMY','<%=locale%>');">
			<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('from_doc_date');"></img></td>

		<td  class="label"><fmt:message key="eST.ToDocDate.label" bundle="${st_labels}"/></td>
		<td class='fields'>
			&nbsp;
			<input type="text" name="to_doc_date" id="to_doc_date" size="10" maxlength="10" value="<%=currentdate%>" onBlur="CheckDateLeap(this,'DMY','<%=locale%>');">
			<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('to_doc_date');"></img></td>
	  </tr>
	  <tr>
		<td  class="label"><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<select name="request_on_store" id="request_on_store"><%=bean.getQRYStore_code_List(store_code)%></select></td>	 
		<td class="label" ><fmt:message key="Common.PrepareLocation.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;<select name='prep_loc' id='prep_loc' ><%=bean.getPrepLoc()%></select></td> 
		
	  </tr>
	  <tr>
		<td >&nbsp;&nbsp;</td>
		<td >&nbsp;&nbsp;</td>
		<td >&nbsp;&nbsp;</td>
		<td >&nbsp;&nbsp;</td>
		<td >&nbsp;&nbsp;</td>
		<td >&nbsp;&nbsp;</td>
		<td >&nbsp;&nbsp;</td>
		<td class='fields'><input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="checkForMandatory();"></td>
		<input type="hidden" name="language_id" id="language_id" value="<%=locale%>">
	  </tr>
	</table>
		<input type="hidden" name="bean_id" id="bean_id"			value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name"		value="<%= bean_name %>">
		<input type="hidden" name="function_id" id="function_id"		value="<%=bean.getFunctionId()%>">
		<input type="hidden" name="language_id" id="language_id"		value="<%=locale%>">
		<input type="hidden" name="orderbycolumns" id="orderbycolumns"  value="doc_type_code,doc_no">
		<input type="hidden" name="sysdate" id="sysdate"	value="<%=com.ehis.util.DateUtils.getCurrentDate("DMY",locale).toString()%>">
		<input type="hidden" name="prep_loc" id="prep_loc" value="">
		
	</form>
	<%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>

