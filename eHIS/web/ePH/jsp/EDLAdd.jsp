<!DOCTYPE html>
 
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="ePH.*, ePH.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<html>
<head>

<% 
	request.setCharacterEncoding("UTF-8");
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
    String locale			= (String)session.getAttribute("LOCALE");
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?	(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
	
	<script language="JavaScript" SRC="../../eCommon/js/common.js"></script>
    <SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<script language="JavaScript" src="../js/PhCommon.js"></script>
	<script language="JavaScript" src="../js/EDL.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
    String mode	  = CommonRepository.getCommonKeyValue( "MODE_INSERT" );
	String bean_id = "EDLBean" ;
    String bean_name = "ePH.EDLBean";

	int iTotalRecords = 5; // This is Hard coded since only 10 rows are fixed. This should be changed in case of more rows

	String EDLCode = request.getParameter("code")==null?"":request.getParameter("code");

	EDLBean bean = (EDLBean)getBeanObject( bean_id,bean_name,request) ;

    //bean.clear() ;
    bean.setMode( mode ) ;
	bean.setLanguageId(locale);
%>
<!-- <body> -->
<body onMouseDown="" onKeyDown="lockKey()">
	<form name='EDLAddForm' id='EDLAddForm'>
	<table width="100%">
		<tr>
			<th width="15%"><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
			<th width="70%"><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
			<th width="15%"><fmt:message key="ePH.Select.label" bundle="${ph_labels}"/></th>
		</tr>
		<% for(int i=0;i<iTotalRecords;i++) {%>
		<tr>
			<td  class ="label"><input type = "text" name="EDLCode<%=i%>" id="EDLCode<%=i%>" size='11' Maxlength='10' onKeyPress="return CheckForSpecChars(event)" onBlur="ChangeUpperCase(this)" ></td>
			<td  class ="label"><input type = "text" name="EDLDescription<%=i%>" id="EDLDescription<%=i%>" size='75' Maxlength='60'></td>
			<td  class ="label"><input type = "checkBox" name="EDLSelect<%=i%>" id="EDLSelect<%=i%>" value="Y"></td>
		</tr>
		<%}%>
		<tr>
			<td colspan =3 align ="right"> <input type="button" class="button" VALUE='<fmt:message key="Common.record.label" bundle="${common_labels}"/>'  onClick="javascript:if(checkForEmptyValues()){apply()};"> 
		</tr>
	</table>

    <INPUT TYPE="hidden" name="mode" id="mode" value="<%=mode%>">
    <INPUT TYPE="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
    <INPUT TYPE="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
    <input type="hidden" name="totalRecords" id="totalRecords" value="<%=iTotalRecords%>">
    <input type="hidden" name="EDLCode" id="EDLCode" value="<%=EDLCode%>">
</form>
<!-- Added Script tag  on 2/dec/09 regarding onlinehelp focus -->
<script>
document.forms[0].EDLCode0.focus();</script>
</body>
<% putObjectInBean(bean_id,bean,request); %>
</html> 

