
function apply()
{
	var fields = new Array(frames[1].document.forms[0].start_time,frames[1].document.forms[0].end_time);
	var names = new Array (getLabel("eDR.MergePatientStartTime.label","DR"),
							getLabel("eDR.MergePatientEndTime.label","DR"));
	if(frames[1].checkFieldsofMst(fields,names,messageFrame))
	{
		if(chkGrtr())	{
			f_query_add_mod.document.dr_param_form.action="../../servlet/eDR.DrParameterServlet";
			f_query_add_mod.document.dr_param_form.target="messageFrame";
			f_query_add_mod.document.dr_param_form.method="post";
			f_query_add_mod.document.dr_param_form.submit();
		} else { 			
			messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
		}
	}
}

function call(obj)
{
	var error = "";
	if(obj.name == "start_time")
	{
		if(obj.value == '' ||obj.value == null)
		{
			error = getMessage('CAN_NOT_BE_BLANK','Common');
			error = error.replace('$', getLabel("Common.StartTime.label","Common"));
			alert(error);
			obj.value = '';
		}
	}
	else if(obj.name == "end_time")
	{
		if(obj.value == '' ||obj.value == null)
		{
			error = getMessage('CAN_NOT_BE_BLANK','Common');
			error = error.replace('$', getLabel("Common.EndTime.label","Common"));
			alert(error);
			obj.value = '';
		}
	}
}

function checkDateObj(date, format, locale){
	if (date.value != '')
	{
		if ( !validDate(date.value, format, locale) )
		{
			if(top.header != null)
				alert(top.header.getMessage("INVALID_TIME_FMT", "SM"));
			else
				alert(getMessage("INVALID_TIME_FMT", "SM"));

			date.select();
			date.focus();
			return false;
		}
		else
			return true;
	}
}




function chkGrtr()
{
	var starttime = f_query_add_mod.document.forms[0].start_time.value;
	var endtime = f_query_add_mod.document.forms[0].end_time.value;		
    
	if(starttime != '' && endtime != '')
	{
		if(isAfter(starttime,endtime,"HM",localeName) == true)
		{
			var st_gt_en_tm = getMessage('ED_TIME_LESS_EQL_ST_TIME','DR');
			f_query_add_mod.document.forms[0].end_time.select();
			alert(st_gt_en_tm);				
			return false;
		}
		else 
			return true;
		
	}
}

function reset()
{
	
	frames[1].location.reload();
	messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp'
}

function onSuccess()
{
	//parent.frames[1].frames[1].location.reload();
	frames[1].location.reload();
}
