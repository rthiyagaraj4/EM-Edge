<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<%
String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<HTML>
<HEAD>
<TITLE>Message Contents</TITLE>
<link rel='StyleSheet' href='${pageContext.request.contextPath}/eCommon/html/<%=sStyle%>' type='text/css'></link>
<SCRIPT LANGUAGE="javascript" SRC="${pageContext.request.contextPath}/eXH/js/NotificationsDisp.js"></SCRIPT>
<SCRIPT LANGUAGE="JAVASCRIPT" SRC="${pageContext.request.contextPath}/eCommon/js/ValidateControl.js"></script>
<SCRIPT LANGUAGE="JAVASCRIPT" SRC='${pageContext.request.contextPath}/eCommon/js/jquery-3.6.3.js'></script>
<SCRIPT LANGUAGE="JAVASCRIPT" SRC='${pageContext.request.contextPath}/eXH/js/Validate.js'></script>

<SCRIPT LANGUAGE="VBScript">
Function openDoc(folder, filename)
	Set fso = CreateObject("Scripting.FileSystemObject")
	If (fso.FileExists(filename)) Then
		Set objWord = CreateObject("Word.Application")
		objWord.Visible = true
		objWord.Documents.Open filename
	Else
		MsgBox ("Template file does not exist!!!")
	End If
End Function
</SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>

<BODY LEFTMARGIN="0" TOPMARGIN="0" onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<FORM ID="notificationContentDisp" name="notificationContentDisp" id="notificationContentDisp" METHOD="post">

<table cellspacing=0 cellpadding=3 border=1 ALIGN="center">
<c:set var="notification" value="${requestScope.notificationContents}" />
<c:if test="${notification['CONTACT_MODE'] == 'M'}">
<TR>
	<TD CLASS='LABEL'>SMS</TD>
	<TD CLASS='FIELD'><TEXTAREA NAME="smsContent" ROWS="4" COLS="75">${notification['SMS_CONTENT']}</TEXTAREA></TD>
	<TD CLASS='FIELD'>
		<A HREF="#" onClick="openDoc('${notification['TEMPLATE_FOLDER']}','${notification['NOTIFICATION_TEMPLATE_ID']}')">
			View Template
		</A>
	</TD>
</TR>
</c:if>
<c:if test="${notification['CONTACT_MODE'] == 'E'}">
<TR>
	<TD CLASS='LABEL'>Mail</TD>
	<TD CLASS='FIELD'><TEXTAREA NAME="mailContent" ROWS="4" COLS="75">${notification['MAIL_CONTENT']}</TEXTAREA></TD>
	<TD CLASS='FIELD'>
		<A HREF="#" onClick="openDoc('${notification['TEMPLATE_FOLDER']}','${notification['NOTIFICATION_TEMPLATE_ID']}')">
			View Template
		</A>
	</TD>
</TR>
<TR>
	<TD CLASS='LABEL'>Subject</TD>
	<TD CLASS='FIELD'><TEXTAREA NAME="subject" ROWS="2" COLS="75">${notification['MAIL_SUBJECT_CONTENT_CLOB']}</TEXTAREA></TD>
</TR>
</c:if>
<TR>
	<TD CLASS='LABEL'>Status</TD>
	<TD CLASS='FIELD'><TEXTAREA NAME="status" ROWS="4" COLS="75">${notification['STATUS_TEXT']}</TEXTAREA></TD>
</TR>
</TABLE>
</FORM>
</BODY>
</HTML>

