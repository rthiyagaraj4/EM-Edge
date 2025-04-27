<!DOCTYPE html>
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


<head>
  <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css">      <%
  
	
	
	%>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language="JavaScript">
function CheckOneSpecialChar(obj,enforce_password_policy_yn,allowed_spl_char_in_password)
{
	var fieldval = obj.value;
	var fieldlen = fieldval.length;
	var to_check = true;
	var SpChar = new Array();
	var allowed_spl_char_in_password1=decodeURIComponent(allowed_spl_char_in_password,'UTF-8');
	allowed_spl_char_in_password1 = allowed_spl_char_in_password1.replace("+",'');
	//Maheshwaran added for the MMS-QH-CRF-0149
	if(enforce_password_policy_yn=='Y')
		{
		SpChar[0] = '!';
		SpChar[1] = '#';
		SpChar[2] = '%';
		SpChar[3] = '&';
		SpChar[4] = '(';
		SpChar[5] = ')';
		SpChar[6] = '+';
		SpChar[7] = '=';
		SpChar[8] = '|';
		SpChar[9] = '\\';
		SpChar[10] = '{';
		SpChar[11] = '}';
		SpChar[12] = ':';
		SpChar[13] = ';';
		SpChar[14] = '"';
		SpChar[15] = '<';
		SpChar[16] = '>';
		SpChar[17] = '/';
		SpChar[18] = '\'';
		SpChar[19] = '';
		SpChar[20] = ',';
		SpChar[21] = '.';
		SpChar[22] = '@';
		}
	else{
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
		}
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
		//Maheshwaran added for the MMS-QH-CRF-0149
		if(enforce_password_policy_yn=='Y')
			{
			for (var j=0;j<=22;j++)
				{
				if (fieldval.substr(i,j) == SpChar[j])
					{
					to_check = false;
					}
				}
			}		
		else
			{
			for (var j=0;j<=31;j++)
				{
				if (fieldval.substr(i,j) == SpChar[j])
					{
					to_check = false;
					}
				}
			}
	}
		
	
	if (to_check == false)
	{	
		//Maheshwaran added for the MMS-QH-CRF-0149
		if(enforce_password_policy_yn=='Y'){
		alert(getMessage('PASSWORD_POLICY','SM').concat(" "+allowed_spl_char_in_password1));
		}
		else
			{
			alert(getMessage('SPECIAL_CHARCTERS_NOT_ALLOWED','SM'));
			}
		obj.select();
		obj.focus();
		obj.value='';
	}

	}

	
	function checkLen_1(Obj,enforce_password_policy_yn,allowed_spl_char_in_password,password_length_min,password_length_max) {
			var errors = "" ;
			var len_one=Obj.value.length;
				var allowed_spl_char_in_password1=decodeURIComponent(allowed_spl_char_in_password,'UTF-8');
		allowed_spl_char_in_password1 = allowed_spl_char_in_password1.replace("+",'')
			if (len_one <password_length_min)
				{
					errors = getMessage('PWD_MIN_CH','SM');
					errors=errors.replace("#",password_length_min);
					alert(errors);
					Obj.focus();
							
				}
				else if (len_one >password_length_max)
				{
					errors = getMessage('PWD_MAX_CH','SM');
					errors=errors.replace("#",password_length_max);
					alert(errors);
					Obj.focus();
							
				}			
				else {
				if(enforce_password_policy_yn=='Y')
					{
					ChkPWSplChar(Obj,allowed_spl_char_in_password1);
					}
						
				}
			}
		
