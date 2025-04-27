<!DOCTYPE html>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import = "eXH.*, eCommon.XSSRequestWrapper, webbeans.eCommon.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>


<HTML>
<HEAD>
<TITLE>Recipient Notification Settings</TITLE>
<script>
var contextPath = "<%=request.getContextPath()%>";
</script>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>

<style type="text/css">
#INT_HEADER {
	position:fixed;
    top: 10%;
    left: 5%;
    background:#fde6d0;
	color:black;
	font-size:15;
}
#mydiv {
    position:fixed;
    top: 50%;
    left: 50%;
    margin-top: -9em; /*set to a negative number 1/2 of your height*/
    margin-left: -15em; /*set to a negative number 1/2 of your width*/
}
div.centered 
{
    text-align: center;
}
div.centered table 
{
    margin: 0 auto; 
    text-align: left;
}

#dataFilterDiv {
    position:fixed;
    top: 50%;
    left: 50%;
    margin-top: -7em; /*set to a negative number 1/2 of your height*/
    margin-left: -15em; /*set to a negative number 1/2 of your width*/
}
#dataConditionFilterDiv {
    position:fixed;
    top: 50%;
    left: 40%;
    margin-top: -9em; /*set to a negative number 1/2 of your height*/
    margin-left: -15em; /*set to a negative number 1/2 of your width*/
}
#templateDiv {
    position:fixed;
    top: 50%;
    left: 30%;
    margin-top: -9em; /*set to a negative number 1/2 of your height*/
    margin-left: -15em; /*set to a negative number 1/2 of your width*/
}
#mobileTemplateDiv {
    position:fixed;
    top: 50%;
    left: 30%;
    margin-top: -2em; /*set to a negative number 1/2 of your height*/
    margin-left: -2em; /*set to a negative number 1/2 of your width*/
}
#mailTemplateDiv {
    position:fixed;
    top: 50%;
    left: 30%;
    margin-top: -8em; /*set to a negative number 1/2 of your height*/
    margin-left: -8em; /*set to a negative number 1/2 of your width*/
}
#reminderDiv {
   position:fixed;
    top: 50%;
    left: 30%;
    margin-top: -9em; /*set to a negative number 1/2 of your height*/
    margin-left: -15em; /*set to a negative number 1/2 of your width*/
}

#buttonTable {
   position:fixed;
    top: 80%;
    left: 70%;
}
#tabTable {
   position:fixed;
    top: 20%;
    left: 40%;
}
#hdrStrID {
   position:fixed;
    top: 10%;
    left: 5%;
}
</style>

<SCRIPT LANGUAGE="javascript">
var contextPath = "<%=request.getContextPath()%>";
function openTemplate(templateFolder, fileName, key, obj)
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
	document.getElementById(obj.id).value = fileName;
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

<SCRIPT LANGUAGE="JAVASCRIPT" SRC="${pageContext.request.contextPath}/eXH/js/NotificationSettings.js"></SCRIPT>
<SCRIPT LANGUAGE="JAVASCRIPT" SRC='${pageContext.request.contextPath}/eCommon/js/common.js'> </Script>
<SCRIPT LANGUAGE="JAVASCRIPT" SRC='${pageContext.request.contextPath}/eCommon/js/CommonCalendar.js'> </Script>
<SCRIPT LANGUAGE="JAVASCRIPT" SRC='${pageContext.request.contextPath}/eCommon/js/common.js'> </Script>
<SCRIPT LANGUAGE="JAVASCRIPT" SRC="${pageContext.request.contextPath}/eCommon/js/ValidateControl.js"></script>
<SCRIPT LANGUAGE="JAVASCRIPT" SRC='${pageContext.request.contextPath}/eCommon/js/jquery-3.6.3.js'></script>
<SCRIPT LANGUAGE="JAVASCRIPT" SRC='${pageContext.request.contextPath}/eXH/js/Validate.js'></script>
<SCRIPT LANGUAGE="JAVASCRIPT" SRC="${pageContext.request.contextPath}/eCommon/js/CommonLookup.js"></Script>
<SCRIPT LANGUAGE="JAVASCRIPT" SRC="${pageContext.request.contextPath}/eXH/js/InterfaceUtil.js"></Script>
<SCRIPT LANGUAGE="JAVASCRIPT" SRC="${pageContext.request.contextPath}/eCommon/js/DateUtils.js"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<BODY onMouseDown="CodeArrest()" onKeyDown ='lockKey()' onLoad="scheduleEventInit('${param.everyQtyYN}','${param.everyWeekDayYN}','${param.lastDayYN}')">
<FORM ID="notificationSettings" name="notificationSettings" id="notificationSettings" METHOD="post" ACTION='${pageContext.request.contextPath}/servlet/eXH.NotificationSettingsServlet'>

