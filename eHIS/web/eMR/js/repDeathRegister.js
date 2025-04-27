function reset() {
	if(f_query_add_mod.document.DeathRegister)
	{
		f_query_add_mod.document.DeathRegister.reset() ;
		
	}
}


function run()
{
	if (f_query_add_mod.document.DeathRegister)
	{
		if (f_query_add_mod.CheckString(getLabel("eMR.DeathDate.label","MR"), f_query_add_mod.document.DeathRegister.date_from,f_query_add_mod.document.DeathRegister.date_to, messageFrame))
		if (f_query_add_mod.CheckString(getLabel("Common.nursingUnit.label","Common"), f_query_add_mod.document.DeathRegister.p_fm_care_code,f_query_add_mod.document.DeathRegister.p_to_care_code, messageFrame))
		if (f_query_add_mod.CheckString(getLabel("Common.speciality.label","Common")+' '+getLabel("Common.code.label","Common"), f_query_add_mod.document.DeathRegister.p_fm_specialty_code,f_query_add_mod.document.DeathRegister.p_to_specialty_code, messageFrame))
			{f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
		    f_query_add_mod.document.forms[0].target="messageFrame";	
			f_query_add_mod.document.DeathRegister.submit() ;}
	}
}