function checkLen_2(len,enforce_password_policy_yn,allowed_spl_char_in_password,password_length_min,password_length_max){

			var errors = "" ;
			var len_two=len.value.length;
				var allowed_spl_char_in_password1=decodeURIComponent(allowed_spl_char_in_password,'UTF-8');
		allowed_spl_char_in_password1 = allowed_spl_char_in_password1.replace("+",'')
			if (len_two <password_length_min)
				{
					errors = getMessage('PWD_MIN_CH','SM');
					errors=errors.replace("#",password_length_min);
					alert(errors);
					len.focus();
							
				}
				else if (len_two >password_length_max)
				{
					errors = getMessage('PWD_MAX_CH','SM');
					errors=errors.replace("#",password_length_max);
					alert(errors);
					len.focus();
							
				}
				else{
				
				if(enforce_password_policy_yn=='Y')
					{
					ChkPWSplChar(len,allowed_spl_char_in_password1);
					}
				
				}
			}
		
	function checkPassword() {
		var current_password	= change_password_form.current_password.value ;

		var old_password		= change_password_form.old_password.value ;

		var new_password1		= change_password_form.new_password1.value ;

		var new_password2		= change_password_form.new_password2.value ;
		var password_length_min		= change_password_form.password_length_min.value ;
		var password_length_max		= change_password_form.password_length_max.value ;
		var case_sensitive_password_yn		= change_password_form.case_sensitive_password_yn.value ;
		

		var errors			= "" ;
		var result			= true ;
		//Maheshwaran added for the MMS-QH-CRF-0149 
		if(case_sensitive_password_yn=='N')
			{
			old_password=old_password.toUpperCase();
			current_password=current_password.toUpperCase();
			}

		if ( current_password != old_password ) {
           
			errors=getMessage('INCORRECT_OLD_PW','SM');
			alert(errors)
			return false ;
		}

		if ( new_password1 != new_password2 ) {
			
			errors=getMessage('CONF_PASS_NOT_SAME_AS_NEW_PASS','SM');
		    alert(errors)
			return false ;
		}

		if ( new_password1.length < password_length_min ) {
			
			errors = getMessage('PWD_MIN_CH','SM');
			errors=errors.replace("#",password_length_min);
			alert(errors)
			return false ;
		}
		if ( new_password1.length > password_length_max ) {
			
			errors = getMessage('PWD_MAX_CH','SM');
			errors=errors.replace("#",password_length_max);
			alert(errors)
			return false ;
		}
		if ( current_password.length < password_length_min ) {
			
			errors = getMessage('PWD_MIN_CH','SM');
			errors=errors.replace("#",password_length_min);
			alert(errors)
			return false ;
		}
		if ( current_password.length > password_length_max ) {
			
			errors = getMessage('PWD_MAX_CH','SM');
			errors=errors.replace("#",password_length_max);
			alert(errors)
			return false ;
		}

		if ( current_password == new_password1 || current_password == new_password2 ) {
			
			errors = getMessage('OLD_NEW_PW_SAME','SM');
			alert(errors)
			return false ;
		}

		//if ( result )
		//{			
				
				document.change_password_form.submit() ;
		//}
		//else
		//	alert( errors ) ;

		//return result ;
	}


	function cancelClose()
	{
		//parent.window.close();
		//parent.window.returnValue = 'F';
		let dialogBody = parent.parent.document.getElementById('dialog-body');
		dialogBody.contentWindow.returnValue = 'F';
		const dialogTag = parent.parent.document.getElementById("dialog_tag");    
        dialogTag.close();
	}
	//Maheshwaran added for the MMS-QH-CRF-0149
