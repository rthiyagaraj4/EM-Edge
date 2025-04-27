  
var function_id = "" ;
var result = false ;
var message = "" ;
var flag = "" ;

var GLschedule_id				   = "" ; 

/*
var GLschedule_desc				   = "" ; 
var GLorder_auth_reqd_yn		   = "" ;
var GLorder_auth_level			   = "" ; 
var GLorder_cosign_reqd_yn		   = "" ;
var GLorder_cosign_level           = "" ; 
var GLspl_appr_reqd_yn             = "" ;
var GLspl_appr_level               = "" ; 
var GLrepeat_single_cont_order_yn  = "" ;
var GLdisp_auth_reqd_yn            = "" ;
var GLeff_status				   = "" ;
*/



function create() {
	//alert("here in js");
	f_query_add_mod.location.href="../../ePH/jsp/DrugScheduleAddModify.jsp?mode="+MODE_INSERT; //&atc_class_l1_code=B&atc_class_l2_code=B01&atc_class_l3_code=ER" ;
}

function query() {
	f_query_add_mod.location.href="../../ePH/jsp/DrugScheduleQueryCriteria.jsp" ;
}


/***************************apply()****************************************************/

function apply()
{

	if(!checkIsValidForProceed())
	{
		messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num=";
		return false;
	}

var mode = f_query_add_mod.document.formDrugSchedule.mode.value;
//alert("mode"+mode);

//////////////////////////////////////////////////////////////////////////////
if( mode == MODE_INSERT ) 
{

	var formObj = f_query_add_mod.document.formDrugSchedule ;
	//alert("order"+formObj.order_auth_reqd_yn.value);
	
var fields = new Array (formObj.schedule_id,formObj.schedule_desc);
var names = new Array (getLabel("Common.identification.label","Common"), getLabel("Common.description.label","Common"));

if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) 
{
	eval( formApply( formObj,PH_CONTROLLER ) ) ;
	messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
	if( result ) {
		onSuccess();
	}
	
}

}//if insert mode ends
////////////////////////////////////////////////////////////////////////////////////////
if( mode == MODE_MODIFY ) 
{
		var frmobj = f_query_add_mod.document.formDrugSchedule;

//alert("in apply before global setting");
var formObj = f_query_add_mod.document.formDrugSchedule ;
	
	
var fields = new Array (formObj.schedule_id,formObj.schedule_desc);
var names = new Array (  getLabel("Common.identification.label","Common"), getLabel("Common.description.label","Common"));
if(f_query_add_mod.checkFieldsofMst( fields, names, messageFrame)) {
	//alert("if condition")
GLschedule_id		=  f_query_add_mod.document.formDrugSchedule.schedule_id.value;
	//alert("if condition--->"+GLschedule_id)
	//alert("if  f_query_add_mod.document.formDrugSchedule--->"+ f_query_add_mod.document.formDrugSchedule)

eval( formApply( f_query_add_mod.document.formDrugSchedule,PH_CONTROLLER ) ) ;

messageFrame.location.href = "../../eCommon/jsp/MstCodeError.jsp?err_num="+ message;
if( result )
{
onSuccess();
}

}// if checkFieldsofMst()


}//modify if ends
///////////////////////////////////////////////////////////////////////////////////

}//apply ends

/***************************************************************************************/

function assignResult( _result, _message, _flag ) {

	//alert("if result--->"+result)

	result = _result ;
	message  = _message ;
	flag = _flag ;
}
///////////////////////////////////////////////////////////////////////////////////
function reset() {
	if(f_query_add_mod.document.formDrugSchedule.mode.value == MODE_INSERT){
	
	f_query_add_mod.document.formDrugSchedule.reset();
	//formReset() ;
	}
	else{
	f_query_add_mod.document.formDrugSchedule.reset();
	}
}
///////////////////////////////////////////////////////////////////////////////////
function onSuccess() 
{
	var mode = f_query_add_mod.document.formDrugSchedule.mode.value;
	if( mode == MODE_INSERT ) {
		f_query_add_mod.document.formDrugSchedule.reset();
		f_query_add_mod.document.formDrugSchedule.schedule_id.focus() ;
		//formReset();
	}

	else if(mode == MODE_MODIFY )
	{
	//	alert("IN onsucess modify");
	f_query_add_mod.location.href="../../ePH/jsp/DrugScheduleAddModify.jsp?mode="+MODE_MODIFY+"&schedule_id="+GLschedule_id;
	}

}
/*******************  formReset()  ***********************************************/
function errorDisplay () {
	alert( getMessage( "INVALID_ATC_L1_CODE" ) ) ;
	document.formATCL3.atc_class_l1_code.select() ; 
	document.formATCL3.atc_class_l1_code.focus() ; 
}


function toUpper(obj) {
	obj.value=obj.value.toUpperCase();
}


/***********************  modify()  ************************************/

function Modify(obj){

	var schedule_id=obj.cells[0].innerText;
	

document.location.href="../../ePH/jsp/DrugScheduleAddModify.jsp?mode="+MODE_MODIFY
+"&schedule_id="+schedule_id;
	
	
}

/*********************   reset()  *************************************************/

function reset()
	{

	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();

	if ( (url.indexOf("drugschedulequerycriteria")!=-1) ) {
		f_query_add_mod.document.query_form.reset();
	}

	else if ( (url.indexOf("drugscheduleaddmodify")!=-1) ) {
		if(f_query_add_mod.document.formDrugSchedule.mode.value == MODE_INSERT){
			f_query_add_mod.document.formDrugSchedule.reset();
			//formReset() ;
		}
		else {
			f_query_add_mod.document.formDrugSchedule.reset();
		}
	}
}
/**************************  enableLevel()  ****************************************/
function enableLevel(obj)
{
	
/*	var formObj = document.formDrugSchedule;
	
	for(var i=2 ; i<=5 ; i=i+2)
	{
	if(formObj.elements[i].checked == true)
	{	
		//alert(formObj.elements[i].checked)
		formObj.elements[i+1].disabled = false;
		formObj.elements[i+1].focus();
	}
	else
	{
		formObj.elements[i+1].value = "";
		formObj.elements[i+1].disabled = true;
		
	}

	}*/
}

/********************************************************************************/
//In case of pressing Apply button from QueryCriteria page..the 'mode' would come null
//this is to avoid that 

function checkIsValidForProceed() {
	var url = f_query_add_mod.location.href;
	url = url.toLowerCase();
	if ( (url.indexOf("blank.html")==-1) && (url.indexOf("drugschedulequery")==-1) )
		return true;
	else
		return false;
}
////////////////////////////////////////////////////////////////////////////////////
//function not to check for special char's onBlur in AddModify////////////////////////////

function DrugScheduleCheck(obj){
	if(!CheckChars(obj))
	{
		alert(getMessage("SPECIAL_CHARCTERS_NOT_ALLOWED","PH"));
		obj.focus();
		return false;
	}
}