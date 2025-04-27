function reset() {
	
	  if(parent.frames[2].frames[1]){
	   parent.frames[2].frames[1].location.reload() ;
	 }

	if(f_query_add_mod.document.repBedBayList){
	   f_query_add_mod.document.repBedBayList.reset() ;
	}
	if(f_query_add_mod.document.repBedorbay){
	   f_query_add_mod.document.repBedorbay.reset() ;
	}
	if(f_query_add_mod.document.repBedsForTreatmentAreaList){
	   f_query_add_mod.document.repBedsForTreatmentAreaList.reset() ;
	}
	if(f_query_add_mod.document.repInjurySubcategoryList){
	   f_query_add_mod.document.repInjurySubcategoryList.reset() ;
	}  
	
		if(f_query_add_mod.document.repinjurycategory){
	   f_query_add_mod.document.repinjurycategory.reset() ;
	}
	if(f_query_add_mod.document.repImmobilizationCodeList){
	   f_query_add_mod.document.repImmobilizationCodeList.reset() ;
	}
	//********* DISASTER TYPE ********************
	if(f_query_add_mod.document.repDisasterCodeList){ 
	   f_query_add_mod.document.repDisasterCodeList.reset() ;
	}

	if(f_query_add_mod.document.repPatPositionList){
	   f_query_add_mod.document.repPatPositionList.reset() ;
	}
	if(f_query_add_mod.document.repProtectiveDeviceList){
	   f_query_add_mod.document.repProtectiveDeviceList.reset() ;
	}
	if(f_query_add_mod.document.repPatPriorityList){
	   f_query_add_mod.document.repPatPriorityList.reset() ;
	}
	if(f_query_add_mod.document.repGCSResponseList){
	   f_query_add_mod.document.repGCSResponseList.reset() ;
	}
	if(f_query_add_mod.document.repGCSResponseScoreList){
	   f_query_add_mod.document.repGCSResponseScoreList.reset() ;
	}
	if(f_query_add_mod.document.repGCSforResponseList){
	   f_query_add_mod.document.repGCSforResponseList.reset() ;
	}
	if(f_query_add_mod.document.repTreatmentAreaforClinicList){
	   f_query_add_mod.document.repTreatmentAreaforClinicList.reset() ;
	}
	if(f_query_add_mod.document.repPractitionerforTreatmentAreaList){
	   f_query_add_mod.document.repPractitionerforTreatmentAreaList.reset() ;	   
	}


}//e.o.reset