<c:set var="pageContextPath" value="${pageContext.request.contextPath}"/>
<c:set var="locale" value="${LOCALE}" />
<c:set var="reminderServiceTypes" value='<%= NotificationBean.getReminderServiceTypes((String)pageContext.getAttribute("locale")) %>' />
<c:set var="dynamicFields" value='<%= NotificationBean.getDynamicFields(request, (String)pageContext.getAttribute("locale")) %>' />
<c:set var="reminderQtyUnits" value='<%= NotificationBean.reminderQtyUnitLists() %>' />
<c:set var="dataFilterLength" value="${fn:length(dynamicFields[0])}"/>
<c:if test="${dataFilterLength > 7}">
	<c:set var="dataFilterScroll" value="overflow-y:auto; height: 200px;"/>
</c:if>

<TABLE ID="tabTable" ALIGN="right">
<TR><TD ID="hdrStrID">Reminder Setting</TD></TR>
<TR>
	<TD CLASS="fields">
		<A HREF="#" onClick="navigatePageDisp('1')"> 1 </A>
		<A HREF="#" onClick="navigatePageDisp('2')"> 2 </A>
	<c:if test="${not empty dynamicFields[1]}">
		<A HREF="#" onClick="navigatePageDisp('3')"> 3 </A>
		<A HREF="#" onClick="navigatePageDisp('4')"> 4 </A>
	</c:if>
	<c:if test="${empty dynamicFields[1]}">
		<c:set var="ignorePage3" value="TRUE"/>
		<A HREF="#" onClick="navigatePageDisp('4')"> 3 </A>
	</c:if>
	</TD>
</TR>
</TABLE>

<TABLE ID="reminderDiv" CELLSPACING="0" CELLPADDING="3" BORDER="0">
<TR> 
	<TD CLASS="LABEL" COLSPAN="5">
	Start
		<INPUT TYPE="radio" name="startType" id="startType" ID="startType" onClick="startTypeChange('I')" CHECKED VALUE="I">Immediately
		<INPUT TYPE="radio" name="startType" id="startType" ID="startType" onClick="startTypeChange('A')" ${param.scheduledTime == '' ? '':'CHECKED'} VALUE="A"> At 
		<INPUT TYPE="text" name="scheduledTime" id="scheduledTime" ID="scheduledTime" VALUE="${param.scheduledTime}" SIZE="11" ${param.scheduledTime == NULL ? 'DISABLED':''} onBlur="xhIsBeforeNow(scheduledTime,'DMYHM');">
		<INPUT TYPE='image' ID="scheduledTimeCalendar" SRC='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('scheduledTime','dd/mm/y hh:mm');" ${param.scheduledTime == NULL ? 'DISABLED':''}>
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
		<c:forEach var="everyQtyUnitTemp" items="${reminderQtyUnits['everyQtyUnits']}">
			<OPTION VALUE="${everyQtyUnitTemp.key}" ${everyQtyUnitTemp.key == param.everyQtyUnit ? 'SELECTED':''}>${everyQtyUnitTemp.value}</OPTION>
		</c:forEach>
		</SELECT>
	</TD>
