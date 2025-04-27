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
<script language="javascript" src="${pageContext.request.contextPath}/eCommon/js/CommonCalendar.js"></script>
<script language="javascript" src="${pageContext.request.contextPath}/eCommon/js/common.js"></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="javascript" src="${pageContext.request.contextPath}/eCommon/js/DateUtils.js"></script>
<script language="javascript" src="${pageContext.request.contextPath}/eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="${pageContext.request.contextPath}/eXH/js/NotificationDisp.js"></script>
<script language="javascript" src="${pageContext.request.contextPath}/eXH/js/NotificationSettings.js"></script>
<SCRIPT LANGUAGE="JAVASCRIPT" SRC='${pageContext.request.contextPath}/eCommon/js/jquery-3.6.3.js'></script>
<SCRIPT LANGUAGE="JAVASCRIPT" SRC='${pageContext.request.contextPath}/eXH/js/InterfaceUtil.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<BODY CLASS="MESSAGE" onMouseDown="CodeArrest()" onKeyDown ='submitFormOnEnter()' onLoad="initNotificationQryCrteria()">
<FORM ID="notificationQueryCriteriaForm" action="./DisplayNotificationServlet">
<c:set var="listValues" value='<%= NotificationBean.searchCriteria((String)session.getAttribute("LOCALE")) %>' />
<TABLE CELLSPACING=0 CELLPADDING=3 WIDTH='100%' ALIGN="CENTER">
	<tr>
		<td></td>
		<td>
		<fieldset style="border-color:black;">
		<legend style="color: black;"><b><fmt:message key="Common.from.label" bundle="${common_labels}"/></b></legend>
			<table cellspacing=0 cellpadding=3 width='100%' align=center>
			<tr>
				<td width='28%'></td>
				<td width='72%'></td>
			</tr>
			
			<tr>
				<td class=label><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
				<td class='fields'>
					<input type=text name="fromMsgDate" id="fromMsgDate" label="From Date" value='${requestScope.notificationCriteriaBean.fromMsgDate}' size=11 onBlur="fromToDateVal(this,toMsgDate,'DMY',this);">
					<input type='image' src='${pageContext.request.contextPath}/eCommon/images/CommonCalendar.gif' onClick="return showCalendar('fromMsgDate','dd/mm/y','','','${pageContext.request.contextPath}');">
				</td>
			</tr>
			<tr>
				<td class=label ><fmt:message key="eXH.MessageID.Label" bundle="${xh_labels}"/></td>
				<td class='fields'>
					<input type=text name="fromMsgID" id="fromMsgID" value='${requestScope.notificationCriteriaBean.fromMsgID}' size=25 maxlength="20" onKeyPress='return(CheckForSpecChars(event));return(ChkNumberInput(this,event,0))'>
				</td>
			</tr>
			</table>	
		</fieldset>
		</td>
		<td></td>
		<td>
		<fieldset style=" border-color:black;"><legend style="color: black;"><b><fmt:message key="Common.to.label" bundle="${common_labels}"/></b></legend>		
			<table cellspacing=0 cellpadding=3 width='100%' align=center>

				<tr>
				<td width='28%'></td> 
				<td width='72%'></td> 
				</tr>
				
				<tr>
				<td class=label><fmt:message key="Common.date.label" bundle="${common_labels}"/></td>
				<td class='fields'>
					<input type=text name="toMsgDate" id="toMsgDate" label="To Date" value='${requestScope.notificationCriteriaBean.toMsgDate}' size=11 onBlur="fromToDateVal(fromMsgDate,toMsgDate,'DMY',this);">
					<input type='image' src='${pageContext.request.contextPath}/eCommon/images/CommonCalendar.gif' onClick="return showCalendar('toMsgDate','dd/mm/y');">
				</td>				
				</tr>

				<tr>
				<td class=label><fmt:message key="eXH.MessageID.Label" bundle="${xh_labels}"/></td>
				<td class='fields'>
				<input type=text name=toMsgID id=toMsgID value='<c:out value="${requestScope.notificationCriteriaBean.toMsgID}" />' size=25 maxlength="20" onKeyPress='return(CheckForSpecChars(event));return(ChkNumberInput(this,event,0))'>
				</td>
				</tr>
			</table>	
	    </fieldset>
		</td>
		<td></td>
	</tr>
