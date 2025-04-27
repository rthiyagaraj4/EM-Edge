function notallowenter(event)
{
	if(window.event.keyCode==13)
		return false
	var desc = document.ManageWorkScheduleTransfer.remarks.value;
	var len = eval(desc.length);
	if(len>=2000)
	{
		document.ManageWorkScheduleTransfer.remarks.readOnly = true;
		return false
	}
}
function shiftchk()
{
	
	var cnt = eval(document.ManageWorkScheduleTransfer.count.value);
	var j = 0;
	var sft_cd = "";
	
	for(i=1;i<=cnt;i++)
	{	
		
		var chk_val = eval("document.ManageWorkScheduleTransfer.chk"+i);
		
		
		if(eval("document.ManageWorkScheduleTransfer.chk"+i+".checked")==true)
		{	
			
			chk_val.value = 'Y';
			if(chk_val.value == 'Y')
			{	
				if(i==1)
				{	
					
					sft_cd = eval("document.ManageWorkScheduleTransfer.sft_code"+i+".value");
					
				}
				else
				{ 
					sft_cd += ","+eval("document.ManageWorkScheduleTransfer.sft_code"+i+".value");
					
				}
				
			}
			else
			{
			}
			
			j++;
		}
		
	}
	if(j==0)
	{	
		document.ManageWorkScheduleTransfer.transfer.value = "";
		
	}
	if(document.ManageWorkScheduleTransfer.transfer.value!="")
	{	
		
		var transfer = document.ManageWorkScheduleTransfer.transfer.value;
		var p_schedule_date = document.ManageWorkScheduleTransfer.p_schedule_date.value;
		var p_facility_id = document.ManageWorkScheduleTransfer.p_facility_id.value;
		var p_position_code = document.ManageWorkScheduleTransfer.p_position_code.value;
		
		
		var htmlvalue = "<html><body><form name='dynamic_value' id='dynamic_value' method='post' action='../../eRS/jsp/ManageWorkScheduleTransferDynamicValues.jsp'><input type='hidden' name='shift_val' id='shift_val' value='"+sft_cd+"'><input type='hidden' name='p_schedule_date' id='p_schedule_date' value='"+p_schedule_date+"'><input type='hidden' name='transfer' id='transfer' value='"+transfer+"'><input type='hidden' name='p_facility_id' id='p_facility_id' value='"+p_facility_id+"'><input type='hidden' name='p_position_code' id='p_position_code' value='"+p_position_code+"'></form></body></html>";
		//var htmlvalue = "<html><body><form name='dynamic_value' id='dynamic_value' method='post' action='../../eRS/jsp/ManageWorkScheduleTransferDynamicValues.jsp'><input type='hidden' name='shift_val' id='shift_val' value='"+sft_cd+"'><input type='hidden' name='p_schedule_date' id='p_schedule_date' value='"+p_schedule_date+"'><input type='hidden' name='transfer' id='transfer' value='"+transfer+"'><input type='hidden' name='p_facility_id' id='p_facility_id' value='"+p_facility_id+"'><input type='hidden' name='p_position_code' id='p_position_code' value='"+p_position_code+"'></form></body></html>";
		// alert("htmlvalue---->"+htmlvalue);
		parent.blankFrame.document.write(htmlvalue);
		
		parent.blankFrame.document.dynamic_value.submit();
	}
}
function wincls()
{
	window.close();
}
function apply()
{	
	 //alert("while applying:")
	var reason = document.ManageWorkScheduleTransfer.reason.value;
	var transfer = document.ManageWorkScheduleTransfer.transfer.value;
	
	if(transfer=="")
	{
		alert(getMessage("TRANSFER_BLANK","RS"));
		return false
	}
	if(reason=="")
	{
		alert(getMessage("REASON_BLANK","RS"));
		return false
	}
	
	document.ManageWorkScheduleTransfer.submit();
}