</TR>
<TR ID="everyWeekDayNoTR">
	<TD CLASS="fields"><INPUT TYPE="radio" name="repeatType" id="repeatType" ID="repeatTypeW" onClick="repeatTypeChange('W')" VALUE="W"></TD>
	<TD CLASS="LABEL">Week</TD>
	<TD CLASS="fields">
		<SELECT name="everyWeekDayNo" id="everyWeekDayNo" ID="everyWeekDayNo">
		<c:forEach var="weekDayNoTemp" items="${reminderQtyUnits['weekDayNos']}">
			<OPTION VALUE="${weekDayNoTemp.key}" ${weekDayNoTemp.key == param.everyWeekDayNo ? 'SELECTED':''}>${weekDayNoTemp.value}</OPTION>
		</c:forEach>
		</SELECT>
	&nbsp;
		<SELECT name="everyWeekWeekDay" id="everyWeekWeekDay" ID="everyWeekWeekDay">
		<c:forEach var="weekDayTemp" items="${reminderQtyUnits['weekDays']}">
			<OPTION VALUE="${weekDayTemp.key}" ${weekDayTemp.key == param.everyWeekWeekDay ? 'SELECTED':''}>${weekDayTemp.value}</OPTION>
		</c:forEach>
		</SELECT>
	</TD>
	<TD CLASS="LABEL">&nbsp;of each month</TD>
</TR>
<TR ID="lastTR">
	<TD CLASS="fields"><INPUT TYPE="radio" name="repeatType" id="repeatType" ID="repeatTypeL" onClick="repeatTypeChange('L')" VALUE="L"></TD>
	<TD CLASS="LABEL">Last</TD>
	<TD>
		<SELECT name="lastWeekDay" id="lastWeekDay" ID="lastWeekDay">
		<c:forEach var="lastWeekDayTemp" items="${reminderQtyUnits['lastWeekDays']}">
			<OPTION VALUE="${lastWeekDayTemp.key}" ${lastWeekDayTemp.key == param.lastWeekDay ? 'SELECTED':''}>${lastWeekDayTemp.value}</OPTION>
		</c:forEach>
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
			<OPTION VALUE="">Select</OPTION>
		<c:forEach var="num" items="1,2,3,4,5,6,7,8,9,10">
			<OPTION VALUE="${num}" ${num == param.retryNo ? 'selected' : ''}>${num}</OPTION>
		</c:forEach>
		</SELECT>
		time(s)
	
		<SELECT name="retryQty" id="retryQty" ID="retryQty">
			<OPTION VALUE="">Select</OPTION>
		<c:forEach var="num" items="1,2,3,4,5,6,7,8,9,10">
			<OPTION VALUE="${num}" ${num == param.retryQty ? 'selected' : ''}>${num}</OPTION>
		</c:forEach>
		</SELECT>
	
		<SELECT name="retryQtyUnit" id="retryQtyUnit" ID="retryQtyUnit">
			<OPTION VALUE="">Select</OPTION>
			<OPTION VALUE="minute" ${'minute' == param.retryQtyUnit ? 'selected' : ''}>minute(s)</OPTION>
			<OPTION VALUE="hour" ${'hour' == param.retryQtyUnit ? 'selected' : ''}>hour(s)</OPTION>
			<OPTION VALUE="day" ${'day' == param.retryQtyUnit ? 'selected' : ''}>day(s)</OPTION>
			<OPTION VALUE="week" ${'week' == param.retryQtyUnit ? 'selected' : ''}>week(s)</OPTION>
			<OPTION VALUE="month" ${'month' == param.retryQtyUnit ? 'selected' : ''}>month(s)</OPTION>
		</SELECT>
		
		<INPUT TYPE="text" name="expiryTime" id="expiryTime" ID="expiryTime" VALUE="${param.expiryTime}" SIZE="11" onBlur="xhIsBeforeNow(expiryTime,'DMYHM');">
		<INPUT TYPE='image' ID="expiryTimeCalendar" SRC='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('expiryTime','dd/mm/y hh:mm');">
	</TD>
