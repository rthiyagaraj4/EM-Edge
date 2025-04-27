function popuvalues()
{
	var p_schedule_date = document.ChangeShift.p_schedule_date.value;
	var shift_val = document.ChangeShift.new_shift.value;
	var shift_code = document.ChangeShift.p_shift_code.value;
	var sftcode = shift_code.split("|");
	for(i=0;i<sftcode.length;i++)
	{
		if(shift_val==trimString(sftcode[i]))
		{
			alert(getMessage("ALREADY_SHIFT_ASSIGNED","RS"));
			document.ChangeShift.new_shift.value = "";
			document.getElementById("productive").innerText = "";
			return false;
		}
	}
	var htmlvalue = "<html><body><form name='dynamic_value' id='dynamic_value' method='post' action='../../eRS/jsp/ManageWorkScheduleChangeDynamicValues.jsp'><input type='hidden' name='shift_val' id='shift_val' value='"+shift_val+"'><input type='hidden' name='p_schedule_date' id='p_schedule_date' value='"+p_schedule_date+"'></form></body></html>";
	parent.blankFrame.document.write(htmlvalue);
	parent.blankFrame.document.dynamic_value.submit();

}
function apply()
{
	var old_shift_val = document.ChangeShift.old_shift_val.value;
	var new_shift_val = document.ChangeShift.new_shift.value;
	var reason = document.ChangeShift.reason.value;
	if(old_shift_val=="" || document.ChangeShift.old_shift.checked==false)
	{
		alert(getMessage("SHIFT_SELECT_CHANGE","RS"));
		return false
	}
	if(new_shift_val=="")
	{
		alert(getMessage("NEW_SHIFT_NOT_BLANK","RS"));
		return false
	}
	if(reason=="")
	{
		alert(getMessage("REASON_BLANK","RS"));
		return false
	}
	document.ChangeShift.submit();
}


function wincls()
{
	window.close();
}

function shiftchk(obj)
{
	document.ChangeShift.old_shift_val.value = obj.value;
}

function notallowenter(event)
{
	if(window.event.keyCode==13)
		return false
	var desc = document.ChangeShift.remarks.value;
	var len = eval(desc.length);
	if(len>=2000)
	{
		document.ChangeShift.remarks.readOnly = true;
		return false
	}
}

