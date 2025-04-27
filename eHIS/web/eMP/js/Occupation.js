function show() {
      // parent.parent.window.document.title = "Setup Occupation" ;
}

function create() {
	f_query_add_mod.location.href = "../../eMP/jsp/addOccupation.jsp" ;
}

function edit() {
//	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {
	f_query_add_mod.location.href ="../../eMP/jsp/OccupationQueryPage.jsp?function=occupation" ;
}
/*
function query() {
	f_query_add_mod.location.href ="../jsp/qOccupation.jsp?function=occupation" ;
}
*/
function apply() {

 if (! (checkIsValidForProceed()) )
    {
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 

	 var fields = new Array ( f_query_add_mod.document.occupation_form.occupation_code,
				  f_query_add_mod.document.occupation_form.long_desc,
				  f_query_add_mod.document.occupation_form.short_desc,
				  f_query_add_mod.document.occupation_form.occupation_class
				);

	 var names  = new Array ( f_query_add_mod.getLabel('Common.code.label','common'),
		                  f_query_add_mod.getLabel('Common.longdescription.label','common'),
				  f_query_add_mod.getLabel('Common.shortdescription.label','common'),
				  f_query_add_mod.getLabel('eMP.OccupationClass.label','MP')
				);
	 var transform = new Array ( f_query_add_mod.document.occupation_form,
			             f_query_add_mod.document.occupation_form.eff_date_from,
			             f_query_add_mod.document.occupation_form.eff_date_from1,
				     f_query_add_mod.document.occupation_form.eff_date_to,
				     f_query_add_mod.document.occupation_form.eff_date_to1
				   );

	var splField = new Array (f_query_add_mod.document.occupation_form.occupation_code);
	var splFieldName = new Array (f_query_add_mod.getLabel('Common.code.label','common'));

	if(f_query_add_mod.SpecialCharCheck(splField, splFieldName, messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp")){
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
			   if(f_query_add_mod.DateTransform(transform,messageFrame)) {
				  var fn_status = f_query_add_mod.document.occupation_form.function_name.value ;
	/*		      if(fn_status == "insert") {
					 f_query_add_mod.document.occupation_form.reset();
				  }*/
			   }
		}
	}
}

function reset() {
/*		if(f_query_add_mod.document.forms[0].name == "occupation_form")
		  f_query_add_mod.document.occupation_form.reset();
		else
//		   f_query_add_mod.document.query_form.reset() ;
		   f_query_add_mod.location.href ="../../eMP/jsp/OccupationQueryPage.jsp?function=occupation" ;*/
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
