function reset() {
	f_query_add_mod.document.repMthlyBabyBorn.reset() ;
}

function run() 
{

	var fields = new Array( f_query_add_mod.document.repMthlyBabyBorn.p_range_id ,f_query_add_mod.document.repMthlyBabyBorn.p_fr_birth_date,
                            f_query_add_mod.document.repMthlyBabyBorn.p_to_birth_date );

    var names = new Array(getLabel('Common.AgeRange.label','common'),getLabel('Common.month.label','common')+" "+getLabel('Common.from.label','common'), getLabel('Common.month.label','common')+" "+getLabel('Common.to.label','common'));
    if(f_query_add_mod.checkFields( fields, names, messageFrame))
	{
		var from = f_query_add_mod.document.repMthlyBabyBorn.p_fr_birth_date;
		var to     = f_query_add_mod.document.repMthlyBabyBorn.p_to_birth_date ;  

		if( f_query_add_mod.doDateChkWithLabel(from , to, messageFrame, 'MY', getLabel('Common.month.label','common'))) 
			f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp"; 
			f_query_add_mod.document.forms[0].target="messageFrame";
			f_query_add_mod.document.repMthlyBabyBorn.submit() ;
	}

}

