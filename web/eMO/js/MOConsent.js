function create() {
	f_query_add_mod.location.href = "../../eMO/jsp/addModifyConsent.jsp" ;
}

function edit() {
	formToolbarFrame.location.href = "formToolbar.html" ;
}

function query() {

	f_query_add_mod.location.href ="../../eMO/jsp/ConsentQueryCriteria.jsp?function=MO_CONSENT_FORMS";
}


function change(){
 if (MOConsent_form.eff_status.checked == true)
 MOConsent_form.eff_status.value="E";
 else
MOConsent_form.eff_status.value="D";     	      	
}      	
function checkIsValidForProceed()
  {
     var url = f_query_add_mod.location.href;
     url = url.toLowerCase();
     if ( (url.indexOf("blank.html")==-1) && (url.indexOf("query")==-1) )
        return true;
    else
        return false;
 }


function apply() {

	 if (! (checkIsValidForProceed()) )
    {
        messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    }
    
	var fields = new Array ( f_query_add_mod.document.MOConsent_form.service_code );
	var names  =  new Array ( f_query_add_mod.getLabel('Common.code.label','common'));
	//var messageFrame = parent.frames[1].frames[2]; 
	var error_page = "../../eCommon/jsp/MstCodeError.jsp";
	
	if(f_query_add_mod.SpecialCharCheck(fields,names,messageFrame,"M", error_page)){
		
	var fields = new Array ( f_query_add_mod.document.MOConsent_form.service_code,
	f_query_add_mod.document.MOConsent_form.long_desc,f_query_add_mod.document.MOConsent_form.terms_desc);
	var names = new Array ( f_query_add_mod.getLabel('Common.code.label','common'), f_query_add_mod.getLabel('Common.TITLE.label','common'), f_query_add_mod.getLabel('Common.description.label','common'));
	
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
			{
	
		f_query_add_mod.document.MOConsent_form.submit();
		
	var fn_status = f_query_add_mod.document.MOConsent_form.function_name.value ;
	}
		
	}
}

function onSuccess() {
	f_query_add_mod.location.reload();
}

function reset() {

		if(f_query_add_mod.document.forms[0])
		f_query_add_mod.document.forms[0].reset() ;

}
