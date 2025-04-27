function isNumber(obj){
	var regex		= /^[0-9]+$/;
	if(obj.value!=""){
		if(!regex.test(obj.value)){
			$("#"+obj.id).val("");
			$("#"+obj.id).focus();
			alert(getMessage("INVALID_NEXT_NUMBER","Common").replace("next",""));
		}else if(obj.value==0){
			$("#"+obj.id).val("");
			$("#"+obj.id).focus();
			alert(getMessage("INVALID_NEXT_NUMBER","Common").replace("next",""));
		}
	}
}

function reset(){
	frames[1].location.href='../../eOA/jsp/PortalBookingCtrls.jsp';
	frames[2].location.href='../../eCommon/jsp/error.jsp';
}

function apply(){
	
	var maxBookingPerPatient			= $("#maxBookingPerPatient",f_query_add_mod.document).val();
	var maxBookingPerPatientPerDay		= $("#maxBookingPerPatientPerDay",f_query_add_mod.document).val();
	var advanceBookinglimitsMin			= $("#advanceBookinglimitsMin",f_query_add_mod.document).val();
	var advanceBookinglimitsMax			= $("#advanceBookinglimitsMax",f_query_add_mod.document).val();
	var booking_reason					= $("#booking_reason",f_query_add_mod.document).val();
	var rescheduling_reason				= $("#rescheduling_reason",f_query_add_mod.document).val();
	var cancelling_reason				= $("#cancelling_reason",f_query_add_mod.document).val();



	var mode							= $("#mode",f_query_add_mod.document).val();
	var msg1=getLabel("eOA.AdvanceBookinglimits.label","OA")+"("+getLabel("Common.Minimum.label","Common")+")";
	var msg2=getLabel("eOA.AdvanceBookinglimits.label","OA")+"("+getLabel("Common.maximum.label","Common")+")";
	var LocalErrors="";
	var localerror1="";

	if(maxBookingPerPatient=='') {
		LocalErrors=getMessage("CAN_NOT_BE_BLANK","Common").replace("$",getLabel("eOA.MaxBookingPerPatient.label","OA"))+"<br>";
		}
	if(maxBookingPerPatientPerDay=='') {
		LocalErrors=LocalErrors+getMessage("CAN_NOT_BE_BLANK","Common").replace("$",getLabel("eOA.MAxBookingPerPatientPerDay.label","OA"))+"<br>";
		}


	if(advanceBookinglimitsMin==''){
		LocalErrors=LocalErrors+getMessage("CAN_NOT_BE_BLANK","Common").replace("$",msg1)+"<br>";
	}

	if(advanceBookinglimitsMax==''){
		LocalErrors=LocalErrors+getMessage("CAN_NOT_BE_BLANK","Common").replace("$",msg2)+"<br>";
	}

	if(booking_reason==''){
		LocalErrors=LocalErrors+getMessage("CAN_NOT_BE_BLANK","Common").replace("$",getLabel("eOA.ReasonForBookingAppointment.label","OA"))+"<br>";
	}
	if(rescheduling_reason==''){
		LocalErrors=LocalErrors+getMessage("CAN_NOT_BE_BLANK","Common").replace("$",getLabel("eOA.ReasonForReschedulingAppointment.label","OA"))+"<br>";
	}
	if(cancelling_reason==''){
		LocalErrors=LocalErrors+getMessage("CAN_NOT_BE_BLANK","Common").replace("$",getLabel("eOA.ReasonForCancellingAppointment.label","OA"))+"<br>";
	}




	if (parseInt(maxBookingPerPatientPerDay) > parseInt(maxBookingPerPatient))
	{	localerror1=getMessage("CANNOT_GREATER","MP")
		localerror1=localerror1.replace("$",getLabel("eOA.MaxBookingPerPatient.label","OA"));
		localerror1=localerror1.replace("#",getLabel("eOA.MAxBookingPerPatientPerDay.label","OA"));
		LocalErrors=LocalErrors+localerror1+"<br>";;
	}


	if (parseInt(advanceBookinglimitsMin) > parseInt(advanceBookinglimitsMax))
	{	localerror1=getMessage("CANNOT_GREATER","MP")
		localerror1=localerror1.replace("$",msg2);
		localerror1=localerror1.replace("#",msg1);
		LocalErrors=LocalErrors+localerror1;
	}

	if(LocalErrors!=""){
		messageFrame.location.href= '../../eCommon/jsp/error.jsp?err_num='+LocalErrors;
	}else{
		var alt_id1_yn							= getChkboxValue('alt_id1_yn');
		var alt_id2_yn							= getChkboxValue('alt_id2_yn');
		var alt_id3_yn							= getChkboxValue('alt_id3_yn');
		var alt_id4_yn							= getChkboxValue('alt_id4_yn');
		var nat_id_prompt_yn					= getChkboxValue('nat_id_prompt_yn');

		var booking_reason_change_yn			= getChkboxValue('booking_reason_change_yn');
		var rescheduling_reason_change_yn		= getChkboxValue('rescheduling_reason_change_yn');
		var cancelling_reason_change_yn			= getChkboxValue('cancelling_reason_change_yn');

		var jsonArguments	= {
								'maxBookingPerPatient':maxBookingPerPatient,
								'maxBookingPerPatientPerDay':maxBookingPerPatientPerDay,
								'advanceBookinglimitsMin':advanceBookinglimitsMin,
								'advanceBookinglimitsMax':advanceBookinglimitsMax,
								'alt_id1_yn':alt_id1_yn,
								'alt_id2_yn':alt_id2_yn,
								'alt_id3_yn':alt_id3_yn,
								'alt_id4_yn':alt_id4_yn,
								'nat_id_prompt_yn':nat_id_prompt_yn,
								'booking_reason' :booking_reason,
								'rescheduling_reason' :rescheduling_reason,
								'cancelling_reason' :cancelling_reason,
								'booking_reason_change_yn' :booking_reason_change_yn,
								'rescheduling_reason_change_yn' :rescheduling_reason_change_yn,
								'cancelling_reason_change_yn' :cancelling_reason_change_yn,
								'mode':mode
							  };
		$.ajax({
			 url:'../../servlet/eOA.PortalBookingCtrlsServlet',
			 type: 'post',
			 data: jsonArguments,
			 dataType: 'json',
			 success: function(data) {
				if(data!=null){
					 if(data.error == ""){
						$("#mode",frames[1].document).val("modify");
						frames[2].location.href= '../../eCommon/jsp/error.jsp?err_num='+getMessage("RECORD_INSERTED","SM");

					 }else{
						 frames[2].location.href= '../../eCommon/jsp/error.jsp?err_num='+data.error;
					 }
				}
			 }
		 });


		//window.commontoolbarFrame.document.location.reload();
	}

}

function getChkboxValue(id){
	var retunValue	= "N";
	if($("#"+id,f_query_add_mod.document)!=null){
		if($("#"+id,f_query_add_mod.document).prop('checked')){
			retunValue	= "Y";
		}
	}
	return retunValue;
}
