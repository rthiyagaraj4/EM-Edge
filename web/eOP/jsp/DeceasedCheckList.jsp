<!DOCTYPE html>
<!-- ************************************************************************************************
/**
* Name:	DeceasedCheckList.jsp
* Date:	12/5/2004 
*
* Author: 	Annadurai.N
*
* -------------------------------------------------------------
* THIS IS UNPUBLISHED PROPRIETARY SOURCE CODE.
* The copyright notice above does not evidence any actual or
* intended publication of such source code.
* --------------------------------------------------------------
*/
***************************************************************************************************-->

<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
	String deceased_check = checkForNull(request.getParameter("deceased_check")); 
	if (deceased_check.equals("undefined"))
		deceased_check = checkForNull((String)session.getAttribute("deceased_check"));
	else session.setAttribute("deceased_check", deceased_check);
	if (deceased_check.equals(""))
		session.removeAttribute("deceased_check");
%>
<HTML>
<HEAD>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<!-- <script src="../../eCommon/js/dchk.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
<script>

function ChkNumberInput(fld, event, decimal)
{
	if (parseInt(decimal)>0)
		var strCheck = '.0123456789 /:';
	else
		var strCheck = '0123456789 /:';

	var whichCode = (window.Event) ? event.which : event.keyCode;
	if (whichCode == 13) return true;  // Enter
	key = String.fromCharCode(whichCode);  // Get key value from key code
	if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
}

function CheckDateTimeValue(obj)
{
	if (obj.value != "")
	if (!doDateTimeChk(obj))
	{
		alert(getMessage("INVALID_DATE_TIME","SM"));
		return false;
	}
}

function assignValue(status)
{
	if (status.checked)
			status.value = "Y";
	else	status.value = "N";
}

function getDeceasedChecklistDetail()
{
	var checklist = "";
	if (deceased_checklist.corner_release.checked)
		deceased_checklist.corner_release.value = "Y";
	if (deceased_checklist.death_certificate.checked)
		deceased_checklist.death_certificate.value = "Y";
	if (deceased_checklist.funeral_home.checked)
		deceased_checklist.funeral_home.value = "Y";
	if (deceased_checklist.autopsy.checked)
		deceased_checklist.autopsy.value = "Y";
	if (deceased_checklist.valuables.checked)
		deceased_checklist.valuables.value = "Y";
	
	checklist = deceased_checklist.orgon_donors.value;
	checklist += "||"+deceased_checklist.corner_release.value;
	checklist += "||"+deceased_checklist.death_certificate.value;
	checklist += "||"+deceased_checklist.funeral_home.value;
	checklist += "||"+deceased_checklist.autopsy.value;
	checklist += "||"+deceased_checklist.releases_date_time.value;
	checklist += "||"+deceased_checklist.valuables.value;

	deceased_checklist.checklist.value = checklist;
}

function closeWindow()
{
	getDeceasedChecklistDetail();
	window.returnValue = deceased_checklist.checklist.value;
	parent.window.close();
}

function getRelatedValues()
{
	var deceased		= new Array();
	var deceased_check	= unescape(deceased_checklist.deceased_check.value);

	if (deceased_check != "")
	{
		deceased = deceased_check.split("||");

		deceased_checklist.orgon_donors.value = deceased[0];

		if (deceased[1]=="Y")
				document.forms[0].corner_release.checked = true;
		else	document.forms[0].corner_release.checked = false;
		if (deceased[2]=="Y")
				document.forms[0].death_certificate.checked = true;
		else	document.forms[0].death_certificate.checked = false;
		if (deceased[3]=="Y")
				document.forms[0].funeral_home.checked = true;
		else	document.forms[0].funeral_home.checked = false;
		if (deceased[4]=="Y")
				document.forms[0].autopsy.checked = true;
		else	document.forms[0].autopsy.checked = false;
		document.forms[0].releases_date_time.value = deceased[5];
		if (deceased[6]=="Y")
				document.forms[0].valuables.checked = true;
		else	document.forms[0].valuables.checked = false;
		
	}
}

