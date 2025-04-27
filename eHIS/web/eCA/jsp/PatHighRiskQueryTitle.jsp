<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<HTML>
<head>
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
 <%
	request.setCharacterEncoding("UTF-8");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<!-- ****  Modified by kishor kumar n on 03/12/2008 for crf0387 applied new css grid. **** -->
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<!-- ends here -->

</head>

<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<table width="100%" align='center'border='1' cellpadding='0' cellspacing='0'>
		<tr>
			<th class='columnheader'  width='44%'><fmt:message key="Common.HighRiskConditions.label" bundle="${common_labels}"/></th>
			<th class='columnheader' ><fmt:message key="Common.onsetdate.label" bundle="${common_labels}"/></th>
		</tr>
	<table>
	</BODY>
</HTML>

