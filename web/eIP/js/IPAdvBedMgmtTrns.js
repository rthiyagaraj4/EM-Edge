// this global var stores the selected nursing unit at any time
// this var stores the selected nursing unit in global scope
// this var has been initialized with space since initializing
// with empty string value does not make this variable a valid var in javascript
var selectedNursingUnit = ' ';

// this var is for tracking page auto refresh functionality
var refreshInAction = false;

var isBedBubbleShown = false;

function checkAndRefreshPage(){
	
	if(typeof isBedBubbleShown != 'undefined'){
		if(isBedBubbleShown == true){
			return;
		}	
	}
	
	// just for safe way of checking
	//if(refreshInAction){
		//refreshInAction = true;	
	//}
	
	//parent.serachFrame.popDynamicValues(true);
	parent.serachFrame.popDynamicValues(true);
	
	// reset the auto refresh tracking var 
	//if(refreshInAction){
		//refreshInAction = false;	
	//}
}


function popDynamicValues(refresh){
	var selOptionIndex = parent.serachFrame.document.getElementById("nursingunitcombo").selectedIndex;
	var selNursingUnitDesc = parent.serachFrame.document.getElementById("nursingunitcombo").options[selOptionIndex].text;
	var selNursingUnit = parent.serachFrame.document.getElementById("nursingunitcombo").value;

	//alert(selOptionIndex);
	// code added to set the selected nursing unit to the global variable
	// the global variable is accessed for patient search functionality as of now
	// global variable will be useful for other scenarios as well
	if(selectedNursingUnit){
		if(selNursingUnit.length > 0){
			selectedNursingUnit = selNursingUnit;	
		}else{
			// this is done for the case when user has selected a valid NU 
			// first and then selected "select" in the combo
			selectedNursingUnit = " ";
		}
		//alert('selected nursing unit ='+selectedNursingUnit);
	}else{
		//alert('Could not refresh the page due to internal error.');
		return;
	}
	
	//alert(selectedNursingUnit);
	
	// code added to get the patient search YN value, patient id specified
	// the room number and the bed number of the searched patient
	// these values are present as hidden fields in the bed mgmt main GUI

	var patSrchYN = 'N';
	var patSrchPatientId = '';
	var roomNumVal = '';
	var bedNumVal = '';
	var facilityId = '';

	if(window.parent.adv_bed_mgmt){
		var patSrchYNComp = window.parent.adv_bed_mgmt.document.getElementById("patientSearch");
		//var patSrchYN = 'N';
		if(patSrchYNComp){
			patSrchYN = patSrchYNComp.value;
		}
	



	var patSrchPatientIdComp = window.parent.adv_bed_mgmt.document.getElementById("patientIdInSearch");
	//var patSrchPatientId = '';
	if(patSrchPatientIdComp){
		patSrchPatientId = patSrchPatientIdComp.value;
	}
	
	var roomNumComp = window.parent.adv_bed_mgmt.document.getElementById("roomNumInSearch");
	//var roomNumVal = '';
	if(roomNumComp){
		roomNumVal = roomNumComp.value;
	}
	var bedNumComp = window.parent.adv_bed_mgmt.document.getElementById("bedNumInSearch");
	//var bedNumVal = '';
	if(bedNumComp){
		bedNumVal = bedNumComp.value;
	}
	
	// if patient id is specified in search text field, get the nursing unit to
	// which the patient belongs using AJAX
	// if the new nursing unit is different from the current one, then refresh the page
	// with the new one
	// if the new nursing unit is invalid, show error message and wipe out the patient id
	var facilityIdComp = window.parent.adv_bed_mgmt.document.getElementById("facility_id");
	//var facilityId = '';
	if(facilityIdComp){
		facilityId = facilityIdComp.value;
	}

}
	console.log(patSrchYN + ' patSrchYN ');
	console.log(patSrchPatientId + ' patId ');
	console.log(roomNumVal + ' roomNum ');
	console.log(bedNumVal + ' bedNum ');
	console.log(facilityId + ' fac ');
	// get the patient id search text field component
	var patientIdInSrchComp = window.parent.serachFrame.document.getElementById("patient_id");
	// there is a need to go in a hierarchial manner using a number of if loops
	if(patientIdInSrchComp){
		// get patient id value
		var tempPatId = patientIdInSrchComp.value;
		if(tempPatId){
			// trim patient id
			tempPatId = trimText(tempPatId);
			if(tempPatId.length > 0){
				// get the nursing unit for the patient
				var tempNU = patientSearchOnMainPageRefresh(tempPatId,facilityId);
				//alert(tempNU);
				if(tempNU){
					tempNU = trimText(tempNU);
					if(tempNU.length > 0){
						// this is the decisive condition
						// if the new nursing unit is different from current
						// reassign the var 
						if(tempNU != selNursingUnit){
							/*selNursingUnit = tempNU;
						
							// there is no need to show a message
							// set the new nursing unit as the selected nursing
							// unit in the combo
							parent.serachFrame.document.getElementById("nursing_unit").value = selNursingUnit;*/

							// if user has selected new nursing unit, then
							// there is a need to reset the patient id in the search field
							/*if(refreshInAction == false){*/
								if(refresh == false){
									// clear the patient id
									patientIdInSrchComp.value = '';
									
									// reset the hidden variables
									if(roomNumComp){
										roomNumComp.value = '';
									}
									if(bedNumComp){
										bedNumComp.value = '';
									}
									
									// this is to store the patient id
									if(patSrchPatientIdComp){
										patSrchPatientIdComp.value = '';
										patSrchPatientId = '';
									}
									
									// this is to store whether patient search has been
									// performed - in this case, it is not so value is 'N'
									if(patSrchYNComp){
										patSrchYNComp.value = 'N';
										patSrchYN = 'N';
									}
									
								}else{
									// control comes here in refresh page scenario
									// in this case, the selected nursing unit should
									// be the nursing unit obtained from servlet

									selNursingUnit = tempNU;
									// set the new nursing unit as the selected nursing
									// unit in the combo
									parent.serachFrame.document.getElementById("nursing_unit").value = selNursingUnit;
									
									// the hidden variables will have correct values
									// no need to set or reset any of them
									// proceed to refresh the page
									patSrchYN = 'Y';
									patSrchPatientId = tempPatId;
								}
							/*}*/
						}
					}else{
						// show an error message that we were not able
						// to get the nursing unit for the patient id
						// control will come here only in the refresh page scenario
						//alert('Could not retrieve nursing unit for patient id '+tempPatId+'. Patient id will be cleared.');
						patSrchYN = 'N';
						patientIdInSrchComp.value = '';
						patSrchPatientId = '';
						roomNumVal = '';
						bedNumVal = '';
					}
				}else{
					// show an error message that we were not able
					// to get the nursing unit for the patient id
					// control will come here only in the refresh page scenario
					//alert('Could not retrieve nursing unit for patient id '+tempPatId+'. Patient id will be cleared.');
					patSrchYN = 'N';
					patientIdInSrchComp.value = '';
					patSrchPatientId = '';
					roomNumVal = '';
					bedNumVal = '';
				}	
			}else{
				patSrchYN = 'N';
				patSrchPatientId = '';
				patientIdInSrchComp.value = '';
				roomNumVal = '';
				bedNumVal = '';
			}
		}else{
			patSrchYN = 'N';
			patSrchPatientId = '';
			patientIdInSrchComp.value = '';
			roomNumVal = '';
			bedNumVal = '';
		}
		//alert('patient id in text field='+tempPatId);
	}else{
		//alert('patient id in text field is not obtained ');
		patSrchYN = 'N';
		patSrchPatientId = '';
		patientIdInSrchComp.value = '';
		roomNumVal = '';
		bedNumVal = '';
	}
	
	// form the URL to be invoked
	//var url = "../../eIP/jsp/IPAdvBedMgmt.jsp?nursingUnit="+selNursingUnit+"&nursingUnitDesc="+selNursingUnitDesc;
	var url = "../../eIP/jsp/IPAdvBedMgmtTrns.jsp?nursingUnit="+selNursingUnit+"&nursingUnitDesc="+selNursingUnitDesc;
	url += "&patientSearch="+patSrchYN+"&patientIdInSearch="+patSrchPatientId;
	url += "&roomNumInSearch="+roomNumVal+"&bedNumInSearch="+bedNumVal;
	//console.log(window.parent.adv_bed_mgmt + ' location ')
	parent.adv_bed_mgmt.location.href=url;
	/*if(parent.frames[2] && parent.frames[2].document.getElementById("+patient_id+")){
		parent.frames[2].document.getElementById("+patient_id+").value='';
	}*/
	
	showMessageInStatusFrame(1,'Page is loading...');
}
function focusTxt(){
	Nursing_Unit_Bed.nursing_unit.focus();
	
}
/*
	calling assign treating practitioner
*/
function assignTreatingPract(facility_id,nursing_unit,patient_id,encounter_id,practitioner_id){
	var arguments   = "" ;
	var dialogHeight= "60vh" ;
	var dialogTop = "72px" ;
	var dialogWidth	= "65vw" ;
	var status = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;

//alert(features);
	//URL:../../eIP/jsp/AssignTreatingPractMain.jsp?location_code=NU15&encounterId=10000759&function_id=ASSIGN_TREAT_PRACT&function_name=&patientId=0123456789&Practitioner_Id=ALLEN&callfrom=IP&call_function=AssignTreatingPract&Sex=Female&mode=modal&bl_instal=N&status_value=&confirmIP=&p_service_type=&chg_nurs_unit_in_assign_bed_yn=N&oper_stn_id=ALLSTATION&pat_check_in_allowed_yn=Y&setup_bl_dtls_in_ip_yn=N&bl_interfaced_yn=Y&priotity_status=Y&change_bed_class_yn=Y&deactivate_pseudo_bed_yn=N&dflt_blk_prd_for_tfr_out=0&bed_block_period_normal=2&reserve_bed_on_tfr_yn=Y&bed_block_period_max=4&bed_block_period_max_type=H&allow_multiple_bed_for_resv_yn=Y&mother_cut_off_age_pda=&mother_max_age_pda=&max_disch_period_for_predc=23&contact1_name_pda=&contact2_name_pda=
	var URL="../../eIP/jsp/AssignTreatingPractMain.jsp?location_code="+nursing_unit+"&encounterId="+encounter_id+"&function_id=ASSIGN_TREAT_PRACT&Practitioner_Id="+practitioner_id;
	
	retVal =    window.showModalDialog(URL,arguments,features);
	parent.adv_bed_mgmt.location.href="../../eIP/jsp/IPAdvBedMgmtTrns.jsp?nursingUnit="+document.forms[0].nursingUnit.value;
	if(parent.frames[2] && parent.frames[2].document.getElementById("+patient_id+")){
		parent.frames[2].document.getElementById("+patient_id+").value='';
	}
}
// function to call prepare discharge advice. Sudhakar
async function PrepDischrgAdvice(facility_id,nursing_unit,patient_id,encounter_id,pend_ord_stats,pat_dtls_unknown,finalize_yn){
	var function_id='PRE_DIS_ADVICE';
	var function_name='';
	var callfrom='IP';
	var call_function='PrepareDischargeAdvice';
	var mode='modal';
	var bl_instal='';//Get value from main page
	var oper_stn_id="";//operator station id
	var setup_bl_dtls_in_ip_yn=document.forms[0].setup_bl_dtls_in_ip_yn.value;
	var bl_interfaced_yn=document.forms[0].bl_interfaced_yn.value;
	var allow_discharge_date=document.forms[0].allow_discharge_date.value;
	var max_disch_period_for_predc=document.forms[0].max_disch_period_for_dc.value;
	var mother_cut_off_age=document.forms[0].mother_cut_off_age.value;
	var mother_max_age=document.forms[0].mother_max_age.value;
	//String contact1_name_pda				= checkForNull(request.getParameter("contact1_name_pda"));//get from mp_pat_rel_contacts,column name contact1_name
	//String contact2_name_pda				= checkForNull(request.getParameter("contact2_name_pda"));//get from mp_pat_rel_contacts,column name contact2_name
	var chk_for_pen_orders_bfr_dis_adv=document.forms[0].chk_for_pen_orders_bfr_dis_adv.value;
	var dis_adv_allow_yn=document.forms[0].dis_adv_allow_yn.value;
	var bl_operational=document.forms[0].bl_operational.value;//billing operational at facility level.
	var proc_flg="N";
	if(bl_operational=='Y'){
		if(chk_for_pen_orders_bfr_dis_adv=='Y'){
			if(pend_ord_stats =='Y'){//if pending orders exists
				var HTMLVal		= new String();
				var p_facility_id=facility_id;
				var p_patient_id= patient_id;
				var p_enc_id=encounter_id;
				var dialogHeight= "29vh" ;
				var dialogTop = "125px" ;
				var dialogWidth	= "50vw" ;
				var status = "no";
				var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;
				var url="../../eOR/jsp/ViewPendingOrders.jsp?patient_id="+p_patient_id+"&encounter_id="+p_enc_id+"&facility_id="+p_facility_id+"&discharge_ind=A";
				if(dis_adv_allow_yn=='Y'){//if Y then orders will be shown and the proceed to prepare discharge advice.			
					var retVal = new String();
					retVal = await window.showModalDialog(url,arguments,features);
					if(window.confirm(getMessage("PROCEED_DISCHARGE_ADVICE","IP"))){
						proc_flg="Y";
					}
				}else{
					if(window.confirm(getMessage("ORDER_PENDING_CNT_PROCEED_VIEW","IP"))){
						var retVal = new String();
						retVal = await window.showModalDialog(url,arguments,features);
					}
				}
			}else{
				proc_flg="Y";
			}
		}else{
			proc_flg="Y";//no need to check pending orders based ip param set up.
		}

	}else{
		proc_flg="Y";		
	}
	if(proc_flg=='Y'){
		var URL="../../eIP/jsp/DischargeAdviceMain.jsp?encounterId="+encounter_id+"&patientId="+patient_id+"&function_id="+function_id+"&setup_bl_dtls_in_ip_yn="+setup_bl_dtls_in_ip_yn+"&bl_interfaced_yn="+bl_interfaced_yn+"&max_disch_period_for_predc="+max_disch_period_for_predc+"&allow_discharge_date_predc="+allow_discharge_date+"&mother_cut_off_age_pda="+mother_cut_off_age+"&mother_max_age_pda="+mother_max_age+"&pat_dtls_unknown_yn_pda="+pat_dtls_unknown+"&contact1_name_pda=&contact2_name_pda=";
		var features="dialogHeight:43vh; scroll=no; dialogWidth:65vw; center: 1; status: no; dialogTop :72px";
		var arguments="";
		retVal =    window.showModalDialog(URL,arguments,features);
		//parent.frames[2].document.location.reload();
		parent.adv_bed_mgmt.location.href="../../eIP/jsp/IPAdvBedMgmtTrns.jsp?nursingUnit="+document.forms[0].nursingUnit.value;
		if(parent.frames[2] && parent.frames[2].document.getElementById("+patient_id+")){
			parent.frames[2].document.getElementById("+patient_id+").value='';
		}
	}	
}

