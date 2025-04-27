<!DOCTYPE html>
<%@ page import=" eST.*, eST.Common.* , eCommon.Common.*,  java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	
<%
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
	<script language="JavaScript" src="../../eST/js/PORequest.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <script>
        function_id			=	"<%= request.getParameter("function_id") %>"
		menu_id				=	"<%= request.getParameter("menu_id") %>"
		module_id			=	"<%= request.getParameter("module_id") %>"
    </script>
</head>
<%
	String mode				=		CommonRepository.getCommonKeyValue("MODE_MODIFY");
	//pmd 29/01/05
//	String function_id		=		request.getParameter("function_id");
	String bean_id			=		"porequestBean";
	String bean_name		=		"eST.PORequestBean";
	String default_value	=		"<option value=\"\">&nbsp;&nbsp;&nbsp;&nbsp;---	"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ---&nbsp;&nbsp;&nbsp;&nbsp;</option>";

	PORequestBean bean		=		(PORequestBean) getBeanObject(bean_id,bean_name, request  );  
	bean.clear();

	request.setCharacterEncoding("UTF-8");
	String locale			=		(String)session.getAttribute("LOCALE");
	String facilityid=(String)session.getValue("facility_id");


	ServletContext context  =		getServletConfig().getServletContext();

	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
	bean.setLocalEJB(false);
	bean.setMode(mode.trim());
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.setEntity_param((String) session.getAttribute("ACC_ENTITY_ID"));
	String default_doc_type_code=
	(String)bean.fetchRecord("SELECT   a.DOC_TYPE_CODE DOC_TYPE_CODE FROM st_trn_doc_type a,sy_doc_type_master_lang_vw b,sy_acc_entity_doc_type c WHERE a.facility_id = ? AND a.doc_type_code = b.doc_type_code AND a.trn_type = 'PRQ' AND b.status IS NULL AND a.doc_type_code = c.doc_type_code AND b.language_id = ?",new String[]{facilityid,locale}).get("DOC_TYPE_CODE");
			

	//java.util.HashMap defaultParameter = bean.getDefaultStParameter();
	//String default_doc_type_code	 =		(String)defaultParameter.get("DEF_ISS_DOC_TYPE_CODE");
	bean.setDefaultDocType(default_doc_type_code);
%>
<body onload='FocusFirstElement();document.formPORequestQueryCriteria.submit();'>
	<form name= "formPORequestQueryCriteria" action="../../eST/jsp/PORequestQueryResult.jsp" method="post" target="PORequestQueryResult" onReset='FocusFirstElement();'>
	<table border="0" cellspacing="0" width="100%" align="center">
	  <tr>
		<td  class="label"><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<select name="doc_type_code" id="doc_type_code" onchange="populateToStoresInQuery(request_by_store);"><%=bean.getDocTypeCodes()%></select></td>
		<td  class="label"><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<input type="text" size="10" maxlength="8" class='NUMBER' name="doc_no" id="doc_no" onKeyPress="return isValidInteger();" onBlur="return checkIntegerFormat(this);" ></td>
		<td  class="label"><fmt:message key="Common.DocDate.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<input type="text" name="doc_date" id="doc_date" size="10" maxlength="10" onBlur="CheckDateLeap(this,'DMY','<%=locale%>');"><img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('doc_date');"></img></td><!-- validDateObj(this,'DMY','<%=locale%>'); removed for Leap year issue, added CheckDateLeap(this,'DMY','<%=locale%>') in doc_date by Badmavathi for SRR20056-SCF-9539 -->
	  </tr>
	  <tr>
		<td  class="label"><fmt:message key="Common.ReqByStore.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<select name="request_by_store" id="request_by_store" onchange="populateToStoresInQuery(this);"><%=bean.getQRYRequestOnStore()%></select></td>
		<td  class="label"><fmt:message key="eST.RequestOnDepartment.label" bundle="${st_labels}"/></td>
		
		<td class='fields'>&nbsp;&nbsp;<select name="request_on_store" id="request_on_store" onchange="loadItemClassesInQuery(request_by_store,this);"><%=default_value%></select></td>	 
		<td  class="label"><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<select name="item_class_code" id="item_class_code"><%=default_value%></select></td>
	  </tr>
	  
	  <tr>
		<td >&nbsp;&nbsp;</td>
		<td >&nbsp;&nbsp;</td>
		<td >&nbsp;&nbsp;</td>
		<td >&nbsp;&nbsp;</td>
		<td >&nbsp;&nbsp;</td>
		<td class='fields'><input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>'  onClick="searchResult()";"></td>
	  </tr>
	</table>
		<input type="hidden" name="bean_id" id="bean_id"			value="<%=bean_id%>">
		<input type="hidden" name="language_id" id="language_id"		value="<%=locale%>">
		<input type="hidden" name="bean_name" id="bean_name"		value="<%= bean_name %>">
		<input type="hidden" name="function_id" id="function_id"		value="<%=bean.getFunctionId()%>">
		<input type="hidden" name="orderbycolumns" id="orderbycolumns"  value="req_store_code,hdr.doc_date,doc_type_code,hdr.doc_no">
	</form>
<%	putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>

