/*
	Developed By       :  P.Sudhakaran
	Developed on   	   :  10/12/2001
	ReDeveloped on	   :  12/02/2002
	Module Name 	   :  eCIS/eDR
	Function Name	   :  Default Search Criteria
*/

function apply()
{
	var submit = true;
	var errors = "";
	var check  = 0;
	
	if(frames[1].document.forms[0].short_desc1 != null)
	{
		if(frames[1].document.forms[0].short_desc1.checked == true)
		{
			frames[1].document.forms[0].short_desc11.value = "Y"
		}
 		else
		{
			frames[1].document.forms[0].short_desc11.value = "N"
		}
	}
	else
	{
		frames[1].document.forms[0].short_desc11.value = "N"
	}
	
	if(frames[1].document.forms[0].short_desc2 != null)
	{
		if(frames[1].document.forms[0].short_desc2.checked == true)
		{
			frames[1].document.forms[0].short_desc22.value = "Y"
		}
		else
		{
			frames[1].document.forms[0].short_desc22.value = "N"
		}
	}
	else
	{
		frames[1].document.forms[0].short_desc22.value = "N"
	}
	
	if(frames[1].document.forms[0].short_desc3 != null)
	{
		if(frames[1].document.forms[0].short_desc3.checked == true)
		{
			frames[1].document.forms[0].short_desc33.value = "Y"
		}
		else
		{
			frames[1].document.forms[0].short_desc33.value = "N"
		}
	}
	else
	{
		frames[1].document.forms[0].short_desc33.value = "N"
	}

	if(frames[1].document.forms[0].short_desc4 != null)
	{
		if(frames[1].document.forms[0].short_desc4.checked == true)
		{
			frames[1].document.forms[0].short_desc44.value = "Y"
		}
		else
		{
			frames[1].document.forms[0].short_desc44.value = "N"
		}
	}
	else
	{
		frames[1].document.forms[0].short_desc44.value = "N"
	}

	if(frames[1].document.forms[0].sex.checked == false)
	{
		frames[1].document.forms[0].sex.value = "";
	}
	else if(frames[1].document.forms[0].sex.checked == true)
	{
		frames[1].document.forms[0].sex.value = "Y";
	}
	if(frames[1].document.forms[0].day_of_birth.checked == false)
	{
		frames[1].document.forms[0].day_of_birth1.value = "";
	}
	else if(frames[1].document.forms[0].day_of_birth.checked == true)
	{
		frames[1].document.forms[0].day_of_birth1.value = "Y";
	}
	if(frames[1].document.forms[0].month_of_birth.checked == false)
	{
		frames[1].document.forms[0].month_of_birth1.value = "";
	}
	else if(frames[1].document.forms[0].month_of_birth.checked == true)
	{
		frames[1].document.forms[0].month_of_birth1.value = "Y";
	}
	if(frames[1].document.forms[0].year_of_birth.checked == false)
	{
		frames[1].document.forms[0].year_of_birth1.value = "";
	}
	else if(frames[1].document.forms[0].year_of_birth.checked == true)
	{
		frames[1].document.forms[0].year_of_birth1.value="Y";
	}
	if(frames[1].document.forms[0].first_name_avail.value == 'Y')
	{
		if(frames[1].document.forms[0].first_name.checked == false)
		{
			frames[1].document.forms[0].first_name.value = "N";
		}
		else if(frames[1].document.forms[0].first_name.checked == true)
		{
			frames[1].document.forms[0].first_name.value = "Y";
		}
	}
	if(frames[1].document.forms[0].second_name_avail.value=='Y')
	{
		if(frames[1].document.forms[0].second_name.checked == false)
		{
			frames[1].document.forms[0].second_name.value = "N";
		}
		else if(frames[1].document.forms[0].second_name.checked == true)
		{
			frames[1].document.forms[0].second_name.value = "Y";
		}
	}
	if(frames[1].document.forms[0].third_name_avail.value == 'Y')
	{
		if(frames[1].document.forms[0].third_name.checked == false)
		{
			frames[1].document.forms[0].third_name.value = "N";
		}
		else if(frames[1].document.forms[0].third_name.checked == true)
		{
			frames[1].document.forms[0].third_name.value = "Y";
		}
	}
	
	if(frames[1].document.forms[0].family_name_avail.value == 'Y')
	{
		
		if(frames[1].document.forms[0].family_name.checked == false)
		{
			frames[1].document.forms[0].family_name.value = "N";
		}
		else if(frames[1].document.forms[0].family_name.checked == true)
		{
			frames[1].document.forms[0].family_name.value = "Y";
		}
	}
	
	if(frames[1].document.forms[0].short_desc1 != null)
	{
		if(frames[1].document.forms[0].short_desc1.checked == true)
		{
			check=check+1;
		}
	}
	if(frames[1].document.forms[0].short_desc2 != null)
	{
		if(frames[1].document.forms[0].short_desc2.checked == true)
		{
			check = check+1;
		}
	}
	if(frames[1].document.forms[0].short_desc3 != null)
	{
		if(frames[1].document.forms[0].short_desc3.checked == true)
		{
			check = check+1;
		}
	}
	if(frames[1].document.forms[0].short_desc4 != null)
	{
		if(frames[1].document.forms[0].short_desc4.checked == true)
		{
			check = check+1;
		}
	}
	if(frames[1].document.forms[0].names_in_oth_lang_yn.value == 'Y')
	{
		if(frames[1].document.forms[0].name_loc_lang_yn.checked == true)
		{
			check = check+1;
		}
	}

	if(frames[1].document.forms[0].first_name_avail.value == 'Y')
	{
		if(frames[1].document.forms[0].first_name.checked == true)
		{
			check = check+1;
		}
	}
	if(frames[1].document.forms[0].second_name_avail.value == 'Y')
	{
		if(frames[1].document.forms[0].second_name.checked == true) 
		{
			check = check+1;
		}
	}
	if(frames[1].document.forms[0].third_name_avail.value == 'Y')
	{
		if(frames[1].document.forms[0].third_name.checked == true) 
		{
			check = check+1;
		}
	}
	if(frames[1].document.forms[0].family_name_avail.value == 'Y')
	{
		if(frames[1].document.forms[0].family_name.checked == true)
		{
			check = check+1;
		}
	}

	if(frames[1].document.forms[0].nationality_code.checked == true) check = check+1;
	if(frames[1].document.forms[0].sex.checked == true) check = check+1;
	if(frames[1].document.forms[0].day_of_birth.checked == true) check = check+1;
	if(frames[1].document.forms[0].month_of_birth.checked == true) check = check+1;
	if(frames[1].document.forms[0].year_of_birth.checked == true) check = check+1;

	if(frames[1].document.forms[0].area_name_avail.value == 'Y')
	{
		if(frames[1].document.forms[0].res_area_code.checked == true)
		{
			check=check+1;
		}
	}

	if(frames[1].document.forms[0].contact1_no.checked == true) check = check+1;
	if(frames[1].document.forms[0].contact2_no.checked == true) check = check+1;

	if(f_query_add_mod.document.forms[0].search_type.value != "")
	{
		if((frames[1].document.forms[0].day_of_birth.value == "Y") || (frames[1].document.forms[0].month_of_birth.value == "Y"))
		{
			if(frames[1].document.forms[0].year_of_birth.value == "")
			{
				var errors = getMessage('CHECK_DAY_MONTH','DR')+ "<br>";
				messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors;
				submit = false;
			}
			else submit = true;
		}
	}
	else
	{
		//errors = "APP-000001 Search Type Cannot be blank..." + "<br>" ;
		errors = getMessage("CAN_NOT_BE_BLANK","Common")+ "<br>";
		errors= errors.replace('$',getLabel("eDR.SearchType.label","DR"));
		messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors;
		submit=false;
	}
	if(submit == true)
	{
		//check for names
		
		if((frames[1].document.forms[0].first_name_avail.value == 'Y') || (frames[1].document.forms[0].second_name_avail.value == 'Y') || (frames[1].document.forms[0].third_name_avail.value == 'Y') || (frames[1].document.forms[0].family_name_avail.value == 'Y') )
		{		
			if(frames[1].document.forms[0].first_name.value == "N" && frames[1].document.forms[0].second_name.value == "N" && frames[1].document.forms[0].third_name.value == "N" && frames[1].document.forms[0].family_name.value == "N")
			{
				errors = getMessage("ATLEAT_ONE_NAME","DR");
				messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors;
				submit = false;
				return false
			} else  { submit = true; }
		}
    }
	
	if(submit == true && check >= 3)
	{
		var first_chk='N';
		var second_chk='N';
		var third_chk='N';
		var family_chk='N';
		var first_reqd;
		var second_reqd;
		var third_reqd;
		var family_reqd;
		var allow	= false;
		var errors  = '';
		messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors;
		if(frames[1].document.forms[0].first_name_avail.value == 'Y')
		{
			if(frames[1].document.forms[0].first_name.checked == true)
			{
				first_chk = 'Y';
			}
			else
			{
				first_chk = 'N';
			}
		}
		if(frames[1].document.forms[0].second_name_avail.value == 'Y')
		{
			if(frames[1].document.forms[0].second_name.checked == true)
			{
				second_chk = 'Y';
			}
			else
			{
				second_chk = 'N';
			}
		}
		
		if(frames[1].document.forms[0].third_name_avail.value == 'Y')
		{
			if(frames[1].document.forms[0].third_name.checked == true)
			{
				third_chk = 'Y';
			}
			else
			{
				third_chk = 'N';
			}
		}
		
		if(frames[1].document.forms[0].family_name_avail.value == 'Y')
		{
			
			if(frames[1].document.forms[0].family_name.checked == true)
			{
				family_chk = 'Y';
			}
			else
			{
				family_chk = 'N';
			}
		}
		var msg = '';
		
		if(frames[1].document.forms[0].first_name_avail.value == 'Y' && frames[1].document.forms[0].first_name_reqd_yn.value == 'Y') 
		{
			first_reqd = 'Y';
			if(msg=='') {
				msg = frames[1].document.forms[0].first_name_prompt.value;
			} else {
				msg = msg+', '+frames[1].document.forms[0].first_name_prompt.value;
			}
		}
		else
		{
			first_reqd = 'N';
		}
		if(frames[1].document.forms[0].second_name_avail.value == 'Y' && frames[1].document.forms[0].second_name_reqd_yn.value == 'Y') 
		{
			second_reqd = 'Y';
			if(msg=='') {
				msg = frames[1].document.forms[0].second_name_prompt.value;
			} else {
				msg = msg+', '+frames[1].document.forms[0].second_name_prompt.value;
			}
		}
		else
		{
			second_reqd = 'N';
		}
		if(frames[1].document.forms[0].third_name_avail.value == 'Y' && frames[1].document.forms[0].third_name_reqd_yn.value == 'Y') 
		{
			third_reqd = 'Y';
			if(msg=='') {
				msg = frames[1].document.forms[0].third_name_prompt.value;
			} else {
				msg = msg+', '+frames[1].document.forms[0].third_name_prompt.value;
			}
		}
		else
		{
			third_reqd = 'N';
		}
		if(frames[1].document.forms[0].family_name_avail.value == 'Y' && frames[1].document.forms[0].family_name_reqd_yn.value == 'Y') 
		{
			family_reqd = 'Y';
			if(msg=='') {
				msg = frames[1].document.forms[0].family_name_prompt.value;
			} else {
				msg = msg+', '+frames[1].document.forms[0].family_name_prompt.value;
			}
		}	
		else
		{
			family_reqd = 'N';
		}
		

		if(((first_chk == 'Y') && (first_reqd == 'Y')) || ((second_chk == 'Y') && (second_reqd == 'Y')) || ((third_chk == 'Y') && (third_reqd == 'Y')) ||  ((family_chk == 'Y') && (family_reqd == 'Y')))
		{
			allow = true;
		}		
		else if(first_reqd=='Y' || second_reqd=='Y' || third_reqd=='Y' || family_reqd=='Y')	{ 		
			errors = getMessage("SELECT_MANDATORY_NAME","DR") ;
			errors = errors.replace('#',msg);
			messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors; 	
		} else {
			allow = true;
		}
		if(allow)
		{
			if(frames[1].document.forms[0].day_of_birth.checked == true)
			{
				frames[1].document.forms[0].day_of_birth.value=  "Y";
			}
			else
			{
				frames[1].document.forms[0].day_of_birth.value = "N";
			}
			if(frames[1].document.forms[0].month_of_birth.checked == true)
			{
				frames[1].document.forms[0].month_of_birth.value = "Y";
			}
			else
			{
				frames[1].document.forms[0].month_of_birth.value = "N";
			}
			if(frames[1].document.forms[0].year_of_birth.checked == true)
			{
				frames[1].document.forms[0].year_of_birth.value = "Y";
			}
			else
			{
				frames[1].document.forms[0].year_of_birth.value = "N";
			}
			frames[1].document.forms[0].submit();
		}
	}
	else if(check<3)
	{
		var errors = getMessage('THREE_FIELD','DR')+ "<br>";
		messageFrame.document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors;
	}
}
//function for if month ordate is selected then by default year also to be selected
function chk_year(obj)
{
	var nam=obj.name;
	if((nam =='day_of_birth') && (document.forms[0].day_of_birth.checked == true))
	{
		document.forms[0].year_of_birth.checked   = true;
		document.forms[0].year_of_birth.disabled  = true;		
		document.forms[0].month_of_birth.checked  = true;
		document.forms[0].month_of_birth.disabled = true;
	}
	else
	{
		document.forms[0].year_of_birth.disabled  = false;		
		document.forms[0].month_of_birth.disabled = false;
		document.forms[0].year_of_birth.checked   = false;
		document.forms[0].month_of_birth.checked  = false;
	
	}
}

