<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- ReportAuthorizationBottomRightBtn.jsp -->
<%@page contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085	
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../js/ReportAuthorization.js"></script>
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onload='FocusFirstElement()'  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%  
	String oledb_con_string=(String)session.getValue("oledb_con_string");
	String user_id = (String)session.getValue("login_user");

 //   String readOnly = "" ;
//	String checked = "checked" ;
	/* Mandatory checks start */
	//String mode	   = request.getParameter( "mode" ) ;
	String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_ReportAuthorization" ;
	String bean_name = "eOR.ReportAuthorization";
	//String disabled = "" ;


/* Mandatory checks end */

%>
<form name='report_authorization_btn' id='report_authorization_btn' target='messageFrame' >
<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
	<tr>
		<td  class='button' align="right">
		<INPUT TYPE="button" value='<fmt:message key="Common.Authorized.label" bundle="${common_labels}"/>' class='button' onClick='authorizeReport()'>
	
		<INPUT TYPE="button" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' class='button' onClick='clearChecked()'>
		</td>
	</tr>

</table>

<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="function_id" id="function_id" value="<%=function_id%>">
<input type='hidden' name ='oledb_con_string' value='<%=oledb_con_string%>' >
<input type='hidden' name='user_id' id='user_id' value='<%=user_id%>'>

<OBJECT ID="WebFp"
CLASSID="CLSID:CA452A7B-737F-434D-904A-AB06E644C25F"
CODEBASE="PrintFPCom.CAB#version=1,0,0,0" VIEWASTEXT></OBJECT>
</form>

</body>
</html>

