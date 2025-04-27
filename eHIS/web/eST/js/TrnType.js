 
var function_id = "";
var bean_id = "";
var bean_name = "";
var xmlDoc;
var xmlDom;
var xmlHttp;
var checkArray = new Array();
var obj = null;
function onSuccess() {
	messageFrame.location.href = "../../eCommon/jsp/error.jsp" + "?err_num=" + message;
}
function reset() {
	f_query_add_mod.document.formTrnType.reset();
}
function apply() {
	var formObj = f_query_add_mod.document.formTrnType;
	responseText = formApply(formObj, ST_CONTROLLER);
	eval(responseText);
	if (result) {
		onSuccess();
	}
	f_query_add_mod.location.href = "../../eST/jsp/TrnTypeModify.jsp?&function_id=" + function_id;
}
function checkZero(obj,finalizedcount,records_per_trn,trn_type) {
	if (obj.value == "0") {
		alert("No.Of.Records Per Transaction Cannot Be Zero");
		obj.select();
	}
	
	//Added by sakti against ML-BRU-SCF-1091.1 to restrict adding items based on transaction per record
	if(trn_type == "ISS"){
		if(finalizedcount && obj.value != records_per_trn) {
			alert(getMessage("UNFINALIZED_TRN_EXITS_SS_PARAM","SS"));
			obj.value = records_per_trn;
		}
	}
	//Added by sakti against ML-BRU-SCF-1091.1 to restrict adding items based on transaction per record ends
}

