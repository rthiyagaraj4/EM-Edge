function codeCheck(Obj){
var master_list=Obj;

if(master_list==' '){
parent.f_query_add_mod.location.href='../../eCommon/html/blank.html';
}
else
if(master_list=='RS_GRADE'){
parent.f_query_add_mod.location.href ="../../eRS/jsp/repGradeList.jsp";
}
else
if(master_list=='RS_LICENSURE'){
parent.f_query_add_mod.location.href ="../../eRS/jsp/repLicensureList.jsp";
}
else
if(master_list=='RS_LOCN_FOR_WORKPLACE'){
parent.f_query_add_mod.location.href ="../../eRS/jsp/repLocationForWorkplaceList.jsp";
}
else
if(master_list=='RS_REASON'){
parent.f_query_add_mod.location.href ="../../eRS/jsp/repReasonList.jsp";
}
else
if(master_list=='RS_SHIFT_FOR_WORKPLACE'){
parent.f_query_add_mod.location.href ="../../eRS/jsp/repShiftForWorkplaceList.jsp";
}
else
if(master_list=='RS_SHIFT_PATTERN'){
parent.f_query_add_mod.location.href ="../../eRS/jsp/repShiftPatternList.jsp";
}
else
if(master_list=='RS_SKILL'){
parent.f_query_add_mod.location.href ="../../eRS/jsp/repSkillList.jsp";
}
else
if(master_list=='RS_ACCESS_RIGHTS'){
parent.f_query_add_mod.location.href ="../../eRS/jsp/repAccessRightsList.jsp";
}
else
if(master_list=='RS_SHIFT_PATTERN_FOR_WORKPLACE'){
parent.f_query_add_mod.location.href ="../../eRS/jsp/repShiftPatternForWorkplaceList.jsp";
}
else
if(master_list=='RS_SKILL_FOR_POSITION'){
parent.f_query_add_mod.location.href ="../../eRS/jsp/repSkillForPositionList.jsp";

}
else
if(master_list=='RS_TRAINING'){
parent.f_query_add_mod.location.href ="../../eRS/jsp/repTrainingList.jsp";

}
else
if(master_list=='RS_WORKPLACE'){
parent.f_query_add_mod.location.href ="../../eRS/jsp/repWorkplaceList.jsp";
}
else
if(master_list=='RS_WORKPLACE_REQUIREMENT'){
parent.f_query_add_mod.location.href ="../../eRS/jsp/repWorkplaceRequirementList.jsp";
}
else
if(master_list=='RS_STAFF_FOR_WORKPLACE'){
parent.f_query_add_mod.location.href ="../../eRS/jsp/repStaffForWorkplaceList.jsp";
}
else
if(master_list=='RS_STAFF_PROFILE'){
parent.f_query_add_mod.location.href ="../../eRS/jsp/repStaffProfileList.jsp";
}
} 


function reset() 
{
	f_query_add_mod.document.forms[0].reset() ;
}	//e.o.reset