function CancelDischrgAdvice(facility_id,nursing_unit,patient_id,encounter_id,pend_ord_stats,pat_dtls_unknown,finalize_yn){
	var bl_operational=document.forms[0].bl_operational.value;//billing operational at facility level.
	var arguments="";
	var features="dialogHeight:43vh; scroll=no; dialogWidth:65vw; center: 1; status: no; dialogTop :72";
	var proceedFlag=false;
	var URL="../../eIP/jsp/CancelDischargeAdviceMain.jsp?encounterId="+encounter_id+"&function_id=CAN_DIS_ADVICE";
	//URL:../../eIP/jsp/CancelDischargeAdviceMain.jsp?location_code=NU15&encounterId=10000596&function_id=CAN_DIS_ADVICE&function_name=&patientId=GH00000470&Practitioner_Id=NARESH&callfrom=IP&call_function=CancelDischargeAdvice&Sex=Male&mode=modal&bl_instal=Y&status_value=&confirmIP=&p_service_type=&chg_nurs_unit_in_assign_bed_yn=N&oper_stn_id=ALLSTATION&pat_check_in_allowed_yn=Y&setup_bl_dtls_in_ip_yn=N&bl_interfaced_yn=Y&priotity_status=Y&change_bed_class_yn=Y&deactivate_pseudo_bed_yn=N&dflt_blk_prd_for_tfr_out=0&bed_block_period_normal=2&reserve_bed_on_tfr_yn=Y&bed_block_period_max=4&bed_block_period_max_type=H&allow_multiple_bed_for_resv_yn=Y&mother_cut_off_age_pda=&mother_max_age_pda=&max_disch_period_for_predc=23&contact1_name_pda=&contact2_name_pda=undefined;
	if(bl_operational=="Y"){
		if(finalize_yn=='Y'){
			alert(getMessage("MDR_FINALIZED_DISCH_CANT_CANCEL","MR"));
		}else{
			//check billing related things to proceed to cancel discharge advice.
			/*var HTMLVal = new String();
			var IPval=document.forms[0].nursingUnit.value;
			document.forms[0].jsp_name.value='CancelDischargeAdviceMain.jsp';
			HTMLVal = "<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eIP/jsp/FindCancelDischargeAdvice.jsp?IP_val="+IPval+"&encounter_Id="+encounter_id+"&patient_Id="+patient_id+"&Practitioner_Id=&callfrom=IP&call_function=CancelDischargeAdviceMain.jsp&jsp_name=CancelDischargeAdviceMain.jsp&Sex=&p_service_type=&mode=modal&function_id=CAN_DIS_ADVICE'></form></BODY></HTML>";
			parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);
			parent.messageFrame.document.form1.submit();*/
			$.post("../../servlet/eIP.IPAdvBedMgmtTrnsServlet",
			{
				operation: "cancelDischargeAdvice",
				nursingUnit:document.forms[0].nursingUnit.value,
				encounter_id:encounter_id,
				patient_id:patient_id,
				function_id:'CAN_DIS_ADVICE'
			},
			function(err_mesg, textStatus)
			{
				//alert('err_mesg==>'+err_mesg+"<==");
				//alert(err_mesg.substring(0,2))
				if(err_mesg=='0'){
					var URL="../../eIP/jsp/CancelDischargeAdviceMain.jsp?encounterId="+encounter_id+"&function_id=CAN_DIS_ADVICE";
					var dialogHeight= "40vh" ;
					var dialogTop = "75px" ;
					var dialogWidth	= "65vw" ;
					var status = "no";
					var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;
					var arguments="";
					//alert(URL)
					retVal =    window.showModalDialog(URL,arguments,features);
					parent.adv_bed_mgmt.location.href="../../eIP/jsp/IPAdvBedMgmtTrns.jsp?nursingUnit="+document.forms[0].nursingUnit.value;
					if(parent.frames[2] && parent.frames[2].document.getElementById("+patient_id+")){
						parent.frames[2].document.getElementById("+patient_id+").value='';
					}
				}else{
					if(err_mesg.length=='6'){ 
						alert(getMessage(err_mesg,'BL')); 
					}else if (!err_mesg.substring(0,2)=="**"){ 
						alert(getMessage(err_mesg,'BL')); 
					}else{ 
						alert(err_mesg); 
					} 

				}
			});
		}
	}else{//billing not installed,then directly call cancel discharge advice
		if(finalize_yn=='Y'){
			alert(getMessage("MDR_FINALIZED_DISCH_CANT_CANCEL","MR"));
		}else{
			proceedFlag=true;
		}
	}
	if(proceedFlag){
		retVal =    window.showModalDialog(URL,arguments,features);
		parent.adv_bed_mgmt.location.href="../../eIP/jsp/IPAdvBedMgmtTrns.jsp?nursingUnit="+document.forms[0].nursingUnit.value;
		if(parent.frames[2] && parent.frames[2].document.getElementById("+patient_id+")){
			parent.frames[2].document.getElementById("+patient_id+").value='';
		}
	}
	
}
async function DischargePatient(facility_id,nursing_unit,patient_id,encounter_id,pend_ord_stats,pat_dtls_unknown,finalize_yn){
	var function_id='PRE_DIS_ADVICE';
	var function_name='';
	var callfrom='IP';
	var call_function='PrepareDischargeAdvice';
	var mode='modal';
	var bl_instal='';//Get value from main page
	var oper_stn_id="";//operator station id
	var setup_bl_dtls_in_ip_yn=document.forms[0].setup_bl_dtls_in_ip_yn.value;
	var bl_interfaced_yn=document.forms[0].bl_interfaced_yn.value;
	var allow_discharge_date=document.forms[0].allow_discharge_date.value;
	var max_disch_period_for_predc=document.forms[0].max_disch_period_for_dc.value;
	var mother_cut_off_age=document.forms[0].mother_cut_off_age.value;
	var mother_max_age=document.forms[0].mother_max_age.value;
	//String contact1_name_pda				= checkForNull(request.getParameter("contact1_name_pda"));//get from mp_pat_rel_contacts,column name contact1_name
	//String contact2_name_pda				= checkForNull(request.getParameter("contact2_name_pda"));//get from mp_pat_rel_contacts,column name contact2_name
	var chk_for_pen_orders_bfr_dis=document.forms[0].chk_for_pen_orders_bfr_dis.value;
	var dis_allow_yn=document.forms[0].dis_allow_yn.value;
	var bl_operational=document.forms[0].bl_operational.value;//billing operational at facility level.
	var proc_flg="N";
	if(chk_for_pen_orders_bfr_dis=='Y'){
		if(pend_ord_stats =='Y'){//if pending orders exists
			var HTMLVal		= new String();
			var p_facility_id=facility_id;
			var p_patient_id= patient_id;
			var p_enc_id=encounter_id;
			var dialogHeight= "29vh" ;
			var dialogTop = "125px" ;
			var dialogWidth	= "50vw" ;
			var status = "no";
			var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;
			var url="../../eOR/jsp/ViewPendingOrders.jsp?patient_id="+p_patient_id+"&encounter_id="+p_enc_id+"&facility_id="+p_facility_id+"&discharge_ind=D";
			if(dis_allow_yn=='Y'){//if Y then orders will be shown and the proceed to discharge.			
				var retVal = new String();
				retVal = await window.showModalDialog(url,arguments,features);
				if(window.confirm(getMessage("PROCEED_DISCHARGE","IP"))){
					proc_flg="Y";
				}
			}else{
				if(window.confirm(getMessage("ORDER_PENDING_CNT_PROCEED_VIEW","IP"))){
					var retVal = new String();
					retVal = await window.showModalDialog(url,arguments,features);
				}
			}
		}else{
			proc_flg="Y";
		}
	}else{
		proc_flg="Y";//no need to check pending orders based ip param set up.
	}
	//alert('DischargePatient proc_flg:'+proc_flg)
	//alert('DischargePatient bl_operational:'+document.forms[0].bl_operational.value)
	//alert('DischargePatient bl_dtls_in_ip:'+document.forms[0].setup_bl_dtls_in_ip_yn.value)
	if(proc_flg=='Y'){
	
		$.post("../../servlet/eIP.IPAdvBedMgmtTrnsServlet",
			{
				operation: "DischargePatient",
				nursingUnit:document.forms[0].bl_operational.value,
				encounter_id:encounter_id,
				patient_id:patient_id,
				function_id:'DISCHARGE_PATIENT',
				bl_operational:document.forms[0].bl_operational.value,
				bl_dtls_in_ip:document.forms[0].bl_operational.value
				//bl_dtls_in_ip:document.forms[0].setup_bl_dtls_in_ip_yn.value
			},
			function(err_mesg, textStatus)
			{
				//alert('err_mesg DischargePatient==>'+err_mesg+"<==");
				//alert(err_mesg.substring(0,2))
				if(err_mesg=='0' || err_mesg==''){
					var URL="../../eIP/jsp/PaintDischargePatient.jsp?location_code=&encounterId="+encounter_id+"&patientId="+patient_id+"&Practitioner_Id=&callfrom=IP&call_function=PaintDischargePatient.jsp&p_service_type=undefined&Sex=&mode=modal&function_id=DISCHARGE_PATIENT&bl_interfaced_yn="+document.forms[0].bl_interfaced_yn.value+"&discharge_checklist_app_yn="+document.forms[0].discharge_checklist_app_yn.value+"&bed_block_period_dis="+document.forms[0].bed_block_period_dis.value+"&dis_date_chk_days="+document.forms[0].dis_date_chk_days.value+"&dis_date_chk_days_unit="+document.forms[0].dis_date_chk_days_unit.value+"&diag_update_period_max_unit="+document.forms[0].diag_update_period_max_unit.value+"&max_disch_period_for_predc="+document.forms[0].max_disch_period_for_dc.value+"&deactivate_pseudo_bed_yn="+document.forms[0].deactivate_pseudo_bed_yn.value+"&allow_late_discharge_reason="+document.forms[0].allow_late_discharge_reason.value+"&disch_reason_mand_yn="+document.forms[0].disch_reason_mand_yn.value;
					//alert('url:'+URL)
					//Sex parameter is not required to pass.
					var dialogHeight= "43vh";
					var dialogWidth = "65vw";
					var dialogTop	= "72px";
					var center = "1" ;
					var status="no";
					var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
					var arguments="";
					//alert(URL)
					retVal =    window.showModalDialog(URL,arguments,features);
					parent.adv_bed_mgmt.location.href="../../eIP/jsp/IPAdvBedMgmtTrns.jsp?nursingUnit="+document.forms[0].nursingUnit.value;
				}else{
					if (err_mesg.substring(0,2)=="**"){
						alert(err_mesg);
					}else{						
						alert(getMessage(err_mesg,'BL'));
					}
				}
			});
		//<HTML><BODY onKeyDown='lockKey()'><form name='form1' id='form1' method='post' action='../../eIP/jsp/FindPatientDischarge.jsp?IP_val=NU15&encounter_Id=10000918&patient_Id=GH00000687&Practitioner_Id=ALLEN&callfrom=IP&call_function=PaintDischargePatient.jsp&jsp_name=PaintDischargePatient.jsp&Sex=Male&p_service_type=&bl_install_yn=Y&mode=modal&function_id=DISCHARGE_PATIENT&bl_interfaced_yn=Y&discharge_checklist_app_yn=N&bed_block_period_dis=1&dis_date_chk_days=6&dis_date_chk_days_unit=D&diag_update_period_max_unit=&max_disch_period_for_predc=23&deactivate_pseudo_bed_yn=N&allow_late_discharge_reason=N&disch_reason_mand_yn=N'></form></BODY></HTML>
		/*var URL="../../eIP/jsp/DischargeAdviceMain.jsp?encounterId="+encounter_id+"&patientId="+patient_id+"&function_id="+function_id+"&setup_bl_dtls_in_ip_yn="+setup_bl_dtls_in_ip_yn+"&bl_interfaced_yn="+bl_interfaced_yn+"&max_disch_period_for_predc="+max_disch_period_for_predc+"&allow_discharge_date_predc="+allow_discharge_date+"&mother_cut_off_age_pda="+mother_cut_off_age+"&mother_max_age_pda="+mother_max_age+"&pat_dtls_unknown_yn_pda="+pat_dtls_unknown+"&contact1_name_pda=&contact2_name_pda=";
		var features="dialogHeight:43; scroll=no; dialogWidth:65; center: 1; status: no; dialogTop :72";
		var arguments="";
		retVal =    window.showModalDialog(URL,arguments,features);
		parent.adv_bed_mgmt.location.href="../../eIP/jsp/IPAdvBedMgmt.jsp?nursingUnit="+document.forms[0].nursingUnit.value;*/
	}
}
function dummyFun(obj){
	//alert("Functionality under development:");
}
function patientChart(facility_id,nursing_unit,patient_id,encounter_id,pend_ord_stats,pat_dtls_unknown,finalize_yn,user_id){
	//alert('patientChart');
	//Added by Ajay Hatwate for MMS-DM-CRF-0210.1
	xmlStr = "<root><SEARCH patient_id=\""+patient_id+"\" logged_user=\""+user_id+"\" action='isPractRestricted' /></root>"
	 var temp_jsp="../../eMP/jsp/MPIntermediate.jsp";
	 var xmlDoc = "" ;
	 var xmlHttp = new XMLHttpRequest() ;
	 xmlDoc = new DOMParser().parseFromString(xmlStr, "text/xml");
	 xmlHttp.open("POST",temp_jsp,false);
	 xmlHttp.send(xmlDoc);
	 var responseText = xmlHttp.responseText;
	 var response = trimString(xmlHttp.responseText);
	 //End of MMS-DM-CRF-0210.1
	 if(response == "N"){
	parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
	var bl_operational=document.forms[0].bl_operational.value;//billing operational at facility level.
	var arguments="";
	var features="dialogHeight:43vh; scroll=no; dialogWidth:65vw; center: 1; status: no; dialogTop :72px";
	var HTMLVal  = "<html>";
			HTMLVal  += "<form name='OpenChartWrapperForm' id='OpenChartWrapperForm' action = '../../eCA/jsp/OpenChartWrapper.jsp' method='post' target='messageFrame' >";
			HTMLVal  += "<input type='hidden' name='encounter_id' id='encounter_id' value='" + encounter_id + "'>";
			HTMLVal  += "<input type='hidden' name='from_module' id='from_module' value='AE'>";
			HTMLVal  += "<input type='hidden' name='patChartCalledFrm' id='patChartCalledFrm' value='OP'>";
			HTMLVal  += "<input type='hidden' name='from_service_yn' id='from_service_yn' value='Y'>";
			HTMLVal  += "</form>";
			HTMLVal  += "</html>";
			//alert(HTMLVal)
			parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);	
			parent.messageFrame.document.OpenChartWrapperForm.submit();
			//parent.adv_bed_mgmt.location.href="../../eIP/jsp/IPAdvBedMgmt.jsp?nursingUnit="+document.forms[0].nursingUnit.value;
			/*var retVal=	window.showModalDialog('../../eCA/jsp/OpenChartWrapper.jsp?called_from_ip=Y&from_module=IP&patChartCalledFrm=IP&encounter_id='+encounter_id,arguments,features);*/
			/*var HTMLVal  = "<html>";
			HTMLVal  += "<form name='OpenChartWrapperForm' id='OpenChartWrapperForm' action = '../../eCA/jsp/OpenChartWrapper.jsp' method='post' target='messageFrame' >";
			HTMLVal  += "<input type='hidden' name='encounter_id' id='encounter_id' value='" + encounter_id + "'>";
			HTMLVal  += "<input type='hidden' name='from_module' id='from_module' value='IP'>";
			HTMLVal  += "<input type='hidden' name='patChartCalledFrm' id='patChartCalledFrm' value='IP'>";
			HTMLVal  += "<input type='hidden' name='from_service_yn' id='from_service_yn' value='N'>";
			HTMLVal  += "</form>";
			HTMLVal  += "</html>";
			parent.messageFrame.document.body.insertAdjacentHTML('afterbegin',HTMLVal);	
			parent.messageFrame.document.OpenChartWrapperForm.submit();*/
}else{
	alert(getMessage('ACCESS_RESTRICTED_AUTH_PERSONAL','COMMON'));
}
}
function callAllergy(event,patient_id)
{
	
	var dialogHeight= "39vh" ;//"29"
	var dialogWidth	= "100vw" ;//"42"
	var dialogTop	= "76px";
	var features    =  "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+";scroll=auto; status:no ";
	if (!e) var e = window.event;
	e.cancelBubble = true;
	if (e.stopPropagation) e.stopPropagation();
	//var retVal=	window.showModalDialog('../../eCA/jsp/PaintPatAllegyResult.jsp?patient_id='+patient_id+'&modal_yn=Y',arguments,features);
	var retVal=	window.showModalDialog('../../eCA/jsp/AllergyList.jsp?called_from_ip=Y&patient_id='+patient_id,arguments,features);
} 
function check(obj){
	if(obj.value!='' && window.parent.adv_bed_mgmt.document.getElementById(obj.value+'Dummy')){
		window.parent.adv_bed_mgmt.document.getElementById(obj.value+'Dummy').click();
	}else if(obj.value!='' && window.parent.adv_bed_mgmt.document.forms[0]){
		alert(getMessage("PAT_DATA_NOT_AVAILABLE","IP"));
		if(parent.frames[2] && parent.frames[2].document.getElementById("+patient_id+")){
			parent.frames[2].document.getElementById("+patient_id+").value='';
		}
	}else{
		if(parent.frames[2] && parent.frames[2].document.getElementById("+patient_id+")){
			parent.frames[2].document.getElementById("+patient_id+").value='';
		}
	}
}

