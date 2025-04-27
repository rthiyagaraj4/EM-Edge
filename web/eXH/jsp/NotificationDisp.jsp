<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<jsp:useBean id="notificationCriteriaBean" class="eXH.NotificationCriteriaBean"/>	
<%
String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<SCRIPT>
var contextPath = "<%=request.getContextPath()%>";
</SCRIPT>

<HTML>
<HEAD>
<TITLE>$(param.title)</TITLE>
<link rel='StyleSheet' href='${pageContext.request.contextPath}/eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' type ='text/css' href='${pageContext.request.contextPath}/eCommon/html/Tabs.css'></link>
<link rel='stylesheet' href='${pageContext.request.contextPath}/eXH/html/menu.css' type='text/css'></link>
<!-- these style setting are used for table scroll -->
<style>
	div {float: left}
	.testSty
	{
		width:expression(document.getElementById("indicatorTable").clientWidth-document.getElementById("left_child").clientWidth);
		overflow: scroll;
	}
</style>

<SCRIPT LANGUAGE="javascript" SRC="${pageContext.request.contextPath}/eCommon/js/CommonCalendar.js"></SCRIPT>
<SCRIPT LANGUAGE="javascript" SRC="${pageContext.request.contextPath}/eXH/js/InterfaceUtil.js"></SCRIPT>
<SCRIPT LANGUAGE="javascript" SRC="${pageContext.request.contextPath}/eCommon/js/Common.js"></SCRIPT>
<SCRIPT LANGUAGE="javascript" SRC="${pageContext.request.contextPath}/eXH/js/NotificationDisp.js"></SCRIPT>
<SCRIPT LANGUAGE="JAVASCRIPT" SRC="${pageContext.request.contextPath}/eCommon/js/ValidateControl.js"></script>
<SCRIPT LANGUAGE="JAVASCRIPT" SRC='${pageContext.request.contextPath}/eCommon/js/jquery-3.6.3.js'></script>
<SCRIPT LANGUAGE="JAVASCRIPT" SRC='${pageContext.request.contextPath}/eXH/js/Validate.js'></script>
<SCRIPT LANGUAGE="JAVASCRIPT" SRC="${pageContext.request.contextPath}/eCommon/js/CommonLookup.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<BODY LEFTMARGIN="0" TOPMARGIN="0" onMouseDown="CodeArrest()" onKeyDown='submitFormOnEnter()' onLoad="initNotificationDisp('${noRecords}')">
<FORM ID="notificationDisp" name="notificationDisp" id="notificationDisp" METHOD="post" ACTION='./DisplayNotificationServlet'>

<TABLE ID="indicatorTable" CELLSPACING="0" CELLPADDING="3" BORDER="0" WIDTH="100%">
<TR>
	<TD ALIGN="left" CLASS="CAGROUP" COLSPAN="1">
		<A CLASS='label' STYLE='cursor:pointer' accesskey="E" onClick="editCriteria()">Edit Criteria</A>
	</TD>
	<TD CLASS='CAGROUP' ALIGH="right" COLSPAN="9"><FONT CLASS='label'>Total Records - ${DBQRY_TOT_ROWS}</FONT></TD>
	<TD ALIGN="right" CLASS="CAGROUP" COLSPAN="3"> 
		<A CLASS='label' STYLE='cursor:pointer' onClick="funAction('P')">${previousPage}</A>
		<A CLASS='label' onClick="funAction('N')" STYLE='cursor:pointer'>${nextPage}</A>
	</TD>
</TR>
</TABLE>
<div id="left_child" style="display:none;">
<table id="table1" cellspacing=0 cellpadding=3 border=1>
<TR>
	<TD CLASS='COLUMNHEADER'>#</TD>
	<TD CLASS='COLUMNHEADER'>Message ID</TD>
	<TD CLASS='COLUMNHEADER'>Message Date</TD>
	<TD CLASS='COLUMNHEADER'>Facility</TD>
	<TD CLASS='COLUMNHEADER'>Contact</TD>
	<TD CLASS='COLUMNHEADER'>Message Type</TD>
	<TD CLASS='COLUMNHEADER'>Recipient ID</TD>
