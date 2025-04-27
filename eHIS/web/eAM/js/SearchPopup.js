
//Opens the respective search dialog for the given code
async function searchCode(obj,target){

	var retVal			= new String();
	var dialogHeight	= "400px" ;
	var dialogWidth	= "700px" ;
	var status			= "no";
	var arguments		= "" ;
	var query			= "";
	var search_code  = "";
	var search_desc	= "";
	var dialogTitle		= "";
	var firstParamName = "SQL";
	search_desc= "short_desc";
	var locale=document.forms[0].locale.value;
	if(document.forms[0].name =="reppgmstatgrp"){
		var fm_module_id = reppgmstatgrp.p_fm_mod.value;
		var to_module_id = reppgmstatgrp.p_to_mod.value;
		var program_type = reppgmstatgrp.p_prog_type.value;
	}

	switch(obj.name.toUpperCase()){
			/*case "AGEGROUP":
					dialogTitle=encodeURIComponent(getLabel("Common.agegroup.label","Common"));
					query = "select age_group_code, short_desc from am_age_group_lang_vw where language_id=`"+locale+"`";
					search_code="age_group_code";					
					break;*/
			/*case "AMBSTATUS":
					dialogTitle=encodeURIComponent(getLabel("Common.ambulatorystatus.label","Common")); 
					query="select ambulatory_status, short_desc from am_ambulatory_status_lang_vw where language_id=`"+locale+"` ";
					search_code="ambulatory_status";
					break;*/
			/*case "BUILDING_FM":
			case "BUILDING_TO":
					dialogTitle=encodeURIComponent(getLabel("Common.building.label","Common")); 
					if(document.forms[0].name == "repFacilityRoom")
						query="select bldng_code, short_desc from am_bldng_lang_vw where language_id=`"+locale+"` and OPERATING_FACILITY_ID =`"+repFacilityRoom.p_facility.value+"` ";
					else
						query="select bldng_code, short_desc from am_bldng_lang_vw where language_id=`"+locale+"` and OPERATING_FACILITY_ID =`"+ document.forms[0].p_facility.value +"` and EFF_STATUS = `E`";
					search_code="bldng_code";					
					break;*/
			case "FACILITY":
					dialogTitle=encodeURIComponent(getLabel("Common.facility.label","Common")); 
					query="select facility_id, facility_name from sm_facility_param_lang_vw where language_id=`"+locale+"` ";
					search_code="facility_id";
					search_desc= "facility_name";
					break;
			/*case "CARELOCN":
					dialogTitle=encodeURIComponent(getLabel("Common.locationtype.label","Common")); 
					query="select locn_type, short_desc from am_care_locn_type_lang_vw where language_id=`"+locale+"` ";
					search_code="locn_type";
					break;*/
			/*case "COI":
					dialogTitle=encodeURIComponent(getLabel("Common.CircumstanceofInjury.label","Common"));
					query="select circumstance_of_injury_code, short_desc from AM_CIRCUM_OF_INJURY_LANG_VW where language_id=`"+locale+"`  ";
					search_code="circumstance_of_injury_code";
					break;*/
			/*case "COMPLAINT":
					dialogTitle=encodeURIComponent(getLabel("Common.Complaint.label","Common")); 
					query="select complaint_code, complaint_desc from am_complaint_lang_vw where language_id=`"+locale+"` ";
					search_code="complaint_code";
					search_desc= "complaint_desc";
					break;*/
			/*case "DEPARTMENT":
					dialogTitle=encodeURIComponent(getLabel("Common.acctdept.label","Common"));
					query="select dept_code, short_desc from am_dept_lang_vw where language_id=`"+locale+"` ";
					search_code="dept_code";
					break;*/
			/*case "DEPARTMENT_FM":
			case "DEPARTMENT_TO":
					dialogTitle=encodeURIComponent(getLabel("Common.acctdept.label","Common"));
					query="select dept_code, am_get_desc.AM_DEPT(DEPT_CODE,`"+locale+"`,2) short_desc  from AM_FACILITY_DEPT  where OPERATING_FACILITY_ID =`"+document.forms[0].p_facility.value+"`  and EFF_STATUS = `E`";
					//alert("query :" +query);
					search_code="dept_code";
					search_desc= "2";
					break;*/
			/*case "SERVICE_FM":
			case "SERVICE_TO":
					dialogTitle=encodeURIComponent(getLabel("Common.service.label","Common"));
					query="select service_code,  am_get_desc.AM_SERVICE(SERVICE_CODE,`"+locale+"`,2) service_short_desc from AM_FACILITY_SERVICE where OPERATING_FACILITY_ID =`"+document.forms[0].p_facility.value+"` and EFF_STATUS = `E` ";
					search_code="service_code";
					search_desc= "2";
					break;*/
		/*	case "ROOM_FM":
			case "ROOM_TO":
					dialogTitle=encodeURIComponent(getLabel("Common.room.label","Common"));
					if(document.forms[0].name == "repFacilityRoom")
						query="select room_num, short_desc from am_facility_room_lang_vw where OPERATING_FACILITY_ID =`"+repFacilityRoom.p_facility.value+"` and language_id=`"+locale+"` ";
					else
						query="select room_num, short_desc from am_facility_room_lang_vw where OPERATING_FACILITY_ID =`"+document.forms[0].p_facility.value+"` and language_id=`"+locale+"` and EFF_STATUS = `E`";				
					search_code="room_num";
					break;*/
			/*case "DISPOSITION":
					dialogTitle=encodeURIComponent(getLabel("Common.DispType.label","Common"));
					query="select disp_type, short_desc from am_disposition_type_lang_vw where language_id=`"+locale+"` ";
					search_code="disp_type";
					break;*/
			/*case "DURATIONTYPE":
					dialogTitle=encodeURIComponent(getLabel("Common.DurationType.label","Common"));
					query="select DURN_TYPE, DURN_DESC from AM_DURATION_TYPE_LANG_VW where language_id=`"+locale+"` ";
					search_code="DURN_TYPE";
					search_desc= "DURN_DESC";
					break;*/
			/*case "REFERRAL":
					dialogTitle=encodeURIComponent(getLabel("Common.referral.label","Common"));
					query="select referral_code, long_desc from am_referral_lang_vw where language_id=`"+locale+"` and eff_status=`E`";
					search_code="referral_code";
					break;*/
			/*case "FLOOR_FM":
			case "FLOOR_TO":
					dialogTitle=encodeURIComponent(getLabel("Common.floor.label","Common"));
					if(document.forms[0].name == "")
						query="select floor_code, short_desc from am_bldng_floor_lang_vw where OPERATING_FACILITY_ID =`"+repFacilityRoom.p_facility.value+"` and language_id=`"+locale+"` ";
					else
						query="select floor_code, short_desc from am_bldng_floor_lang_vw where OPERATING_FACILITY_ID =`"+ document.forms[0].p_facility.value +"` and language_id=`"+locale+"` and EFF_STATUS = `E`";				
					search_code="floor_code";
					break;*/
			/*case "FREQSTATUS":
					dialogTitle=encodeURIComponent(getLabel("Common.FrequencyCode.label","Common"));
					query="select FREQ_CODE, FREQ_DESC from AM_FREQUENCY_lang_vw where language_id=`"+locale+"`";
					search_code="FREQ_CODE";
					search_desc= "FREQ_DESC";
					break;*/
			case "FREQUENCY SCHEDULE":
					dialogTitle=encodeURIComponent(getLabel("Common.FrequencyCode.label","Common"));
					query="select FREQ_CODE, FREQ_DESC from AM_FREQUENCY_lang_vw where language_id=`"+locale+"`";
					search_code="FREQ_CODE";
					search_desc= "FREQ_DESC";
					break;
			case "FREQSCHEDULEID":
					dialogTitle=encodeURIComponent(getLabel("eAM.AdminFacilityID.label","am"));
					query="select FACILITY_ID, FACILITY_NAME from SM_FACILITY_PARAM_lang_vw where language_id=`"+locale+"`";
					search_code="FACILITY_ID";
					search_desc= "FACILITY_NAME";
					break;
			/*case "HLTHCARE":
					dialogTitle=encodeURIComponent(getLabel("Common.HealthcareSettingType.label","Common"));
					query="select hcare_setting_type_code, short_desc from am_hcare_setting_type_lang_vw where language_id=`"+locale+"`";
					search_code="hcare_setting_type_code";
					break;*/
			/*case "OPERSTN_FM":
			case "OPERSTN_TO":
					dialogTitle=encodeURIComponent(getLabel("Common.operatorstation.label","Common"));
					query="select oper_stn_id, short_desc from am_oper_stn_lang_vw where facility_id=`"+document.forms[0].p_facility.value+"` and language_id=`"+locale+"`";
					search_code="oper_stn_id";
					break;*/
			/*case "SPECIALITY_FM":
			case "SPECIALITY_TO":
			case "SPECIALITY":
					dialogTitle=encodeURIComponent(getLabel("Common.speciality.label","Common"));
					query="select speciality_code, short_desc from am_speciality_lang_vw where language_id=`"+locale+"`";
					search_code="speciality_code";
					break;*/
			case "LOCN_FM":
			case "LOCN_TO":
					dialogTitle=encodeURIComponent(getLabel("Common.location.label","Common"));
					query="select clinic_code, long_desc from op_clinic where facility_id=`"+document.forms[0].p_facility.value+"` and language_id=`"+locale+"` ";
					search_code="clinic_code";
					break;
			/*case "MANSTATUS":
					dialogTitle=encodeURIComponent(getLabel("eAM.ManufacturerStatus.label","am"));
					query="select MANUFACTURER_ID, short_name from AM_MANUFACTURER_lang_vw where language_id=`"+locale+"`";
					search_code="MANUFACTURER_ID";
					search_desc= "short_name";
					break;*/
		/*	case "TEAM_FM":
			case "TEAM_TO":
					dialogTitle=encodeURIComponent(getLabel("Common.medicalteam.label","Common"));
					query="select team_id,short_desc from am_medical_team_lang_vw where FACILITY_ID =`"+document.forms[0].p_facility.value+"` and language_id=`"+locale+"` ";
					if(document.forms[0].name == "repMedTeamPract"){
						query += " and EFF_STATUS = `E`";
						
					}
					search_code="team_id";
					break;	*/	
			/*case "ARRIVAL":
					dialogTitle=encodeURIComponent(getLabel("Common.arrival.label","Common"));
					//alert( facilityid);
					query="select arrival_code, short_desc from am_arrival_lang_vw where facility_id=`"+document.forms[0].p_facility_id.value+"` and language_id=`"+locale+"` ";
					search_code="arrival_code";
					break;*/
			case "OPERSTN_FM":
			case "OPERSTN_TO":
					dialogTitle=encodeURIComponent(getLabel("Common.operatorstation.label","Common"));
					query="select oper_stn_id, short_desc from am_oper_stn_lang_vw where FACILITY_ID =`"+document.forms[0].p_facility.value+"` and language_id=`"+locale+"` ";
					search_code="oper_stn_id";
					break;
			case "PATTYPE":
					dialogTitle=encodeURIComponent(getLabel("Common.patienttype.label","Common"));
					query="select patient_type, short_desc from am_patient_type_lang_vw where language_id=`"+locale+"` ";
					search_code="patient_type";
					break;
			case "FM_PRACTITIONER":
					dialogTitle=encodeURIComponent(getLabel("Common.practitioner.label","Common"));
					var fm_pract_type = document.forms[0].p_fm_practitioner_type.value;
					query="select practitioner_id, practitioner_name from am_practitioner_lang_vw where pract_type = 	nvl(`"+fm_pract_type+"`,pract_type) and language_id=`"+locale+"` ";
					search_code="practitioner_id";
					search_desc= "practitioner_name";
					break;
			case "TO_PRACTITIONER":
					dialogTitle=encodeURIComponent(getLabel("Common.practitioner.label","Common"));
					var to_pract_type = document.forms[0].p_to_practitioner_type.value;
					query="select practitioner_id, practitioner_name from am_practitioner_lang_vw where pract_type = 	nvl(`"+ to_pract_type +"`,pract_type) and language_id=`"+locale+"` ";
					search_code="practitioner_id";
					search_desc= "practitioner_name";
					break;
			case "SPECIALITY":
					dialogTitle=encodeURIComponent(getLabel("Common.speciality.label","Common"));
					query="select speciality_code, short_desc from am_speciality_lang_vw where language_id=`"+locale+"` ";
					search_code="speciality_code";
					break;
			case "PRACTITIONERTYPE":
					dialogTitle=encodeURIComponent(getLabel("Common.practitionertype.label","Common"));
					query="select pract_type, desc_userdef from am_pract_type_lang_vw where language_id=`"+locale+"` ";
					search_code="pract_type";
					search_desc= "desc_userdef";
					break;
			/*case "PRACTTYPE":
					dialogTitle=encodeURIComponent(getLabel("Common.practitionertype.label","Common"));
					query="select pract_type, desc_sysdef from am_pract_type_lang_vw where language_id=`"+locale+"` ";
					search_code="pract_type";
					search_desc= "desc_sysdef";
					break;*/
			/*case "PRACTITIONER_FM":
					dialogTitle=encodeURIComponent(getLabel("Common.practitioner.label","Common"));
					var fm_pract_type = document.forms[0].fm_pract_type.value;
					query="select practitioner_id,  AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,`"+locale+"`,1) practitioner_name from am_pract_for_facility WHERE FACILITY_ID =`"+document.forms[0].p_facility.value+"` and pract_type = 	nvl(`"+fm_pract_type+"`,pract_type)";
					//alert("Practfm" +query);
					search_code="practitioner_id";
					search_desc= "2";
					break;
			case "PRACTITIONER_TO":
					dialogTitle=encodeURIComponent(getLabel("Common.practitioner.label","Common"));
					var to_pract_type = document.forms[0].to_pract_type.value;
					query="select practitioner_id, AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,`"+locale+"`,1) practitioner_name from am_pract_for_facility WHERE FACILITY_ID =`"+document.forms[0].p_facility.value+"` and pract_type = nvl(`"+to_pract_type+"`,pract_type)";
					//alert("Practto");
					search_code="practitioner_id";
					search_desc= "2";
					break;*/
			/*case "TO_SPECIALITY":
			case "FM_SPECIALITY":
					dialogTitle=encodeURIComponent(getLabel("Common.speciality.label","Common"));
					query="select speciality_code, short_desc from am_speciality_lang_vw where language_id=`"+locale+"` ";
					search_code="speciality_code";
					break;*/
			/*case "CONTACTREASON":
					dialogTitle=encodeURIComponent(getLabel("Common.ContactReason.label","Common"));
					query="select contact_reason_code, contact_reason from am_contact_reason_lang_vw where language_id=`"+locale+"` ";
					search_code="contact_reason_code";
					search_desc= "contact_reason";
					break;*/
			case "OPERSTN_FM":
			case "OPERSTN_TO":
					dialogTitle=encodeURIComponent(getLabel("Common.operatorstation.label","Common"));
					query="select oper_stn_id, short_desc from am_oper_stn_lang_vw where FACILITY_ID =`"+ document.forms[0].p_facility.value +"` and language_id=`"+locale+"` ";
					search_code="oper_stn_id";
					break;
			/*case "USER_FM":
			case "USER_TO":
					if(document.forms[0].name=="repUserOperStn")
						dialogTitle=encodeURIComponent(getLabel("Common.applusername.label","Common"));
					else
						dialogTitle=encodeURIComponent(getLabel("Common.user.label","Common"));
					query="select APPL_USER_ID, SM_GET_DESC.SM_APPL_USER(APPL_USER_ID,`"+locale+"`,1) APPL_USER_NAME from SM_FACILITY_FOR_USER where FACILITY_ID =`"+document.forms[0].p_facility.value+"` ";
					search_code="APPL_USER_ID";
					search_desc= "2";
					break;*/
			/*case "TYPE_FM":
			case "TYPE_TO":
					dialogTitle=encodeURIComponent(getLabel("Common.type.label","Common"));
					query="select locn_type,short_desc from am_care_locn_type_lang_vw where (care_locn_type_ind in (`R`,`N`)) and language_id=`"+locale+"` ";
					search_code="locn_type";
					break;*/
			/*case "SECTION":
					dialogTitle=encodeURIComponent(getLabel("Common.Section.label","Common"));
					query="select section_code, short_desc from am_dept_section_lang_vw where language_id=`"+locale+"` ";
					search_code="section_code";
					break;*/
			/*case "SECTION_FM":
			case "SECTION_TO":
					if(document.forms[0].name =="repSpecialityForPract"){
						dialogTitle=encodeURIComponent(getLabel("Common.speciality.label","Common"));
						query="select distinct speciality_code,am_get_desc.AM_SPECIALITY(SPECIALITY_CODE,`"+locale+"`,2) speciality_short_desc from AM_PRACT_FOR_SPECIALITY_vw where FACILITY_ID =`"+repSpecialityForPract.p_facility.value+"` ";
						search_code="speciality_code";
						search_desc= "2";
					}else{
						dialogTitle=encodeURIComponent(getLabel("Common.Section.label","Common"));
						query="select distinct section_code, section_short_desc from AM_FACILITY_SECTION_VW where OPERATING_FACILITY_ID =`"+document.forms[0].p_facility.value+"` and EFF_STATUS = `E`";
						search_code="section_code";
						search_desc= "section_short_desc";
					}
					break;*/
			/*case "SERVICE":
					dialogTitle=encodeURIComponent(getLabel("Common.service.label","Common"));
					query="select service_code, short_desc from am_service_lang_vw where language_id=`"+locale+"` ";
					search_code="service_code";
					break;*/
			case "STATGRP":
					dialogTitle=encodeURIComponent(getLabel("Common.StatisticsGroup.label","Common"));
					query="select stat_grp_id,stat_grp_desc from am_stat_group";
					search_code="stat_grp_id";
					search_desc= "stat_grp_desc";
					break;
			/*case "MODULE":
					dialogTitle=encodeURIComponent(getLabel("Common.Module.label","Common"));
					query="select module_id,module_name from sm_module_lang_vw where language_id=`"+locale+"` ";
					search_code="module_id";
					search_desc= "module_name";
					break;*/
			/*case "STATISTICS":
					dialogTitle=encodeURIComponent(getLabel("Common.StatisticsGroup.label","Common"));
					query="select stat_grp_id,stat_grp_desc from am_stat_group";
					search_code="stat_grp_id";
					search_desc= "stat_grp_desc";
					break;*/
			/*case "PROGRAM_BUT1":
					dialogTitle=encodeURIComponent(getLabel("eAM.Program.label","am"));
					if(program_type == "F"){
						query = "Select function_id, function_name from sm_function_lang_vw where module_id = nvl(`"+fm_module_id+"`,module_id) and language_id=`"+locale+"` ";
						search_code="function_id";
						search_desc= "function_name";
					}else if(program_type == "R"){
						query = "Select report_id, report_desc from sm_report_lang_vw where module_id = nvl(`"+fm_module_id+"`,module_id) and language_id=`"+locale+"` ";
						search_code="report_id";
						search_desc= "report_desc";
					}
					break;
			case "PROGRAM_BUT2":
					dialogTitle=encodeURIComponent(getLabel("eAM.Program.label","am"));
					if(program_type == "F"){
						query = "Select function_id, function_name from sm_function_lang_vw where module_id = nvl(`"+to_module_id+"`,module_id) and language_id=`"+locale+"` ";
						search_code="function_id";
						search_desc= "function_name";
					}else if(program_type == "R"){	
						query = "Select report_id, report_desc from sm_report_lang_vw where module_id = nvl(`"+to_module_id+"`,module_id) and language_id=`"+locale+"` ";
						search_code="report_id";
						search_desc= "report_desc";
					}
					break;*/
			/*case "SUBSERVICE_FM":
			case "SUBSERVICE_TO":
					dialogTitle=encodeURIComponent(getLabel("Common.subservice.label","Common"));	// am_subservice
					query="select distinct subservice_code ,am_get_desc.AM_SUBSERVICE(SERVICE_CODE,subservice_code,`"+locale+"`,2) subservice_short_desc from AM_FACILITY_SUBSRVC where OPERATING_FACILITY_ID =`"+document.forms[0].p_facility.value+"` and EFF_STATUS = `E`";
					search_code="subservice_code";
					search_desc= "2";
					break;*/
			/*case "SUBSERVICE":
					dialogTitle=encodeURIComponent(getLabel("Common.subservice.label","Common"));
					query="select subservice_code, short_desc from am_subservice_lang_vw where language_id=`"+locale+"`";
					search_code="subservice_code";
					break;*/
			/*case "AGERANGE":
					dialogTitle=encodeURIComponent(getLabel("Common.AgeRange.label","Common"));
					query="select range_id, short_desc from am_summ_range_lang_vw  where language_id=`"+locale+"` ";
					search_code="range_id";
					break;*/
			/*case "TRADENAME":
					dialogTitle=encodeURIComponent(getLabel("Common.TradeName.label","Common"));
					query="select TRADE_ID, SHORT_NAME from AM_TRADE_NAME_LANG_VW where language_id=`"+locale+"` ";
					search_code="TRADE_ID";
					search_desc= "SHORT_NAME";
					break;*/
			/*case "UOM":
					dialogTitle=encodeURIComponent(getLabel("eAM.UnitofMeasure.label","am"));
					query="select UOM_CODE, short_desc from am_uom_lang_vw where language_id=`"+locale+"` ";
					search_code="UOM_CODE";
					break;*/
			case "CARELOCN":
					tit=encodeURIComponent(getLabel("Common.locationtype.label","Common"));
					sql="select locn_type, short_desc from am_care_locn_type_lang_vw where language_id=`"+locale+"` ";
					search_code="locn_type";
					search_desc= "short_desc";
					break;

			case "COI":
				tit=encodeURIComponent(getLabel("Common.CircumstanceofInjury.label","Common"));
				sql="select circumstance_of_injury_code, short_desc from AM_CIRCUM_OF_INJURY_LANG_VW where language_id=`"+locale+"`";
				search_code="circumstance_of_injury_code";
				search_desc= "short_desc";
				break;

			case "COMPLAINT":
				tit=encodeURIComponent(getLabel("Common.Complaint.label","Common"));
				sql="select complaint_code, complaint_desc from am_complaint_lang_vw where language_id=`"+locale+"` ";
				search_code="complaint_code";
				search_desc= "complaint_desc";
				break;
			
	}
	var features = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	retVal = await window.showModalDialog("../../eCommon/jsp/GeneralSearch.jsp?"+firstParamName+"="+query+"&search_code="+search_code+"&search_desc="+search_desc+"&title="+dialogTitle,arguments,features);

	if (retVal != null)
		target.value=retVal;
	else
		target.focus();
}


