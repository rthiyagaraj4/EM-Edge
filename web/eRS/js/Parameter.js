var operation_fun='';
function create() {
	f_query_add_mod.location.href = "../../eRS/jsp/ParameterAddModify.jsp?mode=1" ;
	
}
/*********************************/
function query() {
	f_query_add_mod.location.href ="../../eRS/jsp/ParameterQueryResult.jsp";
}
/*********************************/
function reset(){
	if(f_query_add_mod.document.forms[0]){
		f_query_add_mod.document.forms[0].reset();
		formObj=f_query_add_mod.document.forms[0];

		if(formObj.attendance_feature_reqd_yn.checked ==true)
		   formObj.all.Max_Durn_Mandatory.style.visibility='visible';
		else
		   formObj.all.Max_Durn_Mandatory.style.visibility='hidden';		

		if(formObj.curr_shift_allocation_yn.checked ==true)
		   formObj.all.Allocate_Mandatory.style.visibility='visible';
		else
		   formObj.all.Allocate_Mandatory.style.visibility='hidden';
		
		if(formObj.curr_shift_change_yn.checked ==true)
		   formObj.all.Change_Mandatory.style.visibility='visible';
		else
		   formObj.all.Change_Mandatory.style.visibility='hidden';

		if(formObj.curr_shift_transfer_yn.checked ==true)
		   formObj.all.Transfer_Mandatory.style.visibility='visible';
		else
		   formObj.all.Transfer_Mandatory.style.visibility='hidden';

		if(formObj.curr_shift_swap_yn.checked ==true)
		   formObj.all.Swap_Mandatory.style.visibility='visible';
		else
		   formObj.all.Swap_Mandatory.style.visibility='hidden';

		if(formObj.curr_shift_overtime_yn.checked ==true)
		   formObj.all.Overtime_Mandatory.style.visibility='visible';
		else
		   formObj.all.Overtime_Mandatory.style.visibility='hidden';
		
		if(formObj.curr_shift_leave_yn.checked ==true)
		   formObj.all.Leave_Mandatory.style.visibility='visible';
		else
		   formObj.all.Leave_Mandatory.style.visibility='hidden';

		if(formObj.curr_shift_cancellation_yn.checked ==true)
		   formObj.all.Cancel_Mandatory.style.visibility='visible';
		else
		   formObj.all.Cancel_Mandatory.style.visibility='hidden';
	}
}
/****************************************************************/
function checkIsValidForProceed(){
		var url = f_query_add_mod.location.href;
		url = url.toLowerCase();
		if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
				return true;
		else
				return false;
}
/*********************************/
function apply(){
	var message="";
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
  	if (! checkIsValidForProceed() ) 
	{
				
				message  = "";
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;	
				return false ;
	}
	var frmobj=f_query_add_mod.document.form_ParameterAddModify ;
	var operation=frmobj.operation_type.value;
	var error_page = "../../eCommon/jsp/MstCodeError.jsp";
	var fields = new Array (frmobj.work_cycle_basis, frmobj.period_for_work_schedule_gen,frmobj.max_continuous_work_duration1,frmobj.max_continuous_work_duration2);
	var names = new Array (getLabel("eRS.WorkCycleBasis.label","RS"),getLabel("eRS.PeriodaheadforWorkSchedulecreation.label","RS"),getLabel("eRS.MaximumContinuousDurationStaffcanworkHours.label","RS"),getLabel("eRS.MaximumContinuousDurationStaffcanworkMinutes.label","RS"));
	var i	=	fields.length;

	if(frmobj.attendance_feature_reqd_yn.checked == true){
		frmobj.attendance_feature_reqd_yn.value	=	'Y';
		fields[i]	=	frmobj.max_durn_to_mark_attendance1;
		names[i]	=	"Max duration to mark attendance Hours";
		i++;
		fields[i]	=	frmobj.max_durn_to_mark_attendance2;
		names[i]	=	"Max duration to mark attendance Minutes",
		i++;
	}

	if(frmobj.curr_shift_allocation_yn.checked == true){
		frmobj.curr_shift_allocation_yn.value	=	'Y';
		fields[i]	=	frmobj.durn_for_allocation_from_sos1;
		names[i]	=	"Duration from start of shift Hours";
		i++;
		fields[i]	=	frmobj.durn_for_allocation_from_sos2;
		names[i]	=	"Duration from start of shift Minutes",
		i++;
	}
	if(frmobj.curr_shift_change_yn.checked == true){
		frmobj.curr_shift_change_yn.value	=	'Y';
		fields[i]	=	frmobj.durn_for_change_from_sos1;
		names[i]	=	"Duration from start of shift Hours";
		i++;
		fields[i]	=	frmobj.durn_for_change_from_sos2;
		names[i]	=	"Duration from start of shift Minutes",
		i++;
	}
	if(frmobj.curr_shift_transfer_yn.checked == true){
		frmobj.curr_shift_transfer_yn.value	=	'Y';
		fields[i]	=	frmobj.durn_for_transfer_from_sos1;
		names[i]	=	"Duration from start of shift Hours";
		i++;
		fields[i]	=	frmobj.durn_for_transfer_from_sos2;
		names[i]	=	"Duration from start of shift Minutes",
		i++;
	}
	if(frmobj.curr_shift_swap_yn.checked == true){
		frmobj.curr_shift_swap_yn.value	=	'Y';
		fields[i]	=	frmobj.durn_for_swap_from_sos1;
		names[i]	=	"Duration from start of shift Hours";
		i++;
		fields[i]	=	frmobj.durn_for_swap_from_sos2;
		names[i]	=	"Duration from start of shift Minutes",
		i++;
	}
	if(frmobj.curr_shift_overtime_yn.checked == true){
		frmobj.curr_shift_overtime_yn.value	=	'Y';
		fields[i]	=	frmobj.durn_for_overtime_from_sos1;
		names[i]	=	"Duration from start of shift Hours";
		i++;
		fields[i]	=	frmobj.durn_for_overtime_from_sos2;
		names[i]	=	"Duration from start of shift Minutes",
		i++;
	}
	if(frmobj.curr_shift_leave_yn.checked == true){
		frmobj.curr_shift_leave_yn.value	=	'Y';
		fields[i]	=	frmobj.durn_for_allocation_from_sos1;
		names[i]	=	"Duration from start of shift Hours ";
		i++;
		fields[i]	=	frmobj.durn_for_allocation_from_sos2;
		names[i]	=	"Duration from start of shift Minutes";
		i++;
	}
	if(frmobj.curr_shift_cancellation_yn.checked == true){
		frmobj.curr_shift_cancellation_yn.value	=	'Y';
		fields[i]	=	frmobj.durn_for_cancel_from_sos1;
		names[i]	=	"Duration from start of shift Hours ";
		i++;
		fields[i]	=	frmobj.durn_for_cancel_from_sos2;
		names[i]	=	"Duration from start of shift Minutes ";
		i++;
	}
	if(operation=="insert")
		operation_fun = "insert";
	else
		operation_fun = "modify";	
				 
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)){
			frmobj.submit();
	}
}

