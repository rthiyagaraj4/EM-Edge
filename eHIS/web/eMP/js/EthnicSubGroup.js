
function show() {
	parent.parent.window.document.title = f_query_add_mod.getLabel('Common.setup.label','common')+" " +f_query_add_mod.getLabel('eMP.OccupationClass.label','MP') ;
}

function create() {
	f_query_add_mod.location.href = "../../eMP/jsp/addEthnicSubGroup.jsp" ;
}

function edit() {
//	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {
	f_query_add_mod.location.href ="../../eMP/jsp/EthnicSubGroupQueryCriteria.jsp?function=occupation_class" ;
}
/*
function query() {
	f_query_add_mod.location.href ="../jsp/qOccupationClass.jsp?function=occupation_class" ;
}*/

function apply() {
	
	
	 if (! (checkIsValidForProceed()) )
    {
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
	
	
	var fields = new Array ( f_query_add_mod.document.ETHNIC_SUBGROUP_FORM.ETHNIC_GROUP_CODE,
				 f_query_add_mod.document.ETHNIC_SUBGROUP_FORM.LONG_DESC,
				 f_query_add_mod.document.ETHNIC_SUBGROUP_FORM.SHORT_DESC,
				 f_query_add_mod.document.ETHNIC_SUBGROUP_FORM.RACE_CODE

			       );

	var names  = new Array ( f_query_add_mod.getLabel('Common.code.label','common'),
		                 f_query_add_mod.getLabel('Common.longdescription.label','common'),
				 f_query_add_mod.getLabel('Common.shortdescription.label','common'),
				 f_query_add_mod.getLabel('Common.race.label','common')
			       );

	var transform = new Array ( f_query_add_mod.document.ETHNIC_SUBGROUP_FORM,
				    f_query_add_mod.document.ETHNIC_SUBGROUP_FORM.eff_date_from,
				    f_query_add_mod.document.ETHNIC_SUBGROUP_FORM.eff_date_from1,
				    f_query_add_mod.document.ETHNIC_SUBGROUP_FORM.eff_date_to,
				    f_query_add_mod.document.ETHNIC_SUBGROUP_FORM.eff_date_to1
				  );
	
	var splField = new Array (f_query_add_mod.document.ETHNIC_SUBGROUP_FORM.ETHNIC_GROUP_CODE);
	var splFieldName = new Array (f_query_add_mod.getLabel('Common.code.label','common'));

	if(f_query_add_mod.SpecialCharCheck(splField, splFieldName, messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp")){
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
				 if(f_query_add_mod.DateTransform(transform,messageFrame)) {
			 var fn_status = f_query_add_mod.document.ETHNIC_SUBGROUP_FORM.function_name.value ;
	/*		 if(fn_status == "insert") {
					 f_query_add_mod.document.occupation_class_form.reset();
			 }*/
			 }
		}
	}
}

function reset() {
		/*if(f_query_add_mod.document.forms[0].name == "occupation_class_form")
		   f_query_add_mod.document.occupation_class_form.reset() ;
		else
//		   f_query_add_mod.document.query_form.reset() ;
		   f_query_add_mod.location.href ="../../eMP/jsp/OccupationClassQueryPage.jsp?function=occupation_class" ;*/
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