function checkVal(Objval)
{	
	if(Objval == "All")
	{
		switch(document.forms[0].name){
			case "repFacilityRoom":
				repFacilityRoom.p_fm_bldng_code.value = "";
				repFacilityRoom.p_to_bldng_code.value = "";
				repFacilityRoom.p_fm_bldng_code.disabled = true;
				repFacilityRoom.p_to_bldng_code.disabled = true;
				repFacilityRoom.building_fm.disabled = true;
				repFacilityRoom.building_to.disabled = true;

				repFacilityRoom.p_fm_type.value = "";
				repFacilityRoom.p_to_type.value = "";
				repFacilityRoom.p_fm_type.disabled = true;
				repFacilityRoom.p_to_type.disabled = true;
				repFacilityRoom.type_fm.disabled = true;
				repFacilityRoom.type_to.disabled = true;


				repFacilityRoom.p_fm_floor_code.value = "";
				repFacilityRoom.p_to_floor_code.value = "";
				repFacilityRoom.p_fm_floor_code.disabled = true;
				repFacilityRoom.p_to_floor_code.disabled = true;
				repFacilityRoom.floor_fm.disabled = true;
				repFacilityRoom.floor_to.disabled = true;

				repFacilityRoom.p_fm_room_num.value = "";
				repFacilityRoom.p_to_room_num.value = "";
				repFacilityRoom.p_fm_room_num.disabled = true;
				repFacilityRoom.p_to_room_num.disabled = true;
				repFacilityRoom.room_fm.disabled = true;
				repFacilityRoom.room_to.disabled = true;
				break;

			case "repFacilitySectionList":
				repFacilitySectionList.p_fm_dept_code.value = "";
				repFacilitySectionList.p_to_dept_code.value = "";
				repFacilitySectionList.p_fm_dept_code.disabled = true;
				repFacilitySectionList.p_to_dept_code.disabled = true;
				repFacilitySectionList.department_fm.disabled = true;
				repFacilitySectionList.department_to.disabled = true;

				repFacilitySectionList.p_fm_section_code.value = "";
				repFacilitySectionList.p_to_section_code.value = "";
				repFacilitySectionList.p_fm_section_code.disabled = true;
				repFacilitySectionList.p_to_section_code.disabled = true;
				repFacilitySectionList.section_fm.disabled = true;
				repFacilitySectionList.section_to.disabled = true;
				break;
				
			case "repBldnginfacility":
				repBldnginfacility.p_fm_bldng_code.value = "";
				repBldnginfacility.p_to_bldng_code.value = "";
				repBldnginfacility.p_fm_bldng_code.disabled = true;
				repBldnginfacility.p_to_bldng_code.disabled = true;
				repBldnginfacility.building_fm.disabled = true;
				repBldnginfacility.building_to.disabled = true;
				break;

			case "repFacilityService":
				repFacilityService.p_fm_dept_code.value = "";
				repFacilityService.p_to_dept_code.value = "";
				repFacilityService.p_fm_dept_code.disabled = true;
				repFacilityService.p_to_dept_code.disabled = true;
				repFacilityService.department_fm.disabled = true;
				repFacilityService.department_to.disabled = true;

				repFacilityService.p_fm_service_code.value = "";
				repFacilityService.p_to_service_code.value = "";
				repFacilityService.p_fm_service_code.disabled = true;
				repFacilityService.p_to_service_code.disabled = true;
				repFacilityService.service_fm.disabled = true;
				repFacilityService.service_to.disabled = true;
				break;

			case "repSpecialityForPract":
				repSpecialityForPract.p_fm_practitioner_id.value = "";
				repSpecialityForPract.p_to_practitioner_id.value = "";
				repSpecialityForPract.p_fm_practitioner_id.disabled = true;
				repSpecialityForPract.p_to_practitioner_id.disabled = true;
				repSpecialityForPract.practitioner_fm.disabled = true;
				repSpecialityForPract.practitioner_to.disabled = true;
				repSpecialityForPract.fm_pract_type.disabled = true;
				repSpecialityForPract.to_pract_type.disabled = true;

				repSpecialityForPract.p_fm_section_code.value = "";
				repSpecialityForPract.p_to_section_code.value = "";
				repSpecialityForPract.p_fm_section_code.disabled = true;
				repSpecialityForPract.p_to_section_code.disabled = true;
				repSpecialityForPract.section_fm.disabled = true;
				repSpecialityForPract.section_to.disabled = true;
				break;
			case "repFacilitySubService":
				repFacilitySubService.p_fm_dept_code.value = "";
				repFacilitySubService.p_to_dept_code.value = "";
				repFacilitySubService.p_fm_dept_code.disabled = true;
				repFacilitySubService.p_to_dept_code.disabled = true;
				repFacilitySubService.department_fm.disabled = true;
				repFacilitySubService.department_to.disabled = true;

				repFacilitySubService.p_fm_section_code.value = "";
				repFacilitySubService.p_to_section_code.value = "";
				repFacilitySubService.p_fm_section_code.disabled = true;
				repFacilitySubService.p_to_section_code.disabled = true;
				repFacilitySubService.section_fm.disabled = true;
				repFacilitySubService.section_to.disabled = true;

				repFacilitySubService.p_fm_service_code.value = "";
				repFacilitySubService.p_to_service_code.value = "";
				repFacilitySubService.p_fm_service_code.disabled = true;
				repFacilitySubService.p_to_service_code.disabled = true;
				repFacilitySubService.service_fm.disabled = true;
				repFacilitySubService.service_to.disabled = true;

				repFacilitySubService.p_fm_subservice_code.value = "";
				repFacilitySubService.p_to_subservice_code.value = "";
				repFacilitySubService.p_fm_subservice_code.disabled = true;
				repFacilitySubService.p_to_subservice_code.disabled = true;
				repFacilitySubService.subservice_fm.disabled = true;
				repFacilitySubService.subservice_to.disabled = true;
				break;
			case "repUserOperStn":
				repUserOperStn.p_fm_oper_stn_id.value = "";
				repUserOperStn.p_to_oper_stn_id.value = "";
				repUserOperStn.p_fm_oper_stn_id.disabled = true;
				repUserOperStn.p_to_oper_stn_id.disabled = true;
				repUserOperStn.operstn_fm.disabled = true;
				repUserOperStn.operstn_to.disabled = true;

				repUserOperStn.p_fm_appl_user_id.value = "";
				repUserOperStn.p_to_appl_user_id.value = "";
				repUserOperStn.p_fm_appl_user_id.disabled = true;
				repUserOperStn.p_to_appl_user_id.disabled = true;
				repUserOperStn.user_fm.disabled = true;
				repUserOperStn.user_to.disabled = true;
				break;
				
			case "repOperStnRestrnList":
				repOperStnRestrnList.p_fm_oper_stn_id.value = "";
				repOperStnRestrnList.p_to_oper_stn_id.value = "";
				repOperStnRestrnList.p_fm_oper_stn_id.disabled = true;
				repOperStnRestrnList.p_to_oper_stn_id.disabled = true;
				repOperStnRestrnList.operstn_fm.disabled = true;
				repOperStnRestrnList.operstn_to.disabled = true;

				repOperStnRestrnList.p_fm_user_id.value = "";
				repOperStnRestrnList.p_to_user_id.value = "";
				repOperStnRestrnList.p_fm_user_id.disabled = true;
				repOperStnRestrnList.p_to_user_id.disabled = true;
				repOperStnRestrnList.user_fm.disabled = true;
				repOperStnRestrnList.user_to.disabled = true;
				break;

			case "repMedTeamPract":
				repMedTeamPract.p_fm_team_id.value = "";
				repMedTeamPract.p_to_team_id.value = "";
				repMedTeamPract.p_fm_team_id.disabled = true;
				repMedTeamPract.p_to_team_id.disabled = true;
				repMedTeamPract.team_fm.disabled = true;
				repMedTeamPract.team_to.disabled = true;
				repMedTeamPract.fm_pract_type.disabled = true;
				repMedTeamPract.to_pract_type.disabled = true;

				repMedTeamPract.p_fm_practitioner_id.value = "";
				repMedTeamPract.p_to_practitioner_id.value = "";
				repMedTeamPract.p_fm_practitioner_id.disabled = true;
				repMedTeamPract.p_to_practitioner_id.disabled = true;
				repMedTeamPract.practitioner_fm.disabled = true;
				repMedTeamPract.practitioner_to.disabled = true;
				break;

			case "repPractForFacility":
				repPractForFacility.p_fm_practitioner_id.value = "";
				repPractForFacility.p_to_practitioner_id.value = "";
				repPractForFacility.p_fm_practitioner_id.disabled = true;
				repPractForFacility.p_to_practitioner_id.disabled = true;
				repPractForFacility.practitioner_fm.disabled = true;
				repPractForFacility.practitioner_to.disabled = true;
				repPractForFacility.fm_pract_type.disabled= true;
				repPractForFacility.to_pract_type.disabled= true;
				break;

			case "repOperStnList":
				repOperStnList.p_fm_oper_stn_id.value = "";
				repOperStnList.p_to_oper_stn_id.value = "";
				repOperStnList.p_fm_oper_stn_id.disabled = true;
				repOperStnList.p_to_oper_stn_id.disabled = true;
				repOperStnList.operstn_fm.disabled = true;
				repOperStnList.operstn_to.disabled = true;
				break;
			
			case "repLocnForOperStn":
				repLocnForOperStn.p_fm_oper_stn_id.value = "";
				repLocnForOperStn.p_to_oper_stn_id.value = "";
				repLocnForOperStn.p_fm_oper_stn_id.disabled = true;
				repLocnForOperStn.p_to_oper_stn_id.disabled = true;
				repLocnForOperStn.operstn_fm.disabled = true;
				repLocnForOperStn.operstn_to.disabled = true;
				repLocnForOperStn.p_fm_locn_code.value = "";
				repLocnForOperStn.p_to_locn_code.value = "";
				repLocnForOperStn.p_fm_locn_code.disabled = true;
				repLocnForOperStn.p_to_locn_code.disabled = true;
				repLocnForOperStn.locn_fm.disabled = true;
				repLocnForOperStn.locn_to.disabled = true;
				break;
				
			case "repMedTeam":
				repMedTeam.p_fm_team_id.value = "";
				repMedTeam.p_to_team_id.value = "";
				repMedTeam.p_fm_team_id.disabled = true;
				repMedTeam.p_to_team_id.disabled = true;
				repMedTeam.team_fm.disabled = true;
				repMedTeam.team_to.disabled = true;
				break;
			case "repFloorinFacility":
				repFloorinFacility.p_fm_bldng_code.value = "";
				repFloorinFacility.p_to_bldng_code.value = "";
				repFloorinFacility.p_fm_bldng_code.disabled = true;
				repFloorinFacility.p_to_bldng_code.disabled = true;
				repFloorinFacility.building_fm.disabled = true;
				repFloorinFacility.building_to.disabled = true;

				repFloorinFacility.p_fm_floor_code.value = "";
				repFloorinFacility.p_to_floor_code.value = "";
				repFloorinFacility.p_fm_floor_code.disabled = true;
				repFloorinFacility.p_to_floor_code.disabled = true;
				repFloorinFacility.floor_fm.disabled = true;
				repFloorinFacility.floor_to.disabled = true;
				break;
			case "repFacilityDeptList":
				repFacilityDeptList.p_fm_dept_code.value = "";
				repFacilityDeptList.p_to_dept_code.value = "";
				repFacilityDeptList.p_fm_dept_code.disabled = true;
				repFacilityDeptList.p_to_dept_code.disabled = true;
				repFacilityDeptList.department_fm.disabled = true;
				repFacilityDeptList.department_to.disabled = true;
				break;
			case "repDeptRoomList":
				repDeptRoomList.p_fm_dept_code.value = "";
				repDeptRoomList.p_to_dept_code.value = "";
				repDeptRoomList.p_fm_dept_code.disabled = true;
				repDeptRoomList.p_to_dept_code.disabled = true;
				repDeptRoomList.department_fm.disabled = true;
				repDeptRoomList.department_to.disabled = true;

				repDeptRoomList.p_fm_service_code.value = "";
				repDeptRoomList.p_to_service_code.value = "";
				repDeptRoomList.p_fm_service_code.disabled = true;
				repDeptRoomList.p_to_service_code.disabled = true;
				repDeptRoomList.service_fm.disabled = true;
				repDeptRoomList.service_to.disabled = true;

				repDeptRoomList.p_fm_room_num.value = "";
				repDeptRoomList.p_to_room_num.value = "";
				repDeptRoomList.p_fm_room_num.disabled = true;
				repDeptRoomList.p_to_room_num.disabled = true;
				repDeptRoomList.room_fm.disabled = true;
				repDeptRoomList.room_to.disabled = true;
				break;

		}
	}
	else
	{
		switch(document.forms[0].name){
			case "repFacilityRoom":
				repFacilityRoom.p_fm_bldng_code.disabled = false;
				repFacilityRoom.p_to_bldng_code.disabled = false;
				repFacilityRoom.building_fm.disabled = false;
				repFacilityRoom.building_to.disabled = false;

				repFacilityRoom.p_fm_floor_code.disabled = false;
				repFacilityRoom.p_to_floor_code.disabled = false;
				repFacilityRoom.floor_fm.disabled = false;
				repFacilityRoom.floor_to.disabled = false;

				repFacilityRoom.p_fm_room_num.disabled = false;
				repFacilityRoom.p_to_room_num.disabled = false;
				repFacilityRoom.room_fm.disabled = false;
				repFacilityRoom.room_to.disabled = false;

				repFacilityRoom.p_fm_type.disabled = false;
				repFacilityRoom.p_to_type.disabled = false;
				repFacilityRoom.type_fm.disabled = false;
				repFacilityRoom.type_to.disabled = false;
				break;
			case "repFacilitySectionList":
				repFacilitySectionList.p_fm_dept_code.disabled = false;
				repFacilitySectionList.p_to_dept_code.disabled = false;
				repFacilitySectionList.department_fm.disabled = false;
				repFacilitySectionList.department_to.disabled = false;

				repFacilitySectionList.p_fm_section_code.disabled = false;
				repFacilitySectionList.p_to_section_code.disabled = false;
				repFacilitySectionList.section_fm.disabled = false;
				repFacilitySectionList.section_to.disabled = false;
				break;

			case "repBldnginfacility":
				repBldnginfacility.p_fm_bldng_code.disabled = false;
				repBldnginfacility.p_to_bldng_code.disabled = false;
				repBldnginfacility.building_fm.disabled = false;
				repBldnginfacility.building_to.disabled = false;
				break;

			case "repFacilityService":
				repFacilityService.p_fm_dept_code.disabled = false;
				repFacilityService.p_to_dept_code.disabled = false;
				repFacilityService.department_fm.disabled = false;
				repFacilityService.department_to.disabled = false;

				repFacilityService.p_fm_service_code.disabled = false;
				repFacilityService.p_to_service_code.disabled = false;
				repFacilityService.service_fm.disabled = false;
				repFacilityService.service_to.disabled = false;
				break;
			case "repSpecialityForPract":
				repSpecialityForPract.p_fm_practitioner_id.disabled = false;
				repSpecialityForPract.p_to_practitioner_id.disabled = false;
				repSpecialityForPract.practitioner_fm.disabled = false;
				repSpecialityForPract.practitioner_to.disabled = false;
				repSpecialityForPract.fm_pract_type.disabled = false;
				repSpecialityForPract.to_pract_type.disabled = false;

				repSpecialityForPract.p_fm_section_code.disabled = false;
				repSpecialityForPract.p_to_section_code.disabled = false;
				repSpecialityForPract.section_fm.disabled = false;
				repSpecialityForPract.section_to.disabled = false;
				break;
			case "repFacilitySubService":
				repFacilitySubService.p_fm_dept_code.disabled = false;
				repFacilitySubService.p_to_dept_code.disabled = false;
				repFacilitySubService.department_fm.disabled = false;
				repFacilitySubService.department_to.disabled = false;

				repFacilitySubService.p_fm_section_code.disabled = false;
				repFacilitySubService.p_to_section_code.disabled = false;
				repFacilitySubService.section_fm.disabled = false;
				repFacilitySubService.section_to.disabled = false;

				repFacilitySubService.p_fm_service_code.disabled = false;
				repFacilitySubService.p_to_service_code.disabled = false;
				repFacilitySubService.service_fm.disabled = false;
				repFacilitySubService.service_to.disabled = false;

				repFacilitySubService.p_fm_subservice_code.disabled = false;
				repFacilitySubService.p_to_subservice_code.disabled = false;
				repFacilitySubService.subservice_fm.disabled = false;
				repFacilitySubService.subservice_to.disabled = false;
				break;
			case "repUserOperStn":
				repUserOperStn.p_fm_oper_stn_id.disabled = false;
				repUserOperStn.p_to_oper_stn_id.disabled = false;
				repUserOperStn.operstn_fm.disabled = false;
				repUserOperStn.operstn_to.disabled = false;

				repUserOperStn.p_fm_appl_user_id.disabled = false;
				repUserOperStn.p_to_appl_user_id.disabled = false;
				repUserOperStn.user_fm.disabled = false;
				repUserOperStn.user_to.disabled = false;
				break;

			case "repOperStnRestrnList":
				repOperStnRestrnList.p_fm_oper_stn_id.disabled = false;
				repOperStnRestrnList.p_to_oper_stn_id.disabled = false;
				repOperStnRestrnList.operstn_fm.disabled = false;
				repOperStnRestrnList.operstn_to.disabled = false;

				repOperStnRestrnList.p_fm_user_id.disabled = false;
				repOperStnRestrnList.p_to_user_id.disabled = false;
				repOperStnRestrnList.user_fm.disabled = false;
				repOperStnRestrnList.user_to.disabled = false;
				break;
			case "repMedTeamPract":
				repMedTeamPract.p_fm_team_id.disabled = false;
				repMedTeamPract.p_to_team_id.disabled = false;
				repMedTeamPract.team_fm.disabled = false;
				repMedTeamPract.team_to.disabled = false;
				repMedTeamPract.fm_pract_type.disabled = false;
				repMedTeamPract.to_pract_type.disabled = false;

				repMedTeamPract.p_fm_practitioner_id.disabled = false;
				repMedTeamPract.p_to_practitioner_id.disabled = false;
				repMedTeamPract.practitioner_fm.disabled = false;
				repMedTeamPract.practitioner_to.disabled = false;
				break;
			case "repPractForFacility":
				repPractForFacility.p_fm_practitioner_id.disabled = false;
				repPractForFacility.p_to_practitioner_id.disabled = false;
				repPractForFacility.practitioner_fm.disabled = false;
				repPractForFacility.practitioner_to.disabled = false;
				repPractForFacility.fm_pract_type.disabled= false;
				repPractForFacility.to_pract_type.disabled= false;
				break;
			
			case "repOperStnList":
				repOperStnList.p_fm_oper_stn_id.disabled = false;
				repOperStnList.p_to_oper_stn_id.disabled = false;
				repOperStnList.operstn_fm.disabled = false;
				repOperStnList.operstn_to.disabled = false;
				break;
			case "repLocnForOperStn":
				repLocnForOperStn.p_fm_oper_stn_id.disabled = false;
				repLocnForOperStn.p_to_oper_stn_id.disabled = false;
				repLocnForOperStn.operstn_fm.disabled = false;
				repLocnForOperStn.operstn_to.disabled = false;

				repLocnForOperStn.p_fm_locn_code.disabled = false;
				repLocnForOperStn.p_to_locn_code.disabled = false;
				repLocnForOperStn.locn_fm.disabled = false;
				repLocnForOperStn.locn_to.disabled = false;
				break;
			case "repMedTeam":
				repMedTeam.p_fm_team_id.disabled = false;
				repMedTeam.p_to_team_id.disabled = false;
				repMedTeam.team_fm.disabled = false;
				repMedTeam.team_to.disabled = false;
				break;
			case "repFloorinFacility":
				repFloorinFacility.p_fm_bldng_code.disabled = false;
				repFloorinFacility.p_to_bldng_code.disabled = false;
				repFloorinFacility.building_fm.disabled = false;
				repFloorinFacility.building_to.disabled = false;

				repFloorinFacility.p_fm_floor_code.disabled = false;
				repFloorinFacility.p_to_floor_code.disabled = false;
				repFloorinFacility.floor_fm.disabled = false;
				repFloorinFacility.floor_to.disabled = false;
				break;
			case "repFacilityDeptList":
				repFacilityDeptList.p_fm_dept_code.disabled = false;
				repFacilityDeptList.p_to_dept_code.disabled = false;
				repFacilityDeptList.department_fm.disabled = false;
				repFacilityDeptList.department_to.disabled = false;
				break;
			case "repDeptRoomList":
				repDeptRoomList.p_fm_dept_code.disabled = false;
				repDeptRoomList.p_to_dept_code.disabled = false;
				repDeptRoomList.department_fm.disabled = false;
				repDeptRoomList.department_to.disabled = false;

				repDeptRoomList.p_fm_service_code.disabled = false;
				repDeptRoomList.p_to_service_code.disabled = false;
				repDeptRoomList.service_fm.disabled = false;
				repDeptRoomList.service_to.disabled = false;

				repDeptRoomList.p_fm_room_num.disabled = false;
				repDeptRoomList.p_to_room_num.disabled = false;
				repDeptRoomList.room_fm.disabled = false;
				repDeptRoomList.room_to.disabled = false;
				break;
		}
	}
}



