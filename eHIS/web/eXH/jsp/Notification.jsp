<!DOCTYPE html>
<HTML> 
<%@ page import="eCommon.XSSRequestWrapper, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eXH/jsp/CommonInclude.jsp" %>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
<head>
<link rel='stylesheet' type='text/css' href='../eCommon/html/<%=sStyle%>'></link>
<SCRIPT LANGUAGE="javascript" SRC="../eXH/js/CommonCalendar.js"></SCRIPT>
<SCRIPT LANGUAGE="javascript" SRC="../eXH/js/NotificationSettings.js"></SCRIPT>

<SCRIPT LANGUAGE="javascript">
function openTemplate(templateFolder, fileName, key)
{
	if(fileName == 'null' || fileName == '')
	{
		fileName = key + ".doc";
		createDoc(templateFolder + fileName);
		document.getElementById(key + "-TEMPLATE_ID").value = fileName;
	}
	else
	{
	//	window.open("file://10.10.44.87/tem/OT12-PRA-Anesthestist1-Mobile1.doc");
		openDoc(templateFolder + fileName);
	}
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

</head>

<BODY LEFTMARGIN="0" TOPMARGIN="0" onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<FORM ID="recipientSchedule" name="recipientSchedule" id="recipientSchedule" METHOD="post" ACTION='../servlet/eXH.NotificationSettingsServlet'>

<TABLE CELLSPACING="0" CELLPADDING="3" BORDER="1" WIDTH="100%">
<TR>
	<TD ALIGN="right" CLASS="CAGROUP" COLSPAN="10"> 
		<A CLASS='label' STYLE='cursor:pointer' onClick="funAction('P')">${previousPage}</A>
		<A CLASS='label' onClick="funAction('N')" STYLE='cursor:pointer'>${nextPage}</A>
	</TD>
</TR>
<TR>
<c:if test="${empty eventType}">
	<TD CLASS='COLUMNHEADER'>Event Type</TD>
</c:if>
	<TD CLASS='COLUMNHEADER'>Recipient Type</TD>
	<TD CLASS='COLUMNHEADER'>Recipient Dependency</TD>
	<TD CLASS='COLUMNHEADER'>Contact Type</TD>
	<TD CLASS='COLUMNHEADER'>Contact Mode</TD>
	<TD CLASS='COLUMNHEADER'>Status</TD>
	<TD CLASS='COLUMNHEADER'>Schedule</TD>
	<TD CLASS='COLUMNHEADER'>Template</TD>
	<TD CLASS='COLUMNHEADER'>EM Contact Mode</TD>
	<TD CLASS='COLUMNHEADER'>Language</TD>
</TR>
<c:forEach var="recipient" items="${recipientList}">
<TR>
<c:if test="${empty eventType}">
	<TD CLASS="${recipient[13]}">${recipient[10]}</TD>
</c:if>
	<TD CLASS="${recipient[13]}">${recipient[1]}</TD>
	<TD CLASS="${recipient[13]}">${recipient[2]}</TD>
	<TD CLASS="${recipient[13]}">${recipient[3]}</TD>
	<TD CLASS="${recipient[13]}">${recipient[4]}</TD>
	<TD CLASS="${recipient[13]}">
	<%-- 
	Two Fields with same name, as unselected checkbox will not be part of the request once submitted.
	If the checkbox is selected, value E will be sent to server in request, else value D of hidden field will be sent. 
	--%>
		<INPUT TYPE="checkbox" name="${recipient[6]}-RCPT_STATUS" id="${recipient[6]}-RCPT_STATUS" VALUE="E" ${recipient[12]}>
		<INPUT TYPE="hidden" name="${recipient[6]}-RCPT_STATUS" id="${recipient[6]}-RCPT_STATUS" VALUE="D">
	</TD>
	<TD CLASS="${recipient[13]}">
		<INPUT TYPE="text" name="${recipient[6]}-RCPT_SCDL" id="${recipient[6]}-RCPT_SCDL" ID="${recipient[6]}-RCPT_SCDL">
		<INPUT class="BUTTON" TYPE="button" VALUE="?" onClick="dispEventSchedule('${recipient[6]}-RCPT_SCDL')">
	</TD>
	<TD CLASS="${recipient[13]}" ALIGN="center">
		<A HREF="#" onClick="openTemplate('${templateFolder}','${recipient[7]}','${recipient[6]}')" TARGET="_self">Edit</A>
		<INPUT TYPE='hidden' name='${recipient[6]}-TEMPLATE_ID' id='${recipient[6]}-TEMPLATE_ID' ID='${recipient[6]}-TEMPLATE_ID' VALUE="${recipient[7]}">
	</TD>
	<TD CLASS="${recipient[13]}">
		<INPUT TYPE="text" name="${recipient[6]}-RCPT_CONTACT_MODE" id="${recipient[6]}-RCPT_CONTACT_MODE" ID="${recipient[9]}-RCPT_CONTACT_MODE" VALUE="${recipient[9]}">
	</TD>
	<TD CLASS="${recipient[13]}">
		<SELECT name="${recipient[6]}-NOTIF_LANG" id="${recipient[6]}-NOTIF_LANG" ID="${recipient[6]}-NOTIF_LANG">
		<c:forEach var="language" items="${languages}">
			<OPTION VALUE="${language.key}" ${language.key == recipient[11] ? 'SELECTED' : ''}>${language.value}</OPTION>
		</c:forEach>
		</SELECT>
	</TD>
</TR>
</c:forEach>
</TABLE>
<INPUT TYPE='hidden' name='action_type' id='action_type' ID='action_type' VALUE="${action_type}">
<INPUT TYPE='hidden' name='requestType' id='requestType' ID='requestType'>
<INPUT TYPE='hidden' name='messageType' id='messageType' ID='messageType' VALUE="${messageType}">
<INPUT TYPE='hidden' name='eventType' id='eventType' ID='eventType' VALUE="${eventType}">
</FORM>
</BODY>
</HTML>