function checkForNull(inString)
{
	return (trimCheck(inString))	?	inString	:	"";
}// End of checkForNull.

</script>
<TITLE><fmt:message key="eOP.DeceasedChecklist.label" bundle="${op_labels}"/></TITLE>
</HEAD>
<body onLoad="getRelatedValues();" onKeyDown = 'lockKey();' >
<form name="deceased_checklist" id="deceased_checklist" >
<br>
<table cellpadding="0" cellspacing="0" border="0" width="100%">
<tr>
<td class="LABEL" align="RIGHT" width="50%"><fmt:message key="eOP.OrganDonors.label" bundle="${op_labels}"/></td>
<td class="QUERYDATA" width="50%"><input type="text" name="orgon_donors" id="orgon_donors"></td>
</tr>
<tr>
<td class="LABEL" align="RIGHT" width="50%"><fmt:message key="eOP.Coronerrelease.label" bundle="${op_labels}"/></td>
<td class="QUERYDATA" width="50%"><input type="checkbox" name="corner_release" id="corner_release" onClick="assignValue(this);" value="N" ></td>
</tr>
<tr>
<td class="LABEL" align="RIGHT" width="50%"><fmt:message key="eOP.DeathCertificateSigned.label" bundle="${op_labels}"/></td>
<td class="QUERYDATA" width="50%"><input type="checkbox" name="death_certificate" id="death_certificate" onClick="assignValue(this);" value="N" ></td>
</tr>
<tr>
<td class="LABEL" align="RIGHT" width="50%"><fmt:message key="eOP.FuneralHomeRelease.label" bundle="${op_labels}"/></td>
<td class="QUERYDATA" width="50%"><input type="checkbox" name="funeral_home" id="funeral_home" onClick="assignValue(this);" value="N" ></td>
</tr>
<tr>
<td class="LABEL" align="RIGHT" width="50%"><fmt:message key="eOP.Autopsy.label" bundle="${op_labels}"/></td>
<td class="QUERYDATA" width="50%"><input type="checkbox" name="autopsy" id="autopsy" onClick="assignValue(this);" value="N" ></td>
</tr>
<tr>
<td class="LABEL" align="RIGHT" width="50%"><fmt:message key="eOP.DateTimeofReleases.label" bundle="${op_labels}"/></td>
<td class="QUERYDATA" width="50%"><input type="text" id="releases_date_time" name="releases_date_time" id="releases_date_time" size="14" onKeyPress='return(ChkNumberInput(this,event,2));' maxlength="16" onBlur="return CheckDateTimeValue(this);" ><input type="image" id="calcomp" src="../../eCommon/images/CommonCalendar.gif" onClick="document.forms[0].releases_date_time.select();return showCalendar('releases_date_time',null,'hh:mm');"  ></td>
</tr>
<tr>
<td class="LABEL" align="RIGHT" width="50%"><fmt:message key="eOP.ValuablesReleased.label" bundle="${op_labels}"/></td>
<td class="QUERYDATA" width="50%"><input type="checkbox" name="valuables" id="valuables" onClick="assignValue(this);" value="N" ></td>
</tr>
</table>
<table width="100%" cellpadding="0" cellspacing="0" >
	<tr><td colspan="2"></td></tr>
	<tr class='white'>
	<td align="right" width="97%"><input type="button" class="button" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onclick="closeWindow();"></td>
	<td width="3%"></td></tr>
	</tr>
</table>
<br>
<input type="hidden" name="checklist" id="checklist">
<input type="hidden" name="deceased_check" id="deceased_check" value="<%=deceased_check%>">
</form>
</body>
</HTML>
<%!
	// By Annadurai 12/5/2004  - To handle NullPointerException starts
	public static String checkForNull(String inputString)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
	// By Annadurai 12/5/2004  - To handle NullPointerException End.
%>

