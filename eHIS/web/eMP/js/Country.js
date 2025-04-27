function create() {
	f_query_add_mod.location.href = "../../eMP/jsp/addCountry.jsp" ;
}

function edit() {
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {
	f_query_add_mod.location.href ="../../eMP/jsp/CountryQueryPage.jsp?function=country" ;
}
/*
function query() {
	f_query_add_mod.location.href ="../jsp/queryCountryPage.jsp?function=country" ;
}
*/
function apply() {
	
	 if (! (checkIsValidForProceed()) )
    {
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    }
	//<!--added by Himanshu Saxena for MOHE-CRF-1930
	var isVIRTUAL_CONSULTATION=f_query_add_mod.document.country_form.isVIRTUAL_CONSULTATION1.value;
	 
	var fields = new Array ( f_query_add_mod.document.country_form.country_code,
						f_query_add_mod.document.country_form.long_name,
						f_query_add_mod.document.country_form.short_name,
						f_query_add_mod.document.country_form.long_desc
					    );
	var names = new Array ( f_query_add_mod.getLabel('Common.code.label','common'),
						f_query_add_mod.getLabel('Common.longname.label','common'),
						f_query_add_mod.getLabel('Common.shortname.label','common'),
						f_query_add_mod.getLabel('Common.Citizenship.label','common')
					      );
	//<!--added by Himanshu Saxena for MOHE-CRF-1930	
	if(isVIRTUAL_CONSULTATION == "true")
		 {
		fields[4]=f_query_add_mod.document.country_form.telephone_country_code;
		names[4]=f_query_add_mod.getLabel('eMP.telephonecode.label','eMP');
		 }

	var transform = new Array (		f_query_add_mod.document.country_form,
							f_query_add_mod.document.country_form.eff_date_from,
							f_query_add_mod.document.country_form.eff_date_from1,
							f_query_add_mod.document.country_form.eff_date_to,
							f_query_add_mod.document.country_form.eff_date_to1
						   );
	var splField = new Array (f_query_add_mod.document.country_form.country_code);
	var splFieldName = new Array (f_query_add_mod.getLabel('Common.code.label','common'));

	if(f_query_add_mod.SpecialCharCheck(splField, splFieldName, messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp")){
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
			if(f_query_add_mod.DateTransform(transform,messageFrame)) {
				var fn_status = f_query_add_mod.document.country_form.function_name.value ;
				//if(fn_status == "insert")  f_query_add_mod.document.country_form.reset();
			}
		}
	}
		return true;
}

function onSuccess() {
	f_query_add_mod.location.reload() ;
}

function reset() {

/*	if(f_query_add_mod.document.forms[0].name == "country_form") f_query_add_mod.document.country_form.reset() ;
	else 
	//f_query_add_mod.document.query_form.reset() ;
		f_query_add_mod.location.href ="../../eMP/jsp/CountryQueryPage.jsp?function=country" ;*/
f_query_add_mod.document.forms[0].reset() ;

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
