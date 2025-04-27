var isCreate = "false";
var isApply = "false";
var isQuery = "false";
var message = "";
var shift_code = "";
var short_desc = "";
var long_desc = "";
var shift_indicator = "";
var shift_start_time = "";
var shift_end_time = "";
var productive_flag = "";
var mnemonic_key = "";
var appl_for_working_days = "";
var appl_for_nonworking_days = "";
var appl_for_holidays = "";
var eff_status = "";


function create() 
{
	f_query_add_mod.location.href = "../../eAM/jsp/ShiftAddModify.jsp?mode=1" ;
	isCreate = "true";
}
function query() 
{
	f_query_add_mod.location.href ="../../eAM/jsp/ShiftQueryCriteria.jsp?function=service";
	isQuery = "true";
	isCreate = "false";
}
function CheckForHours(target)
{ 
	var value = target.value;
	if(value == '') 
	{
		//target.value = '00';
	}
	else
	{
		if(value < 0 || value >= 24)
		{
			message = "APP-AM0027 Operating Hours Can be between 0 and 23";			
			parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			target.focus();
			return;
		}
		else
		{
			message ="";
				parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
			if(value < 10) 
			{
				var len = value.length;
				if(len < 2)
					target.value = '0' + value;
			}
		}
	}
}
function CheckForMinutes(target)
{
	var value = target.value;
	if(value == '')
	{
		//target.value = '00';
	}
	else
	{
		if(value < 0 || value >= 60)
		{
			//message = "APP-AM0027 Operating Minutes Can be between 0 and 59";
			message = getMessage("AM0124","AM");
			parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			target.focus();
			return;
		}
		else
		{
			parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
			if(value < 10)
			{
			
				
				var len = value.length;
				if(len < 2)
					target.value = '0' + value;
			}
		}
	}
}

function checkIsValidForProceed()
  {
     var url = f_query_add_mod.location.href;
     url = url.toLowerCase();
     if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
        return true;
    else
        return false;
  }

