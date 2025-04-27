<!DOCTYPE html>
<!--This file is saved on 07/11/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<HTML>
	<HEAD>
<%
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	 
		String locale			= (String)session.getAttribute("LOCALE");
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../js/IPFillAll.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<title>Confirm Print Unallocated Drug/Medical supply</title>
	</HEAD>
	<body class='MESSAGE' onKeyDown="lockKey()" >
		<FORM name="frmUnallocatedPrintAlert" id="frmUnallocatedPrintAlert"  TARGET="messageFrame" align='center'>
			<p align='center'>
			<br><br>
			<label id='printAlertmsg' align='center'></label>
			<br><br>
			<input type="button" class="button" value='  <fmt:message key="Common.yes.label" bundle="${common_labels}"/> ' name='Yes' onclick="closeWindow('Y');"> &nbsp;&nbsp;
			<input type="button" class="button" name="No" id="No" value='  <fmt:message key="Common.no.label" bundle="${common_labels}"/>  ' onclick="closeWindow('N');">
			</p>
		</FORM>
	</BODY>
	<script>
		document.frmUnallocatedPrintAlert.printAlertmsg.innerHTML ='&nbsp;'+ getMessage('PH_IP_FILL_ALL_PRINT_UNALLOC_DRUGMEDITEM_YN','PH');
	</script>
</HTML>

