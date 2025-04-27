  //saved on 27/10/2005
var function_id = "PH_DRUG_CATG_RULE_BY_PATCL" ;
var result = false ;
var message = "" ;
var flag = "" ;

function create() {
	f_query_add_mod.location.href="../../ePH/jsp/DrugCategoryRuleByPatclAddModify.jsp?function_id="+function_id+"&mode="+MODE_INSERT;
}

function query() {
	f_query_add_mod.location.href="../../ePH/jsp/DrugCategoryRuleByPatclQueryCriteria.jsp?function_id="+function_id ;
}


function deleterecord(){

	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();

	if ( (url.indexOf("drugcategoryrulebypatcladdmodify")==-1) ) {
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false;
	}
	else {
		if (f_query_add_mod.document.frmDrugCategoryRulesByPatcl.mode.value == MODE_MODIFY) {
			f_query_add_mod.document.frmDrugCategoryRulesByPatcl.mode.value = MODE_DELETE;
			if (confirm(f_query_add_mod.getMessage("DELETE_RECORD","Common")))
				apply();
			else {
				f_query_add_mod.document.frmDrugCategoryRulesByPatcl.mode.value = MODE_MODIFY;
				messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
			}
		}
		else {
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false;
		}
	}
}

function apply() {
	
	if(!checkIsValidForProceed()){
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false;
	}

	var mode = f_query_add_mod.document.frmDrugCategoryRulesByPatcl.mode.value;

	if( mode == MODE_INSERT || mode == MODE_DELETE) {
		var formObj = f_query_add_mod.document.frmDrugCategoryRulesByPatcl ;
		var fields = new Array ( formObj.drug_catg_code ,formObj.patient_class,formObj.max_durn_value);
		var names = new Array ( getLabel("ePH.DrugCategory.label","PH"), getLabel("Common.patientclass.label","Common"),getLabel("ePH.MaxPrescriptionDuration.label","PH"));
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
			eval(formApply( f_query_add_mod.document.frmDrugCategoryRulesByPatcl,PH_CONTROLLER ));
			messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;		
			if( result ) {
				onSuccess();		
			}
		}
	}
	if ( mode == MODE_MODIFY ){

		var formObj = f_query_add_mod.document.frmDrugCategoryRulesByPatcl ;
		var fields = new Array (formObj.max_durn_value);
		var names = new Array (getLabel("ePH.MaxPrescriptionDuration.label","PH"));
		if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
			eval(formApply( f_query_add_mod.document.frmDrugCategoryRulesByPatcl,PH_CONTROLLER ));
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
	
	if ( (url.indexOf("drugcategoryrulebypatclquerycriteria")!=-1) ) {
		f_query_add_mod.document.query_form.reset();
	}

	else if ( (url.indexOf("drugcategoryrulebypatcladdmodify")!=-1) ) {
		if(f_query_add_mod.document.frmDrugCategoryRulesByPatcl.mode.value == MODE_INSERT){
			formReset() ;
		}
		else {
			f_query_add_mod.document.frmDrugCategoryRulesByPatcl.reset();
		}
	}
}

function onSuccess() {
	var mode = f_query_add_mod.document.frmDrugCategoryRulesByPatcl.mode.value;
	if( mode == MODE_INSERT ) {
		formReset();
	}else if(mode == MODE_DELETE ){
		f_query_add_mod.location.href="../../eCommon/html/blank.html";
	}else if(mode == MODE_MODIFY ){
		var formObj =f_query_add_mod.document.frmDrugCategoryRulesByPatcl;
		var drug_catg_code	= formObj.drug_catg_code.value;
		var patient_class	= formObj.patient_class.value;
		f_query_add_mod.location.href="../../ePH/jsp/DrugCategoryRuleByPatclAddModify.jsp?function_id="+function_id+"&mode="+MODE_MODIFY+"&drug_catg_code="+drug_catg_code+"&patient_class="+patient_class;
	}
}

function formReset () {
	var obj=f_query_add_mod.document.frmDrugCategoryRulesByPatcl;
	obj.drug_catg_code.value="";
	obj.patient_class.value="*A";
	obj.max_durn_value.value="";
	obj.max_durn_type.value="D";
	obj.action_abbr.value="W";
	obj.ord_auth_level.value="";
	obj.prompt_msg.value="";
	obj.drug_catg_code.focus();
}
function Modify(obj) {

	var drug_catg_code=obj.cells[0].innerText;
	var patient_class=obj.cells[2].innerText;
	if (patient_class=="*All")
	{
		patient_class="*A";
	}
	document.location.href="../../ePH/jsp/DrugCategoryRuleByPatclAddModify.jsp?function_id="+function_id+"&mode="+MODE_MODIFY+"&drug_catg_code="+drug_catg_code+"&patient_class="+patient_class;	
}

function checkIsValidForProceed() {
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();

	if ( (url.indexOf("blank.html")==-1) && (url.indexOf("drugcategoryrulebypatclquery")==-1) )
		return true;
	else
		return false;
}
function callCheckMaxLen(obj,noOfChars,Legend)
{
	makeValidString(obj);
	if(trimCheck(obj.value)==""){
		parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";		
		return false;
	}
	if(obj.value.length > noOfChars) {
        parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=APP-SM0045 - " + Legend + " cannot exceed " + noOfChars  + " characters" ;
		obj.focus();
	}else{		
		parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp";
		return true;
	}
}

function CheckZero(obj)	{
	if(obj.value==0)	{
		alert(getMessage("PH_VALUE_SHOULD_BE_GR_ZERO","PH"));
		obj.value = ""; // Edge Issue
		//obj.select();
		//obj.focus();
	}
}

function checkPHParamValue(obj){
	var formObj =document.frmDrugCategoryRulesByPatcl;
	var max_durn_for_op_pres = formObj.max_durn_for_op_pres.value;
	var max_durn_for_ip_pres = formObj.max_durn_for_ip_pres.value;
	if (formObj.patient_class.value=="IP" || formObj.patient_class.value=="DC" ){
		if (parseFloat(max_durn_for_ip_pres) < parseFloat(obj.value)){
			parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage("PH_MAX_DISP_DURN_PARAM","PH");
			obj.value="";//Edge issue for focus
			obj.focus();
		}else{
			parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		}
	}else{
		if (parseFloat(max_durn_for_op_pres) < parseFloat(obj.value)){
			parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num="+getMessage("PH_MAX_DISP_DURN_PARAM","PH");
			obj.value="";//Edge issue for focus
			obj.focus();
		}else{
			parent.messageFrame.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
		}
	}	
}