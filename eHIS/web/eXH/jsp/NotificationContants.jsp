<!DOCTYPE html>
<TR>
	<TD CLASS='COLUMNHEADER'>Recipient Type</TD>
	<TD CLASS='COLUMNHEADER'>Recipient Dependency</TD>
	<TD CLASS='COLUMNHEADER'>Contact Type</TD>
	<TD CLASS='COLUMNHEADER'>Contact Mode</TD>
	<TD CLASS='COLUMNHEADER'>To CommID</TD>
	<TD CLASS='COLUMNHEADER'>CC CommID</TD>
	<TD CLASS='COLUMNHEADER'>BCC CommID</TD>
	<TD CLASS='COLUMNHEADER'>To Fail CommID</TD>
	<TD CLASS='COLUMNHEADER'>Status</TD>
</TR>

<c:forEach var="recipient" items="${recipientList}">
<c:set var="recKey" value="${recipient['KEY']}" />
<c:set var="CLASS_NAME" value="${recipient['TD_CLASS_NAME']}" />
<TR>
	<TD CLASS="${CLASS_NAME}">${recipient['RECEIPIENT_TYPE_DESC']}</TD>
	<TD CLASS="${CLASS_NAME}">${recipient['RECEIPIENT_DEPENDENCY_DESC']}</TD>
	<TD CLASS="${CLASS_NAME}">${recipient['CONTACT_TYPE_DESC']}</TD>
	<TD CLASS="${CLASS_NAME}">${recipient['CONTACT_MODE_DESC']}</TD>
	<TD CLASS="${CLASS_NAME}">
		<INPUT TYPE="text" NAME="${recKey}${keySeparator}TO_COMM_ID" VALUE="${recipient['TO_COMMUNICATION_ID']}">
	</TD>
	<TD CLASS="${CLASS_NAME}">
		<INPUT TYPE="text" NAME="${recKey}${keySeparator}CC_COMM_ID" VALUE="${recipient['CC_COMMUNICATION_ID']}">
	</TD>
	<TD CLASS="${CLASS_NAME}">
		<INPUT TYPE="text" NAME="${recKey}${keySeparator}BCC_COMM_ID" VALUE="${recipient['BCC_COMMUNICATION_ID']}">
	</TD>
	<TD CLASS="${CLASS_NAME}">
		<INPUT TYPE="text" NAME="${recKey}${keySeparator}TO_FAIL_COMM_ID" VALUE="${recipient['TO_FAIL_COMMUNICATION_ID']}">
	</TD>
	<TD CLASS="${CLASS_NAME}">
		<INPUT TYPE="checkbox" NAME="${recKey}${keySeparator}RCPT_STATUS" VALUE="E" ${recipient['STATUS']}>
		<INPUT TYPE="hidden" NAME="${recKey}${keySeparator}RCPT_STATUS" VALUE="D">
	</TD>
</TR>
</c:forEach>