function admitPatient(facility_id,nursing_unit,appl_patient_class,bedNo){
	if(parent.frames[2] && parent.frames[2].document.getElementById("+patient_id+")){
		parent.frames[2].document.getElementById("+patient_id+").value='';
	}
	var dialogHeight= "100vh" ;//"29"
	var dialogWidth	= "100vw" ;//"42"
	var dialogTop	= "70px";
	var features    =  "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+";scroll=auto; status:no ";	
	var URL='../../eIP/jsp/AdmitPatient.jsp?from_adv_bed_mgmt=Y&nursing_unit='+nursing_unit+'&appl_patient_class='+appl_patient_class+'&bedNo='+bedNo;	
	retVal =    window.showModalDialog(URL,arguments,features);
	parent.adv_bed_mgmt.location.href="../../eIP/jsp/IPAdvBedMgmtTrns.jsp?nursingUnit="+document.forms[0].nursingUnit.value;	
}
function AssignBedMarkArrival(facility_id,nursing_unit,patient_id,encounter_id,operStnId,user_id){
	if(parent.frames[2] && parent.frames[2].document.getElementById("+patient_id+")){
		parent.frames[2].document.getElementById("+patient_id+").value='';
	}
	var dialogHeight= "100vh" ;//"29"
	var dialogWidth	= "100vw" ;//"42"
	var dialogTop	= "70px";
	var features    =  "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+";scroll=auto; status:no ";	
	//URL:../../eIP/jsp/AssignBedMain.jsp?location_code=NU15&encounterId=10001132&function_id=ASSIGN_BED&function_name=&patientId=GH00000019&Practitioner_Id=IPval&callfrom=IP&call_function=assign_bed&Sex=&mode=modal&bl_instal=N&status_value=undefined&confirmIP=&p_service_type=&chg_nurs_unit_in_assign_bed_yn=&oper_stn_id=ALLSTATION&pat_check_in_allowed_yn=N&setup_bl_dtls_in_ip_yn=N&bl_interfaced_yn=N&priotity_status=Y&change_bed_class_yn=Y&deactivate_pseudo_bed_yn=N&dflt_blk_prd_for_tfr_out=2&bed_block_period_normal=2&reserve_bed_on_tfr_yn=Y&bed_block_period_max=240&bed_block_period_max_type=H&allow_multiple_bed_for_resv_yn=Y&mother_cut_off_age_pda=&mother_max_age_pda=&max_disch_period_for_predc=23&contact1_name_pda=undefined&contact2_name_pda=undefined

	var URL='../../eIP/jsp/AssignBedMain.jsp?function_id=ASSIGN_BED&call_function=assign_bed&from_adv_bed_mgmt=Y&patientId='+patient_id+'&encounterId='+encounter_id+'&location_code='+nursing_unit+"&oper_stn_id="+operStnId+'&pat_check_in_allowed_yn='+document.forms[0].pat_check_in_allowed_yn.value+'&setup_bl_dtls_in_ip_yn='+document.forms[0].setup_bl_dtls_in_ip_yn.value;	
	retVal =    window.showModalDialog(URL,arguments,features);
	parent.adv_bed_mgmt.location.href="../../eIP/jsp/IPAdvBedMgmtTrns.jsp?nursingUnit="+document.forms[0].nursingUnit.value;
}	
	