</TABLE>
<table width='100%' cellspacing=0 cellpadding=3 align=center>
<TR>
	<TD CLASS="LABEL">Contact</TD>
	<TD CLASS="FIELDS">
		<INPUT TYPE="text" ID="toCommID" name="toCommID" id="toCommID" VALUE="${requestScope.notificationCriteriaBean.toCommID}">
	</TD>
	<TD CLASS="LABEL">Message Status</TD>
	<TD CLASS="FIELDS">
		<SELECT ID="msgStatus" name="msgStatus" id="msgStatus" STYLE="width:150px">
		<c:forEach var="msgStatus" items="${listValues['msgStatus']}">
			<OPTION VALUE="${msgStatus.key}" ${msgStatus.key == requestScope.notificationCriteriaBean.msgStatus ? 'SELECTED':''}>${msgStatus.value}</OPTION>
		</c:forEach>
		</SELECT>
	</TD>
	<TD CLASS="LABEL">Facility</TD>
	<TD CLASS="FIELDS">
		<SELECT ID="facilityID" name="facilityID" id="facilityID" STYLE="width:150px">
		<c:forEach var="facility" items="${listValues['facilities']}">
			<OPTION VALUE="${facility.key}" ${facility.key == requestScope.notificationCriteriaBean.facilityID ? 'SELECTED':''}>${facility.value}</OPTION>
		</c:forEach>
		</SELECT>
	</TD>
</TR>
	<TR>
		<TD CLASS="LABEL">Message Type</TD>
		<TD CLASS="FIELDS">
			<INPUT TYPE="text" ID="messageTypeDesc" name="messageTypeDesc" id="messageTypeDesc" VALUE="${requestScope.notificationCriteriaBean.messageTypeDesc}" onBlur="if(this.value != '') queryMessageType();else messageType.value = ''">
			<INPUT CLASS="BUTTON" TYPE="button"  name='messageTypeSearch' id='messageTypeSearch' ID="messageTypeSearch" VALUE='?' onClick="queryMessageType()">
			<INPUT TYPE="hidden" name="messageType" id="messageType" ID="messageType" VALUE="${requestScope.notificationCriteriaBean.messageType}">
		</TD>
		<TD CLASS="LABEL">Event Type</TD>
		<TD CLASS="FIELDS">
			<INPUT TYPE="text" ID="eventTypeDesc" name="eventTypeDesc" id="eventTypeDesc" VALUE="${requestScope.notificationCriteriaBean.eventTypeDesc}" onBlur="if(this.value != '') queryEventType();else eventType.value = ''">
			<INPUT CLASS="BUTTON" TYPE="button"  name='eventTypeSearch' id='eventTypeSearch' ID="eventTypeSearch" VALUE='?' onClick="queryEventType()">
			<INPUT TYPE="hidden" name="eventType" id="eventType" ID="eventType" VALUE="${requestScope.notificationCriteriaBean.eventType}">
		</TD>
		<TD CLASS="LABEL">Recipient Type</TD>
		<TD CLASS='FIELDS'>
			<SELECT ID="recipientType" name="recipientType" id="recipientType" onChange="recipientTypeChange()" STYLE="width:150px">
			<c:forEach var="recipientType" items="${listValues['recipientTypes']}">
				<OPTION VALUE="${recipientType.key}" ${recipientType.key == requestScope.notificationCriteriaBean.recipientType ? 'SELECTED':''}>${recipientType.value}</OPTION>
			</c:forEach>
			</SELECT>
		</TD>
	</TR>
	<TR>
	<TD CLASS="LABEL">Recipient ID</TD>
		<TD CLASS="FIELDS">
			<INPUT TYPE="text" ID="recipientName" name="recipientName" id="recipientName" VALUE="${requestScope.notificationCriteriaBean.recipientName}" onBlur="if(this.value!='') queryRecipientID();else recipientID.value = ''" DISABLED>
			<INPUT CLASS="BUTTON" TYPE="button"  name='recipientSearch' id='recipientSearch' ID="recipientSearch" VALUE='?' onClick="queryRecipientID()" DISABLED>
			<INPUT TYPE="hidden" name="recipientID" id="recipientID" ID="recipientID" VALUE="${requestScope.notificationCriteriaBean.recipientID}">
	</TD>
	<TD CLASS="LABEL">Contact Type</TD>
	<TD CLASS="FIELDS">
		<SELECT ID="contactType" name="contactType" id="contactType" STYLE="width:150px">
		<c:forEach var="contactType" items="${listValues['contactTypes']}">
			<OPTION VALUE="${contactType.key}" ${contactType.key == requestScope.notificationCriteriaBean.contactType ? 'SELECTED':''}>${contactType.value}</OPTION>
		</c:forEach>
		</SELECT>
	</TD>
	<TD CLASS="LABEL">Contact Mode</TD>
	<TD CLASS="FIELDS">
		<SELECT ID="contactMode" name="contactMode" id="contactMode" STYLE="width:150px">
		<c:forEach var="contactMode" items="${listValues['contactModes']}">
			<OPTION VALUE="${contactMode.key}" ${contactMode.key == requestScope.notificationCriteriaBean.contactMode ? 'SELECTED':''}>${contactMode.value}</OPTION>
		</c:forEach>
		</SELECT>
	</TD>
