function reset()
{
	f_query_add_mod.document.RaceAgeRange.reset() ;
} 				   

function run()
{
	var fields = new Array ( f_query_add_mod.document.RaceAgeRange.p_age_range_code );
    var names = new Array ( "Age Range" );

	if(f_query_add_mod.checkFields( fields, names, messageFrame))
	{ 
		var fields = new Array( f_query_add_mod.document.RaceAgeRange.p_fm_regndate,
                           f_query_add_mod.document.RaceAgeRange.p_to_regndate );
    var names = new Array("Regn Date From", "Regn Date To");
    if(f_query_add_mod.checkFields( fields, names, messageFrame))
	{
		if( f_query_add_mod.doDateCheckMsg( f_query_add_mod.document.RaceAgeRange.p_fm_regndate, f_query_add_mod.document.RaceAgeRange.p_to_regndate, messageFrame ,'DMY' ) )
		{       
	            f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
    		    f_query_add_mod.document.forms[0].target="messageFrame";
				f_query_add_mod.document.RaceAgeRange.submit() ;
		}
	}
}
}