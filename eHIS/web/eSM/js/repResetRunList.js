function reset() 
{
	menuFrame.location.href='../../eSM/jsp/repSmMastListForm.jsp'
	f_query_add_mod.location.href='../../eCommon/html/blank.html'

	
}//e.o.reset



function run() 
{

if(f_query_add_mod.document.repFunctionList)
{
	if( f_query_add_mod.CheckString1('Module', f_query_add_mod.document.repFunctionList.p_from_function_id,f_query_add_mod.document.repFunctionList.p_to_function_id, messageFrame )  )
	f_query_add_mod.document.repFunctionList.submit() ;
}
}//e.o.run