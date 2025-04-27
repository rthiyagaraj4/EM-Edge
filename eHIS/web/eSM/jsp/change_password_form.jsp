<!DOCTYPE html>

<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<head>
<%
		  request.setCharacterEncoding("UTF-8");
          String sStyle	=
          (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<%
		String mainyn = request.getParameter("main")==null?"":request.getParameter("main");
%>
<script language="JavaScript">
function CheckForSpecCharsforID(event){
	//if(document.getElementById('changepwdfor').value!='L'){
		var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_';
		var whichCode = (window.Event) ? event.which : event.keyCode;
		key = String.fromCharCode(whichCode);  // Get key value from key code
		if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
		if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
		return true ;
//	}
}
//Maheshwaran modified for the MMS-QH-CRF-0149
function CheckSpecialChar(obj,enforce_password_policy_yn,allowed_spl_char_in_password)
{
	var fieldval = obj.value;
	var fieldlen = fieldval.length;
	var to_check = true;
	var SpChar = new Array();
	var allowed_spl_char_in_password1=decodeURIComponent(allowed_spl_char_in_password,'UTF-8');
	allowed_spl_char_in_password1 = allowed_spl_char_in_password1.replace("+",'');
	var changepwdfor=document.change_password_form.changepwdfor.value;	
	//Maheshwaran added for the MMS-QH-CRF-0149
	if((enforce_password_policy_yn=='Y')&&(changepwdfor=='L'))
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
		if((enforce_password_policy_yn=='Y')&&(changepwdfor=='L'))
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
		if((enforce_password_policy_yn=='Y')&&(changepwdfor=='L'))
			{
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

	
	function checkLen_1(Obj) {
			/*var errors = "" ;
			var len_one=Obj.value.length;
			if (len_one <5)
				{
					errors = getMessage('PWD_MIN_FIVE_CH') ;
					alert(errors);
					Obj.focus();
							
				}
				else if (len_one >20)
				{
					errors = getMessage('PW_EXCEED_MAX_LENGTH') ;
					alert(errors);
					Obj.focus();
							
				}			
				else {
				
						
				}*/
			}
		
function checkLen_2(len)
{
			/*var errors = "" ;
			var len_two=len.value.length;
			if (len_two <5)
				{
					errors = getMessage('PWD_MIN_FIVE_CH') ;
					alert(errors);
					len.focus();
							
				}
				else if (len_two >20)
				{
					errors = getMessage('PW_EXCEED_MAX_LENGTH') ;
					alert(errors);
					len.focus();
							
				}
				else{}*/
}
		
	
	
function enableDisableValues(obj){

/*if(obj.value=="A")
{

change_password_form.old_password.readOnly=true
change_password_form.document.getElementById("oldpwd").style.visibility="hidden"
change_password_form.old_password.value ="";;
change_password_form.new_password1.value="" ;
change_password_form.new_password2.value ="";

}else
{*/
change_password_form.old_password.readOnly=false
change_password_form.document.getElementById("oldpwd").style.visibility="visible"
change_password_form.old_password.value ="";;
change_password_form.new_password1.value="" ;
change_password_form.new_password2.value ="";

/*}*/
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
function spl_char_legend(obj,enforce_password_policy_yn)
	{
	if((obj.value=='L')&&(enforce_password_policy_yn=='Y'))
	document.getElementById('spl_char_legend_display').style.display  = '';
	else
	document.getElementById('spl_char_legend_display').style.display  = 'none';
	}	
function ChangeUpperCase1(obj,change_pw)
		{
		if(change_pw.value!='L')
			{
			ChangeUpperCase(obj);
			}
		}
	//End
</script>

</head>

<%
	String current_user	 = (String) session.getAttribute( "login_user" ) ;
	String facility_id	 = (String) session.getAttribute( "facility_id" ) ;
	String locale	=	(String)session.getAttribute("LOCALE");

	//Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2 
	String login_user_type = (String)session.getAttribute("login_user_type")==null?"":(String)session.getAttribute("login_user_type");

	String current_password	 = "" ;
	String pinpwd="";
    String disppas="";
    String senpass="";
    String hrpass="";
	String ph_install_yn = "";
	int senCnt=0;
	int mrCnt=0;
	int phCnt=0;
	Connection con =null;
	PreparedStatement pstmt = null;
    ResultSet rs = null;
	//Added by Maheshwaran K for the Password Validation as on 11/07/2012
	//Start
	//Maheshwaran added for the MMS-QH-CRF-0149
	String ENFORCE_PASSWORD_POLICY_YN="";
	String CASE_SENSITIVE_PASSWORD_YN="";
	String ALLOWED_SPL_CHAR_IN_PASSWORD="";
	int PASSWORD_LENGTH_MIN=0;
	int PASSWORD_LENGTH_MAX=0;
	//End
	String RESP_GROUP_ID = "";
	//end
	try{
	con = ConnectionManager.getConnection(request);

	pstmt							= con.prepareStatement("select install_yn from sm_module where module_id='PH' ");
	rs								= pstmt.executeQuery();
	while(rs!=null  && rs.next())
	{
				ph_install_yn		= rs.getString(1);
	}
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	//Maheshwaran added for the MMS-QH-CRF-0149	
	try
		{
		if(rs!=null)rs.close();
		pstmt	 = con.prepareStatement("select ENFORCE_PASSWORD_POLICY_YN,CASE_SENSITIVE_PASSWORD_YN,ALLOWED_SPL_CHAR_IN_PASSWORD,PASSWORD_LENGTH_MIN,PASSWORD_LENGTH_MAX from sm_site_param");
		rs=pstmt.executeQuery();
		if(rs.next())
			{
			ENFORCE_PASSWORD_POLICY_YN=rs.getString("ENFORCE_PASSWORD_POLICY_YN");
			CASE_SENSITIVE_PASSWORD_YN=rs.getString("CASE_SENSITIVE_PASSWORD_YN");
			ALLOWED_SPL_CHAR_IN_PASSWORD=rs.getString("ALLOWED_SPL_CHAR_IN_PASSWORD");
			PASSWORD_LENGTH_MIN=rs.getInt("PASSWORD_LENGTH_MIN");
			PASSWORD_LENGTH_MAX=rs.getInt("PASSWORD_LENGTH_MAX");
			}
		if(pstmt!=null)pstmt.close();	
		if(rs!=null)rs.close();	
		}
	catch(Exception e)	
		{
		System.out.println("Exception in sm_site_param : "+e);
		}
	//"ORA_RSRC_GROUP_ID" was added in the query by Maheshwaran K for the Password Validation as on 11/07/212
	//pstmt	 = con.prepareStatement( "select UPPER(app_password.decrypt( appl_user_password )) as password ,UPPER(app_password.decrypt(pin_no)) as pinpwd,ORA_RSRC_GROUP_ID  from sm_appl_user where appl_user_id = ?" ) ;
	try{
	pstmt	 = con.prepareStatement( "select app_password.decrypt( appl_user_password ) as password ,UPPER(app_password.decrypt(pin_no)) as pinpwd,ORA_RSRC_GROUP_ID  from sm_appl_user where appl_user_id = ?" ) ;
	pstmt.setString( 1, current_user ) ;
	rs = pstmt.executeQuery() ;
	
	if ( rs != null && rs.next() )
		{
		current_password = rs.getString( "password" ) ==null?"":rs.getString( "password" );
		pinpwd = rs.getString( "pinpwd" )==null?"":rs.getString( "pinpwd" );
		//Added by Maheshwaran K for the Password Validation as on 11/07/2012
		//Start
		RESP_GROUP_ID = rs.getString( "ORA_RSRC_GROUP_ID" )==null?"":rs.getString( "ORA_RSRC_GROUP_ID" );
		//End
		}
	if(CASE_SENSITIVE_PASSWORD_YN.equals("N"))	
		{
		current_password=current_password.toUpperCase();
		}
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	
   }
   catch(Exception e)
	{}
	
	pstmt	 = con.prepareStatement("SELECT COUNT(*) senCnt FROM MR_USER_ACCESS_RIGHTS WHERE FACILITY_ID=?  and  APPL_USER_ID=? and SEN_DIAG_PASSWORD IS NOT NULL") ;
	pstmt.setString( 1, facility_id ) ;
	pstmt.setString( 2, current_user ) ;
	rs = pstmt.executeQuery() ;
	rs.next();
	senCnt = rs.getInt( "senCnt" ) ;
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	if(senCnt>0)
	{
	pstmt	 = con.prepareStatement("select  UPPER(APP_PASSWORD.DECRYPT(SEN_DIAG_PASSWORD)) as senpass  from MR_USER_ACCESS_RIGHTS where FACILITY_ID=? AND APPL_USER_ID=?");
	pstmt.setString( 1, facility_id ) ;
	pstmt.setString( 2, current_user ) ;
	rs = pstmt.executeQuery() ;
	if ( rs != null && rs.next() )
	senpass = rs.getString("senpass" )==null?"":rs.getString( "senpass" ) ;
	
	}
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();


    pstmt	 = con.prepareStatement("SELECT COUNT(*) mrCnt FROM MR_USER_ACCESS_RIGHTS WHERE FACILITY_ID=?  and APPL_USER_ID=? and HIGH_RISK_PASSWORD IS NOT NULL") ;
	pstmt.setString( 1, facility_id ) ;
	pstmt.setString( 2, current_user ) ;
	rs = pstmt.executeQuery() ;
	rs.next();
	mrCnt = rs.getInt("mrCnt") ;
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();

   if(mrCnt>0)
	{
    pstmt	 = con.prepareStatement("select   UPPER(APP_PASSWORD.DECRYPT(HIGH_RISK_PASSWORD)) as hrpass  from MR_USER_ACCESS_RIGHTS where FACILITY_ID=? AND APPL_USER_ID=?");
	pstmt.setString( 1, facility_id ) ;
	pstmt.setString( 2, current_user ) ;
	 rs = pstmt.executeQuery() ;
	
	if ( rs != null && rs.next() )
	hrpass=  rs.getString( "hrpass" )==null?"": rs.getString( "hrpass" );
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	
	}
    if (ph_install_yn.equals("Y"))
	{
		pstmt	 = con.prepareStatement("select count(*) phCnt from PH_DISP_USERS WHERE   APPL_USER_ID=? ") ;
		pstmt.setString( 1, current_user ) ;
		rs = pstmt.executeQuery() ;
		rs.next();
		phCnt = rs.getInt("phCnt") ;
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(phCnt>0)
		{
		
		 pstmt	 = con.prepareStatement( "select  UPPER(APP_PASSWORD.DECRYPT(DISP_PASSWORD)) as disppas from PH_DISP_USERS where APPL_USER_ID=?" ) ;
		 pstmt.setString( 1, current_user ) ;
		 rs = pstmt.executeQuery() ;
		 if ( rs != null && rs.next() )
		 disppas = rs.getString( "disppas" )==null?"":rs.getString( "disppas" ) ;
		 if(rs!=null) rs.close();
		 if(pstmt!=null) pstmt.close();
			
		}
	}
	
%>

<body  class="CONTENT" onLoad="" onKeyDown = 'lockKey()'>
<center>

	<table width="100%">
		<tr class="HEADER">
			<td class="HEADER" valign="top" width="10%">
				<!-- <img src="../../eCommon/images/orgLogo.gif" vspace=0 hspace=0> -->
				<img src="../../eCommon/jsp/DisplayImages.jsp?param=clientlogo" width="40" height="40">
			</td>

			<td class="HEADER" valign="top" width="65%">
				<font size="-1"><b>					
					<%= java.net.URLDecoder.decode(((String) session.getAttribute( "facility_name" )==null?"":(String) session.getAttribute( "facility_name" )))  %>
				</b></font>
			</td>

			<td class="HEADER" valign="top" width="15%">
				<font size="-1">
					<b>
					<%
						java.text.SimpleDateFormat dateformat = new java.text.SimpleDateFormat( "dd/MM/yyyy" ) ;
						out.println(DateUtils.convertDate(dateformat.format( new java.util.Date()),"DMY","en",locale)) ;
					%>
					</b>
				</font>
			</td>
		</tr>
	</table>

	

	<form name="change_password_form" id="change_password_form" method="post" action="../../servlet/eSM.ChangePasswordServlet">
		<table width="90%" cellpadding='0' cellspacing='0'>
			<!-- <tr><td colspan='2'>&nbsp;</td></tr> -->

			<tr>
				<td width='50%' class='label'>
					<fmt:message key="Common.userid.label" bundle="${common_labels}"/>		
				</td>
				<td>&nbsp;
					<input type="text" name="user" id="user" value="<%= current_user %>" readonly>
				</td>
			</tr>
              
       		<tr>
			<td width='50%' class='label'>
			<fmt:message key="Common.changePasswordFor.label" bundle="${common_labels}"/>
			</td>
			<td>&nbsp;
			<!--Maheshwaran modified for the MMS-QH-CRF-0149-->
			<SELECT name="changepwdfor" id="changepwdfor" onChange="enableDisableValues(this); spl_char_legend(this,'<%=ENFORCE_PASSWORD_POLICY_YN%>')" > 
			<option>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
			
			<!--Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2-->
			<%if(!login_user_type.equals("AD")){%>
			<option value='L'><fmt:message key="Common.login.label" bundle="${common_labels}"/></option>	
			<%}%>

			<option value='P'><fmt:message key="Common.PIN.label" bundle="${common_labels}"/></option>	
			<%if(senCnt>0)
		    {%>
	         <option value='S'><fmt:message key="Common.SensitiveDiagnosis.label" bundle="${common_labels}"/></option>	
		    <%}%>
			<%if(mrCnt>0)
		    {%>
	         <option value='H'><fmt:message key="Common.HighRiskConditions.label" bundle="${common_labels}"/></option>	
		    <%}%>
			
			<%if(phCnt>0)
		    {%>
	         <option value='PH'><fmt:message key="Common.Dispensing.label" bundle="${common_labels}"/></option>	
		    <%}%>
			
			</SELECT>&nbsp;<img src="../../eCommon/images/mandatory.gif" align="center"></img>
			</td>
			</tr>


			<tr>
				<td class='label'>
					<fmt:message key="Common.oldPassword.label" bundle="${common_labels}"/>
				</td>
				<td>&nbsp;
					<input type="password" name="old_password" id="old_password" onBlur='ChangeUpperCase1(this,changepwdfor)' readOnly maxlength=20 >&nbsp;<img src="../../eCommon/images/mandatory.gif" id='oldpwd' style="visibility:hidden"align="center">
				</td>
			</tr>

			<tr>
				<td class='label'>
					<fmt:message key="Common.newPassword.label" bundle="${common_labels}"/>
				</td>
				<!--Maheshwaran K modified for the MMS-QH-CRF-0149-->
				<td>&nbsp;
					<input type="password" name="new_password1" id="new_password1" maxlength="20" onChange="<%if(ENFORCE_PASSWORD_POLICY_YN.equals("Y")){%> if(document.change_password_form.changepwdfor.value=='L'){ ChkPWSplChar(this,'<%=java.net.URLEncoder.encode(ALLOWED_SPL_CHAR_IN_PASSWORD)%>')}<%}%>" onkeypress='return checkMaxLimit(this,20)' onBlur="" onKeyUp=" if(document.change_password_form.changepwdfor.value=='L'){ CheckSpecialChar(this,'<%=ENFORCE_PASSWORD_POLICY_YN%>', '<%=java.net.URLEncoder.encode(ALLOWED_SPL_CHAR_IN_PASSWORD)%>'); CheckForNumber(this);}">&nbsp;<img src="../../eCommon/images/mandatory.gif" id='newpwd' align="center">

					<!--input type="password" name="new_password1" maxlength="20" onChange="checkLen_1(this)" onkeypress='return checkMaxLimit(this,20)' onBlur="" onKeyUp="CheckSpecialChar(this);CheckForNumber(this)">&nbsp;<img src="../../eCommon/images/mandatory.gif" id='newpwd' align="center"-->
				</td>
			</tr>

			<tr>
				<td class='label'  onChange='checkLen_2(this)' onkeypress='checkMaxLimit(this,20)'>
					<fmt:message key="Common.reEnterNewPassword.label" bundle="${common_labels}"/>
				</td>
				<!--Maheshwaran K modified for the MMS-QH-CRF-0149-->
				<td>&nbsp;
					<input type="password" name="new_password2" id="new_password2" maxlength="20" onBlur="" onChange="<%if(ENFORCE_PASSWORD_POLICY_YN.equals("Y")){%> if(document.change_password_form.changepwdfor.value=='L'){ ChkPWSplChar(this,'<%=java.net.URLEncoder.encode(ALLOWED_SPL_CHAR_IN_PASSWORD)%>')}<%}%>" onkeypress='return checkMaxLimit(this,20)' onKeyUp=" if(document.change_password_form.changepwdfor.value=='L'){ CheckSpecialChar(this,'<%=ENFORCE_PASSWORD_POLICY_YN%>','<%=java.net.URLEncoder.encode(ALLOWED_SPL_CHAR_IN_PASSWORD)%>'); CheckForNumber(this); }">&nbsp;<img src="../../eCommon/images/mandatory.gif"  id='retypwd'align="center">

					<!--input type="password" name="new_password2" maxlength="20" onBlur="" onkeypress='return checkMaxLimit(this,20)' onKeyUp="CheckSpecialChar(this);CheckForNumber(this)">&nbsp;<img src="../../eCommon/images/mandatory.gif"  id='retypwd'align="center"-->
				</td>
			</tr>

			<tr><td colspan='2'>&nbsp;</td></tr>
			<tr id='spl_char_legend_display' style='display:none'>
			 <td colspan='3' class='label' style='color:red'><b><fmt:message key="eSM.PASSWORD_POLICY.label" bundle="${sm_labels}"/></b>&nbsp;<fmt:message key="eSM.PASSWORD_POLICY1.label" bundle="${sm_labels}"/>&nbsp;<%=ALLOWED_SPL_CHAR_IN_PASSWORD%></td>
			</tr>
			</table>

		<br>

		<input type="hidden" name="current_password1" id="current_password1" value="<%= current_password%>">
		<input type="hidden" name="current_password" id="current_password" value="">
		<input type="hidden" name="main_yn" id="main_yn" value="<%=mainyn%>">
	   
		<input type="hidden" name="senpwd" id="senpwd" value="<%=senpass%>">
		<input type="hidden" name="hrpwd" id="hrpwd" value="<%=hrpass%>">
		<input type="hidden" name="pinpwd" id="pinpwd" value="<%=pinpwd%>">
        <input type="hidden" name="disppwd" id="disppwd" value="<%=disppas%>"> 

		<input type="hidden" name="phCnt" id="phCnt" value="<%=phCnt%>">
		<input type="hidden" name="mrCnt" id="mrCnt" value="<%=mrCnt%>">
		<input type="hidden" name="senCnt" id="senCnt" value="<%=senCnt%>">
		<input type="hidden" name="ph_install_yn" id="ph_install_yn" value="<%=ph_install_yn%>">
		<!--	//Maheshwaran added for the MMS-QH-CRF-0149-->
		<!--Start-->
		<input type='hidden' name='allowed_spl_char_in_password' id='allowed_spl_char_in_password' value='<%=java.net.URLEncoder.encode(ALLOWED_SPL_CHAR_IN_PASSWORD)%>'>
		<input type='hidden' name='enforce_password_policy_yn' id='enforce_password_policy_yn' value='<%=ENFORCE_PASSWORD_POLICY_YN%>'>
		<input type='hidden' name='case_sensitive_password_yn' id='case_sensitive_password_yn' value='<%=CASE_SENSITIVE_PASSWORD_YN%>'>
		<!--<input type='hidden' name='password_length_min' id='password_length_min' value=''>	
		<input type='hidden' name='password_length_max' id='password_length_max' value=''>-->
		<!--End-->
		<!--Added by Maheshwaran K for the Password Validation as on 11/07/2012
		Start-->
		<input type="hidden" name="resp_group_id" id="resp_group_id" value="<%=RESP_GROUP_ID%>">
		<!--End-->
		<input type='button' class='BUTTON' value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick='checkPassword()'>&nbsp;&nbsp;
		<input type='button' class='BUTTON' value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onClick="cancelClose()">
<script>
			
	function checkPassword() {
	//	var current_password	= change_password_form.current_password.value ;
		var current_password1	= change_password_form.current_password1.value ;
		var old_password		= change_password_form.old_password.value ;
		var new_password1		= change_password_form.new_password1.value ;
		var new_password2		= change_password_form.new_password2.value ;
	//	var password_length_min		= change_password_form.password_length_min.value ;//Maheshwaran added for the MMS-QH-CRF-0149
	//	var password_length_max		= change_password_form.password_length_max.value ;//Maheshwaran added for the MMS-QH-CRF-0149
		var case_sensitive_password_yn=change_password_form.case_sensitive_password_yn.value ;//Maheshwaran added for the MMS-QH-CRF-0149
		var changepwdfor=change_password_form.changepwdfor.value ;
        var phpwd =change_password_form.disppwd.value ;
        var senpwd=change_password_form.senpwd.value ;
        var hrpwd =change_password_form.hrpwd.value ;
        var pinpwd=change_password_form.pinpwd.value ;

		var errors			= "" ;
		var result			= true ;

		if(changepwdfor=="")
		{
		alert(getMessage('CHANGE_PWD_SELECT','SM'))
		return false;
		}else if(changepwdfor=="A")
		{
           	
		if(new_password1==""||new_password2=="")
		{
		alert(getMesage('ENTER_PWD','SM'))
		return false;
		}

		
		if ( new_password1.toUpperCase() != new_password2.toUpperCase() ) {
		    
			errors=getMessage('CONF_PASS_NOT_SAME_AS_NEW_PASS','SM');
			alert(errors)
			return false;
			///result = false ;
		}

		if ( new_password1.length < 5 ) {
			
			errors=getMessage('MIN_LENGTH_5_CH','SM');
			alert(errors)
			return false;
		}
		if ( new_password1.length > 20 ) {
			
			errors=getMessage('MAX_LENGTH_5_CH','SM');
			errors=errors.replace("5","10");
			alert(errors)
			return false;
		}
		
		 if('<%=mainyn%>' == 'N')
			{
				var html = "<html><body onKeyDown = 'lockKey()'><form name='dummyForSubmit' id='dummyForSubmit'  action='../../servlet/eSM.ChangePasswordServlet' method='post'>";
				for(var i=0;i<document.change_password_form.elements.length;i++)
				{
					var n = document.change_password_form.elements(i).name;
					var v = document.change_password_form.elements(i).value;
					html += "<input type=hidden name="+n+" id="+n+" value="+v+">";
				}
				html+="</form></body></html>";
				parent.frames[1].document.body.insertAdjacentHTML("AfterBegin",html);
				parent.frames[1].document.dummyForSubmit.submit();
			}
			else
				document.change_password_form.submit() ;
		


		
		}else
			{

		                             
		 if(changepwdfor=='L')         
		{  
		//Maheshwaran added for the MMS-QH-CRF-0149 
		if(case_sensitive_password_yn=='N')
			{
			old_password=old_password.toUpperCase();
			current_password1=current_password1.toUpperCase();
			}
		current_password=current_password1  
		change_password_form.current_password.value =current_password;
		
		}else if (changepwdfor=='P')
		{
		current_password=pinpwd
		change_password_form.current_password.value =current_password;
		}
		else if (changepwdfor=='S')
		{
		current_password=senpwd;
		change_password_form.current_password.value =current_password;
		}
		else if (changepwdfor=='H')
		{
		current_password=hrpwd;
		change_password_form.current_password.value =current_password;
		}else if (changepwdfor=='PH')
		{
		current_password=phpwd;
		change_password_form.current_password.value =current_password;
		}
		
		if ( current_password != old_password ) {

			errors=getMessage('INCORRECT_OLD_PW','SM');
			alert(errors)
			return false;
		}

		if ( new_password1.toUpperCase() != new_password2.toUpperCase() ) {
			
			errors=getMessage('CONF_PASS_NOT_SAME_AS_NEW_PASS','SM');
			alert(errors)
			return false;
		}

		
		if(changepwdfor!='P')
				{
				if(changepwdfor=='L')
					{
					if ( new_password1.length < '<%=PASSWORD_LENGTH_MIN%>' ) {
						errors = getMessage('PWD_MIN_CH','SM');
						errors=errors.replace("#",'<%=PASSWORD_LENGTH_MIN%>');
						alert(errors)
						return false;
					}
					}
				else
					{		
					if ( new_password1.length < 5 ) {
						errors=getMessage('MIN_LENGTH_5_CH','SM');
						alert(errors)
						return false;
					}
					}
				}
		 
		 
		 if(changepwdfor=='L') 
				{
				if ( new_password1.length > '<%=PASSWORD_LENGTH_MAX%>' ) {
				errors = getMessage('PWD_MAX_CH','SM');
				errors=errors.replace("#",'<%=PASSWORD_LENGTH_MAX%>');
				alert(errors)
		       	return false;	
			   }
				//loginpwdlen=10
				}else
				{
				if ( new_password1.length >20) {
				errors=getMessage('PWD_MAX_20_CHAR','SM');
		       alert(errors)
		       	return false;	
			   }
			}
		/*if ( new_password1.length > 10 ) {
		
			errors=getMessage('MAX_LENGTH_10_CH');
		alert(errors)
			return false;		}*/
		if(changepwdfor!='P')
				{
				if(changepwdfor=='L')	
				{
				//Maheshwaran K commeneted this lines for BSP-SCF-0107 as on 28-04-2022
				/*	if ( current_password.length < password_length_min ) {
				errors = getMessage('PWD_MIN_CH','SM');
				errors=errors.replace("#",password_length_min);
				alert(errors)
				return false;
				}
				*/
				}
			else
				{	
				if( current_password.length < 5 ) {
				errors=getMessage('MIN_LENGTH_5_CH','SM');
				alert(errors)
				return false;
				}
				}
				}
		 if(changepwdfor=='L') 
		{
		if ( current_password.length >'<%=PASSWORD_LENGTH_MAX%>' ) {
		errors = getMessage('PWD_MAX_CH','SM');
		errors=errors.replace("#",'<%=PASSWORD_LENGTH_MAX%>');
		alert(errors)
		return false;
		}
		  		}else
			{
			if ( current_password.length >20 ) {
			
			errors=getMessage('MAX_LENGTH_10_CH','SM');
			alert(errors)
			return false;
		  }
			}
		
		if(changepwdfor=='L') 
			{
			if(case_sensitive_password_yn=='N')
				{
				if ( current_password.toUpperCase() == new_password1.toUpperCase() || current_password.toUpperCase() == new_password2.toUpperCase() ) 
					{
					errors = getMessage('OLD_NEW_PW_SAME','SM');
					alert(errors)
					return false;
					}
				}
			else
				{
				if (current_password == new_password1 || current_password == new_password2) 
					{
					errors = getMessage('OLD_NEW_PW_SAME','SM');
					alert(errors)
					return false;
					}
				}
			}
		else
			{
			if ( current_password.toUpperCase() == new_password1.toUpperCase() || current_password.toUpperCase() == new_password2.toUpperCase() ) 
				{
				errors = getMessage('OLD_NEW_PW_SAME','SM');
				alert(errors)
				return false;
				}
			}

		if ( result )
		{
			if('<%=mainyn%>' == 'N')
			{
				var html = "<html><body onKeyDown = 'lockKey()'><form name='dummyForSubmit' id='dummyForSubmit'  action='../../servlet/eSM.ChangePasswordServlet' method='post'>";
				for(var i=0;i<document.change_password_form.elements.length;i++)
				{
					var n = document.change_password_form.elements(i).name;
					var v = document.change_password_form.elements(i).value;
					html += "<input type=hidden name="+n+" id="+n+" value="+v+">";
				}
				html+="</form></body></html>";
				parent.frames[1].document.body.insertAdjacentHTML("AfterBegin",html);
				parent.frames[1].document.dummyForSubmit.submit();
			}
			else
				{
				document.change_password_form.submit() ;
				}
		}
		
	}
		

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
		
</script>
	</form>
</center>
</body>

	<% }catch(Exception e){out.println("Error "+e);}
	finally {
		if(pstmt!=null) pstmt.close();
	ConnectionManager.returnConnection(con,request);
	}
	%>


