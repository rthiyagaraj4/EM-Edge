<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<head>
<%
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script language="JavaScript" src="../../eOR/js/OrCommonLookup.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<div align='right'>
<table  cellpadding='0' cellspacing='0' >
	<tr>
		<td >
			<input type='button' name='close' id='close' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='closew()' class='button'>	
		</td>
	</tr>
</table>
</div>
</body>
</html>


