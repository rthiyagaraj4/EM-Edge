/*
*Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
* 
*Warning: This computer program is protected by copyright law and international treaties.
*Unauthorized reproduction or distribution of this program, or any portion of it, 
*may result in severe civil and criminal penalties, and will be prosecuted to 
*the maximum extent possible under the law.
*/
/*
------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History      		Name        		Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------------------------------
10/07/2017	IN061903			Krishna Gowtham J 			10/07/2017		Ramesh G		ML-MMOH-CRF-0555		
------------------------------------------------------------------------------------------------------------------------------------------------------
*/
var function_id = "" ;
var result = false;
var message = "" ;
var flag = "" ;
var qry_string = "";
function create() {
	f_query_add_mod.location.href = "../../eOR/jsp/ReasonCodeAddModify.jsp?mode="+MODE_INSERT+"&function_id="+function_id ;
}

function query() {
	f_query_add_mod.location.href='../../eOR/jsp/ReasonCodeQueryCriteria.jsp?function_id='+function_id ;
}

function apply() {
	if (! checkIsValidForProceed() ) {
		message  = getMessage("NOT_VALID","OR");
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		return false ;
	}

	var formObj = f_query_add_mod.reason_code_top.document.reason_code ;
	var formObj1 = f_query_add_mod.reason_code_bottom.document.reason_code_ord_cat ;
	var fields = new Array ( formObj.reason_type
						,formObj.reason_code
						,formObj.reason_short_desc
						,formObj.reason_desc
						);

	var names = new Array ( getLabel("Common.type.label","Common")
				,getLabel("Common.code.label","Common")
				,getLabel("Common.description.label","Common")
				,getLabel("eOR.ReasonText.label","OR")
				);

	var obj= getBlankField(fields, names, messageFrame,"../../eCommon/jsp/MstCodeError.jsp");
	if(obj != null)
		obj.focus();

	var finalString="";
	//messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
	if(f_query_add_mod.reason_code_top.checkFieldsofMst( fields, names, messageFrame)) {
		  var flds=new Array(formObj.reason_code);
		  var name=new Array(getLabel("Common.code.label","Common"));
	  if(SpecialCharCheck(flds,name,messageFrame,"M","../../eCommon/jsp/MstCodeError.jsp")){

		var chkValues= false;
		var totalChk = formObj1.totalSize.value
		var checkedVal = "";
		for(i=0; i<totalChk; i++){
		checkedVal = "N"
			if(eval("formObj1.chk"+i).checked == true)
			{
				checkedVal = "Y";chkValues = true;
			}
			tempVal = eval("formObj1.scope"+i).value
			tempVal = checkedVal+tempVal+"~"
			finalString += tempVal
		}
		if(!chkValues){
			var msg= getMessage("CHECK_ATLEAST_ONE_CATEGORY","OR");
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg;
			return false ;
		}
		if(finalString != ""){
			finalString=finalString.substring(0,finalString.length-1);
		}

		formObj1.allOrderCats.value = finalString ;
		formObj1.reason_type.value = formObj.reason_type.value
		formObj1.reason_code.value = formObj.reason_code.value
		formObj1.reason_desc.value = formObj.reason_desc.value
		formObj1.reason_short_desc.value = formObj.reason_short_desc.value


		if(formObj.eff_status.checked == true){
			formObj1.eff_status.value = "E";
		}else{
			formObj1.eff_status.value = "D";
		}

		if(formObj.reason_desc.value.length >= 200) {
			var msg = getMessage("MAX_RECORDS","OR");

			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ msg;
			return false
		}
		qry_string =  "mode=2&action_type="+formObj.reason_type.value+"&action_reason_code="+formObj.reason_code.value+"&action_reason_desc="+formObj.reason_desc.value+"&eff_status="+formObj1.eff_status.value+"&action_description="+formObj.reason_short_desc.value





		//alert(	formApply( f_query_add_mod.reason_code_bottom.reason_code_ord_cat ) );
		eval(	formApply( f_query_add_mod.reason_code_bottom.reason_code_ord_cat, OR_CONTROLLER) );
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
		if( result ) {
			onSuccess();
		}
	}
	}
}


function onSuccess() {
	var mode = f_query_add_mod.reason_code_bottom.document.reason_code_ord_cat.mode.value;
	if( mode == "1" ) {
		formReset();
		f_query_add_mod.location.href = "../../eOR/jsp/ReasonCodeAddModify.jsp?mode="+MODE_INSERT
	}
	if(mode == "2"){

		f_query_add_mod.location.href='../../eOR/jsp/ReasonCodeAddModify.jsp?'+unescape(qry_string) ;
	}
}



function formReset () {
	var formObj = f_query_add_mod.reason_code_top.document.reason_code ;
	var formObj1 = f_query_add_mod.reason_code_bottom.document.reason_code_ord_cat ;
	formObj.reason_type.value = "";
	formObj.reason_code.value = "";
	formObj.reason_desc.value = "";
	formObj.reason_short_desc.value = "";

	for(var i=0;i<formObj1.length;i++) {
		if(formObj1[i].type == "checkbox") {
			formObj1[i].checked = false;
		}
	}

}

function assignResult(_result, _message, _flag){
	result = _result ;
	message  = _message ;
	flag = _flag ;

}

function reset(){
	if(f_query_add_mod.reason_code_top){
		if(f_query_add_mod.reason_code_top.document.forms[0].name == "reason_code"){
			f_query_add_mod.reason_code_top.document.reason_code.reset();
			f_query_add_mod.reason_code_bottom.document.reason_code_ord_cat.reset();
		}
	}
	else if(f_query_add_mod.document.forms[0]!=null)
		f_query_add_mod.document.forms[0].reset();
	else{
			frames[0].location.reload();
			return false;
	}
}

function CheckMaxLength(obj,max) {
	if(obj.value.length >= max) {
		alert(getMessage("MAX_RECORDS","OR"));
		return false;
	} else return true;
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

function chkType(obj) {
    if (obj.value == 'O') {
        for (i = 0; i < parent.reason_code_bottom.document.reason_code_ord_cat.totalSize.value; i++) {
            eval("parent.reason_code_bottom.document.reason_code_ord_cat.chk"+i).checked = true;
            eval("parent.reason_code_bottom.document.reason_code_ord_cat.chk"+i).disabled = true;
        }
    }
	//IN061903 start
	else if(obj.value == "ND"){
		for(i = 0; i < parent.reason_code_bottom.document.reason_code_ord_cat.totalSize.value; i++){
			if(eval("parent.reason_code_bottom.document.reason_code_ord_cat.scope"+i).value != "PC" && eval("parent.reason_code_bottom.document.reason_code_ord_cat.scope"+i).value != "TR")
			{
				eval("parent.reason_code_bottom.document.reason_code_ord_cat.chk"+i).disabled = true;
				eval("parent.reason_code_bottom.document.reason_code_ord_cat.chk"+i).checked = false;
			}
			else{
				eval("parent.reason_code_bottom.document.reason_code_ord_cat.chk"+i).disabled = false;
				eval("parent.reason_code_bottom.document.reason_code_ord_cat.chk"+i).checked = false;
			}
		}
	}
	//IN061903 end
	else {
        for (i = 0; i < parent.reason_code_bottom.document.reason_code_ord_cat.totalSize.value; i++) {
            eval("parent.reason_code_bottom.document.reason_code_ord_cat.chk"+i).checked = false;
            eval("parent.reason_code_bottom.document.reason_code_ord_cat.chk"+i).disabled = false;
        }
    }
}

