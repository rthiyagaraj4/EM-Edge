function ok_func() {
	if(document.forms[0].criteria(0).checked == true)
	{
		parent.window.returnValue = document.forms[0].criteria(0).value;
	}
	if(document.forms[0].criteria(1).checked == true)
	{
		parent.window.returnValue = document.forms[0].criteria(1).value;
	}
	 parent.parent.window.close();
}
function modal_close() {
	//const dialogTag = parent.parent.document.getElementById("dialog_tag");    
    //dialogTag.close(); 
	parent.parent.document.querySelectorAll('#dialog_tag')[parent.parent.document.querySelectorAll('#dialog_tag').length-1].close();
}	
function canceling() {
	window.returnValue = "cancel";
	parent.window.close();
}
 function search_criteria() {
	var dialogHeight = "7" ;
	var dialogWidth	 = "18";
	var dialogTop	 = "250";
	var dialogLeft	 = "260";
	var features	 = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no; center=yes" ;
	var arguments	 = "";
	var retValue	 = window.showModalDialog('../../eDR/jsp/SearchCriteriaModalFrameset.jsp',arguments,features);
		
	if(retValue == null)
	{
		parent.location.href='../../eCommon/jsp/dmenu.jsp';
	}
	if(retValue == "cancel")
	{
		parent.location.href='../../eCommon/jsp/dmenu.jsp';
	}
	if(retValue == "p" || retValue == "d")
	{
		parent.frames[1].document.location.href="../../eDR/jsp/SearchCriteriaMain.jsp?criteria="+retValue
	}
}
function checking_year() {
	document.forms[0].year_of_birth.checked = true;
}
function checking_year_month()
{
	document.forms[0].year_of_birth.checked  = true;
	document.forms[0].month_of_birth.checked = true;
}
function disable_soundex() {
	if(parent.frames[1].document.forms[0].names_in_oth_lang_yn.value == 'Y')
	{
		if(document.forms[0].name_loc_lang_yn.checked == true)
		{
			document.forms[0].names_sndx_type.value		= "N";
			document.forms[0].names_sndx_type.disabled	= true;
			document.forms[0].names_sndx_type.value		= "N";
		}
		if(document.forms[0].name_loc_lang_yn.checked == false)
		{
			document.forms[0].names_sndx_type.disabled = false;
		}
	}
}
function load_value() {
	if(parent.frames[1].document.forms[0].names_in_oth_lang_yn.value == 'Y')
	{
		if(document.forms[0].name_loc_lang_yn.checked == true)
		{
			document.forms[0].names_sndx_type.disabled = true;
		}
	}
}
function create() { }
function query()
{
	//frames[1].document.location.href="../../eDR/jsp/resultSetBeanTest.jsp?criteria1=first";
}
async function call_audit() {
	var dialogHeight = "500px" ;
	var dialogWidth	 = "700px";
	var dialogTop    = "150";
	var dialogLeft   = "80";
	var features     = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+ "; dialogLeft:" +dialogLeft+ "; dialogTop:" +dialogTop+ "; status=no; center=yes" ;
	var arguments	 = "" ;
	var retValue     = await window.showModalDialog('../../eDR/jsp/SearchCriteriaAudit.jsp',arguments,features);
}
function call_dflt_criteria() {
	parent.frames[1].location.href="../../eDR/jsp/SearchCriteriaDfltMain.jsp?criteria=dflt";
}
function call_previous_criteria() {
	parent.frames[1].location.href="../../eDR/jsp/SearchCriteriaDfltMain.jsp?criteria=prev";
}
function start_process(obj) {

	var identy		= obj.name;
	var submit		= true;
	var errors		= "";
	var check		= 0;
	var count_name	= 0;

	if(document.forms[0].alt1_avail.value == 'Y')
	{
		if(document.forms[0].short_desc1.checked == true) 
		{
			document.forms[0].short_desc11.value = "Y"
		}
		else
		{
			document.forms[0].short_desc11.value = "N"
		}
	}
	if(document.forms[0].alt2_avail.value == 'Y')
	{
		if(document.forms[0].short_desc2.checked == true)
		{
			document.forms[0].short_desc22.value = "Y"
		}
		else
		{
			document.forms[0].short_desc22.value = "N"
		}
	}
	if(document.forms[0].alt3_avail.value =='Y')
	{
		if(document.forms[0].short_desc3.checked == true)
		{
			document.forms[0].short_desc33.value = "Y"
		}
		else
		{
			document.forms[0].short_desc33.value = "N"
		}
	}
	if(document.forms[0].alt4_avail.value == 'Y')
	{
		if(document.forms[0].short_desc4.checked == true)
		{
			document.forms[0].short_desc44.value = "Y"
		}
		else
		{
			document.forms[0].short_desc44.value = "N"
		}
	}
	if(parent.frames[1].document.forms[0].names_in_oth_lang_yn.value == 'Y')
	{
		if(document.forms[0].name_loc_lang_yn.checked == false)
		{
			document.forms[0].name_loc_lang_yn.value = ""
		}
		else if(document.forms[0].name_loc_lang_yn.checked == true)
		{
			document.forms[0].name_loc_lang_yn.value = "Y"
		}
	}
	if(document.forms[0].sex.checked == false)
	{
		document.forms[0].sex.value = "";
	}
	else if(document.forms[0].sex.checked == true)
	{
		document.forms[0].sex.value = "Y";
	}
	if(document.forms[0].day_of_birth.checked == false)
	{
		document.forms[0].day_of_birth.value = "";
	}
	else if(document.forms[0].day_of_birth.checked == true)
	{
		document.forms[0].day_of_birth.value="Y";
	}
	if(document.forms[0].month_of_birth.checked == false)
	{
		document.forms[0].month_of_birth.value="";
	}
	else if(document.forms[0].month_of_birth.checked == true)
	{
		document.forms[0].month_of_birth.value = "Y";
	}
	if(document.forms[0].year_of_birth.checked == false)
	{
		document.forms[0].year_of_birth.value = "";
	}
	else if(document.forms[0].year_of_birth.checked == true)
	{
		document.forms[0].year_of_birth.value = "Y";
	}
	if(document.forms[0].first_name_avail.value == 'Y')
	{
		if(document.forms[0].first_name.checked == false)
		{
			document.forms[0].first_name.value = "";
		}
		else if(document.forms[0].first_name.checked == true)
		{
			document.forms[0].first_name.value = "Y";
			count_name++;
		}
	}
	if(document.forms[0].second_name_avail.value == 'Y')
	{
		if(document.forms[0].second_name.checked == false)
		{
			document.forms[0].second_name.value = "";
		}
		else if(document.forms[0].second_name.checked == true)
		{
			document.forms[0].second_name.value = "Y";
			count_name++;
		}
	}
	if(document.forms[0].third_name_avail.value == 'Y')
	{
		if(document.forms[0].third_name.checked == false)
		{
			document.forms[0].third_name.value = "";
		}
		else if(document.forms[0].third_name.checked == true)
		{
			document.forms[0].third_name.value = "Y";
			count_name++;
		}
	}
	if(document.forms[0].family_name_avail.value	==	'Y')
	{
		if(document.forms[0].family_name.checked == false)
		{
			document.forms[0].family_name.value = "";
		}
		if(document.forms[0].family_name.checked == true)
		{
			document.forms[0].family_name.value = "Y";
			count_name++;
		}
	}
	if(count_name != 0)
	{
		if(document.forms[0].short_desc1.checked == true) check = check+1;
		if(document.forms[0].short_desc2.checked == true) check = check+1;
		if(document.forms[0].short_desc3.checked == true) check = check+1;
		if(document.forms[0].short_desc4.checked == true) check = check+1;
		if(parent.frames[1].document.forms[0].names_in_oth_lang_yn.value == 'Y')
		{
			if(document.forms[0].name_loc_lang_yn.checked == true)check = check+1;
		}
		if(document.forms[0].first_name_avail.value == 'Y')
		{
			if(document.forms[0].first_name.checked == true) 
				check = check+1;
		}
		if(document.forms[0].second_name_avail.value =='Y')
		{
			if(document.forms[0].second_name.checked == true) 
				check = check+1;
		}
		if(document.forms[0].third_name_avail.value =='Y')
		{
			if(document.forms[0].third_name.checked == true) 
				check = check+1;
		}
		if(document.forms[0].family_name_avail.value =='Y')
		{
			if(document.forms[0].family_name.checked == true) 
				check = check+1;
		}
		if(document.forms[0].nationality_code.checked == true) check = check+1;
		if(document.forms[0].sex.checked == true) check = check+1;
		if(document.forms[0].day_of_birth.checked == true) check = check+1;
		if(document.forms[0].month_of_birth.checked == true) check = check+1;
		if(document.forms[0].year_of_birth.checked == true) check = check+1;
		if(document.forms[0].area_name_avail.value == 'Y')
		{
			if(document.forms[0].res_area_code.checked == true) 
				check = check+1;
		}
		if(document.forms[0].contact1_no.checked == true) check = check+1;
		if(document.forms[0].contact2_no.checked == true) check = check+1;

		if(document.forms[0].day_of_birth.value == "Y"&& document.forms[0].month_of_birth.value == "Y")
		{
			if(document.forms[0].year_of_birth.value=="")
			{
				errors = getMessage("CHECK_DAY_MONTH","DR");
				parent.frames[2].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
				submit = false;
				return false;
			}
			else
			{
				submit = true;
			}
		}
		if(submit == true)
		{
			if((document.forms[0].first_name_avail.value == 'Y') || (document.forms[0].second_name_avail.value == 'Y') || (document.forms[0].third_name_avail.value == 'Y') ||  (document.forms[0].family_name_avail.value == 'Y') )
			{		
				if(document.forms[0].first_name.value == ""&& document.forms[0].second_name.value == "" && document.forms[0].third_name.value==""&& document.forms[0].family_name.value=="")
				{
					errors = getMessage("ATLEAT_ONE_NAME","DR");
					parent.frames[2].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
					submit = false;
					return false
				}
				else 
				{
					submit = true;
				}
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
			var allow  = false;
			var errors = '';

			parent.frames[2].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
			if(document.forms[0].first_name_avail.value == 'Y')
			{
				if(document.forms[0].first_name.checked == true)
				{
					first_chk = 'Y';
				}
				else
				{
					first_chk = 'N';
				}
			}
			if(document.forms[0].second_name_avail.value == 'Y')
			{
				if(document.forms[0].second_name.checked == true)
				{
					second_chk = 'Y';
				}
				else
				{
					second_chk = 'N';
				}
			}
			if(document.forms[0].third_name_avail.value == 'Y')
			{
				if(document.forms[0].third_name.checked == true)
				{
					third_chk = 'Y';
				}
				else
				{
					third_chk = 'N';
				}
			}
			if(document.forms[0].family_name_avail.value == 'Y')
			{
				if(document.forms[0].family_name.checked == true)
				{
					family_chk = 'Y';
				}
				else
				{
					family_chk = 'N';
				}
			}
			var msg = '';
		
		if(document.forms[0].first_name_avail.value == 'Y' && document.forms[0].first_name_reqd_yn.value == 'Y') 
		{
			first_reqd = 'Y';
			if(msg=='') {
				msg = document.forms[0].first_name_prompt.value;
			} else {
				msg = msg+', '+document.forms[0].first_name_prompt.value;
			}
		}
		else
		{
			first_reqd = 'N';
		}
		if(document.forms[0].second_name_avail.value == 'Y' && document.forms[0].second_name_reqd_yn.value == 'Y') 
		{
			second_reqd = 'Y';
			if(msg=='') {
				msg = document.forms[0].second_name_prompt.value;
			} else {
				msg = msg+', '+document.forms[0].second_name_prompt.value;
			}
		}
		else
		{
			second_reqd = 'N';
		}
		if(document.forms[0].third_name_avail.value == 'Y' && document.forms[0].third_name_reqd_yn.value == 'Y') 
		{
			third_reqd = 'Y';
			if(msg=='') {
				msg =document.forms[0].third_name_prompt.value;
			} else {
				msg = msg+', '+document.forms[0].third_name_prompt.value;
			}
		}
		else
		{
			third_reqd = 'N';
		}
		if(document.forms[0].family_name_avail.value == 'Y' && document.forms[0].family_name_reqd_yn.value == 'Y') 
		{
			family_reqd = 'Y';
			if(msg=='') {
				msg = document.forms[0].family_name_prompt.value;
			} else {
				msg = msg+', '+document.forms[0].family_name_prompt.value;
			}
		}	
		else
		{
			family_reqd = 'N';
		}
			
			if(((first_chk == 'Y') && (first_reqd == 'Y')) ||  ((second_chk == 'Y') && (second_reqd == 'Y')) ||  ((third_chk == 'Y') && (third_reqd == 'Y')) ||  ((family_chk == 'Y') && (family_reqd == 'Y')))
			{
				allow = true;
			}
			else if(first_reqd=='Y' || second_reqd=='Y' || third_reqd=='Y' || family_reqd=='Y')	{ 				
				errors =getMessage("SELECT_MANDATORY_NAME","DR") ;
				errors = errors.replace('#',msg);				
				parent.frames[2].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors; 
			} else {
			allow = true;
		   }
			if(allow)
			{
				if(parent.frames[1].document.forms[0].names_in_oth_lang_yn.value == 'Y')
				{
					if(document.forms[0].name_loc_lang_yn.checked == true)
					{
						document.forms[0].names_sndx_type.value = "N";
					}
				}
				if(identy == "start_now")
				{
					document.forms[0].process_start.value = "process_now";
					if(document.forms[0].day_of_birth.checked == true)
					{
						document.forms[0].day_of_birth1.value = "Y";
					}
					else
					{
						document.forms[0].day_of_birth1.value = "N";
					}
					if(document.forms[0].month_of_birth.checked == true)
					{
						document.forms[0].month_of_birth1.value = "Y";
					}
					else
					{
						document.forms[0].month_of_birth1.value = "N";
					}
					if(document.forms[0].year_of_birth.checked == true)
					{
						document.forms[0].year_of_birth1.value = "Y";
					}
					else
					{
						document.forms[0].year_of_birth1.value = "N";
					}

                    document.forms[0].action='../../servlet/eDR.SearchDuplicateServlet';
					document.forms[0].target="messageFrame"; 
					document.forms[0].submit();
				}
				else if(identy == "start_later")
				{
				
					if(document.forms[0].start_later_time.value == "")
					{
						alert(getMessage("DATE_TIME_NOT_BLANK","DR"));						
						document.forms[0].start_later_time.focus();
					}
					else
					{
						//var comp		= document.forms[0].start_later_time;
						var senddate	= document.forms[0].start_later_time.value;
						var retval	= true;
						if(senddate != "")
						{
							//if(validDate(obj.value,'DMYHM',localeName) == false)						
							if(validDate(senddate,'DMYHM',localeName) == false)
							{
									errors = getMessage("INVALID_DATETIME","DR") ;
									parent.frames[2].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
									document.forms[0].start_later_time.focus();
									retval = false;									
							}				
						}
						if(retval)
						{
							document.forms[0].process_start.value = "process_later";
							//var time = document.forms[0].start_later_time.value;

							if(document.forms[0].day_of_birth.checked == true)
							{
								document.forms[0].day_of_birth.value = "Y";
							}
							else
							{
								document.forms[0].day_of_birth.value = "N";
							}
							if(document.forms[0].month_of_birth.checked == true)
							{
								document.forms[0].month_of_birth.value = "Y";
							}
							else
							{
								document.forms[0].month_of_birth.value = "N";
							}
							if(document.forms[0].year_of_birth.checked == true)
							{
								document.forms[0].year_of_birth.value = "Y";
						
							}
							else
							{
								document.forms[0].year_of_birth.value = "N";
							}
							document.forms[0].action='../../servlet/eDR.SearchDuplicateServlet';
							document.forms[0].target="messageFrame";
							document.forms[0].submit();
						
						}						
					}
				} 				
			}
		}
		else if(check < 3)
		{
			errors = getMessage("THREE_FIELD","DR") ;
			parent.frames[2].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
			return false;
		}
	}
	else
	{		
		errors = getMessage("ATLEAT_ONE_NAME","DR");
		parent.frames[2].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
		submit = false;
		//document.forms[0].submit();
	}
}
//function : if month or date is selected then by default year also to be selected
function chk_year(obj) {
	var nam = obj.name;
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
function chk_month(obj) {
	var nam = obj.name;

	if((nam == 'month_of_birth') && (document.forms[0].month_of_birth.checked == true))
	{
		document.forms[0].year_of_birth.checked		= true;
		document.forms[0].year_of_birth.disabled	= true;		
	}
	else
	{
		document.forms[0].year_of_birth.disabled	= false;		
		document.forms[0].year_of_birth.checked		= false;
	}
}
function chk_year_month() {
	if((document.forms[0].day_of_birth.checked == true))
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

function doDateCheckAlert(from,to,time) {
	var HTMLVal = new String();
	HTMLVal = "<HTML><BODY onKeyDown='lockKey();'><form name='form1' id='form1' method='post' action='../../eDR/jsp/DateValidation.jsp'></form></BODY></HTML>";
	parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.frames[2].document.form1.submit();

	var fromarray; 
	var toarray;
	var fromdate	= from ;
	var todate		= to ;

	if(fromdate.length > 0 && todate.length > 0) 
	{
		fromarray		= fromdate.split("/");
		toarray			= todate.split("/");
		fromarray[1]	= fromarray[1] - 1;
		toarray[1]		= toarray[1] - 1;
		var fromdt	= new Date(fromarray[2],fromarray[1],fromarray[0]);
		var todt	= new Date(toarray[2],toarray[1],toarray[0]);

		if(Date.parse(todt) <= Date.parse(fromdt))
		{
			if(Date.parse(todt) == Date.parse(fromdt))
			{
				var app_time	= time;
				var sys_time	= document.forms[0].sys_time.value;
				var app_time_ar	= app_time.split(":"); 
				var app_time_ho	= app_time_ar[0];
				var app_time_mi	= app_time_ar[1];
				var sys_time_ar	= sys_time.split(":"); 
				var sys_time_ho	= sys_time_ar[0];
				var sys_time_mi	= sys_time_ar[1];

				var fin_app_time	= new Date(1,1,1,app_time_ar[0],app_time_ar[1],0,0);
				var fin_sys_time	= new Date(1,1,1,sys_time_ar[0],sys_time_ar[1],0,0);
            
				if(Date.parse(fin_app_time) <= Date.parse(fin_sys_time))
				{
					errors = getMessage("START_LATER_TIME","DR") ;
					parent.frames[2].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
					document.forms[0].start_later_time.focus();
				}
			}
			return true;

			parent.frames[2].document.location.href="../../eCommon/jsp/error.jsp?";
		}
		else
		{
			 
			errors = getMessage("START_LATER_TIME","DR");
			parent.frames[2].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
			document.forms[0].start_later_time.focus();
			return false;
		}
	}
}
function reset() {
	//parent.frames[1].frames[1].location.reload();
       //parent.frames[1].frames[1].forms[0].reset();
	   parent.frames[2].frames[1].document.forms[0].reset();
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
function touppercase(obj) {
	obj.value = obj.value.toUpperCase();
}


function chkFromToTime2(Obj)
{
	var fromFormDate ='';
	

	if(Obj.value != '') 
	{
		if(!validDate(Obj.value,'DMYHM',localeName))
		{
			alert(getMessage("INVALID_DATE_TIME",'SM'))
			//Obj.select();
			Obj.value="";
		}
		else
		{
			fromFormDate = convertDate(Obj.value,"DMYHM",localeName,"en");				

			if(!isAfterNow(Obj.value,'DMYHM',localeName)){
				alert(getMessage("DT_NLT_CURR_DT","SM"));  
				//Obj.select();
				Obj.value="";
			}
			
		}//end if else
       
	} // end of if
}// end of fun


