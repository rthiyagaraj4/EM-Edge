<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8"  import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" %>

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
request.setCharacterEncoding("UTF-8");
%>
<HTML>
<HEAD>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%String called_from = request.getParameter("called_from");%>

</HEAD>
<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<table width='100%' cellpadding='2' cellspacing='0' BORDER='0'>
<script>

function allowOnlyNumbers(event)
{
	if (((event.keyCode >= 48) && (event.keyCode <= 57)) || (event.keyCode == 46))
		return true;
	else return false;
}

function checkForMaximum(val)
{
	if (val.length>60)
	{
		var error = getMessage('CANNOT_EXCEED_N_CHARS','IP');
		error = error.replace('$','60');
		alert(error);	
		document.forms[0].bed_block_remarks.select();
	}
}

</script>
<TR>
	<TD  class="label" width='25%'><fmt:message key="eIP.BlockType.label" bundle="${ip_labels}"/></TD>
	<TD   class="fields" colspan='3'><INPUT TYPE="text" name="blocking_type" id="blocking_type" readOnly maxlength="30" size="30" ><input type="hidden" name="blocking_type_code" id="blocking_type_code" value="" ></TD>
	</TR>
<TR>
	<TD class="label" width='25%'><fmt:message key="eIP.BlockPeriod.label" bundle="${ip_labels}"/></TD>
	<TD  class="fields" colspan='3'><INPUT TYPE="text" name="bed_blocking_period" id="bed_blocking_period" value="" onBlur = "validSpecialChars(this);CheckNum(this);" onKeyPress="return allowOnlyNumbers(event);" maxlength="3" size="3" >&nbsp;<fmt:message key="Common.hours.label" bundle="${common_labels}"/></td>
</tr>

<%
if(called_from.equals("tfr_patient"))
{	%>
	<tr>
		<td class=label width='22%'><fmt:message key="eIP.BedBlockleduntil.label" bundle="${ip_labels}"/></td>
		<td colspan=3 class='fields' ><INPUT TYPE="text" name="bed_block_until" id="bed_block_until" readOnly maxlength="15" size="15" ></td>
	</TR>
<%}%>
<%if(!called_from.equals("tfr_patient"))
{%>
<TR>
	<TD class="label" width='20%'><fmt:message key="eIP.BedBlockleduntil.label" bundle="${ip_labels}"/></TD>
	<TD  class="fields" colspan='3'><INPUT TYPE="text" name="bed_block_until" id="bed_block_until" readOnly maxlength="15" size="15" ></TD>
</TR>
<%}%>

<TR>
	<TD class="label" width='23%'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></TD>
	<TD  colspan='3' class="fields"><TEXTAREA name='bed_block_remarks' value="" ROWS="2" COLS="60" maxlength='60' onBlur="makeValidString(this);checkForMaximum(this.value);" ></TEXTAREA></TD>
</TR>
</table>
</BODY>
</HTML>
<%!

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

