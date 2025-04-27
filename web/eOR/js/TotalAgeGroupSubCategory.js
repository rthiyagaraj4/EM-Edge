/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
function reset() {
	f_query_add_mod.document.TotalAgeGroupSubCategoryForm.reset() ;
}

function run() {
			var fields = new Array ( f_query_add_mod.document.TotalAgeGroupSubCategoryForm.p_fr_order_date_time,f_query_add_mod.document.TotalAgeGroupSubCategoryForm.p_to_order_date_time);
	var names = new Array ( getLabel("eOR.FromOrderDate.label","OR"),getLabel("eOR.ToOrderDate.label","OR"));
	
if( f_query_add_mod.CheckString( 'Service Category Code',f_query_add_mod.document.forms[0].p_fr_service_category, f_query_add_mod.document.forms[0].p_to_service_category, messageFrame ) ) 
	{
	if( f_query_add_mod.CheckString( 'Service Sub-category code',f_query_add_mod.document.forms[0].p_fr_service_sub_category, f_query_add_mod.document.forms[0].p_to_service_sub_category, messageFrame ) ) 
	{
		if( f_query_add_mod.CheckString( 'Service Code',f_query_add_mod.document.forms[0].p_fr_service_code, f_query_add_mod.document.forms[0].p_to_service_code, messageFrame ) ) 
	{


	if(f_query_add_mod.checkFields( fields, names, messageFrame)) {
				f_query_add_mod.document.TotalAgeGroupSubCategoryForm.submit() ;
	}
	}
	}
	}


}
function doDateCheckForOr() {

	
	var fromarray; var toarray;
	var fromdate = document.forms[0].p_fr_order_date_time.value ;
	var todate = document.forms[0].p_to_order_date_time.value ;
		
	if(fromdate.length > 0 && todate.length > 0 ) {
			fromarray = fromdate.split("/");
			toarray = todate.split("/");
			var fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);
			var todt = new Date(toarray[2],toarray[1],toarray[0]);	
	
			if(Date.parse(todt) < Date.parse(fromdt)) {
			alert(getMessage('TO_DT_GR_EQ_FM_DT','SM'));		
			document.forms[0].p_to_order_date_time.focus();
			return false;
			}
			else if(Date.parse(todt) >= Date.parse(fromdt)) return true;
	}	
//return true;
}
