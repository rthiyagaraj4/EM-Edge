function shiftchk(obj)
{
	//alert(obj.value)
	document.ManageWorkScheduleSwap.staff1_shiftcode_value.value = obj.value;
}
function swapwith()
{ 
	var staff1_shift_code=document.ManageWorkScheduleSwap.staff1_shiftcode_value.value;
	if(staff1_shift_code==null || staff1_shift_code=="")
	{
	alert(getMessage("ONE_SHIFT_SELECT_FOR_SWAP","RS"));
	}
	else
	{			
		 var p_facility_id=document.ManageWorkScheduleSwap.p_facility_id.value;
		 var p_role_type=document.ManageWorkScheduleSwap.p_role_type.value;
		 var p_staff_id=document.ManageWorkScheduleSwap.p_staff_id.value;
		 var p_schedule_date=document.ManageWorkScheduleSwap.p_schedule_date.value;
		 var p_workplace_code=document.ManageWorkScheduleSwap.p_workplace_code.value;
		 var p_position_code=document.ManageWorkScheduleSwap.p_position_code.value;
		 var grade_code=document.ManageWorkScheduleSwap.grade_code.value;
		 var grade_level=document.ManageWorkScheduleSwap.grade_level.value;
		 var staff_subs_same_grade_yn=document.ManageWorkScheduleSwap.staff_subs_same_grade_yn.value;
		 var staff_subs_high_to_low_yn=document.ManageWorkScheduleSwap.staff_subs_high_to_low_yn.value;
		 var staff_subs_low_to_high_yn=document.ManageWorkScheduleSwap.staff_subs_low_to_high_yn.value;
		 var count=document.ManageWorkScheduleSwap.count.value;

		 
		 for(i=0;i<document.ManageWorkScheduleSwap.elements.length;i++){
			
			document.ManageWorkScheduleSwap.elements[i].disabled=true;
	 }
		
	parent.ManageWorkScheduleSwap_frame.location.href = "../jsp/ManageWorkScheduleSwapWith.jsp?p_facility_id="+p_facility_id+"&p_role_type="+p_role_type+"&p_staff_id="+p_staff_id+"&p_schedule_date="+p_schedule_date+"&countval="+count+"&p_position_code="+p_position_code+"&staff1_shift_code="+staff1_shift_code+"&p_workplace_code="+p_workplace_code+"&grade_code="+grade_code+"&grade_level="+grade_level+"&staff_subs_same_grade_yn="+staff_subs_same_grade_yn+"&staff_subs_high_to_low_yn="+staff_subs_high_to_low_yn+"&staff_subs_low_to_high_yn="+staff_subs_low_to_high_yn;
	
	parent.ManageWorkScheduleButtons_frame.location.href ="../jsp/ManageWorkScheduleSwapButtons.jsp";
   }
	
}

function wincls()
{
	window.close();
}

