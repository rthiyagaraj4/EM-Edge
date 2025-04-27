function reset()
{	
	
	f_query_add_mod.document.forms[0].reset();
	f_query_add_mod.location.href ='../../eMR/jsp/Rep2MovementHistory.jsp'; // modified for ICN-64475
	

	
}//e.o.reset

function run()
{	
			
		if(f_query_add_mod.document.Rep2MovementHistForm) 
		{
			if(f_query_add_mod.document.Rep2MovementHistForm.p_encounter_id.value == "")
			{
			var err = f_query_add_mod.getMessage("CAN_NOT_BE_BLANK","common");
			err = err.replace('$',getLabel("Common.encounterid.label","Common"));
			messageFrame.location.href='../../eCommon/jsp/error.jsp?err_num='+err;
			f_query_add_mod.document.Rep2MovementHistForm.p_encounter_id.focus();
			}
			else
			{
			
			
			f_query_add_mod.document.forms[0].submit() ;
			
			}
		
		}
	
}//e.o.run

