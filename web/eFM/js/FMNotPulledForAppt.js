 function reset()
 {
	searchFrame.document.forms[0].reset(); 
 }

 function run()
 {
	var function_id=searchFrame.document.getElementById("function_id").value;
	var error="";




	if(function_id=="FM_NOT_PULLED_FOR_BKG")
	 {
		if(searchFrame.document.reportFMFileNotPulledForAppointment.p_booking_date.value==""){
		error= getMessage("CAN_NOT_BE_BLANK","Common");
		error = error.replace("$",getLabel('Common.BookingDate.label','common'));
		}
	 }
	 else
	 {
		if(searchFrame.document.reportFMFileNotPulledForAppointment.P_APPT_DATE.value==""){
		error= getMessage("CAN_NOT_BE_BLANK","Common");
		error = error.replace("$",getLabel('eFM.AppointmentDatefield.label','FM'));
		}
	 }
	var today = searchFrame.document.reportFMFileNotPulledForAppointment.today.value;
	
	

	if(searchFrame.document.reportFMFileNotPulledForAppointment.P_FROM_CODE.value == '')
	 {
//		var msg ="APP-FM0057 one of the option from FS Location should be selected"	  ;
		var msg =getMessage("CAN_NOT_BE_BLANK","common") ;
		msg=msg.replace('$',getLabel("eFM.FSLocation.label","FM"));
		msg = msg +"<br>";
		error=msg+error;
		//messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+msg;
		//return false ;
	 }
	/*Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 24th 2014 Start*/
	var start_time	= searchFrame.document.reportFMFileNotPulledForAppointment.p_start_time.value;
	var end_time	= searchFrame.document.reportFMFileNotPulledForAppointment.p_end_time.value;
	if(start_time!="" || end_time!=""){
		if(start_time=="" || end_time==""){
			 error	+=  getMessage('START_END_TIME_CANNOT_BE_BLANK','FM');
		}
	}
	/*Added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 24th 2014 End*/

	if(error=="")
	{	
		searchFrame.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
		searchFrame.document.forms[0].target="messageFrame";
		searchFrame.document.forms[0].submit(); 
	}else{
		messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+error;
		return false ;
	}	
 }