function menuFun(){
	parent.parent.parent.frames[1].expand(this);
}



function trimText(textVal){
	// this function trims the input text
	var tempVal = textVal;
	tempVal = tempVal.replace(/(?:(?:^|\n)\s+|\s+(?:$|\n))/g,'').replace(/\s+/g,' ');
    return tempVal;
}

function getHttpObject(){
	// this function is used to form an xmlhttprequest object instance and return it
	// this object is used by the caller in an Ajax call
	// the formation is based on the window type
	var xmlHttp;
	/*if (window.XMLHttpRequest) {
		xmlHttp = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	}*/
	xmlHttp = new XMLHttpRequest();
	return xmlHttp;
}

function createBooking(roomNumber,roomName,bedNumber,bedClassDesc,bedTypeDesc,nursingUnit,nursingUnitDesc,func_id,func_name,func_type,module_id,menu_id,access_rights_menu_id,call_func,call_from){
	// this function invokes the create booking functionality in bed manager GUI
	// this function takes as arguements the bed number, bed class description, bed type description,
	// the nursing unit, function id, module id, menu id, function name 
	// access is not passed as it is not needed in the create booking page
	// this function invokes the create booking page - Booking.jsp
	
	//alert('menu id='+menu_id+';function id='+func_id);
	// first need to get the access rights
	// make an ajax call to the access rights servlet
	var accessRight = "";
	var xmlHttp = getHttpObject();
	xmlHttp.onreadystatechange=function(){
 		if(xmlHttp.readyState==4 && xmlHttp.status==200){
 			accessRight = xmlHttp.responseText;
 			//alert(accessRight);
 			var URL='../../eIP/jsp/Booking.jsp?menu_id='+menu_id+'&module_id='+module_id+'&function_id='+func_id+'&function_name='+func_name+'&function_type='+func_type+'&roomNumber='+roomNumber+'&roomName='+roomName+'&bedNumber='+bedNumber+'&bedClass='+bedClassDesc+'&bedType='+bedTypeDesc+'&nursing_unit_code='+nursingUnit+'&access='+accessRight+'&home_required_yn=N&nursing_unit_desc='+nursingUnitDesc+'&call_func='+call_func+'&callFrom='+call_from;
 			var dialogHeight= "100vh" ;//"29"
 			var dialogWidth	= "100vw" ;//"42"
 			var dialogTop	= "70px";
 			var arguments   = "" ;
 			var features    =  "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+";scroll=auto; status:no ";
 			retVal =    window.showModalDialog(URL,arguments,features);
 			parent.adv_bed_mgmt.location.href="../../eIP/jsp/IPAdvBedMgmtTrns.jsp?nursingUnit="+nursingUnit;
 		}
	}
	
	xmlHttp.open("POST", "../../servlet/eIP.advbedmgmt.transaction.access.servlet.AccessServlet", true);
 	xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	var params = 'menuId='+access_rights_menu_id+'&functionId='+func_id;
	xmlHttp.send(params);
}




