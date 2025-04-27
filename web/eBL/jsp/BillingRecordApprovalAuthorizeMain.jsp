<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
	<title><fmt:message key="eBL.AUTH_SCREEN.label" bundle="${bl_labels}"/></title>
	<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eBL/js/BillingRecordApprovalScript.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<iframe SRC="BillingRecordApprovalAuthorize.jsp?<%=request.getQueryString()%>" name='AuthFrame1' frameborder=0 scrolling='no' noresize style='height:100vh;width:100vw'></iframe>
	<iframe SRC="../../eCommon/html/blank.html" frameborder=0 name='AuthDummyFrame' id='AuthDummyFrame' scrolling='no' noresize style='height:0vh;width:100vw'></iframe>
	
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	</body>
</html>


