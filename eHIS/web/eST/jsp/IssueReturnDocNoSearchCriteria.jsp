<!DOCTYPE html>
 <%@ page import=" eST.*, eST.Common.* , eCommon.Common.*,  java.util.*,java.lang.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
         String doc_type_code=request.getParameter("doc_type_code");
         String frm_store_code=request.getParameter("fm_store_code");
         String to_store_code=request.getParameter("to_store_code");
         String item_class=request.getParameter("item_class");
	
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<link rel="stylesheet" type ="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
	<script language="JavaScript" src="../../eST/js/IssueReturn.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

  <!--  <script>
        function_id			=	 "<%= request.getParameter("function_id") %>"
		menu_id				=	 "<%= request.getParameter("menu_id") %>"
		module_id			=	 "<%= request.getParameter("module_id") %>"
    </script>-->
 
</head>
<%
	String mode				=		CommonRepository.getCommonKeyValue("MODE_INSERT");
	String acc_entity_id	=		(String) session.getValue("ACC_ENTITY_ID");
//	String function_id		=		request.getParameter("function_id");
	String bean_id			=		"issueReturnBean";
	String bean_name		=		"eST.IssueReturnBean";
	
	IssueReturnBean bean	=		(IssueReturnBean) getBeanObject(bean_id, bean_name, request);  
	bean.setLanguageId(locale);
	bean.initialize();
	ServletContext context  =		getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);
	bean.setMode(mode.trim());
	String sys_date=com.ehis.util.DateUtils.getCurrentDate("DMY",locale).toString();
	bean.setAcc_entity_id(acc_entity_id);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));

	HashMap alstartdate      = bean.getDurationforStartDate();
    String currentdate	   =  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("SYSTEMDATE"),"DMY","en",locale);
	String currentdateminus	=  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("DURATIONFORSTARTDATE"),"DMY","en",locale);
%>
<body onload='FocusFirstElement();document.formIssueDocNoSearchCriteria.submit();'>
	<form name= "formIssueDocNoSearchCriteria" action="../../eST/jsp/IssueReturnDocNoSearchResult.jsp" method="post" target="IssueDocNoSearchResultFrame">
	<table border="0" cellspacing="0" width="100%" align=center>
	  <tr>
		<td class=label align=left><fmt:message key="Common.item.label" bundle="${common_labels}"/></td>
			<td colspan=6 align=left class='label' colspan=2><input type=text name=item_desc size=70 maxlength=60 onkeypress="callItemSearchIssRetforBarcode(event,item_desc)" ><input type=button name="item_search" id="item_search" class="button"  onClick="callItemSearchIssRetforBarcode(event,item_desc)"  value='?'><input type="hidden" name="item_code" id="item_code" value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.DocNo.label" bundle="${common_labels}"/>
		<input type="text" size="10" maxlength="8" class='NUMBER' name="doc_no" id="doc_no" onBlur="return checkIntegerFormat(this);" ></td>
	  </tr>
	  <tr>
		<td  class="label"><fmt:message key="Common.DocDate.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<input type="text" name="frm_doc_date" id="frm_doc_date" size="10" value="<%=currentdateminus%>" maxlength="10" onBlur="checkSysdate(this, sysdate, '<%=locale%>');doDateCheckLocal(this, to_doc_date);">&nbsp;<!--added locale for SRR20056-SCF-9527 by Badmavathi on 26/08/2015-->
		<img src="../../eCommon/images/CommonCalendar.gif" id=Calendar onClick="return  showCalendar('frm_doc_date');"></img>
		</td>
		<td  class="label"><fmt:message key="Common.DocDate.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="to_doc_date" id="to_doc_date" size="10" maxlength="10" value="<%=currentdate%>"  onBlur="checkSysdate(this, sysdate, '<%=locale%>');doDateCheckLocal(frm_doc_date, this);">&nbsp;<!--added locale for SRR20056-SCF-9527 by Badmavathi on 26/08/2015-->
		<img src="../../eCommon/images/CommonCalendar.gif" id=Calendar onClick="return  showCalendar('to_doc_date');"></img>
		</td>
	  </tr>
	  <tr>
		<td >&nbsp;&nbsp;</td>
		<td >&nbsp;&nbsp;</td>
		<td >&nbsp;&nbsp;</td>
		<td >&nbsp;&nbsp;</td>
		<td >&nbsp;&nbsp;</td>

		<td class='fields'><input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' 
		onClick='document.formIssueDocNoSearchCriteria.action="../../eST/jsp/IssueReturnDocNoSearchResult.jsp"; document.formIssueDocNoSearchCriteria.target="IssueDocNoSearchResultFrame"; document.formIssueDocNoSearchCriteria.submit();'></td>
		<td   class='fields'><input type=reset name='Reset' id='Reset' value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' onClick="cancelData()"class='Button'>
				</td>
		<input type="hidden" name="language_id" id="language_id" value="<%=locale%>">
	  </tr>
	</table>
		<input type="hidden" name="bean_id" id="bean_id"			value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name"		value="<%= bean_name %>">
		<input type="hidden" name="function_id" id="function_id"		value="<%=bean.getFunctionId()%>">
		<input type="hidden" name="language_id" id="language_id"		value="<%=locale%>">
		<input type="hidden" name="frm_store_code" id="frm_store_code"		value="<%=frm_store_code%>">
		<input type="hidden" name="to_store_code" id="to_store_code"		value="<%=to_store_code%>">
		<input type="hidden" name="doc_type_code" id="doc_type_code"		value="<%=doc_type_code%>">
		<input type="hidden" name="item_class" id="item_class"		value="<%=item_class%>">
		<input type="hidden" name="sysdate" id="sysdate"		value="<%=sys_date%>">

		<input type="hidden"    name="barcode_applicable1" id="barcode_applicable1"			value="" >
		<input type="hidden"    name="defaultqty_appl1" id="defaultqty_appl1"				value="" ><!--dummy-->
		<input type="hidden"	name="defaultqty_value1" id="defaultqty_value1"			value=""><!--dummy-->
		<input type="hidden"    name="editqty_appl1" id="editqty_appl1"				value="" ><!--dummy-->
		 <input type="hidden"    name="batch_id" id="batch_id"				value="" >
		 <input type="hidden"    name="expiry_date" id="expiry_date"				value="" >
		<input type="hidden"    name="trade_id" id="trade_id"				value="" >
		<input type="hidden"    name="binlocation" id="binlocation"				value="" >
	</form>
<script>
callBarCodeApplicable('RET','formIssueDocNoSearchCriteria','issueReturnBean','eST.IssueReturnBean');
</script>
	<%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>

