<!DOCTYPE html>
<TR>
	<TD CLASS='COLUMNHEADER'>Subscription</TD>
	<TD CLASS='COLUMNHEADER' TITLE="Preference" ALIGN="center">Pref</TD>
	<TD CLASS='COLUMNHEADER' TITLE="Consent" ALIGN="center">Consent</TD>
</TR>

<c:forEach var="recipient" items="${recipientList}">
	<c:set var="recKey" value="${recipient['KEY']}" />
	<c:set var="CLASS_NAME" value="${recipient['TD_CLASS_NAME']}" />
<TR>
	<TD CLASS="${CLASS_NAME}">${recipient['FILTER_GROUP_DESC']}</TD>
	<TD CLASS="${CLASS_NAME}">
<%-- 
Two Fields with same name, as unselected checkbox will not be part of the request once submitted.
If the checkbox is selected, value E will be sent to server in request, else value D of hidden field will be sent. 
--%>
		<INPUT TYPE="checkbox" NAME="${recKey}-PREF_STATUS" VALUE="Y" ${recipient['PREF_STATUS']}>
		<INPUT TYPE="hidden" NAME="${recKey}-PREF_STATUS" VALUE="N">
	</TD>
	<TD CLASS="${CLASS_NAME}">
		<INPUT TYPE="checkbox" NAME="${recKey}-CONSENT_STATUS" VALUE="Y" ${recipient['CONSENT_STATUS']}>
		<INPUT TYPE="hidden" NAME="${recKey}-CONSENT_STATUS" VALUE="N">
	</TD>
</TR>
</c:forEach>
