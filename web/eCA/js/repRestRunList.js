function reset() {
	
	if(f_query_add_mod.document.repSection){
	f_query_add_mod.document.repSection.reset() ;
	}
	if(f_query_add_mod.document.repNoteType){
	f_query_add_mod.document.repNoteType.reset() ;
	}
	if(f_query_add_mod.document.repTextBlock){
	f_query_add_mod.document.repTextBlock.reset() ;
	}
/*	if(f_query_add_mod.document.repdiaggroup){
	f_query_add_mod.document.repdiaggroup.reset() ;
	}
	if(f_query_add_mod.document.repdiaggroupdet){
	f_query_add_mod.document.repdiaggroupdet.reset() ;
	}
	if(f_query_add_mod.document.rephighrisk){
	f_query_add_mod.document.rephighrisk.reset() ;
	}
	if(f_query_add_mod.document.repnotessection){
	f_query_add_mod.document.repnotessection.reset() ;
	}
	if(f_query_add_mod.document.reprhesusfactor){
	f_query_add_mod.document.reprhesusfactor.reset() ;
	}
	if(f_query_add_mod.document.reptabulationlist){
	f_query_add_mod.document.reptabulationlist.reset() ;
	}
	if(f_query_add_mod.document.repaccessright){
	f_query_add_mod.document.repaccessright.reset() ;
	}
	if(f_query_add_mod.document.repicdcode){
	f_query_add_mod.document.repicdcode.reset() ;
	}
	if(f_query_add_mod.document.repNotifiableDiseaseVisitForm){
	f_query_add_mod.document.repNotifiableDiseaseVisitForm.reset() ;
	}
*/
}//e.o.reset

function run()
{
if(f_query_add_mod.document.repSection)
{
	if( f_query_add_mod.CheckString('Section', f_query_add_mod.document.repSection.sec_hdg_code_from,f_query_add_mod.document.repSection.sec_hdg_code_to, messageFrame )  )
	f_query_add_mod.document.repSection.submit() ;
}


if(f_query_add_mod.document.repNoteType){
if( f_query_add_mod.CheckString('Note Type', f_query_add_mod.document.repNoteType.note_type_from,f_query_add_mod.document.repNoteType.note_type_to, messageFrame )  )
f_query_add_mod.document.repbloodgroup.submit() ;
}

if(f_query_add_mod.document.repTextBlock){
if( f_query_add_mod.CheckString('Text Block', f_query_add_mod.document.repTextBlock.text_blk_code_from,f_query_add_mod.document.repTextBlock.text_blk_code_to, messageFrame )  )
f_query_add_mod.document.repcptcode.submit() ;
}
/*
if(f_query_add_mod.document.repdiaggroup){
if( f_query_add_mod.CheckString('Custom Diagnosis Group ', f_query_add_mod.document.repdiaggroup.p_fm_daig_code,f_query_add_mod.document.repdiaggroup.p_to_daig_code, messageFrame )  )
f_query_add_mod.document.repdiaggroup.submit() ;
}

if(f_query_add_mod.document.repdiaggroupdet){
if( f_query_add_mod.CheckString('Custom Diagnosis Group Details', f_query_add_mod.document.repdiaggroupdet.p_fm_diag_group_code,f_query_add_mod.document.repdiaggroupdet.p_to_diag_group_code, messageFrame )  )
f_query_add_mod.document.repdiaggroupdet.submit() ;
}

if(f_query_add_mod.document.rephighrisk){
if( f_query_add_mod.CheckString('High Risk ', f_query_add_mod.document.rephighrisk.p_fm_risk_code,f_query_add_mod.document.rephighrisk.p_to_risk_code, messageFrame )  )
f_query_add_mod.document.rephighrisk.submit() ;
}

if(f_query_add_mod.document.repnotessection){
if( f_query_add_mod.CheckString('Notes Section Heading', f_query_add_mod.document.repnotessection.p_fm_sec_hgd,f_query_add_mod.document.repnotessection.p_to_sec_hgd, messageFrame )  )
f_query_add_mod.document.repnotessection.submit() ;
}

if(f_query_add_mod.document.reprhesusfactor){
if( f_query_add_mod.CheckString('Rhesus Factor Code', f_query_add_mod.document.reprhesusfactor.p_fm_rhesus_code,f_query_add_mod.document.reprhesusfactor.p_to_rhesus_code, messageFrame )  )
f_query_add_mod.document.reprhesusfactor.submit() ;
}

if(f_query_add_mod.document.reptabulationlist){
if( f_query_add_mod.CheckString('Tabulation List Code', f_query_add_mod.document.reptabulationlist.p_fm_tab_list,f_query_add_mod.document.reptabulationlist.p_to_tab_list, messageFrame )  )
f_query_add_mod.document.reptabulationlist.submit() ;
}

if(f_query_add_mod.document.repaccessright){
if( f_query_add_mod.CheckString('User Access Rights ', f_query_add_mod.document.repaccessright.p_fm_appl_user_id,f_query_add_mod.document.repaccessright.p_to_appl_user_id, messageFrame )  )
if( f_query_add_mod.CheckString('User Access Rights ', f_query_add_mod.document.repaccessright.p_fm_facility_id,f_query_add_mod.document.repaccessright.p_to_facility_id, messageFrame )  )
f_query_add_mod.document.repaccessright.submit() ;
}


if(f_query_add_mod.document.repicdcode){

if( f_query_add_mod.CheckString('Tabulation List Code', f_query_add_mod.document.repicdcode.p_fm_tab_list,f_query_add_mod.document.repicdcode.p_to_tab_list, messageFrame )  )
if( f_query_add_mod.CheckString('Diagnosis Code', f_query_add_mod.document.repicdcode.p_fm_diag_code,f_query_add_mod.document.repicdcode.p_to_diag_code, messageFrame )  )
f_query_add_mod.document.repicdcode.submit() ;
}

if(f_query_add_mod.document.repNotifiableDiseaseVisitForm){

if( f_query_add_mod.CheckString('Dignosis Code', f_query_add_mod.document.repNotifiableDiseaseVisitForm.p_fm_diag_code,f_query_add_mod.document.repNotifiableDiseaseVisitForm.p_to_diag_code, messageFrame )  )
if( f_query_add_mod.CheckString('Facility ID', f_query_add_mod.document.repNotifiableDiseaseVisitForm.p_fm_facility_id,f_query_add_mod.document.repNotifiableDiseaseVisitForm.p_to_facility_id, messageFrame )  )
if( f_query_add_mod.CheckString('Clinic Code', f_query_add_mod.document.repNotifiableDiseaseVisitForm.p_fm_clinic_code,f_query_add_mod.document.repNotifiableDiseaseVisitForm.p_to_clinic_code, messageFrame )  )
if( f_query_add_mod.CheckString('Practitioner ID', f_query_add_mod.document.repNotifiableDiseaseVisitForm.p_fm_pract_id,f_query_add_mod.document.repNotifiableDiseaseVisitForm.p_to_pract_id, messageFrame )  )
if(f_query_add_mod.doDateCheck(f_query_add_mod.document.repNotifiableDiseaseVisitForm.p_fm_diag_date,f_query_add_mod.document.repNotifiableDiseaseVisitForm.p_to_diag_date,messageFrame))
f_query_add_mod.document.repNotifiableDiseaseVisitForm.submit() ;
}
*/
}//e.o.run

