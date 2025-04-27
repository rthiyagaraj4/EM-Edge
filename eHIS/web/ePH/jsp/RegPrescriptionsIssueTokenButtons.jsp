<!DOCTYPE html>
 <%@page contentType="text/html;charset=UTF-8  " import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
<!-- 	<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
	<script language="JavaScript" src="../../ePH/js/PhMessages.js"></script>
 -->	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../ePH/js/RegPrescriptions.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0">
<form name="regprescriptionsissuetokebuttons" id="regprescriptionsissuetokebuttons" >
<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0" >
	<tr>
		<td align="right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<input type="button" name="btnGenerateToken" id="btnGenerateToken" value='<fmt:message key="ePH.GenerateToken.label" bundle="${ph_labels}"/> ' class="button"  onClick="generateToken()">&nbsp;&nbsp;&nbsp;<input type="button" name="btnTokenCancel" id="btnTokenCancel" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/> '  class="button" disabled onClick="cancelIssueToken()">&nbsp;&nbsp;&nbsp;</td> 
	</tr>
</table>
</form>
</body>
</html>

