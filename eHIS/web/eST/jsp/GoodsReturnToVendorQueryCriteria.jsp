<!DOCTYPE html>
 <%@ page import=" eST.*, eST.Common.* , eCommon.Common.*,  java.util.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<!--  	<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
 -->	<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
<!-- 	<script language="JavaScript" src="../../eST/js/StMessages.js"></script>
 -->	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eST/js/GoodsReturnToVendor.js"></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

    <script>
        function_id = "<%= request.getParameter("function_id") %>"
		menu_id		= "<%= request.getParameter("menu_id") %>"
		module_id	= "<%= request.getParameter("module_id") %>"
    </script>
</head>
<%
	String bean_id = "goodsReturnToVendorBean";
	String bean_name = "eST.GoodsReturnToVendorBean";
	GoodsReturnToVendorBean bean = (GoodsReturnToVendorBean) getBeanObject(bean_id, bean_name, request);  //modified on 30/12
		bean.setLanguageId(locale);
	bean.initialize();
	ServletContext context = getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);

	bean.setMode("1");
	bean.setTrn_type("RTV");
	bean.initStore_code_List("SQL_QRY_ST_RTV_STORE_SELECT");
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.initDoc_type_code_List();
	java.util.HashMap defaultParameter = bean.getDefaultStParameter();
	String default_doc_type_code = (String)defaultParameter.get("DEF_RTV_DOC_TYPE_CODE");
	String default_store_code = (String)defaultParameter.get("DEF_STORE_CODE_FOR_REC");
	bean.setDoc_type_code(bean.checkForNull(default_doc_type_code));
	bean.setStore_code(bean.checkForNull(default_store_code));

	//Added by Sakti Sankar #Inc no: on 22/03/13 Starts
	  
	HashMap alstartdate           = bean.getDurationforStartDate();
    String currentdate	=  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("SYSTEMDATE"),"DMY","en",locale);
	String currentdateminus	=  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("DURATIONFORSTARTDATE"),"DMY","en",locale);
	   
//ends
	String homepage		= request.getParameter("homepage") == null?"N":request.getParameter("homepage");
	String store_code	= request.getParameter("store_code") == null?"":request.getParameter("store_code");
	if(homepage.equals("Y"))
		bean.setStore_code(store_code);
%>
<body onload='FocusFirstElement();document.formGoodsReturnToVendorQueryCriteria.submit();'>
	<form name= "formGoodsReturnToVendorQueryCriteria" action="../../eST/jsp/GoodsReturnToVendorQueryResult.jsp" method="post" target="GoodsReturnToVendorQueryResult" onReset='FocusFirstElement();'>
	<table border="0" cellspacing="0" width="100%" align=center>
	  <tr>
		<td  class="label"><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<select name="doc_type_code" id="doc_type_code"><%=bean.getDoc_type_code_List()%></select></td>
		<td  class="label"><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<input type="text" size="10" maxlength="8" class='NUMBER' name="doc_no" id="doc_no" onBlur="return checkIntegerFormat(this);" ></td>
		<!--<td  class="label"><fmt:message key="Common.DocDate.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<input type="text" name="doc_date" id="doc_date" size="10" maxlength="10" onBlur="CheckDate(this);">
		<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('doc_date');" ></img></td>-->
		<td  class="label"><fmt:message key="eST.FromDocDate.label" bundle="${st_labels}"/></td>
		<td class='fields'>
			&nbsp;
			<input type="text" name="from_doc_date" id="from_doc_date" size="10" maxlength="10" value="<%=currentdateminus%>" onBlur="ChekDate(this,'<%=locale%>');">
			<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('from_doc_date');"></img></td>

		<td  class="label"><fmt:message key="eST.ToDocDate.label" bundle="${st_labels}"/></td>
		<td class='fields'>
			&nbsp;
			<input type="text" name="to_doc_date" id="to_doc_date" size="10" maxlength="10" value="<%=currentdate%>" onBlur="ChekDate(this,'<%=locale%>');">
			<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('to_doc_date');"></img></td>
	  </tr>
	  <tr>
		<td  class="label"><fmt:message key="Common.Store.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<select name="store_code" id="store_code"><%=bean.getStore_code_List()%></select></td>
	<td class='label' ><fmt:message key="Common.EntryCompleted.label" bundle="${common_labels}"/></td>
		<td colspan='5' class='fields'>&nbsp;&nbsp;<select name="entry_completed_yn" id="entry_completed_yn"><option value="%"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option><option value="Y" selected><fmt:message key="Common.completed.label" bundle="${common_labels}"/></option><option value="N"><fmt:message key="Common.NotCompleted.label" bundle="${common_labels}"/></option></select></td>
	  </tr>
	  <tr>
		<td >&nbsp;&nbsp;</td>
		<td >&nbsp;&nbsp;</td>
		<td >&nbsp;&nbsp;</td>
		<td >&nbsp;&nbsp;</td>
		<td >&nbsp;&nbsp;</td>
		<td >&nbsp;&nbsp;</td>
		<td  class='fields' colspan="2"><input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="return checkSysdateTo(to_doc_date,from_doc_date);"></td>
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

