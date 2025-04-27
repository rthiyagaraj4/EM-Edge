<!DOCTYPE html>
<%@ include file="../../eXH/jsp/CommonIncludeSession.jsp" %>
<%@ page import = "eXH.*" %> 
<script>
var contextPath = "<%=request.getContextPath()%>";
</script>
<style type="text/css">
#dataFilterDiv {
   position:fixed;
    top: 20%;
    left: 30%;
    
}
#templateDiv {
   position:fixed;
    top: 20%;
    left: 20%;
}
#reminderDiv {
   position:fixed;
    top: 20%;
    left: 20%;
}

#buttonTable {
   position:fixed;
    top: 80%;
    left: 70%;
}
</style>

<SCRIPT LANGUAGE="javascript">
var contextPath = "<%=request.getContextPath()%>";
function openTemplate(templateFolder, fileName, key)
{
	if(fileName == 'null' || fileName == '')
	{
		fileName = key + ".doc";
		createDoc(templateFolder + fileName);
	}
	else
	{
		openDoc(templateFolder + fileName);
	}
	document.getElementById("templateID").value = fileName;
}
</SCRIPT>

<SCRIPT LANGUAGE="VBScript">
Function openDoc(filename)
	Set fso = CreateObject("Scripting.FileSystemObject")
	If (fso.FileExists(filename)) Then
		Set objWord = CreateObject("Word.Application")
		objWord.Visible = true
		objWord.Documents.Open filename
	Else
		createDoc(filename)
	End If
End Function
Function createDoc(filename)
	Set objWord = CreateObject("Word.Application")
	objWord.Caption = "Test Caption"
	objWord.Visible = True
	Set objDoc = objWord.Documents.Add()
	Set objSelection = objWord.Selection
	objDoc.SaveAs(filename)
End Function
</SCRIPT>

<SCRIPT TYPE="text/javascript" SRC="${pageContext.request.contextPath}/eXH/js/NotificationSettings.js"></SCRIPT>
<SCRIPT TYPE="text/javascript" SRC='${pageContext.request.contextPath}/eCommon/js/common.js'> </Script>
<SCRIPT TYPE="text/javascript" SRC='${pageContext.request.contextPath}/eCommon/js/CommonCalendar.js'> </Script>

<TITLE>Notification Settings</TITLE>

<BODY onMouseDown="CodeArrest()" onKeyDown ='lockKey()' onLoad="scheduleEventInit('${param.everyQtyYN}','${param.everyWeekDayYN}')">
<FORM ID="notificationSettings" name="notificationSettings" id="notificationSettings" METHOD="post" ACTION='${pageContext.request.contextPath}/servlet/eXH.NotificationSettingsServlet'>

<c:set var="pageContextPath" value="${pageContext.request.contextPath}"/>
<c:set var="locale" value="${LOCALE}" />
<c:set var="reminderServiceTypes" value='<%= NotificationBean.getReminderServiceTypes((String)pageContext.getAttribute("locale")) %>' />
<c:set var="dynamicFields" value='<%= NotificationBean.getDynamicFields(request, (String)pageContext.getAttribute("locale")) %>' />

<TABLE ID="reminderDiv">
<TR> 
	<TD CLASS="LABEL" COLSPAN="5">
	Start
		<INPUT TYPE="radio" name="startType" id="startType" ID="startType" onClick="startTypeChange('I')" CHECKED VALUE="I">Immediately
		<INPUT TYPE="radio" name="startType" id="startType" ID="startType" onClick="startTypeChange('A')" VALUE="A"> At 
		<INPUT TYPE="text" name="startAt" id="startAt" ID="startAt" VALUE="${param.startAt}" SIZE="11" DISABLED>
		<INPUT TYPE='image' ID="startAtCalendar" SRC='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('startAt','dd/mm/y hh:mm');" DISABLED>
	</TD>
</TR>
<TR ID="noRepeatTR">
	<TD CLASS="fields"><INPUT TYPE="radio" name="repeatType" id="repeatType" ID="repeatTypeD" onClick="repeatTypeChange('D')" VALUE="D" CHECKED></TD>
	<TD COLSPAN="4" CLASS="LABEL">Do not repeat</TD>
