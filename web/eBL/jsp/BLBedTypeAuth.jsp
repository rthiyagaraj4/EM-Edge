<!DOCTYPE html>
<%@  page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
    <head>
	<title><fmt:message key="eBL.AUTH_SCREEN.label" bundle="${bl_labels}"/></title>
	<!--
    <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src='../../eCommon/js/common.js' language='Javascript'></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<!--<script src='../../eCommon/js/messages.js' language='Javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

-->
	</head>
	<script>
	function chkNull()
	{
	var user = document.forms[0].user.value;
	var pin = document.forms[0].pin.value;
	if(user=="")
	{
//		alert(getMessage("BL9112"));
		alert(getMessage("BL9112","BL"));
		document.forms[0].user.focus();
		return false;
	}
	if(pin=="")
	{
//		alert(getMessage("BL9113"));
		alert(getMessage("BL9113","BL"));
		document.forms[0].pin.focus();
		return false;
	}
	if(user!="" && pin!="")
		return true;
	}
	function function1()
	{
		if(chkNull())
		document.Bl_Bed_Type_Form.submit();
	}
	function function2()
	{
		window.returnValue = '0';
		window.close();

	}
	function makeUpperCase()
	{
	if( (event.keyCode > 96) && (event.keyCode < 123) )
	{
		event.keyCode = event.keyCode - 32;
	}
	return true;
	}
	</script>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
    <form name='Bl_Bed_Type_Form' id='Bl_Bed_Type_Form'  method="post" target='dummyFrame1' action='../../eBL/jsp/BLBedTypeAuthPass.jsp'>
	<table border='0' cellpadding='3' cellspacing='0' align='center' width='100%'>

	<tr>
<!--	<td width="35%" align="right" class="label">User ID</td> -->
	<td width="50%" class="label"><fmt:message key="Common.userid.label" bundle="${common_labels}"/></td> 
	<td width="50%" class="fields"><input type='text' name='user' id='user' size='20' maxlength='20' onKeyPress='return makeUpperCase()'><img src='../../eCommon/images/mandatory.gif'></td>
	</tr>
	<tr>
<!--	<td width="35%" align="right" class="label">Pin No</td> -->
	<td width="50%" class="label"><fmt:message key="Common.PIN.label" bundle="${common_labels}"/></td>
	<td width="50%" class="fields"><input type='password' name='pin' id='pin' size='20' maxlength='64' autocomplete="off"><!--V230508-41626 --><img src='../../eCommon/images/mandatory.gif'></td>
	</tr>
	<!-- <td class='white' align='right' width='20%' colspan='2'><input class='button' type='Submit'  value='OK' onclick='function1()'>&nbsp;
    <input class='button' type='button' name='cancel' id='cancel' value='Cancel' onclick='function2()'></td>
	<input type=hidden name='auth_flag' id='auth_flag' value=''>
	</tr> -->
	
	<tr>
 	<td width="50%" class='button'><input type='button' class='button' name='auth_ok' id='auth_ok' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>" onClick ='function1()'><input type='button' class='button' name='auth_cancel' id='auth_cancel'  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" onClick='function2()'>
	<td width="50%"></td>
	</td>
	</tr>
	
	
	<tr>
		<td  colspan="115"></td>
	</tr>



	</table>
	<input type=hidden name='flag' id='flag' value=''>
	<script>
		document.forms[0].user.focus();
	</script>
	</form>
</html>

