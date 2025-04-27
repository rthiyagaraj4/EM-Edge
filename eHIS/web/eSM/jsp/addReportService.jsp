<!DOCTYPE html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


<%
	request.setCharacterEncoding("UTF-8");
	String app_server_ip = (String) session.getValue( "app_server_ip" ) ;
String rep_cfg_key = "";
	if ( app_server_ip == null ) app_server_ip = "" ;
%>

<html>
<head>
   <%
        String sStyle	=
       (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/dchk.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
	function ChkNumberInput1(fld, e, deci)
{
if (parseInt(deci)>0)
   var strCheck = '.0123456789';
else
   var strCheck = '0123456789';


	
var whichCode = (window.Event) ? e.which : e.keyCode;
if (whichCode == 13) return true;  // Enter

key = String.fromCharCode(whichCode);  // Get key value from key code

if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
}

function SpeCharCheck(which) {
fldval = which.value;
fldval = fldval.replace(/^\s+/,""); // strip leading spaces
if (/[^.0-9\s]/i.test(fldval)) { // only alphanumeric and space allowed
alert ("You have entered one or more invalid characters - try again!");
which.value = "";
which.focus();
return false;
}
}


function CheckForSpecChars1(event){
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
}
</script>
</head>
<body  OnMouseDown="CodeArrest()"  onKeyDown = 'lockKey()' OnLoad="Focusing('Report_Service_Id')">
<form name="report_service_form" id="report_service_form" action="../../servlet/eSM.ReportServiceServlet" method="post" target="messageFrame">
<div align="left">
<br><br><br><br><br><br>
  <table border="0" cellpadding="0" cellspacing="0" width="90%" align='center'>
  <tr>
     <td width='25%'>&nbsp;</td>
     <td width='25%'>&nbsp;</td>
     <td width='25%'>&nbsp;</td>
     <td width='25%'>&nbsp;</td>
  </tr>
  <tr> 
      <td class="label" ><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
      <td  class='fields' >
      <input type="text" name="Report_Service_Id" id="Report_Service_Id" size="8" maxlength="8" onKeyPress="return CheckForSpecChars(event)" OnBlur="ChangeUpperCase(this)">&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img>
      </td>
	  <td colspan='2'>&nbsp;</td>
    </tr>
    <tr>
     <td width='25%'>&nbsp;</td>
     <td width='25%'>&nbsp;</td>
     <td width='25%'>&nbsp;</td>
     <td width='25%'>&nbsp;</td>
    </tr>
    <tr>
      <td  class="label" ><fmt:message key="Common.name.label" bundle="${common_labels}"/></td>
      <td  class='fields' ><input type="text" name="Report_Service_Name" id="Report_Service_Name" size="30" onBlur="makeValidString(this)"  maxlength="30">&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
  	  <td colspan='2'>&nbsp;</td>
    </tr>

<!-- By sbchand start on 24th July, 2001 -->                         
    <tr>
     <td width='25%'>&nbsp;</td>
     <td width='25%'>&nbsp;</td>
     <td width='25%'>&nbsp;</td>
     <td width='25%'>&nbsp;</td>
    </tr>
    <tr>
      <td  class="label" nowrap><fmt:message key="eSM.ReportServerIPAddress.label" bundle="${sm_labels}"/> </td>
      <td class='fields' ><input type="text" name="app_server_ip" id="app_server_ip" size="30" maxlength="30" value="<%= app_server_ip %>" onKeyPress='return(ChkNumberInput1(this,event,2))' onblur='SpeCharCheck(this)'>&nbsp;</td> <!-- Added by Ashwin K where size and maxlength are increased to 30 for COMMON-ICN-0093 on 03.03.2022 -->
	  <td colspan='2'>&nbsp;</td>
    </tr>
<!-- By sbchand end on 24th July, 2001 -->
    <tr>
     <td width='25%'>&nbsp;</td>
     <td width='25%'>&nbsp;</td>
     <td width='25%'>&nbsp;</td>
     <td width='25%'>&nbsp;</td>
    </tr>
	<tr>
      <td  class="label" ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
      <td  class='fields' ><TextArea  name="Remarks" cols="40" rows="5" onBlur="makeValidString(this)" onkeypress='checkMaxLimit(this,200)'></TextArea></td>
	  <td colspan='2'>&nbsp;</td>
    </tr>
    <tr>
     <td width='25%'>&nbsp;</td>
     <td width='25%'>&nbsp;</td>
     <td width='25%'>&nbsp;</td>
     <td width='25%'>&nbsp;</td>
    </tr>
	<tr>
      <td  class="label" nowrap><fmt:message key="eSM.ReportConfigKey.label" bundle="${sm_labels}"/> </td>
      <td class='fields' ><input type="text" name="rep_cfg_key" id="rep_cfg_key" size="10" maxlength="10"  onBlur='makeValidString(this)' value="<%=rep_cfg_key%>" >&nbsp;</td>
	  <td colspan='2'>&nbsp;</td>
    </tr>
    <tr>
     <td width='25%'>&nbsp;</td>
     <td width='25%'>&nbsp;</td>
     <td width='25%'>&nbsp;</td>
     <td width='25%'>&nbsp;</td>
    </tr>

	<tr>
	<td class='label' ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
    <td class='fields' ><input type="checkbox" name="eff_status" id="eff_status" value="E" checked>&nbsp;</td>
    <td colspan='2'>&nbsp;</td>
	</tr>
    <tr>
     <td width='25%'>&nbsp;</td>
     <td width='25%'>&nbsp;</td>
     <td width='25%'>&nbsp;</td>
     <td width='25%'>&nbsp;</td>
    </tr>
  </table>
</div>
<input type="hidden" name="function" id="function" value="insert">
<input type="hidden" name="function_name" id="function_name" value="insert">
<input type="hidden" name="eff_date_from" id="eff_date_from" >
<input type="hidden" name="eff_date_to" id="eff_date_to" >
</form>

</body>
</html>

