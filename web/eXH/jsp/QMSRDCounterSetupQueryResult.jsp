<!DOCTYPE html>
<%@ include file="../../eXH/jsp/CommonInclude.jsp" %>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
<link rel='StyleSheet' href='../eCommon/html/<%=sStyle%>' type='text/css'></link>

<SCRIPT LANGUAGE="javascript" SRC="../eXH/js/CommonCalendar.js"></SCRIPT>
<SCRIPT LANGUAGE="javascript" SRC="../eXH/js/QMSRDCounterSetup.js"></SCRIPT>
</head>
<BODY LEFTMARGIN="0" TOPMARGIN="0" onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<FORM ID="counterList" name="counterList" id="counterList" METHOD="post" ACTION='../servlet/eXH.NotificationRecipientServlet'>

<TABLE CELLSPACING="0" CELLPADDING="3" BORDER="1" WIDTH="100%">
<TR>
	<TD ALIGN="right" CLASS="CAGROUP" COLSPAN="7"> 
		<A CLASS='label' onClick="funAction('P')" STYLE='cursor:pointer'>${previousPage}</A>
		<A CLASS='label' onClick="funAction('N')" STYLE='cursor:pointer'>${nextPage}</A>
	</TD>
</TR>
<TR>
	<TD CLASS='COLUMNHEADER'>Section</TD>
	<TD CLASS='COLUMNHEADER'>Study Location</TD>
	<TD CLASS='COLUMNHEADER'>Facility</TD>
	<TD CLASS='COLUMNHEADER'>Service ID</TD>
	<TD CLASS='COLUMNHEADER'>Counter Name</TD>
</TR>
<c:forEach var="counter" items="${counters}">
<TR>
	<TD CLASS="${counter[15]}">
		<A HREF='#' onClick='funModify(this)' sectionCode='${counter[0]}' studyLocation='${counter[4]}' facilityID='${counter[6]}'>${counter[1]}</a>
	</TD>
	<TD CLASS="${counter[15]}">${counter[5]}</TD>
	<TD CLASS="${counter[15]}">${counter[7]}</TD>
	<TD CLASS="${counter[15]}">${counter[3]}</TD>
	<TD CLASS="${counter[15]}">${counter[2]}</TD>
</TR>
</c:forEach>
</TABLE>

<INPUT TYPE='hidden' name='action_type' id='action_type' ID='action_type' VALUE="${action_type}">
<INPUT TYPE='hidden' name='requestType' id='requestType' ID='requestType'>
</FORM>
</BODY>
</HTML>