function ChkPWSplChar(obj,allowed_spl_char_in_password)
	{
	var value = obj.value;
	allowed_spl_char_in_password=decodeURIComponent(allowed_spl_char_in_password,'UTF-8');
	allowed_spl_char_in_password = allowed_spl_char_in_password.replace("+",'')
	var paswd1=/^[a-zA-Z](?=.*[0-9])/;
	var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
	strCheck= strCheck.concat(allowed_spl_char_in_password);
	var strCheck1 = 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
	var paswd4=/^[a-zA-Z]*$/;
	if(obj.value.match(paswd1))
		{
		for (var i = 0; i < value.length; i++) 
			{
			if (strCheck.indexOf(value.charAt(i)) == -1) 
				{
				alert(getMessage('PASSWORD_POLICY','SM').concat(" "+allowed_spl_char_in_password));
				obj.value="";
				obj.focus();
				return false;
				}
					
			}
		}
	else if(value.match(paswd4))
		{
		if (allowed_spl_char_in_password.indexOf(value.charAt(i)) == -1) 
			{
			alert(getMessage('PASSWORD_POLICY','SM').concat(" "+allowed_spl_char_in_password));
			obj.value="";
			obj.focus();
			return false;
			}
		}
	else
		{
		for (var i = 0; i < value.length; i++) 
			{
			if (strCheck1.indexOf(value.charAt(i)) == -1) 
				{
				if (allowed_spl_char_in_password.indexOf(value.charAt(i)) != -1) 
					{
					if(value.indexOf(value.charAt(i))==0)
						{
						alert(getMessage('PASSWORD_POLICY','SM').concat(" "+allowed_spl_char_in_password));
						obj.value="";
						obj.focus();
						return false;
						}
					}
				if (allowed_spl_char_in_password.indexOf(value.charAt(i)) == -1) 
					{
					alert(getMessage('PASSWORD_POLICY','SM').concat(" "+allowed_spl_char_in_password));
					obj.value="";
					obj.focus();
					return false;
					}
				}
			}
		
		}
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
	String current_user=request.getParameter("ecis_jdbc_user");
	String startup_db_driver=request.getParameter("startup_db_driver");
	String startup_connect_string=request.getParameter("startup_connect_string");
	String startup_user=request.getParameter("startup_user");
	String startup_password=request.getParameter("startup_password");
	//Added by Maheshwaran K for the Password Validation as on 11/07/2012
	//Start
	//Maheshwaran added for the MMS-QH-CRF-0149
	String ENFORCE_PASSWORD_POLICY_YN="";
	String CASE_SENSITIVE_PASSWORD_YN="";
	String ALLOWED_SPL_CHAR_IN_PASSWORD="";
	int PASSWORD_LENGTH_MIN=0;
	int PASSWORD_LENGTH_MAX=0;
	//End
	String current_password	 = "" ;
	Connection con						=null;
	ResultSet rs1=null;
	PreparedStatement pstmt = null;
	try
		{
	Class.forName( startup_db_driver ) ;
	con = DriverManager.getConnection( startup_connect_string, startup_user, startup_password ) ;
	//Maheshwaran added for the MMS-QH-CRF-0149	
	try
		{
		if(rs1!=null)rs1.close();
		pstmt	 = con.prepareStatement("select ENFORCE_PASSWORD_POLICY_YN,CASE_SENSITIVE_PASSWORD_YN,ALLOWED_SPL_CHAR_IN_PASSWORD,PASSWORD_LENGTH_MIN,PASSWORD_LENGTH_MAX from sm_site_param");
		rs1=pstmt.executeQuery();
		if(rs1.next())
			{
			ENFORCE_PASSWORD_POLICY_YN=rs1.getString("ENFORCE_PASSWORD_POLICY_YN");
			CASE_SENSITIVE_PASSWORD_YN=rs1.getString("CASE_SENSITIVE_PASSWORD_YN");
			ALLOWED_SPL_CHAR_IN_PASSWORD=rs1.getString("ALLOWED_SPL_CHAR_IN_PASSWORD");
			PASSWORD_LENGTH_MIN=rs1.getInt("PASSWORD_LENGTH_MIN");
			PASSWORD_LENGTH_MAX=rs1.getInt("PASSWORD_LENGTH_MAX");
			}
		if(pstmt!=null)pstmt.close();	
		if(rs1!=null)rs1.close();	
		}
	catch(Exception e)	
		{
		System.out.println("Exception in sm_site_param : "+e);
		}
	if(pstmt!=null)pstmt.close();		
	pstmt	 = con.prepareStatement( "select app_password.decrypt( appl_user_password ) as password from sm_appl_user where appl_user_id = ?" ) ;	
	pstmt.setString( 1, current_user ) ;
	ResultSet rs = pstmt.executeQuery() ;
	if ( rs != null && rs.next() )
	current_password = rs.getString( "password" ) ;
	if(CASE_SENSITIVE_PASSWORD_YN.equals("N"))	
		{
		current_password=current_password.toUpperCase();
		}
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	
	
%>

<body class="CONTENT"  OnMouseDown='CodeArrest()' ; onKeyDown = 'lockKey()';  onLoad="window.document.title='Change Password';">
<center>

	<table width="100%">
		<tr class="HEADER">
			<td class="HEADER" valign="top" width="10%">
				<img src="../../eCommon/images/orgLogo.gif" vspace=0 hspace=0>
			</td>

			<td class="HEADER" valign="top" width="65%">
			
			</td>

			<td class="HEADER" valign="top" width="15%">
				<font size="-1">
					<b>
					<%
						java.text.SimpleDateFormat dateformat = new java.text.SimpleDateFormat( "dd/MM/yyyy" ) ;
						out.println( dateformat.format( new java.util.Date() ) ) ;
					%>
					</b>
				</font>
			</td>
		</tr>
	</table>

	<h3><fmt:message key="Common.changepassword.label" bundle="${common_labels}"/></h3>

	<form name="change_password_form" id="change_password_form" method="post" action="../../servlet/eSM.ChangePasswordServletLogin">
		<table width="90%" cellpadding='0' cellspacing='0'>
			<tr><td colspan='2'>&nbsp;</td></tr>

			<tr>
				<td width='50%' class='label'>
					<fmt:message key="Common.userid.label" bundle="${common_labels}"/>
				</td>
				<td>&nbsp;
					<input type="text" name="user" id="user" value="<%= current_user %>" readonly>
				</td>
			</tr>

			<tr>
				<td class='label'>
					<fmt:message key="Common.oldPassword.label" bundle="${common_labels}"/>
				</td>
				<td>&nbsp;
					<input type="password" name="old_password" id="old_password" maxlength=10>
				</td>
			</tr>

			<tr>
				<td class='label'>
					<fmt:message key="Common.newPassword.label" bundle="${common_labels}"/>
				</td>
				<td>&nbsp;
					<input type="password" name="new_password1" id="new_password1" maxlength="10" onChange="checkLen_1(this,'<%=ENFORCE_PASSWORD_POLICY_YN%>','<%=java.net.URLEncoder.encode(ALLOWED_SPL_CHAR_IN_PASSWORD)%>',<%=PASSWORD_LENGTH_MIN%>,<%=PASSWORD_LENGTH_MAX%>);" onkeypress='checkMaxLimit(this,10)' onBlur="" onKeyUp="CheckOneSpecialChar(this,'<%=ENFORCE_PASSWORD_POLICY_YN%>','<%=java.net.URLEncoder.encode(ALLOWED_SPL_CHAR_IN_PASSWORD)%>');CheckForNumber(this)">
				</td>
			</tr>

			<tr>
				<td class='label'  >
					<fmt:message key="eSM.ReenterNewPassword.label" bundle="${sm_labels}"/>
				</td>
				<td>&nbsp;
					<input type="password" name="new_password2" id="new_password2" maxlength="10" onBlur="" onChange="checkLen_2(this,'<%=ENFORCE_PASSWORD_POLICY_YN%>','<%=java.net.URLEncoder.encode(ALLOWED_SPL_CHAR_IN_PASSWORD)%>',<%=PASSWORD_LENGTH_MIN%>,<%=PASSWORD_LENGTH_MAX%>);" onkeypress='checkMaxLimit(this,10)' onKeyUp="CheckOneSpecialChar(this,'<%=ENFORCE_PASSWORD_POLICY_YN%>','<%=java.net.URLEncoder.encode(ALLOWED_SPL_CHAR_IN_PASSWORD)%>');CheckForNumber(this)">
				</td>
			</tr>

			<tr><td colspan='2'>&nbsp;</td></tr>
			<%if(ENFORCE_PASSWORD_POLICY_YN.equals("Y")) {%>
			<tr>
			 <td colspan='3' class='label' style='color:red'><b><fmt:message key="eSM.PASSWORD_POLICY.label" bundle="${sm_labels}"/></b>&nbsp;<fmt:message key="eSM.PASSWORD_POLICY1.label" bundle="${sm_labels}"/>&nbsp;<%=ALLOWED_SPL_CHAR_IN_PASSWORD%></td>
			</tr>
			<%}%>
		</table>

		<br>

		<input type="hidden" name="current_password" id="current_password" value="<%= current_password %>">
		<input type="hidden" name="current_user" id="current_user" value="<%= current_user %>">
		<input type="hidden" name="startup_db_driver" id="startup_db_driver" value="<%= startup_db_driver %>">
		<input type="hidden" name="startup_connect_string" id="startup_connect_string" value="<%= startup_connect_string %>">
		<input type="hidden" name="startup_user" id="startup_user" value="<%= startup_user %>">
		<input type="hidden" name="startup_password" id="startup_password" value="<%= startup_password %>">
		<input type='button' class='BUTTON' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>' onClick='checkPassword();'> &nbsp;&nbsp;&nbsp;&nbsp;
		<input type='button' class='BUTTON' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' onClick="cancelClose();">
		<input type='hidden' name='allowed_spl_char_in_password' id='allowed_spl_char_in_password' value='<%=java.net.URLEncoder.encode(ALLOWED_SPL_CHAR_IN_PASSWORD)%>'>
		<input type='hidden' name='enforce_password_policy_yn' id='enforce_password_policy_yn' value='<%=ENFORCE_PASSWORD_POLICY_YN%>'>
		<input type='hidden' name='case_sensitive_password_yn' id='case_sensitive_password_yn' value='<%=CASE_SENSITIVE_PASSWORD_YN%>'>	
		<input type='hidden' name='password_length_min' id='password_length_min' value=<%=PASSWORD_LENGTH_MIN%>>	
		<input type='hidden' name='password_length_max' id='password_length_max' value=<%=PASSWORD_LENGTH_MAX%>>	

	</form>
</center>
</body>

	<% }
	catch(Exception e){out.println("Error "+e);}
	finally {
		if(pstmt!=null) pstmt.close();
	if(con != null) con.close();
	

	}
	%>


