function show() {
	parent.window.document.title = getLabel('eMP.ResidenceArea.label','MP') ;
}

function create() {
	f_query_add_mod.location.href = "../../eMP/jsp/ResidenceArea.jsp" ;
}

function query() {
	f_query_add_mod.location.href ="../../eMP/jsp/AreaQueryPage.jsp?function=Area";
}
/*
function query() {
	f_query_add_mod.location.href ="../jsp/queryResidenceAreaPage.jsp?function=Area";
}
*/

function apply() {
	
  if (! (checkIsValidForProceed()) )
    {
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    }
	var postal_code_link_yn=f_query_add_mod.document.res_area_form.postal_code_link_yn.value;
	if(postal_code_link_yn=="Y")
	{
	var fields = new Array ( f_query_add_mod.document.res_area_form.res_area_code,
						f_query_add_mod.document.res_area_form.long_desc,
						f_query_add_mod.document.res_area_form.short_desc,
						f_query_add_mod.document.res_area_form.region_code
					    );
	var names = new Array ( getLabel('Common.code.label','common'),
						getLabel('Common.longdescription.label','common'),
						getLabel('Common.shortdescription.label','common'),
						getLabel('eMP.region.label','MP')
					      );
	}else{

	var fields = new Array ( f_query_add_mod.document.res_area_form.res_area_code,
						f_query_add_mod.document.res_area_form.long_desc,
						f_query_add_mod.document.res_area_form.short_desc
							    );
	var names = new Array ( getLabel('Common.code.label','common'),
						getLabel('Common.longdescription.label','common'),
						getLabel('Common.shortdescription.label','common')
						     );
	}
	
	var transform = new Array (	f_query_add_mod.document.res_area_form,
							f_query_add_mod.document.res_area_form.eff_date_from,
							f_query_add_mod.document.res_area_form.eff_date_from1,
							f_query_add_mod.document.res_area_form.eff_date_to,
							f_query_add_mod.document.res_area_form.eff_date_to1
						   );
	var splField = new Array (f_query_add_mod.document.res_area_form.res_area_code);
	var splFieldName = new Array (getLabel('Common.code.label','common'));

	if(f_query_add_mod.SpecialCharCheck(splField, splFieldName, messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp")){	
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
			if(f_query_add_mod.DateTransform(transform,messageFrame)) {
			}
		}
	}
}

function reset() {
		/*if(f_query_add_mod.document.forms[0].name == "res_area_form") f_query_add_mod.document.res_area_form.reset() ;
		else 
		//f_query_add_mod.document.query_form.reset() ;
			f_query_add_mod.location.href ="../../eMP/jsp/AreaQueryPage.jsp?function=Area";*/
	f_query_add_mod.document.forms[0].reset() ;

}

function onSuccess() {
	f_query_add_mod.location.reload() ;
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
