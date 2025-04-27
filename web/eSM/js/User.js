var check;

function create() {
	f_query_add_mod.location.href = "../../eSM/jsp/User_Form.jsp" ;
}

function query() {
	  f_query_add_mod.location.href ="../../eSM/jsp/queryUserPage.jsp?function=user" ;
}
//Maheshwaran modified for the MMS-QH-CRF-0149
function CheckSpecialChar(obj,enforce_password_policy_yn,allowed_spl_char_in_password,func)
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
	else
		{
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
				if (fieldval.substr(i,1) == SpChar[j])
				{
					to_check = false;
				}
			}
			}
		else
			{
			for (var j=0;j<=31;j++)
			{
				if (fieldval.substr(i,1) == SpChar[j])
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
		else{
		if(func=='apply')
			{
			return false;
			}
		else
			{
			alert(getMessage('SPECIAL_CHARCTERS_NOT_ALLOWED','SM'));
			obj.value="";
			obj.focus();
			return false;
			}
		}
		obj.select();
		obj.focus();
		obj.value='';
	}
}
function apply()
{
	//Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2
	var isSSOIntegrationAppl = f_query_add_mod.document.user_form.isSSOIntegrationAppl.value;

	if(isSSOIntegrationAppl == 'true'){
		if(f_query_add_mod.document.user_form.appl_user_password.disabled == true)
			f_query_add_mod.document.user_form.appl_user_password.disabled = false;
		if(f_query_add_mod.document.user_form.appl_user_cpassword.disabled == true)
			f_query_add_mod.document.user_form.appl_user_cpassword.disabled = false;
	}

//Maheshwaran added for the MMS-QH-CRF-0149	
//Start
var enforce_password_policy_yn =f_query_add_mod.document.forms[0].enforce_password_policy_yn.value;
var password_length_min =f_query_add_mod.document.forms[0].password_length_min.value;
var password_length_max =f_query_add_mod.document.forms[0].password_length_max.value;
var proceed 	= new Boolean(true) ;
var proceed1 	= new Boolean(true) ;
if(enforce_password_policy_yn=='Y')
	{
	var allowed_spl_char_in_password =f_query_add_mod.document.forms[0].allowed_spl_char_in_password.value;
	var allowed_spl_char_in_password1=decodeURIComponent(allowed_spl_char_in_password,'UTF-8');
	allowed_spl_char_in_password1 = allowed_spl_char_in_password1.replace("+",'');
	proceed=ChkPWSplChar(f_query_add_mod.document.forms[0].appl_user_password,allowed_spl_char_in_password1,'apply');
	}
else
	{
	proceed1=CheckSpecialChar(f_query_add_mod.document.forms[0].appl_user_password,enforce_password_policy_yn,allowed_spl_char_in_password,'apply');	
	}
	
//End
 if(f_query_add_mod.document.forms[0]!=null)
 {
	var appl_user_password_len=f_query_add_mod.document.forms[0].appl_user_password.value.length;
	var appl_user_cpassword_len=f_query_add_mod.document.forms[0].appl_user_cpassword.value.length;
    f_query_add_mod.document.user_form.language.disabled = false;
				

		
		if (f_query_add_mod.document.user_form.function_name.value=="modify")
		{
			f_query_add_mod.document.user_form.role_type1.value=f_query_add_mod.document.user_form.role_type.value;
			f_query_add_mod.document.user_form.pract_type1.value=f_query_add_mod.document.user_form.pract_type.value;
			f_query_add_mod.document.user_form.pract_name1.value=f_query_add_mod.document.user_form.pract_name.value;
			f_query_add_mod.document.user_form.resp_group_id1.value=f_query_add_mod.document.user_form.resp_group_id.value;
			f_query_add_mod.document.user_form.responsibility_group1.value=f_query_add_mod.document.user_form.responsibility_group.value; //Added by Suji Keerthi for MMS-MD-SCF-0173
		    f_query_add_mod.document.user_form.appl_pin_no1.value=f_query_add_mod.document.user_form.appl_pin_no.value;
			
			var old_name=f_query_add_mod.document.forms[0].old_password.value;
			var new_name=f_query_add_mod.document.forms[0].appl_user_password.value;
			var old_resource=f_query_add_mod.document.forms[0].old_resource_id.value;
			var new_resource=f_query_add_mod.document.forms[0].resp_group_id.value;
			//Below Added by Suji Keerthi for MMS-MD-SCF-0173
			var old_response=f_query_add_mod.document.forms[0].old_response_id.value;
			var new_response=f_query_add_mod.document.forms[0].responsibility_group.value;
			//Ended by Suji Keerthi for MMS-MD-SCF-0173
			if(old_resource==new_resource)
			{
			f_query_add_mod.document.forms[0].resource_status.value="Y";
			}
			else{
			f_query_add_mod.document.forms[0].resource_status.value="N";
			}
            //Below Added by Suji Keerthi for MMS-MD-SCF-0173
			if(old_response==new_response)
			{
			f_query_add_mod.document.forms[0].response_status.value="Y";
			}
			else{
			f_query_add_mod.document.forms[0].response_status.value="N";
			}
			//Added by Suji Keerthi for MMS-MD-SCF-0173
			if(old_name==new_name)
			{
			f_query_add_mod.document.forms[0].password_status.value="Y";
			}
			else{
			f_query_add_mod.document.forms[0].password_status.value="N";
			}
			
		}
	/***************ICN:-1137***************************************************/

		var roletype 		= f_query_add_mod.document.user_form.role_type.value;
		if (roletype == "P")
		{
			if(isSSOIntegrationAppl == 'true' && f_query_add_mod.document.user_form.link_ad_user.value == "Y"){
					
				 var fields = new Array ( f_query_add_mod.document.user_form.appl_user_id,
					  f_query_add_mod.document.user_form.appl_user_name,
					  f_query_add_mod.document.user_form.appl_user_password,
					  f_query_add_mod.document.user_form.appl_user_cpassword,
					  f_query_add_mod.document.user_form.pract_type,
					  f_query_add_mod.document.user_form.pract_name,
					  f_query_add_mod.document.user_form.language,
					  f_query_add_mod.document.user_form.active_dir_id
					);
				 var names  = new Array (getLabel("Common.identification.label","Common"),
					  getLabel("Common.name.label","Common"),
					  getLabel("Common.password.label","Common"),
					  getLabel("Common.ConfirmPassword.label","Common"),
					  getLabel("Common.practitionertype.label","Common"),
					  getLabel("Common.practitionername.label","Common"),
					  getLabel("eSM.PreferredLanguage.label","SM"),
					 getLabel("eSM.ActiveDirectoryID.label","SM")
					);

			}else{
				
				 var fields = new Array ( f_query_add_mod.document.user_form.appl_user_id,
					  f_query_add_mod.document.user_form.appl_user_name,
					  f_query_add_mod.document.user_form.appl_user_password,
					  f_query_add_mod.document.user_form.appl_user_cpassword,
					  f_query_add_mod.document.user_form.pract_type,
					  f_query_add_mod.document.user_form.pract_name,
					  f_query_add_mod.document.user_form.language
					);
				 var names  = new Array (getLabel("Common.identification.label","Common"),
					  getLabel("Common.name.label","Common"),
					  getLabel("Common.password.label","Common"),
					  getLabel("Common.ConfirmPassword.label","Common"),
					  getLabel("Common.practitionertype.label","Common"),
					  getLabel("Common.practitionername.label","Common"),
					  getLabel("eSM.PreferredLanguage.label","SM")
					);
			}
			
		}
		else if (roletype == "O")
		{
			//alert('2 '+f_query_add_mod.document.user_form.pract_name.value)
			//Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2
			 if(isSSOIntegrationAppl == 'true' && f_query_add_mod.document.user_form.link_ad_user.value == "Y"){

				 var fields = new Array ( f_query_add_mod.document.user_form.appl_user_id,
							  f_query_add_mod.document.user_form.appl_user_name,
							  f_query_add_mod.document.user_form.appl_user_password,
							  f_query_add_mod.document.user_form.appl_user_cpassword,
							  f_query_add_mod.document.user_form.pract_type,
							  f_query_add_mod.document.user_form.pract_name,
							  f_query_add_mod.document.user_form.language,
							  f_query_add_mod.document.user_form.active_dir_id
							);
				 var names  = new Array ( getLabel("Common.identification.label","Common"),
							  getLabel("Common.name.label","Common"),
							  getLabel("Common.password.label","Common"),
							  getLabel("Common.ConfirmPassword.label","Common"),
							  getLabel("Common.OtherStaffType.label","Common"),
							  getLabel("Common.OtherStaffName.label","Common"),
							  getLabel("eSM.PreferredLanguage.label","SM"),
							  getLabel("eSM.ActiveDirectoryID.label","SM")
							);
			 }else{
				 
				 var fields = new Array ( f_query_add_mod.document.user_form.appl_user_id,
							  f_query_add_mod.document.user_form.appl_user_name,
							  f_query_add_mod.document.user_form.appl_user_password,
							  f_query_add_mod.document.user_form.appl_user_cpassword,
							  f_query_add_mod.document.user_form.pract_type,
							  f_query_add_mod.document.user_form.pract_name,
							  f_query_add_mod.document.user_form.language
							);
				 var names  = new Array ( getLabel("Common.identification.label","Common"),
							  getLabel("Common.name.label","Common"),
							  getLabel("Common.password.label","Common"),
							  getLabel("Common.ConfirmPassword.label","Common"),
							  getLabel("Common.OtherStaffType.label","Common"),
							  getLabel("Common.OtherStaffName.label","Common"),
							  getLabel("eSM.PreferredLanguage.label","SM")
							);
			 }
			
		}
	/*************************************************************************/
		else
		{	 
			 //Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2
			 if(isSSOIntegrationAppl == 'true' && f_query_add_mod.document.user_form.link_ad_user.value == "Y"){

				 var fields = new Array ( f_query_add_mod.document.user_form.appl_user_id,
							  f_query_add_mod.document.user_form.appl_user_name,
							  f_query_add_mod.document.user_form.appl_user_password,
							  f_query_add_mod.document.user_form.appl_user_cpassword,
							  f_query_add_mod.document.user_form.language,
							  f_query_add_mod.document.user_form.active_dir_id
							);

				 var names  = new Array ( getLabel("Common.identification.label","Common"),
							  getLabel("Common.name.label","Common"),
							  getLabel("Common.password.label","Common"),
							  getLabel("Common.ConfirmPassword.label","Common"),
							  getLabel("eSM.PreferredLanguage.label","SM"),
							  getLabel("eSM.ActiveDirectoryID.label","SM")
							);
			 }else{

				 var fields = new Array ( f_query_add_mod.document.user_form.appl_user_id,
							  f_query_add_mod.document.user_form.appl_user_name,
							  f_query_add_mod.document.user_form.appl_user_password,
							  f_query_add_mod.document.user_form.appl_user_cpassword,
							  f_query_add_mod.document.user_form.language
							);

				 var names  = new Array ( getLabel("Common.identification.label","Common"),
							  getLabel("Common.name.label","Common"),
							  getLabel("Common.password.label","Common"),
							  getLabel("Common.ConfirmPassword.label","Common"),
							  getLabel("eSM.PreferredLanguage.label","SM")
							);
			 }
		}

			 //Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2
			 if(isSSOIntegrationAppl == 'true')
			 {
				 var field = new Array ();
				 var name  = new Array ();

			 }else{
				 var field = new Array ( f_query_add_mod.document.user_form.appl_user_id);
				 var name  = new Array ( getLabel("Common.identification.label","Common"));
			 }

			 var transform = new Array ( f_query_add_mod.document.user_form,
							 f_query_add_mod.document.user_form.eff_date_from,
							 f_query_add_mod.document.user_form.eff_date_from1,
							 f_query_add_mod.document.user_form.eff_date_to,
							 f_query_add_mod.document.user_form.eff_date_to1
						   );

	/**********************************************************************/
	//Maheshwaran added for the MMS-QH-CRF-0149
	//Start
		if(proceed==false)	
			{
			var pw_msg=getMessage('PASSWORD_POLICY','SM').concat(" "+allowed_spl_char_in_password1);
			messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+pw_msg ;
			}
		else if(proceed1==false)	
			{
			f_query_add_mod.document.user_form.appl_user_password.value="";
			f_query_add_mod.document.user_form.appl_user_password.focus();
			var pw_msg=getMessage('SPECIAL_CHARCTERS_NOT_ALLOWED','SM');	
			messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+pw_msg ;
			} //End
		else
			{
			if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
			{
				if (appl_user_password_len <password_length_min)
					{
						
						errors = getMessage('PWD_MIN_CH','SM');
						errors=errors.replace("#",password_length_min);
						messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
						f_query_add_mod.document.forms[0].appl_user_password.select();
						f_query_add_mod.document.forms[0].appl_user_password.focus();
						return;
					
								
					}

					else if (appl_user_password_len >password_length_max)
					{
						errors = getMessage('PWD_MAX_CH','SM');
						errors=errors.replace("#",password_length_max);
						messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
						f_query_add_mod.document.forms[0].appl_user_password.select();
						f_query_add_mod.document.forms[0].appl_user_password.focus();
						return;
								
					}
					else if (appl_user_cpassword_len <password_length_min)
					{
						errors = getMessage('PWD_MIN_CH','SM');
						errors=errors.replace("#",password_length_min);
						messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
						f_query_add_mod.document.forms[0].appl_user_cpassword.select();
						f_query_add_mod.document.forms[0].appl_user_cpassword.focus();
						return;
								
					}
					else if (appl_user_cpassword_len >password_length_max)
					{
						errors = getMessage('PWD_MAX_CH','SM');
						errors=errors.replace("#",password_length_max);
						messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errors ;
						f_query_add_mod.document.forms[0].appl_user_cpassword.focus();
						return;
								
					}
					/*If Condition relocated against the incident - 27971*/
					if ( (f_query_add_mod.document.user_form.appl_user_cpassword.value != ""
				&&  f_query_add_mod.document.user_form.appl_user_password.value != "" ) )
				{
				if  ((f_query_add_mod.document.user_form.appl_user_password.value !=
					f_query_add_mod.document.user_form.appl_user_cpassword.value))
				{
					
					f_query_add_mod.document.user_form.appl_user_cpassword.focus();
					f_query_add_mod.document.user_form.appl_user_cpassword.select();
					messageFrame.document.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+getMessage('PWD_MISMATCH','SM');
					return false;											
				}
			}
				if (f_query_add_mod.SpecialCharCheck (field,name,messageFrame,'M','MstCodeError.jsp'))
				{
				  
				  if(f_query_add_mod.document.user_form.eff_date_from1.value=="")
					  f_query_add_mod.document.user_form.eff_date_from.value="";
				  else
					  f_query_add_mod.document.user_form.eff_date_from.value=f_query_add_mod.document.user_form.eff_date_from1.value;
				if(f_query_add_mod.document.user_form.eff_date_to1.value=="")
					 f_query_add_mod.document.user_form.eff_date_to.value="";
				else
					f_query_add_mod.document.user_form.eff_date_to.value=f_query_add_mod.document.user_form.eff_date_to1.value;
					
							var fn_status = f_query_add_mod.document.user_form.function_name.value ;
							
							//Added by Ashwini on 16-Oct-2023 for ML-MMOH-CRF-1844.2
							if(isSSOIntegrationAppl == 'true'){
								if(f_query_add_mod.document.user_form.link_ad_user.disabled == true)
									f_query_add_mod.document.user_form.link_ad_user.disabled = false;
								if(f_query_add_mod.document.user_form.appl_user_password.disabled == true)
									f_query_add_mod.document.user_form.appl_user_password.disabled = false;
								if(f_query_add_mod.document.user_form.appl_user_cpassword.disabled == true)
									f_query_add_mod.document.user_form.appl_user_cpassword.disabled = false;
							}

							f_query_add_mod.document.user_form.submit();


				 
				}else{
					if(isSSOIntegrationAppl == 'true'){
						if(f_query_add_mod.document.user_form.active_dir_id.value != ""){
							if(f_query_add_mod.document.user_form.appl_user_password.disabled == false)
								f_query_add_mod.document.user_form.appl_user_password.disabled = true;
							if(f_query_add_mod.document.user_form.appl_user_cpassword.disabled == false)
								f_query_add_mod.document.user_form.appl_user_cpassword.disabled = true;
						}
					}
				}		
			}else{
				if(isSSOIntegrationAppl == 'true'){
					if(f_query_add_mod.document.user_form.active_dir_id.value != ""){
						if(f_query_add_mod.document.user_form.appl_user_password.disabled == false)
							f_query_add_mod.document.user_form.appl_user_password.disabled = true;
						if(f_query_add_mod.document.user_form.appl_user_cpassword.disabled == false)
							f_query_add_mod.document.user_form.appl_user_cpassword.disabled = true;
					}
				}
			}

				}
	/********If Condition relocated against the incident - 27971**************************************/
			/*if ( (f_query_add_mod.document.user_form.appl_user_cpassword.value != ""
				&&  f_query_add_mod.document.user_form.appl_user_password.value != "" ) )
			{
				if  ((f_query_add_mod.document.user_form.appl_user_password.value !=
					f_query_add_mod.document.user_form.appl_user_cpassword.value))
				{
					alert('password mismatch');
					f_query_add_mod.document.user_form.appl_user_cpassword.focus();
				f_query_add_mod.document.user_form.appl_user_cpassword.select();
					messageFrame.document.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num='+getMessage('PWD_MISMATCH','SM');
					return false;
		
				}
			}*/
  }
   else
  {
  	frames[0].location.reload();
	return false;
  }

}
	//Maheshwaran added for the MMS-QH-CRF-0149	