/*********************************/
function deleterecord(){
	var message="";
	var messageFrame = parent.frames[2].frames[2]; 
	if (! checkIsValidForProceed()) {
	    message  = getMessage("DELETE_NOT_VALID","RS");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;	
		return false ;
	}
	
	var frmobj=f_query_add_mod.document.form_ParameterAddModify ;
	var mode=frmobj.mode.value;
	if(mode != '2'){
	     message  = getMessage("DELETE_NOT_VALID","RS");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;	
		return false ;
	}
	var source= frmobj.sparams.value;
	
	if(frmobj.operation_type.value=="modify"){
		if(confirm(getMessage("DELETE_RECORD","Common"))){	
			f_query_add_mod.document.form_ParameterAddModify.operation_type.value = "Delete";
			frmobj.submit();
	    }
		else{
		  messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=';
		}
	}    	
	else{
		self.location.href = "../../eRS/jsp/ParameterAddModify.jsp?mode=1&source="+source;	
	}
}
/*********************************/
function checkActive(target){

	if(target.checked == false){
		target.value = "N";
		target.checked = false;
	}
	else{
		target.value = "Y";
		target.checked = true;
	}
}
 /*********************************/
function checkActive1(target,hour,minit,mandatory){

	if(target.checked == false){
		target.value = "N";
		hour.value='';
		minit.value='';
		target.checked = false;
		hour.readOnly=true;
		minit.readOnly=true;
		mandatory.style.visibility='hidden';
	}
	else{
		target.value = "Y";
		target.checked = true;
		hour.readOnly=false;
		minit.readOnly=false;
		mandatory.style.visibility='visible';
	}
}
 /*********************************/
function ModifycheckActive(target,hour,minit,mandatory){

	if(target.checked == false){
		target.value = "N";
		hour.value='';
		minit.value='';
		target.checked = false;
		hour.readOnly=true;
		minit.readOnly=true;
		mandatory.style.display='none';
		mandatory.style.visibility='hidden';
	}
	else{
		target.value = "Y";
		target.checked = true;
		hour.readOnly=false;
		minit.readOnly=false;
		mandatory.style.display='inline';
		mandatory.style.visibility='visible';
	}
}
/*********************************/
function allowPositiveNumber1() {
   var key = window.event.keyCode;// allows only numbers to be entered
   //alert(key);
   if((key<48)||(key>58)) {
	   return false;
   }
}


