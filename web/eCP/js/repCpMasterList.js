//This file is saved on 18/10/2005


function codeCheck(Obj){
var u=Obj;
//alert("U "+u);
if(u==' '){
parent.f_query_add_mod.location.href='../../eCommon/html/blank.html';
}
else
if(u=='MR_FACTOR'){
parent.f_query_add_mod.location.href ="../../eCP/jsp/repFactorList.jsp";
}
else
if(u=='MR_ACCURACY'){
parent.f_query_add_mod.location.href ="../../eCP/jsp/repAccuracyList.jsp";
}
else
if(u=='CA_INTERVENTION_TYPE'){
	
parent.f_query_add_mod.location.href ="../../eCP/jsp/repInterventionTypeList.jsp";
}
else
if(u=='CP_STAGE'){
parent.f_query_add_mod.location.href ="../../eCP/jsp/repStageList.jsp";
}
else
if(u=='CP_OUTCOME'){
parent.f_query_add_mod.location.href ="../../eCP/jsp/repOutcomeList.jsp";
}
else
if(u=='CP_ASSESS_CATG'){
parent.f_query_add_mod.location.href ="../../eCP/jsp/repAssessmentCategoryList.jsp";
}
else
if(u=='MR_EPISODE_OF_CARE'){
parent.f_query_add_mod.location.href ="../../eCP/jsp/repEpisodeOfCareList.jsp";
}
else
if(u=='CP_DEPENDENCY'){
parent.f_query_add_mod.location.href ="../../eCP/jsp/repDependency.jsp";
}
else
if(u=='CP_REASON'){
parent.f_query_add_mod.location.href ="../../eCP/jsp/repReasonList.jsp";
}
else
if(u=='MR_TERM_SET_FOR_FACILITY'){
parent.f_query_add_mod.location.href ="../../eCP/jsp/repTerminologySetForFacility.jsp";

}
else
if(u=='MR_TERM_SET_FOR_PRACT'){
parent.f_query_add_mod.location.href ="../../eCP/jsp/repTerminologySetForPractitioner.jsp";

}
else
if(u=='MR_TERM_SET_FOR_PRACT_TYPE'){
parent.f_query_add_mod.location.href ="../../eCP/jsp/repTerminologySetForPractitionerType.jsp";
}
else
if(u=='MR_TERM_SET_FOR_SPECIALTY'){
parent.f_query_add_mod.location.href ="../../eCP/jsp/repTerminologySetForSpecialty.jsp";
}
else
if(u=='MR_AGE_GRP_FOR_TERM_CODE'){
parent.f_query_add_mod.location.href ="../../eCP/jsp/repAgeGroupForTermCode.jsp";
}
else
if(u=='CA_AGE_GRP_FOR_INTERVENTION'){
parent.f_query_add_mod.location.href ="../../eCP/jsp/repAgeGroupForIntervention.jsp";
}
else
if(u=='CP_CASE_TYPE'){
parent.f_query_add_mod.location.href ="../../eCP/jsp/repCaseTypeList.jsp";
}
else
if(u=='CP_TERM_CODE_FOR_CASE_TYPE'){
parent.f_query_add_mod.location.href ="../../eCP/jsp/repTermCodeForCaseType.jsp";
}
else
if(u=='CP_PAT_CLASS_FOR_STAGE'){
parent.f_query_add_mod.location.href ="../../eCP/jsp/repPatientClassForStageList.jsp";
}
else
if(u=='CP_LIBRARY'){
parent.f_query_add_mod.location.href ="../../eCP/jsp/repLibraryList.jsp";
}
else
if(u=='CP_CASE_TYPE_FOR_LIBRARY'){
parent.f_query_add_mod.location.href ="../../eCP/jsp/repLibraryForCaseTypeList.jsp";
}
else
if(u=='CP_ASSESS_NOTE'){
parent.f_query_add_mod.location.href ="../../eCP/jsp/repAssessmentNoteList.jsp";
}
//else
//if(u=='CP_ASSESS_NOTE_SPLTY'){
//parent.f_query_add_mod.location.href ="../../eCP/jsp/repSpecialtyForAssessmentNoteList.jsp";
//}
else
if((u=='CP_ASSESS_NOTE_PRACT_TYPE')||(u=='CP_ASSESS_NOTE_AGE_GROUP')||(u=='CP_ASSESS_NOTE_ASSESS_CATG')||(u=='CP_TRGD_DEP_CLSFN_AT_ASSMT')||(u=='CP_ASSESS_CRIT')||(u=='CP_ASSESS_NUM_CRIT_SCORE')||(u=='CP_ASSESS_NOTE_SPLTY')){
parent.f_query_add_mod.location.href ="../../eCP/jsp/repPractTypeForAssessmentNoteList.jsp?mainValue="+u;
}
else
if(u=='CP_VARIANCE_CAUSE'){
parent.f_query_add_mod.location.href ="../../eCP/jsp/repVarianceCauseList.jsp";
}
else
if(u=='CP_TRGD_TERM_CODE_AT_ASSMT'){
//alert("inside");
parent.f_query_add_mod.location.href ="../../eCP/jsp/repAssessmentCriteriaScoreList.jsp?mainValue="+u;
}
else
if(u=='CP_VARIANCE_REASON'){
parent.f_query_add_mod.location.href ="../../eCP/jsp/repVarianceReasonList.jsp";
}
else
if(u=='CA_INTERVENTION_FOR_POSN'){
parent.f_query_add_mod.location.href ="../../eCP/jsp/repPositionForIntervention.jsp";
}
else
if((u=='CA_INTERVENTION')||(u=='CA_INTERVENTION_FREQ')|| (u=='CA_PAT_CLASS_INTERVENTION')){
parent.f_query_add_mod.location.href ="../../eCP/jsp/repInterventionList.jsp?mainValue="+u;
}
//else
//if((u=='CP_ASSESS_CRIT')||(u=='CP_ASSESS_NUM_CRIT_SCORE')){
//parent.f_query_add_mod.location.href ="../../eCP/jsp/repAssessmentCriteriaScoreList.jsp?mainValue="+u;
//}
parent.messageFrame.location.href = "../../eCommon/jsp/error.jsp";
} 