function resetVals() 
{
	var frmObj=parent.ManageWorkSchedule_frame.document.ManageWorkScheduleSwap;
	for(i=0;i<frmObj.elements.length;i++){
	frmObj.elements[i].disabled=false;
			}
    frmObj.reset();
	parent.ManageWorkScheduleSwap_frame.location.href='../../eCommon/html/blank.html';	
	parent.ManageWorkScheduleStaff2Shifts_frame.location.href='../../eCommon/html/blank.html';			
	
}
function populateStaff(form)
{	
	 var new_workplace_code=document.ManageWorkScheduleSwap1.new_workplace.value;
	 
	 var p_facility_id=document.ManageWorkScheduleSwap1.p_facility_id.value;
	 var p_role_type=document.ManageWorkScheduleSwap1.p_role_type.value;
	 var p_staff_id=document.ManageWorkScheduleSwap1.p_staff_id.value;
	 var p_schedule_date=document.ManageWorkScheduleSwap1.p_schedule_date.value;
	 var p_position_code=document.ManageWorkScheduleSwap1.p_position_code.value;
	 var grade_code=document.ManageWorkScheduleSwap1.grade_code.value;
	 var grade_level=document.ManageWorkScheduleSwap1.grade_level.value;
	 var staff_subs_same_grade_yn=document.ManageWorkScheduleSwap1.staff_subs_same_grade_yn.value;
	 var staff_subs_high_to_low_yn=document.ManageWorkScheduleSwap1.staff_subs_high_to_low_yn.value;
	 var staff_subs_low_to_high_yn=document.ManageWorkScheduleSwap1.staff_subs_low_to_high_yn.value;
	 document.ManageWorkScheduleSwap1.new_workplace_code.value=new_workplace_code;
	 removeitems(form.new_staff);
	 
	 var htmlvalue = "<html><body><form name='dynamic_value' id='dynamic_value' method='post' action='../../eRS/jsp/ManageWorkScheduleSwapDynamicValues.jsp'><input type='hidden' name='p_facility_id' id='p_facility_id' value='"+p_facility_id+"'><input type='hidden' name='new_workplace_code' id='new_workplace_code' value='"+new_workplace_code+"'><input type='hidden' name='p_schedule_date' id='p_schedule_date' value='"+p_schedule_date+"'><input type='hidden' name='p_position_code' id='p_position_code' value='"+p_position_code+"'><input type='hidden' name='p_role_type' id='p_role_type' value='"+p_role_type+"'><input type='hidden' name='p_staff_id' id='p_staff_id' value='"+p_staff_id+"'><input type='hidden' name='grade_level' id='grade_level' value='"+grade_level+"'><input type='hidden' name='staff_subs_same_grade_yn' id='staff_subs_same_grade_yn' value='"+staff_subs_same_grade_yn+"'><input type='hidden' name='staff_subs_high_to_low_yn' id='staff_subs_high_to_low_yn' value='"+staff_subs_high_to_low_yn+"'><input type='hidden' name='staff_subs_low_to_high_yn' id='staff_subs_low_to_high_yn' value='"+staff_subs_low_to_high_yn+"'></form></body></html>";
	 //alert("htmlvalue------>"+htmlvalue);
	 parent.blankFrame.document.write(htmlvalue);
	 parent.blankFrame.document.dynamic_value.submit();

}
function removeitems(obj)
{
	var len=obj.length;
	var i=1;
	while(i<len)
	{
		len=obj.length
		obj.remove(i)
	}
}

function populateNewShifts()
{
	 var new_staff_id=document.ManageWorkScheduleSwap1.new_staff.value;
	 var p_facility_id=document.ManageWorkScheduleSwap1.p_facility_id.value;
	 var p_role_type=document.ManageWorkScheduleSwap1.p_role_type.value;
	 var p_schedule_date=document.ManageWorkScheduleSwap1.p_schedule_date.value;
	 var p_position_code=document.ManageWorkScheduleSwap1.p_position_code.value;
	 var p_workplace_code=document.ManageWorkScheduleSwap1.p_workplace_code.value;
	 var new_workplace_code=document.ManageWorkScheduleSwap1.new_workplace_code.value;
	 var p_requirement_id=document.ManageWorkScheduleSwap1.p_requirement_id.value;
	 
	 document.ManageWorkScheduleSwap1.new_staff_id.value = new_staff_id;

	 parent.ManageWorkScheduleStaff2Shifts_frame.location.href = "../jsp/ManageWorkScheduleSwapGetStaff2Shifts.jsp?p_facility_id="+p_facility_id+"&p_schedule_date="+p_schedule_date+"&p_position_code="+p_position_code+"&p_workplace_code="+p_workplace_code+"&new_workplace_code="+new_workplace_code+"&p_role_type="+p_role_type+"&new_staff_id="+new_staff_id+"&p_requirement_id="+p_requirement_id;
}


