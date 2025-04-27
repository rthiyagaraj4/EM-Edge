<!DOCTYPE html>
<%@ include file="../../eXH/jsp/CommonIncludeSession.jsp" %>
<%@ page import = "eXH.*" %> 

<script>
var contextPath = "<%=request.getContextPath()%>";
</script>

<style type="text/css">
#centerTable {
    position:fixed;
    top: 35%;
    left: 45%;
    margin-top: -9em; /*set to a negative number 1/2 of your height*/
    margin-left: -15em; /*set to a negative number 1/2 of your width*/
}
#buttonTable {
    position:fixed;
    top: 70%;
    left: 45%;
    margin-top: 5em; /*set to a negative number 1/2 of your height*/
    margin-left: -27em; /*set to a negative number 1/2 of your width*/
}
</style>

<SCRIPT TYPE="text/javascript" SRC="${pageContext.request.contextPath}/eXH/js/NotificationSettings.js"></SCRIPT>
<SCRIPT TYPE="text/javascript" SRC='${pageContext.request.contextPath}/eCommon/js/common.js'> </Script>

<BODY onMouseDown="CodeArrest()" onKeyDown ='lockKey()' onLoad="filterCriteriaInit()">
<FORM ID="notificationFilterCriteria" name="notificationFilterCriteria" id="notificationFilterCriteria" METHOD="post">

<c:set var="listValues" value='<%= NotificationBean.searchCriteria((String)session.getAttribute("LOCALE")) %>' />
<c:set var="locale" value="${LOCALE}" />

<TABLE CELLSPACING="1" CELLPADDING="3" ALIGN="center" ID="centerTable">
<TR>
	<TD CLASS="LABEL">Message Type</TD>
	<TD CLASS="FIELDS">
		<INPUT TYPE="text" ID="messageTypeDesc" name="messageTypeDesc" id="messageTypeDesc" VALUE="${param.messageTypeDesc}" onBlur="if(this.value != '') queryMessageType();else messageType.value = ''">
		<INPUT CLASS="BUTTON" TYPE="button"  name='messageTypeSearch' id='messageTypeSearch' ID="messageTypeSearch" VALUE='?' onClick="queryMessageType()">
		<INPUT TYPE="hidden" name="messageType" id="messageType" ID="messageType" VALUE="${param.messageType}">
	</TD>
</TR>
<TR>
	<TD CLASS="LABEL">Event Type</TD>
	<TD CLASS="FIELDS">
		<INPUT TYPE="text" ID="eventTypeDesc" name="eventTypeDesc" id="eventTypeDesc" VALUE="${param.eventTypeDesc}" onBlur="if(this.value != '') queryEventType();else eventType.value = ''">
		<INPUT CLASS="BUTTON" TYPE="button"  name='eventTypeSearch' id='eventTypeSearch' ID="eventTypeSearch" VALUE='?' onClick="queryEventType()">
		<INPUT TYPE="hidden" name="eventType" id="eventType" ID="eventType" VALUE="${param.eventType}">
	</TD>
</TR>
<TR>
	<TD CLASS="LABEL">Recipient Type</TD>
	<TD CLASS="FIELDS">
		<SELECT ID="recipientType" name="recipientType" id="recipientType" onChange="recipientTypeChange()" STYLE="width:150px">
		<c:forEach var="recipientType" items="${listValues['recipientTypes']}">
			<OPTION VALUE="${recipientType.key}" ${recipientType.key == param.recipientType ? 'SELECTED':''}>${recipientType.value}</OPTION>
		</c:forEach>
		</SELECT>
	</TD>
</TR>
<TR>
	<TD CLASS="LABEL">Recipient ID</TD>
	<TD CLASS="FIELDS">
		<INPUT TYPE="text" ID="recipientName" name="recipientName" id="recipientName" VALUE="${param.recipientName}" onBlur="recipientIDChange()" DISABLED>
		<INPUT CLASS="BUTTON" TYPE="button"  name='recipientSearch' id='recipientSearch' ID="recipientSearch" VALUE='?' onClick="queryRecipientID()" DISABLED>
		<INPUT TYPE="hidden" name="recipientID" id="recipientID" ID="recipientID" VALUE="${param.recipientID}">
	</TD>