function ChkPWSplChar(obj,allowed_spl_char_in_password,func)
	{
	var value = obj.value;
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
				if(func=='tab')
					{
					alert(getMessage('PASSWORD_POLICY','SM').concat(" "+allowed_spl_char_in_password));
					}
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
			if(func=='tab')
				{
				alert(getMessage('PASSWORD_POLICY','SM').concat(" "+allowed_spl_char_in_password));
				}
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
						if(func=='tab')
						{
						alert(getMessage('PASSWORD_POLICY','SM').concat(" "+allowed_spl_char_in_password));
						}
					obj.value="";
					obj.focus();
					return false;
						}
					}
				if (allowed_spl_char_in_password.indexOf(value.charAt(i)) == -1) 
					{
					if(func=='tab')
						{
						alert(getMessage('PASSWORD_POLICY','SM').concat(" "+allowed_spl_char_in_password));
						}
					obj.value="";
					obj.focus();
					return false;
					}
				}
			}
		}
	}
function reset() {
		 
	 if(f_query_add_mod.document.forms[0])
	 f_query_add_mod.document.location.reload();
	}

function onSuccess() {
						f_query_add_mod.document.location.reload();
}


//Added by Maheshwaran K for the Password Validation as on 11/07/2012
//Start
function applyunlock()
	{
	var appl_user_password_len=user_form.document.forms[0].appl_user_password.value.length;
	var appl_user_cpassword_len=user_form.document.forms[0].appl_user_cpassword.value.length;
	if (user_form.document.user_form.function_name.value=="modify")
		{
		user_form.document.user_form.role_type1.value=user_form.document.user_form.role_type.value;
		user_form.document.user_form.pract_type1.value=user_form.document.user_form.pract_type.value;
		user_form.document.user_form.pract_name1.value=user_form.document.user_form.pract_name.value;
		user_form.document.user_form.resp_group_id1.value=user_form.document.user_form.resp_group_id.value;
		user_form.document.user_form.appl_pin_no1.value=user_form.document.user_form.appl_pin_no.value;
		var old_name=user_form.document.forms[0].old_password.value;
		var new_name=user_form.document.forms[0].appl_user_password.value;
		var old_resource=user_form.document.forms[0].old_resource_id.value;
		var new_resource=user_form.document.forms[0].resp_group_id.value;
		if(old_resource==new_resource)
			{
			user_form.document.forms[0].resource_status.value="Y";
			}
		else
			{
			user_form.document.forms[0].resource_status.value="N";
			}
		if(old_name==new_name)
			{
			user_form.document.forms[0].password_status.value="Y";
			}
		else
			{
			user_form.document.forms[0].password_status.value="N";
			}
		}
	var roletype 		= user_form.document.user_form.role_type.value;
	if (roletype == "P")
		{
		var fields = new Array (document.user_form.appl_user_id,
								document.user_form.appl_user_name,
								document.user_form.appl_user_password,
								document.user_form.appl_user_cpassword,
								document.user_form.pract_type,
								document.user_form.pract_name,
								document.user_form.language
								);
		var names  = new Array (getLabel("Common.identification.label","Common"),
								getLabel("Common.name.label","Common"),
								getLabel("Common.password.label","Common"),
								getLabel("Common.ConfirmPassword.label","Common"),
								getLabel("Common.practitionertype.label","Common"),
								getLabel("Common.practitionername.label","Common"),
								getLabel("eSM.PreferredLanguage.label","SM")
								);	
		}
	else if (roletype == "O")
		{
		var fields = new Array (document.user_form.appl_user_id,
								document.user_form.appl_user_name,
								document.user_form.appl_user_password,
								document.user_form.appl_user_cpassword,
								document.user_form.pract_type,
								document.user_form.pract_name,
								document.user_form.language
								);
		var names  = new Array (getLabel("Common.identification.label","Common"),
								getLabel("Common.name.label","Common"),
								getLabel("Common.password.label","Common"),
								getLabel("Common.ConfirmPassword.label","Common"),
								getLabel("Common.OtherStaffType.label","Common"),
								getLabel("Common.OtherStaffName.label","Common"),
								getLabel("eSM.PreferredLanguage.label","SM")
								);
		}
	else
		{
		var fields = new Array (document.user_form.appl_user_id,
								document.user_form.appl_user_name,
								document.user_form.appl_user_password,
								document.user_form.appl_user_cpassword,
								document.user_form.language
								);
		var names  = new Array (getLabel("Common.identification.label","Common"),
								getLabel("Common.name.label","Common"),
								getLabel("Common.password.label","Common"),
								getLabel("Common.ConfirmPassword.label","Common"),
								getLabel("eSM.PreferredLanguage.label","SM")
								);
		}
	var field = new Array ( user_form.document.user_form.appl_user_id);
	var name  = new Array ( "ID" );
	var transform = new Array ( document.user_form,
								document.user_form.eff_date_from,
								document.user_form.eff_date_from1,
								document.user_form.eff_date_to,
								document.user_form.eff_date_to1
								);
	if(document.user_form.eff_date_from1.value=="")
	document.user_form.eff_date_from.value="";
	else
	document.user_form.eff_date_from.value=document.user_form.eff_date_from1.value;
	if(document.user_form.eff_date_to1.value=="")
	document.user_form.eff_date_to.value="";
	else
	document.user_form.eff_date_to.value=document.user_form.eff_date_to1.value;			
	document.forms[0].eff_status.checked == true
	document.forms[0].language.disabled = false;
	document.forms[0].eff_status.value='E';
	document.forms[0].unlock_yn.value='Y';
	document.forms[0].responsibility_group1.value = document.forms[0].responsibility_group.value; // Added Against MMS-MD-SCF-0191
	document.forms[0].submit();
	}