function run() 
{
	if(f_query_add_mod.document.form_repAccessRightsList)
		
	{
		var frmobj =f_query_add_mod.document.form_repAccessRightsList;
		if( f_query_add_mod.CheckString('Access Rights', frmobj.from_workplace_desc,frmobj.to_workplace_desc,frmobj.from_user_desc,frmobj.to_user_desc, messageFrame ) )
			frmobj.submit() ;
	}

	else if(f_query_add_mod.document.form_repGradeList)
	{
		var frmobj =f_query_add_mod.document.form_repGradeList;
		if( f_query_add_mod.CheckString('Grade', frmobj.from_grade_desc,frmobj.to_grade_desc, messageFrame )  )
		frmobj.submit() ;
	}
	else if(f_query_add_mod.document.form_repLicensureList)
	{	
		var frmobj =f_query_add_mod.document.form_repLicensureList;
		if( f_query_add_mod.CheckString('Licensure', frmobj.from_licensure_desc,frmobj.to_licensure_desc, messageFrame )  )
		frmobj.submit() ;
	}
	else if(f_query_add_mod.document.form_repLocnForWorkplaceList)
	{
			var frmobj =f_query_add_mod.document.form_repLocnForWorkplaceList;
       		if( f_query_add_mod.CheckString('Location For Workplace', frmobj.from_workplace_desc,frmobj.to_workplace_desc, messageFrame )  )
			frmobj.submit() ;
	}
	else if(f_query_add_mod.document.form_repReasonList)
	{
		var frmobj =f_query_add_mod.document.form_repReasonList;
		if( f_query_add_mod.CheckString('Reason', frmobj.from_reason_desc,frmobj.to_reason_desc, messageFrame )  )
		frmobj.submit() ;
	}
	else if(f_query_add_mod.document.form_repShiftForWorkplaceList)
	{
		var frmobj =f_query_add_mod.document.form_repShiftForWorkplaceList;
		if( f_query_add_mod.CheckString('Shift For Workplace', frmobj.from_workplace_desc,frmobj.to_workplace_desc,frmobj.from_shift_desc,frmobj.to_shift_desc, messageFrame )  )
		frmobj.submit() ;
	}
	else if(f_query_add_mod.document.form_repShiftPatternList)
	{
		var frmobj =f_query_add_mod.document.form_repShiftPatternList;
		if( f_query_add_mod.CheckString('Shift Pattern', frmobj.from_shift_pattern,frmobj.to_shift_pattern, messageFrame )  )
			frmobj.submit() ;
	}
	else if(f_query_add_mod.document.form_repShiftPatternForWorkplaceList)
	{
		var frmobj =f_query_add_mod.document.form_repShiftPatternForWorkplaceList;
		if( f_query_add_mod.CheckString('Shift Pattern For Workplace', frmobj.from_workplace_desc,frmobj.to_workplace_desc,frmobj.from_shift_desc,frmobj.to_shift_desc, messageFrame )  )
			frmobj.submit() ;
	}
	else if(f_query_add_mod.document.form_repSkillList)
	{
		var frmobj =f_query_add_mod.document.form_repSkillList;
		if( f_query_add_mod.CheckString('Skill', frmobj.from_skill_desc,frmobj.to_skill_desc, messageFrame )  )
			frmobj.submit() ;
	}
	else if(f_query_add_mod.document.form_repSkillForPositionList)
	{
		var frmobj =f_query_add_mod.document.form_repSkillForPositionList;
		if( f_query_add_mod.CheckString('Skill For Position', frmobj.from_position_desc,frmobj.to_position_desc,frmobj.from_skill_desc,frmobj.to_skill_desc, messageFrame )  )
			frmobj.submit() ;
	}
	else if(f_query_add_mod.document.form_repTrainingList)
	{
		var frmobj =f_query_add_mod.document.form_repTrainingList;
		if( f_query_add_mod.CheckString('Training', frmobj.from_training_desc,frmobj.to_training_desc, messageFrame ))
		frmobj.submit() ;
	}
	else if(f_query_add_mod.document.form_repWorkplaceList)
	{
		var frmobj =f_query_add_mod.document.form_repWorkplaceList;
		if( f_query_add_mod.CheckString('Workplace', frmobj.from_workplace_desc,frmobj.to_workplace_desc, messageFrame )  )
		frmobj.submit() ;
	}
	else if(f_query_add_mod.document.form_repWorkplaceRequirementList)
	{
		var frmobj =f_query_add_mod.document.form_repWorkplaceRequirementList;
		if( f_query_add_mod.CheckString(' Workplace Requirement', frmobj.from_workplace_desc,frmobj.to_workplace_desc, messageFrame )  )
        frmobj.submit() ;
	}
	else if(f_query_add_mod.document.form_repStaffForWorkplaceList)
	{
		var frmobj =f_query_add_mod.document.form_repStaffForWorkplaceList;
		if( f_query_add_mod.CheckString('Staff For Workplace', frmobj.from_workplace_desc,frmobj.to_workplace_desc, messageFrame )  )
		frmobj.submit() ;
	}
/*	else if(f_query_add_mod.document.repAgeGroupForInterventionForm)
	{
		//alert(f_query_add_mod.document.RepAdmissionTypeForm.p_DEPENDENCY_code_from +"\n"+f_query_add_mod.document.RepAdmissionTypeForm.p_fr_adm_type )
		if( f_query_add_mod.CheckString(' Age Group', f_query_add_mod.document.repAgeGroupForInterventionForm.p_agegroup_code_from,f_query_add_mod.document.repAgeGroupForInterventionForm.p_agegroup_code_to, messageFrame )  )
        if( f_query_add_mod.CheckString('Intervention', f_query_add_mod.document.repAgeGroupForInterventionForm.p_Intervention_code_from,f_query_add_mod.document.repAgeGroupForInterventionForm.p_Intervention_code_to, messageFrame )  )
			f_query_add_mod.document.repAgeGroupForInterventionForm.submit() ;
	}*/
			 
}//e.o.run

