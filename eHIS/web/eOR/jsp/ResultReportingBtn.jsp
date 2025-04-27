<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- AuthorizeOrdersBottomRightBtn.jsp -->
<%@ page contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/ResultReporting.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onload='FocusFirstElement()'  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<%
	
//	String readOnly = "" ;
//	String checked = "checked" ;
	/* Mandatory checks start */
//	String mode	   = request.getParameter( "mode" ) ;
//	String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_ResultReporting" ;
	String bean_name = "eOR.ResultReportingBean";
//	String disabled = "" ;


/* Mandatory checks end */

%>
<form name='result_reporting_btn' id='result_reporting_btn' target='messageFrame' >
<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
	<tr>
		<td  class='button'> 
		<INPUT TYPE="button" value='<fmt:message key="Common.Register.label" bundle="${common_labels}"/>' class='button' onClick='registerOrder()'>
		
		<INPUT TYPE="button" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' class='button' onClick='clearChecked()'>
		</td>
	</tr>

</table>

<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<!-- <input type="hidden" name="function_id" id="function_id" value="<%//=bean.getFunctionId()%>"> -->
</form>

</body>
</html>

