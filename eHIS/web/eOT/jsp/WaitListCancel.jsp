<!DOCTYPE html>


<%@ page import ="eOT.*,eOT.Common.*,eCommon.Common.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8"); %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<HTML>
<HEAD>

<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language="Javascript" src="../../eOT/js/Booking.js"></script>
<script lanaguage='javascript'>

function windowAccept()
{

	var frmObj=document.forms[0];
	if(frmObj.reason_code.value!='')
	{
		var param="reason_code="+frmObj.reason_code.value+"&waitlist_no="+frmObj.waitlist_no.value;

		var xmlDoc = "";
		var xmlHttp = new XMLHttpRequest();
		
		var xmlStr="<root></root>";
		xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
		
		xmlHttp.open("POST", "../../servlet/eOT.CancelWaitList?"+param, false);
		xmlHttp.send(xmlDoc);
		var resTxt=xmlHttp.responseText;
		window.returnValue=getMessage(resTxt,"OT");
		window.close();
	}
	else
	{
		var msg1 = getMessage("CAN_NOT_BE_BLANK","Common").replace("$",getLabel("Common.reason.label","Common"));
		alert(msg1);
	}
}



function windowClosing()
{
	window.returnValue='0';
	window.close();
}
 </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<TITLE> <fmt:message key="eOT.CancelWaitlist.Label" bundle="${ot_labels}"/></title>
</HEAD>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link>
<BODY>
<%
  String strWaitListNo="";
   strWaitListNo=CommonBean.checkForNull(request.getParameter("waitlist_no"));

   %>

<form>
<table  cellspacing='0'>
<tr>
<td class='label' valign='top'>
	<fmt:message key="Common.reason.label" bundle="${common_labels}"/>
</td>
<td class='label' colspan='2'>
<TEXTAREA NAME="reason_desc" ROWS="4" COLS="50" readonly >
</TEXTAREA>
</td>
	<td valign='top'>
		<input type='button'  class='button' value='?' name='surButton' id='surButton' onClick="funOTCheckDetail1('WaitlistReason','','<%=locale%>');"><img src='../../eCommon/images/mandatory.gif'></img>	
	</td>
	<tr>
		<td align='right' colspan='4'>
			<input type='button' class='button' value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick='windowAccept();'>
			<input type='button' class='button' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick='windowClosing();'>
		</td>
	</tr>
</table>
<input type='hidden' name='reason_code' id='reason_code' value=''>
<input type='hidden' name='waitlist_no' id='waitlist_no' value='<%=strWaitListNo%>'>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</HTML>

