function reset() {
	f_query_add_mod.document.repPurgeAudit.reset() ;
}

function run() 
{
	var fields = new Array( f_query_add_mod.document.repPurgeAudit.P_PURGED_FROM_DATE,
                            f_query_add_mod.document.repPurgeAudit.P_PURGED_TO_DATE );

    var names = new Array( getLabel('eMP.PurgedDateFrom.label','MP'), getLabel('eMP.PurgedDateTo.label','MP'));
    if(f_query_add_mod.checkFields( fields, names, messageFrame))
	{
    	if( f_query_add_mod.doDateCheckMsg( f_query_add_mod.document.repPurgeAudit.P_PURGED_FROM_DATE, f_query_add_mod.document.repPurgeAudit.P_PURGED_TO_DATE, messageFrame,'DMY' ))	
		{
			f_query_add_mod.document.forms[0].action="../../eCommon/jsp/report_options.jsp";
			f_query_add_mod.document.forms[0].target="messageFrame";		
			f_query_add_mod.document.repPurgeAudit.submit() ;
		}
	}
}
