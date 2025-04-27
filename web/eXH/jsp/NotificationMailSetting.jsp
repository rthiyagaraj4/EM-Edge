<!DOCTYPE html>
<%@ include file="../../eXH/jsp/CommonInclude.jsp" %>

<SCRIPT LANGUAGE="javascript" SRC="../../eXH/js/NotificationSettings.js"></SCRIPT>
<TITLE>Notification - Mail Settings</TITLE>

<BODY onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<FORM ID="mailSetting" name="mailSetting" id="mailSetting" METHOD="post">
<TABLE CELLSPACING="0" CELLPADDING="3" ALIGN="center">

<TR>
	<TD COLSPAN="5" ALIGN="right">
		<INPUT CLASS="BUTTON" TYPE="button" VALUE="OK" onClick="filterResults()" />
		<INPUT CLASS="BUTTON" TYPE="button" VALUE="Cancel" onClick="window.close()" />
	</TD>
</TR>
</TABLE>
<INPUT TYPE='hidden' name='requestType' id='requestType' ID='requestType' VALUE="CRITERIA_CHANGE">
</FORM>
</BODY>
</HTML>