</TR>
<TR ID="beforeTR">
	<TD CLASS="fields"><INPUT TYPE="radio" name="repeatType" id="repeatType" ID="repeatTypeB" onClick="repeatTypeChange('B')" VALUE="B"></TD>
	<TD CLASS="LABEL">Every</TD>
	<TD class='fields'>
		<INPUT TYPE="text" name="everyQtyNo" id="everyQtyNo" ID="everyQtyNo" VALUE="${param.everyQtyNo}">
	&nbsp;
		<SELECT name="everyQtyUnit" id="everyQtyUnit" ID="everyQtyUnit">
		<c:forEach var="unit" items="minute(s),hour(s),day(s),week(s),month(s)">
			<OPTION VALUE="${unit}" ${unit == param.everyQtyUnit ? 'selected' : ''}>${unit}</OPTION>
		</c:forEach>
		</SELECT>
	</TD>
	<TD>
		<INPUT TYPE="text" name="scheduledTime" id="scheduledTime" ID="scheduledTime" SIZE="11" VALUE="${param.scheduledTime}">
		<INPUT TYPE='image' ID="scheduledTimeCalendar" SRC='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('scheduledTime','hh:mm');">
	</TD>
</TR>
<TR ID="everyWeekDayNoTR">
	<TD CLASS="fields"><INPUT TYPE="radio" name="repeatType" id="repeatType" ID="repeatTypeW" onClick="repeatTypeChange('W')" VALUE="W"></TD>
	<TD CLASS="LABEL">Week</TD>
	<TD CLASS="fields">
		<SELECT name="everyWeekDayNo" id="everyWeekDayNo" ID="everyWeekDayNo">
			<OPTION VALUE="1" ${1 == param.everyWeekDayNo ? 'selected' : ''}>First</OPTION>
			<OPTION VALUE="2" ${2 == param.everyWeekDayNo ? 'selected' : ''}>Second</OPTION>
			<OPTION VALUE="3" ${3 == param.everyWeekDayNo ? 'selected' : ''}>Third</OPTION>
			<OPTION VALUE="4" ${4 == param.everyWeekDayNo ? 'selected' : ''}>Fourth</OPTION>
			<OPTION VALUE="5" ${5 == param.everyWeekDayNo ? 'selected' : ''}>Fifth</OPTION>
		</SELECT>
	&nbsp;
		<SELECT name="weekDay" id="weekDay" ID="weekDay">
			<OPTION VALUE="1" ${1 == param.everyWeekWeekDay ? 'selected' : ''}>Monday</OPTION>
			<OPTION VALUE="2" ${2 == param.everyWeekWeekDay ? 'selected' : ''}>Tuesday</OPTION>
			<OPTION VALUE="3" ${3 == param.everyWeekWeekDay ? 'selected' : ''}>Wednesday</OPTION>
			<OPTION VALUE="4" ${4 == param.everyWeekWeekDay ? 'selected' : ''}>Thursday</OPTION>
			<OPTION VALUE="5" ${5 == param.everyWeekWeekDay ? 'selected' : ''}>Friday</OPTION>
			<OPTION VALUE="6" ${6 == param.everyWeekWeekDay ? 'selected' : ''}>Saturday</OPTION>
			<OPTION VALUE="7" ${7 == param.everyWeekWeekDay ? 'selected' : ''}>Sunday</OPTION>
		</SELECT>
	</TD>
	<TD CLASS="LABEL">&nbsp;of each month</TD>
</TR>
<TR ID="lastTR">
	<TD CLASS="fields"><INPUT TYPE="radio" name="repeatType" id="repeatType" ID="repeatTypeL" onClick="repeatTypeChange('L')" VALUE="L"></TD>
	<TD CLASS="LABEL">Last</TD>
	<TD>
		<SELECT name="lastWeekDay" id="lastWeekDay" ID="lastWeekDay">
			<OPTION VALUE="1" ${1 == param.everyWeekWeekDay ? 'selected' : ''}>Monday</OPTION>
			<OPTION VALUE="2" ${2 == param.everyWeekWeekDay ? 'selected' : ''}>Tuesday</OPTION>
			<OPTION VALUE="3" ${3 == param.everyWeekWeekDay ? 'selected' : ''}>Wednesday</OPTION>
			<OPTION VALUE="4" ${4 == param.everyWeekWeekDay ? 'selected' : ''}>Thursday</OPTION>
			<OPTION VALUE="5" ${5 == param.everyWeekWeekDay ? 'selected' : ''}>Friday</OPTION>
			<OPTION VALUE="6" ${6 == param.everyWeekWeekDay ? 'selected' : ''}>Saturday</OPTION>
			<OPTION VALUE="7" ${7 == param.everyWeekWeekDay ? 'selected' : ''}>Sunday</OPTION>
		</SELECT>
	</TD>
	<TD></TD>
	<TD></TD>