function cancelAdmission(nursingUnit,encounterId,patientId,practId,callFrom,
		callFunction,jspName,sex,patCheckInAllowedYN,pServiceType,mode){
	// this function launches the cancel admission page in a new window
	/*var URL='../jsp/CancelAdmissionMain.jsp?IP_val='+nursingUnit+
		'&encounter_Id='+encounterId+'&patient_Id='+patientId+'&Practitioner_Id='+
		escape(practId)+'&callfrom='+callFrom+'&call_function='+callFunction+'&jsp_name='+
		jspName+'&Sex='+sex+'&pat_check_in_allowed_yn='+patCheckInAllowedYN+'&p_service_type='+
		pServiceType+'&mode='+mode;*/
	var URL='../jsp/CancelAdmissionMain.jsp?location_code='+nursingUnit+
	'&encounterId='+encounterId+'&patientId='+patientId+'&Practitioner_Id='+
	escape(practId)+'&callfrom='+callFrom+'&call_function='+callFunction+
	'&Sex='+sex+'&pat_check_in_allowed_yn='+patCheckInAllowedYN+'&p_service_type='+
	pServiceType+'&mode='+mode;
	//alert(URL);
	var arguments   = "" ;
	var dialogHeight= "100vh" ;//"29"
	var dialogWidth	= "100vw" ;//"42"
	var dialogTop	= "70px";
	var features    =  "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+";scroll=auto; status:no ";
	//alert('before showing the modal window');
	var retVal =    window.showModalDialog(URL,arguments,features);
	//alert('after showing the modal window');
	parent.adv_bed_mgmt.location.href="../../eIP/jsp/IPAdvBedMgmtTrns.jsp?nursingUnit="+nursingUnit;
	
}