</TR>
<c:forEach var="notification" items="${notificationsList}">
<TR>
	<c:set var="CLASS_NAME" value="${notification['TD_CLASS_NAME']}" />
	<c:if test="${notification['MESSAGE_STATUS'] == 'S'}">
		<c:set var="IMG_SRC" value="../eXH/images/green_square.jpg" />
	</c:if>
	<c:if test="${notification['MESSAGE_STATUS'] == 'E'}">
		<c:set var="IMG_SRC" value="../eXH/images/red_square.jpg" />
	</c:if>
	<c:if test="${notification['MESSAGE_STATUS'] == ''}">
		<c:set var="IMG_SRC" value="../eXH/images/blue_square.jpg" />
	</c:if>
	<TD CLASS="${CLASS_NAME}"><IMG SRC="${IMG_SRC}" HEIGHT="8"></TD>
	<TD CLASS="${CLASS_NAME}">
		<A HREF="#" onClick="viewMessage('${notification['MESSAGE_ID']}')">
			${notification['MESSAGE_ID']}
		</A>
	</TD>
	<TD CLASS="${CLASS_NAME}">${notification['MESSAGE_DATE']}&nbsp;</TD>
	<TD CLASS="${CLASS_NAME}">${notification['FACILITY_ID']}&nbsp;</TD>
	<TD CLASS="${CLASS_NAME}">${notification['TO_COMMUNICATION_ID']}&nbsp;</TD>
	<TD CLASS="${CLASS_NAME}">${notification['EVENT_NAME']}&nbsp;</TD>
	<TD CLASS="${CLASS_NAME}">${notification['RECIPIENT_ID']}&nbsp;</TD>
</TR>
</c:forEach>
</TABLE>
</div>
<div id="right_child" class="testSty" style="overflow-y:scroll;overflow:-moz-scrollbars-vertical;display:none;">
<table id="table2" cellspacing=0 cellpadding=3 border=1>
<TR>
	<TD CLASS='COLUMNHEADER' nowrap>Recipient Type</TD>
	<TD CLASS='COLUMNHEADER' nowrap>Recipient Dependency</TD>
	<TD CLASS='COLUMNHEADER' nowrap>Contact Type</TD>
	<TD CLASS='COLUMNHEADER' nowrap>Contact Mode</TD>
	<TD CLASS='COLUMNHEADER' nowrap>Language</TD>
	<TD CLASS='COLUMNHEADER' nowrap>Added By</TD>
	<TD CLASS='COLUMNHEADER' nowrap>Added Date</TD>
	<TD CLASS='COLUMNHEADER' nowrap>Added WSNO</TD>
	<TD CLASS='COLUMNHEADER' nowrap>Added Facility</TD>
	<TD CLASS='COLUMNHEADER' nowrap>Modified By</TD>
	<TD CLASS='COLUMNHEADER' nowrap>Modified Date</TD>
	<TD CLASS='COLUMNHEADER' nowrap>Modified WSNO</TD>
	<TD CLASS='COLUMNHEADER' nowrap>Modified Facility</TD>
</TR>
<c:forEach var="notification" items="${notificationsList}">
<TR>
	<c:set var="CLASS_NAME" value="${notification['TD_CLASS_NAME']}" />
	<TD CLASS="${CLASS_NAME}" nowrap>${notification['RECEIPIENT_TYPE']}&nbsp;</TD>
	<TD CLASS="${CLASS_NAME}" nowrap>${notification['RECEIPIENT_DEPENDENCY']}&nbsp;</TD>
	<TD CLASS="${CLASS_NAME}" nowrap>${notification['CONTACT_TYPE']}&nbsp;</TD>
	<TD CLASS="${CLASS_NAME}" nowrap>${notification['CONTACT_MODE']}&nbsp;</TD>
	<TD CLASS="${CLASS_NAME}" nowrap>${notification['LANG_DESC']}&nbsp;</TD>
	<TD CLASS="${CLASS_NAME}" nowrap>${notification['ADDED_BY_ID']}&nbsp;</TD>
	<TD CLASS="${CLASS_NAME}" nowrap>${notification['ADDED_DATE']}&nbsp;</TD>
	<TD CLASS="${CLASS_NAME}" nowrap>${notification['ADDED_AT_WS_NO']}&nbsp;</TD>
	<TD CLASS="${CLASS_NAME}" nowrap>${notification['ADDED_FACILITY_ID']}&nbsp;</TD>
	<TD CLASS="${CLASS_NAME}" nowrap>${notification['MODIFIED_BY_ID']}&nbsp;</TD>
	<TD CLASS="${CLASS_NAME}" nowrap>${notification['MODIFIED_DATE']}&nbsp;</TD>
	<TD CLASS="${CLASS_NAME}" nowrap>${notification['MODIFIED_AT_WS_NO']}&nbsp;</TD>
	<TD CLASS="${CLASS_NAME}" nowrap>${notification['MODIFIED_FACILITY_ID']}&nbsp;</TD>
