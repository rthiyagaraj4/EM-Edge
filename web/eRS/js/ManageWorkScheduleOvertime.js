function windclose()
{
	window.close();
}

function apply()
{
	var frmObj=document.ManageWorkSchedule_Overtime;
	var shift =frmObj.shift.value ;
	var over_time_durn1 = frmObj.over_time_durn1.value ;
	var over_time_durn2 = frmObj.over_time_durn2.value ;
	var over_time_durn = over_time_durn1+":"+over_time_durn2;
	var reason = frmObj.reason.value;
	var shift_start_time = frmObj.shift_start_time.value;
	var actual_end_time = frmObj.actual_end_time.value;
	var role_type = frmObj.p_role_type.value;
	var staff_id = frmObj.p_staff_id.value;
	var shift_end_date_time = frmObj.shift_end_date_time.value;
	if(shift == ""){
		alert("APP-000001  Shift cannot be blank...");
		return false;
	}

	if(over_time_durn1 == "" && over_time_durn2 == ""){
		alert("APP-000001 Overtime Duration cannot be blank...");
		return false;
	}
	if(over_time_durn1 == "")
		over_time_durn1="00";
	if(over_time_durn2 == "")
		over_time_durn2="00";
	if(reason == ""){
		alert("APP-000001 Reason cannot be blank...");
		return false;
	}

	var xmlDoc = "" ;
	var xmlHttp = new XMLHttpRequest() ;
	xmlStr = "<root><SEARCH " ;
	xmlStr += " /></root>" ;
	xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	xmlHttp.open( "POST","../../eRS/jsp/ManageWorkScheduleOvertimeDynamicValues.jsp?shift_code1="+shift+"&role_type="+role_type+"&staff_id="+staff_id+"&over_time_durn1="+over_time_durn1+"&over_time_durn2="+over_time_durn2+"&shift_start_time="+shift_start_time+"&actual_end_time="+actual_end_time+"&shift_end_date_time="+shift_end_date_time+"&flag=inapply",false);
	xmlHttp.send( xmlDoc ) ;
	responseText = xmlHttp.responseText ;
	eval(responseText); 
	frmObj.submit();
	
}

/****************************************************************************************/

function ChangeType(form,target)
	  {

		    frmObj=document.ManageWorkSchedule_Overtime;
			frmObj.over_time_durn1.value = ""; 
			frmObj.over_time_durn2.value = "";
			var schedule_date = frmObj.p_schedule_date.value;
			var facility_id = frmObj.p_facility_id.value;
			var workplace_code = frmObj.p_workplace_code.value;
			var role_type = frmObj.p_role_type.value;
			var staff_id = frmObj.p_staff_id.value;
			var position_code = frmObj.p_position_code.value;
			var curr_shift_overtime_yn = frmObj.curr_shift_overtime_yn.value;
			var durn_for_overtime_from_sos = frmObj.durn_for_overtime_from_sos.value;
			var shift_code1 = target.value;
			var xmlDoc = "" ;
			var xmlHttp = new XMLHttpRequest() ;
			xmlStr = "<root><SEARCH " ;
			xmlStr += " /></root>" ;
			xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
			//to get the period for selected requirement
			xmlHttp.open( "POST","../../eRS/jsp/ManageWorkScheduleOvertimeDynamicValues.jsp?shift_code1="+shift_code1+"&schedule_date="+schedule_date+"&durn_for_overtime_from_sos="+durn_for_overtime_from_sos+"&facility_id="+facility_id+"&workplace_code="+workplace_code+"&role_type="+role_type+"&staff_id="+staff_id+"&position_code="+position_code+"&curr_shift_overtime_yn="+curr_shift_overtime_yn+"&flag=changeshift",false);
			xmlHttp.send( xmlDoc ) ;
			responseText = xmlHttp.responseText ;
			eval(responseText); 
			
	  }

	 

/****************************************************************************************/
	function assignDateRange(start_time1,end_time1,shift_start_date_time,shift_end_date_time)
	{
		var frmobj=document.ManageWorkSchedule_Overtime ;
		var start_time1=start_time1;
		var end_time1=end_time1;
		var shift_start_date_time=shift_start_date_time;
		var shift_end_date_time=shift_end_date_time;
		frmobj.start_time1.value=start_time1;
		frmobj.end_time1.value=end_time1;
		frmobj.shift_start_date_time.value=shift_start_date_time;
		frmobj.shift_end_date_time.value=shift_end_date_time;
	}