</TR>
<TR>
	<TD CLASS="LABEL">Recipient Dependancy</TD>
	<TD CLASS="FIELDS">
		<INPUT TYPE="text" ID="recipientDependancyName" name="recipientDependancyName" id="recipientDependancyName" VALUE="${param.recipientDependancyName}" onBlur="queryRecipientDependency()" DISABLED>
		<INPUT CLASS="BUTTON" TYPE="button" ID='recipientDependencySearch' name='recipientDependencySearch' id='recipientDependencySearch' VALUE='?' onClick="queryRecipientDependency();" DISABLED>
		<INPUT TYPE="hidden" ID="recipientDependancy" name="recipientDependancy" id="recipientDependancy" VALUE="${param.recipientDependancy}">
	</TD>
</TR>
<TR>
	<TD CLASS="LABEL">Contact Type</TD>
	<TD CLASS="FIELDS">
		<SELECT ID="contactType" name="contactType" id="contactType" STYLE="width:150px">
		<c:forEach var="contactType" items="${listValues['contactTypes']}">
			<OPTION VALUE="${contactType.key}" ${contactType.key == param.contactType ? 'SELECTED':''}>${contactType.value}</OPTION>
		</c:forEach>
		</SELECT>
	</TD>
</TR>
<TR>
	<TD CLASS="LABEL">Contact Mode</TD>
	<TD CLASS="FIELDS">
		<SELECT ID="contactMode" name="contactMode" id="contactMode" STYLE="width:150px">
		<c:forEach var="contactMode" items="${listValues['contactModes']}">
			<OPTION VALUE="${contactMode.key}" ${contactMode.key == param.contactMode ? 'SELECTED':''}>${contactMode.value}</OPTION>
		</c:forEach>
		</SELECT>
	</TD>
</TR>
<TR>
	<TD CLASS="LABEL">Language</TD>
	<TD CLASS="FIELDS">
		<SELECT ID="languageID" name="languageID" id="languageID" STYLE="width:150px">
		<c:forEach var="language" items="${listValues['languages']}">
			<OPTION VALUE="${language.key}" ${language.key == param.languageID ? 'SELECTED':''}>${language.value}</OPTION>
		</c:forEach>
		</SELECT>
	</TD>
</TR>
</TABLE>
<TABLE WIDTH="100%" ID="buttonTable">
<TR ALIGN="right">
	<TD>
	<!-- 
		<INPUT CLASS="BUTTON" TYPE="button" ID="FRMT" VALUE="Formats" onClick="filterResults(this)" />
		<INPUT CLASS="BUTTON" TYPE="button" ID="RMND" VALUE="Reminders" onClick="filterResults(this)" />
		<INPUT CLASS="BUTTON" TYPE="button" ID="PREFERRENCES" VALUE="Preferrences" onClick="filterResults(this)" />
	 -->
	 	<INPUT CLASS="BUTTON" TYPE="button" ID="NTFY" VALUE="Subscription" onClick="filterResults(this)" TITLE="Enabled upon selecting RecipientID and Dependency"/>
	 	<INPUT CLASS="BUTTON" TYPE="button" ID="CONT" VALUE="Contacts" onClick="filterResults(this)" />
	 	<INPUT CLASS="BUTTON" TYPE="button" ID="PREFERRENCES" VALUE="Preferences" onClick="filterResults(this)" />
		<INPUT CLASS="BUTTON" TYPE="button" ID="CANCEL" VALUE="Cancel" onClick="window.close()" />
	</TD>
</TR>
</TABLE>
<INPUT TYPE='hidden' name='requestType' id='requestType' ID='requestType' VALUE="CRITERIA_CHANGE">
<INPUT TYPE='hidden' name='criteriaType' id='criteriaType' ID='criteriaType' VALUE="${param.criteriaType}">
<INPUT TYPE='hidden' name='criteriaTypeDesc' id='criteriaTypeDesc' ID='criteriaTypeDesc' VALUE="">
<INPUT TYPE='hidden' name='recipientTypeDesc' id='recipientTypeDesc' ID='recipientTypeDesc' VALUE="">
<INPUT TYPE='hidden' name='contactTypeDesc' id='contactTypeDesc' ID='contactTypeDesc' VALUE="">
<INPUT TYPE='hidden' name='emContactModeDesc' id='emContactModeDesc' ID='emContactModeDesc' VALUE="">
<INPUT TYPE='hidden' name='languageDesc' id='languageDesc' ID='languageDesc' VALUE="">
<INPUT TYPE='hidden' name='contactModeDesc' id='contactModeDesc' ID='contactModeDesc' VALUE="">
<INPUT TYPE='hidden' name='locale' id='locale' ID='locale' VALUE="${LOCALE}">
</FORM>
</BODY>
</HTML>