</TR>
<TR ID="retryTR">
	<TD CLASS="fields"><INPUT TYPE="checkbox" name="retryEnabled" id="retryEnabled" ID="retryEnabled" VALUE="E"></TD>
	<TD CLASS="LABEL">Retry up to</TD>
	<TD CLASS="fields">
		<SELECT name="retryNo" id="retryNo" ID="retryNo">
		<c:forEach var="num" items="1,2,3,4,5,6,7,8,9,10">
			<OPTION VALUE="${num}" ${num == param.retryNo ? 'selected' : ''}>${num}</OPTION>
		</c:forEach>
		</SELECT>
		time(s)
	
		<SELECT name="retryQty" id="retryQty" ID="retryQty">
		<c:forEach var="num" items="1,2,3,4,5,6,7,8,9,10">
			<OPTION VALUE="${num}" ${num == param.retryQty ? 'selected' : ''}>${num}</OPTION>
		</c:forEach>
		</SELECT>
	
		<SELECT name="retryTimeUnit" id="retryTimeUnit" ID="retryTimeUnit">
		<c:forEach var="units" items="minute(s),hour(s),day(s),week(s),month(s)">
			<OPTION VALUE="minute" ${'minute' == param.retryQtyUnit ? 'selected' : ''}>minute(s)</OPTION>
			<OPTION VALUE="hour" ${'hour' == param.retryQtyUnit ? 'selected' : ''}>hour(s)</OPTION>
			<OPTION VALUE="day" ${'day' == param.retryQtyUnit ? 'selected' : ''}>day(s)</OPTION>
			<OPTION VALUE="week" ${'week' == param.retryQtyUnit ? 'selected' : ''}>week(s)</OPTION>
			<OPTION VALUE="month" ${'month' == param.retryQtyUnit ? 'selected' : ''}>month(s)</OPTION>
		</c:forEach>
		</SELECT>
	</TD>
</TR>
<TR>
	<TD CLASS="LABEL" COLSPAN="2">Reminder to be Submitted as</TD>
	<TD CLASS="fields" COLSPAN="1">
		<SELECT ID="reminderServiceType" name="reminderServiceType" id="reminderServiceType" STYLE="width:150px">
		<c:forEach var="tempReminderServiceType" items="${reminderServiceTypes}">
			<OPTION VALUE="${tempReminderServiceType.key}" ${tempReminderServiceType.key == param.reminderServiceType ? 'SELECTED':''}>${tempReminderServiceType.value}</OPTION>
		</c:forEach>
		</SELECT>
	</TD>
</TR>
<TR>
	<TD COLSPAN="5" ALIGN="right" CLASS="fields">
<!-- 	<INPUT CLASS="BUTTON" TYPE="button" VALUE="Ok" onClick="eventSchedule()" />
		<INPUT CLASS="BUTTON" TYPE="button" VALUE="Cancel" onClick="window.close()" />
 -->	<INPUT CLASS="BUTTON" TYPE="button" VALUE="Next" onClick="navigateSettings('reminderDiv','dataFilterDiv')" />
 </TD>
</TR>
</TABLE>
<TABLE ID="dataFilterDiv" STYLE="display: none;">
<TR>
	<TD CLASS="LABEL">Data Filter</TD>
	<TD CLASS="fields"><INPUT TYPE="text" name="dataFilter" id="dataFilter" ID="dataFilter" VALUE="${param.dataFilter}"></TD>
</TR>
<c:forEach var="field" items="${dynamicFields}">
<TR>
	<TD CLASS="LABEL">${field['PARAMLABEL']}</TD>
	<TD CLASS="fields">
<c:if test="${field['PARAMDATATYPE'] == 'CHAR'}">
	<INPUT TYPE="text" name="${field['PARAMID']}" id="${field['PARAMID']}" ID="${field['PARAMID']}" VALUE="${field['PARAMCURRENTVALUE']}">
