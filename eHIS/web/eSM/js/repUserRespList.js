function reset() 
{
f_query_add_mod.location.href='../../eSM/jsp/repRespuserListFormMain.jsp'
f_query_add_mod1.location.href='../../eCommon/html/blank.html'

}
function run() {
	if(f_query_add_mod1.document.repUserList)
		{
		if( f_query_add_mod1.document.repUserList.p_report_id.value=="SMBFUNUR" &&  f_query_add_mod1.CheckString1('User Id ', f_query_add_mod1.document.repUserList.p_from_appl_user_id, f_query_add_mod1.document.repUserList.p_to_appl_user_id, messageFrame ))
	   		f_query_add_mod1.document.repUserList.submit() ;
	   		if(f_query_add_mod1.document.repUserList.p_report_id.value=="SMBFUNRE" && f_query_add_mod1.CheckString1('Resp Id ', f_query_add_mod1.document.repUserList.p_from_resp_id, f_query_add_mod1.document.repUserList.p_to_resp_id, messageFrame ))  
		
			f_query_add_mod1.document.repUserList.submit() ;
	 }		
	
}