</TR>
<TR>
	<TD CLASS="LABEL" COLSPAN="2">Reminder to be Submitted as</TD>
	<TD CLASS="fields" COLSPAN="1">
		<SELECT ID="reminderServiceType" name="reminderServiceType" id="reminderServiceType" STYLE="width:150px">
		<c:forEach var="tempReminderServiceType" items="${reminderServiceTypes}">
			<OPTION VALUE="${tempReminderServiceType.key}" ${tempReminderServiceType.key == param.serviceType ? 'SELECTED':''}>${tempReminderServiceType.value}</OPTION>
		</c:forEach>
		</SELECT>
		<IMG SRC='${pageContext.request.contextPath}/eCommon/images/mandatory.gif' ID="reminderServiceTypeIMG">
	</TD>
</TR>
</TABLE>
<DIV ID="dataFilterDiv" STYLE="${dataFilterScroll}display: none;">
<TABLE>
<TR>
	<TD CLASS="LABEL">Data Filter</TD>
	<TD CLASS="fields"><INPUT TYPE="text" name="dataFilter" id="dataFilter" ID="dataFilter" VALUE="${param.dataFilter}"></TD>
</TR>
<c:forEach var="field" items="${dynamicFields[0]}">
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
</TABLE>
</DIV>

<TABLE ID="dataConditionFilterDiv" STYLE="display: none;">
<c:forEach var="field" items="${dynamicFields[1]}">
<TR>
	<TD>
		<INPUT class="BUTTON" TYPE="button" VALUE="(" TITLE="Add Left bracket to filter criteria" onClick="addBracket('L','${field['PARAMID']}')">
	</TD>
	<TD CLASS="LABEL">${field['PARAMLABEL']}</TD>
	<TD CLASS='fields'>
		<SELECT ID="${field['PARAMID']}Operator" name="${field['PARAMID']}Operator" id="${field['PARAMID']}Operator">
			<c:forEach var="currentOperator" items="${reminderQtyUnits['operators']}">
				<OPTION VALUE="${currentOperator.key}" ${currentOperator.key == field['PARAM_COMPARISION_OPERATOR'] ? 'SELECTED' : ''}>${currentOperator.value}</OPTION>
			</c:forEach>
		</SELECT>
	</TD>
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
	<TD>
		<INPUT class="BUTTON" TYPE="button" VALUE=")" TITLE="Add Right bracket to filter criteria" onClick="addBracket('R','${field['PARAMID']}')">
	</TD>
	<TD CLASS='fields'>
		<SELECT ID="${field['PARAMID']}logicOperator" name="${field['PARAMID']}logicOperator" id="${field['PARAMID']}logicOperator">
			<OPTION VALUE="" SELECTED>Operator</OPTION>
			<OPTION VALUE=" AND " ${' AND ' == field['PARAM_LOGICAL_OPERATOR'] ? 'SELECTED' : ''}>AND</OPTION>
			<OPTION VALUE=" OR " ${' OR ' == field['PARAM_LOGICAL_OPERATOR'] ? 'SELECTED' : ''}>OR</OPTION>
		</SELECT>
	</TD>
</TR>
</c:forEach>
</TABLE>

<DIV ID="templateDiv" STYLE="display: none;">
<c:if test="${param.contactMode == 'M'}">
<TABLE ID="mobileTemplateDiv">
<TR>
	<TD CLASS="LABEL">Template</TD>
	<TD CLASS="fields"><INPUT TYPE="text" name="templateID" id="templateID" ID="templateID" VALUE="${param.templateID}"></TD>
	<TD><INPUT CLASS="BUTTON" TYPE="button" VALUE="Edit" onClick="openTemplate('${param.templateFolder}','${param.fileName}','${param.key}', templateID)" /></TD>
</TR>
</TABLE>
</c:if>
<c:if test="${param.contactMode == 'E'}">
<TABLE ID="mailTemplateDiv">
<TR>
	<TD CLASS="LABEL">Subject Format</TD>
	<TD CLASS="fields"><INPUT TYPE="text" name="mailSubject" id="mailSubject" ID="mailSubject" VALUE="${param.mailSubject}"></TD>