</c:if>
<c:if test="${field['PARAMDATATYPE'] == 'DATE'}">
	<INPUT TYPE="text" name="${field['PARAMID']}" id="${field['PARAMID']}" ID="${field['PARAMID']}" VALUE="${field['PARAMCURRENTVALUE']}" SIZE="11">
	<INPUT TYPE='image' ID="${field['PARAMID']}Calendar" SRC='${pageContextPath}/eCommon/images/CommonCalendar.gif' onClick="return showCalendar('${field['PARAMID']}','dd/mm/y hh:mm');">
</c:if>
<c:if test="${field['PARAMDATATYPE'] == 'LIST'}">
	<SELECT name="${field['PARAMID']}" id="${field['PARAMID']}" ID="${field['PARAMID']}">
	<c:forEach var="item" items="${field['LISTITEMS']}">
		<OPTION VALUE="${item.key}" ${item.key == field['PARAMCURRENTVALUE'] ? 'SELECTED' : ''}>${item.key}</OPTION>
	</c:forEach>
	</SELECT>
</c:if>
	</TD>
</TR>
</c:forEach>
<TR>
	<TD COLSPAN="2" CLASS="fields" ALIGN="right">
		<INPUT CLASS="BUTTON" TYPE="button" VALUE="Previous" onClick="navigateSettings('dataFilterDiv','reminderDiv')" />
		<INPUT CLASS="BUTTON" TYPE="button" VALUE="Next" onClick="navigateSettings('dataFilterDiv','templateDiv')" />
	</TD>
</TR>
</TABLE>
<c:if test="${param.contactMode == 'Mobile'}">
<TABLE ID="templateDiv" STYLE="display: none;">
<TR>
	<TD CLASS="LABEL">Template</TD>
	<TD CLASS="fields"><INPUT TYPE="text" name="templateID" id="templateID" ID="templateID" VALUE="${param.templateID}"></TD>
	<TD><INPUT CLASS="BUTTON" TYPE="button" VALUE="Edit" onClick="openTemplate('${param.templateFolder}','${param.fileName}','${param.key}')" /></TD>
</TR>
<TR>
	<TD COLSPAN="2" CLASS="fields" ALIGN="right">
		<INPUT CLASS="BUTTON" TYPE="button" VALUE="Previous" onClick="navigateSettings('templateDiv','dataFilterDiv')" />
	</TD>
</TR>
<TR>
	<TD COLSPAN="2" CLASS="fields" ALIGN="right">
		<INPUT CLASS="BUTTON" TYPE="button" VALUE="Previous" onClick="navigateSettings('templateDiv','dataFilterDiv')" />
		<INPUT CLASS="BUTTON" TYPE="button" VALUE="Save" onClick="saveSettings()" />
	</TD>
</TR>
</TABLE>
</c:if>
<c:if test="${param.contactMode == 'Mail'}">
<TABLE ID="templateDiv" STYLE="display: none;">
<TR>
	<TD CLASS="LABEL">Subject Format</TD>
	<TD CLASS="fields"><INPUT TYPE="text" name="mailSubject" id="mailSubject" ID="mailSubject" VALUE="${param.mailSubject}"></TD>
</TR>
<TR>
	<TD CLASS="LABEL">Mail Format</TD>
	<TD CLASS="fields"><INPUT TYPE="text" name="templateID" id="templateID" ID="templateID" VALUE="${param.templateID}"></TD>
	<TD><INPUT CLASS="BUTTON" TYPE="button" VALUE="Edit" onClick="openTemplate('${param.templateFolder}','${param.fileName}','${param.key}')" /></TD>
</TR>
<TR>
	<TD CLASS="LABEL">Mail Attachment Format</TD>
	<TD CLASS="fields"><INPUT TYPE="text" name="attachmentTemplateID" id="attachmentTemplateID" ID="attachmentTemplateID" VALUE="${param.attachmentTemplateID}"></TD>
	<TD><INPUT CLASS="BUTTON" TYPE="button" VALUE="Edit" onClick="openTemplate('${param.templateFolder}','${param.attachemntTemplateID}','${param.key} + ATTACHMENT')" /></TD>
</TR>
<TR>
	<TD CLASS="LABEL">Mail To</TD>
	<TD CLASS="field">
		<SELECT name="toRecipientType" id="toRecipientType" ID="toRecipientType" STYLE="width:150px">
			<OPTION VALUE="">Select</OPTION>
			<OPTION VALUE="PAT">Patient</OPTION>
			<OPTION VALUE="PRA">Practitioner</OPTION>
			<OPTION VALUE="KIN">Next of Kin</OPTION>
		</SELECT>
	</TD>
	<TD CLASS="fields"><INPUT TYPE="text" name="toMailID" id="toMailID" ID="toMailID" VALUE="${param.toMailID}" TITLE="Mail ID to which this notification will be sent always"></TD>
