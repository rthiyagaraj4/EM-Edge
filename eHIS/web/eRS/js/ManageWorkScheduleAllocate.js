function notallowenter(event)
{
	
	if(window.event.keyCode==13)
		return false
	var desc = document.ManageWorkScheduleAllocate.remarks.value;
	var len = eval(desc.length);
	if(len>=2000)
	{
		document.ManageWorkScheduleAllocate.remarks.readOnly = true;
		return false
	}
}
function popuvalues()
{
	
	var shift_val = document.ManageWorkScheduleAllocate.shift.value;
	var shift_code = document.ManageWorkScheduleAllocate.p_shift_code.value;
	var p_schedule_date = document.ManageWorkScheduleAllocate.p_schedule_date.value;
	var sftcode = shift_code.split("|");
	
	for(i=0;i<sftcode.length;i++)
	{
		if(shift_val==trimString(sftcode[i]))
		{
			alert(getMessage("CANNOT_ASSIGN_SHIFT","RS"));
			document.ManageWorkScheduleAllocate.shift.value = "";
			document.getElementById("productive").innerText = "";
			return false;
		}
	}
	
	var htmlvalue = "<html><body><form name='dynamic_value' id='dynamic_value' method='post' action='../../eRS/jsp/ManageWorkScheduleAllocateDynamicValues.jsp'><input type='hidden' name='shift_val' id='shift_val' value='"+shift_val+"'><input type='hidden' name='p_schedule_date' id='p_schedule_date' value='"+p_schedule_date+"'></form></body></html>";
	
	parent.blankFrame.document.write(htmlvalue);
	parent.blankFrame.document.dynamic_value.submit();
}
function wincls()
{
	window.close();
}
function apply()
{	
	var shift_val = document.ManageWorkScheduleAllocate.shift.value;
	var reason = document.ManageWorkScheduleAllocate.reason.value;
	
	if(shift_val=="")
	{
		alert(getMessage("SHIFT_BLANK","RS"));
		return false
	}
	if(reason=="")
	{
		alert(getMessage("REASON_BLANK","RS"));
		return false
	}
	document.ManageWorkScheduleAllocate.submit();
	
}

