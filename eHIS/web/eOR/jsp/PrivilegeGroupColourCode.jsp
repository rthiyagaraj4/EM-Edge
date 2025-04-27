<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@page  import="java.util.*, eOR.* " %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%-- Mandatory declarations end --%>
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
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<!-- 
	Modified by Kishore kumar N on Aug-17-09, for the CRF 641
-->

<!--<table cellpadding=3 cellspacing=0 border=0 width="100%" height="100%" align='center'>
<tr><td>	<table cellpadding=3 cellspacing=0 border=0 width="100%">
					<tr></tr>
					<tr>
					<td style='background-color:#FFFF00'>&nbsp;</td>
					</tr>
					<tr></tr>
				</table>
</td>		<td class='label'>
			<font size=2>A-<fmt:message key="Common.AllOrders.label" bundle="${common_labels}"/></font>
			</td>
<td><table cellpadding=3 cellspacing=0 border=0 width="100%">
					<tr></tr>
					<tr>
					<td style='background-color:#9370DB'>&nbsp;</td>
					</tr>
					<tr></tr>
				</table>
</td>
			<td class='label'>
			<font size=2>S-<fmt:message key="eOR.SelfOrder.label" bundle="${or_labels}"/></font>
			</td>
<td><table cellpadding=3 cellspacing=0 border=0 width="100%">
					<tr></tr>
					<tr>
					<td style='background-color:#90EE90'>&nbsp;</td>
					</tr>
					<tr></tr>
				</table>
</td>
		<td class='label'>
			<font size=2>M-<fmt:message key="eOR.MedicalTeam.label" bundle="${or_labels}"/></font>
			</td>
<td> <table cellpadding=3 cellspacing=0 border=0 width="100%">
					<tr></tr>
					<tr>
					<td style='background-color:#808080'>&nbsp;</td>
					</tr>
					<tr></tr>
				</table>
</td>
			<td class='label'>
			<font size=2>N-<fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></font>
			</td>
			</tr>
			</table> -->

<!-- ends here. -->
			</body>
			</html>