function reset() 
{
	f_query_add_mod.document.forms[0].reset() ;
}	//e.o.reset


function run() 
{
//	alert(f_query_add_mod.document.forms[0].p_report_id.value);
	
	if(f_query_add_mod.document.repAccuracyForm)
		
	{
		if( f_query_add_mod.CheckString('Accuracy', f_query_add_mod.document.repAccuracyForm.p_Accuracy_code_from,f_query_add_mod.document.repAccuracyForm.p_Accuracy_code_to, messageFrame )  )
			f_query_add_mod.document.repAccuracyForm.submit() ;
	}

	else if(f_query_add_mod.document.repAssessmentForm)
	{
		if( f_query_add_mod.CheckString('Assessment', f_query_add_mod.document.repAssessmentForm.p_Assessment_code_from,f_query_add_mod.document.repAssessmentForm.p_Assessment_code_to, messageFrame )  )
			f_query_add_mod.document.repAssessmentForm.submit() ;
	}
	else if(f_query_add_mod.document.repDEPENDENCYForm)
	{
		if( f_query_add_mod.CheckString('DEPENDENCY', f_query_add_mod.document.repDEPENDENCYForm.p_DEPENDENCY_code_from,f_query_add_mod.document.repDEPENDENCYForm.p_DEPENDENCY_code_to, messageFrame )  )
			f_query_add_mod.document.repDEPENDENCYForm.submit() ;
	}
	else if(f_query_add_mod.document.repEpisodeofCareForm)
	{
		if( f_query_add_mod.CheckString('EpisodeofCare', f_query_add_mod.document.repEpisodeofCareForm.p_Episodeofcare_code_from,f_query_add_mod.document.repEpisodeofCareForm.p_Episodeofcare_code_to, messageFrame )  )
			f_query_add_mod.document.repEpisodeofCareForm.submit() ;
	}
	else if(f_query_add_mod.document.repFactorListForm)
	{
		if( f_query_add_mod.CheckString('Factor', f_query_add_mod.document.repFactorListForm.p_factor_code_from,f_query_add_mod.document.repFactorListForm.p_factor_code_to, messageFrame )  )
			f_query_add_mod.document.repFactorListForm.submit() ;
	}
	else if(f_query_add_mod.document.repInterventionTypeForm)
	{
		if( f_query_add_mod.CheckString('Intervention Type', f_query_add_mod.document.repInterventionTypeForm.p_intervention_code_from,f_query_add_mod.document.repInterventionTypeForm.p_intervention_code_to, messageFrame )  )
			f_query_add_mod.document.repInterventionTypeForm.submit() ;
	}
	else if(f_query_add_mod.document.repOutcomeForm)
	{
		if( f_query_add_mod.CheckString('Outcome', f_query_add_mod.document.repOutcomeForm.p_Outcome_code_from,f_query_add_mod.document.repOutcomeForm.p_Outcome_code_to, messageFrame )  )
			f_query_add_mod.document.repOutcomeForm.submit() ;
	}
	else if(f_query_add_mod.document.repReasonForm)
	{
		if( f_query_add_mod.CheckString('Reason', f_query_add_mod.document.repReasonForm.p_Reason_code_from,f_query_add_mod.document.repReasonForm.p_Reason_code_to, messageFrame )  )
			f_query_add_mod.document.repReasonForm.submit() ;
	}
	else if(f_query_add_mod.document.repStageListForm)
	{
		if( f_query_add_mod.CheckString('Stage', f_query_add_mod.document.repStageListForm.p_stage_code_from,f_query_add_mod.document.repStageListForm.p_stage_code_to, messageFrame )  )
			f_query_add_mod.document.repStageListForm.submit() ;
	}
	else if(f_query_add_mod.document.repTerminologySetForFacilityForm)
	{
		if( f_query_add_mod.CheckString('Terminology Set For Facility', f_query_add_mod.document.repTerminologySetForFacilityForm.p_TerminologySet_code_from,f_query_add_mod.document.repTerminologySetForFacilityForm.p_TerminologySet_code_to, messageFrame )  )
			f_query_add_mod.document.repTerminologySetForFacilityForm.submit() ;
	}
	else if(f_query_add_mod.document.repTerminologySetForPractitionerForm)
	{
		if( f_query_add_mod.CheckString(' Practitioner', f_query_add_mod.document.repTerminologySetForPractitionerForm.p_Practitioner_code_from,f_query_add_mod.document.repTerminologySetForPractitionerForm.p_Practitioner_code_to, messageFrame )  )
        if( f_query_add_mod.CheckString('TerminologySet For Practitioner', f_query_add_mod.document.repTerminologySetForPractitionerForm.p_TerminologySet_code_from,f_query_add_mod.document.repTerminologySetForPractitionerForm.p_TerminologySet_code_to, messageFrame )  )
			f_query_add_mod.document.repTerminologySetForPractitionerForm.submit() ;
	}
	else if(f_query_add_mod.document.repPractitionerTypeForm)
	{
		if( f_query_add_mod.CheckString(' Practitioner Type', f_query_add_mod.document.repPractitionerTypeForm.p_Practtype_code_from,f_query_add_mod.document.repPractitionerTypeForm.p_Practtype_code_to, messageFrame )  )
        if( f_query_add_mod.CheckString('TerminologySet For Practitioner Type', f_query_add_mod.document.repPractitionerTypeForm.p_TerminologySet_code_from,f_query_add_mod.document.repPractitionerTypeForm.p_TerminologySet_code_to, messageFrame )  )
			f_query_add_mod.document.repPractitionerTypeForm.submit() ;
	}
	else if(f_query_add_mod.document.repTerminologySetForSpecialityForm)
	{
		if( f_query_add_mod.CheckString(' TerminologySet For Speciality', f_query_add_mod.document.repTerminologySetForSpecialityForm.p_TerminologySet_code_from,f_query_add_mod.document.repTerminologySetForSpecialityForm.p_TerminologySet_code_to, messageFrame )  )
        if( f_query_add_mod.CheckString('Speciality', f_query_add_mod.document.repTerminologySetForSpecialityForm.p_Speciality_code_from,f_query_add_mod.document.repTerminologySetForSpecialityForm.p_Speciality_code_to, messageFrame )  )
			f_query_add_mod.document.repTerminologySetForSpecialityForm.submit() ;
	}
	else if(f_query_add_mod.document.repAgeGroupForTermCodeForm)
	{
		if( f_query_add_mod.CheckString(' Age Group', f_query_add_mod.document.repAgeGroupForTermCodeForm.p_agegroup_code_from,f_query_add_mod.document.repAgeGroupForTermCodeForm.p_agegroup_code_to, messageFrame )  )
        if( f_query_add_mod.CheckString('Terminology Set ', f_query_add_mod.document.repAgeGroupForTermCodeForm.p_TerminologySet_code_from,f_query_add_mod.document.repAgeGroupForTermCodeForm.p_TerminologySet_code_to, messageFrame )  )
			f_query_add_mod.document.repAgeGroupForTermCodeForm.submit() ;
	}
	else if(f_query_add_mod.document.repAgeGroupForInterventionForm)
	{
		if( f_query_add_mod.CheckString(' Age Group', f_query_add_mod.document.repAgeGroupForInterventionForm.p_agegroup_code_from,f_query_add_mod.document.repAgeGroupForInterventionForm.p_agegroup_code_to, messageFrame )  )
        if( f_query_add_mod.CheckString('Intervention', f_query_add_mod.document.repAgeGroupForInterventionForm.p_Intervention_code_from,f_query_add_mod.document.repAgeGroupForInterventionForm.p_Intervention_code_to, messageFrame )  )
			f_query_add_mod.document.repAgeGroupForInterventionForm.submit() ;
	}
	else if(f_query_add_mod.document.repPostionForInterventionForm)
	{
		if( f_query_add_mod.CheckString(' Position', f_query_add_mod.document.repPostionForInterventionForm.p_Position_code_from,f_query_add_mod.document.repPostionForInterventionForm.p_Position_code_to, messageFrame )  )
        if( f_query_add_mod.CheckString('Intervention', f_query_add_mod.document.repPostionForInterventionForm.p_Intervention_code_from,f_query_add_mod.document.repPostionForInterventionForm.p_Intervention_code_to, messageFrame )  )
			f_query_add_mod.document.repPostionForInterventionForm.submit() ;
	}
	else if(f_query_add_mod.document.repPractTypeForAssessmentNoteList)
	{
		var displayname = "Assessment Note";
		//alert(f_query_add_mod.document.repPractTypeForAssessmentNoteList.p_report_id.value);
		if( f_query_add_mod.CheckString(displayname, f_query_add_mod.document.repPractTypeForAssessmentNoteList.p_Assess_note_from,f_query_add_mod.document.repPractTypeForAssessmentNoteList.p_Assess_note_to, messageFrame )  )
			f_query_add_mod.document.repPractTypeForAssessmentNoteList.submit() ;
	}
	else if(f_query_add_mod.document.repAssessmentCriteriaScoreList)
	{
		if( f_query_add_mod.CheckString('Assessment Note', f_query_add_mod.document.repAssessmentCriteriaScoreList.p_Assess_note_from,f_query_add_mod.document.repAssessmentCriteriaScoreList.p_Assess_note_to, messageFrame )  )
		if( f_query_add_mod.CheckString('Assessment Category', f_query_add_mod.document.repAssessmentCriteriaScoreList.p_Assess_catg_from,f_query_add_mod.document.repAssessmentCriteriaScoreList.p_Assess_catg_to, messageFrame )  )
			f_query_add_mod.document.repAssessmentCriteriaScoreList.submit() ;
	}
	else if(f_query_add_mod.document.repCaseTypeForm)
	{
		if( f_query_add_mod.CheckString('CaseType', f_query_add_mod.document.repCaseTypeForm.p_case_type_from,f_query_add_mod.document.repCaseTypeForm.p_case_type_to, messageFrame )  )
			f_query_add_mod.document.repCaseTypeForm.submit() ;
	}
	else if(f_query_add_mod.document.repAssessmentNoteForm)
	{
		if( f_query_add_mod.CheckString('Assessment Note', f_query_add_mod.document.repAssessmentNoteForm.p_Note_from,f_query_add_mod.document.repAssessmentNoteForm.p_Note_to, messageFrame )  )
			f_query_add_mod.document.repAssessmentNoteForm.submit() ;
	}
	else if(f_query_add_mod.document.repVarianceCauseForm)
	{
		if( f_query_add_mod.CheckString('Variance Cause', f_query_add_mod.document.repVarianceCauseForm.p_variancecause_from,f_query_add_mod.document.repVarianceCauseForm.p_variancecause_to, messageFrame )  )
			f_query_add_mod.document.repVarianceCauseForm.submit() ;
	}
	else if(f_query_add_mod.document.repVarianceReasonForm)
	{
		if( f_query_add_mod.CheckString('Variance Reason', f_query_add_mod.document.repVarianceReasonForm.p_variancereason_from,f_query_add_mod.document.repVarianceReasonForm.p_variancereason_to, messageFrame )  )
			f_query_add_mod.document.repVarianceReasonForm.submit() ;
	}
	else if(f_query_add_mod.document.repPatclassforStageForm)
	{
		if( f_query_add_mod.CheckString('Patient Class for Stage', f_query_add_mod.document.repPatclassforStageForm.p_stage_from,f_query_add_mod.document.repPatclassforStageForm.p_stage_to, messageFrame )  )
			f_query_add_mod.document.repPatclassforStageForm.submit() ;
	}
	else if(f_query_add_mod.document.repLibraryforCasetypeForm)
	{
		if( f_query_add_mod.CheckString('Library for CaseType', f_query_add_mod.document.repLibraryforCasetypeForm.p_case_type_from,f_query_add_mod.document.repLibraryforCasetypeForm.p_case_type_to, messageFrame )  )
			f_query_add_mod.document.repLibraryforCasetypeForm.submit() ;
	}
	else if(f_query_add_mod.document.repLibraryForm)
	{
		if( f_query_add_mod.CheckString('Library', f_query_add_mod.document.repLibraryForm.p_Library_from,f_query_add_mod.document.repLibraryForm.p_Library_to, messageFrame )  )
			f_query_add_mod.document.repLibraryForm.submit() ;
	}
	else if(f_query_add_mod.document.repInterventionForm)
	{
		if( f_query_add_mod.CheckString('Intervention', f_query_add_mod.document.repInterventionForm.p_from_intervention_code,f_query_add_mod.document.repInterventionForm.p_to_intervention_code, messageFrame )  )
			f_query_add_mod.document.repInterventionForm.submit() ;
	}
	else if(f_query_add_mod.document.repAssessmentCategoryScoreListform)
	{
		//alert("inside");
		if( f_query_add_mod.CheckString('Assessment Category', f_query_add_mod.document.repAssessmentCategoryScoreListform.p_Assess_note_from,f_query_add_mod.document.repAssessmentCategoryScoreListform.p_Assess_note_to, messageFrame )  )
			f_query_add_mod.document.repAssessmentCategoryScoreListform.submit() ;
	}
	else if(f_query_add_mod.document.repSpecialityforAssessmentNoteForm)
	{
		//alert("inside");
		if( f_query_add_mod.CheckString('Assessment Note', f_query_add_mod.document.repSpecialityforAssessmentNoteForm.p_Note_from,f_query_add_mod.document.repSpecialityforAssessmentNoteForm.p_Note_to, messageFrame )  )
			f_query_add_mod.document.repSpecialityforAssessmentNoteForm.submit() ;
	}
	else if(f_query_add_mod.document.repTermcodeforCasetypeForm)
	{
		//alert("inside");
		if( f_query_add_mod.CheckString('Case Type', f_query_add_mod.document.repTermcodeforCasetypeForm.p_case_type_from,f_query_add_mod.document.repTermcodeforCasetypeForm.p_case_type_to, messageFrame )  )
			f_query_add_mod.document.repTermcodeforCasetypeForm.submit() ;
	}
}//e.o.run
