function create() {
//	f_query_add_mod.location.href = "../html/addMaritalStatus.html" ;
	f_query_add_mod.location.href = "../../eMP/jsp/addMaritalStatus.jsp";
	//f_query_add_mod.location.href = "../../eMP/jsp/ViewPatDetailsMain.jsp?function_id=CAPTUREPATPHOTO&Patient_ID=DS02000073"
}
/*
function query() {
	f_query_add_mod.location.href ="../jsp/queryPageMaritalStatus.jsp?" ;
}
*/

function query() {
	f_query_add_mod.location.href ="../../eMP/jsp/MaritalStatusQueryPage.jsp?" ;
}

function apply() {

	 if (! (checkIsValidForProceed()) )
    {
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    } 
	
	var fields = new Array (	f_query_add_mod.document.marital_status_form.mar_status_code,
									f_query_add_mod.document.marital_status_form.long_desc,
									f_query_add_mod.document.marital_status_form.short_desc
								   );
		 var names = new Array ( 		f_query_add_mod.getLabel('Common.code.label','common'),
						f_query_add_mod.getLabel('Common.longdescription.label','common'),
						f_query_add_mod.getLabel('Common.shortdescription.label','common')

					      );
	 var transform = new Array (	f_query_add_mod.document.marital_status_form,
							f_query_add_mod.document.marital_status_form.eff_date_from,
							f_query_add_mod.document.marital_status_form.eff_date_from1,
							f_query_add_mod.document.marital_status_form.eff_date_to,
							f_query_add_mod.document.marital_status_form.eff_date_to1
						   );
	 var splField = new Array(f_query_add_mod.document.marital_status_form.mar_status_code);
	 var splFieldName = new Array(f_query_add_mod.getLabel('Common.code.label','common'));

	if(f_query_add_mod.SpecialCharCheck(splField, splFieldName, messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp")){
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
			if(f_query_add_mod.DateTransform(transform,messageFrame)) {
				var fn_status = f_query_add_mod.document.marital_status_form.function_name.value ;
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
