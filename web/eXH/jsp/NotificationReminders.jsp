<!DOCTYPE html>
<TR>
	<TD CLASS='COLUMNHEADER'>Recipient Type</TD>
	<TD CLASS='COLUMNHEADER'>Recipient Dependency</TD>
	<TD CLASS='COLUMNHEADER'>Contact Type</TD>
	<TD CLASS='COLUMNHEADER'>Contact Mode</TD>
	<TD CLASS='COLUMNHEADER'>Job Execution Frequency</TD>
	<TD CLASS='COLUMNHEADER'>Schedule</TD>
	<TD CLASS='COLUMNHEADER'>Data Criteria</TD>
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
	<TD CLASS="${CLASS_NAME}">${recipient['SCHEDULE_CMD']}</TD>
	<TD CLASS="${CLASS_NAME}">${recipient['SCHEDULE_CMD']}</TD>
	<TD CLASS="${CLASS_NAME}">${recipient['DATA_CRITERIA_CMD']}</TD>
	<TD CLASS="${CLASS_NAME}">
		<INPUT TYPE="checkbox" NAME="${recKey}${keySeparator}RCPT_STATUS" VALUE="E" ${recipient['STATUS']}>
		<INPUT TYPE="hidden" NAME="${recKey}${keySeparator}RCPT_STATUS" VALUE="D">
	</TD>
</TR>
</c:forEach>
