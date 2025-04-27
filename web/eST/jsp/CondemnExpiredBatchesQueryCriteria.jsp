<!DOCTYPE html>
 <%@ page import=" eST.*, eST.Common.* , eCommon.Common.*,  java.util.*,java.lang.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%	request.setCharacterEncoding("UTF-8");
	String locale			=	(String)session.getAttribute("LOCALE");

	String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eST/js/StCommon.js"></script>
	<script language="JavaScript" src="../../eST/js/CondemnExpiredBatches.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
    <script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
        function_id			=		"<%= request.getParameter("function_id") %>"
		menu_id				=		"<%= request.getParameter("menu_id") %>"
		module_id			=		"<%= request.getParameter("module_id") %>"
    </script>
</head>
<%
	String mode				=		CommonRepository.getCommonKeyValue("MODE_MODIFY");
	String bean_id			=		"condemnExpiredBatchesHeaderBean";
	String bean_name		=		"eST.CondemnExpiredBatchesHeaderBean";
	CondemnExpiredBatchesHeaderBean bean	=		(CondemnExpiredBatchesHeaderBean) getBeanObject(bean_id,bean_name,request); 
	bean.setLanguageId(locale);
	//bean.clear();
	bean.initialize();
	ServletContext context	=		getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
	bean.setLocalEJB(false);
	bean.setMode(mode.trim());
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));  
	  HashMap alstartdate           = bean.getDurationforStartDate();
      String currentdate	=  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("SYSTEMDATE"),"DMY","en",locale);
	  String currentdateminus	=  com.ehis.util.DateUtils.convertDate((String)alstartdate.get("DURATIONFORSTARTDATE"),"DMY","en",locale);

%>
<body onload='FocusFirstElement();'>
	<form name= "formCondemnExpiredBatchesQueryCriteria" action="../../eST/jsp/CondemnExpiredBatchesQueryResult.jsp" method="post" target="CondemnExpiredBatchesQueryResult" onReset='FocusFirstElement();'>
	<table border="0" cellspacing="0" width="100%" align=center>
	  <tr>
		<td  class="label"><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<select name="doc_type_code" id="doc_type_code"><%=bean.getDocTypeCodes()%></select></td>

		<td  class="label"><fmt:message key="eST.CondemnID.label" bundle="${st_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<input type="text" size="10" maxlength="10" class='NUMBER' name="doc_no" id="doc_no" onKeyPress="return isValidInteger();" onBlur="return checkIntegerFormat(this);" ></td>

		<!--  <td  class="label"><fmt:message key="Common.Store.label" bundle="${mm_labels}"/></td>
		<td class='fields'>&nbsp;&nbsp;<select name="request_on_store" id="request_on_store">  </select></td> -->	 

	  </tr>
	  <tr>

		<td  class="label"><fmt:message key="eST.FromDocDate.label" bundle="${st_labels}"/></td>
		<td class='fields'>
			&nbsp;
			<input type="text" name="from_doc_date" id="from_doc_date" size="10" maxlength="10" value="<%=currentdateminus%>" onBlur="ChekDate(this,'<%=locale%>');">
			<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('from_doc_date');"></img>
			<%=bean.getImage("M")%>

		</td>

		<td  class="label"><fmt:message key="eST.ToDocDate.label" bundle="${st_labels}"/></td>
		<td class='fields'>
			&nbsp;
			<input type="text" name="to_doc_date" id="to_doc_date" size="10" maxlength="10" value="<%=currentdate%>" onBlur="ChekDate(this,'<%=locale%>');">
			<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('to_doc_date');"></img>
			<%=bean.getImage("M")%>
		</td>

		<td>&nbsp;&nbsp;</td>
		<td>&nbsp;&nbsp;</td>
	  </tr>
	  <tr>
		<td >&nbsp;&nbsp;</td>
		<td >&nbsp;&nbsp;</td>
		<td >&nbsp;&nbsp;</td>
		<td >&nbsp;&nbsp;</td>
		<td >&nbsp;&nbsp;</td>
		<td class='fields' ><input type="button" class="button" name="search" id="search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>'  onClick="checkForMandatory();"></td>
		<input type="hidden" name="language_id" id="language_id" value="<%=locale%>">
	  </tr>
	</table>
		<input type="hidden" name="bean_id" id="bean_id"			value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name"		value="<%=bean_name %>">
		<input type="hidden" name="function_id" id="function_id"		value="<%=bean.getFunctionId()%>">
		<input type="hidden" name="orderbycolumns" id="orderbycolumns"  value="doc_type_code,doc_no">
		<input type="hidden" name="sysdate" id="sysdate"	value="<%=com.ehis.util.DateUtils.getCurrentDate("DMY",locale).toString()%>">
		
	</form>
	<%
putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>