function run() 
{
	
if(f_query_add_mod.document.repBedsForTreatmentAreaList){
if(( f_query_add_mod.CheckString2(getLabel("Common.ClinicCode.label","Common"), f_query_add_mod.document.repBedsForTreatmentAreaList.p_fm_clinic_code,f_query_add_mod.document.repBedsForTreatmentAreaList.p_to_clinic_code, messageFrame ) )&&( f_query_add_mod.CheckString2(getLabel("eAE.TreatmentAreaCode.label","AE"), f_query_add_mod.document.repBedsForTreatmentAreaList.p_fm_tr_area_code,f_query_add_mod.document.repBedsForTreatmentAreaList.p_to_tr_area_code, messageFrame ) )&&
( f_query_add_mod.CheckString2(getLabel("eAE.BedBayTypeCode.label","AE"), f_query_add_mod.document.repBedsForTreatmentAreaList.p_fm_bay_type,f_query_add_mod.document.repBedsForTreatmentAreaList.p_to_bay_type, messageFrame ) ) )  
	
f_query_add_mod.document.repBedsForTreatmentAreaList.submit() ;	
}
else
	if(f_query_add_mod.document.repInjurySubcategoryList){

if(( f_query_add_mod.CheckString2(getLabel("eAE.InjuryCategoryCode.label","AE"), f_query_add_mod.document.repInjurySubcategoryList.p_fm_inju_code,f_query_add_mod.document.repInjurySubcategoryList.p_to_inju_code, messageFrame ) )&&(f_query_add_mod.CheckString2(getLabel("eAE.InjurySubcategoryCode.label","AE"), f_query_add_mod.document.repInjurySubcategoryList.p_fm_injury_sub_code,f_query_add_mod.document.repInjurySubcategoryList.p_to_injury_sub_code, messageFrame) ) )  
	
f_query_add_mod.document.repInjurySubcategoryList.submit() ;	
}
else
if(f_query_add_mod.document.repBedorbay){

if(( f_query_add_mod.CheckString2(getLabel("Common.ClinicCode.label","Common"), f_query_add_mod.document.repBedorbay.p_fm_clinic_code,f_query_add_mod.document.repBedorbay.p_to_clinic_code, messageFrame ) )&&
( f_query_add_mod.CheckString2(getLabel("eAE.BedBayTypeCode.label","AE"), f_query_add_mod.document.repBedorbay.p_fm_bay_code,f_query_add_mod.document.repBedorbay.p_to_bay_code, messageFrame ) ) )  
	
f_query_add_mod.document.repBedorbay.submit() ;	
}
else
	if(f_query_add_mod.document.repinjurycategory){

if( f_query_add_mod.CheckString2(getLabel("eAE.InjuryCategoryCode.label","AE"), f_query_add_mod.document.repinjurycategory.p_fm_inju_code,f_query_add_mod.document.repinjurycategory.p_to_inju_code, messageFrame ) ) 
	f_query_add_mod.document.repinjurycategory.submit() ;	
}
else
if(f_query_add_mod.document.repBedBayList){

if( f_query_add_mod.CheckString2(getLabel("eAE.BedBayTypeCode.label","AE"), f_query_add_mod.document.repBedBayList.p_fm_bay_code,f_query_add_mod.document.repBedBayList.p_to_bay_code, messageFrame ) ) 
	f_query_add_mod.document.repBedBayList.submit() ;	
}
else
if(f_query_add_mod.document.repImmobilizationCodeList){

if( f_query_add_mod.CheckString2(getLabel("eAE.ImmobilizationCode.label","AE"), f_query_add_mod.document.repImmobilizationCodeList.p_fm_immobilization_code,f_query_add_mod.document.repImmobilizationCodeList.p_to_immobilization_code, messageFrame ) ) 
	f_query_add_mod.document.repImmobilizationCodeList.submit() ;	
}
//******************* DISASTER TYPE *********************
else
if(f_query_add_mod.document.repDisasterCodeList){

if( f_query_add_mod.CheckString2(getLabel("eAE.DisasterTypeCode.label","AE"), f_query_add_mod.document.repDisasterCodeList.p_fm_disaster_type_code,f_query_add_mod.document.repDisasterCodeList.p_to_disaster_type_code, messageFrame ) ) 
	f_query_add_mod.document.repDisasterCodeList.submit() ;	
}

else
if(f_query_add_mod.document.repPatPositionList){
if( f_query_add_mod.CheckString2(getLabel("Common.PositionCode.label","Common"), f_query_add_mod.document.repPatPositionList.p_fm_pat_position_code,f_query_add_mod.document.repPatPositionList.p_to_pat_position_code, messageFrame ) ) 
	f_query_add_mod.document.repPatPositionList.submit() ;	
}
else
if(f_query_add_mod.document.repProtectiveDeviceList){
if( f_query_add_mod.CheckString2(getLabel("eAE.ProtectiveDeviceCode.label","AE"), f_query_add_mod.document.repProtectiveDeviceList.p_fm_protective_device_code,f_query_add_mod.document.repProtectiveDeviceList.p_to_protective_device_code, messageFrame ) ) 
	f_query_add_mod.document.repProtectiveDeviceList.submit() ;	
}
else
if(f_query_add_mod.document.repPatPriorityList){
if( f_query_add_mod.CheckString2(getLabel("eAE.PatientPriorityCode.label","AE"), f_query_add_mod.document.repPatPriorityList.p_fm_priority_code,f_query_add_mod.document.repPatPriorityList.p_to_priority_code, messageFrame ) ) 
	f_query_add_mod.document.repPatPriorityList.submit() ;	
}
else
if(f_query_add_mod.document.repGCSResponseList){
if( f_query_add_mod.CheckString2(getLabel("eAE.GCSResponseCode.label","AE"), f_query_add_mod.document.repGCSResponseList.p_fm_gcs_response_code,f_query_add_mod.document.repGCSResponseList.p_to_gcs_response_code, messageFrame ) ) 
	f_query_add_mod.document.repGCSResponseList.submit() ;	
}
if(f_query_add_mod.document.repGCSResponseScoreList){
	f_query_add_mod.document.repGCSResponseScoreList.submit() ;	
}
else
if(f_query_add_mod.document.repGCSforResponseList){
if(( f_query_add_mod.CheckString2('GCS for Response Code', f_query_add_mod.document.repGCSforResponseList.p_fm_gcs_response_code,f_query_add_mod.document.repGCSforResponseList.p_to_gcs_response_code, messageFrame )) &&
( f_query_add_mod.CheckString2(getLabel("eAE.GCSCode.label","AE"), f_query_add_mod.document.repGCSforResponseList.p_fm_gcs_code,f_query_add_mod.document.repGCSforResponseList.p_to_gcs_code, messageFrame ) ) ) 
	f_query_add_mod.document.repGCSforResponseList.submit() ;	
}
if(f_query_add_mod.document.repTreatmentAreaforClinicList){
if(( f_query_add_mod.CheckString2(getLabel("Common.ClinicCode.label","Common"), f_query_add_mod.document.repTreatmentAreaforClinicList.p_fm_clinic_code,f_query_add_mod.document.repTreatmentAreaforClinicList.p_to_clinic_code, messageFrame ) ) &&
( f_query_add_mod.CheckString2(getLabel("eAE.TreatmentAreaCode.label","AE"), f_query_add_mod.document.repTreatmentAreaforClinicList.p_fm_tr_area_code,f_query_add_mod.document.repTreatmentAreaforClinicList.p_to_tr_area_code, messageFrame ) ))
	f_query_add_mod.document.repTreatmentAreaforClinicList.submit() ;	
}
if(f_query_add_mod.document.repPractitionerforTreatmentAreaList){
if(( f_query_add_mod.CheckString2(getLabel("Common.ClinicCode.label","Common"), f_query_add_mod.document.repPractitionerforTreatmentAreaList.p_fm_clinic_code,f_query_add_mod.document.repPractitionerforTreatmentAreaList.p_to_clinic_code, messageFrame ) ) &&
( f_query_add_mod.CheckString2(getLabel("eAE.TreatmentAreaCode.label","AE"), f_query_add_mod.document.repPractitionerforTreatmentAreaList.p_fm_tr_area_code,f_query_add_mod.document.repPractitionerforTreatmentAreaList.p_to_tr_area_code, messageFrame ) )&&
( f_query_add_mod.CheckString2(getLabel("Common.practitionerid.label","Common"), f_query_add_mod.document.repPractitionerforTreatmentAreaList.p_fm_practitioner_id,f_query_add_mod.document.repPractitionerforTreatmentAreaList.p_to_practitioner_id, messageFrame )))
	f_query_add_mod.document.repPractitionerforTreatmentAreaList.submit() ;	
}
}//e.o.run

function validSplchars(obj,name)
			{				
				 var fields=new Array();
				 var names=new Array();
				 fields[0]=obj;
				 names[0]=name;									
				if(SpecialCharCheck( fields, names,'',"A",''))
					return true;
				else
				{
					obj.select();
					obj.focus();
					return false;
				}
			}