//End

//Added by Kamatchi S for ML-MMOH-CRF-1844.2
function activeDirIdBlur(obj)
{
	if(obj.value != "")
	{
		activeDirId(obj);
	}else{
		document.forms[0].appl_user_password.disabled = false;
		document.forms[0].appl_user_cpassword.disabled = false;
	}
}

async function activeDirId(obj){

		var searchtxtval = obj.value;

		var retVal;
		var dialogHeight= "42" ;
		var dialogTop = "65" ;
		var dialogWidth	= "50" ;
        var center  = "1" ;
        var status  = "no";
        var scroll  = "no"; 

        var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop +"; scroll :"+ scroll;
        var arguments   = "" ;
		var url = "../../eSM/jsp/ActiveDirectoryLookup.jsp?searchtxtval="+searchtxtval;
		retVal = await window.showModalDialog(url,arguments,features);

        if (retVal != null && retVal != '' && retVal != "null")
		{     
			var retVal=unescape(retVal);
			
            document.forms[0].active_dir_id.value = retVal;

			if(document.forms[0].appl_user_password.value == ""){
				document.forms[0].appl_user_password.value = document.forms[0].defpass_sso.value;
			}
			if(document.forms[0].appl_user_cpassword.value == ""){
				document.forms[0].appl_user_cpassword.value = document.forms[0].defpass_sso.value;
			}

			document.forms[0].appl_user_password.disabled = true;
			document.forms[0].appl_user_cpassword.disabled = true;

		}else{
			document.forms[0].active_dir_id.value = "";
			document.forms[0].appl_user_password.disabled = false;
			document.forms[0].appl_user_cpassword.disabled = false;
		}
}