function staff2shiftchk(obj)
{
	document.ManageWorkScheduleStaff2shifts_form.staff2_shiftcode_value.value = obj.value;
}

function apply()
{
	if (! checkIsValidForProceed() ) {
		message  = getMessage("NOT_VALID","Common");
		alert(message);
		return false ;
	}
	var i=0;
	var new_workplace=parent.ManageWorkScheduleSwap_frame.document.ManageWorkScheduleSwap1.new_workplace.value;
	if(new_workplace=="")
	  {	
		var i=1;
		alert(getMessage("WORKPLACE_NOT_BLANK","RS"));
		return false
	  }

	var new_staff_val = parent.ManageWorkScheduleSwap_frame.document.ManageWorkScheduleSwap1.new_staff.value;
	if(new_staff_val=="")
	{	
		var i=2;
		alert(getMessage("STAFF_NOT_BLANK","RS"));
		return false
	}
	var staff2_shiftcode_value=parent.ManageWorkScheduleStaff2Shifts_frame.document.ManageWorkScheduleStaff2shifts_form.staff2_shiftcode_value.value;
	if(staff2_shiftcode_value=="" || (parent.ManageWorkScheduleStaff2Shifts_frame.document.ManageWorkScheduleStaff2shifts_form.staff2_shft_code.checked==false))
	  {
		 alert(getMessage("ONE_SHIFT_SELECT_FOR_SWAP","RS"));
		 return false
	   }
	if(parent.ManageWorkScheduleStaff2Shifts_frame.document.ManageWorkScheduleStaff2shifts_form.reason.value == "" && i==0)
	  {
		alert(getMessage("REASON_BLANK","RS"));
		return false
	  }
	var staff1_shiftcode_value=parent.ManageWorkSchedule_frame.document.ManageWorkScheduleSwap.staff1_shiftcode_value.value;
	
	var staff1_allocated_shifts_string=parent.ManageWorkSchedule_frame.document.ManageWorkScheduleSwap.staff1_allocated_shifts_string.value;
	var staff2_allocated_shifts_string=parent.ManageWorkScheduleStaff2Shifts_frame.document.ManageWorkScheduleStaff2shifts_form.staff2_allocated_shifts_string.value;
	
	parent.ManageWorkScheduleStaff2Shifts_frame.ManageWorkScheduleStaff2shifts_form.submit();

}
function validate()
{
	 var new_staff_val = parent.ManageWorkScheduleSwap_frame.document.ManageWorkScheduleSwap1.new_staff.value;
	 var staff1_shiftcode_value=parent.ManageWorkSchedule_frame.document.ManageWorkScheduleSwap.staff1_shiftcode_value.value;
	 var staff2_shiftcode_value=parent.ManageWorkScheduleStaff2Shifts_frame.document.ManageWorkScheduleStaff2shifts_form.staff2_shiftcode_value.value;
	 var staff1_allocated_shifts_string=parent.ManageWorkSchedule_frame.document.ManageWorkScheduleSwap.staff1_allocated_shifts_string.value;
	 var staff2_allocated_shifts_string=parent.ManageWorkScheduleStaff2Shifts_frame.document.ManageWorkScheduleStaff2shifts_form.staff2_allocated_shifts_string.value;
	 var reason=parent.ManageWorkScheduleStaff2Shifts_frame.document.ManageWorkScheduleStaff2shifts_form.reason.value;
	 var remarks=parent.ManageWorkScheduleStaff2Shifts_frame.document.ManageWorkScheduleStaff2shifts_form.remarks.value;
	 var durn_for_swap_from_sos=parent.ManageWorkScheduleStaff2Shifts_frame.document.ManageWorkScheduleStaff2shifts_form.durn_for_swap_from_sos.value;
	 var staff1_shiftcode_value=parent.ManageWorkSchedule_frame.document.ManageWorkScheduleSwap.staff1_shiftcode_value.value;
	 var p_facility_id=parent.ManageWorkSchedule_frame.document.ManageWorkScheduleSwap.p_facility_id.value;
	 var p_role_type=parent.ManageWorkSchedule_frame.document.ManageWorkScheduleSwap.p_role_type.value;
	 var p_staff_id=parent.ManageWorkSchedule_frame.document.ManageWorkScheduleSwap.p_staff_id.value;
	 var p_schedule_date=parent.ManageWorkSchedule_frame.document.ManageWorkScheduleSwap.p_schedule_date.value;
	 var p_workplace_code=parent.ManageWorkSchedule_frame.document.ManageWorkScheduleSwap.p_workplace_code.value;
	 var p_position_code=parent.ManageWorkSchedule_frame.document.ManageWorkScheduleSwap.p_position_code.value; 
	 var p_staff_type=parent.ManageWorkSchedule_frame.document.ManageWorkScheduleSwap.p_staff_type.value; 
	 var new_workplace_code=parent.ManageWorkScheduleSwap_frame.document.ManageWorkScheduleSwap1.new_workplace_code.value;
	 var p_requirement_id=parent.ManageWorkScheduleSwap_frame.document.ManageWorkScheduleSwap1.p_requirement_id.value;
		 
	 var htmlvalue = "<html><body><form name='dynamic_value' id='dynamic_value' method='post' action='../../eRS/jsp/ManageWorkScheduleSwapValidate.jsp'><input type='hidden' name='p_facility_id' id='p_facility_id' value='"+p_facility_id+"'><input type='hidden' name='p_role_type' id='p_role_type' value='"+p_role_type+"'><input type='hidden' name='p_staff_type' id='p_staff_type' value='"+p_staff_type+"'><input type='hidden' name='p_staff_id' id='p_staff_id' value='"+p_staff_id+"'><input type='hidden' name='p_schedule_date' id='p_schedule_date' value='"+p_schedule_date+"'><input type='hidden' name='p_position_code' id='p_position_code' value='"+p_position_code+"'><input type='hidden' name='p_workplace_code' id='p_workplace_code' value='"+p_workplace_code+"'><input type='hidden' name='p_requirement_id' id='p_requirement_id' value='"+p_requirement_id+"'><input type='hidden' name='staff1_shift_code' id='staff1_shift_code' value='"+staff1_shiftcode_value+"'><input type='hidden' name='new_workplace_code' id='new_workplace_code' value='"+new_workplace_code+"'><input type='hidden' name='new_staff_id' id='new_staff_id' value='"+new_staff_val+"'><input type='hidden' name='staff2_shift_code' id='staff2_shift_code' value='"+staff2_shiftcode_value+"'><input type='hidden' name='staff1_allocated_shifts_string' id='staff1_allocated_shifts_string' value='"+staff1_allocated_shifts_string+"'><input type='hidden' name='staff2_allocated_shifts_string' id='staff2_allocated_shifts_string' value='"+staff2_allocated_shifts_string+"'><input type='hidden' name='reason' id='reason' value='"+reason+"'><input type='hidden' name='remarks' id='remarks' value='"+remarks+"'><input type='hidden' name='durn_for_swap_from_sos' id='durn_for_swap_from_sos' value='"+durn_for_swap_from_sos+"'></form></body></html>";
	 parent.blankFrame.document.write(htmlvalue);
	 parent.blankFrame.document.dynamic_value.submit();
}

function checkIsValidForProceed(){
   var url = parent.ManageWorkScheduleSwap_frame.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("blank")==-1) )
			return true;
	else
			return false;
}

function notallowenter(event)
{
	if(window.event.keyCode==13)
		return false
	var desc = document.ManageWorkScheduleStaff2shifts_form.remarks.value;
	var len = eval(desc.length);
	if(len>=2000)
	{
		document.ManageWorkScheduleStaff2shifts_form.remarks.readOnly = true;
		return false
	}
}

