function create() {
	f_query_add_mod.location.href = "../../eMP/jsp/addModifyProcedureClassification.jsp" ;
}


function query() {
	f_query_add_mod.location.href ="../../eMP/jsp/ProcedureClassificationQueryCriteria.jsp" ;
}

function apply() {
	
	if (! (checkIsValidForProceed()) )
    {
		messageFrame.location.href='../../eCommon/jsp/MstCodeError.jsp?err_num=&err_value=0';
        return false;
    }
	
	
	var fields = new Array ( f_query_add_mod.document.Procedure_Classification.proc_class_code,
												f_query_add_mod.document.Procedure_Classification.long_desc,
												f_query_add_mod.document.Procedure_Classification.short_desc
											);
	var names = new Array (  f_query_add_mod.getLabel('Common.code.label','common'),
							 f_query_add_mod.getLabel('Common.longdescription.label','common'),
						 f_query_add_mod.getLabel('Common.shortdescription.label','common'));

	var splField = new Array (f_query_add_mod.document.Procedure_Classification.proc_class_code);
	var splFieldName = new Array ( f_query_add_mod.getLabel('Common.code.label','common'));

	if(f_query_add_mod.SpecialCharCheck(splField, splFieldName, messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp")){	
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
		f_query_add_mod.document.Procedure_Classification.submit();
		}
	}

}

function onSuccess() {
	f_query_add_mod.location.reload();
}

function reset() {
	f_query_add_mod.document.forms[0].reset() ;

}

function CheckSpecChars(event){
    var strCheck = '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_*';
    var whichCode = (window.Event) ? event.which : event.keyCode;
    key = String.fromCharCode(whichCode);  // Get key value from key code
    if (strCheck.indexOf(key) == -1) return false;  // Not a valid key
	if( (event.keyCode >= 97) && (event.keyCode <= 122) )
		return (event.keyCode );
	return true ;
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