</TR>
<TR>
	<TD CLASS="LABEL">Mail Format</TD>
	<TD CLASS="fields"><INPUT TYPE="text" name="templateID" id="templateID" ID="templateID" VALUE="${param.templateID}"></TD>
	<TD><INPUT CLASS="BUTTON" TYPE="button" VALUE="Edit" onClick="openTemplate('${param.templateFolder}','${param.fileName}','${param.key}', templateID)" /></TD>
</TR>
<TR>
	<TD CLASS="LABEL">Mail Attachment Format</TD>
	<TD CLASS="fields"><INPUT TYPE="text" name="attachmentTemplateID" id="attachmentTemplateID" ID="attachmentTemplateID" VALUE="${param.attachmentTemplateID}"></TD>
	<TD><INPUT CLASS="BUTTON" TYPE="button" VALUE="Edit" onClick="openTemplate('${param.templateFolder}','${param.attachmentID}','${param.key}-attachment', attachmentTemplateID)" /></TD>
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
	<TD CLASS="fields">
		<INPUT TYPE="text" name="bccMailID" id="bccMailID" ID="bccMailID" VALUE="${param.bccMailID}" TITLE="Mail ID to which this notification will be sent always">
	</TD>
</TR>
</c:if>
</TABLE>
</DIV>

<TABLE ID="buttonTable" ALIGN="right">
<TR>
	<TD CLASS="fields"><INPUT ID="previousButton" CLASS="BUTTON" TYPE="button" VALUE="Previous" onClick="navigatePage(this)" DISABLED></TD>
	<TD CLASS="fields"><INPUT ID="nextButton" CLASS="BUTTON" TYPE="button" VALUE="Next" onClick="navigatePage(this)"></TD>
	<TD CLASS="fields"><INPUT ID="saveButton" CLASS="BUTTON" TYPE="button" VALUE="Save" onClick="saveSettings()" DISABLED></TD>
	<TD CLASS="fields"><INPUT ID="cancelButton" CLASS="BUTTON" TYPE="button" VALUE="Cancel" onClick="window.close();"></TD>
</TR>
</TABLE>

<INPUT TYPE="hidden" name="recipientType" id="recipientType" VALUE="${param.recipientType}">
<INPUT TYPE="hidden" name="recipientDependancy" id="recipientDependancy" VALUE="${param.recipientDependancy}">
<INPUT TYPE="hidden" name="contactType" id="contactType" VALUE="${param.contactType}">
<INPUT TYPE="hidden" name="contactMode" id="contactMode" VALUE="${param.contactMode}">
<INPUT TYPE="hidden" name="eventType" id="eventType" VALUE="${param.eventType}">
<INPUT TYPE="hidden" name="emContactMode" id="emContactMode" VALUE="${param.emContactMode}">
<INPUT TYPE="hidden" name="languageID" id="languageID" VALUE="${param.languageID}">
<INPUT TYPE="hidden" name="effStatus" id="effStatus" VALUE="${param.effStatus}">
<INPUT TYPE="hidden" name="consentYN" id="consentYN" VALUE="${param.consentStatus}">
<INPUT TYPE="hidden" name="preferrenceYN" id="preferrenceYN" VALUE="${param.preferrenceStatus}">
<INPUT TYPE="hidden" name="requestType" id="requestType" ID="requestType" VALUE="SAVE_SETTINGS">
<INPUT TYPE="hidden" name="everyQtyYN" id="everyQtyYN" ID="everyQtyYN">
<INPUT TYPE="hidden" name="recipientID" id="recipientID" ID="recipientID" VALUE="${param.recipientID}">
<INPUT TYPE="hidden" name="jobID" id="jobID" ID="jobID" VALUE="${param.jobID}">
<INPUT TYPE="hidden" name="ignorePage3" id="ignorePage3" ID="ignorePage3" VALUE="${ignorePage3}">
<INPUT TYPE="hidden" name="everyWeekDayYN" id="everyWeekDayYN" ID="everyWeekDayYN">
<INPUT TYPE="hidden" name="reportServiceCmd" id="reportServiceCmd" ID="reportServiceCmd">
<INPUT TYPE="hidden" ID="pageNo" VALUE="1">

</FORM>
</BODY>
</HTML>

