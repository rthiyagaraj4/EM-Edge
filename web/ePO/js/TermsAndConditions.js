var	function_id	=	"" ;
var result		=	false ;
var message		=	"" ;
var flag		=	"" ;
function assignResult( _result, _message, _flag ) 
{
	result		=	_result ;
	message		=	_message ;
	flag		=	_flag ;
}
function create() {
	f_query_add_mod.location.href="../../ePO/jsp/TermsAndConditionsAddModify.jsp?mode="+MODE_INSERT+"&function_id="+function_id; 
}

function query() {
		f_query_add_mod.location.href="../../ePO/jsp/TermsAndConditionsQueryCriteria.jsp?function_id="+function_id ;
}

function apply() {
//	var formObj = f_query_add_mod.document.forms[0]; 
	var formObj = f_query_add_mod.document.TermsAndConditionsAddModifyform; 
	if(formObj==undefined){
	messageFrame.location.href	=	"../../eCommon/jsp/error.jsp?err_num=";
	return false;
	}
	var fields = new Array ( formObj.termsAndCond_code, formObj.short_desc,formObj.long_desc);
	var names = new Array ( getLabel("eST.TermsAndCondCode.label","ST"),getLabel("Common.shortdescription.label","Common"),getLabel("Common.longdescription.label","Common"));
	var errorPage	=	"../../eCommon/jsp/error.jsp";
	var blankObj	=	null;
	blankObject		=	checkPOFields( fields, names, messageFrame,errorPage);
	if(blankObject==true) {
		eval(formApply(formObj,PO_CONTROLLER));
		messageFrame.location.href = errorPage+"?err_num="+ message;
		if( result ) {
	
			onSuccess();
		}
	}
	else{
	
	}
	
}

function reset() {
			f_query_add_mod.document.forms[0].reset();
			
}

function onSuccess() {
	var mode = f_query_add_mod.document.forms[0].mode.value;
	if( mode == MODE_INSERT ) 
		reset();
	else
	{
	
		f_query_add_mod.document.location.reload();
	}
		
}

function Modify(obj){
	
	var termsAndCond_code=obj.cells[0].innerText;
	document.location.href="../../ePO/jsp/TermsAndConditionsAddModify.jsp?mode="+MODE_MODIFY+"&function_id="+parent.function_id+"&termsAndCond_code="+termsAndCond_code;
	

}

function callTextBox ()
{ 
	
	}
