function show() {
	parent.parent.window.document.title = getLabel('Common.setup.label','common')+ " " + getLabel('eMP.ResidenceTown.label','MP') ;
}

function create() {
	f_query_add_mod.location.href = "../../eMP/jsp/ResidenceTown.jsp" ;
}

function query() {
	f_query_add_mod.location.href ="../../eMP/jsp/TownQueryPage.jsp?function=Town";
}
/*
function query() {
	f_query_add_mod.location.href ="../jsp/queryResidenceTownPage.jsp?function=Town";
}
*/
function apply() {
	
	  if (! (checkIsValidForProceed()) )
    {
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    }
	
	if(f_query_add_mod.document.res_town_form.postal_code_link_yn)
	{
	postal_code_link_yn=f_query_add_mod.document.res_town_form.postal_code_link_yn.value;
	}
	if(postal_code_link_yn=="Y")
	{
	var fields = new Array ( f_query_add_mod.document.res_town_form.res_town_code,
						f_query_add_mod.document.res_town_form.long_desc,
						f_query_add_mod.document.res_town_form.short_desc,
						f_query_add_mod.document.res_town_form.res_area_code
					    );
	var names = new Array ( getLabel('Common.code.label','common'),
						getLabel('Common.longdescription.label','common'),
						getLabel('Common.shortdescription.label','common'),
						getLabel('Common.area.label','common')
			      );
	
	}else{

   var fields = new Array ( f_query_add_mod.document.res_town_form.res_town_code,
						f_query_add_mod.document.res_town_form.long_desc,
						f_query_add_mod.document.res_town_form.short_desc						
					    );
	 var names = new Array ( getLabel('Common.code.label','common'),
						getLabel('Common.longdescription.label','common'),
						getLabel('Common.shortdescription.label','common')						
			             );

	}
	var transform = new Array (	f_query_add_mod.document.res_town_form,
							f_query_add_mod.document.res_town_form.eff_date_from,
							f_query_add_mod.document.res_town_form.eff_date_from1,
							f_query_add_mod.document.res_town_form.eff_date_to,
							f_query_add_mod.document.res_town_form.eff_date_to1
						  );
	var splField = new Array (f_query_add_mod.document.res_town_form.res_town_code);
	var splFieldName = new Array (getLabel('Common.code.label','common'));

	if(f_query_add_mod.SpecialCharCheck(splField, splFieldName, messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp")){	
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
			if(f_query_add_mod.DateTransform(transform,messageFrame)) {
				var fn_status = f_query_add_mod.document.res_town_form.function_name.value ;
	//			if(fn_status == "insert") f_query_add_mod.document.res_town_form.reset();
			}
		}
	}
}

function reset() {
	f_query_add_mod.document.forms[0].reset() ;
}

function onSuccess() {
	f_query_add_mod.location.reload();
}

function checkIsValidForProceed()
{
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("queryresult.jsp")==-1) && (url.indexOf("query")==-1)&&(url.indexOf("blank")==-1) )
		return true;
	else
		return false;
}
