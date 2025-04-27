function run() 
{
		var fromdate = f_query_add_mod.document.forms[0].fm_date.value;
		var todate = f_query_add_mod.document.forms[0].p_to_date.value;
		f_query_add_mod.document.forms[0].P_FR_LOCN_CODE1.value = f_query_add_mod.document.forms[0].fm_locn_code.value;
		f_query_add_mod.document.forms[0].P_TO_LOCN_CODE1.value = f_query_add_mod.document.forms[0].to_locn_code.value;
		
		f_query_add_mod.document.forms[0].P_FR_PRACTITIONER_ID1.value = f_query_add_mod.document.forms[0].fm_practitioner_id.value;
		f_query_add_mod.document.forms[0].P_TO_PRACTITIONER_ID1.value = f_query_add_mod.document.forms[0].to_practitioner_id.value;   


		
		if( f_query_add_mod.doDateCheck(fromdate, todate, messageFrame ) ) 
		{
			f_query_add_mod.document.forms[0].p_date_from.value = fromdate;
			f_query_add_mod.document.forms[0].p_date_to.value = todate;
			 if(f_query_add_mod.CheckString( getLabel("Common.locationcode.label","Common"),f_query_add_mod.document.forms[0].fm_locn_code,f_query_add_mod.document.forms[0].to_locn_code,messageFrame))
	       if(f_query_add_mod.CheckString( getLabel("Common.practitionerid.label","Common"),f_query_add_mod.document.forms[0].fm_practitioner_id,f_query_add_mod.document.forms[0].to_practitioner_id,messageFrame))    
		
			  f_query_add_mod.document.forms[0].submit();
		}
	
	
}

function reset() 
{
	f_query_add_mod.document.forms[0].reset();
}