function requestForTransfer(facilityId,encounterId,patientId,practId,nursingUnitCode,sex,bedNumber,mode){
	// this function is used to integrate the request for transfer functionality with ABM
	// this function launches the request for transfer page
	var URL = "../../servlet/eIP.advbedmgmt.transaction.requestfortransfer.servlet.RequestForTransferServlet";
	URL += "?facilityId="+facilityId+"&encounterId="+encounterId+"&patientId="+patientId;
	URL += "&practionerId="+practId+"&nursingUnit="+nursingUnitCode+"&sex="+sex;
	URL += "&bedNumber="+bedNumber+"&mode="+mode;
	
	
	var arguments   = "" ;
	var dialogHeight= "100vh" ;//"29"
	var dialogWidth	= "100vw" ;//"42"
	var dialogTop	= "70px";
	var features    =  "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+";scroll=auto; status:no ";
	var retVal =    window.showModalDialog(URL,arguments,features);
	
	parent.adv_bed_mgmt.location.href="../../eIP/jsp/IPAdvBedMgmtTrns.jsp?nursingUnit="+nursingUnitCode;
}

function showPatientFinancials(facilityId,patientIdKey,patientId,encounterIdKey,encounterId){
	// this function is used to show the patient's financials for an encounter
	// this function takes as input the facility id, patient id and the patient's
	// encounter id
	
	// first get the encounter visit num by calling servlet through AJAX
	// below code is for AJAX response handling
	var xmlHttp = getHttpObject();
	// AJAX call is synchronous 
	xmlHttp.open("POST", "../../servlet/eIP.advbedmgmt.transaction.patientfinancial.servlet.FinancialInfoServlet", false);
 	xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
 	var params = ''+patientIdKey+'='+patientId;
	params += '&'+encounterIdKey+'='+encounterId;
	xmlHttp.send(params);
	
	// handle the AJAX response
	if(xmlHttp.readyState==4 && xmlHttp.status==200){
		// get the response text and parse it to get json objects
		var responseText = xmlHttp.responseText;
		//alert(responseText);
		var dataObj = ((JSON && JSON.parse(responseText)) );
		var objLength = 0;
		if(dataObj){
			objLength = dataObj.length;	
		}
		 
		var errorMessage = '';
		var encounterVisitNum = '';
		// iterate through the json objects and get data
		for(var count=0;count<objLength;count++){
			errorMessage = dataObj[count].errorMessage;
			// trim only if value is valid
			if(errorMessage){
				errorMessage = trimText(errorMessage);	
			}
			
			// if error message is filled, then show it
			// no need to get other data
			if(errorMessage.length > 0){
				alert(errorMessage);
				return;
			} 
			
			encounterVisitNum = dataObj[count].encounterVisitNum;
			
		}
		
		// all is well if control comes here
		if(undefined != encounterVisitNum){
			encounterVisitNum = trimText(encounterVisitNum);
			// call the function to launch the financial details page
			ViewBLDtl(encounterId,encounterVisitNum,patientId);
		}
		
	}
	
}