/*********************************/
function allowPositiveNumber() {
   var key = window.event.keyCode;// allows only numbers to be entered
   if((key<48 )||(key>58)) {
	   return false;
   }
}
/*********************************/
function CheckForHours(target){
	var val=target.value;
	if(val != ''){
		var value =parseFloat(target.value);
		if(!isNaN(value)){
		   if(value < 0 || value >= 24 ){
				message =getMessage("HR_LESS_TWENTYFOUR","RS");
				parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
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
			parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			target.select();
			target.focus();
			return;
		}
	}
}
/*********************************/
function CheckForMinutes(target,hr){
	var val=target.value;
	if(val != ''){
		var minit	=	parseFloat(target.value);
		var hour	=	parseFloat(hr.value);
		if(!isNaN(minit)){
			if(minit < 0 || minit > 59){
				message =getMessage("MI_LESS_SIXTY","RS");
				parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
				target.select();
				target.focus();
				return;
			}
			else{
				if((minit == 0)&&(hour == 0)){
					message =getMessage("DURATION_CANNOT_BE_ZERO","RS");
					parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
					target.value='';
					hr.select();
					hr.focus();
					return;
				}else{
					if(minit < 10){
						target.value = '0' + minit;
					}
					parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp";
				}
			}
		}else{
			message =getMessage("INVALID_NUMBER_FORMAT","Common");
			parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			target.select();
			target.focus();
			return;
		}
	}
}
/*********************************/
function onSuccess() {
	if (operation_fun=="insert"){
		f_query_add_mod.location.href="../../eRS/jsp/ParameterAddModify.jsp?mode=1";

	}else{

		var frmobj=f_query_add_mod.document.form_ParameterAddModify ;
		var facility_id=frmobj.facility_id.value;
		var facility_name=frmobj.facility_name.value;
		var work_cycle_basis=frmobj.work_cycle_basis.value;
		var overlap_shifts_in_workplace_yn=frmobj.overlap_shifts_in_workplace_yn.value;
		var period_for_work_schedule_gen=frmobj.period_for_work_schedule_gen.value;
		var max_continuous_work_duration1=frmobj.max_continuous_work_duration1.value;
		var max_continuous_work_duration2=frmobj.max_continuous_work_duration2.value;
		var staff_subs_same_grade_yn=frmobj.staff_subs_same_grade_yn.value;
		var staff_subs_high_to_low_yn=frmobj.staff_subs_high_to_low_yn.value;
		var staff_subs_low_to_high_yn=frmobj.staff_subs_low_to_high_yn.value; 
		var attendance_feature_reqd_yn=frmobj.attendance_feature_reqd_yn.value;
		var max_durn_to_mark_attendance1=frmobj.max_durn_to_mark_attendance1.value;
		var max_durn_to_mark_attendance2=frmobj.max_durn_to_mark_attendance2.value;
		var vald_staff_acc_by_work_sch_yn=frmobj.vald_staff_acc_by_work_sch_yn.value;
		var vald_staff_acc_by_att_yn=frmobj.vald_staff_acc_by_att_yn.value;
		var curr_shift_allocation_yn=frmobj.curr_shift_allocation_yn.value;
		var curr_shift_change_yn=frmobj.curr_shift_change_yn.value;
		var curr_shift_cancellation_yn=frmobj.curr_shift_cancellation_yn.value;
		//var curr_shift_absence_yn=frmobj.curr_shift_absence_yn.value;
		//var curr_shift_partial_att_yn=frmobj.curr_shift_partial_att_yn.value;
		var curr_shift_transfer_yn=frmobj.curr_shift_transfer_yn.value;
		var curr_shift_swap_yn=frmobj.curr_shift_swap_yn.value;
		var curr_shift_overtime_yn=frmobj.curr_shift_overtime_yn.value;
		var curr_shift_leave_yn=frmobj.curr_shift_leave_yn.value;
		var durn_for_allocation_from_sos1=frmobj.durn_for_allocation_from_sos1.value;
		var durn_for_change_from_sos1=frmobj.durn_for_change_from_sos1.value;
		var durn_for_transfer_from_sos1=frmobj.durn_for_transfer_from_sos1.value;
		var durn_for_swap_from_sos1=frmobj.durn_for_swap_from_sos1.value;
		var durn_for_overtime_from_sos1=frmobj.durn_for_overtime_from_sos1.value;
		//var durn_for_partial_att_from_sos1=frmobj.durn_for_partial_att_from_sos1.value;
		//var durn_for_absence_from_sos1=frmobj.durn_for_absence_from_sos1.value;
		var durn_for_leave_from_sos1=frmobj.durn_for_leave_from_sos1.value;
		var durn_for_cancel_from_sos1=frmobj.durn_for_cancel_from_sos1.value;
		var durn_for_allocation_from_sos2=frmobj.durn_for_allocation_from_sos2.value;
		var durn_for_change_from_sos2=frmobj.durn_for_change_from_sos2.value;
		var durn_for_transfer_from_sos2=frmobj.durn_for_transfer_from_sos2.value;
		var durn_for_swap_from_sos2=frmobj.durn_for_swap_from_sos2.value;
		var durn_for_overtime_from_sos2=frmobj.durn_for_overtime_from_sos2.value;
		//var durn_for_partial_att_from_sos2=frmobj.durn_for_partial_att_from_sos2.value;
		//var durn_for_absence_from_sos2=frmobj.durn_for_absence_from_sos2.value;
		var durn_for_leave_from_sos2=frmobj.durn_for_leave_from_sos2.value;
		var durn_for_cancel_from_sos2=frmobj.durn_for_cancel_from_sos2.value;
		var max_continuous_work_duration=max_continuous_work_duration1+":"+max_continuous_work_duration2;
		if(max_durn_to_mark_attendance1 == "")
			max_durn_to_mark_attendance1="00";
		if(max_durn_to_mark_attendance2 !="")
			var max_durn_to_mark_attendance=max_durn_to_mark_attendance1+":"+max_durn_to_mark_attendance2;
		else
			var max_durn_to_mark_attendance="";

		if(durn_for_allocation_from_sos2 !="")
			var durn_for_allocation_from_sos=durn_for_allocation_from_sos1+":"+durn_for_allocation_from_sos2;
		else
			var durn_for_allocation_from_sos="";

		if(durn_for_change_from_sos2 !="")
			var durn_for_change_from_sos=durn_for_change_from_sos1+":"+durn_for_change_from_sos2;
		else
			var durn_for_change_from_sos="";

		if(durn_for_transfer_from_sos2 !="")
			var durn_for_transfer_from_sos = durn_for_transfer_from_sos1+":"+durn_for_transfer_from_sos2;
		else
			var durn_for_transfer_from_sos="";

		if(durn_for_swap_from_sos2 !="")
			var durn_for_swap_from_sos = durn_for_swap_from_sos1+":"+durn_for_swap_from_sos2;
		else
			var durn_for_swap_from_sos="";

		if(durn_for_overtime_from_sos2 !="")
			var durn_for_overtime_from_sos= durn_for_overtime_from_sos1+":"+durn_for_overtime_from_sos2;
		else
			var durn_for_overtime_from_sos="";

		if(durn_for_leave_from_sos2 !="")
			var durn_for_leave_from_sos= durn_for_leave_from_sos1+":"+durn_for_leave_from_sos2;
		else
			var durn_for_leave_from_sos="";

		if(durn_for_cancel_from_sos2 !="")
			var durn_for_cancel_from_sos=durn_for_cancel_from_sos1+":"+durn_for_cancel_from_sos2;
		else
			var durn_for_cancel_from_sos="";
		f_query_add_mod.location.href = "../../eRS/jsp/ParameterAddModify.jsp?mode=2&facility_id="+facility_id+"&facility_name="+facility_name+"&overlap_shifts_in_workplace_yn="+overlap_shifts_in_workplace_yn+"&work_cycle_basis="+work_cycle_basis+"&period_for_work_schedule_gen="+period_for_work_schedule_gen+"&max_continuous_work_duration="+max_continuous_work_duration+"&staff_subs_same_grade_yn="+staff_subs_same_grade_yn+"&staff_subs_high_to_low_yn="+staff_subs_high_to_low_yn+"&staff_subs_low_to_high_yn="+staff_subs_low_to_high_yn+"&attendance_feature_reqd_yn="+attendance_feature_reqd_yn+"&max_durn_to_mark_attendance="+max_durn_to_mark_attendance+"&vald_staff_acc_by_work_sch_yn="+vald_staff_acc_by_work_sch_yn+"&vald_staff_acc_by_att_yn="+vald_staff_acc_by_att_yn+"&curr_shift_allocation_yn="+curr_shift_allocation_yn+"&curr_shift_change_yn="+curr_shift_change_yn+"&curr_shift_cancellation_yn="+curr_shift_cancellation_yn+"&curr_shift_transfer_yn="+curr_shift_transfer_yn+"&curr_shift_swap_yn="+curr_shift_swap_yn+"&curr_shift_overtime_yn="+curr_shift_overtime_yn+"&curr_shift_leave_yn="+curr_shift_leave_yn+"&durn_for_allocation_from_sos="+durn_for_allocation_from_sos+"&durn_for_change_from_sos="+durn_for_change_from_sos+"&durn_for_transfer_from_sos="+durn_for_transfer_from_sos+"&durn_for_swap_from_sos="+durn_for_swap_from_sos+"&durn_for_overtime_from_sos="+durn_for_overtime_from_sos+"&durn_for_leave_from_sos="+durn_for_leave_from_sos+"&durn_for_cancel_from_sos="+durn_for_cancel_from_sos;
	}
}
/**********************************************************/
function checkForZero(obj){
	objvalue=obj.value;
	if(objvalue != ''){
		var val=parseInt(obj.value);
		if(!isNaN(val)){
			if(val ==0 ){
				message=getMessage("CANNOT_BE_ZERO","Common");
				parent.messageFrame.location.href= "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
				obj.select();
				return false;
			}
		}else{
			message =getMessage("INVALID_NUMBER_FORMAT","Common");
			parent.messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			target.select();
			target.focus();
			return;
		}
	}
}
/********************************************************/
function ModifyDisplay()
{
  var formObj=document.form_ParameterAddModify ;
  if(formObj.mode.value=="2")
  {
    if(formObj.attendance_feature_reqd_yn.value =="Y"){
       formObj.all.Max_Durn_Mandatory.style.display='inline';
       formObj.all.Max_Durn_Mandatory.style.visibility='visible';
    }else{
       formObj.all.Max_Durn_Mandatory.style.display='none';
       formObj.all.Max_Durn_Mandatory.style.visibility='hidden';
    }

    if(formObj.curr_shift_allocation_yn.value =="Y"){
       formObj.all.Allocate_Mandatory.style.display='inline';
       formObj.all.Allocate_Mandatory.style.visibility='visible';
    }else{
       formObj.all.Allocate_Mandatory.style.display='none';
       formObj.all.Allocate_Mandatory.style.visibility='hidden';
    }

    if(formObj.curr_shift_change_yn.value =="Y"){
       formObj.all.Change_Mandatory.style.display='inline';
       formObj.all.Change_Mandatory.style.visibility='visible';
    }else{
       formObj.all.Change_Mandatory.style.display='none';
       formObj.all.Change_Mandatory.style.visibility='hidden';
    }

    if(formObj.curr_shift_transfer_yn.value =="Y"){
       formObj.all.Transfer_Mandatory.style.display='inline';
       formObj.all.Transfer_Mandatory.style.visibility='visible';
    }else{
       formObj.all.Transfer_Mandatory.style.display='none';
       formObj.all.Transfer_Mandatory.style.visibility='hidden';
    }

    if(formObj.curr_shift_swap_yn.value =="Y"){
       formObj.all.Swap_Mandatory.style.display='inline';
       formObj.all.Swap_Mandatory.style.visibility='visible';
    }else{
       formObj.all.Swap_Mandatory.style.display='none';
       formObj.all.Swap_Mandatory.style.visibility='hidden';
    }

    if(formObj.curr_shift_overtime_yn.value =="Y"){
       formObj.all.Overtime_Mandatory.style.display='inline';
       formObj.all.Overtime_Mandatory.style.visibility='visible';
    }else{
       formObj.all.Overtime_Mandatory.style.display='none';
       formObj.all.Overtime_Mandatory.style.visibility='hidden';
	}
    if(formObj.curr_shift_leave_yn.value =="Y"){
       formObj.all.Leave_Mandatory.style.display='inline';
       formObj.all.Leave_Mandatory.style.visibility='visible';
    }else{
       formObj.all.Leave_Mandatory.style.display='none';
       formObj.all.Leave_Mandatory.style.visibility='hidden';
    }

    if(formObj.curr_shift_cancellation_yn.value =="Y"){
       formObj.all.Cancel_Mandatory.style.display='inline';
       formObj.all.Cancel_Mandatory.style.visibility='visible';
    }else{
       formObj.all.Cancel_Mandatory.style.display='none';
       formObj.all.Cancel_Mandatory.style.visibility='hidden';
    }
  }
}
/**********************************************************/
function checkForblank(obj2, obj1){

	if((obj2.value != "")&&(obj1.value==""))
		obj1.value ="00";

	if((obj1.value == 0)&&(obj2.value==""))
		obj1.value ="";
}
