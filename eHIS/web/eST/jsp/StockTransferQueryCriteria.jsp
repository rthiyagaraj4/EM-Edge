<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name       	Rev.Date   		Rev.By    	Description
--------------------------------------------------------------------------------------------------------------
12/08/2015	  	IN0037673	   		Karthi	 								SRR20056-SCF-9532
---------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import=" eST.StockTransferBean,eCommon.Common.*,  java.util.HashMap,java.util.ArrayList,java.lang.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' 
type='text/css' ></link>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<!-- 	<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
 -->	<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
<!-- 	<script language="JavaScript" src="../../eST/js/StMessages.js"></script>
 -->	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eST/js/StockTransfer.js"></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

   <script>
        function_id = "<%= request.getParameter("function_id") %>"
		menu_id		= "<%= request.getParameter("menu_id") %>"
		module_id	= "<%= request.getParameter("module_id") %>"
    </script>
</head>
<%
	String mode = CommonRepository.getCommonKeyValue("MODE_MODIFY");
//	String function_id = request.getParameter("function_id");
	String bean_id = "stockTransferBean";
	String bean_name = "eST.StockTransferBean";
	String default_value				=		"<option value=\"\">&nbsp;&nbsp;&nbsp;&nbsp;---	"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ---&nbsp;&nbsp;&nbsp;&nbsp;</option>";
	StockTransferBean bean = (StockTransferBean)getBeanObject(bean_id,bean_name,request );  
	bean.clear();
	bean.setLanguageId(locale);
	ServletContext context = getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);
	bean.setMode(mode.trim());
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	java.util.HashMap defaultParameter = bean.getDefaultStParameter();
	String default_doc_type_code = (String)defaultParameter.get("DEF_TFR_DOC_TYPE_CODE");
	bean.setDefaultDocType(default_doc_type_code);
	bean.setAcc_entity_id((String)session.getAttribute("ACC_ENTITY_ID"));

		//Added for 29970	Bru-HIMS-CRF-095
	String homepage		= request.getParameter("homepage") == null?"N":request.getParameter("homepage");
	String store_code	= request.getParameter("store_code") == null?"":request.getParameter("store_code");
	if(homepage.equals("Y"))
		bean.setFrom_store_code(store_code);

	//Added by Sakti Sankar #Inc no: on 22/03/13 Starts
	  
	HashMap alstartdate           = bean.getDurationforStartDate();
    String currentdate	=  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("SYSTEMDATE"),"DMY","en",locale);
	String currentdateminus	=  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("DURATIONFORSTARTDATE"),"DMY","en",locale);
	   
//ends
%>
<body onload='FocusFirstElement();document.formStockTransferQueryCriteria.submit();'>
	<form name= "formStockTransferQueryCriteria" id="formStockTransferQueryCriteria" action="../../eST/jsp/StockTransferQueryResult.jsp" method="post" target="StockTransferQueryResult" onReset='FocusFirstElement();'>
	<table border="0" cellspacing="0" width="100%" align="center">
	  <tr>
		<td  class="label"><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<select name="doc_type_code" id="doc_type_code" onFocus="populateStoresInQuery(fm_store);"><%=bean.getDocTypeCodes()%></select></td>
		<td  class="label"><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<input type="text" size="10" maxlength="8" class='NUMBER' name="doc_no" id="doc_no" onBlur="return checkIntegerFormat(this);" ></td>
		<!--<td  class="label"><fmt:message key="Common.DocDate.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<input type="text" name="doc_date" id="doc_date" size="10" maxlength="10" onBlur="CheckDate(this);"> 
		<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('doc_date');" ></img> </td>-->
		<td  class="label"><fmt:message key="eST.FromDocDate.label" bundle="${st_labels}"/></td>
		<td class='fields'>
			&nbsp;
			<input type="text" name="from_doc_date" id="from_doc_date" size="10" maxlength="10" value="<%=currentdateminus%>" onBlur="CheckDateLeap(this,'DMY','<%=locale%>');">
			<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('from_doc_date');"></img></td> <!-- changed CheckDate() to CheckDateLeap() for SRR20056-SCF-9532 [IN037673] -->

		<td  class="label"><fmt:message key="eST.ToDocDate.label" bundle="${st_labels}"/></td>
		<td class='fields'>
			&nbsp;
			<input type="text" name="to_doc_date" id="to_doc_date" size="10" maxlength="10" value="<%=currentdate%>" onBlur="CheckDateLeap(this,'DMY','<%=locale%>');">
			<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('to_doc_date');"></img></td> <!-- changed CheckDate() to CheckDateLeap() for SRR20056-SCF-9532 [IN037673] -->
	  </tr>
	  <tr>
		<td  class="label"><fmt:message key="Common.FromStore.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<select name="fm_store" id="fm_store" onBlur="populateStoresInQuery(this);"><%=bean.getFromStore()%></select></td>
		<td  class="label"><fmt:message key="Common.ToStore.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<select name="to_store" id="to_store" onBlur="populateItemClassesInQuery(fm_store,this);"><%=default_value%></select></td>	 
		<td  class="label"><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></td>
		<td class='fields' colspan='3'>&nbsp;&nbsp;<select name="item_class_code" id="item_class_code"><%=default_value%></select></td>
	  </tr>
	  <tr>
		<td >&nbsp;&nbsp;</td>
		<td >&nbsp;&nbsp;</td>
		<td >&nbsp;&nbsp;</td>
		<td >&nbsp;&nbsp;</td>
		<td >&nbsp;&nbsp;</td>
		<td >&nbsp;&nbsp;</td>
		<td colspan='2'><input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="return checkSysdateTo(to_doc_date,from_doc_date);"></td>
				<input type="hidden" name="language_id" id="language_id" value="<%=locale%>">
	  </tr>
	</table>
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
		<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
		<input type="hidden" name="orderbycolumns" id="orderbycolumns" value="doc_type_code,doc_no">
	</form>
	<%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>