function setValues(ObjVal)
{
	if(ObjVal == "F" || ObjVal == "R")
	{
		switch(document.forms[0].name){
			case  "reppgmstatgrp":
				reppgmstatgrp.p_fm_program_id.disabled = false;
				reppgmstatgrp.p_to_program_id.disabled = false;
				reppgmstatgrp.Program_but1.disabled = false;
				reppgmstatgrp.Program_but2.disabled = false;
				break;
		}
	}
	else
	{
		switch(document.forms[0].name){
			case  "reppgmstatgrp":
				reppgmstatgrp.p_fm_program_id.value = "";
				reppgmstatgrp.p_to_program_id.value = "";
				reppgmstatgrp.p_fm_program_id.disabled = true;
				reppgmstatgrp.p_to_program_id.disabled = true;
				reppgmstatgrp.Program_but1.disabled = true;
				reppgmstatgrp.Program_but2.disabled = true;
				break;
		}
	}
}



async function open_lookup(obj,target_code,target_desc)
{
//	alert("into");
		
		var argumentArray  = new Array() ;
		var dataNameArray  = new Array() ;
		var dataValueArray = new Array() ;
		var dataTypeArray  = new Array() ;
		var target="";
		var dialogTitle		= "";
		var sql="";
		

	//	alert("target_desc" +target_desc);
	//		alert("target_code" +target_code);

		var locale=document.forms[0].locale.value;
	if(document.forms[0].name =="reppgmstatgrp"){
		var fm_module_id = reppgmstatgrp.p_fm_mod.value;
		var to_module_id = reppgmstatgrp.p_to_mod.value;
		var program_type = reppgmstatgrp.p_prog_type.value;
	}

	switch(obj.name.toUpperCase()){
			case "DEPARTMENT":
			case "P_FM_DEPT_CODE":
			case "P_TO_DEPT_CODE":
			
					dialogTitle=getLabel("Common.acctdept.label","Common");
					sql="select dept_code code, short_desc description from am_dept where upper(dept_code) like upper(?) and upper(short_desc) like upper(?) ";
				
					break;

			case "DEPARTMENT_FM":
			case "DEPARTMENT_TO":
			case "P_FM_DEPT_CODE_FM":
			case "P_TO_DEPT_CODE_TO":
			
					dialogTitle=getLabel("Common.acctdept.label","Common");
					sql="select dept_code code, dept_short_desc description from AM_FACILITY_DEPT_VW where OPERATING_FACILITY_ID ='"+document.forms[0].p_facility.value+"' and EFF_STATUS = 'E' and upper(dept_code) like upper(?) and upper(dept_short_desc) like upper(?)";

					
					break;

			case "SERVICE_FM":
			case "SERVICE_TO":
			case "P_FM_SERVICE_CODE_FM":
			case "P_TO_SERVICE_CODE_TO":
					dialogTitle=getLabel("Common.service.label","Common");
					sql="select service_code code, service_short_desc description from AM_FACILITY_SERVICE_VW where OPERATING_FACILITY_ID ='"+document.forms[0].p_facility.value+"' and EFF_STATUS = 'E' and upper(service_code) like upper(?) and upper(service_short_desc) like upper(?) ";
					
			
					break;

			case "ROOM_FM":
			case "ROOM_TO":
			case "P_FM_ROOM_NUM":
			case "P_TO_ROOM_NUM":
					dialogTitle=getLabel("Common.room.label","Common");
					if(document.forms[0].name == "repFacilityRoom")
						
					sql="select room_num code, short_desc description from am_facility_room where OPERATING_FACILITY_ID ='"+repFacilityRoom.p_facility.value+"' and upper(room_num) like upper(?) and upper(short_desc) like upper(?) order by 2 ";
					else
					sql="select room_num code, short_desc description from am_facility_room where OPERATING_FACILITY_ID ='"+document.forms[0].p_facility.value+"' and EFF_STATUS = 'E' and upper(room_num) like upper(?) and upper(short_desc) like upper(?) order by 2";	
					
					
		
					break;

			case "AGEGROUP":
			case "P_FM_AGE_GROUP_CODE":
			case "P_TO_AGE_GROUP_CODE":
					dialogTitle=getLabel("Common.agegroup.label","Common");
					sql = "select age_group_code code, short_desc description from am_age_group where upper(age_group_code) like upper(?) and upper(short_desc) like upper(?) order by 2";

				
					break;

			case "AMBSTATUS":
			case "P_FM_AMBULATORY_STATUS":
			case "P_TO_AMBULATORY_STATUS":
					dialogTitle=getLabel("Common.ambulatorystatus.label","Common"); 
					sql="select ambulatory_status code, short_desc description from am_ambulatory_status where  upper(ambulatory_status) like upper(?) and upper(short_desc) like upper(?) order by 2 ";
					
			
					break;

			case "BUILDING_FM":
			case "BUILDING_TO":
			case "P_FM_BLDNG_CODE":
			case "P_TO_BLDNG_CODE":
					dialogTitle=getLabel("Common.building.label","Common"); 
					if(document.forms[0].name == "repFacilityRoom")
						sql="select bldng_code code, short_desc description from am_bldng where OPERATING_FACILITY_ID ='"+repFacilityRoom.p_facility.value+"' and upper(bldng_code) like upper(?) and upper(short_desc) like upper(?) order by 2";
					else
						sql="select bldng_code code, short_desc description from am_bldng where OPERATING_FACILITY_ID ='"+ document.forms[0].p_facility.value +"' and EFF_STATUS = 'E' and upper(bldng_code) like upper(?) and upper(short_desc) like upper(?) order by 2";

			
					break;

			case "CARELOCN":
			case "P_FM_LOCN_TYPE":
			case "P_TO_LOCN_TYPE":
					dialogTitle=getLabel("Common.locationtype.label","Common"); 
					sql="select locn_type code, short_desc description from am_care_locn_type where  upper(locn_type) like upper(?) and upper(short_desc) like upper(?) order by 2 ";

					
					break;

			case "COI":
			case "P_FM_COI_CODE":
			case "P_TO_COI_CODE":
					dialogTitle=getLabel("Common.CircumstanceofInjury.label","Common");
					sql="select circumstance_of_injury_code code, short_desc description from am_circumstance_of_injury where upper(circumstance_of_injury_code) like upper(?) and upper(short_desc) like upper(?) order by 2";
					
					break;

			case "COMPLAINT":
			case "P_FM_COMPLAINT_CODE":
			case "P_TO_COMPLAINT_CODE":
					dialogTitle=getLabel("Common.Complaint.label","Common"); 
					sql="select complaint_code code, complaint_desc description from am_complaint where upper(complaint_code) like upper(?) and upper(complaint_desc) like upper(?) order by 2";
					
				
					break;

			 case "DISPOSITION":
			 case "P_FM_DISP_TYPE":
			 case "P_TO_DISP_TYPE":
					dialogTitle=getLabel("Common.DispType.label","Common");
					sql="select disp_type code, short_desc description from am_disposition_type where upper(disp_type) like upper(?) and upper(short_desc) like upper(?) order by 2";
					
				
					break;

			case "DURATIONTYPE":
			case "P_FM_STATUS":
			case "P_TO_STATUS":
					dialogTitle=getLabel("Common.DurationType.label","Common");
					sql="select DURN_TYPE code, DURN_DESC description from AM_DURATION_TYPE where upper(DURN_TYPE) like upper(?) and upper(DURN_DESC) like upper(?) order by 2 ";
					
					
					break;

			case "REFERRAL":
			case "P_FM_REFERRAL_CODE":
			case "P_TO_REFERRAL_CODE":
					dialogTitle=getLabel("Common.referral.label","Common");
					sql="select referral_code code, short_desc description from am_referral where eff_status='E' and upper(referral_code) like upper(?) and upper(long_desc) like upper(?) order by 2 ";
					
				
					break;

		   case "FLOOR_FM":
		   case "FLOOR_TO":
		   case "P_FM_FLOOR_CODE":
		   case "P_TO_FLOOR_CODE":
					dialogTitle=getLabel("Common.floor.label","Common");
					if(document.forms[0].name == "")
						sql="select floor_code code, short_desc description from am_bldng_floor where OPERATING_FACILITY_ID ='"+repFacilityRoom.p_facility.value+"'  and upper(floor_code) like upper(?) and upper(short_desc) like upper(?) order by 2";
					else
						sql="select floor_code code, short_desc description from am_bldng_floor where OPERATING_FACILITY_ID ='"+ document.forms[0].p_facility.value +"' and EFF_STATUS = 'E'  and upper(floor_code) like upper(?) and upper(short_desc) like upper(?) order by 2";
					
				
					break;

			case "FREQSTATUS":
			case "P_FM_STATUS_FREQ":
			case "P_TO_STATUS_FREQ":
					dialogTitle=getLabel("Common.FrequencyCode.label","Common");
					sql="select FREQ_CODE code, FREQ_DESC description from AM_FREQUENCY where upper(FREQ_CODE) like upper(?) and upper(FREQ_DESC) like upper(?) order by 2";
					
					
					break;

			case "HLTHCARE":
			case "P_FM_HCARE":
			case "P_TO_HCARE":
					dialogTitle=getLabel("Common.HealthcareSettingType.label","Common");
					sql="select hcare_setting_type_code code, short_desc description from am_hcare_setting_type where upper(hcare_setting_type_code) like upper(?) and upper(short_desc) like upper(?) order by 2";
					
					break;

			case "MANSTATUS":
			case "P_FM_STATUS_MAN":
			case "P_TO_STATUS_MAN":
					dialogTitle=getLabel("eAM.ManufacturerStatus.label","am");
					sql="select MANUFACTURER_ID code, short_name description from AM_MANUFACTURER where upper(MANUFACTURER_ID) like upper(?) and upper(short_name) like upper(?) order by 2 ";
					
				
					
					break;

			case "TEAM_FM":
			case "TEAM_TO":
			case "P_FM_TEAM_ID":
			case "P_TO_TEAM_ID":
					dialogTitle=getLabel("Common.medicalteam.label","Common");
					sql="select team_id code,short_desc description from am_medical_team where FACILITY_ID ='"+document.forms[0].p_facility.value+"' ";
					if(document.forms[0].name == "repMedTeamPract"){
						sql += " and EFF_STATUS = 'E'";
						
					}
					
					
					sql += "and upper(team_id) like upper(?) and upper(short_desc) like upper(?) order by 2 ";
					break;


			case "SPECIALITY_FM":
			case "SPECIALITY_TO":
			case "SPECIALITY":
			case "P_FM_SPECIALITY":
			case "P_TO_SPECIALITY":
			case "P_FM_SPECIALITY_CODE":
			case "P_TO_SPECIALITY_CODE":
					dialogTitle=getLabel("Common.speciality.label","Common");
					sql="select speciality_code code, short_desc description from am_speciality where upper(speciality_code) like upper(?) and upper(short_desc) like upper(?) order by 2";
					
					
					break;

			case "ARRIVAL":
			case "P_FM_ARRIVAL_CODE":
			case "P_TO_ARRIVAL_CODE":
					dialogTitle=getLabel("Common.arrival.label","Common");
					sql="select arrival_code code, short_desc description from am_arrival where facility_id='"+document.forms[0].p_facility_id.value+"' and upper(arrival_code) like upper(?) and upper(short_desc) like upper(?) order by 2 ";
					
					
					break;

			case "OPERSTN_FM":
			case "OPERSTN_TO":
			case "P_FM_OPER_STN_ID":
			case "P_TO_OPER_STN_ID":
					dialogTitle=getLabel("Common.operatorstation.label","Common");
					sql="select oper_stn_id code, short_desc description from am_oper_stn where FACILITY_ID ='"+document.forms[0].p_facility.value+"' and upper(oper_stn_id) like upper(?) and upper(short_desc) like upper(?)";
					
					
					break;

			case "PRACTTYPE":
			case "P_FM_PRACT_TYPE":
			case "P_TO_PRACT_TYPE":
					dialogTitle=getLabel("Common.practitionertype.label","Common");
					sql="select pract_type code, desc_sysdef description from am_pract_type where upper(pract_type) like upper(?) and upper(desc_sysdef) like upper(?) order by 2 ";
				
				
					break;

			case "PRACTITIONER_FM":
			case "P_FM_PRACTITIONER_ID":
					dialogTitle=getLabel("Common.practitioner.label","Common");
					var fm_pract_type = document.forms[0].fm_pract_type.value;
					sql="select practitioner_id code, practitioner_name description from am_pract_for_facility_vw where OPERATING_FACILITY_ID ='"+document.forms[0].p_facility.value+"' and pract_type = 	nvl('"+fm_pract_type+"',pract_type)  and upper(practitioner_id) like upper(?) and upper(practitioner_name) like upper(?) order by 2";
					
					
					break;
			case "PRACTITIONER_TO":
			case "P_TO_PRACTITIONER_ID":
					dialogTitle=getLabel("Common.practitioner.label","Common");
					var to_pract_type = document.forms[0].to_pract_type.value;
					sql="select practitioner_id code, practitioner_name description from AM_PRACT_FOR_FACILITY_VW where OPERATING_FACILITY_ID ='"+document.forms[0].p_facility.value+"' and pract_type = 	nvl('"+to_pract_type+"',pract_type) and upper(practitioner_id) like upper(?) and upper(practitioner_name) like upper(?) order by 2";
						
					
					break;

			case "TO_SPECIALITY":
			case "FM_SPECIALITY":
			case "P_FM_PRIMARY_SPECIALITY_CODE":
			case "P_TO_PRIMARY_SPECIALITY_CODE":
				
					dialogTitle=getLabel("Common.speciality.label","Common");
					sql="select speciality_code code, short_desc description from am_speciality where upper(speciality_code) like upper(?) and upper(short_desc) like upper(?) order by 2 ";
					
				
					break;

			case "CONTACTREASON":
			case "P_FM_REASON_CODE":
			case "P_TO_REASON_CODE":
					dialogTitle=getLabel("Common.ContactReason.label","Common");
					sql="select contact_reason_code code, contact_reason description from am_contact_reason where upper(contact_reason_code) like upper(?) and upper(contact_reason) like upper(?) order by 2 ";
					
					
					break;

			case "USER_FM":
			case "USER_TO":
			case "P_FM_USER_ID":
			case "P_TO_USER_ID":
			case "P_FM_APPL_USER_ID":
			case "P_TO_APPL_USER_ID":
			
					if(document.forms[0].name=="repUserOperStn")
						dialogTitle=getLabel("Common.applusername.label","Common");
					else
						dialogTitle=getLabel("Common.user.label","Common");
					sql="select APPL_USER_ID code, APPL_USER_NAME description from SM_FACILITY_FOR_USER_VW where FACILITY_ID ='"+document.forms[0].p_facility.value+"' and upper(APPL_USER_ID) like upper(?) and upper(APPL_USER_NAME) like upper(?) order by 2 ";
					
				
					break;

			case "TYPE_FM":
			case "TYPE_TO":
			case "P_FM_TYPE":
			case "P_TO_TYPE":
					dialogTitle=getLabel("Common.type.label","Common");
					sql="select locn_type code,short_desc description from am_care_locn_type where (care_locn_type_ind in ('R','N')) and upper(locn_type) like upper(?) and upper(short_desc) like upper(?) order by 2 ";
					
				
					break;

			case "SECTION":
			case "P_FM_SECTION_CODE":
			case "P_TO_SECTION_CODE":
					dialogTitle=getLabel("Common.Section.label","Common");
					sql="select section_code code, short_desc description from am_dept_section where upper(section_code) like upper(?) and upper(short_desc) like upper(?) order by 2 ";
				
					break;

			case "SECTION_FM":
			case "SECTION_TO":
			case "P_FM_SECTION_CODE_FM":
			case "P_TO_SECTION_CODE_TO":

			
					if(document.forms[0].name =="repSpecialityForPract"){
						dialogTitle=getLabel("Common.speciality.label","Common");
						sql="select distinct speciality_code code, speciality_short_desc description from AM_PRACT_FOR_SPECIALITY_VW where FACILITY_ID ='"+repSpecialityForPract.p_facility.value+"' and upper(speciality_code) like upper(?) and upper(speciality_short_desc) like upper(?) order by 2 ";
						
						
						}else{
						dialogTitle=getLabel("Common.Section.label","Common");
						sql="select distinct section_code code, section_short_desc description from AM_FACILITY_SECTION_VW where OPERATING_FACILITY_ID ='"+document.forms[0].p_facility.value+"' and EFF_STATUS = 'E' and upper(section_code) like upper(?) and upper(section_short_desc) like upper(?) order by 2";
						
				
						}
					break;

			case "SERVICE":
			case "P_FM_SERVICE_CODE":
			case "P_TO_SERVICE_CODE":
					dialogTitle=getLabel("Common.service.label","Common");
					sql="select service_code code, short_desc description from am_service where upper(service_code) like upper(?) and upper(short_desc) like upper(?) order by 2";
					
				
					break;

			case "MODULE":
			case "P_FM_MOD":
			case "P_TO_MOD":	
					dialogTitle=getLabel("Common.Module.label","Common");
					sql="select module_id code,module_name description from sm_module where upper(module_id) like upper(?) and upper(module_name) like upper(?) order by 2";
					
				
					break;

			case "PROGRAM_BUT1":
			case "P_FM_PROGRAM_ID":
					dialogTitle=getLabel("Common.Program.label","common");
					if(program_type == "F"){
						sql = "Select function_id code, function_name description from sm_function where module_id = nvl('"+fm_module_id+"',module_id) and upper(function_id) like upper(?) and upper(function_name) like upper(?) order by 2 ";
					
						
					}else if(program_type == "R"){
						sql = "Select report_id code, report_desc description from sm_report where module_id = nvl('"+fm_module_id+"',module_id) and upper(report_id) like upper(?) and upper(report_desc) like upper(?) order by 2";
						
					
						
					}
					break;
			case "PROGRAM_BUT2":
			case "P_TO_PROGRAM_ID":
					dialogTitle=getLabel("Common.Program.label","common");
					if(program_type == "F"){
						sql = "Select function_id code, function_name description from sm_function where module_id = nvl('"+to_module_id+"',module_id)  and upper(function_id) like upper(?) and upper(function_name) like upper(?) order by 2 ";
						
						
					}else if(program_type == "R"){	
						sql = "Select report_id code, report_desc description from sm_report where module_id = nvl('"+to_module_id+"',module_id) and upper(report_id) like upper(?) and upper(report_desc) like upper(?) order by 2 ";
						
					
						
					}
					break;

			case "STATISTICS":
			case "P_FM_STAT_GRP":
			case "P_TO_STAT_GRP":
					dialogTitle=getLabel("Common.StatisticsGroup.label","Common");
					sql="select stat_grp_id code,stat_grp_desc description from am_stat_group where upper(stat_grp_id) like upper(?) and upper(stat_grp_desc) like upper(?) order by 2";
					
					
					break;

			case "SUBSERVICE_FM":
			case "SUBSERVICE_TO":
			case "P_FM_SUBSERVICE_CODE":
			case "P_TO_SUBSERVICE_CODE":
					dialogTitle=getLabel("Common.subservice.label","Common");	// am_subservice
					sql="select distinct subservice_code code, subservice_short_desc description from AM_FACILITY_SUBSRVC_VW where OPERATING_FACILITY_ID ='"+ document.forms[0].p_facility.value + "' and EFF_STATUS = 'E' and upper(subservice_code) like upper(?) and upper(subservice_short_desc) like upper(?) order by 2";
					
					break;

			case "SUBSERVICE":
			case "P_FM_SUBSERVICE_CODE_FM":
			case "P_TO_SUBSERVICE_CODE_TO":
					dialogTitle=getLabel("Common.subservice.label","Common");
					sql="select subservice_code code, short_desc description from am_subservice where upper(subservice_code) like upper(?) and upper(short_desc) like upper(?) order by 2";
					
					
					break;

			case "AGERANGE":
			case "P_FM_RANGE_ID":
			case "P_TO_RANGE_ID":
					dialogTitle=getLabel("Common.AgeRange.label","Common");
					sql="select range_id code, short_desc description from am_summ_range where upper(range_id) like upper(?) and upper(short_desc) like upper(?) order by 2";
					
					break;

			case "TRADENAME":
			case "P_FROM_CODE":
			case "P_TO_CODE":
					dialogTitle=getLabel("Common.TradeName.label","Common");
					sql="select TRADE_ID code, SHORT_NAME description from AM_TRADE_NAME where upper(TRADE_ID) like upper(?) and upper(SHORT_NAME) like upper(?) order by 2";
					
					break;

			case "UOM":
			case "P_FM_STATUS_CODE":
			case "P_TO_STATUS_CODE":
					dialogTitle=getLabel("Common.UnitofMeasure.label","common");
					sql="select UOM_CODE code, short_desc description from am_uom where upper(UOM_CODE) like upper(?) and upper(short_desc) like upper(?) order by 2";
						
					
					break;

	}
		
		argumentArray[0] = sql ;
		argumentArray[1] = dataNameArray ;
		argumentArray[2] = dataValueArray ;
		argumentArray[3] = dataTypeArray ;
		argumentArray[4] = "1,2";
		argumentArray[5] = target_code.value;
		argumentArray[6] = CODE_LINK ;
		argumentArray[7] = CODE_DESC ; 

		retVal = await CommonLookup(dialogTitle, argumentArray );
		var arr=new Array();

		if (retVal != null && retVal != '' && retVal != "null")
		{
			var retVal=unescape(retVal);
			arr=retVal.split(",");
			var desc=arr[1];
			var code=arr[0];
			target_desc.value=desc;
			target_code.value=code;
		}else
		{
			target_desc.value="";
			target_code.value="";
			return;
		}
	
}
