function reset()
{
 // 	patencdtlframe.location.reload();
  patencdtlframe.location.reload();
}	

function create()
{

}

function apply()
{

}


function checkDateBL(entered_date)
	{
		
	var locale=document.forms[0].locale.value;
	if(entered_date.value!="")
	{
		if(validDate(entered_date.value,'DMY',locale))
		{
			return true;
		}
		else
		{	
			alert(getMessage("INVALID_DATE_FMT","SM"));
			entered_date.select();
			return false;
		}
	}
	else
	{
		return true;
	}
}

function chkDtLessEqualThanSysDateNew(entered_date,sysdate)
	{
		
		var locale=document.forms[0].locale.value;
	
	if(entered_date.value!="")
	{
		if((validDate(entered_date.value,'DMY',locale)))
		{
			var enteredDate = entered_date.value ;
			var sysDate = sysdate.value;
			if(isBeforeNow(enteredDate,'DMY',locale))
			{
				return true;
			}
			else
			{
				alert(getMessage("BL9114",'BL'));
				entered_date.select();
				return false;
			}
		}
		else
		{
			alert(getMessage("INVALID_DATE_FMT","SM"));
			entered_date.select();
			return false;
		}
	}
	else
	{
		return true;
	}
}
