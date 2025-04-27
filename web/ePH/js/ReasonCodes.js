 //saved on 07/11/2005
var function_id = "" ;
var result = false ;
var message = "" ;
var flag = "" ;
var gloabl_appl_trn_type = "";
var gloabl_reason_code="";
function create() {
	f_query_add_mod.location.href="../../ePH/jsp/ReasonCodesAddModify.jsp?mode="+MODE_INSERT;
}

function query() {
	f_query_add_mod.location.href="../../ePH/jsp/ReasonCodesQueryCriteria.jsp" ;
}

function deleterecord(){
}

function apply() {
	if(!checkIsValidForProceed()){
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false;
	}
	var mode = f_query_add_mod.document.frmReasonCodesAddModify.mode.value;
	if( mode == MODE_INSERT || mode == MODE_MODIFY ) {
		var formObj = f_query_add_mod.document.frmReasonCodesAddModify ;
		
		if(formObj.QAP_report.checked == true){
			formObj.QAP_report.value = "Y";
		}else{
			formObj.QAP_report.value = "N";
		}
		if(formObj.appl_trn_type.value=="PR"){
		var fields = new Array ( formObj.appl_trn_type ,formObj.reason_code,formObj.reason_desc,formObj.remarks);
		var names = new Array ( getLabel('ePH.ApplicableTransaction.label','PH'),getLabel('ePH.ReasonCodes.label','PH'),getLabel('Common.ReasonDescription.label','Common'),getLabel('Common.remarks.label','Common'));
		}else{
		  var fields = new Array ( formObj.appl_trn_type ,formObj.reason_code,formObj.reason_desc);
		  var names = new Array ( getLabel('ePH.ApplicableTransaction.label','PH'),getLabel('ePH.ReasonCodes.label','PH'),getLabel('Common.ReasonDescription.label','Common'));
		
		}
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
			
			formObj.remarks.value = encodeURIComponent(formObj.remarks.value,"UTF-8"); //added for  SKR-SCF-0155 -IN029192
			gloabl_appl_trn_type = formObj.appl_trn_type.value;
			gloabl_reason_code = formObj.reason_code.value;
			eval(formApply( f_query_add_mod.document.frmReasonCodesAddModify,PH_CONTROLLER ));
			formObj.remarks.value = decodeURIComponent(formObj.remarks.value,"UTF-8"); //added for  SKR-SCF-0155 -IN029192
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
	
	if ( (url.indexOf("reasoncodesquerycriteria")!=-1) ) {
		f_query_add_mod.document.query_form.reset();
	}

	else if ( (url.indexOf("reasoncodesaddmodify")!=-1) ) {
		if(f_query_add_mod.document.frmReasonCodesAddModify.mode.value == MODE_INSERT){
			formReset() ;
		}
		else {
			f_query_add_mod.document.frmReasonCodesAddModify.reset();
		}
	}
}

function formReset(){
	var obj=f_query_add_mod.document.frmReasonCodesAddModify;
	obj.appl_trn_type.value="R";
	obj.reason_code.value="";
	obj.reason_desc.value="";
	obj.eff_status.checked=true;
	obj.QAP_report.checked=false;
}

function onSuccess() {
	var mode = f_query_add_mod.document.frmReasonCodesAddModify.mode.value;
    if( mode == MODE_INSERT ) {
        f_query_add_mod.document.frmReasonCodesAddModify.reset();
    }
    else if(mode == MODE_MODIFY ){
		f_query_add_mod.document.location.href="../../ePH/jsp/ReasonCodesAddModify.jsp?appl_trn_type="+gloabl_appl_trn_type+"&mode="+MODE_MODIFY+"&reason_code="+gloabl_reason_code;
    }
}
function Modify(appl_trn_type, reason_code) {
	document.location.href="../../ePH/jsp/ReasonCodesAddModify.jsp?appl_trn_type="+appl_trn_type+"&mode="+MODE_MODIFY+"&reason_code="+reason_code;
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
	//alert("Reason Codes::"+str);5/30/2005
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

/*function ChkMaxLen(lab,obj,max,mode) {
	
		if(obj.value.length > max) {
			alert("APP-SM0045 - " + lab + " cannot exceed " + max  + " characters" );
			obj.select();
			return false;
		} else return true;

}*/

function ChkMaxLen(lab,obj,max,transaction) 
{
	var val = "";
	val = obj.value;
	if(transaction.value!="PR"&&transaction.value!="BR")//added "BR" conditon  for ML-MMOH-CRF-0734
	{
	max=255;
	   document.getElementById("mandatory1").style.visibility = 'hidden';
	}else if(transaction.value=="PR"){
	  document.getElementById("mandatory1").style.visibility = 'visible';
	}//added if condition for ML-MMOH-CRF-0734  start
	else if(transaction.value=="BR")
		{
		 max=1000; 
		   document.getElementById("mandatory1").style.visibility = 'hidden';
		}//end ML-MMOH-CRF-0734  end
	if(obj.value.length > max)
		{
			var msg = getMessage("REMARKS_CANNOT_EXCEED","Common");
			msg = msg.replace("$",lab);
			msg = msg.replace("#",max);
			alert(msg);
			obj.focus();
			//obj.value = val.substring(0,max);
		
		}
	
}
