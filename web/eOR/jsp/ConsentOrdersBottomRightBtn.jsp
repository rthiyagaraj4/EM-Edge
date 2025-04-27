<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- ConsentOrdersBottomRightBtn.jsp -->
<%@page contentType="text/html; charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

 

<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%request.setCharacterEncoding("UTF-8");%>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../js/ConsentOrder.js"></script>
 	<script language="JavaScript" src="../js/AuthoriseOrder.js"></script>
 	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body   onload='FocusFirstElement()'  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	//String readOnly = "" ;
	//String checked = "checked" ;
	/* Mandatory checks start */
	//String mode	   = request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_ConsentOrders" ;
	String bean_name = "eOR.ConsentOrders";
	//String disabled = "" ;

	String oledb_con_string=(String)session.getValue("oledb_con_string");
	String user_id = (String)session.getValue("login_user");
/* Mandatory checks end */
 

%>
<form name='consent_order' id='consent_order' target='messageFrame' >
<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
	<tr>
		<td class='button' align="right">
		<INPUT TYPE="button" value='<fmt:message key="eOR.RecordConsent.label" bundle="${or_labels}"/>' class='button' onClick=' return consent()'>
		
		<INPUT TYPE="button" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' class='button' onClick='clearConsentChecked()'>
		</td>
	</tr>

</table>

<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type='hidden' name='user_id' id='user_id' value='<%=user_id%>'>
<input type='hidden' name ='oledb_con_string' value='<%=oledb_con_string%>' >
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
<OBJECT ID="WebFp"
CLASSID="CLSID:CA452A7B-737F-434D-904A-AB06E644C25F"
CODEBASE="PrintFPCom.CAB#version=1,0,0,0" VIEWASTEXT HEIGHT=0 WIDTH=0></OBJECT>

<!-- <input type="hidden" name="function_id" id="function_id" value="<%//=bean.getFunctionId()%>"> -->
</form>

</body>
</html>

