<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes start --%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<title><fmt:message key="eOR.InstructionsMode.label" bundle="${or_labels}"/></title>
</head>
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">

<%
	request.setCharacterEncoding("UTF-8");

	/* Mandatory checks start */
	String mode	   = "1";//request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_ViewOrder" ;
	String bean_name = "eOR.ViewOrder";

	String reason_code = request.getParameter("reason_code");
/* Mandatory checks end */
	
	/* Initialize Function specific start */
	//ViewOrder bean = (ViewOrder)mh.getBeanObject( bean_id, request,  bean_name ) ; 
	ViewOrder bean	= (ViewOrder)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);

	
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
 
	bean.clear() ;
	bean.setMode( mode ) ;

	String instructions_mode =  bean.getInstructionsMode(reason_code);
%>
<form method=post action="">
<table cellpadding=0 cellspacing=0 border=0 align=center>
<tr>
	<td align=center>
		<TEXTAREA NAME="" ROWS="6" COLS="60" readonly><%=instructions_mode%></TEXTAREA>
	</td>
</tr>
<tr>
	<td class="button" align="right"><INPUT TYPE="button"  class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onClick='window.close()'>
	</td>
</tr>
</table>
</FORM>

</BODY>
</HTML>


<%
		putObjectInBean(bean_id,bean,request);
%>