function apply()
{

	//var messageFrame = parent.frames[1].frames[2]; 
	var messageFrame = frames[2]; 
	
	if (! (checkIsValidForProceed()) )
    {
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 

	var error_page = "../../eCommon/jsp/MstCodeError.jsp";
	var frmObj = f_query_add_mod.document.shift_frm;
	var shift_indi = frmObj.shift_indicator.value;
	var operation_type = frmObj.operation_type.value;
	
	var max_cont_work_durn = frmObj.max_cont_work_durn.value;
	if(frmObj.appl_for_working_days.disabled==true)
	{
		frmObj.appl_for_working_days.disabled=false;
	}
	if(frmObj.appl_for_nonworking_days.disabled==true)
	{
		frmObj.appl_for_nonworking_days.disabled=false;
	}
	if(frmObj.appl_for_holidays.disabled==true)
	{
		frmObj.appl_for_holidays.disabled=false;
	}
	if(frmObj.appl_for_working_days.checked == false && frmObj.appl_for_nonworking_days.checked == false && frmObj.appl_for_holidays.checked == false)
	{
		if(shift_indi == 'P' || shift_indi =='U')
		{
			var fields = new Array (frmObj.shift_indicator, frmObj.shift_code,
						frmObj.short_desc, frmObj.long_desc, frmObj.starthour,
						frmObj.startmin, frmObj.endhour, frmObj.endmin, frmObj.mnemonic_key );
			var names = new Array (getLabel("Common.ShiftIndicator.label","common"),getLabel("eAM.ShiftID.label","am"),getLabel("Common.shortdescription.label","common"),getLabel("Common.longdescription.label","common"),getLabel("eAM.FromHours.label","AM"),getLabel("eAM.FromMins.label","AM") , "To Hours","To Mins", getLabel("eAM.MnemonicforShiftID.label","am"));
		}
		else
		{
			
			var fields = new Array (frmObj.shift_indicator, frmObj.shift_code,
						frmObj.short_desc, frmObj.long_desc,frmObj.starthour,
						frmObj.startmin, frmObj.endhour, frmObj.endmin, frmObj.mnemonic_key);
			var names = new Array (getLabel("Common.ShiftIndicator.label","common"),
									getLabel("eAM.ShiftID.label","am"),
									getLabel("Common.shortdescription.label","common"),
									getLabel("Common.longdescription.label","common"),getLabel("eAM.FromHours.label","AM"),getLabel("eAM.FromMins.label","AM") , "To Hours","To Mins",
									getLabel("eAM.MnemonicforShiftID.label","am"));
					
		}
	}
	else
	{
	var fields = new Array (frmObj.shift_indicator, frmObj.shift_code,
						frmObj.short_desc, frmObj.long_desc, frmObj.starthour,
						frmObj.startmin, frmObj.endhour, frmObj.endmin, frmObj.mnemonic_key);

	var names = new Array ( getLabel("Common.ShiftIndicator.label","common"),  getLabel("eAM.ShiftID.label","am"),getLabel("Common.shortdescription.label","common"), getLabel("Common.longdescription.label","common"),getLabel("eAM.FromHours.label","AM"),getLabel("eAM.FromMins.label","AM") , getLabel("eAM.ToHours.label","AM"),getLabel("eAM.ToMins.label","AM"),getLabel("eAM.MnemonicforShiftID.label","am") );	
	}
	
		if(operation_type == "insert")
		{
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
		 {
			if((frmObj.starthour.value)==(frmObj.endhour.value)&&
	(frmObj.startmin.value)==(frmObj.endmin.value))
	{
		//message = "APP-AM0027 Working Days From and To cannot be Equal";
		message =getMessage("START_END_NOT_EQUAL","AM");
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			//frmObj.endmin.focus();
			return;
	}
			var shift_indi = frmObj.shift_indicator.value;
			
			if(shift_indi == 'P' || shift_indi == 'U')
			{
				if(frmObj.appl_for_working_days.checked == false && 
				frmObj.appl_for_nonworking_days.checked == false && frmObj.appl_for_holidays.checked == false)
				{
					//message = "APP-AM0028 Atleast one Applicability Should be specified";
					message =getMessage("AM0119","AM");
					messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
					return;
				}
			}
				else
				{
					var start_hh = frmObj.starthour.value;
					var start_mi = frmObj.startmin.value;
					var end_hh = frmObj.endhour.value;
					var end_mi = frmObj.endmin.value;
					
					var diff = Math.abs(end_hh - start_hh);

					if(start_hh == end_hh)
					{
						if(start_mi == end_mi)
						{
							//message = "APP-AM0027 Shift Timings Should Differ Atleast 1 mins";
							message =getMessage("AM0115","AM");
							messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
						}
						else
						{
							f_query_add_mod.document.shift_frm.submit();
							//f_query_add_mod.location.reload();
						}
					}
					else
					{
						if(diff > max_cont_work_durn)
						{
							//message = "APP-AM0028 Working Hours Should Not Exceed Maximum Continuous Work Duration";
							message =getMessage("AM0114","AM");
							messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
						}
					}
				//
			}
				f_query_add_mod.document.shift_frm.submit();
		}
		}
			else
			{
				if(operation_type == "modify")
				{
					
					
					if(frmObj.appl_for_working_days.disabled==true)
					{
					frmObj.appl_for_working_days.disabled=false;
					}
					if(frmObj.appl_for_nonworking_days.disabled==true)
					{
						frmObj.appl_for_nonworking_days.disabled=false;
					}
					if(frmObj.appl_for_holidays.disabled==true)
					{
						frmObj.appl_for_holidays.disabled=false;
					}
					shift_code = frmObj.shift_code.value;
					short_desc = frmObj.short_desc.value;
					long_desc = frmObj.long_desc.value;
					shift_indicator = frmObj.shift_indicator.value;
					shift_start_time = frmObj.starthour.value+":"+frmObj.startmin.value;
					shift_end_time = frmObj.endhour.value+":"+frmObj.endmin.value;
					productive_flag = frmObj.productive_flagChk.value;
					
					mnemonic_key = frmObj.mnemonic_key.value;
					
					if(frmObj.appl_for_working_days.checked)
					{
						frmObj.appl_for_working_days.value='Y';
					}
					else
					{
						frmObj.appl_for_working_days.value='N';
					}
					if(frmObj.appl_for_nonworking_days.checked)
					{
						frmObj.appl_for_nonworking_days.value='Y';
					}
					else
					{
						frmObj.appl_for_nonworking_days.value='N';
					}
					if(frmObj.appl_for_holidays.checked)
					{
						frmObj.appl_for_holidays.value='Y';
					}
					else
					{
						frmObj.appl_for_holidays.value='N';
					}
					
					if(frmObj.eff_status.checked)
					{
						frmObj.eff_status.value='E';
					}
					else
					{
						frmObj.eff_status.value='D';
					}
					appl_for_working_days = frmObj.appl_for_working_days.value;
					
					appl_for_nonworking_days = frmObj.appl_for_nonworking_days.value;
					
					appl_for_holidays = frmObj.appl_for_holidays.value;
					
					eff_status = frmObj.eff_status.value;
					if(shift_indi == 'P' || shift_indi == 'U')
			        {
				        var fields = new Array (frmObj.shift_indicator, frmObj.shift_code,
						frmObj.short_desc, frmObj.long_desc, frmObj.starthour,
						frmObj.startmin, frmObj.endhour, frmObj.endmin, frmObj.mnemonic_key);

						var names = new Array (  getLabel("Common.ShiftIndicator.label","common"),   getLabel("eAM.ShiftID.label","am"), getLabel("Common.shortdescription.label","common"), getLabel("Common.longdescription.label","common"),getLabel("eAM.FromHours.label","AM"),getLabel("eAM.FromMins.label","AM") , "To Hours","To Mins",getLabel("eAM.MnemonicforShiftID.label","am") );	
						if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
				        {					
							if(frmObj.appl_for_working_days.checked == false && 
							frmObj.appl_for_nonworking_days.checked == false && frmObj.appl_for_holidays.checked == false)
							{
								//message = "APP-AM0027 Atleast one Applicability Should be specified";
								message =getMessage("AM0119","AM");
								messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
							}
							else if((frmObj.starthour.value)==(frmObj.endhour.value)&&(frmObj.startmin.value)==(frmObj.endmin.value))
							{
								//message = "APP-AM0027 Working Days From and To cannot be Equal";
								message =getMessage("START_END_NOT_EQUAL","AM");
								messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;					
							}
							else
							{						
								f_query_add_mod.document.shift_frm.submit();
							}
                
                        }

			     }
				else
				{
				
					var fields = new Array (frmObj.shift_indicator, frmObj.shift_code,
						frmObj.short_desc, frmObj.long_desc, frmObj.starthour,
						frmObj.startmin, frmObj.endhour, frmObj.endmin, frmObj.mnemonic_key);

	                var names = new Array (  getLabel("Common.ShiftIndicator.label","common"),  getLabel("eAM.ShiftID.label","am"), getLabel("Common.shortdescription.label","common"), getLabel("Common.longdescription.label","common"),getLabel("eAM.FromHours.label","AM"),getLabel("eAM.FromMins.label","AM") , "To Hours","To Mins",getLabel("eAM.MnemonicforShiftID.label","am") );	
					if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
					f_query_add_mod.document.shift_frm.submit();
				}
				}
				else
				{
				
					var fields = new Array (frmObj.shift_indicator, frmObj.shift_code,
						frmObj.short_desc, frmObj.long_desc, frmObj.starthour,
						frmObj.startmin, frmObj.endhour, frmObj.endmin, frmObj.mnemonic_key);

	                var names = new Array ( getLabel("Common.ShiftIndicator.label","common"),  getLabel("eAM.ShiftID.label","am"), getLabel("Common.shortdescription.label","common"), getLabel("Common.longdescription.label","common"),getLabel("eAM.FromHours.label","AM"),getLabel("eAM.FromMins.label","AM") , "To Hours","To Mins",getLabel("eAM.MnemonicforShiftID.label","am"));	
					if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
					  f_query_add_mod.document.shift_frm.submit();
				}
				
				//f_query_add_mod.location.reload();
			}
		  
		
		/*else
		{
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
		}*/
		isApply = "true";
}

function reset()
{
	if(f_query_add_mod.document.forms[0])
	f_query_add_mod.location.reload();

else
{
	if(parent.frames[1].frames[1].document.forms[0].name=="query_form")
	f_query_add_mod.document.location.reload();	
else
	{
	}
}
}


function chngradio()
{
document.shift_frm.productive_flagChk.value=document.shift_frm.productive_flag.value;
}

function showShiftIndicatorType(target)
{
	
	if(target.value == 'P')
	{
		show_shift_radio.innerHTML = "<input type=radio name='productive_flag' id='productive_flag' value='W' checked> Working <input type=radio name='productive_flag' id='productive_flag' value='O'> On Call &nbsp; <img src='../../eCommon/images/mandatory.gif'align='center'></img>";
		
		document.shift_frm.appl_for_working_days.checked = false;
		document.shift_frm.appl_for_working_days.disabled = false;
			
		document.shift_frm.appl_for_nonworking_days.checked = false;
		document.shift_frm.appl_for_nonworking_days.disabled = false;

		document.shift_frm.appl_for_holidays.checked = false;
		document.shift_frm.appl_for_holidays.disabled = false;
		//show_from_mandatory.innerHTML = "<img src='../../eCommon/images/mandatory.gif'align='center'></img>";
		//show_to_mandatory.innerHTML = "<img src='../../eCommon/images/mandatory.gif'align='center'></img>";
	}
	else
	{
		show_shift_radio.innerHTML = "";
		if(target.value == 'A' || target.value == 'L')
		{
			document.shift_frm.appl_for_working_days.checked = false;
			document.shift_frm.appl_for_working_days.disabled = true;
			
			document.shift_frm.appl_for_nonworking_days.checked = false;
			document.shift_frm.appl_for_nonworking_days.disabled = true;

			document.shift_frm.appl_for_holidays.checked = false;
			document.shift_frm.appl_for_holidays.disabled = true;

			show_from_mandatory.innerHTML = "";
			show_to_mandatory.innerHTML = "";		
		}
		else
		{
			document.shift_frm.appl_for_working_days.checked = false;
			document.shift_frm.appl_for_working_days.disabled = false;
			
			document.shift_frm.appl_for_nonworking_days.checked = false;
			document.shift_frm.appl_for_nonworking_days.disabled = false;

			document.shift_frm.appl_for_holidays.checked = false;
			document.shift_frm.appl_for_holidays.disabled = false;

		//	show_from_mandatory.innerHTML = "<img src='../../eCommon/images/mandatory.gif'align='center'></img>";
			//show_to_mandatory.innerHTML = "<img src='../../eCommon/images/mandatory.gif'align='center'></img>";
		}
	}
	
}

function checkForSpecial(target)
{
	
	var strCheck = '0123456789';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);
	if(strCheck.indexOf(key) == -1)
	{
		message		 = getMessage("SPECIAL_CHARCTERS_NOT_ALLOWED","SM");
		parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		target.value = "";
		//target.focus();
		//return;
	}
	else
	{
		message = "";
		parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
	}
	
}

