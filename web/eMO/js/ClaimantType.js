/*Created by Ashwini on 11-Oct-2018 for ML-MMOH-CRF-1095*/

function create() {
	f_query_add_mod.location.href = "../../eMO/jsp/ClaimantTypeAddModify.jsp";
}

function edit() {
	formToolbarFrame.location.href = "formToolbar.html";
}

function query() {
	f_query_add_mod.location.href ="../../eMO/jsp/ClaimantTypeQueryCriteria.jsp?function=CLAIMANT_TYPE_MASTER";
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

function apply() 
{
    if (! (checkIsValidForProceed()) )
    {
        messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    }

    var fields = new Array ( f_query_add_mod.document.claimant_type_mstr_form.claimant_type_mstr_code );
	var names  =  new Array ( "Code" );
	var error_page = "../../eCommon/jsp/MstCodeError.jsp";

	if(f_query_add_mod.SpecialCharCheck(fields,names,messageFrame,"M", error_page))
	{
		var fields = new Array ( f_query_add_mod.document.claimant_type_mstr_form.claimant_type_mstr_code,f_query_add_mod.document.claimant_type_mstr_form.long_desc,f_query_add_mod.document.claimant_type_mstr_form.short_desc);
		
		var names = new Array ( f_query_add_mod.getLabel('Common.code.label','common'),f_query_add_mod.getLabel('Common.longdescription.label','common'),f_query_add_mod.getLabel('Common.shortdescription.label','common'));
		
			if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame))
			{
				f_query_add_mod.document.claimant_type_mstr_form.submit();
				var fn_status = f_query_add_mod.document.claimant_type_mstr_form.function_name.value ;
			}
	}
}

function onSuccess() {
	f_query_add_mod.location.reload();
}	

function change() {
	if (claimant_type_mstr_form.eff_status.checked == true)
	claimant_type_mstr_form.eff_status.value="E";
	else
	claimant_type_mstr_form.eff_status.value="D";
}

function reset() {
	if(f_query_add_mod.document.forms[0])
	f_query_add_mod.document.forms[0].reset() ;
}
