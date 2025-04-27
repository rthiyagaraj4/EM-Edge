<!DOCTYPE html>
<%@ include file="../../eXH/jsp/CommonInclude.jsp" %>

<SCRIPT LANGUAGE="javascript" SRC="../eCommon/js/CommonCalendar.js"></SCRIPT>
<SCRIPT LANGUAGE="javascript" SRC="../eXH/js/NotificationsDisp.js"></SCRIPT>

<BODY LEFTMARGIN="0" TOPMARGIN="0" onMouseDown="CodeArrest()" onKeyDown ='lockKey()' onLoad="initNotificationDisp('${noRecords}')">
<FORM ID="notificationDisp" name="notificationDisp" id="notificationDisp" METHOD="post">
<c:set var="notificationCriteriaBean" scope="request" value="${requestScope.notificationCriteriaBean}"/>
<% System.out.println("Test JSP"); %>
<TABLE CELLSPACING="0" CELLPADDING="3" BORDER="0" WIDTH="100%">
<TR>
	<TD ALIGN="left" CLASS="CAGROUP" COLSPAN="1">
		Notifications
	</TD>
	<TD ALIGN="right" CLASS="CAGROUP" COLSPAN="12"> 
		<A CLASS='label' STYLE='cursor:pointer' onClick="funAction('P')">${previousPage}</A>
		<A CLASS='label' onClick="funAction('N')" STYLE='cursor:pointer'>${nextPage}</A>
	</TD>
</TR>
</TABLE>
<TABLE CELLSPACING="0" CELLPADDING="3" BORDER="1" WIDTH="100%">
<TR>
	<TD CLASS='COLUMNHEADER'>Status</TD>
	<TD CLASS='COLUMNHEADER'>Message ID</TD>
	<TD CLASS='COLUMNHEADER'>Recipient ID</TD>
	<TD CLASS='COLUMNHEADER'>Message Date</TD>
	<TD CLASS='COLUMNHEADER'>Message Type</TD>
	<TD CLASS='COLUMNHEADER'>Facility</TD>
	<TD CLASS='COLUMNHEADER'>Contact</TD>
	<TD CLASS='COLUMNHEADER'>Recipient Type</TD>
	<TD CLASS='COLUMNHEADER'>Recipient Dependency</TD>
	<TD CLASS='COLUMNHEADER'>Contact Type</TD>
	<TD CLASS='COLUMNHEADER'>Contact Mode</TD>
	<TD CLASS='COLUMNHEADER'>Language</TD>
	<TD CLASS='COLUMNHEADER'>Added By</TD>
	<TD CLASS='COLUMNHEADER'>Added Date</TD>
	<TD CLASS='COLUMNHEADER'>Added WSNO</TD>
	<TD CLASS='COLUMNHEADER'>Added Facility</TD>
	<TD CLASS='COLUMNHEADER'>Modified By</TD>
	<TD CLASS='COLUMNHEADER'>Modified Date</TD>
	<TD CLASS='COLUMNHEADER'>Modified WSNO</TD>
	<TD CLASS='COLUMNHEADER'>Modified Facility</TD>
</TR>

<c:forEach var="notification" items="${notificationList}">
	<c:set var="CLASS_NAME" value="${notification['TD_CLASS_NAME']}" />
<TR>
	<TD CLASS="${CLASS_NAME}"><IMG SRC="${notification['STATUS_COLOR']}" HEIGHT="10"></TD>
	<TD CLASS="${CLASS_NAME}">
		<A HREF="#" onClick="viewMessage('${notification['SMS_BODY_CONTENT_CLOB']}',
											'${notification['MAIL_BODY_CONTENT_CLOB']}',
											'${notification['STATUS_TEXT']}')">
			<IMG BORDER="0" SRC="../eXH/images/setting.png" TITLE="View Message">
		</A>
	</TD>
	<TD CLASS="${CLASS_NAME}">${notification['MESSAGE_ID']}</TD>
	<TD CLASS="${CLASS_NAME}">${notification['RECIPIENT_ID']}</TD>
	<TD CLASS="${CLASS_NAME}">${notification['MESSAGE_DATE']}</TD>
	<TD CLASS="${CLASS_NAME}">${notification['EVENT_NAME']}</TD>
	<TD CLASS="${CLASS_NAME}">${notification['FACILITY_ID']}</TD>
	<TD CLASS="${CLASS_NAME}">${notification['RECIPIENT_TYPE']}</TD>
	<TD CLASS="${CLASS_NAME}">${notification['RECIPIENT_DEPENDENCY']}</TD>
	<TD CLASS="${CLASS_NAME}">${notification['CONTACT_TYPE']}</TD>
	<TD CLASS="${CLASS_NAME}">${notification['CONTACT_MODE']}</TD>
	<TD CLASS="${CLASS_NAME}">${notification['LANGUAGE']}</TD>
	<TD CLASS="${CLASS_NAME}">${notification['ADDED_BY_ID']}</TD>
	<TD CLASS="${CLASS_NAME}">${notification['ADDED_DATE']}</TD>
	<TD CLASS="${CLASS_NAME}">${notification['ADDED_AT_WS_NO']}</TD>
	<TD CLASS="${CLASS_NAME}">${notification['ADDED_FACILITY_ID']}</TD>
	<TD CLASS="${CLASS_NAME}">${notification['MODIFIED_DATE']}</TD>
	<TD CLASS="${CLASS_NAME}">${notification['MODIFIED_AT_WS_NO']}</TD>
	<TD CLASS="${CLASS_NAME}">${notification['MODIFIED_FACILITY_ID']}</TD>
</TR>
</c:forEach>
</TABLE>
</FORM>
</BODY>
</HTML>

