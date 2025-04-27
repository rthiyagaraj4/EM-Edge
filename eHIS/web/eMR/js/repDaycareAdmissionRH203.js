function reset() {
	if(f_query_add_mod.document.repDaycareAdmissionRH203Form)
	{
	//f_query_add_mod.document.repDaycareAdmissionRH203Form.reload();
	f_query_add_mod.document.location.reload();
	}
}


function run()
{
	if (f_query_add_mod.document.repDaycareAdmissionRH203Form)
	{	 
		
		var fields = new Array(f_query_add_mod.document.repDaycareAdmissionRH203Form.p_from_date,f_query_add_mod.document.repDaycareAdmissionRH203Form.p_to_date);
		var reptype=f_query_add_mod.document.repDaycareAdmissionRH203Form.report_type.value;
		if(reptype=="M")
		{		
		var names  = new Array ( getLabel("Common.FromMonth.label","Common"),getLabel("Common.ToMonth.label","Common"));
		}
		else if(reptype=="Y")
		{
		var names  = new Array ( getLabel("eIP.FromYear.label","IP"),getLabel("eIP.ToYear.label","IP"));
		}
		if(reptype=="M")
		{					  
		var names1  = new Array ( getLabel("Common.month.label","Common"));
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		    {
        //Modified CheckString and Added the checkmonths by kamatchi S for ML-MMOH-SCF-1747
	  		 if (f_query_add_mod.checkmonths(getLabel("Common.month.label","MR"), f_query_add_mod.document.repDaycareAdmissionRH203Form.p_from_date,f_query_add_mod.document.repDaycareAdmissionRH203Form.p_to_date, messageFrame))
			if (f_query_add_mod.CheckString(getLabel("Common.NursingUnitCode.label","Common"), f_query_add_mod.document.repDaycareAdmissionRH203Form.p_fm_care_code,f_query_add_mod.document.repDaycareAdmissionRH203Form.p_to_care_code, messageFrame))
			 f_query_add_mod.document.repDaycareAdmissionRH203Form.submit() ;
			}	
		}
		else if(reptype=="Y")
		{
		var names1  = new Array ( getLabel("Common.year.label","Common"));
		if(f_query_add_mod.checkFields( fields, names, messageFrame))
		    {
			if( f_query_add_mod.CheckString( names1,f_query_add_mod.document.forms[0].p_from_date, f_query_add_mod.document.forms[0].p_to_date, messageFrame ) )			
			if (f_query_add_mod.CheckString(getLabel("Common.NursingUnitCode.label","Common"), f_query_add_mod.document.repDaycareAdmissionRH203Form.p_fm_care_code,f_query_add_mod.document.repDaycareAdmissionRH203Form.p_to_care_code, messageFrame))
		     f_query_add_mod.document.repDaycareAdmissionRH203Form.submit() ;
			}
		}	
		
	}
	/**********************/
}