/****************************************************************************************/
	function display(obj1,obj2)
	{
	var frmobj=document.ManageWorkSchedule_Overtime ;
	
	var start_time1=frmobj.start_time1.value;
	var end_time1=frmobj.end_time1.value;

	obj1.innerText=""+start_time1+ "        " +end_time1;
	
	}
/******************************************************************************/
function assignovertime(valid_yn,shift_start_time1,actual_end_time1)
{
	//alert("valid_yn==>" +valid_yn);
	var valid_yn = valid_yn ;
	var shift_start_time = shift_start_time1 ;
	var actual_end_time = actual_end_time1 ;
	var frmobj=document.ManageWorkSchedule_Overtime ;
	//alert("valid_yn===>" +valid_yn);
	//alert("shift_start_time===>" +shift_start_time);
	//alert("actual_end_time===>" +actual_end_time);

	frmobj.shift_start_time.value=shift_start_time;
	frmobj.actual_end_time.value=actual_end_time;

	if(valid_yn == "NA")
	{
		var msg = getMessage("OVERTIME_ASSIGNMENT_NOT_ALLOWED","RS");
		alert (msg);
		frmobj.shift.value = "";
		frmObj.over_time_durn1.value = "";
		frmObj.over_time_durn2.value ="";
		return false;
	}
	if(valid_yn == "DL")
	{
		var msg1 = getMessage("OVERTIME_DURATION_LAPSED","RS");
		alert (msg1);
		frmobj.shift.value = "";
		frmObj.over_time_durn1.value = "";
		frmObj.over_time_durn2.value ="";
		return false;
	}


}
/******************************************************************************/
function getoverlap(overlaps_yn , actual_end_date_time)
{
	var frmobj = document.ManageWorkSchedule_Overtime ;
	var overlaps_yn = overlaps_yn ;
	var actual_end_date_time = actual_end_date_time;
	frmobj.actual_end_date_time.value = actual_end_date_time;
	if(overlaps_yn == "Y")
	{
		var msg = getMessage("OVERTIME_DURATION_CLASHES","RS");
		alert (msg);
		frmobj.shift.value = "";
		frmObj.over_time_durn1.value = "";
		frmObj.over_time_durn2.value ="";
		return false;
	}
}
/******************************************************************************/
function allowPositiveNumber() {
   var key = window.event.keyCode;// allows only numbers to be entered
   if((key<48 )||(key>58)) {
	   return false;
   }
}

/******************************************************************************/
function CheckForHours(target){
	var val=target.value;
	if(val != ''){
		var value =parseInt(target.value);
		if(!isNaN(value)){
			if(value < 0 || value >= 24){
				message =getMessage("HR_LESS_TWENTYFOUR","RS");
				alert(message);
				target.select();
				target.focus();
				return;
			}else{
				if(value < 10) {
					target.value = '0' + value;
				}
			}
		}else{
			message =getMessage("INVALID_NUMBER_FORMAT","Common");
			alert(message);
			target.select();
			target.focus();
			return;
		}
	}
}
/********************************************************************/
function CheckForMinutes(target,hr){
	var val=target.value;
	if(val != ''){
		var minit	=	parseInt(target.value);
		var hour	=	parseInt(hr.value);
		if(!isNaN(minit)){
			if(minit < 0 || minit > 59){
				message =getMessage("MI_LESS_SIXTY","RS");
				alert(message);
				target.select();
				target.focus();
				return;
			}
			else{
				if((minit == 0)&&(hour == 0)){
					message =getMessage("OVERTIME_DURATION_NOT_ZERO","RS");
					alert(message);
					target.value='';
					hr.select();
					hr.focus();
					return;
				}else{
					if(minit < 10){
						target.value = '0' + minit;
					}
				}
			}
		}else{
			message =getMessage("INVALID_NUMBER_FORMAT","Common");
			alert(message);
			target.select();
			target.focus();
			return;
		}
	}
}
/*************************************************************************************/
