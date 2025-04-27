<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eXH/jsp/CommonInclude.jsp" %>
<html>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
<head>
<link rel='stylesheet' type='text/css' href='../eCommon/html/<%=sStyle%>'></link>
<SCRIPT LANGUAGE="javascript" SRC="../eXH/js/CommonCalendar.js"></SCRIPT>
<SCRIPT LANGUAGE="javascript" SRC="../eXH/js/NotificationTypeSetup.js"></SCRIPT>
<script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY LEFTMARGIN="0" TOPMARGIN="0" onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<FORM ID="notificationTypeList" name="notificationTypeList" id="notificationTypeList" METHOD="post" ACTION='../servlet/eXH.NotificationTypeSetupServlet'>

<TABLE CELLSPACING="0" CELLPADDING="3" BORDER="1" WIDTH="100%">
<TR>
	<TD ALIGN="right" CLASS="CAGROUP" COLSPAN="7"> 
		<A CLASS='label' onClick="funAction('P')" STYLE='cursor:pointer'>${previousPage}</A>
		<A CLASS='label' onClick="funAction('N')" STYLE='cursor:pointer'>${nextPage}</A>
	</TD>
</TR>
<TR>
	<TD CLASS='COLUMNHEADER'>Type Code</TD>
	<TD CLASS='COLUMNHEADER'>Description</TD>
	<TD CLASS='COLUMNHEADER'>Type Class</TD>
	<TD CLASS='COLUMNHEADER'>Status</TD>
</TR>
<c:forEach var="notificationType" items="${notificationTypes}">
<TR>
	<TD CLASS="${notificationType[4]}">
		<A HREF='#' onClick='funModify(this)' typeCode='${notificationType[3]}'>${notificationType[3]}</a>
	</TD>
	<TD CLASS="${recipient[4]}">${notificationType[0]}</TD>
	<TD CLASS="${recipient[4]}">${notificationType[1]}</TD>
	<TD CLASS="${recipient[4]}">
	<c:if test="${notificationType[2] == 'E'}">
		<IMG SRC='../eCommon/images/enabled.gif'>
	</c:if>
	<c:if test="${notificationType[2] == 'D'}">
		<IMG SRC='../eCommon/images/disabled.gif'>
	</c:if>
	</TD>
</TR>
</c:forEach>
</TABLE>

<INPUT TYPE='hidden' name='action_type' id='action_type' ID='action_type' VALUE="${action_type}">
<INPUT TYPE='hidden' name='requestType' id='requestType' ID='requestType'>
</FORM>
</BODY>
</HTML>