</TR>
<TR>
	<TD CLASS="LABEL">Mail CC</TD>
	<TD CLASS="field">
		<SELECT name="ccRecipientType" id="ccRecipientType" ID="ccRecipientType" STYLE="width:150px">
			<OPTION VALUE="">Select</OPTION>
			<OPTION VALUE="PAT">Patient</OPTION>
			<OPTION VALUE="PRA">Practitioner</OPTION>
			<OPTION VALUE="KIN">Next of Kin</OPTION>
		</SELECT>
	</TD>
	<TD CLASS="fields"><INPUT TYPE="text" name="ccMailID" id="ccMailID" ID="ccMailID" VALUE="${param.ccMailID}" TITLE="Mail ID to which this notification will be sent always"></TD>
</TR>
<TR>
	<TD CLASS="LABEL">Mail BCC</TD>
	<TD CLASS="field">
		<SELECT name="bccRecipientType" id="bccRecipientType" ID="bccRecipientType" STYLE="width:150px">
			<OPTION VALUE="">Select</OPTION>
			<OPTION VALUE="PAT">Patient</OPTION>
			<OPTION VALUE="PRA">Practitioner</OPTION>
			<OPTION VALUE="KIN">Next of Kin</OPTION>
		</SELECT>
	</TD>
	<TD CLASS="fields"><INPUT TYPE="text" name="bccMailID" id="bccMailID" ID="bccMailID" VALUE="${param.bccMailID}" TITLE="Mail ID to which this notification will be sent always"></TD>
</TR>
<TR>
	<TD COLSPAN="3" CLASS="fields" ALIGN="right">
		<INPUT CLASS="BUTTON" TYPE="button" VALUE="Previous" onClick="navigateSettings('templateDiv','dataFilterDiv')" />
		<INPUT CLASS="BUTTON" TYPE="button" VALUE="Save" onClick="saveSettings()" />
	</TD>
</TR>
</TABLE>
</c:if>

<TABLE ID="buttonTable" ALIGN="right">
<TR>
	<TD CLASS="fields" STYLE="display: none;" ID="previousButton"><INPUT CLASS="BUTTON" TYPE="button" VALUE="Previous" onClick="navigatePage(this)"></TD>
	<TD CLASS="fields" ID="nextButton"><INPUT CLASS="BUTTON" TYPE="button" VALUE="Next" onClick="navigatePage(this)"></TD>
	<TD CLASS="fields" STYLE="display: none;" ID="saveButton"><INPUT CLASS="BUTTON" TYPE="button" VALUE="Save" onClick="saveSettings()"></TD>
</TR>
</TABLE>

<INPUT TYPE="hidden" name="recipientType" id="recipientType" VALUE="${param.recipientType}">
<INPUT TYPE="hidden" name="recipientDependancy" id="recipientDependancy" VALUE="${param.recipientDependancy}">
<INPUT TYPE="hidden" name="contactType" id="contactType" VALUE="${param.contactType}">
<INPUT TYPE="hidden" name="contactMode" id="contactMode" VALUE="${param.contactMode}">
<INPUT TYPE="hidden" name="eventType" id="eventType" VALUE="${param.eventType}">
<INPUT TYPE="hidden" name="emContactMode" id="emContactMode" VALUE="${param.emContactMode}">
<INPUT TYPE="hidden" name="languageID" id="languageID" VALUE="${param.languageID}">
<INPUT TYPE="hidden" name="requestType" id="requestType" ID="requestType" VALUE="SAVE_SETTINGS">
<INPUT TYPE="hidden" name="everyQtyYN" id="everyQtyYN" ID="everyQtyYN">
<INPUT TYPE="hidden" name="recipientID" id="recipientID" ID="recipientID" VALUE="${param.recipientID}">
<INPUT TYPE="hidden" name="everyWeekDayYN" id="everyWeekDayYN" ID="everyWeekDayYN">
<INPUT TYPE="hidden" name="reportServiceCmd" id="reportServiceCmd" ID="reportServiceCmd">
<INPUT TYPE="hidden" ID="pageNo" VALUE="1">

</FORM>
</BODY>
</HTML>

