<!DOCTYPE html>

<%@ page   import="java.sql.*,java.util.*, java.text.*,  java.io.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%	request.setCharacterEncoding("UTF-8");	%>
<html>
<head>
	<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String func_id = request.getParameter("func_id");
		if(func_id==null) func_id="";
		String resp_id = request.getParameter("resp_id");
		if(resp_id == null) resp_id ="";
    %>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript'>
		function retModal(obj)
			{			
			var returnArray = false;		
			parent.window.returnValue = returnArray;					
			parent.window.close();
			}
		function confirmPasswdchk(obj)
			{
				
					var usr_id=document.forms(0).user_id.value;
					var pass_wd=document.forms(0).passwd.value;
					var func_id=document.forms(0).func_id.value; 
					var resp_id=document.forms(0).resp_id.value; 
					var returnArray ;
						if(usr_id=="")
						{
							alert(getMessage("USER_ID_NOT_BLANK","SM"));
							document.forms(0).user_id.focus();
							return false;
						}
						if(pass_wd=="")
						{
							alert(getMessage("PIN_NOT_BLANK","SM"));
							document.forms(0).passwd.focus();
							return false;
						}

					var HTMLVal="<html><body><form name='ConfirmPassWdForm' method='post' action='../../eSM/jsp/ConfirmPassWdForm.jsp'>"+
						"<input type='hidden' name='usr_id' value='"+usr_id+"'>"+
						"<input type='hidden' name='pass_wd' value='"+pass_wd+"'>"+
						"<input type='hidden' name='func_id' value='"+func_id+"'>"+
						"<input type='hidden' name='resp_id' value='"+resp_id+"'>"+
                        
						"</form></body></html>";

						parent.frames[1].document.body.insertAdjacentHTML('afterbegin', HTMLVal);
						parent.frames[1].document.ConfirmPassWdForm.submit();											
						return true;
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
		<title><fmt:message key="eSM.Auth_Screen.label" bundle="${sm_labels}"/></title>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<center>
<form name='AuthForm' id='AuthForm'>
<table border='0' cellpadding='3' cellspacing='0' align='center' width='100%'>
<tr>
	<td colspan=15>&nbsp;</td>
</tr>

<tr>
	<td width="50%" class="label"><fmt:message key="Common.userid.label" bundle="${common_labels}"/></td>
	<td width="50%" class="fields"><input type='text' name='user_id' id='user_id' size='30' maxlength='30' onKeyPress='return makeUpperCase()'><img src='../../eCommon/images/mandatory.gif'></td>
 </tr>
 <tr>
	<td width="50%" class="label" ><fmt:message key="Common.PIN.label" bundle="${common_labels}"/></td>
	<td width="50%" class="fields"><input type='password' name='passwd' id='passwd' size='20' maxlength='64'><img src='../../eCommon/images/mandatory.gif'></td>
 </tr>
<tr>
	<td width="50%"></td>
	<td width="50%">
	<!-- Added by Ajay for MMS-DM-CRF-0209.4  -->
	<input type="hidden" name="func_id" id="func_id" value="<%=func_id %>">
	<input type="hidden" name="resp_id" id="resp_id" value="<%=resp_id %>">
	<input type='button' class='button' name='auth_ok' id='auth_ok' value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>" onClick ='return confirmPasswdchk(this);'>
	<input type='button' class='button' name='auth_cancel' id='auth_cancel'  value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" onClick='return retModal(this);'>
	</td>
</tr>

<tr>
	<td colspan=15>&nbsp;</td>
</tr>
<tr>
	<td colspan=15>&nbsp;</td>
</tr>

	<script>
		document.forms[0].user_id.focus();
	</script>
</table>
</form>
</center>
</body>
</html>