</TR>
</c:forEach>
</TABLE>
</DIV>
<SCRIPT>
	document.getElementById("left_child").style.display = "block";
	document.getElementById("right_child").style.display = "block"; 
</SCRIPT>
<INPUT TYPE='hidden' name='action_type' id='action_type' ID='action_type' VALUE="${action_type}">
<INPUT TYPE='hidden' name='requestType' id='requestType' ID='requestType' VALUE="${requestType}">
<INPUT TYPE='hidden' name='fromMsgID' id='fromMsgID' ID='fromMsgID' VALUE="${requestScope.notificationCriteriaBean.fromMsgID}">
<INPUT TYPE='hidden' name='toMsgID' id='toMsgID' ID='toMsgID' VALUE="${requestScope.notificationCriteriaBean.toMsgID}">
<INPUT TYPE='hidden' name='recipientType' id='recipientType' ID='recipientType' VALUE="${requestScope.notificationCriteriaBean.recipientType}">
<INPUT TYPE='hidden' name='fromMsgDate' id='fromMsgDate' ID='fromMsgDate' VALUE="${requestScope.notificationCriteriaBean.fromMsgDate}">
<INPUT TYPE='hidden' name='toMsgDate' id='toMsgDate' ID='toMsgDate' VALUE="${requestScope.notificationCriteriaBean.toMsgDate}">
<INPUT TYPE='hidden' name='msgStatus' id='msgStatus' ID='fromMsgID' VALUE="${requestScope.notificationCriteriaBean.msgStatus}">
<INPUT TYPE='hidden' name='contactMode' id='contactMode' ID='contactMode' VALUE="${requestScope.notificationCriteriaBean.contactMode}">
<INPUT TYPE='hidden' name='facilityID' id='facilityID' ID='facilityID' VALUE="${requestScope.notificationCriteriaBean.facilityID}">
<INPUT TYPE='hidden' name='recipientID' id='recipientID' ID='recipientID' VALUE="${requestScope.notificationCriteriaBean.recipientID}">
<INPUT TYPE='hidden' name='contactType' id='contactType' ID='contactType' VALUE="${requestScope.notificationCriteriaBean.contactType}">
<INPUT TYPE='hidden' name='languageID' id='languageID' ID='languageID' VALUE="${requestScope.notificationCriteriaBean.languageID}">
<INPUT TYPE='hidden' name='notificationType' id='notificationType' ID='notificationType' VALUE="${requestScope.notificationCriteriaBean.notificationType}">
<INPUT TYPE='hidden' name='toCommID' id='toCommID' ID='toCommID' VALUE="${requestScope.notificationCriteriaBean.toCommID}">
<INPUT TYPE='hidden' name='messageTypeDesc' id='messageTypeDesc' ID='messageTypeDesc' VALUE="${requestScope.notificationCriteriaBean.messageTypeDesc}">
<INPUT TYPE='hidden' name='messageType' id='messageType' ID='messageType' VALUE="${requestScope.notificationCriteriaBean.messageType}">
<INPUT TYPE='hidden' name='eventTypeDesc' id='eventTypeDesc' ID='eventTypeDesc' VALUE="${requestScope.notificationCriteriaBean.eventTypeDesc}">
<INPUT TYPE='hidden' name='eventType' id='eventType' ID='eventType' VALUE="${requestScope.notificationCriteriaBean.eventType}">
</FORM>
</BODY>
</HTML>

