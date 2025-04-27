  //saved on 27/10/2005
var function_id = "PH_FORM_OF_DRUG" ;
var result1	= false ;
var message = "" ;
var flag = "" ;
var invalidCode	=  "";

var globalCode="";

function create() {
	f_query_add_mod.location.href="../../ePH/jsp/FormOfDrugAddModify.jsp?function_id="+function_id+"&mode="+MODE_INSERT;
}
function query() {
	f_query_add_mod.location.href="../../ePH/jsp/FormOfDrugQueryCriteria.jsp?function_id="+function_id ;
}

function apply() {

	if(!checkIsValidForProceed()){
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false;
	}

	var formObj	=	f_query_add_mod.document.frmFormOfDrug;
	var arrFieldName		=	new Array();
	var arrLegends			=	new Array();
   
	arrFieldName[0]			=	"form_code";
	arrFieldName[1]			=	"form_desc";

	var code=getLabel("Common.code.label","Common");
	  var description=getLabel("Common.description.label","Common");
	arrLegends[0]			=	code;
	arrLegends[1]			=	description;


	var arrPKFieldNames		=	new Array();
	arrPKFieldNames[0]		=	"form_code";

	var mode = formObj.mode.value;

	if( mode == MODE_INSERT )
	{
		
		resetDuplicateClass(formObj,arrPKFieldNames,'1');
		
		var	result	=	validateMandatoryFields(formObj,arrFieldName,arrLegends,arrPKFieldNames,'1');
		if (result){
			
			//alert(formApply(formObj,PH_CONTROLLER));
			eval(formApply(formObj,PH_CONTROLLER));
			if( result1 ) {
			    messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
				onSuccess();
			}
			if( invalidCode != "null" && invalidCode != "" ){
				messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message+":-"+invalidCode;
				showDuplicates(formObj, arrPKFieldNames, invalidCode,'1',messageFrame);
				}
		}
	}
	if( mode == MODE_MODIFY ) {
		
		var formObj = f_query_add_mod.document.frmFormOfDrug ;
		var fields = new Array ( formObj.form_code ,formObj.form_desc);
		var names = new Array ( getLabel("Common.code.label","Common"),getLabel("Common.description.label","Common"));
		
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
			globalCode		=	formObj.form_code.value;
			eval(formApply( f_query_add_mod.document.frmFormOfDrug,PH_CONTROLLER ));
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
			if( result1 ) {
				onSuccess();
			}
		}
	}
}

function assignResult( _result, _message, _flag, _invalidCode ) {
	result1 = _result ;
	message  = _message ;
	flag = _flag ;
	invalidCode = _invalidCode ;
}

function reset() {
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("formofdrugquerycriteria")!=-1) ) {
		f_query_add_mod.document.query_form.reset();
	}
	else if ( (url.indexOf("formofdrugaddmodify")!=-1) ) {
		if(f_query_add_mod.document.frmFormOfDrug.mode.value == MODE_INSERT){
			formObj	=	f_query_add_mod.document.frmFormOfDrug;
			var arrPKFieldNames		=	new Array();
			arrPKFieldNames[0]		=	"form_code";
			resetDuplicateClass(formObj,arrPKFieldNames,'1');
			f_query_add_mod.document.frmFormOfDrug.reset();
		}
		else {
			f_query_add_mod.document.frmFormOfDrug.reset();
		}
	}
}
function onSuccess() {
	var mode = f_query_add_mod.document.frmFormOfDrug.mode.value;
	if( mode == MODE_INSERT ) {
		f_query_add_mod.document.frmFormOfDrug.reset();
		f_query_add_mod.document.frmFormOfDrug.form_code1.focus();
	}
	else if(mode == MODE_MODIFY ){
			f_query_add_mod.location.href="../../ePH/jsp/FormOfDrugAddModify.jsp?function_id="+function_id+"&mode="+MODE_MODIFY+"&form_code="+globalCode;
	}
}
function toUpper(obj) {
	obj.value=obj.value.toUpperCase();
}
function Modify(obj) {
	var form_code=obj.cells[0].innerText;
	parent.f_query_add_mod.location.href="../../ePH/jsp/FormOfDrugAddModify.jsp?function_id="+function_id+"&mode="+MODE_MODIFY+"&form_code="+form_code;
}
function checkIsValidForProceed() {
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("blank.html")==-1) && (url.indexOf("formofdrugquery")==-1) )
		return true;
	else
		return false;
}
function CodeCheck(obj){
	if(!CheckChars(obj)){
		alert(getMessage("SPECIAL_CHARCTERS_NOT_ALLOWED","PH"));
		obj.focus();
		return false;
	}
}
function resetColorCode(obj){
	
	var arrPKFieldNames	=	new Array();
	var formObj			=	parent.f_query_add_mod.document.frmFormOfDrug;
	/**
	  * specify the primary key columns
	  */
	arrPKFieldNames[0]	=	"form_code";
	resetDuplicateClass( formObj, arrPKFieldNames, '1', obj );
}