function chk_month(obj)
{
	var nam = obj.name;

	if((nam == 'month_of_birth') && (document.forms[0].month_of_birth.checked == true))
	{
		document.forms[0].year_of_birth.checked  = true;
		document.forms[0].year_of_birth.disabled = true;		
	}
	else
	{
		document.forms[0].year_of_birth.disabled = false;		
		document.forms[0].year_of_birth.checked  = false;
		document.forms[0].day_of_birth.checked   = false;
	}
}
function disable_soundex()
{
	if(parent.frames[1].document.forms[0].names_in_oth_lang_yn.value == 'Y')
	{
		var mode = document.DefaultSearchCriteria.name_loc_lang_yn.checked;
		if(mode == true)
		{
			document.DefaultSearchCriteria.names_sndx_type.value    = "N";
			document.DefaultSearchCriteria.names_sndx_type.disabled = true;
		}
		if(mode == false)
		{
			document.DefaultSearchCriteria.names_sndx_type.disabled = false;
		}
	}
}
//on submit of form
function chk_year_month()
{
	if((document.forms[0].day_of_birth.checked == true) )
	{
		document.forms[0].year_of_birth.checked   = true;
		document.forms[0].year_of_birth.disabled  = true;		
		document.forms[0].month_of_birth.checked  = true;
		document.forms[0].month_of_birth.disabled = true;
	}
	else if((document.forms[0].month_of_birth.checked == true))
	{
		document.forms[0].year_of_birth.checked  = true;
		document.forms[0].year_of_birth.disabled = true;		
	}
}

