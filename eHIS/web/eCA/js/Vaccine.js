function create()
{
	
	f_query_add_mod.location.href='../../eCA/jsp/VaccineAddModify.jsp?mode=insert';
}

function query()
{
	
	f_query_add_mod.location.href='../../eCA/jsp/VaccineQueryCriteria.jsp';
}

function apply()
{
	var fields = new Array (
							f_query_add_mod.document.forms[0].vaccine_id,
							f_query_add_mod.document.forms[0].vaccine_long_desc,
							f_query_add_mod.document.forms[0].vaccine_short_desc
		                    //f_query_add_mod.document.forms[0].dup_chk_days, 
		                   // f_query_add_mod.document.forms[0].dup_chk_action
		          
							);

	var names = new Array (
							 f_query_add_mod.getLabel("eCA.id.label",'CA'),
							 f_query_add_mod.getLabel("eCA.LongDescription.label",'CA'),
							 f_query_add_mod.getLabel("eCA.ShortDescription.label",'CA')
		                    // f_query_add_mod.getLabel("eCA.DuplicateCheckDays.label",'CA'),
		                     //f_query_add_mod.getLabel("eCA.DuplicateCheckAction.label",'CA')
		
							);


	var status = "";
	
	if(f_query_add_mod.document.forms[0].check_dup_yn.checked)
	{
		if (f_query_add_mod.document.forms[0].dup_chk_days.value != null && f_query_add_mod.document.forms[0].dup_chk_days.value != '')
		{
			status = "S";			
		}else {
			status = "F";
		}
		
	}else {
		if (f_query_add_mod.document.forms[0].dup_chk_days.value != null && f_query_add_mod.document.forms[0].dup_chk_days.value != '')
		{
			status = "F";			
		}else {
			status = "S";
		}		
	}	
	
	if(status == "S")
	{
	
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
		{			
		
			var mode =	f_query_add_mod.document.forms[0].mode.value;
						
			var fields1 = new Array (f_query_add_mod.document.forms[0].vaccine_id);
			var names1 = new Array (f_query_add_mod.getLabel("eCA.id.label",'CA'));
					
			if (f_query_add_mod.SpecialCharCheck (fields1,names1,messageFrame,'M','MstCodeError.jsp'))
			{
				f_query_add_mod.document.forms[0].submit();		
			}
		}	
	}
	else
	{
	
		var errorMessage = "";
		errorMsg = getMessage("VACCINE_DUPLICATE_CHECK_DAYS","CA");
		messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+errorMsg
		commontoolbarFrame.location.reload();
		return false;
	}

//}

}

function deleterecord()
{
	if(f_query_add_mod.document.forms[0]!=null )
	{
		if(f_query_add_mod.document.forms[0].mode != null)
		{
			if(f_query_add_mod.document.forms[0].mode.value=="insert"){
			//commontoolbarFrame.location.reload();
			messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+messageArray["RECORD_CANNOT_DELETE"]
			}
			else{
				if(window.confirm(getMessage("DELETE_RECORD","Common")) == true)
				{
					f_query_add_mod.document.vaccine_form.mode.value='delete';
					f_query_add_mod.document.vaccine_form.submit();     
				}
				else
				{
					commontoolbarFrame.location.reload();
				}
			}
		}
		else
		{
			messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		}
	}
}

function onSuccess()
{
	
	if(f_query_add_mod.document.forms[0].mode.value=="insert")
		f_query_add_mod.location.href='../../eCA/jsp/VaccineAddModify.jsp?mode=insert';
	else if(f_query_add_mod.document.forms[0].mode.value=="update")
	       f_query_add_mod.location.reload();
	else     
	      f_query_add_mod.location.href='../../eCommon/html/blank.html';

}
function reset()
{
	if(f_query_add_mod.document.forms[0]!=null)
	f_query_add_mod.document.forms[0].reset();

}

function CheckForSpecCharsNoCaps(event){
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_* ';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode);
	return true ;
}

function OnAdhocChange(obj)
{
	if(obj.checked)
	{
		document.vaccine_form.adh_yn.value = 'Y'
	}
	else
	{
		document.vaccine_form.adh_yn.value = 'N'
	}

}

function OnChkReqDaysChange(obj)
{
	
	if(obj.checked)
	{		
		document.vaccine_form.chk_yn.value = 'Y'		
	}
	else
	{	
		document.vaccine_form.chk_yn.value = 'N'
	}
/*function checkForMode(objCheck)
{
	var mode = document.forms[0].mode.value;
	
	if(mode == 'update')
	{
		
		if(objCheck.checked== true)
		{
			document.forms[0].eff_status1.value='E'
		}
		else
		{
			document.forms[0].eff_status1.value='D'
		}
	}
}*/

/*
function OnConfChange(obj,val)
{
	var selVal = "document.vaccine_form."+val+".value";
	if(obj.checked && val == 'chk_yn')
	{		
	//	document.vaccine_form.chk_yn.value = 'Y'
		
		alert("document.vaccine_form."+val+".value");
		eval(selVal) = 'Y'
	}
	else
	{
		eval(selVal) = 'N'
		//document.vaccine_form.chk_yn.value = 'N'
	}
	*/
}