function CheckForNumbers(target)
{
	

	var frmObj = document.shift_frm;
	
	
		if(target.value == '')
		{
		if(target.name == 'starthour')
		{
			message = getMessage("FROMTIME_CANNOT_BE_BLANK","SM");
			parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			target.focus();
			target.value="";
		}
		else
		{
			if(target.name == 'endhour')
			{	
				message = "APP-AM0028 To Time Cannot be blank";
				parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
				target.focus();
				target.value="";
			}
			else
			{
				if(target.name == 'startmin')
				{
					//target.value = "00";
				}
				else
				{
					//target.value = "00";
					
					var a = frmObj.starthour.value;
					var b = frmObj.startmin.value;
					var c = frmObj.endhour.value;
					var d = frmObj.endmin.value;
					
						frmObj.durn_hh.value = c - a;
						frmObj.durn_hh.value = Math.abs(frmObj.durn_hh.value);

					if(frmObj.durn_hh.value == 0)
						frmObj.durn_hh.value = '00';
					else
					{
						if(frmObj.durn_hh.value <10)
							frmObj.durn_hh.value = '0' + frmObj.durn_hh.value;
					}

						frmObj.durn_mm.value = d - b;
						frmObj.durn_mm.value = Math.abs(frmObj.durn_mm.value);	

					if(frmObj.durn_mm.value == 0)
						frmObj.durn_mm.value = '00';
					else
					{
						if(frmObj.durn_mm.value < 10)
							frmObj.durn_mm.value = '0' + frmObj.durn_mm.value;
					}
				}
				message = "";
				parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			}
		}
		}
		else
		{
			if(target.name == 'starthour')
			{
				if(target.value < 0)
				{
					message = "APP-AM0028 Time in Hours should be between 0 and 23";
					parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
					target.focus();
					target.value="";
				}
				if(target.value > 23)
				{
					message = "APP-AM0028 Time in Hours should be between 0 and 23";
					parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
					target.focus();
					target.value="";
				}
				if(target.value >= 0 || target.value <= 23)
				{
					if(target.value < 10)
					{
						if((target.value).charAt(0) != '0')
							target.value = '0' + target.value;
					}
				}
			}
			if(target.name == 'startmin')
			{
				if(target.value < 0)
				{
					message = "APP-AM0028 Time in Minutes should be between 0 and 59";
					parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
					target.focus();
					target.value="";
				}
				if(target.value > 59)
				{
					message = "APP-AM0028 Time in Minutes should be between 0 and 59";
					parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
					target.focus();
					target.value="";
				}
				if(target.value >= 0 || target.value <= 59)
				{
					if(target.value < 10)
					{
						if((target.value).charAt(0) != '0')
							target.value = '0' + target.value;
					}
				}
			}
			if(target.name == 'endhour')
			{
				if(target.value < 0)
				{
					message = "APP-AM0028 Time in Hours should be between 0 and 23";
					parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
					target.focus();
					target.value="";
				}
				if(target.value > 23)
				{
					message = "APP-AM0028 Time in Hours should be between 0 and 23";
					parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
					target.focus();
					target.value="";
				}
				if(target.value >= 0 || target.value <= 23)
				{
					if(target.value < 10)
					{
						if((target.value).charAt(0) != '0')
							target.value = '0' + target.value;
					}
				}
			}
			if(target.name == 'endmin')
			{
				if(target.value < 0)
				{
					message = "APP-AM0028 Time in Minutes should be between 0 and 59";
					parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
					target.focus();
					target.value="";
				}
				if(target.value > 59)
				{
					message = "APP-AM0028 Time in Minutes should be between 0 and 59";
					parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
					target.focus();
					target.value="";
				}

				if(target.value >= 0 || target.value <= 59)
				{
					if(target.value < 10)
					{
						if((target.value).charAt(0) != '0')
							target.value = '0' + target.value;
					}
				}
				
				var a = frmObj.starthour.value;
				var b = frmObj.startmin.value;
				var c = frmObj.endhour.value;
				var d = frmObj.endmin.value;
				
					frmObj.durn_hh.value = c - a;
					frmObj.durn_hh.value = Math.abs(frmObj.durn_hh.value);
				
				if(frmObj.durn_hh.value == 0)
					frmObj.durn_hh.value = '00';
				else
				{
					if(frmObj.durn_hh.value <10)
						frmObj.durn_hh.value = '0' + frmObj.durn_hh.value;
				}
				
					frmObj.durn_mm.value = d - b;
					frmObj.durn_mm.value = Math.abs(frmObj.durn_mm.value);

				if(frmObj.durn_mm.value == 0)
					frmObj.durn_mm.value = '00';
				else
				{
					if(frmObj.durn_mm.value < 10)
						frmObj.durn_mm.value = '0' + frmObj.durn_mm.value;
				}
			}
		}


	


}

