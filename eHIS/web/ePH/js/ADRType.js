  //saved on 07/11/2005
var function_id = "" ;
var result = false ;
var message = "" ;
var flag = "" ;
var global_adr_code = "";

function create() 
{
	f_query_add_mod.location.href="../../ePH/jsp/ADRTypeAddModify.jsp?mode="+MODE_INSERT;
}

function query() 
{
	f_query_add_mod.location.href="../../ePH/jsp/ADRTypeQueryCriteria.jsp" ;
}

function deleterecord()
{

}

function apply() 
{

	if(!checkIsValidForProceed())
	{
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false;
	}
	
	var mode = f_query_add_mod.document.frmADRTypeAddModify.mode.value;

	if( mode == MODE_INSERT || mode == MODE_MODIFY ) 
	{
		var formObj = f_query_add_mod.document.frmADRTypeAddModify ;
		var fields = new Array ( formObj.adr_code ,formObj.adr_desc);
		var names= new Array (getLabel("ePH.ADRTypeCode.label","PH"), getLabel("ePH.ADRTypeDescription.label","PH"));
		
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
		{
			global_adr_code = formObj.adr_code.value;
			eval(formApply( f_query_add_mod.document.frmADRTypeAddModify,PH_CONTROLLER ));
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;		
			if( result ) {
				onSuccess();		
			}
		}
	}
}

function assignResult( _result, _message, _flag ) {
	result = _result ;
	message  = _message ;
	flag = _flag ;
}

function reset() {
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	
	if ( (url.indexOf("adrtypequerycriteria")!=-1) ) {
		f_query_add_mod.document.query_form.reset();
	}

	else if ( (url.indexOf("adrtypeaddmodify")!=-1) ) {
		if(f_query_add_mod.document.frmADRTypeAddModify.mode.value == MODE_INSERT){
			formReset() ;
		}
		else {
			f_query_add_mod.document.frmADRTypeAddModify.reset();
		}
	}
}

function formReset()
{
	var obj=f_query_add_mod.document.frmADRTypeAddModify;
	obj.adr_code.value = "";
	obj.adr_desc.value = "";
	obj.eff_status.checked = true;
}

function onSuccess() {
	var mode = f_query_add_mod.document.frmADRTypeAddModify.mode.value;
    if( mode == MODE_INSERT ) {
        f_query_add_mod.document.frmADRTypeAddModify.reset();
    }
    else if(mode == MODE_MODIFY ){
		f_query_add_mod.document.location.href="../../ePH/jsp/ADRTypeAddModify.jsp?adr_code="+global_adr_code+"&mode="+MODE_MODIFY;
    }
}
function Modify(adr_code) {
	document.location.href="../../ePH/jsp/ADRTypeAddModify.jsp?adr_code="+adr_code+"&mode="+MODE_MODIFY;
}
function checkIsValidForProceed() {
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();

	if ( (url.indexOf("blank.html")==-1) && (url.indexOf("reasoncodesquery")==-1) )
		return true;
	else
		return false;
}
function beforePost(str){
	//alert("Reason Codes::"+str);
}

function ReasonCodeCheck(obj){
	if(!CheckChars(obj))
	{
		alert(getMessage("SPECIAL_CHARCTERS_NOT_ALLOWED","PH"));
		obj.focus();
		return false;
	}
}
function toUpper(obj) {
	obj.value=obj.value.toUpperCase();
}

function ChkMaxLen(lab,obj,max,mode) {
	if(obj.value.length >= max) {
		alert("APP-SM0045 - " + lab + getLabel("ePH.Cannotexceed.label","PH")+ max  + getLabel("ePH.characters.label","PH") );

		obj.select();
		return false;
	} 
	else return true;
}