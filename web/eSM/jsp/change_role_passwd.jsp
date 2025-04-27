<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*, eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<head>
	<%
          String sStyle	=
          (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<title><fmt:message key="Common.changepassword.label" bundle="${common_labels}"/> </title>

<script language="JavaScript">
function clearPage()
{
	parent.frames[2].location.href ="../../eCommon/html/blank.html";
parent.frames[1].location.reload()
}


function CheckSpecialChar(obj)
{
	var fieldval = obj.value;
	var fieldlen = fieldval.length;
	var to_check = true;
	var SpChar = new Array();

	SpChar[0] = '~';
	SpChar[1] = '`';
	SpChar[2] = '!';
	SpChar[3] = '@';
	SpChar[4] = '#';
	SpChar[5] = '$';
	SpChar[6] = '%';
	SpChar[7] = '^';
	SpChar[8] = '&';
	SpChar[9] = '*';
	SpChar[10] = '(';
	SpChar[11] = ')';
	SpChar[12] = '-';
	SpChar[13] = '+';
	SpChar[14] = '=';
	SpChar[15] = '|';
	SpChar[16] = '\\';
	SpChar[17] = '[';
	SpChar[18] = ']';
	SpChar[19] = '{';
	SpChar[20] = '}';
	SpChar[21] = ':';
	SpChar[22] = ';';
	SpChar[23] = '"';
	SpChar[24] = '<';
	SpChar[25] = '>';
	SpChar[26] = '?';
	SpChar[27] = '/';
	SpChar[28] = '\'';
	SpChar[29] = '';
	SpChar[30] = ',';
	SpChar[31] = '.';

	if (fieldval.substr(0,1) == '_' ) 
	{
		to_check = false;
	}

	for (var i=0;i<fieldlen;i++)
	{

		if (fieldval.substr(i,1) == ' ' || fieldval.substr(i,1) == null)
		{
			to_check = false;
		}

		for (var j=0;j<=31;j++)
		{
			if (fieldval.substr(i,1) == SpChar[j])
			{
				to_check = false;
			}
		}
	}

	if (to_check == false)
	{
		alert(getMessage('SPECIAL_CHARCTERS_NOT_ALLOWED','SM'));
		//obj.select();
		obj.focus();
		obj.value='';
	}
}

function checkPassword() {
		

		var old_password	= change_password_form.old_password.value ;
		
		var new_password1	= change_password_form.new_password1.value ;
		
		var new_password2	= change_password_form.new_password2.value ;
		
		var errors		= "" ;
		var result		= true ;

		
if (  old_password =="") 
		{ 
			var err2 = getMessage('OLD_PW_NOT_BLANK','SM');
			alert(err2);
			return  false ;
		}


if ( new_password1 =="") 
		{  	var err2 = getMessage('NEW_PW_NOT_BLANK','SM');
			alert(err2);
			return  false ;
		}

if ( new_password2 =="") 
		{   
	       var err2 = getMessage('REENTER_PW_NOT_BLANK','SM');
		   alert(err2)
			return  false ;
		}

		if ( new_password1 != new_password2 ) 
		{
		
			var err2 = getMessage('CONF_PASS_NOT_SAME_AS_NEW_PASS','SM'); 
			errors = errors +'\n'+ err2;
			result = false ;
		}

		if ( new_password1.length < 5  ) 
		{

			var err3 = getMessage('MIN_LENGTH_5_CH','SM'); 
			errors = errors + '\n'+ err3;
			result = false ;
		}

		

		if ( new_password1.length > 10)
		{
			var err5 = getMessage('MAX_LENGTH_10_CH','SM'); 
			errors = errors + '\n'+ err5;
			result = false ;
		}

		if ( result )
	{	
         
		change_password_form.submit() ;
		
	}
		else{
			alert( errors ) ;
			
		    }	
		return result ;
	}

		function CheckForNumber(obj) 
	{
		if (obj.value.length > 0 )
		{
			if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0)
			{		
				alert(getMessage('CANNOT_START_WITH_NUMERIC','SM'));
				obj.value='';
				obj.select();
				obj.focus();
				return false;
			}

			if (obj.value.substr(0,1) >= 0)
			{
				alert(getMessage('CANNOT_START_WITH_NUMERIC','SM'));
				obj.value='';
				obj.select();
				obj.focus();
				return false;
			}
		}
	}
	