function onSuccess()
{
	frames[1].document.location.href="../../eDR/jsp/DefaultSearchCriteria.jsp";
}

function reset()
{
	
	frames[1].document.forms[0].reset();
	if((frames[1].document.forms[0].family_name_prompt.value != null) && (!(frames[1].document.forms[0].family_name_prompt.value=="")) && (frames[1].document.forms[0].family_name_init.value != null) && (frames[1].document.forms[0].family_name_init.value=="Y"))
	{
		 
		 frames[1].document.forms[0].family_name_avail.value = 'Y';
    }
	else
	{
		frames[1].document.forms[0].family_name_avail.value = 'N';
	}
	if((frames[1].document.forms[0].first_name_prompt.value != null) && (!(frames[1].document.forms[0].first_name_prompt.value=="")) && (frames[1].document.forms[0].first_name_init.value != null) && (frames[1].document.forms[0].first_name_init.value=="Y"))
	{
		 
		 frames[1].document.forms[0].first_name_avail.value = 'Y';
    }
	else
	{
		frames[1].document.forms[0].first_name_avail.value = 'N';
	}
	if((frames[1].document.forms[0].second_name_prompt.value != null) && (!(frames[1].document.forms[0].second_name_prompt.value=="")) && (frames[1].document.forms[0].second_name_init.value != null) && (frames[1].document.forms[0].second_name_init.value=="Y"))
	{
		 
		 frames[1].document.forms[0].second_name_avail.value = 'Y';
    }
	else
	{
		frames[1].document.forms[0].second_name_avail.value = 'N';
	}
	if((frames[1].document.forms[0].third_name_prompt.value != null) && (!(frames[1].document.forms[0].third_name_prompt.value=="")) && (frames[1].document.forms[0].third_name_init.value != null) && (frames[1].document.forms[0].third_name_init.value=="Y"))
	{
		 
		 frames[1].document.forms[0].third_name_avail.value = 'Y';
    }
	else
	{
		frames[1].document.forms[0].third_name_avail.value = 'N';
	}
		 
}
