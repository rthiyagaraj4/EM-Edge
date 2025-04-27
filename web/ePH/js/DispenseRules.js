  var function_id = "" ;
var result = false ;
var message = "" ;
var flag = "" ;

function query(){
		f_query_add_mod.document.location.href="../../ePH/jsp/DispenseRulesQueryCriteria.jsp?function_id="+function_id ;
}
function reset() {
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();

	if ( (url.indexOf("dispenserulesquerycriteria")!=-1) ) {
		f_query_add_mod.document.query_form.reset();
	}

	else if ( (url.indexOf("dispenserulesaddmodify")!=-1) ) {
		if(f_query_add_mod.document.dispense_rules.mode.value == MODE_INSERT){
			f_query_add_mod.document.dispense_rules.reset();
		}
		else {
					
//			f_query_add_mod.document.dispense_rules.reset();
			f_query_add_mod.document.location.reload();
		}
	}
}

function create(){
	f_query_add_mod.document.location.href="../../ePH/jsp/DispenseRulesAddModify.jsp?mode="+MODE_INSERT;
}

function apply(){
	var fields  = new Array() ;
	var names   = new Array() ;
	fields[0]   = f_query_add_mod.document.dispense_rules.drug_category ;
	fields[1]   = f_query_add_mod.document.dispense_rules.patient_class ;
	fields[2]   = f_query_add_mod.document.dispense_rules.dispensing_group ;
	fields[3]   = f_query_add_mod.document.dispense_rules.dispense_duration ;
	fields[4]   = f_query_add_mod.document.dispense_rules.action ;	
	names[0]   =getLabel( "ePH.DrugCategory.label",'PH') ;
	names[1]   = getLabel( "Common.patientclass.label",'Common') ;
	names[2]   = getLabel( "ePH.DispensingGroup.label",'PH') ;
	names[3]   = getLabel( "ePH.MaxDispenseDuration.label",'PH') ;
	names[4]   = getLabel( "Common.action.label",'Common') ;
	if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
		var formarray  =new Array(f_query_add_mod.document.dispense_rules);
		eval( formApply( formarray,PH_CONTROLLER) ) ;
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+message;
		if( result ) {
			onSuccess();
		}   
	}
}

function onSuccess(){
	var formobj = f_query_add_mod.document.dispense_rules;
	if(formobj.mode.value==MODE_MODIFY){
	f_query_add_mod.document.location.href="../../ePH/jsp/DispenseRulesAddModify.jsp?mode="+MODE_MODIFY+"&drug_catg_code="+formobj.drug_category.value+"&patient_class="+formobj.patient_class.value+"&stat_group_id="+formobj.dispensing_group.value+"&action="+formobj.action.value;

	}else 
		create();
	}

function assignResult( _result, _message, _flag ) {
	result = _result ;
	message  = _message ;
	flag = _flag ;
}
function ChkMaxLen(obj,max,mode) {
		if(obj.value.length >= max) {
			alert(getMessage("MESSAGE_TEXT_CANNOT_EXCEED","PH"));
			obj.select();
			return false;
		}
		else
			return true;
	
}


function DurationValidate(obj){
	var formObj =	document.dispense_rules;
	var max_durn_for_op_pres = formObj.max_durn_for_op_pres.value;
	var max_durn_for_ip_pres = formObj.max_durn_for_ip_pres.value;
	if (formObj.patient_class.value=="IP" || formObj.patient_class.value=="DC" ){
		if (parseFloat(max_durn_for_ip_pres) < parseFloat(obj.value)){
			parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage("PH_MAX_DISP_DURN_PARAM","PH");
			obj.focus();
		}else{
			parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		}
	}else{
		if (parseFloat(max_durn_for_op_pres) < parseFloat(obj.value)){
			parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage("PH_MAX_DISP_DURN_PARAM","PH");
			obj.focus();
		}else{
			parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		}
	}	
}
function deleterecord()
{

var url = f_query_add_mod.location.href;
url = url.toLowerCase();

if ( (url.indexOf("dispenserulesaddmodify")==-1) ) {
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
	return false;
}
else {
	if (f_query_add_mod.document.dispense_rules.mode.value == MODE_MODIFY) {
		f_query_add_mod.document.dispense_rules.mode.value = MODE_DELETE;
		var get_val=confirm(getMessage("DELETE_RECORD","Common"));
		if(get_val==true){
			apply();
		}else{
			 f_query_add_mod.document.dispense_rules.mode.value = MODE_MODIFY;
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
			return false;
		}
	 }
	else {
		   f_query_add_mod.document.dispense_rules.mode.value = MODE_MODIFY;
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
			return false;
		}
	}
}

function Modify(obj){
	var drug_catg_code=obj.cells[0].innerText;
	var patient_class=obj.cells[2].innerText;
	var stat_group_id=obj.cells[3].innerText;
	var action=obj.cells[5].innerText;

	document.location.href="../../ePH/jsp/DispenseRulesAddModify.jsp?mode="+MODE_MODIFY+"&drug_catg_code="+drug_catg_code+"&patient_class="+patient_class+"&stat_group_id="+stat_group_id+"&action="+action;
}