<!DOCTYPE html>
<TR>
	<TD CLASS='COLUMNHEADER'>Recipient Type</TD>
	<TD CLASS='COLUMNHEADER'>Recipient Dependency</TD>
	<TD CLASS='COLUMNHEADER'>Contact Type</TD>
	<TD CLASS='COLUMNHEADER'>Contact Mode</TD>
	<TD CLASS='COLUMNHEADER'>Mail Subject Format</TD>
	<TD CLASS='COLUMNHEADER'>Mail Template</TD>
	<TD CLASS='COLUMNHEADER'>SMS Template</TD>
	<TD CLASS='COLUMNHEADER'>Consent</TD>
	<TD CLASS='COLUMNHEADER'>Status</TD>
</TR>

<c:forEach var="recipient" items="${recipientList}">
<c:set var="recKey" value="${recipient['KEY']}" />
<c:set var="CLASS_NAME" value="${recipient['TD_CLASS_NAME']}" />
<TR>
	<TD CLASS="${CLASS_NAME}">${recipient['RECEIPIENT_TYPE_DESC']}</TD>
	<TD CLASS="${CLASS_NAME}">${recipient['RECIPIENT_DEPENDENCY_DESC']}</TD>
	<TD CLASS="${CLASS_NAME}">${recipient['CONTACT_TYPE_DESC']}</TD>
	<TD CLASS="${CLASS_NAME}">${recipient['CONTACT_MODE_DESC']}</TD>
	<TD CLASS="${CLASS_NAME}">
		<INPUT TYPE="text" NAME="${recKey}${keySeparator}SUBJECT" VALUE="${recipient['MAIL_SUBJECT_FORMAT']}">
	</TD>
	<TD CLASS="${CLASS_NAME}">
		<A HREF="#" onClick="openTemplate('${templateFolder}','${recipient['TEMPLATE_ID']}','${recKey}')" TARGET="_self">Edit</A>
		<INPUT TYPE='hidden' NAME='${recKey}${keySeparator}TEMPLATE_ID' ID='${recKey}${keySeparator}TEMPLATE_ID' VALUE="${recipient['TEMPLATE_ID']}">
	</TD>
	<TD CLASS="${CLASS_NAME}">
		<A HREF="#" onClick="openTemplate('${templateFolder}','${recipient['TEMPLATE_ID']}','${recKey}')" TARGET="_self">Edit</A>
		<INPUT TYPE='hidden' NAME='${recKey}${keySeparator}TEMPLATE_ID' ID='${recKey}${keySeparator}TEMPLATE_ID' VALUE="${recipient['TEMPLATE_ID']}">
	</TD>
	<TD CLASS="${CLASS_NAME}">
		<A HREF="#" onClick="openTemplate('${templateFolder}','${recipient['CONSENT_ID']}','${recKey}')" TARGET="_self">Edit</A>
		<INPUT TYPE='hidden' NAME='${recKey}${keySeparator}TEMPLATE_ID' ID='${recKey}${keySeparator}TEMPLATE_ID' VALUE="${recipient['TEMPLATE_ID']}">
	</TD>
	<TD CLASS="${CLASS_NAME}">
		<INPUT TYPE="checkbox" NAME="${recKey}${keySeparator}RCPT_STATUS" VALUE="E" ${recipient['STATUS']}>
		<INPUT TYPE="hidden" NAME="${recKey}${keySeparator}RCPT_STATUS" VALUE="D">
	</TD>
</TR>
</c:forEach>