function checkActive(target)
{

	if(target.checked == false)
	{
		target.value = "D";
		target.checked = false;
	}
	else
	{
		target.value = "E";
		target.checked = true;
	}

}

function checkActiveApplicable(target)
{

	if(target.checked == false)
	{
		target.value = "N";
		target.checked = false;
	}
	else
	{
		target.value = "Y";
		target.checked = true;
	}

}

function onSuccess() 
{
	var frmObj = f_query_add_mod.document.shift_frm;
	var operation_type = frmObj.operation_type.value;

if(operation_type=="insert")	
{
	f_query_add_mod.location.reload();

}
else
{
	f_query_add_mod.location.href="../../eAM/jsp/ShiftAddModify.jsp?mode=2&shift_code="+shift_code+"&short_desc="+short_desc+"&long_desc="+long_desc+"&shift_indicator="+shift_indicator+"&shift_start_time="+shift_start_time+"&shift_end_time="+shift_end_time+"&productive_flag="+productive_flag+"&mnemonic_key="+mnemonic_key+"&appl_for_working_days="+appl_for_working_days+"&appl_for_nonworking_days="+appl_for_nonworking_days+"&appl_for_holidays="+appl_for_holidays+"&eff_status="+eff_status;
}
}

function goHomePage(){
				parent.location.href='../../eCommon/jsp/dmenu.jsp';
		}
		
		function chcol(ro)
		{
				var prev=0;
				var prevcol='MENUSUBLEVELCOLOR';
				document.getElementById('t').rows(prev).cells(0).className=prevcol;
				prevcol=ro.cells(0).className;
				ro.cells(0).className="MENUSELECTEDCOLOR";
				prev=ro.rowIndex;
		}

		function callJSPs(val)
		{
			

			if (val=='Shift'){
				parent.frames[1].location.href='Shift.jsp?module_id=AM&function_id=DurationType&function_name=Shift&function_type=f&access=YYYNN';
			}
			if (val=='Shift_for_locn_type'){
				parent.frames[1].location.href='ShiftForLocationType.jsp?module_id=AM&function_id=Shift_for_locn_type&function_name=Shift for Location Type&function_type=f&access=YYYNN';
			}
			if (val=='Shift_for_position'){
				parent.frames[1].location.href='ShiftForPosition.jsp?module_id=AM&function_id=Shift_for_position&function_name=Shift for Position&function_type=f&access=YYYNN';
			}
		}



   async function showFunctionality(){
		var retVal = new Array(); 

		var features	= 'dialogHeight:33; dialogWidth:15;dialogLeft:2;dialogTop:60;status=no;scroll=no;title=no;fullscreen=1';  
		var arguments	= '' ;  
		
		var vals = parent.parent.header.document.header_form.menu_values.value;
		MPMasterMenu_form.menu_values.value = vals;
 		
		arguments = vals

		
		retVal	= await window.showModalDialog('change_functionality.jsp',arguments,features);


		if(retVal != null)
		{
			//alert(retVal)
			retVal = retVal.replace("location","parent.parent.frames[1].location")
			eval(retVal)
		}
	}
	/*******************************************************************************************/

	function allowPositiveNumber() 
	{
		var key = window.event.keyCode;// allows only numbers to be entered
		if((key<48 )||(key>58)) 
			{
				return false;
			}
	}

	function CheckForSpecChars1(event){
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode -= 32);
	return true ;
}

