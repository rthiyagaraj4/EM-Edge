<!DOCTYPE html>
<TR>
<c:if test="${empty eventType}">
	<TD CLASS='COLUMNHEADER'>Event Type</TD>
</c:if>
	<TD CLASS='COLUMNHEADER'>Recipient Type</TD>
	<TD CLASS='COLUMNHEADER'>Recipient Dependency</TD>
	<TD CLASS='COLUMNHEADER'>Contact Type</TD>
	<TD CLASS='COLUMNHEADER'>Contact Mode</TD>
	<TD CLASS='COLUMNHEADER'>Language</TD>
	<TD CLASS='COLUMNHEADER' TITLE="Preference" ALIGN="center">Pref</TD>
	<TD CLASS='COLUMNHEADER' TITLE="Consent" ALIGN="center">Consent</TD>
	<TD CLASS='COLUMNHEADER'>Status</TD>
	<TD CLASS='COLUMNHEADER' TITLE="Notification Settings">&nbsp;</TD>
</TR>

<c:forEach var="recipient" items="${recipientList}">
	<c:set var="recKey" value="${recipient['KEY']}" />
	<c:set var="CLASS_NAME" value="${recipient['TD_CLASS_NAME']}" />
<TR>
<c:if test="${empty eventType}">
	<TD CLASS="${CLASS_NAME}">${recipient['EVENT_NAME']}</TD>
</c:if>
	<TD CLASS="${CLASS_NAME}">${recipient['RECEIPIENT_TYPE_DESC']}</TD>
	<TD CLASS="${CLASS_NAME}">${recipient['RECIPIENT_DEPENDENCY_DESC']}</TD>
	<TD CLASS="${CLASS_NAME}">${recipient['CONTACT_TYPE_DESC']}</TD>
	<TD CLASS="${CLASS_NAME}">${recipient['CONTACT_MODE_DESC']}</TD>
	<TD CLASS="${CLASS_NAME}">${languages[recipient['PREF_LANG_ID']]}</TD>
	<TD CLASS="${CLASS_NAME}">
<%-- 
Two Fields with same name, as unselected checkbox will not be part of the request once submitted.
If the checkbox is selected, value E will be sent to server in request, else value D of hidden field will be sent. 
--%>
		<INPUT TYPE="checkbox" NAME="${recKey}${keySeparator}PREF_STATUS" ID="${recKey}${keySeparator}PREF_STATUS" VALUE="Y" ${recipient['PREF_STATUS']}>
		<INPUT TYPE="hidden" NAME="${recKey}${keySeparator}PREF_STATUS" VALUE="N">
	</TD>
	<TD CLASS="${CLASS_NAME}">
		<INPUT TYPE="checkbox" NAME="${recKey}${keySeparator}CONSENT_STATUS" ID="${recKey}${keySeparator}CONSENT_STATUS" VALUE="Y" ${recipient['CONSENT_STATUS']}>
		<INPUT TYPE="hidden" NAME="${recKey}${keySeparator}CONSENT_STATUS" VALUE="N">
	</TD>
	<TD CLASS="${CLASS_NAME}">
		<INPUT TYPE="checkbox" NAME="${recKey}${keySeparator}RCPT_STATUS" ID="${recKey}${keySeparator}RCPT_STATUS" VALUE="E" ${recipient['STATUS']}>
		<INPUT TYPE="hidden" NAME="${recKey}${keySeparator}RCPT_STATUS" VALUE="D">
	</TD>
	<TD CLASS="${CLASS_NAME}">
		<A HREF="#" onClick="notificationSettings('${templateFolder}',
								'${recipient['CONTACT_TYPE']}',
								'${recipient['TEMPLATE_ID']}',
								'${recKey}',
								'${recipient['ATTACHMENT_ID']}',
								'${recipient['EM_CONTACT_MODE']}',
								'${recipient['EVENT_NAME']}',
								'${recipient['EVENT_TYPE']}',
								'${recipient['RECEIPIENT_TYPE']}',
								'${recipient['RECEIPIENT_DEPENDENCY']}',
								'${recipient['CONTACT_MODE']}',
								'${recipient['PREF_LANG_ID']}',
								'${recipient['REMINDER_DTLS']}',
								'${recipient['JOB_NUMBER']}',
								'${recipient['REMAINDER_EVENT_YN']}')">
			<IMG BORDER="0" SRC="../eXH/images/setting.png" TITLE="Notification Settings">
		</A>
	</TD>
</TR>
</c:forEach>
