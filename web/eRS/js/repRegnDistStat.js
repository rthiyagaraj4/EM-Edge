function reset() {
	f_query_add_mod.document.repRegnDistStat.reset() ;
}

function run() 
{
	var fields = new Array( f_query_add_mod.document.repRegnDistStat.p_fm_regndate,
                            f_query_add_mod.document.repRegnDistStat.p_to_regndate );

    var names = new Array("Regn Date From", "Regn Date To");
    if(f_query_add_mod.checkFields( fields, names, messageFrame))
	{
		if( f_query_add_mod.doDateCheck( f_query_add_mod.document.repRegnDistStat.p_fm_regndate, f_query_add_mod.document.repRegnDistStat.p_to_regndate, messageFrame ) ) 
		if( f_query_add_mod.CheckString('State Code',f_query_add_mod.document.repRegnDistStat.P_fm_region_code, f_query_add_mod.document.repRegnDistStat.P_to_region_code, messageFrame ) )
		if( f_query_add_mod.CheckString('District Code',f_query_add_mod.document.repRegnDistStat.P_fm_area_code, f_query_add_mod.document.repRegnDistStat.P_to_area_code, messageFrame ) )
		if( f_query_add_mod.CheckString('Town Code',f_query_add_mod.document.repRegnDistStat.P_fm_town_code, f_query_add_mod.document.repRegnDistStat.P_to_town_code, messageFrame ) )
			f_query_add_mod.document.forms[0].submit();
}
}

