<!DOCTYPE html>
<html>
<%@ page import = "eXH.*" %>
<%
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");
%> 
<%@ page contentType="text/html;charset=UTF-8" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<jsp:useBean id="notificationCriteriaBean" class="eXH.NotificationCriteriaBean"/>

<link rel='StyleSheet' href='${pageContext.request.contextPath}/eCommon/html/<%=sStyle%>' type='text/css'></link>
<head>
<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="javascript" src="${pageContext.request.contextPath}/eCommon/js/common.js"></script>
<Script Language="JavaScript" src="${pageContext.request.contextPath}/eCommon/js/CommonLookup.js"></Script>
<script language="javascript" src="${pageContext.request.contextPath}/eCommon/js/DateUtils.js"></script>
<script language="javascript" src="${pageContext.request.contextPath}/eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="${pageContext.request.contextPath}/eXH/js/NotificationDisp.js"></script>
<script language="javascript" src="${pageContext.request.contextPath}/eXH/js/NotificationSettings.js"></script>
<SCRIPT LANGUAGE="JAVASCRIPT" SRC='${pageContext.request.contextPath}/eCommon/js/jquery-3.6.3.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<BODY CLASS="MESSAGE" onLoad="initforward()">
<FORM ID="notificationForward" action="${pageContext.request.contextPath}/eXH/jsp/DispNotForward.jsp">
<INPUT TYPE='hidden' name='fromMsgDate' id='fromMsgDate' ID='fromMsgDate' VALUE="${param.fromMsgDate}">
<INPUT TYPE='hidden' name='fromMsgID' id='fromMsgID' ID='fromMsgID' VALUE="${param.fromMsgID}">
<INPUT TYPE='hidden' name='toMsgDate' id='toMsgDate' ID='toMsgDate' VALUE="${param.toMsgDate}">
<INPUT TYPE='hidden' name='toMsgID' id='toMsgID' ID='toMsgID' VALUE="${param.toMsgID}">
<INPUT TYPE='hidden' name='recipientType' id='recipientType' ID='recipientType' VALUE="${param.recipientType}">
<INPUT TYPE='hidden' name='recipientID' id='recipientID' ID='recipientID' VALUE="${param.recipientID}">
<INPUT TYPE='hidden' name='contactType' id='contactType' ID='contactType' VALUE="${param.contactType}">
<INPUT TYPE='hidden' name='notificationType' id='notificationType' ID='notificationType' VALUE="${param.notificationType}">
<INPUT TYPE='hidden' name='languageID' id='languageID' ID='languageID' VALUE="${param.languageID}">
<INPUT TYPE='hidden' name='facilityID' id='facilityID' ID='facilityID' VALUE="${param.facilityID}">
<INPUT TYPE='hidden' name='contactMode' id='contactMode' ID='contactMode' VALUE="${param.contactMode}">
<INPUT TYPE='hidden' name='msgStatus' id='msgStatus' ID='msgStatus' VALUE="${param.msgStatus}">
<INPUT TYPE='hidden' name='messageType' id='messageType' ID='messageType' VALUE="${param.messageType}">
<INPUT TYPE='hidden' name='eventType' id='eventType' ID='eventType' VALUE="${param.eventType}">
<INPUT TYPE='hidden' name='toCommID' id='toCommID' ID='toCommID' VALUE="${param.toCommID}">
</FORM>
</BODY>
</html>

