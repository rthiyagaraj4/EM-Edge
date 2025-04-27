function create() {
	f_query_add_mod.location.href = "../../eAM/jsp/addModifyContactReason.jsp" ;
}

function edit() {
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {

	f_query_add_mod.location.href ="../../eAM/jsp/ContactReasonQueryCriteria.jsp";
}
function checkIsValidForProceed()
  {
     var url = f_query_add_mod.location.href;
     url = url.toLowerCase();
     if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
        return true;
    else
        return false;
  }


function apply() {
	var messageFrame = frames[2]; 
	if (! (checkIsValidForProceed()) )
    {
        //var msg = parent.frames[0].getMessage("AM0100","AM");
		//messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+msg;
		//f_query_add_mod.document.location.reload();
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 

	var fields = new Array ( f_query_add_mod.document.contactreason_form.contact_reason_code );
	var names  =  new Array ( getLabel("Common.code.label","Common") );
	
	//var messageFrame = parent.frames[1].frames[2]; 

	
	var error_page = "../../eCommon/jsp/MstCodeError.jsp";

	if(f_query_add_mod.SpecialCharCheck(fields,names,messageFrame,"M", error_page)){

		var fields = new Array ( f_query_add_mod.document.contactreason_form.contact_reason_code,
							f_query_add_mod.document.contactreason_form.contact_reason
						);
		var names = new Array (  getLabel("Common.code.label","Common"),
					 getLabel("Common.description.label","Common"));

		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
		{
			   f_query_add_mod.document.contactreason_form.visit_registration_yn  .value=(f_query_add_mod.document.contactreason_form.visit_registration_yn1  .checked)?"Y":"N";
			   f_query_add_mod.document.contactreason_form.cancel_visit_yn        .value=(f_query_add_mod.document.contactreason_form.cancel_visit_yn1        .checked)?"Y":"N";
			   f_query_add_mod.document.contactreason_form.book_appointment_yn    .value=(f_query_add_mod.document.contactreason_form.book_appointment_yn1    .checked)?"Y":"N";
			   f_query_add_mod.document.contactreason_form.transfer_appointment_yn.value=(f_query_add_mod.document.contactreason_form.transfer_appointment_yn1.checked)?"Y":"N";
			   f_query_add_mod.document.contactreason_form.cancel_appointment_yn  .value=(f_query_add_mod.document.contactreason_form.cancel_appointment_yn1  .checked)?"Y":"N";
			   f_query_add_mod.document.contactreason_form.lift_schedule_yn       .value=(f_query_add_mod.document.contactreason_form.lift_schedule_yn1       .checked)?"Y":"N";
			   f_query_add_mod.document.contactreason_form.block_schedule_yn      .value=(f_query_add_mod.document.contactreason_form.block_schedule_yn1      .checked)?"Y":"N";
			   f_query_add_mod.document.contactreason_form.cancel_schedule_yn     .value=(f_query_add_mod.document.contactreason_form.cancel_schedule_yn1     .checked)?"Y":"N";
			   f_query_add_mod.document.contactreason_form.transfer_schedule_yn   .value=(f_query_add_mod.document.contactreason_form.transfer_schedule_yn1   .checked)?"Y":"N";
			   f_query_add_mod.document.contactreason_form.revise_visit_yn .value=(f_query_add_mod.document.contactreason_form.revise_visit_yn1.checked)?"Y":"N";
			    f_query_add_mod.document.contactreason_form.reason_for_recall_yn .value=(f_query_add_mod.document.contactreason_form.reason_for_recall_yn1 .checked)?"Y":"N";
			   
			   f_query_add_mod.document.contactreason_form.reason_for_referral_yn .value=(f_query_add_mod.document.contactreason_form.reason_for_referral_yn1 .checked)?"Y":"N";
			    
			 f_query_add_mod.document.contactreason_form.followup_of_referral_yn1 .value=(f_query_add_mod.document.contactreason_form.followup_of_referral_yn.checked)?"Y":"N";
			 
			 f_query_add_mod.document.contactreason_form.rejection_of_referral_yn1 .value=(f_query_add_mod.document.contactreason_form.rejection_of_referral_yn .checked)?"Y":"N";
			 
			  f_query_add_mod.document.contactreason_form.patient_depart_yn .value=(f_query_add_mod.document.contactreason_form.patient_depart_yn1.checked)?"Y":"N";


			   f_query_add_mod.document.contactreason_form.cancel_transfer_yn .disabled = false;
		
			   f_query_add_mod.document.contactreason_form.cancel_transfer_yn .value=(f_query_add_mod.document.contactreason_form.cancel_transfer_yn .checked)?"Y":"N";

			   f_query_add_mod.document.contactreason_form.REGISTER_ATTENDANCE_YN .disabled = false;
			
			   f_query_add_mod.document.contactreason_form.REGISTER_ATTENDANCE_YN .value=(f_query_add_mod.document.contactreason_form.REGISTER_ATTENDANCE_YN .checked)?"Y":"N";	
			   f_query_add_mod.document.contactreason_form.cancel_booking_yn.value=(f_query_add_mod.document.contactreason_form.cancel_booking_yn1.checked)?"Y":"N";
			   f_query_add_mod.document.contactreason_form.cancel_admission_yn .value=(f_query_add_mod.document.contactreason_form.cancel_admission_yn1.checked)?"Y":"N";
			   f_query_add_mod.document.contactreason_form.cancel_discharge_advice_yn.value=(f_query_add_mod.document.contactreason_form.cancel_discharge_advice_yn1.checked)?"Y":"N";
			   f_query_add_mod.document.contactreason_form.reason_for_revise_bkg_yn.value=(f_query_add_mod.document.contactreason_form.reason_for_revise_bkg_yn1.checked)?"Y":"N";
			   
			   f_query_add_mod.document.contactreason_form.CANCEL_OP_CHECKOUT_YN .value=(f_query_add_mod.document.contactreason_form.CANCEL_OP_CHECKOUT_YN .checked)?"Y":"N";
			   f_query_add_mod.document.contactreason_form.CANCEL_AE_CHECKOUT_YN .value=(f_query_add_mod.document.contactreason_form.CANCEL_AE_CHECKOUT_YN .checked)?"Y":"N";

			    f_query_add_mod.document.contactreason_form.pract_override_reason_yn .value=(f_query_add_mod.document.contactreason_form.pract_override_reason_yn .checked)?"Y":"N";
				
				/*Added by Thamizh selvi on 7th July 2017 for ML-MMOH-CRF-0719 Start*/
				var isIncompReqCancelApplicable = f_query_add_mod.document.contactreason_form.isIncompReqCancelApplicable.value;
				if(isIncompReqCancelApplicable == "true"){
					f_query_add_mod.document.contactreason_form.cancel_med_request_yn.disabled = false;
					f_query_add_mod.document.contactreason_form.cancel_med_request_yn.value=(f_query_add_mod.document.contactreason_form.cancel_med_request_yn .checked)?"Y":"N";
				}
				/*End*/
				/*Added by Mujafar for ML-MMOH-CRF-0713 Start*/
				var isRejectRequestApplicable = f_query_add_mod.document.contactreason_form.isRejectRequestApplicable.value;
				if(isRejectRequestApplicable == "true"){
					f_query_add_mod.document.contactreason_form.rejectRequest_mrp_yn.disabled = false;
					f_query_add_mod.document.contactreason_form.rejectRequest_mrp_yn.value=(f_query_add_mod.document.contactreason_form.rejectRequest_mrp_yn .checked)?"Y":"N";
				}
				/*End*/
				/*Added by Mujafar for ML-MMOH-CRF-0714 Start*/
				var isRejectReportApplicable = f_query_add_mod.document.contactreason_form.isRejectReportApplicable.value;
				if(isRejectReportApplicable == "true"){
					f_query_add_mod.document.contactreason_form.rejectReport_mrp_yn.disabled = false;
					f_query_add_mod.document.contactreason_form.rejectReport_mrp_yn.value=(f_query_add_mod.document.contactreason_form.rejectReport_mrp_yn .checked)?"Y":"N";
				}
				/*End*/
				/*Below line added for this CRF ML-MMOH-CRF-0566*/
				var referralRegister = f_query_add_mod.document.contactreason_form.referralRegister.value;
				if(referralRegister == "true"){
					f_query_add_mod.document.contactreason_form.reject_referral_reason_yn.disabled = false;
					f_query_add_mod.document.contactreason_form.reject_referral_reason_yn.value=(f_query_add_mod.document.contactreason_form.reject_referral_reason_yn .checked)?"Y":"N";
					
					f_query_add_mod.document.contactreason_form.cancel_referral_reason_yn.disabled = false;
					f_query_add_mod.document.contactreason_form.cancel_referral_reason_yn.value=(f_query_add_mod.document.contactreason_form.cancel_referral_reason_yn .checked)?"Y":"N";
				}
				/*End ML-MMOH-CRF-0566*/
				
				/*Added by Ashwini on 07-May-2018 for ML-MMOH-CRF-0589*/
				f_query_add_mod.document.contactreason_form.UNIT_TRANSFER_REASON_YN.disabled = false;
				f_query_add_mod.document.contactreason_form.UNIT_TRANSFER_REASON_YN.value = (f_query_add_mod.document.contactreason_form.UNIT_TRANSFER_REASON_YN .checked)?"Y":"N";	
				/*ML-MMOH-CRF-0589*/

				
				/*Added by Ashwini on 11-Aug-2021 for ML-BRU-CRF-0628.1*/
				f_query_add_mod.document.contactreason_form.external_appl_reason_yn.disabled = false;
				f_query_add_mod.document.contactreason_form.external_appl_reason_yn.value = (f_query_add_mod.document.contactreason_form.external_appl_reason_yn .checked)?"Y":"N";	
				/*End ML-BRU-CRF-0628.1*/
				
				/* Added for MMS-DM-CRF-0157 on 26-MAR-2020 by KAMATCHI S*/
				var isBarcodeScanningApplicable = f_query_add_mod.document.contactreason_form.isBarcodeScanningApplicable.value;
				if(isBarcodeScanningApplicable == "true"){
				f_query_add_mod.document.contactreason_form.BARCODE_SCANNING_YN.disabled = false;
				f_query_add_mod.document.contactreason_form.BARCODE_SCANNING_YN.value = (f_query_add_mod.document.contactreason_form.BARCODE_SCANNING_YN .checked)?"Y":"N";
				/*MMS-DM-CRF-0157*/
				}
					
          //<!--Added by Himanshu Saxena on 16-Jun-2023 for ML-MMOH-CRF-1972 Starts-->
				var isPendingForAdmissionAppl = f_query_add_mod.document.contactreason_form.isPendingForAdmissionAppl.value;
				if(isPendingForAdmissionAppl=="true")
				{
					f_query_add_mod.document.contactreason_form.cancel_For_admission_yn.disabled = false;
					f_query_add_mod.document.contactreason_form.cancel_For_admission_yn.value=(f_query_add_mod.document.contactreason_form.cancel_For_admission_yn .checked)?"Y":"N";
				}
				//<!--Added by Himanshu Saxena on 16-Jun-2023 for ML-MMOH-CRF-1972 ends-->
        
				/* Added by lakshmanan for ML-MMOH-CRF-1955 on 10-07-2023 Start */
				var isMarkPatientMLC=f_query_add_mod.document.contactreason_form.isMarkPatientMLC.value;
				if(isMarkPatientMLC=="true")
				{
					f_query_add_mod.document.contactreason_form.mark_mlc_yn.disabled=false;
					f_query_add_mod.document.contactreason_form.mark_nonmlc_yn.disabled=false;
					f_query_add_mod.document.contactreason_form.mark_mlc_yn.value=(f_query_add_mod.document.contactreason_form.mark_mlc_yn.checked)?"Y":"N";
					f_query_add_mod.document.contactreason_form.mark_nonmlc_yn.value=(f_query_add_mod.document.contactreason_form.mark_nonmlc_yn.checked)?"Y":"N";
				}
				/* Added by lakshmanan for ML-MMOH-CRF-1955 on 10-07-2023 end */
				
         //<!--Added by Himanshu Saxena on 30-Jun-2023 for AAKH-CRF-0175  US11 Starts-->
				//var isBiometricRejectionAppl = f_query_add_mod.document.contactreason_form.isBiometricRejectionAppl.value;
				var function_name = f_query_add_mod.document.contactreason_form.function_name_biometric_rej.value;
				if(function_name=="01") //isBiometricRejectionAppl=="true" &&
				{
					f_query_add_mod.document.contactreason_form.REASON_BIOMETRIC_REJECTION_YN.disabled = false;
					f_query_add_mod.document.contactreason_form.REASON_BIOMETRIC_REJECTION_YN.value=(f_query_add_mod.document.contactreason_form.REASON_BIOMETRIC_REJECTION_YN .checked)?"Y":"N";
				}
				//<!--Added by Himanshu Saxena on 30-Jun-2023 for AAKH-CRF-0175  US11 ends-->
			 f_query_add_mod.document.contactreason_form.submit();
		}
	}

}

function onSuccess() {
	if(f_query_add_mod.document.forms[0])
	f_query_add_mod.document.location.reload();

}

function reset() {

	if(f_query_add_mod.document.forms[0])
	//	f_query_add_mod.document.forms[0].reset();
		f_query_add_mod.document.location.reload();



}
