
function run() {
	var names="";
	var p_language_id = f_query_add_mod.document.forms[0].p_language_id.value;
	var converDate1 = f_query_add_mod.document.forms[0].mdsfrom.value;
	f_query_add_mod.document.forms[0].P_FM_VIST_DATE.value = convertDate(converDate1,'DMY',p_language_id,'en') ;
	var converDate2 = f_query_add_mod.document.forms[0].mdsto.value;
	f_query_add_mod.document.forms[0].P_TO_VIST_DATE.value = convertDate(converDate2,'DMY',p_language_id,'en') ;
		
	var fields = new Array( f_query_add_mod.document.opPurchaseVisit.P_FM_VIST_DATE,
		    f_query_add_mod.document.opPurchaseVisit.P_TO_VIST_DATE)
	
	if(f_query_add_mod.document.forms[0].FM_VIST_DATE.value == "" || f_query_add_mod.document.forms[0].TO_VIST_DATE.value == ""){
		var names = new Array(getLabel("Common.VisitDateFrom.label","Common"), getLabel("Common.VisitDateTo.label","Common"));
	if(f_query_add_mod.checkFields( fields, names, messageFrame)) 
	{
			f_query_add_mod.document.forms[0].submit();
	}
	}else{
		f_query_add_mod.document.forms[0].submit();
		
	}

} 

function reset() 
{
	f_query_add_mod.document.forms[0].reset();
}
