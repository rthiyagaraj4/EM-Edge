function reset() {
	f_query_add_mod.document.location.reload();


}//e.o.reset

function run() 
{
if (f_query_add_mod.document.repAnaesthesia)
{
if(CheckString('Anaesthesia', f_query_add_mod.document.repAnaesthesia.p_fm_anaesthesia_code,f_query_add_mod.document.repAnaesthesia.p_to_anaesthesia_code, messageFrame ))
f_query_add_mod.document.repAnaesthesia.submit() ;
}

if (f_query_add_mod.document.repAnatomicalSite)
{
if(CheckString('Anatomical Site', f_query_add_mod.document.repAnatomicalSite.p_fm_anatomical_code,f_query_add_mod.document.repAnatomicalSite.p_to_anatomical_code, messageFrame ))
f_query_add_mod.document.repAnatomicalSite.submit() ;
}

if (f_query_add_mod.document.repEscortType)
{
if(CheckString('Escort Type', f_query_add_mod.document.repEscortType.p_fm_escort_code,f_query_add_mod.document.repEscortType.p_to_escort_code, messageFrame ))
f_query_add_mod.document.repEscortType.submit() ;
}

if (f_query_add_mod.document.repLevelOfCare)
{
if(CheckString('Level Of Care', f_query_add_mod.document.repLevelOfCare.p_fm_level_of_care_code,f_query_add_mod.document.repLevelOfCare.p_to_level_of_care_code, messageFrame ))
f_query_add_mod.document.repLevelOfCare.submit() ;
}

if (f_query_add_mod.document.repEquipmentResource)
{
if(CheckString('Resource Code', f_query_add_mod.document.repEquipmentResource.p_fm_resource_code,f_query_add_mod.document.repEquipmentResource.p_to_resource_code, messageFrame ))
if(CheckString('Resource ID', f_query_add_mod.document.repEquipmentResource.p_fm_resource_id,f_query_add_mod.document.repEquipmentResource.p_to_resource_id, messageFrame ))
f_query_add_mod.document.repEquipmentResource.submit() ;
}

if (f_query_add_mod.document.repResourceType)
{
if(CheckString('Resource Type code', f_query_add_mod.document.repResourceType.p_fm_resource_code,f_query_add_mod.document.repResourceType.p_to_resource_code, messageFrame ))
f_query_add_mod.document.repResourceType.submit() ;
}


if(f_query_add_mod.document.repAgeGroupList)
{
	//if( f_query_add_mod.CheckString('Facility ID', f_query_add_mod.document.repAgeGroupList.p_fm_facility_id,f_query_add_mod.document.repAgeGroupList.p_to_facility_id, messageFrame ))
	if(CheckString('Age Group Code', f_query_add_mod.document.repAgeGroupList.p_fm_age_group_code,f_query_add_mod.document.repAgeGroupList.p_to_age_group_code, messageFrame ))
	f_query_add_mod.document.repAgeGroupList.submit() ;
}

if(f_query_add_mod.document.repAmbStatus)
 {
	if(CheckString('Ambulatory Status', f_query_add_mod.document.repAmbStatus.p_fm_ambulatory_status,f_query_add_mod.document.repAmbStatus.p_to_ambulatory_status, messageFrame )  )
	f_query_add_mod.document.repAmbStatus.submit() ;
 }
 
if(f_query_add_mod.document.repBldnginfacility){
//if( f_query_add_mod.CheckString('Facility Code', f_query_add_mod.document.repBldnginfacility.p_fm_facility_code,f_query_add_mod.document.repBldnginfacility.p_to_facility_code, messageFrame )  )
if(CheckString('Building Code', f_query_add_mod.document.repBldnginfacility.p_fm_bldng_code,f_query_add_mod.document.repBldnginfacility.p_to_bldng_code, messageFrame )  )
f_query_add_mod.document.repBldnginfacility.submit() ;
}

if(f_query_add_mod.document.repCOIList){
if(CheckString('Circumstance of Injury Code', f_query_add_mod.document.repCOIList.p_fm_COI_code,f_query_add_mod.document.repCOIList.p_to_COI_code, messageFrame )  )
f_query_add_mod.document.repCOIList.submit() ;
}

if(f_query_add_mod.document.repDeptList){
if(CheckString('Acct Dept Code', f_query_add_mod.document.repDeptList.p_fm_dept_code,f_query_add_mod.document.repDeptList.p_to_dept_code, messageFrame )  )
f_query_add_mod.document.repDeptList.submit() ;
}

if(f_query_add_mod.document.repDeptRoomList){
if(CheckString('Acct Dept Code', f_query_add_mod.document.repDeptRoomList.p_fm_dept_code,f_query_add_mod.document.repDeptRoomList.p_to_dept_code, messageFrame )  )
if(CheckString('Service Code', f_query_add_mod.document.repDeptRoomList.p_fm_service_code,f_query_add_mod.document.repDeptRoomList.p_to_service_code, messageFrame )  )	
if(CheckString('Room Number', f_query_add_mod.document.repDeptRoomList.p_fm_room_num,f_query_add_mod.document.repDeptRoomList.p_to_room_num, messageFrame )  )	
f_query_add_mod.document.repDeptRoomList.submit() ;
}

if(f_query_add_mod.document.repFacilityDeptList){
//if( f_query_add_mod.CheckString('Facility ID', f_query_add_mod.document.repFacilityDeptList.p_fm_facility_id,f_query_add_mod.document.repFacilityDeptList.p_to_facility_id, messageFrame )  )
if(CheckString('Acct Dept Code', f_query_add_mod.document.repFacilityDeptList.p_fm_dept_code,f_query_add_mod.document.repFacilityDeptList.p_to_dept_code, messageFrame )  )		
f_query_add_mod.document.repFacilityDeptList.submit() ;
}

if(f_query_add_mod.document.repDispTypeList){
if(CheckString('Disposition Type', f_query_add_mod.document.repDispTypeList.p_fm_disp_type,f_query_add_mod.document.repDispTypeList.p_to_disp_type, messageFrame )  )
f_query_add_mod.document.repDispTypeList.submit() ;
}

if(f_query_add_mod.document.repReactionList){
if(CheckString('Reaction Code', f_query_add_mod.document.repReactionList.p_fm_reaction,f_query_add_mod.document.repReactionList.p_to_reaction, messageFrame )  )
f_query_add_mod.document.repReactionList.submit() ;
}

if(f_query_add_mod.document.repReferralList){
if(CheckString('Referral Code', f_query_add_mod.document.repReferralList.p_fm_referral_code,f_query_add_mod.document.repReferralList.p_to_referral_code, messageFrame )  )
f_query_add_mod.document.repReferralList.submit() ;
}

if(f_query_add_mod.document.repFloorinFacility){
//if( f_query_add_mod.CheckString('Facility Code', f_query_add_mod.document.repFloorinFacility.p_fm_facility_code,f_query_add_mod.document.repFloorinFacility.p_to_facility_code, messageFrame )  )
if(CheckString('Building Code', f_query_add_mod.document.repFloorinFacility.p_fm_bldng_code,f_query_add_mod.document.repFloorinFacility.p_to_bldng_code, messageFrame )  )	
if(CheckString('Floor Code', f_query_add_mod.document.repFloorinFacility.p_fm_floor_code,f_query_add_mod.document.repFloorinFacility.p_to_floor_code, messageFrame )  )	
f_query_add_mod.document.repFloorinFacility.submit() ;
}

if(f_query_add_mod.document.repLocnForOperStn){
if(CheckString('Operator Station ID', f_query_add_mod.document.repLocnForOperStn.p_fm_oper_stn_id,f_query_add_mod.document.repLocnForOperStn.p_to_oper_stn_id, messageFrame )  )
if(CheckString('Location Code', f_query_add_mod.document.repLocnForOperStn.p_fm_locn_code,f_query_add_mod.document.repLocnForOperStn.p_to_locn_code, messageFrame )  )	
if(CheckString('Speciality Code', f_query_add_mod.document.repLocnForOperStn.p_fm_speciality,f_query_add_mod.document.repLocnForOperStn.p_to_speciality, messageFrame )  )	
f_query_add_mod.document.repLocnForOperStn.submit() ;
}

if(f_query_add_mod.document.repArrivalList){
if(CheckString('Arrival Code', f_query_add_mod.document.repArrivalList.p_fm_arrival_code,f_query_add_mod.document.repArrivalList.p_to_arrival_code, messageFrame )  )
f_query_add_mod.document.repArrivalList.submit() ;
}

if(f_query_add_mod.document.repOperStnList){
if( CheckString('Operator Station ID', f_query_add_mod.document.repOperStnList.p_fm_oper_stn_id,f_query_add_mod.document.repOperStnList.p_to_oper_stn_id, messageFrame )  )
f_query_add_mod.document.repOperStnList.submit() ;
}

if(f_query_add_mod.document.repPatInstrList){
if( CheckString('Speciality Code', f_query_add_mod.document.repPatInstrList.p_fm_speciality_code,f_query_add_mod.document.repPatInstrList.p_to_speciality_code, messageFrame )  )
if(CheckString('Instruction ID', f_query_add_mod.document.repPatInstrList.p_fm_instrn_id,f_query_add_mod.document.repPatInstrList.p_to_instrn_id, messageFrame )  )	
f_query_add_mod.document.repPatInstrList.submit() ;
}

if(f_query_add_mod.document.repPatType){
if(CheckString('Patient Type', f_query_add_mod.document.repPatType.p_fm_patient_type,f_query_add_mod.document.repPatType.p_to_patient_type, messageFrame )  )
f_query_add_mod.document.repPatType.submit() ;
}

if(f_query_add_mod.document.repPatTypeClass){
if(CheckString('Patient Type', f_query_add_mod.document.repPatTypeClass.p_fm_patient_type,f_query_add_mod.document.repPatTypeClass.p_to_patient_type, messageFrame )  )
if( CheckString('Patient Type Class', f_query_add_mod.document.repPatTypeClass.p_fm_patient_class,f_query_add_mod.document.repPatTypeClass.p_to_patient_class, messageFrame )  )
f_query_add_mod.document.repPatTypeClass.submit() ;
}

if(f_query_add_mod.document.repPractTypeList){
if( CheckString('Practitioner Type', f_query_add_mod.document.repPractTypeList.p_fm_pract_type,f_query_add_mod.document.repPractTypeList.p_to_pract_type, messageFrame )  )
f_query_add_mod.document.repPractTypeList.submit() ;
}

if(f_query_add_mod.document.repPractForFacility){
//if( f_query_add_mod.CheckString('Facility ID', f_query_add_mod.document.repPractForFacility.p_fm_facility_id,f_query_add_mod.document.repPractForFacility.p_to_facility_id, messageFrame )  )
if(CheckString('Practitioner ID', f_query_add_mod.document.repPractForFacility.p_fm_practitioner_id,f_query_add_mod.document.repPractForFacility.p_to_practitioner_id, messageFrame )  )	
if( CheckString('Primary Speciality Code', f_query_add_mod.document.repPractForFacility.p_fm_primary_speciality_code,f_query_add_mod.document.repPractForFacility.p_to_primary_speciality_code, messageFrame )  )	
f_query_add_mod.document.repPractForFacility.submit() ;
}

if(f_query_add_mod.document.repContactReason){
if(CheckString('Contact Reason Code', f_query_add_mod.document.repContactReason.p_fm_reason_code,f_query_add_mod.document.repContactReason.p_to_reason_code, messageFrame )  )
f_query_add_mod.document.repContactReason.submit() ;
}

if(f_query_add_mod.document.repFacilityRoom){
if( CheckString('Building Code', f_query_add_mod.document.repFacilityRoom.p_fm_bldng_code,f_query_add_mod.document.repFacilityRoom.p_to_bldng_code, messageFrame )  )
if(CheckString('Floor Code', f_query_add_mod.document.repFacilityRoom.p_fm_floor_code,f_query_add_mod.document.repFacilityRoom.p_to_floor_code, messageFrame )  )	
if(CheckString('Room Number', f_query_add_mod.document.repFacilityRoom.p_fm_room_num,f_query_add_mod.document.repFacilityRoom.p_to_room_num, messageFrame )  )	
if(CheckString('Type', f_query_add_mod.document.repFacilityRoom.p_fm_type,f_query_add_mod.document.repFacilityRoom.p_to_type, messageFrame )  )	
f_query_add_mod.document.repFacilityRoom.submit() ;
}

if(f_query_add_mod.document.repSectionList){
if( CheckString('Acct Dept Code', f_query_add_mod.document.repSectionList.p_fm_dept_code,f_query_add_mod.document.repSectionList.p_to_dept_code, messageFrame )  )
if( CheckString('Section Code', f_query_add_mod.document.repSectionList.p_fm_section_code,f_query_add_mod.document.repSectionList.p_to_section_code, messageFrame )  )
f_query_add_mod.document.repSectionList.submit() ;
}

if(f_query_add_mod.document.repFacilitySectionList){
//if( f_query_add_mod.CheckString('Facility ID', f_query_add_mod.document.repFacilitySectionList.p_fm_facility_id,f_query_add_mod.document.repFacilitySectionList.p_to_facility_id, messageFrame )  )
if( CheckString('Acct Dept Code', f_query_add_mod.document.repFacilitySectionList.p_fm_dept_code,f_query_add_mod.document.repFacilitySectionList.p_to_dept_code, messageFrame )  )	
if( CheckString('Section Code', f_query_add_mod.document.repFacilitySectionList.p_fm_section_code,f_query_add_mod.document.repFacilitySectionList.p_to_section_code, messageFrame )  )	
f_query_add_mod.document.repFacilitySectionList.submit() ;
}

if(f_query_add_mod.document.repServiceList){
if(CheckString('Service Code', f_query_add_mod.document.repServiceList.p_fm_service_code,f_query_add_mod.document.repServiceList.p_to_service_code, messageFrame )  )
f_query_add_mod.document.repServiceList.submit() ;
}

if(f_query_add_mod.document.repSpecialityList){
if(CheckString('Speciality Code', f_query_add_mod.document.repSpecialityList.p_fm_speciality_code,f_query_add_mod.document.repSpecialityList.p_to_speciality_code, messageFrame )  )
f_query_add_mod.document.repSpecialityList.submit() ;
}
if(f_query_add_mod.document.repSpecialityForPract){
//if( f_query_add_mod.CheckString('Facility ID', f_query_add_mod.document.repSpecialityForPract.p_fm_facility_id,f_query_add_mod.document.repSpecialityForPract.p_to_facility_id, messageFrame )  )
if( CheckString('Practitioner ID', f_query_add_mod.document.repSpecialityForPract.p_fm_practitioner_id,f_query_add_mod.document.repSpecialityForPract.p_to_practitioner_id, messageFrame )  )	
if( CheckString('Section Code', f_query_add_mod.document.repSpecialityForPract.p_fm_section_code,f_query_add_mod.document.repSpecialityForPract.p_to_section_code, messageFrame )  )	
f_query_add_mod.document.repSpecialityForPract.submit() ;
}

if(f_query_add_mod.document.repFacilitySubService){
//if( f_query_add_mod.CheckString('Facility ID', f_query_add_mod.document.repFacilitySubService.p_fm_facility_id,f_query_add_mod.document.repFacilitySubService.p_to_facility_id, messageFrame )  )
if( CheckString('Acct Dept Code', f_query_add_mod.document.repFacilitySubService.p_fm_dept_code,f_query_add_mod.document.repFacilitySubService.p_to_dept_code, messageFrame )  )	
if(CheckString('Section Code', f_query_add_mod.document.repFacilitySubService.p_fm_section_code,f_query_add_mod.document.repFacilitySubService.p_to_section_code, messageFrame )  )	
if( CheckString('Service Code', f_query_add_mod.document.repFacilitySubService.p_fm_service_code,f_query_add_mod.document.repFacilitySubService.p_to_service_code, messageFrame )  )
if( CheckString('Subservice Code', f_query_add_mod.document.repFacilitySubService.p_fm_subservice_code,f_query_add_mod.document.repFacilitySubService.p_to_subservice_code, messageFrame )  )
f_query_add_mod.document.repFacilitySubService.submit() ;
}

if(f_query_add_mod.document.repSubServiceList){
if( CheckString('Service Code', f_query_add_mod.document.repSubServiceList.p_fm_service_code,f_query_add_mod.document.repSubServiceList.p_to_service_code, messageFrame )  )
if( CheckString('Subservice Code', f_query_add_mod.document.repSubServiceList.p_fm_subservice_code,f_query_add_mod.document.repSubServiceList.p_to_subservice_code, messageFrame )  )
f_query_add_mod.document.repSubServiceList.submit() ;
}

if(f_query_add_mod.document.repAgeRange){
if( CheckString('Range ID', f_query_add_mod.document.repAgeRange.p_fm_range_id,f_query_add_mod.document.repAgeRange.p_to_range_id, messageFrame )  )
f_query_add_mod.document.repAgeRange.submit() ;
}

if(f_query_add_mod.document.repTemplocnforpat){
//if( f_query_add_mod.CheckString('Facility Code', f_query_add_mod.document.repTemplocnforpat.p_fm_facility_code,f_query_add_mod.document.repTemplocnforpat.p_to_facility_code, messageFrame )  )
if(CheckString('Location ID', f_query_add_mod.document.repTemplocnforpat.p_fm_temp_locn_id,f_query_add_mod.document.repTemplocnforpat.p_to_temp_locn_id, messageFrame )  )
if(CheckString('Building Code', f_query_add_mod.document.repTemplocnforpat.p_fm_bldng_code,f_query_add_mod.document.repTemplocnforpat.p_to_bldng_code, messageFrame )  )
if( CheckString('Floor Code', f_query_add_mod.document.repTemplocnforpat.p_fm_floor_code,f_query_add_mod.document.repTemplocnforpat.p_to_floor_code, messageFrame )  )	
f_query_add_mod.document.repTemplocnforpat.submit() ;
}

if(f_query_add_mod.document.repVisitType){
if( CheckString('Visit Type Code', f_query_add_mod.document.repVisitType.p_fm_visit_analysis_code,f_query_add_mod.document.repVisitType.p_to_visit_analysis_code, messageFrame )  )
f_query_add_mod.document.repVisitType.submit() ;
}

if(f_query_add_mod.document.repCareLocnType){
if( CheckString('Location Type', f_query_add_mod.document.repCareLocnType.p_fm_locn_type,f_query_add_mod.document.repCareLocnType.p_to_locn_type, messageFrame )  )
f_query_add_mod.document.repCareLocnType.submit() ;
}

if(f_query_add_mod.document.repComplaintList){
if(CheckString('Complaint Code', f_query_add_mod.document.repComplaintList.p_fm_complaint_code,f_query_add_mod.document.repComplaintList.p_to_complaint_code, messageFrame )  )
f_query_add_mod.document.repComplaintList.submit() ;
}

	if(f_query_add_mod.document.repUserOperStn){
		if( CheckString('Operator Station ID', f_query_add_mod.document.repUserOperStn.p_fm_oper_stn_id,f_query_add_mod.document.repUserOperStn.p_to_oper_stn_id, messageFrame )  )
			if(CheckString('Appl User ID', f_query_add_mod.document.repUserOperStn.p_fm_appl_user_id,f_query_add_mod.document.repUserOperStn.p_to_appl_user_id, messageFrame )  )	
				if(f_query_add_mod.doDateCheck(f_query_add_mod.document.repUserOperStn.p_eff_date_fm,f_query_add_mod.document.repUserOperStn.p_eff_date_to,messageFrame))
				{
					f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
					f_query_add_mod.document.forms[0].target="messageFrame";
					f_query_add_mod.document.repUserOperStn.submit() ;
				}
	}
if(f_query_add_mod.document.repVitalSignNrsngMsrGrp){
if( CheckString('Battery ID', f_query_add_mod.document.repVitalSignNrsngMsrGrp.p_fm_observ_battery_id,f_query_add_mod.document.repVitalSignNrsngMsrGrp.p_to_observ_battery_id, messageFrame )  )
f_query_add_mod.document.repVitalSignNrsngMsrGrp.submit() ;
}

if(f_query_add_mod.document.repFacilityService){
//if( f_query_add_mod.CheckString('Facility ID', f_query_add_mod.document.repFacilityService.p_fm_facility_id,f_query_add_mod.document.repFacilityService.p_to_facility_id, messageFrame )  )
if(CheckString('Acct Dept Code', f_query_add_mod.document.repFacilityService.p_fm_dept_code,f_query_add_mod.document.repFacilityService.p_to_dept_code, messageFrame )  )	
if( CheckString('Service Code', f_query_add_mod.document.repFacilityService.p_fm_service_code,f_query_add_mod.document.repFacilityService.p_to_service_code, messageFrame )  )
f_query_add_mod.document.repFacilityService.submit() ;
}

if(f_query_add_mod.document.repVitalSignNrsngMsr){
if( CheckString('Test Observ ID', f_query_add_mod.document.repVitalSignNrsngMsr.p_fm_test_observ_id,f_query_add_mod.document.repVitalSignNrsngMsr.p_to_test_observ_id, messageFrame )  )
f_query_add_mod.document.repVitalSignNrsngMsr.submit() ;
}

if(f_query_add_mod.document.repPractitionerList){
if(CheckString('Practitioner ID', f_query_add_mod.document.repPractitionerList.p_fm_practitioner_id,f_query_add_mod.document.repPractitionerList.p_to_practitioner_id, messageFrame )  )
if(CheckString('Practitioner Type', f_query_add_mod.document.repPractitionerList.p_fm_practitioner_type,f_query_add_mod.document.repPractitionerList.p_to_practitioner_type, messageFrame )  )
if( CheckString('Primary Speciality Code', f_query_add_mod.document.repPractitionerList.p_fm_primary_speciality_code,f_query_add_mod.document.repPractitionerList.p_to_primary_speciality_code, messageFrame )  )	
if( CheckString('Rep Facility ID', f_query_add_mod.document.repPractitionerList.p_fm_rep_facility_id,f_query_add_mod.document.repPractitionerList.p_to_rep_facility_id, messageFrame )  )	
f_query_add_mod.document.repPractitionerList.submit() ;
}

if(f_query_add_mod.document.repHcareList){
if(CheckString('Healthcare Setting Type', f_query_add_mod.document.repHcareList.p_fm_hcare,f_query_add_mod.document.repHcareList.p_to_hcare, messageFrame )  )
f_query_add_mod.document.repHcareList.submit() ;
}

if(f_query_add_mod.document.repHcareRestrnList){
if( CheckString('From Healthcare Setting Type', f_query_add_mod.document.repHcareRestrnList.p_fm_hcare,f_query_add_mod.document.repHcareRestrnList.p_to_hcare, messageFrame )  )
if( CheckString('To Healthcare Setting Type', f_query_add_mod.document.repHcareRestrnList.p_fm_hcare,f_query_add_mod.document.repHcareRestrnList.p_to_hcare, messageFrame )  )
f_query_add_mod.document.repHcareRestrnList.submit() ;
}

if(f_query_add_mod.document.repOperStnRestrnList){
if( CheckString('Operator Station ID', f_query_add_mod.document.repOperStnRestrnList.p_fm_oper_stn_id,f_query_add_mod.document.repOperStnRestrnList.p_to_oper_stn_id, messageFrame )  )
f_query_add_mod.document.repOperStnRestrnList.submit() ;
}

if(f_query_add_mod.document.repStatGrp){
if( CheckString('Statistics Group', f_query_add_mod.document.repStatGrp.p_fm_stat_grp,f_query_add_mod.document.repStatGrp.p_to_stat_grp, messageFrame )  )
f_query_add_mod.document.repStatGrp.submit() ;
}
if(f_query_add_mod.document.repStatGrpDtl){
if( CheckString('Statistics Group', f_query_add_mod.document.repStatGrpDtl.p_fm_stat_grp,f_query_add_mod.document.repStatGrpDtl.p_to_stat_grp, messageFrame )  )
f_query_add_mod.document.repStatGrpDtl.submit() ;
}

if(f_query_add_mod.document.reppgmstatgrp){
if(CheckString('Module', f_query_add_mod.document.reppgmstatgrp.p_fm_mod,f_query_add_mod.document.reppgmstatgrp.p_to_mod, messageFrame )  )
if(CheckString('Program ID', f_query_add_mod.document.reppgmstatgrp.p_fm_program_id,f_query_add_mod.document.reppgmstatgrp.p_to_program_id, messageFrame )  )
if(CheckString('Statistics Group', f_query_add_mod.document.reppgmstatgrp.p_fm_stat_grp,f_query_add_mod.document.reppgmstatgrp.p_to_stat_grp, messageFrame )  )
f_query_add_mod.document.reppgmstatgrp.submit() ;
}

if(f_query_add_mod.document.repMedTeam){
if(CheckString('Team ID', f_query_add_mod.document.repMedTeam.p_fm_team_id,f_query_add_mod.document.repMedTeam.p_to_team_id, messageFrame )  )
if(CheckString('Speciality Code', f_query_add_mod.document.repMedTeam.p_fm_speciality,f_query_add_mod.document.repMedTeam.p_to_speciality, messageFrame )  )
f_query_add_mod.document.repMedTeam.submit() ;
}

if(f_query_add_mod.document.repMedTeamPract){
if(CheckString('Team ID', f_query_add_mod.document.repMedTeamPract.p_fm_team_id,f_query_add_mod.document.repMedTeamPract.p_to_team_id, messageFrame )  )
if(CheckString('Speciality Code', f_query_add_mod.document.repMedTeamPract.p_fm_speciality,f_query_add_mod.document.repMedTeamPract.p_to_speciality, messageFrame )  )
if(CheckString('Practitioner ID', f_query_add_mod.document.repMedTeamPract.p_fm_practitioner_id,f_query_add_mod.document.repMedTeamPract.p_fm_practitioner_id, messageFrame )  )
f_query_add_mod.document.repMedTeamPract.submit() ;
}

if(f_query_add_mod.document.repRefNum){
//if( f_query_add_mod.CheckString('Facility ID', f_query_add_mod.document.repRefNum.p_fm_facility_id,f_query_add_mod.document.repRefNum.p_to_facility_id, messageFrame )  )
f_query_add_mod.document.repRefNum.submit() ;
}
/****************************************************************/
if(f_query_add_mod.document.repManufacturerForm){

	if(CheckString('Manufacturer ID', f_query_add_mod.document.repManufacturerForm.p_fm_status,f_query_add_mod.document.repManufacturerForm.p_to_status, messageFrame )  )

	f_query_add_mod.document.repManufacturerForm.submit() ;
}
//////////////
if(f_query_add_mod.document.repUnitofMeasureForm){

if(CheckString('UOM Code', f_query_add_mod.document.repUnitofMeasureForm.p_fm_status,f_query_add_mod.document.repUnitofMeasureForm.p_to_status, messageFrame )  )
f_query_add_mod.document.repUnitofMeasureForm.submit() ;
}
/////////////////////
if(f_query_add_mod.document.repDurationTypeForm){

	if(CheckString('Duration Type', f_query_add_mod.document.repDurationTypeForm.p_fm_status,f_query_add_mod.document.repDurationTypeForm.p_to_status, messageFrame )  )
	f_query_add_mod.document.repDurationTypeForm.submit() ;
}
///////////////////
if(f_query_add_mod.document.repFrequencyForm){

if(CheckString('Frequency Code', f_query_add_mod.document.repFrequencyForm.p_fm_status,f_query_add_mod.document.repFrequencyForm.p_to_status, messageFrame )  )

	f_query_add_mod.document.repFrequencyForm.submit() ;
}
/////////////////////
if(f_query_add_mod.document.repFrequencyScheduleForm){
	
	if(CheckString('Frequency Code', f_query_add_mod.document.repFrequencyScheduleForm.p_fm_code,f_query_add_mod.document.repFrequencyScheduleForm.p_to_fm_code, messageFrame )  )
	if(CheckString('Admin Facility ID', f_query_add_mod.document.repFrequencyScheduleForm.p_fm_status,f_query_add_mod.document.repFrequencyScheduleForm.p_to_status, messageFrame )  )

	f_query_add_mod.document.repFrequencyScheduleForm.submit() ;
}
/////////////////////
if(f_query_add_mod.document.repTradeNameForm){
	if(CheckString('Trade Name', f_query_add_mod.document.repTradeNameForm.p_from_code,f_query_add_mod.document.repTradeNameForm.p_to_code, messageFrame )  )
	f_query_add_mod.document.repTradeNameForm.submit() ;
}
/////////////////////
if(f_query_add_mod.document.repEquiUOMForm){

if(CheckString('UOM Code', f_query_add_mod.document.repEquiUOMForm.p_fm_status,f_query_add_mod.document.repEquiUOMForm.p_to_status, messageFrame )  )
if(CheckString('Equivalent UOM', f_query_add_mod.document.repEquiUOMForm.p_fm_status_equiUOM,f_query_add_mod.document.repEquiUOMForm.p_to_status_equiUOM, messageFrame )  )
f_query_add_mod.document.repEquiUOMForm.submit() ;
}


if(f_query_add_mod.document.repSpecialityReferralForm){

if(CheckString('Referral Code', f_query_add_mod.document.repSpecialityReferralForm.p_from_referral_code,f_query_add_mod.document.repSpecialityReferralForm.p_to_referral_code, messageFrame )  )
if(CheckString('Speciality Code', f_query_add_mod.document.repSpecialityReferralForm.p_from_specialty_code,f_query_add_mod.document.repSpecialityReferralForm.p_to_specialty_code, messageFrame )  )
f_query_add_mod.document.repSpecialityReferralForm.submit() ;
}
/*////////////////////
if(f_query_add_mod.document.repMedTeam){
if( f_query_add_mod.CheckString('Team ID', f_query_add_mod.document.repMedTeam.p_fm_team_id,f_query_add_mod.document.repMedTeam.p_to_team_id, messageFrame )  )
if( f_query_add_mod.CheckString('Speciality Code', f_query_add_mod.document.repMedTeam.p_fm_speciality,f_query_add_mod.document.repMedTeam.p_to_speciality, messageFrame )  )
f_query_add_mod.document.repMedTeam.submit() ;
}
/****************************************************************/
}//e.o.run

function CheckString(str,fromobj,toobj,messageFrame) {

	 var arr = new Array(toobj.value,fromobj.value);
    if( trimCheck(fromobj.value) && trimCheck(toobj.value) ) {
        if(fromobj.value <= toobj.value) {
            return true;
        }
        else {
			var error=getMessage("REMARKS_MUST_GR_EQUAL","common",arr);
			error=error.replace("$",getLabel('Common.to.label','common_labels')+ ' ' +str);
			error=error.replace("#",str);
            messageFrame.location.href = "../../eCommon/jsp/error.jsp?err_num="+error  ;
            return false;
        }
    }
    else {
        return true;
    }
}