</TR>
<TR>
	<TD CLASS="LABEL">Language</TD>
	<TD CLASS="FIELDS">
		<SELECT ID="languageID" name="languageID" id="languageID" STYLE="width:150px">
		<c:forEach var="language" items="${listValues['languages']}">
			<OPTION VALUE="${language.key}" ${language.key == requestScope.notificationCriteriaBean.languageID ? 'SELECTED':''}>${language.value}</OPTION>
		</c:forEach>
		</SELECT>
	</TD>
	<TD CLASS="LABEL">Notification Queue Type</TD>
	<TD CLASS="FIELDS">
		<SELECT ID="notificationType" name="notificationType" id="notificationType" STYLE="width:150px">
		<c:forEach var="notificationType" items="${listValues['notificationTypes']}">
			<OPTION VALUE="${notificationType.key}" ${notificationType.key == requestScope.notificationCriteriaBean.notificationType ? 'SELECTED':''}>${notificationType.value}</OPTION>
		</c:forEach>
		</SELECT>
	</TD>
</TR>
</table>
<table cellspacing=0 cellpadding=3 width='100%' align=center>
	<tr align="right">
		<td colspan=4 class='BUTTON'>
			<input class='button' type="button" ID="search" name=search value='Search' onClick="submitForm(this)">
			<input class='button' type="button" ID="excel" name=excel value='Export To Excel' onClick="submitForm(this)">
		</td>
	</tr>
	<TR><td>&nbsp;</td></TR><td>&nbsp;</td><TR><td>&nbsp;</td></TR><TR><td>&nbsp;</td></TR><TR><td>&nbsp;</td></TR><TR><td>&nbsp;</td></TR><TR><td>&nbsp;</td></TR><TR><td>&nbsp;</td></TR><TR><td>&nbsp;</td></TR>
	<TR><td>&nbsp;</td></TR><td>&nbsp;</td><TR><td>&nbsp;</td></TR><TR><td>&nbsp;</td></TR><TR><td>&nbsp;</td></TR>
	<TR><td>&nbsp;</td></TR><td>&nbsp;</td><TR><td>&nbsp;</td></TR><TR><td>&nbsp;</td></TR><TR><td>&nbsp;</td></TR>
</table>
<INPUT TYPE="hidden" name="outputType" id="outputType" ID="outputType">
</form>
</BODY>															  
</html>

