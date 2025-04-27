<!DOCTYPE html>
<%@ include file="../../eXH/jsp/CommonInclude.jsp" %>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
<link rel='StyleSheet' href='../eCommon/html/<%=sStyle%>' type='text/css'></link>
<SCRIPT LANGUAGE="javascript" SRC="../eXH/js/CommonCalendar.js"></SCRIPT>
<SCRIPT LANGUAGE="javascript" SRC="../eXH/js/NotificationConsent.js"></SCRIPT>
</head>



<BODY LEFTMARGIN="0" TOPMARGIN="0" onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<FORM ID="notificationConsentList" name="notificationConsentList" id="notificationConsentList" METHOD="post" ACTION='../servlet/eXH.notificationConsentSetupServlet'>

<TABLE CELLSPACING="0" CELLPADDING="3" BORDER="1" WIDTH="100%">
<TR>
	<TD ALIGN="right" CLASS="CAGROUP" COLSPAN="7"> 
		<A CLASS='label' onClick="funAction('P')" STYLE='cursor:pointer'>${previousPage}</A>
		<A CLASS='label' onClick="funAction('N')" STYLE='cursor:pointer'>${nextPage}</A>
	</TD>
</TR>
<TR>
	<TD CLASS='COLUMNHEADER'>Patient ID</TD>
	<TD CLASS='COLUMNHEADER'>Contact Mode</TD>
	<TD CLASS='COLUMNHEADER'>Language</TD>
	<TD CLASS='COLUMNHEADER'>Status</TD>
</TR>
<c:forEach var="notificationConsent" items="${notificationConsents}">
<TR>
	<TD CLASS="${notificationConsent[4]}">
		<A HREF='#' onClick='funModify(this)' typeCode='${notificationConsent[3]}'>${notificationConsent[0]}</a>
	</TD>
	<TD CLASS="${recipient[15]}">${notificationConsent[4]}</TD>
	<TD CLASS="${recipient[15]}">${languages[notificationConsent[7]]}</TD>
	<TD CLASS="${recipient[15]}">${notificationConsent[5]}</TD>
</TR>
</c:forEach>
</TABLE>

<INPUT TYPE='hidden' name='action_type' id='action_type' ID='action_type' VALUE="${action_type}">
<INPUT TYPE='hidden' name='requestType' id='requestType' ID='requestType'>
</FORM>
</BODY>
</HTML>