function assignbed(nursingUnitCode,nursingUnitDesc,specialtyCode,specialtyDesc,showNursingUnitPopup,showSpecialtyPopup){
	// this function is used for assign bed functionality
	// launches the assign bed page
	// this function does not take any inputs as of now
	var arguments   = "" ;
	var dialogHeight= "43vh" ;
	var dialogTop = "72px" ;
	var dialogWidth	= "65vw" ;
	var status = "no";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status  + "; dialogTop :" + dialogTop ;
	var URL="../jsp/GBMAssignBedWrapper.jsp?";
	URL += "nursingUnitCode="+nursingUnitCode+"&nursingUnitDesc="+nursingUnitDesc;
	URL += "&specialtyCode="+specialtyCode+"&specialtyDesc="+specialtyDesc;
	URL += "&showNursingUnitPopup="+showNursingUnitPopup+"&showSpecialtyPopup="+showSpecialtyPopup;
	
	retVal =    window.showModalDialog(URL,arguments,features);
	//parent.adv_bed_mgmt.location.href="../../eIP/jsp/IPAdvBedMgmtTrns.jsp?nursingUnit="+document.forms[0].nursingUnit.value;
	/*if(parent.frames[2] && parent.frames[2].document.getElementById("+patient_id+")){
		parent.frames[2].document.getElementById("+patient_id+").value='';
	}*/
}

