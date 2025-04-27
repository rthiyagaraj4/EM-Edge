<!DOCTYPE html>
 <!-- 
Developed by	: P.Sudhakaran.
Module/Function : Drug Item Link (Master)
--><%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.* , eCommon.Common.*" %>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>

<head>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../js/DrugItemLink.js"></script>
<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="drugitem_tab" id="drugitem_tab">
	<table border="0" width="30%" cellspacing="0" cellpadding="0">
		<tr>
		<td>
		<img src="../../ePH/images/Matching Records.gif" border="0" onClick="callMatchingRecords('matching_record');" id="matching_record"></img></td>
		<td><img src='../../ePH/images/Missing Records_click.gif' border='0' onClick="callMissingRecords('missing_record');" id="missing_record"></img></td>
		</tr>
	</table>
</form>
</body>

</html>