</script>

</head>

<%
    request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	Connection con=null;
	PreparedStatement pstmt	 = null;
	try{
	String  idH1 = request.getParameter("idH1");
	String  idH2 = request.getParameter("idH2");
	String  idH3 = request.getParameter("idH3");
	
	
	String  enab1 = request.getParameter("enab1");
	String  enab2 = request.getParameter("enab2");
	String  enab3 = request.getParameter("enab3");	
	


	String ObjVal= request.getParameter("ObjVal");

	

%>

<body class="CONTENT" onKeyDown = 'lockKey()'; OnMouseDown='CodeArrest()'  onLoad="window.document.title='Change Password';">
<center>

	<form name="change_password_form" id="change_password_form" method="post" action="../../servlet/eSM.DatabaseRoleServlet" target="blankFrame">
		<tr><td colspan='2'>&nbsp;</td></tr>
		<tr><td colspan='2'>&nbsp;</td></tr>
		<tr><td colspan='2'>&nbsp;</td></tr>
<BR>
<BR>
		<table width="70%" cellpadding='0' cellspacing='0'>		

			<tr><th colspan='2'> <b><fmt:message key="Common.changepassword.label" bundle="${common_labels}"/></b></th></tr>
			<tr><td colspan='2'>&nbsp;</td></tr>
			<tr>
				<td width='50%' class='label'>
					<fmt:message key="Common.RoleType.label" bundle="${common_labels}"/>
				</td>
				<td>&nbsp;
					<input type="text" name="role_id" id="role_id" value="<%= ObjVal%>" readonly>
				</td>
			</tr>
			<tr>
				<td class='label'>
					<fmt:message key="Common.oldPassword.label" bundle="${common_labels}"/>
				</td>
				<td>&nbsp;
					<input type="password" onKeyUp="CheckSpecialChar(this);CheckForNumber(this)"  maxlength=10 name="old_password" id="old_password"> <img src='../../eCommon/images/mandatory.gif'align='center'></img>
				</td>
			</tr>

			<tr>
				<td class='label'>
					<fmt:message key="Common.newPassword.label" bundle="${common_labels}"/>
				</td>
				<td>&nbsp;
					<input type="password" name="new_password1" id="new_password1" onBlur="" onKeyUp="CheckSpecialChar(this);CheckForNumber(this)" maxlength="10"> <img src='../../eCommon/images/mandatory.gif'align='center'></img>
				</td>
			</tr>

			<tr>
				<td class='label'>
					<fmt:message key="eSM.ReenterNewPassword.label" bundle="${sm_labels}"/>
				</td>
				<td>&nbsp;
					<input type="password" name="new_password2" id="new_password2" onBlur="" onKeyUp="CheckSpecialChar(this);CheckForNumber(this)" maxlength="10"> <img src='../../eCommon/images/mandatory.gif'align='center'></img>
				</td>
			</tr>

			<tr><td colspan='2'>&nbsp;</td></tr>
		</table>

		<br>

		
		<input type='button' class='BUTTON' value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/> ' onClick='checkPassword();'> &nbsp;&nbsp;
		<input type='button' class='BUTTON' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick="clearPage()">

		
		<input type="hidden" name="idH1" id="idH1" value="<%= idH1 %>">
		<input type="hidden" name="idH2" id="idH2" value="<%= idH2 %>">
		<input type="hidden" name="idH3" id="idH3" value="<%= idH3 %>">
				
		<input type="hidden" name="enab1" id="enab1" value="<%= enab1 %>">
		<input type="hidden" name="enab2" id="enab2" value="<%= enab2 %>">
		<input type="hidden" name="enab3" id="enab3" value="<%= enab3 %>">
		
		<input type="hidden" name="ObjVal" id="ObjVal" value="<%= ObjVal %>">
		
		<input type="hidden" name="ChangeWin" id="ChangeWin" value=CW>
		

	</form>
</center>
<%
}catch(Exception e){out.println(e);}
			finally { 
				if(pstmt!=null) pstmt.close();
	ConnectionManager.returnConnection(con,request);
}
%>
</body>

