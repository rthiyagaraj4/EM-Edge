function reset() {
	f_query_add_mod.document.repRespList.reset() ;
}

function run() 
{
	if( f_query_add_mod.CheckString1( 'Responsibility ID',f_query_add_mod.document.repRespList.p_from_resp_id, f_query_add_mod.document.repRespList.p_to_resp_id, messageFrame ) ) 
	{
			f_query_add_mod.document.repRespList.submit() ;
	}	
}