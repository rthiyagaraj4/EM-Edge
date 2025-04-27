function create() {
	f_query_add_mod.location.href = "../../eMP/jsp/addLanguage.jsp" ;
}

function query() {
   f_query_add_mod.location.href ="../../eMP/jsp/LanguageQueryPage.jsp?";
   
}

function apply() {

	if(f_query_add_mod.document.Language_form)
	{
	
	var fields = new Array (f_query_add_mod.document.Language_form.language_id,
						f_query_add_mod.document.Language_form.long_desc,
						f_query_add_mod.document.Language_form.short_desc );

	var names = new Array (getLabel('Common.code.label','common'),
						getLabel('Common.longdescription.label','common'),
						getLabel('Common.shortdescription.label','common'));



	var splField = new Array (f_query_add_mod.document.Language_form.language_id);
	var splFieldName = new Array (getLabel('Common.code.label','common'));

	if(f_query_add_mod.SpecialCharCheck(splField, splFieldName, messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp")){	
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {

			
			f_query_add_mod.document.Language_form.submit();
		}
	}
	}
	else
	{
		message  = "";
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	} 

	
}

function reset() {
	f_query_add_mod.document.forms[0].reset() ;
}

function onSuccess() {
	f_query_add_mod.location.reload();
}
