function reset() {
	f_query_add_mod.location.href='../../eCommon/html/blank.html';
   frames[1].document.location.reload();
	//if(f_query_add_mod.document.repTimeTableList){
	//					f_query_add_mod.document.repTimeTableList.reset() ;
//	}
}//e.o.reset

function run()
{


if(f_query_add_mod.document.repTimeTableList){
if( f_query_add_mod.CheckString(getLabel("Common.locationcode.label","Common"), f_query_add_mod.document.repTimeTableList.p_fm_clinic_code,f_query_add_mod.document.repTimeTableList.p_to_clinic_code, messageFrame )  )
if( f_query_add_mod.CheckString(getLabel("Common.resourceid.label","Common"), f_query_add_mod.document.repTimeTableList.p_fm_pract_id,f_query_add_mod.document.repTimeTableList.p_to_pract_id, messageFrame )  )
f_query_add_mod.document.repTimeTableList.submit() ;
}



}//e.o.run
