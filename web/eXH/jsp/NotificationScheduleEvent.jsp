<!DOCTYPE html>
<%@ include file="../../eXH/jsp/CommonIncludeSession.jsp" %>

<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonCalendar.js"></SCRIPT>
<SCRIPT LANGUAGE="javascript" SRC="../../eXH/js/NotificationSettings.js"></SCRIPT>
<TITLE>Notification Schedule</TITLE>
<BODY LEFTMARGIN="0" TOPMARGIN="0" onMouseDown="CodeArrest()" onKeyDown ='lockKey()' onLoad="scheduleEventInit()">
<FORM ID="scheduleEvent" name="scheduleEvent" id="scheduleEvent" METHOD="post">
<TABLE ALIGN="center">
<TR>
	<TD CLASS="LABEL" COLSPAN="5">
	Notify
		<INPUT TYPE="radio" name="startType" id="startType" ID="startType" onClick="startTypeChange('I')" CHECKED VALUE="I">Immediately
		<INPUT TYPE="radio" name="startType" id="startType" ID="startType" onClick="startTypeChange('R')" VALUE="R"> Reminder 
		<INPUT TYPE="radio" name="startType" id="startType" ID="startType" onClick="startTypeChange('B')" VALUE="B"> Both 
<!--		
		<INPUT TYPE="text" name="startAt" id="startAt" ID="startAt" VALUE="${param.startAt}" SIZE="11" DISABLED>
		<INPUT TYPE='image' ID="startAtCalendar" SRC='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('startAt','dd/mm/y hh:mm');" DISABLED>
-->
	</TD>
</TR>
<!--
<TR ID="noRepeatTR">
	<TD CLASS="fields"><INPUT TYPE="radio" name="repeatType" id="repeatType" ID="repeatType" onClick="repeatTypeChange('D')" VALUE="D" CHECKED></TD>
	<TD COLSPAN="4" CLASS="LABEL">Do not repeat</TD>
</TR>
-->
<TR ID="beforeTR">
	<TD CLASS="LABEL">Before</TD>
	<TD class='fields'>
		<INPUT TYPE="text" name="remindBefore" id="remindBefore" ID="remindBefore" VALUE="${remindBefore}">
	</TD>
	<TD CLASS="LABEL">Days</TD>
</TR>
<!--
<TR ID="weekBeforeTR">
	<TD CLASS="fields"><INPUT TYPE="radio" name="repeatType" id="repeatType" ID="repeatType" onClick="repeatTypeChange('W')" VALUE="W"></TD>
	<TD CLASS="LABEL">Week</TD>
	<TD CLASS="fields">
		<SELECT name="weekBefore" id="weekBefore" ID="weekBefore">
		<c:forEach var="before" items="First,Second,Third,Fourth,Fifth">
			<OPTION VALUE="${before}">${before}</OPTION>
		</c:forEach>
		</SELECT>
	&nbsp;
		<SELECT name="weekDay" id="weekDay" ID="weekDay">
		<c:forEach var="day" items="Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday">
			<OPTION VALUE="${day}">${day}</OPTION>
		</c:forEach>
		</SELECT>
	</TD>
	<TD CLASS="LABEL">&nbsp;of each month</TD>
</TR>
<TR ID="lastTR">
	<TD CLASS="fields"><INPUT TYPE="radio" name="repeatType" id="repeatType" ID="repeatType" onClick="repeatTypeChange('L')" VALUE="L"></TD>
	<TD CLASS="LABEL">Last</TD>
	<TD>
		<SELECT name="lastWeekDay" id="lastWeekDay" ID="lastWeekDay">
		<c:forEach var="day" items="Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday">
			<OPTION VALUE="${day}">${day}</OPTION>
		</c:forEach>
		</SELECT>
	</TD>
	<TD></TD>
	<TD></TD>
</TR>
-->
<TR>
	<TD COLSPAN="5" ALIGN="right">
		<INPUT CLASS="BUTTON" TYPE="button" VALUE="OK" onClick="eventSchedule()" />
		<INPUT CLASS="BUTTON" TYPE="button" VALUE="Cancel" onClick="window.close()" />
	</TD>
</TR>
</TABLE>
<INPUT TYPE="hidden" name="remindBeforeTimeUnit" id="remindBeforeTimeUnit" ID="remindBeforeTimeUnit" VALUE="D">
</FORM>
</BODY>
</HTML>

